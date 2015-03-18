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
@Table(name = "tipos_de_solicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeSolicitudes.findAll", query = "SELECT t FROM TiposDeSolicitudes t"),
    @NamedQuery(name = "TiposDeSolicitudes.findByIdTipoSolicitud", query = "SELECT t FROM TiposDeSolicitudes t WHERE t.idTipoSolicitud = :idTipoSolicitud"),
    @NamedQuery(name = "TiposDeSolicitudes.findByNombreTipoSolicitud", query = "SELECT t FROM TiposDeSolicitudes t WHERE t.nombreTipoSolicitud = :nombreTipoSolicitud")})
public class TiposDeSolicitudes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_solicitud")
    private Integer idTipoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_solicitud")
    private String nombreTipoSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoSolicitud")
    private List<Cdp> cdpList;

    public TiposDeSolicitudes() {
    }

    public TiposDeSolicitudes(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public TiposDeSolicitudes(Integer idTipoSolicitud, String nombreTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }

    public Integer getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getNombreTipoSolicitud() {
        return nombreTipoSolicitud;
    }

    public void setNombreTipoSolicitud(String nombreTipoSolicitud) {
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSolicitud != null ? idTipoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeSolicitudes)) {
            return false;
        }
        TiposDeSolicitudes other = (TiposDeSolicitudes) object;
        if ((this.idTipoSolicitud == null && other.idTipoSolicitud != null) || (this.idTipoSolicitud != null && !this.idTipoSolicitud.equals(other.idTipoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ nombreTipoSolicitud;
    }
    
}
