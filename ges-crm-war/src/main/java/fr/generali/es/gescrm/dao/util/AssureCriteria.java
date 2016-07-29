package fr.generali.es.gescrm.dao.util;


import java.util.ArrayList;
import java.util.List;

/**
 * This class allows to link the code from the controller to
 * the existing CRM code to generate the request
 */
public class AssureCriteria implements ICriteriaManager {
    public Long szIdentifiant = 0l;
    public Long szIdentifiantCreelia = 0l;
    public java.lang.String szNom = "";
    public java.lang.String szPrenom = "";
    public java.lang.String szINSEE = "";
    public java.lang.String szAgent = "";

    @Override
    public String generateWhere() {
        java.lang.String szIdentifiant = this.szIdentifiant.toString();
        java.lang.String szIdentifiantCreelia = this.szIdentifiantCreelia.toString();
        java.lang.String szNom = this.szNom;
        java.lang.String szPrenom = this.szPrenom;
        java.lang.String szINSEE = this.szINSEE;
        java.lang.String szAgent = this.szAgent;
        java.lang.String szFiltre = "";
        java.lang.String szSQL;

        // INPUT pretreatment
        if (!(szNom == null)) {
            szNom = szNom.trim().replace("_", "\\_").replace("*", "%").replace("?", "_").toUpperCase();
        }
        if (!(szPrenom == null)) {
            szPrenom = szPrenom.trim().replace("_", "\\_").replace("*", "%").replace("?", "_").toUpperCase();
        }
        if (!(szINSEE == null)) {
            szINSEE = szINSEE.trim().replace("_", "\\_").replace("*", "%").replace("?", "_").toUpperCase();
        }

        szSQL = "SELECT DISTINCT " +
                "  util.ID_UTIL, " +
                "  CIVI_LIBELLE, " +
                "  UTIL_NOM, " +
                "  UTIL_PRENOM,   " +
                "  UTIL_LIEU_NAIS," +
                "  regi.libelle as regime," +
                "  situ.situ_libelle as situation, " +
                "  res.rese_nom_long, " +
                "  res.ID_RESEAU_DISTRIB, " +
                "  NVL(ent.entr_nom,' ') AS entr_nom, " +
                "  prod.prod_abrev ||nvl2(NVL(cc.CENT_DATE_FIN,cont.CIND_FERME_CONTRAT),' (fermé)','') AS " +
                "  prod_abrev, " +
                "  cind_cod_postal, " +
                "  cind_ville, " +
                "  UTIL_IDENTIFIANT, " +
                "  ( " +
                "    SELECT " +
                "      TO_CHAR(sigl_avoir_tot,'99,999,990.99') " +
                "    FROM " +
                "      CIND_SITUATION_GBL sit " +
                "    WHERE " +
                "      cont.id_contrat = sit.id_contrat " +
                "  ) AS sigl_avoir_tot, " +
                "  tdagent.AGT_CD " +
                " FROM " +
                "  GC_UTIL util, " +
                "  GC_CIVILITE civ,     " +
                "  GC_REGIME regi," +
                "  GC_SITUATION situ," +
                "  IND_CONTRAT cont, " +
                "  RESEAU_DISTRIB res, " +
                "  PROD_PRODUIT prod, " +
                "  ENT_CONTRAT_COLLECTIF cc, " +
                "  ENT_ENTREPRISE ent, " +
                "  CC_CONTRAT_AGENT contrat_agent, " +
                "  TD_AGENT tdagent " +
                "WHERE " +
                "  util.id_civilite       =civ.id_civilite " +
                "AND util.id_util         =cont.id_util " +
                "AND res.id_reseau_distrib=cont.id_reseau_distrib " +
                "AND cont.id_produit      =prod.id_produit  " +
                "AND cont.id_contrat_ent = cc.id_contrat_ent(+) " +
                "AND tdagent.AGT_ID(+) = contrat_agent.AGT_ID  " +
                "AND cont.id_contrat = contrat_agent.ID_CONTRAT(+) " +
                "AND ent.id_entreprise(+) = cc.id_entreprise " +
                "AND regi.id_regime(+)  = util.id_regime        " +
                "AND situ.id_situation(+)  = util.id_situation ";

//        if (!"".equals(szAgent)) {
//            szSQL += "  tdagent.AGT_ID = contrat_agent.AGT_ID AND" +
//                    "  cont.id_contrat = contrat_agent.ID_CONTRAT AND" +
//                    "  tdagent.AGT_CD = '" + szAgent + "'";
//        } else {
//            szSQL += "  tdagent.AGT_ID(+) = contrat_agent.AGT_ID AND" +
//                    "  cont.id_contrat = contrat_agent.ID_CONTRAT(+)";
//        }

//            if (this._mdiParent.User.TypeReseau !=0)
//            {
//                szSQL+=" AND res.id_reseau_distrib in ("+this._mdiParent.User.ListeReseaux+")";
//            }

        List<String> filtres = new ArrayList<String>();

        if (!"0".equals(szIdentifiant)) {
            if (szIdentifiant.contains("%")) {
                filtres.add(" UPPER(util.id_util) like '" + szIdentifiant + "' ");
            } else {
                filtres.add(" UPPER(util.id_util) = '" + szIdentifiant + "' ");
            }
        }
        if (!"0".equals(szIdentifiantCreelia)) {
            if (szIdentifiantCreelia.contains("%")) {
                filtres.add(" UPPER(util.util_identifiant) like '" + szIdentifiantCreelia + "' ");
            } else {
                filtres.add(" UPPER(util.util_identifiant) = '" + szIdentifiantCreelia + "' ");
            }
        }
        if (!"".equals(szNom)) {
            if (szNom.contains("%")) {
                filtres.add(" UPPER(util.util_nom) like '" + szNom.replace("'", "''") + "' ");
            } else {
                filtres.add(" UPPER(util.util_nom) = '" + szNom.replace("'", "''") + "' ");
            }
        }
        if (!"".equals(szPrenom)) {
            if (szPrenom.contains("%")) {
                filtres.add(" UPPER(util.util_prenom) like '" + szPrenom.replace("'", "''") + "' ");
            } else {
                filtres.add(" UPPER(util.util_prenom) = '" + szPrenom.replace("'", "''") + "' ");
            }
        }
        if (!"".equals(szINSEE)) {
            if (szINSEE.contains("%")) {
                filtres.add(" UPPER(util.util_insee) like '" + szINSEE.replace("'", "''") + "' ");
            } else {
                filtres.add(" UPPER(util.util_insee) = '" + szINSEE.replace("'", "''") + "' ");
            }
        }

        for (int i = 0; i < filtres.size(); i++) {
            szSQL += " AND " + filtres.get(i);
        }

        szSQL += " ORDER BY ID_UTIL";
        return szSQL;
    }

    public boolean isEmpty() {
        if (szNom != null && !szNom.equals("")) {
            return false;
        }
        if (szPrenom != null && !szPrenom.equals("")) {
            return false;
        }
        if (szINSEE != null && !szINSEE.equals("")) {
            return false;
        }
        if (szAgent != null && !szAgent.equals("")) {
            return false;
        }
        if (szIdentifiant != null && !(szIdentifiant == 0L)) {
            return false;
        }
        if (szIdentifiantCreelia != null && !(szIdentifiantCreelia == 0L)) {
            return false;
        }
        return true;
    }
}
