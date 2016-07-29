package fr.generali.es.gescrm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Mikael KROK (b002ksc)
 * @date 12/05/2016
 * POJO d'affichage
 */
@Entity
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="DATE_TRI") private String  dateTri;
    @Id
    @Column(name="ID") private String  id;
    @Column(name="DOSSIER") private String  dossier;
    @Column(name="ACTION") private String  action;
    @Column(name="IDACTION") private String  idaction;
    @Column(name="TYPE") private String  type;
    @Column(name="LIBTYPE") private String  libtype;
    @Column(name="MOTIF") private String  motif;
    @Column(name="SENS") private String  sens;
    @Column(name="COMMENTAIRE") private String  commentaire;
    @Column(name="AGENT_INITIATEUR") private String  agentInitiateur;
    // @TODO Remplacer par des dates
    @Column(name="DATE_CREATION") private String dateCreation;
    @Column(name="AGENT_AFFECTE") private String  agentAffecte;
    // @TODO Remplacer par des dates
    @Column(name="DATE_ECHEANCE") private String dateEcheance;
    @Column(name="STATUT") private String  statut;
    @Column(name="IDTYPEDOSSIER") private String  idtypedossier;

    public String getDateTri() {
        return dateTri;
    }

    public void setDateTri(String dateTri) {
        this.dateTri = dateTri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDossier() {
        return dossier;
    }

    public void setDossier(String dossier) {
        this.dossier = dossier;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIdaction() {
        return idaction;
    }

    public void setIdaction(String idaction) {
        this.idaction = idaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibtype() {
        return libtype;
    }

    public void setLibtype(String libtype) {
        this.libtype = libtype;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getAgentInitiateur() {
        return agentInitiateur;
    }

    public void setAgentInitiateur(String agentInitiateur) {
        this.agentInitiateur = agentInitiateur;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAgentAffecte() {
        return agentAffecte;
    }

    public void setAgentAffecte(String agentAffecte) {
        this.agentAffecte = agentAffecte;
    }

    public String getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(String dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getIdtypedossier() {
        return idtypedossier;
    }

    public void setIdtypedossier(String idtypedossier) {
        this.idtypedossier = idtypedossier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (action != null ? !action.equals(contact.action) : contact.action != null) return false;
        if (agentAffecte != null ? !agentAffecte.equals(contact.agentAffecte) : contact.agentAffecte != null)
            return false;
        if (agentInitiateur != null ? !agentInitiateur.equals(contact.agentInitiateur) : contact.agentInitiateur != null)
            return false;
        if (commentaire != null ? !commentaire.equals(contact.commentaire) : contact.commentaire != null) return false;
        if (dateCreation != null ? !dateCreation.equals(contact.dateCreation) : contact.dateCreation != null)
            return false;
        if (dateEcheance != null ? !dateEcheance.equals(contact.dateEcheance) : contact.dateEcheance != null)
            return false;
        if (dateTri != null ? !dateTri.equals(contact.dateTri) : contact.dateTri != null) return false;
        if (dossier != null ? !dossier.equals(contact.dossier) : contact.dossier != null) return false;
        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (idaction != null ? !idaction.equals(contact.idaction) : contact.idaction != null) return false;
        if (idtypedossier != null ? !idtypedossier.equals(contact.idtypedossier) : contact.idtypedossier != null)
            return false;
        if (libtype != null ? !libtype.equals(contact.libtype) : contact.libtype != null) return false;
        if (motif != null ? !motif.equals(contact.motif) : contact.motif != null) return false;
        if (sens != null ? !sens.equals(contact.sens) : contact.sens != null) return false;
        if (statut != null ? !statut.equals(contact.statut) : contact.statut != null) return false;
        if (type != null ? !type.equals(contact.type) : contact.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateTri != null ? dateTri.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (dossier != null ? dossier.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (idaction != null ? idaction.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (libtype != null ? libtype.hashCode() : 0);
        result = 31 * result + (motif != null ? motif.hashCode() : 0);
        result = 31 * result + (sens != null ? sens.hashCode() : 0);
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        result = 31 * result + (agentInitiateur != null ? agentInitiateur.hashCode() : 0);
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        result = 31 * result + (agentAffecte != null ? agentAffecte.hashCode() : 0);
        result = 31 * result + (dateEcheance != null ? dateEcheance.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (idtypedossier != null ? idtypedossier.hashCode() : 0);
        return result;
    }
}
