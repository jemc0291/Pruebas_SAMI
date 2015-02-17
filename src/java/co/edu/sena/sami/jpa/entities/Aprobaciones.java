/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "aprobaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprobaciones.findAll", query = "SELECT a FROM Aprobaciones a"),
    @NamedQuery(name = "Aprobaciones.findByFechaAprobacion", query = "SELECT a FROM Aprobaciones a WHERE a.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "Aprobaciones.findByIdAprobacion", query = "SELECT a FROM Aprobaciones a WHERE a.idAprobacion = :idAprobacion")})
public class Aprobaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aprobacion")
    private Boolean idAprobacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAprobacion")
    private List<Comisiones> comisionesList;

    public Aprobaciones() {
    }

    public Aprobaciones(Boolean idAprobacion) {
        this.idAprobacion = idAprobacion;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Boolean getIdAprobacion() {
        return idAprobacion;
    }

    public void setIdAprobacion(Boolean idAprobacion) {
        this.idAprobacion = idAprobacion;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAprobacion != null ? idAprobacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprobaciones)) {
            return false;
        }
        Aprobaciones other = (Aprobaciones) object;
        if ((this.idAprobacion == null && other.idAprobacion != null) || (this.idAprobacion != null && !this.idAprobacion.equals(other.idAprobacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Aprobaciones[ idAprobacion=" + idAprobacion + " ]";
    }
    
}
