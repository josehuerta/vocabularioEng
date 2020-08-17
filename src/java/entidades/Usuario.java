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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.findByCalifVerbos", query = "SELECT u FROM Usuario u WHERE u.califVerbos = :califVerbos")
    , @NamedQuery(name = "Usuario.findByCalifAnimales", query = "SELECT u FROM Usuario u WHERE u.califAnimales = :califAnimales")
    , @NamedQuery(name = "Usuario.findByCalifCuerpo1", query = "SELECT u FROM Usuario u WHERE u.califCuerpo1 = :califCuerpo1")
    , @NamedQuery(name = "Usuario.findByCalifCuerpo2", query = "SELECT u FROM Usuario u WHERE u.califCuerpo2 = :califCuerpo2")
    , @NamedQuery(name = "Usuario.findByCalifColores", query = "SELECT u FROM Usuario u WHERE u.califColores = :califColores")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "califVerbos")
    private int califVerbos;
    @Basic(optional = false)
    @Column(name = "califAnimales")
    private int califAnimales;
    @Basic(optional = false)
    @Column(name = "califCuerpo1")
    private int califCuerpo1;
    @Basic(optional = false)
    @Column(name = "califCuerpo2")
    private int califCuerpo2;
    @Basic(optional = false)
    @Column(name = "califColores")
    private int califColores;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String correo, String password, int califVerbos, int califAnimales, int califCuerpo1, int califCuerpo2, int califColores, String nombre, String apellidos) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.password = password;
        this.califVerbos = califVerbos;
        this.califAnimales = califAnimales;
        this.califCuerpo1 = califCuerpo1;
        this.califCuerpo2 = califCuerpo2;
        this.califColores = califColores;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCalifVerbos() {
        return califVerbos;
    }

    public void setCalifVerbos(int califVerbos) {
        this.califVerbos = califVerbos;
    }

    public int getCalifAnimales() {
        return califAnimales;
    }

    public void setCalifAnimales(int califAnimales) {
        this.califAnimales = califAnimales;
    }

    public int getCalifCuerpo1() {
        return califCuerpo1;
    }

    public void setCalifCuerpo1(int califCuerpo1) {
        this.califCuerpo1 = califCuerpo1;
    }

    public int getCalifCuerpo2() {
        return califCuerpo2;
    }

    public void setCalifCuerpo2(int califCuerpo2) {
        this.califCuerpo2 = califCuerpo2;
    }

    public int getCalifColores() {
        return califColores;
    }

    public void setCalifColores(int califColores) {
        this.califColores = califColores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
