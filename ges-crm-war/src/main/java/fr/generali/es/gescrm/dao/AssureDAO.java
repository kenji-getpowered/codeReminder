package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.AssureCriteria;
import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.dao.util.CriteriaManager;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <Assure> Basic object
 * @param <String> Identifier
 * @date 26/04/2016
 */
@Repository
public class AssureDAO<Assure, String> extends BasicDAO implements DAO {

    private static final java.lang.String SQL_ASSURE_LIST = "SELECT                                                                                                                  " +
            "  GC_UTIL.ID_UTIL,                                                                                                         " +
            "  UTIL_IDENTIFIANT,                                                                                                     " +
            "  id_civilite,                                                                                                          " +
            "  UTIL_NOM,                                                                                                             " +
            "  UTIL_PRENOM,                                                                                                          " +
            "  res.rese_nom_long,                                                                                                    " +
            "  res.ID_RESEAU_DISTRIB,                                                                                                " +
            "  NVL(ent.entr_nom,' ') AS entr_nom,                                                                                    " +
            "  prod.prod_abrev                                                                                                       " +
            "  ||nvl2(NVL(cc.CENT_DATE_FIN,cont.CIND_FERME_CONTRAT),' (fermé)','') AS                                                " +
            "  prod_abrev,                                                                                                           " +
            "  cind_cod_postal,                                                                                                      " +
            "  cind_ville,                                                                                                           " +
            "  (                                                                                                                     " +
            "    SELECT                                                                                                              " +
            "      TO_CHAR(sigl_avoir_tot,'99,999,990.99')                                                                           " +
            "    FROM                                                                                                                " +
            "      CIND_SITUATION_GBL sit                                                                                            " +
            "    WHERE                                                                                                               " +
            "      cont.id_contrat = sit.id_contrat                                                                                  " +
            "  )                                                                                                                     " +
            "  sigl_avoir_tot,                                                                                                       " +
            " tda.AGT_CD                                                                                                             " +
            "FROM                                                                                                                    " +
            "  GC_UTIL                                                                                                          " +
            "  left join   IND_CONTRAT cont on GC_UTIL.id_util = cont.id_util                                                           " +
            "  left join   RESEAU_DISTRIB res on res.id_reseau_distrib = cont.id_reseau_distrib                                      " +
            "  join PROD_PRODUIT prod on cont.id_produit = prod.id_produit                                                           " +
            "  join ENT_CONTRAT_COLLECTIF cc on cont.id_contrat_ent  = cc.id_contrat_ent                                             " +
            "  join ENT_ENTREPRISE ent on ent.ID_ENTREPRISE = cc.ID_ENTREPRISE                                                       " +
            "  join CC_CONTRAT_AGENT contrat_agent on cont.ID_CONTRAT_ENT = contrat_agent.ID_CONTRAT                                 " +
            "  join td_agent  tda   on tda.AGT_ID = contrat_agent.AGT_ID                                                             ";

    private static final  java.lang.String SQL_ASSURE_RESET_MDP = "UPDATE   GC_UTIL\n" +
            "  SET   UTIL_LOG_PASSWORD = '13572214931341929235208222871982131726131',\n" +
            "        UTIL_LOG_PWD_CL = 'nova0001',\n" +
            "        UTIL_ETAT = S_ETAT_UTIL,\n" +
            "        UTIL_DTMAJ = SYSDATE,\n" +
            "        UTIL_USMAJ = 'RESET'\n" +
            "WHERE   ID_UTIL = P_ID_UTIL";

    @Override
    public List<Assure> get() {
        Query query = this.getSession().createSQLQuery(SQL_ASSURE_LIST).addEntity(fr.generali.es.gescrm.bean.Assure.class);
        List<Assure> list = query.list();
        return list;
    }

    @Override
    public Assure get(Object id) {
        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        criterias.add(new CriteriaField("GC_UTIL", "id_util", id.toString()));
        AssureCriteria criteriaManager = new AssureCriteria();
        criteriaManager.szIdentifiant = Long.valueOf(id.toString());
        final List<Assure> search = this.search(criteriaManager);
        Assure result = null;
        if(search != null){
            if(search.size()>1){
                //throw new Exception("");
            }
            result = search.get(0);
        }
        return result;
    }

    public void resetPassword(Long id) {
        Query query = this.getSession().createSQLQuery(SQL_ASSURE_RESET_MDP).setString(new Integer(0), id.toString());
        query.executeUpdate();
    }

    @Override
    public List<Assure> search(ICriteriaManager criterias) {
        java.lang.String zeQuery = criterias.generateWhere();
        Query query = this.getSession().createSQLQuery(zeQuery).addEntity(fr.generali.es.gescrm.bean.Assure.class);
        List<Assure> list = query.list();
        return list;
    }


}