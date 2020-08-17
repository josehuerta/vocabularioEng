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
@Table(name = "verbosirregulares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Verbosirregulares.findAll", query = "SELECT v FROM Verbosirregulares v")
    , @NamedQuery(name = "Verbosirregulares.findByIdVerbo", query = "SELECT v FROM Verbosirregulares v WHERE v.idVerbo = :idVerbo")
    , @NamedQuery(name = "Verbosirregulares.findByEspanol", query = "SELECT v FROM Verbosirregulares v WHERE v.espanol = :espanol")
    , @NamedQuery(name = "Verbosirregulares.findByPresente", query = "SELECT v FROM Verbosirregulares v WHERE v.presente = :presente")
    , @NamedQuery(name = "Verbosirregulares.findByPasado", query = "SELECT v FROM Verbosirregulares v WHERE v.pasado = :pasado")
    , @NamedQuery(name = "Verbosirregulares.findByPasadoParticipio", query = "SELECT v FROM Verbosirregulares v WHERE v.pasadoParticipio = :pasadoParticipio")})
public class Verbosirregulares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVerbo")
    private Integer idVerbo;
    @Basic(optional = false)
    @Column(name = "espanol")
    private String espanol;
    @Basic(optional = false)
    @Column(name = "presente")
    private String presente;
    @Basic(optional = false)
    @Column(name = "pasado")
    private String pasado;
    @Basic(optional = false)
    @Column(name = "pasado_participio")
    private String pasadoParticipio;

    public Verbosirregulares() {
    }

    public Verbosirregulares(Integer idVerbo) {
        this.idVerbo = idVerbo;
    }

    public Verbosirregulares(Integer idVerbo, String espanol, String presente, String pasado, String pasadoParticipio) {
        this.idVerbo = idVerbo;
        this.espanol = espanol;
        this.presente = presente;
        this.pasado = pasado;
        this.pasadoParticipio = pasadoParticipio;
    }

    public Integer getIdVerbo() {
        return idVerbo;
    }

    public void setIdVerbo(Integer idVerbo) {
        this.idVerbo = idVerbo;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    public String getPasado() {
        return pasado;
    }

    public void setPasado(String pasado) {
        this.pasado = pasado;
    }

    public String getPasadoParticipio() {
        return pasadoParticipio;
    }

    public void setPasadoParticipio(String pasadoParticipio) {
        this.pasadoParticipio = pasadoParticipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVerbo != null ? idVerbo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Verbosirregulares)) {
            return false;
        }
        Verbosirregulares other = (Verbosirregulares) object;
        if ((this.idVerbo == null && other.idVerbo != null) || (this.idVerbo != null && !this.idVerbo.equals(other.idVerbo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Verbosirregulares[ idVerbo=" + idVerbo + " ]";
    }
    
}
