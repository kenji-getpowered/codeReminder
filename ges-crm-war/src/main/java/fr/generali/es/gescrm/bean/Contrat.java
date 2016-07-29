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
public class Contrat  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_contrat") private String  idContrat;
    @Column(name="prod_abrev") private String  prodAbrev;
    @Column(name="PROD_CLASSE") private String  prodClasse;
    @Column(name="id_produit") private String  idProduit;
    @Column(name="ENTR_NOM") private String  entrNom;
    @Column(name="ENTR_CODE") private String  entrCode;
    @Column(name="CENT_NUM_CONTRAT") private String  centNumContrat;
    @Column(name="sigl_avoir_tot") private String  siglAvoirTot;
    @Column(name="id_contrat_ent") private String  idContratEnt;
    @Column(name="cind_insee") private String  cindInsee;
    @Column(name="cind_numero") private String  cindNumero;
    @Column(name="cind_matricule") private String  cindMatricule;
    @Column(name="cind_profession") private String  cindProfession;
    @Column(name="cind_npai") private String  cindNpai;
    @Column(name="id_csp") private String  idCsp;
    @Column(name="csp_libelle") private String  cspLibelle;
    @Column(name="cind_ouver_contrat") private String  cindOuverContrat;
    @Column(name="cind_ferme_contrat") private String  cindFermeContrat ;
    @Column(name="cind_depart_ent") private String  cindDepartEnt;
    @Column(name="cind_entre_ent") private String  cindEntreEnt;
    @Column(name="cind_dep_retraite") private String  cindDepRetraite;
    @Column(name="cind_adr1") private String  cindAdr1;
    @Column(name="cind_adr2") private String  cindAdr2;
    @Column(name="cind_adr3") private String  cindAdr3;
    @Column(name="cind_cod_postal")    private String  cindCodPostal;
    @Column(name="cind_ville") private String  cindVille;
    @Column(name="cind_pays") private String  cindPays;
//    @Column(name="cind_usmaj") private Date  cindUsmaj;
//    @Column(name="cind_dtmaj") private Date cindDtmaj;
    @Column(name="id_reseau_distrib") private String  idReseauDistrib;
    @Column(name="CIND_NON_ASSUJETI_TAXE") private String  cindNonAssujetiTaxe;
    @Column(name="CIND_ARB_GRATUIT") private String  cindArbGratuit;
    @Column(name="UTIL_AUTO_CROSSELLING") private String  utilAutoCrosselling;
    @Column(name="UTIL_AUTO_RELANCE") private String  utilAutoRelance;
    @Column(name="CENT_AUTO_CROSSELLING") private String  centAutoCrosselling;
    @Column(name="CENT_AUTO_RELANCE") private String  centAutoRelance;
    @Column(name="AGT_ID") private String  agtId;
    @Column(name="AGT_CD") private String  agtCd;
    @Column(name="AGT_PRENOM") private String  agtPrenom;
    @Column(name="AGT_NOM") private String  agtNom;
    @Column(name="ENTR_CODE_CREELIA") private String  entrCodeCreelia;
    @Column(name="REF_CONTRAT_CREELIA") private String  refContratCreelia;
    @Column(name="rese_nom_long") private String  nomReseau;

    public String getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(String idContrat) {
        this.idContrat = idContrat;
    }

    public String getProdAbrev() {
        return prodAbrev;
    }

    public void setProdAbrev(String prodAbrev) {
        this.prodAbrev = prodAbrev;
    }

    public String getProdClasse() {
        return prodClasse;
    }

    public void setProdClasse(String prodClasse) {
        this.prodClasse = prodClasse;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getEntrNom() {
        return entrNom;
    }

    public void setEntrNom(String entrNom) {
        this.entrNom = entrNom;
    }

    public String getEntrCode() {
        return entrCode;
    }

    public void setEntrCode(String entrCode) {
        this.entrCode = entrCode;
    }

    public String getCentNumContrat() {
        return centNumContrat;
    }

    public void setCentNumContrat(String centNumContrat) {
        this.centNumContrat = centNumContrat;
    }

    public String getSiglAvoirTot() {
        return siglAvoirTot;
    }

    public void setSiglAvoirTot(String siglAvoirTot) {
        this.siglAvoirTot = siglAvoirTot;
    }

    public String getIdContratEnt() {
        return idContratEnt;
    }

    public void setIdContratEnt(String idContratEnt) {
        this.idContratEnt = idContratEnt;
    }

    public String getCindInsee() {
        return cindInsee;
    }

    public void setCindInsee(String cindInsee) {
        this.cindInsee = cindInsee;
    }

    public String getCindNumero() {
        return cindNumero;
    }

    public void setCindNumero(String cindNumero) {
        this.cindNumero = cindNumero;
    }

    public String getCindMatricule() {
        return cindMatricule;
    }

    public void setCindMatricule(String cindMatricule) {
        this.cindMatricule = cindMatricule;
    }

    public String getCindProfession() {
        return cindProfession;
    }

    public void setCindProfession(String cindProfession) {
        this.cindProfession = cindProfession;
    }

    public String getCindNpai() {
        return cindNpai;
    }

    public void setCindNpai(String cindNpai) {
        this.cindNpai = cindNpai;
    }

    public String getIdCsp() {
        return idCsp;
    }

    public void setIdCsp(String idCsp) {
        this.idCsp = idCsp;
    }

    public String getCspLibelle() {
        return cspLibelle;
    }

    public void setCspLibelle(String cspLibelle) {
        this.cspLibelle = cspLibelle;
    }

    public String getCindOuverContrat() {
        return cindOuverContrat;
    }

    public void setCindOuverContrat(String cindOuverContrat) {
        this.cindOuverContrat = cindOuverContrat;
    }

    public String getCindFermeContrat() {
        return cindFermeContrat;
    }

    public void setCindFermeContrat(String cindFermeContrat) {
        this.cindFermeContrat = cindFermeContrat;
    }

    public String getCindDepartEnt() {
        return cindDepartEnt;
    }

    public void setCindDepartEnt(String cindDepartEnt) {
        this.cindDepartEnt = cindDepartEnt;
    }

    public String getCindEntreEnt() {
        return cindEntreEnt;
    }

    public void setCindEntreEnt(String cindEntreEnt) {
        this.cindEntreEnt = cindEntreEnt;
    }

    public String getCindDepRetraite() {
        return cindDepRetraite;
    }

    public void setCindDepRetraite(String cindDepRetraite) {
        this.cindDepRetraite = cindDepRetraite;
    }

    public String getCindAdr1() {
        return cindAdr1;
    }

    public void setCindAdr1(String cindAdr1) {
        this.cindAdr1 = cindAdr1;
    }

    public String getCindAdr2() {
        return cindAdr2;
    }

    public void setCindAdr2(String cindAdr2) {
        this.cindAdr2 = cindAdr2;
    }

    public String getCindAdr3() {
        return cindAdr3;
    }

    public void setCindAdr3(String cindAdr3) {
        this.cindAdr3 = cindAdr3;
    }

    public String getCindCodPostal() {
        return cindCodPostal;
    }

    public void setCindCodPostal(String cindCodPostal) {
        this.cindCodPostal = cindCodPostal;
    }

    public String getCindVille() {
        return cindVille;
    }

    public void setCindVille(String cindVille) {
        this.cindVille = cindVille;
    }

    public String getCindPays() {
        return cindPays;
    }

    public void setCindPays(String cindPays) {
        this.cindPays = cindPays;
    }

//    public String getCindUsmaj() {
//        return cindUsmaj;
//    }
//
//    public void setCindUsmaj(String cindUsmaj) {
//        this.cindUsmaj = cindUsmaj;
//    }

//    public Date getCindDtmaj() {
//        return cindDtmaj;
//    }
//
//    public void setCindDtmaj(Date cindDtmaj) {
//        this.cindDtmaj = cindDtmaj;
//    }

    public String getIdReseauDistrib() {
        return idReseauDistrib;
    }

    public void setIdReseauDistrib(String idReseauDistrib) {
        this.idReseauDistrib = idReseauDistrib;
    }

    public String getCindNonAssujetiTaxe() {
        return cindNonAssujetiTaxe;
    }

    public void setCindNonAssujetiTaxe(String cindNonAssujetiTaxe) {
        this.cindNonAssujetiTaxe = cindNonAssujetiTaxe;
    }

    public String getCindArbGratuit() {
        return cindArbGratuit;
    }

    public void setCindArbGratuit(String cindArbGratuit) {
        this.cindArbGratuit = cindArbGratuit;
    }

    public String getUtilAutoCrosselling() {
        return utilAutoCrosselling;
    }

    public void setUtilAutoCrosselling(String utilAutoCrosselling) {
        this.utilAutoCrosselling = utilAutoCrosselling;
    }

    public String getUtilAutoRelance() {
        return utilAutoRelance;
    }

    public void setUtilAutoRelance(String utilAutoRelance) {
        this.utilAutoRelance = utilAutoRelance;
    }

    public String getCentAutoCrosselling() {
        return centAutoCrosselling;
    }

    public void setCentAutoCrosselling(String centAutoCrosselling) {
        this.centAutoCrosselling = centAutoCrosselling;
    }

    public String getCentAutoRelance() {
        return centAutoRelance;
    }

    public void setCentAutoRelance(String centAutoRelance) {
        this.centAutoRelance = centAutoRelance;
    }

    public String getAgtId() {
        return agtId;
    }

    public void setAgtId(String agtId) {
        this.agtId = agtId;
    }

    public String getAgtCd() {
        return agtCd;
    }

    public void setAgtCd(String agtCd) {
        this.agtCd = agtCd;
    }

    public String getAgtPrenom() {
        return agtPrenom;
    }

    public void setAgtPrenom(String agtPrenom) {
        this.agtPrenom = agtPrenom;
    }

    public String getAgtNom() {
        return agtNom;
    }

    public void setAgtNom(String agtNom) {
        this.agtNom = agtNom;
    }

    public String getEntrCodeCreelia() {
        return entrCodeCreelia;
    }

    public void setEntrCodeCreelia(String entrCodeCreelia) {
        this.entrCodeCreelia = entrCodeCreelia;
    }

    public String getRefContratCreelia() {
        return refContratCreelia;
    }

    public void setRefContratCreelia(String refContratCreelia) {
        this.refContratCreelia = refContratCreelia;
    }

    public String getNomReseau() {
        return nomReseau;
    }

    public void setNomReseau(String nomReseau) {
        this.nomReseau = nomReseau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contrat contrat = (Contrat) o;

        if (agtCd != null ? !agtCd.equals(contrat.agtCd) : contrat.agtCd != null) return false;
        if (agtId != null ? !agtId.equals(contrat.agtId) : contrat.agtId != null) return false;
        if (agtNom != null ? !agtNom.equals(contrat.agtNom) : contrat.agtNom != null) return false;
        if (agtPrenom != null ? !agtPrenom.equals(contrat.agtPrenom) : contrat.agtPrenom != null) return false;
        if (centAutoCrosselling != null ? !centAutoCrosselling.equals(contrat.centAutoCrosselling) : contrat.centAutoCrosselling != null)
            return false;
        if (centAutoRelance != null ? !centAutoRelance.equals(contrat.centAutoRelance) : contrat.centAutoRelance != null)
            return false;
        if (centNumContrat != null ? !centNumContrat.equals(contrat.centNumContrat) : contrat.centNumContrat != null)
            return false;
        if (cindAdr1 != null ? !cindAdr1.equals(contrat.cindAdr1) : contrat.cindAdr1 != null) return false;
        if (cindAdr2 != null ? !cindAdr2.equals(contrat.cindAdr2) : contrat.cindAdr2 != null) return false;
        if (cindAdr3 != null ? !cindAdr3.equals(contrat.cindAdr3) : contrat.cindAdr3 != null) return false;
        if (cindArbGratuit != null ? !cindArbGratuit.equals(contrat.cindArbGratuit) : contrat.cindArbGratuit != null)
            return false;
        if (cindCodPostal != null ? !cindCodPostal.equals(contrat.cindCodPostal) : contrat.cindCodPostal != null)
            return false;
        if (cindDepRetraite != null ? !cindDepRetraite.equals(contrat.cindDepRetraite) : contrat.cindDepRetraite != null)
            return false;
        if (cindDepartEnt != null ? !cindDepartEnt.equals(contrat.cindDepartEnt) : contrat.cindDepartEnt != null)
            return false;
//        if (cindDtmaj != null ? !cindDtmaj.equals(contrat.cindDtmaj) : contrat.cindDtmaj != null) return false;
        if (cindEntreEnt != null ? !cindEntreEnt.equals(contrat.cindEntreEnt) : contrat.cindEntreEnt != null)
            return false;
        if (cindFermeContrat != null ? !cindFermeContrat.equals(contrat.cindFermeContrat) : contrat.cindFermeContrat != null)
            return false;
        if (cindInsee != null ? !cindInsee.equals(contrat.cindInsee) : contrat.cindInsee != null) return false;
        if (cindMatricule != null ? !cindMatricule.equals(contrat.cindMatricule) : contrat.cindMatricule != null)
            return false;
        if (cindNonAssujetiTaxe != null ? !cindNonAssujetiTaxe.equals(contrat.cindNonAssujetiTaxe) : contrat.cindNonAssujetiTaxe != null)
            return false;
        if (cindNpai != null ? !cindNpai.equals(contrat.cindNpai) : contrat.cindNpai != null) return false;
        if (cindNumero != null ? !cindNumero.equals(contrat.cindNumero) : contrat.cindNumero != null) return false;
        if (cindOuverContrat != null ? !cindOuverContrat.equals(contrat.cindOuverContrat) : contrat.cindOuverContrat != null)
            return false;
        if (cindPays != null ? !cindPays.equals(contrat.cindPays) : contrat.cindPays != null) return false;
        if (cindProfession != null ? !cindProfession.equals(contrat.cindProfession) : contrat.cindProfession != null)
            return false;
//        if (cindUsmaj != null ? !cindUsmaj.equals(contrat.cindUsmaj) : contrat.cindUsmaj != null) return false;
        if (cindVille != null ? !cindVille.equals(contrat.cindVille) : contrat.cindVille != null) return false;
        if (cspLibelle != null ? !cspLibelle.equals(contrat.cspLibelle) : contrat.cspLibelle != null) return false;
        if (entrCode != null ? !entrCode.equals(contrat.entrCode) : contrat.entrCode != null) return false;
        if (entrCodeCreelia != null ? !entrCodeCreelia.equals(contrat.entrCodeCreelia) : contrat.entrCodeCreelia != null)
            return false;
        if (entrNom != null ? !entrNom.equals(contrat.entrNom) : contrat.entrNom != null) return false;
        if (idContrat != null ? !idContrat.equals(contrat.idContrat) : contrat.idContrat != null) return false;
        if (idContratEnt != null ? !idContratEnt.equals(contrat.idContratEnt) : contrat.idContratEnt != null)
            return false;
        if (idCsp != null ? !idCsp.equals(contrat.idCsp) : contrat.idCsp != null) return false;
        if (idProduit != null ? !idProduit.equals(contrat.idProduit) : contrat.idProduit != null) return false;
        if (idReseauDistrib != null ? !idReseauDistrib.equals(contrat.idReseauDistrib) : contrat.idReseauDistrib != null)
            return false;
        if (prodAbrev != null ? !prodAbrev.equals(contrat.prodAbrev) : contrat.prodAbrev != null) return false;
        if (prodClasse != null ? !prodClasse.equals(contrat.prodClasse) : contrat.prodClasse != null) return false;
        if (refContratCreelia != null ? !refContratCreelia.equals(contrat.refContratCreelia) : contrat.refContratCreelia != null)
            return false;
        if (siglAvoirTot != null ? !siglAvoirTot.equals(contrat.siglAvoirTot) : contrat.siglAvoirTot != null)
            return false;
        if (utilAutoCrosselling != null ? !utilAutoCrosselling.equals(contrat.utilAutoCrosselling) : contrat.utilAutoCrosselling != null)
            return false;
        if (utilAutoRelance != null ? !utilAutoRelance.equals(contrat.utilAutoRelance) : contrat.utilAutoRelance != null)
            return false;
        if (nomReseau != null ? !nomReseau.equals(contrat.nomReseau) : contrat.nomReseau != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = idContrat != null ? idContrat.hashCode() : 0;
        result = 31 * result + (prodAbrev != null ? prodAbrev.hashCode() : 0);
        result = 31 * result + (prodClasse != null ? prodClasse.hashCode() : 0);
        result = 31 * result + (idProduit != null ? idProduit.hashCode() : 0);
        result = 31 * result + (entrNom != null ? entrNom.hashCode() : 0);
        result = 31 * result + (entrCode != null ? entrCode.hashCode() : 0);
        result = 31 * result + (centNumContrat != null ? centNumContrat.hashCode() : 0);
        result = 31 * result + (siglAvoirTot != null ? siglAvoirTot.hashCode() : 0);
        result = 31 * result + (idContratEnt != null ? idContratEnt.hashCode() : 0);
        result = 31 * result + (cindInsee != null ? cindInsee.hashCode() : 0);
        result = 31 * result + (cindNumero != null ? cindNumero.hashCode() : 0);
        result = 31 * result + (cindMatricule != null ? cindMatricule.hashCode() : 0);
        result = 31 * result + (cindProfession != null ? cindProfession.hashCode() : 0);
        result = 31 * result + (cindNpai != null ? cindNpai.hashCode() : 0);
        result = 31 * result + (idCsp != null ? idCsp.hashCode() : 0);
        result = 31 * result + (cspLibelle != null ? cspLibelle.hashCode() : 0);
        result = 31 * result + (cindOuverContrat != null ? cindOuverContrat.hashCode() : 0);
        result = 31 * result + (cindFermeContrat != null ? cindFermeContrat.hashCode() : 0);
        result = 31 * result + (cindDepartEnt != null ? cindDepartEnt.hashCode() : 0);
        result = 31 * result + (cindEntreEnt != null ? cindEntreEnt.hashCode() : 0);
        result = 31 * result + (cindDepRetraite != null ? cindDepRetraite.hashCode() : 0);
        result = 31 * result + (cindAdr1 != null ? cindAdr1.hashCode() : 0);
        result = 31 * result + (cindAdr2 != null ? cindAdr2.hashCode() : 0);
        result = 31 * result + (cindAdr3 != null ? cindAdr3.hashCode() : 0);
        result = 31 * result + (cindCodPostal != null ? cindCodPostal.hashCode() : 0);
        result = 31 * result + (cindVille != null ? cindVille.hashCode() : 0);
//        result = 31 * result + (cindPays != null ? cindPays.hashCode() : 0);
//        result = 31 * result + (cindUsmaj != null ? cindUsmaj.hashCode() : 0);
//        result = 31 * result + (cindDtmaj != null ? cindDtmaj.hashCode() : 0);
        result = 31 * result + (idReseauDistrib != null ? idReseauDistrib.hashCode() : 0);
        result = 31 * result + (cindNonAssujetiTaxe != null ? cindNonAssujetiTaxe.hashCode() : 0);
        result = 31 * result + (cindArbGratuit != null ? cindArbGratuit.hashCode() : 0);
        result = 31 * result + (utilAutoCrosselling != null ? utilAutoCrosselling.hashCode() : 0);
        result = 31 * result + (utilAutoRelance != null ? utilAutoRelance.hashCode() : 0);
        result = 31 * result + (centAutoCrosselling != null ? centAutoCrosselling.hashCode() : 0);
        result = 31 * result + (centAutoRelance != null ? centAutoRelance.hashCode() : 0);
        result = 31 * result + (agtId != null ? agtId.hashCode() : 0);
        result = 31 * result + (agtCd != null ? agtCd.hashCode() : 0);
        result = 31 * result + (agtPrenom != null ? agtPrenom.hashCode() : 0);
        result = 31 * result + (agtNom != null ? agtNom.hashCode() : 0);
        result = 31 * result + (entrCodeCreelia != null ? entrCodeCreelia.hashCode() : 0);
        result = 31 * result + (refContratCreelia != null ? refContratCreelia.hashCode() : 0);
        result = 31 * result + (nomReseau != null ? nomReseau.hashCode() : 0);
        return result;
    }
}
