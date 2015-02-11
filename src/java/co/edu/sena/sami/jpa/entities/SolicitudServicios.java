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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "solicitud_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudServicios.findAll", query = "SELECT s FROM SolicitudServicios s"),
    @NamedQuery(name = "SolicitudServicios.findByIdSolicitudServicio", query = "SELECT s FROM SolicitudServicios s WHERE s.idSolicitudServicio = :idSolicitudServicio"),
    @NamedQuery(name = "SolicitudServicios.findByDescripcionservicioSolicitud", query = "SELECT s FROM SolicitudServicios s WHERE s.descripcionservicioSolicitud = :descripcionservicioSolicitud"),
    @NamedQuery(name = "SolicitudServicios.findByUbicacionSolicitud", query = "SELECT s FROM SolicitudServicios s WHERE s.ubicacionSolicitud = :ubicacionSolicitud"),
    @NamedQuery(name = "SolicitudServicios.findByFechaSolicitudServicio", query = "SELECT s FROM SolicitudServicios s WHERE s.fechaSolicitudServicio = :fechaSolicitudServicio")})
public class SolicitudServicios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud_servicio")
    private Integer idSolicitudServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion_servicio_Solicitud")
    private String descripcionservicioSolicitud;
    @Size(max = 40)
    @Column(name = "ubicacion_solicitud")
    private String ubicacionSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud_servicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitudServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitudServicio")
    private List<Avance> avanceList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_tipo_serv", referencedColumnName = "id_tipo_serv")
    @ManyToOne(optional = false)
    private TipoDeServicios idTipoServ;

    public SolicitudServicios() {
    }

    public SolicitudServicios(Integer idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public SolicitudServicios(Integer idSolicitudServicio, String descripcionservicioSolicitud, Date fechaSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
        this.descripcionservicioSolicitud = descripcionservicioSolicitud;
        this.fechaSolicitudServicio = fechaSolicitudServicio;
    }

    public Integer getIdSolicitudServicio() {
        return idSolicitudServicio;
    }

    public void setIdSolicitudServicio(Integer idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public String getDescripcionservicioSolicitud() {
        return descripcionservicioSolicitud;
    }

    public void setDescripcionservicioSolicitud(String descripcionservicioSolicitud) {
        this.descripcionservicioSolicitud = descripcionservicioSolicitud;
    }

    public String getUbicacionSolicitud() {
        return ubicacionSolicitud;
    }

    public void setUbicacionSolicitud(String ubicacionSolicitud) {
        this.ubicacionSolicitud = ubicacionSolicitud;
    }

    public Date getFechaSolicitudServicio() {
        return fechaSolicitudServicio;
    }

    public void setFechaSolicitudServicio(Date fechaSolicitudServicio) {
        this.fechaSolicitudServicio = fechaSolicitudServicio;
    }

    @XmlTransient
    public List<Avance> getAvanceList() {
        return avanceList;
    }

    public void setAvanceList(List<Avance> avanceList) {
        this.avanceList = avanceList;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoDeServicios getIdTipoServ() {
        return idTipoServ;
    }

    public void setIdTipoServ(TipoDeServicios idTipoServ) {
        this.idTipoServ = idTipoServ;
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
        if (!(object instanceof SolicitudServicios)) {
            return false;
        }
        SolicitudServicios other = (SolicitudServicios) object;
        if ((this.idSolicitudServicio == null && other.idSolicitudServicio != null) || (this.idSolicitudServicio != null && !this.idSolicitudServicio.equals(other.idSolicitudServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.SolicitudServicios[ idSolicitudServicio=" + idSolicitudServicio + " ]";
    }
    
}
