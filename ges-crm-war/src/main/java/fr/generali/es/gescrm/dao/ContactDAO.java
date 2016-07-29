package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.CriteriaManager;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <Contact> Basic object
 * @param <String> Identifier
 * @date 26/04/2016
 */
@Repository
public class ContactDAO<Contact, String> extends BasicDAO implements DAO {


    private class DateTriComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if(o1 != null && o2 != null
                    && o1 instanceof fr.generali.es.gescrm.bean.Contact
                    && o2 instanceof fr.generali.es.gescrm.bean.Contact){
                fr.generali.es.gescrm.bean.Contact c1 = (fr.generali.es.gescrm.bean.Contact) o1;
                fr.generali.es.gescrm.bean.Contact c2 = (fr.generali.es.gescrm.bean.Contact) o2;
                if(c1.getDateTri() != null && c2.getDateTri() != null){
                    return c1.getDateTri().compareTo(c2.getDateTri());
                }
                return 0;
            }
            return 0;
        }
    }

    private static final java.lang.String SQL_TACHES_BY_ID = "    SELECT" +
            "      TACH_DATE_ECHEANCE                                  AS Date_tri," +
            "      a.ID_Tache                                          AS Id," +
            "      TYDO_LIBELLE                                        AS Dossier," +
            "      'Tâche'                                             AS Action," +
            "      0                                                   AS IDAction," +
            "      TACH_CANAL                                          AS Type," +
            "      TACH_CANAL                                          AS LibType," +
            "      ''                                                  AS motif," +
            "      ''                                                  AS Sens," +
            "      TACH_COMMENTAIRE                                    AS commentaire," +
            "      d.AGT_CD                                            AS Agent_Initiateur," +
            "      TO_CHAR(TACH_DATE_CREATION,'DD/MM/YYYY hh24:mi:ss') AS Date_creation," +
            "      e.AGT_CD                                            AS Agent_affecte," +
            "      TO_CHAR(TACH_DATE_ECHEANCE,'DD/MM/YYYY')            AS Date_echeance," +
            "      TACH_ETAT                                           AS Statut," +
            "      c.id_type_Dossier                                   AS IdTypeDossier" +
            "    FROM" +
            "      CC_TACHE a " +
            "      join CC_TYPE_DOSSIER c  on  a.ID_TYPE_DOSSIER=c.ID_TYPE_DOSSIER" +
            "      join TD_AGENT d         on  d.AGT_ID=a.AGT_ID" +
            "      join TD_AGENT e         on e.AGT_ID=a.AGT_ID_AFF" +
            "      join CC_TACHE_REF f     on  a.TACH_OBJET=f.ID_TACHE_REF";
    private static final java.lang.String SQL_CONTACTS_BY_ID = "    SELECT" +
            "      CONT_DATE                                            AS Date_tri," +
            "      a.ID_CONTACT                                         AS Id," +
            "      TYDO_LIBELLE                                         AS Dossier," +
            "      DECODE(d.ACT_TYPE_CONTACT,1,'Contact','Application') AS Action," +
            "      d.ACT_TYPE_CONTACT                                   AS IDAction," +
            "      CONT_CANAL                                           AS Type," +
            "      LIBEL_TYPE_CONTACT                                   AS LibType," +
          //  "      -- DECODE(CONT_SENS,'E','Entrant','Sortant') as Sens," +
            "      g.LIBEL_TYPE_MOTIF                         AS motif," +
            "      CONT_SENS                                  AS Sens," +
            "      CONT_COMMENTAIRE                           AS commentaire," +
            "      AGT_CD                                     AS Agent_Initiateur," +
            "      TO_CHAR(CONT_DATE,'DD/MM/YYYY hh24:mi:ss') AS Date_creation," +
            "      ''                                         AS Agent_affecte," +
            "      NULL                                       AS Date_echeance," +
            "      ''                                         AS Statut," +
            "      b.id_type_Dossier                          AS IdTypeDossier" +
            "    FROM" +
            "      CC_CONTACT a" +
            "      join CC_TYPE_DOSSIER b on  a.ID_TYPE_DOSSIER  =b.ID_TYPE_DOSSIER" +
            "      join TD_AGENT c on  c.AGT_ID           =a.AGT_ID" +
            "      join CC_TYPE_CONTACT_REF d on a.CONT_CANAL         =d.CODE_TYPE_CONTACT" +
            "      LEFT join CC_TYPE_MOTIF_REF g on g.CODE_TYPE_MOTIF =a.CODE_TYPE_MOTIF";


    @Override
    public List<Contact> search(ICriteriaManager criteriaManager) {
        java.lang.String zeQuery =
                SQL_CONTACTS_BY_ID;
        zeQuery += criteriaManager.generateWhere();
        Query query = this.getSession().createSQLQuery(zeQuery).addEntity(fr.generali.es.gescrm.bean.Contact.class);
        List<Contact> listContacts = query.list();

        zeQuery = SQL_TACHES_BY_ID;
        zeQuery += criteriaManager.generateWhere();
        Query queryTache = this.getSession().createSQLQuery(zeQuery).addEntity(fr.generali.es.gescrm.bean.Contact.class);
        List<Contact> listTache =  queryTache.list();
        if(listTache != null){
            listContacts.addAll(listTache);
        }
        Collections.sort(listContacts, new DateTriComparator());
        return listContacts;
    }
}