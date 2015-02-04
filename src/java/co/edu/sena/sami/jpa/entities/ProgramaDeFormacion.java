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
 * @author Adsim
 */
@Entity
@Table(name = "programa_de_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaDeFormacion.findAll", query = "SELECT p FROM ProgramaDeFormacion p"),
    @NamedQuery(name = "ProgramaDeFormacion.findByIdProgramaFormacion", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.idProgramaFormacion = :idProgramaFormacion"),
    @NamedQuery(name = "ProgramaDeFormacion.findByNombreprogramaformacion", query = "SELECT p FROM ProgramaDeFormacion p WHERE p.nombreprogramaformacion = :nombreprogramaformacion")})
public class ProgramaDeFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_programa_formacion")
    private Integer idProgramaFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Nombre_programa_formacion")
    private String nombreprogramaformacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProgramaFormacion")
    private List<FichaCaracterizacion> fichaCaracterizacionList;

    public ProgramaDeFormacion() {
    }

    public ProgramaDeFormacion(Integer idProgramaFormacion) {
        this.idProgramaFormacion = idProgramaFormacion;
    }

    public ProgramaDeFormacion(Integer idProgramaFormacion, String nombreprogramaformacion) {
        this.idProgramaFormacion = idProgramaFormacion;
        this.nombreprogramaformacion = nombreprogramaformacion;
    }

    public Integer getIdProgramaFormacion() {
        return idProgramaFormacion;
    }

    public void setIdProgramaFormacion(Integer idProgramaFormacion) {
        this.idProgramaFormacion = idProgramaFormacion;
    }

    public String getNombreprogramaformacion() {
        return nombreprogramaformacion;
    }

    public void setNombreprogramaformacion(String nombreprogramaformacion) {
        this.nombreprogramaformacion = nombreprogramaformacion;
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
        hash += (idProgramaFormacion != null ? idProgramaFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaDeFormacion)) {
            return false;
        }
        ProgramaDeFormacion other = (ProgramaDeFormacion) object;
        if ((this.idProgramaFormacion == null && other.idProgramaFormacion != null) || (this.idProgramaFormacion != null && !this.idProgramaFormacion.equals(other.idProgramaFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ProgramaDeFormacion[ idProgramaFormacion=" + idProgramaFormacion + " ]";
    }
    
}
