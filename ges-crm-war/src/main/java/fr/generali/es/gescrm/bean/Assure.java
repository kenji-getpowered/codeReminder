package fr.generali.es.gescrm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * POJO d'affichage
 */
@Entity
public class Assure implements Serializable {

    private static final long serialVersionUID = 1L;
    //    util.ID_UTIL,
//    CIVI_LIBELLE,
//    UTIL_NOM,
//    UTIL_PRENOM,
//    res.rese_nom_long,
//    res.ID_RESEAU_DISTRIB,
//    NVL(ent.entr_nom,' ') AS entr_nom,
//    prod.prod_abrev  ||nvl2(NVL(cc.CENT_DATE_FIN,cont.CIND_FERME_CONTRAT), ' (fermé)','') AS
//            prod_abrev,
//            cind_cod_postal,
//            cind_ville,
//            UTIL_IDENTIFIANT,
//    (
//    SELECT
//    TO_CHAR(sigl_avoir_tot,'99,999,990.99')
//    FROM
//    CIND_SITUATION_GBL sit
//    WHERE
//    cont.id_contrat = sit.id_contrat
//    ) AS sigl_avoir_tot,
//    tdagent.AGT_CD
    @Id
    @Column(name = "ID_UTIL")
    private Long identifiant;
    @Column(name = "CIVI_LIBELLE")
    private String idCivilite;
    @Column(name = "UTIL_NOM")
    private String nom;
    @Column(name = "UTIL_PRENOM")
    private String prenom;
    @Column(name = "rese_nom_long")
    private String reseau;
    @Column(name = "ID_RESEAU_DISTRIB")
    private String idReseau;
    @Column(name = "entr_nom")
    private String nomEntrepise;
    @Column(name = "prod_abrev")
    private String prod_abrev;
    @Column(name = "cind_cod_postal")
    private String cindCodePostal;
    @Column(name = "cind_ville")
    private String cindVille;
    @Column(name = "sigl_avoir_tot")
    private String montantTotalAvoirs;
    @Column(name = "AGT_CD")
    private String codeAgent;
    @Column(name = "UTIL_IDENTIFIANT")
    private Long identifiantCreelia;
    @Column(name = "regime")
    private String regime;
    @Column(name = "UTIL_LIEU_NAIS")
    private String lieuNaissance;
    @Column(name = "situation")
    private String statutFamilial;


    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getStatutFamilial() {
        return statutFamilial;
    }

    public void setStatutFamilial(String statutFamilial) {
        this.statutFamilial = statutFamilial;
    }

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public Long getIdentifiantCreelia() {
        return identifiantCreelia;
    }

    public void setIdentifiantCreelia(Long identifiantCreelia) {
        this.identifiantCreelia = identifiantCreelia;
    }

    public String getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(String idCivilite) {
        this.idCivilite = idCivilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getReseau() {
        return reseau;
    }

    public void setReseau(String reseau) {
        this.reseau = reseau;
    }

    public String getIdReseau() {
        return idReseau;
    }

    public void setIdReseau(String idReseau) {
        this.idReseau = idReseau;
    }

    public String getNomEntrepise() {
        return nomEntrepise;
    }

    public void setNomEntrepise(String nomEntrepise) {
        this.nomEntrepise = nomEntrepise;
    }

    public String getProd_abrev() {
        return prod_abrev;
    }

    public void setProd_abrev(String prod_abrev) {
        this.prod_abrev = prod_abrev;
    }

    public String getCindCodePostal() {
        return cindCodePostal;
    }

    public void setCindCodePostal(String cindCodePostal) {
        this.cindCodePostal = cindCodePostal;
    }

    public String getCindVille() {
        return cindVille;
    }

    public void setCindVille(String cindVille) {
        this.cindVille = cindVille;
    }

    public String getMontantTotalAvoirs() {
        return montantTotalAvoirs;
    }

    public void setMontantTotalAvoirs(String montantTotalAvoirs) {
        this.montantTotalAvoirs = montantTotalAvoirs;
    }

    public String getCodeAgent() {
        return codeAgent;
    }

    public void setCodeAgent(String codeAgent) {
        this.codeAgent = codeAgent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assure assure = (Assure) o;

        if (cindCodePostal != null ? !cindCodePostal.equals(assure.cindCodePostal) : assure.cindCodePostal != null)
            return false;
        if (cindVille != null ? !cindVille.equals(assure.cindVille) : assure.cindVille != null) return false;
        if (codeAgent != null ? !codeAgent.equals(assure.codeAgent) : assure.codeAgent != null) return false;
        if (idCivilite != null ? !idCivilite.equals(assure.idCivilite) : assure.idCivilite != null) return false;
        if (idReseau != null ? !idReseau.equals(assure.idReseau) : assure.idReseau != null) return false;
        if (identifiant != null ? !identifiant.equals(assure.identifiant) : assure.identifiant != null) return false;
        if (identifiantCreelia != null ? !identifiantCreelia.equals(assure.identifiantCreelia) : assure.identifiantCreelia != null)
            return false;
        if (lieuNaissance != null ? !lieuNaissance.equals(assure.lieuNaissance) : assure.lieuNaissance != null)
            return false;
        if (montantTotalAvoirs != null ? !montantTotalAvoirs.equals(assure.montantTotalAvoirs) : assure.montantTotalAvoirs != null)
            return false;
        if (nom != null ? !nom.equals(assure.nom) : assure.nom != null) return false;
        if (nomEntrepise != null ? !nomEntrepise.equals(assure.nomEntrepise) : assure.nomEntrepise != null)
            return false;
        if (prenom != null ? !prenom.equals(assure.prenom) : assure.prenom != null) return false;
        if (prod_abrev != null ? !prod_abrev.equals(assure.prod_abrev) : assure.prod_abrev != null) return false;
        if (regime != null ? !regime.equals(assure.regime) : assure.regime != null) return false;
        if (reseau != null ? !reseau.equals(assure.reseau) : assure.reseau != null) return false;
        if (statutFamilial != null ? !statutFamilial.equals(assure.statutFamilial) : assure.statutFamilial != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifiant != null ? identifiant.hashCode() : 0;
        result = 31 * result + (idCivilite != null ? idCivilite.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (reseau != null ? reseau.hashCode() : 0);
        result = 31 * result + (idReseau != null ? idReseau.hashCode() : 0);
        result = 31 * result + (nomEntrepise != null ? nomEntrepise.hashCode() : 0);
        result = 31 * result + (prod_abrev != null ? prod_abrev.hashCode() : 0);
        result = 31 * result + (cindCodePostal != null ? cindCodePostal.hashCode() : 0);
        result = 31 * result + (cindVille != null ? cindVille.hashCode() : 0);
        result = 31 * result + (montantTotalAvoirs != null ? montantTotalAvoirs.hashCode() : 0);
        result = 31 * result + (codeAgent != null ? codeAgent.hashCode() : 0);
        result = 31 * result + (identifiantCreelia != null ? identifiantCreelia.hashCode() : 0);
        result = 31 * result + (regime != null ? regime.hashCode() : 0);
        result = 31 * result + (lieuNaissance != null ? lieuNaissance.hashCode() : 0);
        result = 31 * result + (statutFamilial != null ? statutFamilial.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Assure{" +
                "identifiant=" + identifiant +
                ", idCivilite='" + idCivilite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", reseau='" + reseau + '\'' +
                ", idReseau='" + idReseau + '\'' +
                ", nomEntrepise='" + nomEntrepise + '\'' +
                ", prod_abrev='" + prod_abrev + '\'' +
                ", cindCodePostal='" + cindCodePostal + '\'' +
                ", cindVille='" + cindVille + '\'' +
                ", montantTotalAvoirs='" + montantTotalAvoirs + '\'' +
                ", codeAgent='" + codeAgent + '\'' +
                ", identifiantCreelia=" + identifiantCreelia +
                ", regime='" + regime + '\'' +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", statutFamilial='" + statutFamilial + '\'' +
                '}';
    }
}
