/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "tipo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByIdtipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.idtipoUsuario = :idtipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByNombreUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.nombreUsuario = :nombreUsuario")})
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_usuario")
    private Integer idtipoUsuario;
    @Size(max = 45)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoUsuario")
    private List<AvanceUsuarios> avanceUsuariosList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idtipoUsuario) {
        this.idtipoUsuario = idtipoUsuario;
    }

    public Integer getIdtipoUsuario() {
        return idtipoUsuario;
    }

    public void setIdtipoUsuario(Integer idtipoUsuario) {
        this.idtipoUsuario = idtipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @XmlTransient
    public List<AvanceUsuarios> getAvanceUsuariosList() {
        return avanceUsuariosList;
    }

    public void setAvanceUsuariosList(List<AvanceUsuarios> avanceUsuariosList) {
        this.avanceUsuariosList = avanceUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoUsuario != null ? idtipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idtipoUsuario == null && other.idtipoUsuario != null) || (this.idtipoUsuario != null && !this.idtipoUsuario.equals(other.idtipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.TipoUsuario[ idtipoUsuario=" + idtipoUsuario + " ]";
    }
    
}
