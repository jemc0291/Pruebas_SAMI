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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "niveles_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelesFormacion.findAll", query = "SELECT n FROM NivelesFormacion n"),
    @NamedQuery(name = "NivelesFormacion.findByIdNivelesFormacion", query = "SELECT n FROM NivelesFormacion n WHERE n.idNivelesFormacion = :idNivelesFormacion"),
    @NamedQuery(name = "NivelesFormacion.findByNombreNivel", query = "SELECT n FROM NivelesFormacion n WHERE n.nombreNivel = :nombreNivel")})
public class NivelesFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_niveles_formacion")
    private Integer idNivelesFormacion;
    @Size(max = 45)
    @Column(name = "nombre_nivel")
    private String nombreNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelesFormacion")
    private List<FormacionAcademica> formacionAcademicaList;

    public NivelesFormacion() {
    }

    public NivelesFormacion(Integer idNivelesFormacion) {
        this.idNivelesFormacion = idNivelesFormacion;
    }

    public Integer getIdNivelesFormacion() {
        return idNivelesFormacion;
    }

    public void setIdNivelesFormacion(Integer idNivelesFormacion) {
        this.idNivelesFormacion = idNivelesFormacion;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    @XmlTransient
    public List<FormacionAcademica> getFormacionAcademicaList() {
        return formacionAcademicaList;
    }

    public void setFormacionAcademicaList(List<FormacionAcademica> formacionAcademicaList) {
        this.formacionAcademicaList = formacionAcademicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelesFormacion != null ? idNivelesFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelesFormacion)) {
            return false;
        }
        NivelesFormacion other = (NivelesFormacion) object;
        if ((this.idNivelesFormacion == null && other.idNivelesFormacion != null) || (this.idNivelesFormacion != null && !this.idNivelesFormacion.equals(other.idNivelesFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.NivelesFormacion[ idNivelesFormacion=" + idNivelesFormacion + " ]";
    }
    
}
