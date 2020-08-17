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
@Table(name = "partesdecuerpo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partesdecuerpo.findAll", query = "SELECT p FROM Partesdecuerpo p")
    , @NamedQuery(name = "Partesdecuerpo.findByIdParte", query = "SELECT p FROM Partesdecuerpo p WHERE p.idParte = :idParte")
    , @NamedQuery(name = "Partesdecuerpo.findByParteCuerpoespanol", query = "SELECT p FROM Partesdecuerpo p WHERE p.parteCuerpoespanol = :parteCuerpoespanol")
    , @NamedQuery(name = "Partesdecuerpo.findByParteCuerpoingles", query = "SELECT p FROM Partesdecuerpo p WHERE p.parteCuerpoingles = :parteCuerpoingles")})
public class Partesdecuerpo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idParte")
    private Integer idParte;
    @Basic(optional = false)
    @Column(name = "parteCuerpo_espanol")
    private String parteCuerpoespanol;
    @Basic(optional = false)
    @Column(name = "parteCuerpo_ingles")
    private String parteCuerpoingles;

    public Partesdecuerpo() {
    }

    public Partesdecuerpo(Integer idParte) {
        this.idParte = idParte;
    }

    public Partesdecuerpo(Integer idParte, String parteCuerpoespanol, String parteCuerpoingles) {
        this.idParte = idParte;
        this.parteCuerpoespanol = parteCuerpoespanol;
        this.parteCuerpoingles = parteCuerpoingles;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public String getParteCuerpoespanol() {
        return parteCuerpoespanol;
    }

    public void setParteCuerpoespanol(String parteCuerpoespanol) {
        this.parteCuerpoespanol = parteCuerpoespanol;
    }

    public String getParteCuerpoingles() {
        return parteCuerpoingles;
    }

    public void setParteCuerpoingles(String parteCuerpoingles) {
        this.parteCuerpoingles = parteCuerpoingles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParte != null ? idParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partesdecuerpo)) {
            return false;
        }
        Partesdecuerpo other = (Partesdecuerpo) object;
        if ((this.idParte == null && other.idParte != null) || (this.idParte != null && !this.idParte.equals(other.idParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Partesdecuerpo[ idParte=" + idParte + " ]";
    }
    
}
