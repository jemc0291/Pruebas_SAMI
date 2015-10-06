/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "riesgos_laborales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RiesgosLaborales.findAll", query = "SELECT r FROM RiesgosLaborales r"),
    @NamedQuery(name = "RiesgosLaborales.findByIdRiesgosLaborales", query = "SELECT r FROM RiesgosLaborales r WHERE r.idRiesgosLaborales = :idRiesgosLaborales"),
    @NamedQuery(name = "RiesgosLaborales.findByDescripcionRiesgo", query = "SELECT r FROM RiesgosLaborales r WHERE r.descripcionRiesgo = :descripcionRiesgo")})
public class RiesgosLaborales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_riesgos_laborales")
    private Integer idRiesgosLaborales;
    @Size(max = 45)
    @Column(name = "descripcion_riesgo")
    private String descripcionRiesgo;
    @ManyToMany(mappedBy = "riesgosLaboralesList")
    private List<Usuarios> usuariosList;

    public RiesgosLaborales() {
    }

    public RiesgosLaborales(Integer idRiesgosLaborales) {
        this.idRiesgosLaborales = idRiesgosLaborales;
    }

    public Integer getIdRiesgosLaborales() {
        return idRiesgosLaborales;
    }

    public void setIdRiesgosLaborales(Integer idRiesgosLaborales) {
        this.idRiesgosLaborales = idRiesgosLaborales;
    }

    public String getDescripcionRiesgo() {
        return descripcionRiesgo;
    }

    public void setDescripcionRiesgo(String descripcionRiesgo) {
        this.descripcionRiesgo = descripcionRiesgo;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRiesgosLaborales != null ? idRiesgosLaborales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RiesgosLaborales)) {
            return false;
        }
        RiesgosLaborales other = (RiesgosLaborales) object;
        if ((this.idRiesgosLaborales == null && other.idRiesgosLaborales != null) || (this.idRiesgosLaborales != null && !this.idRiesgosLaborales.equals(other.idRiesgosLaborales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.RiesgosLaborales[ idRiesgosLaborales=" + idRiesgosLaborales + " ]";
    }
    
}
