/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "tipos_de_servicios_solicitud_de_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeServiciosSolicitudDeServicios.findAll", query = "SELECT t FROM TiposDeServiciosSolicitudDeServicios t"),
    @NamedQuery(name = "TiposDeServiciosSolicitudDeServicios.findByIdSolicitudServicio", query = "SELECT t FROM TiposDeServiciosSolicitudDeServicios t WHERE t.idSolicitudServicio = :idSolicitudServicio")})
public class TiposDeServiciosSolicitudDeServicios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Solicitud_Servicio")
    private Integer idSolicitudServicio;
    @JoinColumn(name = "id_tipo_Servicio", referencedColumnName = "id_tipo_serv")
    @ManyToOne(optional = false)
    private TipoDeServicios idtipoServicio;
    @JoinColumn(name = "id_Solicitud_Servicio", referencedColumnName = "id_solicitud_servicio", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SolicitudServicios solicitudServicios;

    public TiposDeServiciosSolicitudDeServicios() {
    }

    public TiposDeServiciosSolicitudDeServicios(Integer idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public Integer getIdSolicitudServicio() {
        return idSolicitudServicio;
    }

    public void setIdSolicitudServicio(Integer idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public TipoDeServicios getIdtipoServicio() {
        return idtipoServicio;
    }

    public void setIdtipoServicio(TipoDeServicios idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public SolicitudServicios getSolicitudServicios() {
        return solicitudServicios;
    }

    public void setSolicitudServicios(SolicitudServicios solicitudServicios) {
        this.solicitudServicios = solicitudServicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudServicio != null ? idSolicitudServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeServiciosSolicitudDeServicios)) {
            return false;
        }
        TiposDeServiciosSolicitudDeServicios other = (TiposDeServiciosSolicitudDeServicios) object;
        if ((this.idSolicitudServicio == null && other.idSolicitudServicio != null) || (this.idSolicitudServicio != null && !this.idSolicitudServicio.equals(other.idSolicitudServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.TiposDeServiciosSolicitudDeServicios[ idSolicitudServicio=" + idSolicitudServicio + " ]";
    }
    
}
