package fr.generali.es.gescrm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author Mikael KROK (b002ksc)
 * @date 12/05/2016
 * POJO d'affichage
 */
@Entity
public class ContactSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONT_CANAL")
    private String canal;

    @Id
    @Column(name = "CONT_SENS")
    private String sens;

    @Id
    @Column(name = "NB")
    private Long nombre;

       public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }
}

