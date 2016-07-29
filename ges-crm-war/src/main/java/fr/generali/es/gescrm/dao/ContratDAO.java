package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.CriteriaManager;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <Contrat> Basic object
 * @param <String> Identifier
 * @date 26/04/2016
 */
@Repository
public class ContratDAO<Contrat, String> extends BasicDAO implements DAO {

    private static final java.lang.String SQL_FIN_CONTRAT_BY_SIREN = "UPDATE\n" +
            " \"UEPSNOVP0\".\"ENT_CONTRAT_COLLECTIF\" SET CENT_DATE_FIN =\n" +
            "TO_DATE('1983-10-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS') \n" +
            "WHERE  \n" +
            "id_entreprise = (select id_entreprise from ENT_ENTREPRISE ee WHERE replace(ee.ENTR_SIREN, ' ', '') = replace('?', ' ', ''))\n" +
            "AND CENT_DATE_FIN is NULL";

    private static final java.lang.String SQL_FIN_CONTRAT_BY_SIREN_RESET = "UPDATE\n" +
            " \"UEPSNOVP0\".\"ENT_CONTRAT_COLLECTIF\" SET CENT_DATE_FIN = NULL\n" +
            "WHERE  \n" +
            "id_entreprise = (select id_entreprise from ENT_ENTREPRISE ee WHERE replace(ee.ENTR_SIREN, ' ', '') = replace('?, ' ', ''))\n" +
            "AND CENT_DATE_FIN = TO_DATE('1983-10-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS')";


    private static final java.lang.String SQL_CONTRAT =
            "SELECT"+
                    "  cont.id_contrat,"+
                    "  prod.prod_abrev,"+
                    "  prod.PROD_CLASSE,"+
                    "  prod.id_produit,"+
                    "  ent.ENTR_NOM,"+
                    "  ent.ENTR_CODE,"+
                    "  cc.CENT_NUM_CONTRAT,"+
                    "  NVL(sit.sigl_avoir_tot,0) AS sigl_avoir_tot,"+
                    "  cont.id_contrat_ent,"+
                    "  cont.cind_insee,"+
                    "  cont.cind_numero,"+
                    "  cont.cind_matricule,"+
                    "  cont.cind_profession,"+
                    "  cont.cind_npai,"+
                    "  cont.id_csp,"+
                    "  csp.csp_libelle,"+
                    "  cont.cind_ouver_contrat,"+
                    "  nvl2(cont.id_contrat_ent,cc.cent_date_fin,cont.cind_ferme_contrat)"+
                    "  cind_ferme_contrat ,"+
                    "  cont.cind_depart_ent,"+
                    "  cont.cind_entre_ent,"+
                    "  cont.cind_dep_retraite,"+
                    "  cont.cind_adr1,"+
                    "  cont.cind_adr2,"+
                    "  cont.cind_adr3,"+
                    "  cont.cind_cod_postal,"+
                    "  cont.cind_ville,"+
                    "  cont.cind_pays,"+
                    "  cont.cind_usmaj,"+
                    "  cont.cind_dtmaj,"+
                    "  cont.id_reseau_distrib,"+
                    "  cont.id_contrat_ent,"+
                    "  cont.CIND_NON_ASSUJETI_TAXE,"+
                    "  cont.CIND_ARB_GRATUIT," +
                    "  res.rese_nom_long,"+
                    "  NVL(GC_UTIL.UTIL_AUTO_CROSSELING,0) AS UTIL_AUTO_CROSSELLING,"+
                    "  NVL(GC_UTIL.UTIL_AUTO_RELANCE,0)    AS UTIL_AUTO_RELANCE,"+
                    "  NVL(cc.CENT_AUTO_CROSSELLING,0)  AS CENT_AUTO_CROSSELLING,"+
                    "  NVL(cc.CENT_AUTO_RELANCE,0)      AS CENT_AUTO_RELANCE,"+
                    "  tdagent.AGT_ID,"+
                    "  tdagent.AGT_CD,"+
                    "  tdagent.AGT_PRENOM,"+
                    "  tdagent.AGT_NOM,"+
                    "  ent.ENTR_CODE_CREELIA,"+
                    "  cc.REF_CONTRAT_CREELIA"+
                    "  FROM IND_CONTRAT cont"+
                    "  join CIND_SITUATION_GBL sit on sit.id_contrat(+) = cont.id_contrat"+
                    "  join PROD_PRODUIT prod      on  prod.id_produit = cont.id_produit"+
                    "  join GC_UTIL           on cont.id_util = GC_UTIL.id_util"+
                    "  join ENT_CONTRAT_COLLECTIF cc on cont.id_contrat_ent = cc.id_contrat_ent"+
                    "  join ENT_ENTREPRISE ent     on ent.id_entreprise = cc.id_entreprise"+
                    "  join GC_CSP csp             on cont.id_csp = csp.id_csp" +
                    "  join RESEAU_DISTRIB res on res.id_reseau_distrib = cont.id_reseau_distrib"+
                    "  left outer join CC_CONTRAT_AGENT contrat_agent  on contrat_agent.ID_CONTRAT  = cont.id_contrat"+
                    "  left outer join TD_AGENT tdagent on contrat_agent.AGT_ID = tdagent.AGT_ID";

    @Override
    public List<Contrat> search(ICriteriaManager criteriaManager) {
        java.lang.String zeQuery =
                SQL_CONTRAT;
        zeQuery += criteriaManager.generateWhere();
//        zeQuery += " ORDER BY ID_UTIL";
        Query query = this.getSession().createSQLQuery(zeQuery).addEntity(fr.generali.es.gescrm.bean.Contrat.class);
        List<Contrat> list = query.list();
        return list;
    }
}