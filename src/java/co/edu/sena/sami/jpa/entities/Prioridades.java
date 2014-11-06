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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "prioridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridades.findAll", query = "SELECT p FROM Prioridades p"),
    @NamedQuery(name = "Prioridades.findByIdPrioridades", query = "SELECT p FROM Prioridades p WHERE p.idPrioridades = :idPrioridades"),
    @NamedQuery(name = "Prioridades.findByNombrePrioridad", query = "SELECT p FROM Prioridades p WHERE p.nombrePrioridad = :nombrePrioridad")})
public class Prioridades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prioridades")
    private Short idPrioridades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_prioridad")
    private String nombrePrioridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrioridades")
    private List<SolicitudServicios> solicitudServiciosList;

    public Prioridades() {
    }

    public Prioridades(Short idPrioridades) {
        this.idPrioridades = idPrioridades;
    }

    public Prioridades(Short idPrioridades, String nombrePrioridad) {
        this.idPrioridades = idPrioridades;
        this.nombrePrioridad = nombrePrioridad;
    }

    public Short getIdPrioridades() {
        return idPrioridades;
    }

    public void setIdPrioridades(Short idPrioridades) {
        this.idPrioridades = idPrioridades;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    @XmlTransient
    public List<SolicitudServicios> getSolicitudServiciosList() {
        return solicitudServiciosList;
    }

    public void setSolicitudServiciosList(List<SolicitudServicios> solicitudServiciosList) {
        this.solicitudServiciosList = solicitudServiciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrioridades != null ? idPrioridades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridades)) {
            return false;
        }
        Prioridades other = (Prioridades) object;
        if ((this.idPrioridades == null && other.idPrioridades != null) || (this.idPrioridades != null && !this.idPrioridades.equals(other.idPrioridades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Prioridades[ idPrioridades=" + idPrioridades + " ]";
    }
    
}
