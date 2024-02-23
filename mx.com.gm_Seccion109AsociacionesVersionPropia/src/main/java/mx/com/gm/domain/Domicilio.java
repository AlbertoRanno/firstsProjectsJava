package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //Indico el tipo de llave primaria que voy a utilizar
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //Esto indica que es la BBDD la que se va a encargar de generar esta llave primaria
    //No es algo necesario de aclarar, pero asi se formaliza. Podria haber otra forma de generarla, y la pondria aca
    
    @Column(name = "id_domicilio")
    /*private int idDomicilio; 
    => Es correcto, pero a veces se usa Integer, en lugar de int, para poder hacer comprobaciones sobre null
    Es decir, "null" en lugar de "0", como seria para int (tipo primitivo) */
    private Integer idDomicilio;

    private String calle;

    @Column(name = "nro_calle")
    private String nroCalle;

    private String pais;

    public Domicilio() { //Para cumplir con el standart de los java beans. Las clases de entidad deben cumplir este standar
    }

    public Domicilio(int idDomicilio) { //Para manejar la llave primaria
        this.idDomicilio = idDomicilio;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNroCalle() {
        return nroCalle;
    }

    public void setNroCalle(String nroCalle) {
        this.nroCalle = nroCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", nroCalle=" + nroCalle + ", pais=" + pais + '}';
    }
    
    //Como buena practica, dado que estas clases se pueden agregar en colleciones, agrego equals y hashCode
    //Basta con seleccionar el idDomicilio para saber si dos objetos son iguales

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idDomicilio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        return this.idDomicilio == other.idDomicilio;
    }

}
