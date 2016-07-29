package fr.generali.es.gescrm.form;

import javax.validation.constraints.Pattern;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * POJO d'affichage
 */

public class SearchAssureForm {
    @Pattern(regexp="[0-9]*")
    private String identifiant;
    @Pattern(regexp="[0-9]*")
    private String identifiantCreelia;
    private String nom;
    private String prenom;
    private String sortGroup;
    private String codeAgent;
    private String page;


    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiantCreelia() {
        return identifiantCreelia;
    }

    public void setIdentifiantCreelia(String identifiantCreelia) {
        this.identifiantCreelia = identifiantCreelia;
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

    public String getSortGroup() {
        return sortGroup;
    }

    public void setSortGroup(String sortGroup) {
        this.sortGroup = sortGroup;
    }

    public String getCodeAgent() {
        return codeAgent;
    }

    public void setCodeAgent(String codeAgent) {
        this.codeAgent = codeAgent;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}
