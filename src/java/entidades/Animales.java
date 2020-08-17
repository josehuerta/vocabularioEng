/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LALO
 */
@Entity
@Table(name = "animales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animales.findAll", query = "SELECT a FROM Animales a")
    , @NamedQuery(name = "Animales.findByIdAnimal", query = "SELECT a FROM Animales a WHERE a.idAnimal = :idAnimal")
    , @NamedQuery(name = "Animales.findByAnimalEspanol", query = "SELECT a FROM Animales a WHERE a.animalEspanol = :animalEspanol")
    , @NamedQuery(name = "Animales.findByAnimalIngles", query = "SELECT a FROM Animales a WHERE a.animalIngles = :animalIngles")
    , @NamedQuery(name = "Animales.findByRuta", query = "SELECT a FROM Animales a WHERE a.ruta = :ruta")})
public class Animales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnimal")
    private Integer idAnimal;
    @Basic(optional = false)
    @Column(name = "animal_espanol")
    private String animalEspanol;
    @Basic(optional = false)
    @Column(name = "animal_ingles")
    private String animalIngles;
    @Basic(optional = false)
    @Column(name = "ruta")
    private String ruta;

    public Animales() {
    }

    public Animales(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Animales(Integer idAnimal, String animalEspanol, String animalIngles, String ruta) {
        this.idAnimal = idAnimal;
        this.animalEspanol = animalEspanol;
        this.animalIngles = animalIngles;
        this.ruta = ruta;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getAnimalEspanol() {
        return animalEspanol;
    }

    public void setAnimalEspanol(String animalEspanol) {
        this.animalEspanol = animalEspanol;
    }

    public String getAnimalIngles() {
        return animalIngles;
    }

    public void setAnimalIngles(String animalIngles) {
        this.animalIngles = animalIngles;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animales)) {
            return false;
        }
        Animales other = (Animales) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Animales[ idAnimal=" + idAnimal + " ]";
    }
    
}
