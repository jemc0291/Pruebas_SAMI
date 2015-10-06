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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "formacion_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormacionAcademica.findAll", query = "SELECT f FROM FormacionAcademica f"),
    @NamedQuery(name = "FormacionAcademica.findByIdFormacion", query = "SELECT f FROM FormacionAcademica f WHERE f.idFormacion = :idFormacion"),
    @NamedQuery(name = "FormacionAcademica.findByNombreFormacion", query = "SELECT f FROM FormacionAcademica f WHERE f.nombreFormacion = :nombreFormacion"),
    @NamedQuery(name = "FormacionAcademica.findBySoportadoFormacion", query = "SELECT f FROM FormacionAcademica f WHERE f.soportadoFormacion = :soportadoFormacion")})
public class FormacionAcademica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_formacion")
    private Integer idFormacion;
    @Size(max = 45)
    @Column(name = "nombre_formacion")
    private String nombreFormacion;
    @Column(name = "soportado_formacion")
    private Boolean soportadoFormacion;
    @ManyToMany(mappedBy = "formacionAcademicaList")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "id_niveles_formacion", referencedColumnName = "id_niveles_formacion")
    @ManyToOne(optional = false)
    private NivelesFormacion idNivelesFormacion;

    public FormacionAcademica() {
    }

    public FormacionAcademica(Integer idFormacion) {
        this.idFormacion = idFormacion;
    }

    public Integer getIdFormacion() {
        return idFormacion;
    }

    public void setIdFormacion(Integer idFormacion) {
        this.idFormacion = idFormacion;
    }

    public String getNombreFormacion() {
        return nombreFormacion;
    }

    public void setNombreFormacion(String nombreFormacion) {
        this.nombreFormacion = nombreFormacion;
    }

    public Boolean getSoportadoFormacion() {
        return soportadoFormacion;
    }

    public void setSoportadoFormacion(Boolean soportadoFormacion) {
        this.soportadoFormacion = soportadoFormacion;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public NivelesFormacion getIdNivelesFormacion() {
        return idNivelesFormacion;
    }

    public void setIdNivelesFormacion(NivelesFormacion idNivelesFormacion) {
        this.idNivelesFormacion = idNivelesFormacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormacion != null ? idFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormacionAcademica)) {
            return false;
        }
        FormacionAcademica other = (FormacionAcademica) object;
        if ((this.idFormacion == null && other.idFormacion != null) || (this.idFormacion != null && !this.idFormacion.equals(other.idFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.FormacionAcademica[ idFormacion=" + idFormacion + " ]";
    }
    
}
