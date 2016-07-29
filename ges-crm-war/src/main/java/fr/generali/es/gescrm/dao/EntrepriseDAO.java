package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.dao.util.CriteriaManager;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <Entreprise> Basic object
 * @param <String>     Identifier
 * @date 26/04/2016
 */
@Repository
public class EntrepriseDAO<Entreprise, String> extends BasicDAO implements DAO {

    private static final java.lang.String SQL_ENTREPRISE_LIST = "SELECT   ent_entreprise.id_entreprise, entr_nom,  entr_siren,  cent_college_a83,  cent_num_contrat ,  cent_ref_externe FROM  ent_contrat_collectif join ent_entreprise on ent_contrat_collectif.id_entreprise = ent_entreprise.id_entreprise";

    /*
     * ID_PRODUIT must remains the same among the request
     */
    private static final java.lang.String SQL_ENTREPRISE_UPDATE_ABOND = "UPDATE\n" +
            "  CENT_ABONDEMENT\n" +
            "SET\n" +
            "  ABOND_TRANCHE_MAX  = (select ABOND_TRANCHE_MAX from CENT_ABONDEMENT_TAUX where  ABOND_ANNEE = 2016 and ID_PRODUIT = ?),\n" +
            "  ABOND_PLAFOND_VRST = (select ABOND_PLAFOND_VRST from CENT_ABONDEMENT_TAUX where ABOND_ANNEE = 2016 and ID_PRODUIT = ?),\n" +
            "  ABOND_PLAFOND_ABD  = (select ABOND_PLAFOND_ABD from CENT_ABONDEMENT_TAUX where  ABOND_ANNEE = 2016 and ID_PRODUIT = ?)\n" +
            "WHERE\n" +
            "  id_contrat_ent =\n" +
            "  (\n" +
            "    SELECT\n" +
            "      id_contrat_ent\n" +
            "    FROM\n" +
            "      ENT_CONTRAT_COLLECTIF\n" +
            "    WHERE\n" +
            "      id_entreprise =\n" +
            "      (\n" +
            "        SELECT\n" +
            "          ID_ENTREPRISE\n" +
            "        FROM\n" +
            "          ENT_ENTREPRISE\n" +
            "        WHERE\n" +
            "          ENTR_CODE_CREELIA = '?'\n" +
            "      )\n" +
            "    AND id_produit = ?\n" +
            "  )";



    @Override
    public List<Entreprise> get() {
        Query query = this.getSession().createSQLQuery(SQL_ENTREPRISE_LIST).addEntity(fr.generali.es.gescrm.bean.Entreprise.class);
        List<Entreprise> list = query.list();
        return list;
    }

    @Override
    public Entreprise get(Object id) {
        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        criterias.add(new CriteriaField("ent_entreprise", "id_entreprise", id.toString()));
        CriteriaManager  criteriaManager = new CriteriaManager(criterias);
        final List<Entreprise> search = this.search(criteriaManager);
        Entreprise result = null;
        if (search != null) {
            if (search.size() > 1) {
                //throw new Exception("");
            }
            result = search.get(0);
        }
        return result;
    }


    @Override
    public List<Entreprise> search(ICriteriaManager criteriaManager) {
        java.lang.String zeQuery =
                SQL_ENTREPRISE_LIST;
        zeQuery += criteriaManager.generateWhere();
        Query query = this.getSession().createSQLQuery(zeQuery).addEntity(fr.generali.es.gescrm.bean.Assure.class);
        List<Entreprise> list = query.list();
        return list;
    }

    public void updateAbondements(Long id, int annee) {
        // Ce service pourrait ^^être appelé depuis l'espace PRO. plus besoin de joindre Eric puis Nous

        // TODO
        // variabiliser l'année
        // boucle sur les projet
       // id doit etre l'id creelia
        Query query = this.getSession().createSQLQuery(SQL_ENTREPRISE_UPDATE_ABOND);
        query.setLong(0, 6);
        query.setLong(1, 6);
        query.setLong(2, 6);
        query.setLong(3, id);
        query.setLong(4, 6);
        query.executeUpdate();


        //
        query = this.getSession().createSQLQuery(SQL_ENTREPRISE_UPDATE_ABOND);
        query.setLong(0, 12);
        query.setLong(1, 12);
        query.setLong(2, 12);
        query.setLong(3, id);
        query.setLong(4, 12);
        query.executeUpdate();

    }
}

