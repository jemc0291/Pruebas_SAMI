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
@Table(name = "proyecto_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoFormacion.findAll", query = "SELECT p FROM ProyectoFormacion p"),
    @NamedQuery(name = "ProyectoFormacion.findByIdProyectoFormacion", query = "SELECT p FROM ProyectoFormacion p WHERE p.idProyectoFormacion = :idProyectoFormacion"),
    @NamedQuery(name = "ProyectoFormacion.findByNombreProyectoFormacion", query = "SELECT p FROM ProyectoFormacion p WHERE p.nombreProyectoFormacion = :nombreProyectoFormacion")})
public class ProyectoFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto_formacion")
    private Integer idProyectoFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_proyecto_formacion")
    private String nombreProyectoFormacion;
    @ManyToMany(mappedBy = "proyectoFormacionList")
    private List<FichaCaracterizacion> fichaCaracterizacionList;

    public ProyectoFormacion() {
    }

    public ProyectoFormacion(Integer idProyectoFormacion) {
        this.idProyectoFormacion = idProyectoFormacion;
    }

    public ProyectoFormacion(Integer idProyectoFormacion, String nombreProyectoFormacion) {
        this.idProyectoFormacion = idProyectoFormacion;
        this.nombreProyectoFormacion = nombreProyectoFormacion;
    }

    public Integer getIdProyectoFormacion() {
        return idProyectoFormacion;
    }

    public void setIdProyectoFormacion(Integer idProyectoFormacion) {
        this.idProyectoFormacion = idProyectoFormacion;
    }

    public String getNombreProyectoFormacion() {
        return nombreProyectoFormacion;
    }

    public void setNombreProyectoFormacion(String nombreProyectoFormacion) {
        this.nombreProyectoFormacion = nombreProyectoFormacion;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoFormacion != null ? idProyectoFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoFormacion)) {
            return false;
        }
        ProyectoFormacion other = (ProyectoFormacion) object;
        if ((this.idProyectoFormacion == null && other.idProyectoFormacion != null) || (this.idProyectoFormacion != null && !this.idProyectoFormacion.equals(other.idProyectoFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ProyectoFormacion[ idProyectoFormacion=" + idProyectoFormacion + " ]";
    }
    
}
