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
@Table(name = "colores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colores.findAll", query = "SELECT c FROM Colores c")
    , @NamedQuery(name = "Colores.findByIdColor", query = "SELECT c FROM Colores c WHERE c.idColor = :idColor")
    , @NamedQuery(name = "Colores.findByColorEspanol", query = "SELECT c FROM Colores c WHERE c.colorEspanol = :colorEspanol")
    , @NamedQuery(name = "Colores.findByColorIngles", query = "SELECT c FROM Colores c WHERE c.colorIngles = :colorIngles")})
public class Colores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idColor")
    private Integer idColor;
    @Basic(optional = false)
    @Column(name = "color_espanol")
    private String colorEspanol;
    @Basic(optional = false)
    @Column(name = "color_ingles")
    private String colorIngles;

    public Colores() {
    }

    public Colores(Integer idColor) {
        this.idColor = idColor;
    }

    public Colores(Integer idColor, String colorEspanol, String colorIngles) {
        this.idColor = idColor;
        this.colorEspanol = colorEspanol;
        this.colorIngles = colorIngles;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getColorEspanol() {
        return colorEspanol;
    }

    public void setColorEspanol(String colorEspanol) {
        this.colorEspanol = colorEspanol;
    }

    public String getColorIngles() {
        return colorIngles;
    }

    public void setColorIngles(String colorIngles) {
        this.colorIngles = colorIngles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColor != null ? idColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colores)) {
            return false;
        }
        Colores other = (Colores) object;
        if ((this.idColor == null && other.idColor != null) || (this.idColor != null && !this.idColor.equals(other.idColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Colores[ idColor=" + idColor + " ]";
    }
    
}
