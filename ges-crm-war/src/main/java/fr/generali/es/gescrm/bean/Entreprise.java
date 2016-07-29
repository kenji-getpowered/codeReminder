package fr.generali.es.gescrm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * POJO d'affichage simple.
 */
@Entity
public class Entreprise  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ENTR_NOM")
    private String entrNom;
    @Id
    @Column(name = "ENTR_SIREN")
    private String entrSiren;
    @Column(name = "CENT_COLLEGE_A83")
    private String centCollegeA83;
    @Column(name = "CENT_NUM_CONTRAT")
    private String centNumContrat;
    @Column(name = "CENT_REF_EXTERNE")
    private String centRefExterne;

    public String getEntrNom() {
        return entrNom;
    }

    public void setEntrNom(String entrNom) {
        this.entrNom = entrNom;
    }

    public String getEntrSiren() {
        return entrSiren;
    }

    public void setEntrSiren(String entrSiren) {
        this.entrSiren = entrSiren;
    }

    public String getCentCollegeA83() {
        return centCollegeA83;
    }

    public void setCentCollegeA83(String centCollegeA83) {
        this.centCollegeA83 = centCollegeA83;
    }

    public String getCentNumContrat() {
        return centNumContrat;
    }

    public void setCentNumContrat(String centNumContrat) {
        this.centNumContrat = centNumContrat;
    }

    public String getCentRefExterne() {
        return centRefExterne;
    }

    public void setCentRefExterne(String centRefExterne) {
        this.centRefExterne = centRefExterne;
    }
}
