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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "solicitud_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudServicios.findAll", query = "SELECT s FROM SolicitudServicios s"),
    @NamedQuery(name = "SolicitudServicios.findByIdSolicitudServicio", query = "SELECT s FROM SolicitudServicios s WHERE s.idSolicitudServicio = :idSolicitudServicio"),
    @NamedQuery(name = "SolicitudServicios.findByFechaServicio", query = "SELECT s FROM SolicitudServicios s WHERE s.fechaServicio = :fechaServicio"),
    @NamedQuery(name = "SolicitudServicios.findByHoraServicio", query = "SELECT s FROM SolicitudServicios s WHERE s.horaServicio = :horaServicio"),
    @NamedQuery(name = "SolicitudServicios.findByDescripcionservicioSolicitud", query = "SELECT s FROM SolicitudServicios s WHERE s.descripcionservicioSolicitud = :descripcionservicioSolicitud"),
    @NamedQuery(name = "SolicitudServicios.findByDescripcionServicioPrestado", query = "SELECT s FROM SolicitudServicios s WHERE s.descripcionServicioPrestado = :descripcionServicioPrestado"),
    @NamedQuery(name = "SolicitudServicios.findByUbicaci\u00f3nSolicitud", query = "SELECT s FROM SolicitudServicios s WHERE s.ubicaci\u00f3nSolicitud = :ubicaci\u00f3nSolicitud"),
    @NamedQuery(name = "SolicitudServicios.findByUbicacionServicioPrestado", query = "SELECT s FROM SolicitudServicios s WHERE s.ubicacionServicioPrestado = :ubicacionServicioPrestado"),
    @NamedQuery(name = "SolicitudServicios.findByFueAtendido", query = "SELECT s FROM SolicitudServicios s WHERE s.fueAtendido = :fueAtendido"),
    @NamedQuery(name = "SolicitudServicios.findByFueSolucionado", query = "SELECT s FROM SolicitudServicios s WHERE s.fueSolucionado = :fueSolucionado"),
    @NamedQuery(name = "SolicitudServicios.findByObservaciones", query = "SELECT s FROM SolicitudServicios s WHERE s.observaciones = :observaciones"),
    @NamedQuery(name = "SolicitudServicios.findByReferencia", query = "SELECT s FROM SolicitudServicios s WHERE s.referencia = :referencia"),
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
    @Column(name = "fecha_servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_servicio")
    @Temporal(TemporalType.TIME)
    private Date horaServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion_servicio_Solicitud")
    private String descripcionservicioSolicitud;
    @Size(max = 500)
    @Column(name = "descripcion_servicio_prestado")
    private String descripcionServicioPrestado;
    @Size(max = 40)
    @Column(name = "ubicaci\u00f3n_solicitud")
    private String ubicaciónSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ubicacion_servicio_prestado")
    private String ubicacionServicioPrestado;
    @Column(name = "fue_atendido")
    private Boolean fueAtendido;
    @Column(name = "fue_solucionado")
    private Boolean fueSolucionado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "referencia")
    private int referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud_servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitudServicio;
    @ManyToMany(mappedBy = "solicitudServiciosList")
    private List<Usuarios> usuariosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "solicitudServicios")
    private TiposDeServiciosSolicitudDeServicios tiposDeServiciosSolicitudDeServicios;
    @JoinColumn(name = "id_prioridades", referencedColumnName = "id_prioridades")
    @ManyToOne(optional = false)
    private Prioridades idPrioridades;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicios idServicio;

    public SolicitudServicios() {
    }

    public SolicitudServicios(Integer idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public SolicitudServicios(Integer idSolicitudServicio, Date fechaServicio, Date horaServicio, String descripcionservicioSolicitud, String ubicacionServicioPrestado, String observaciones, int referencia, Date fechaSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
        this.fechaServicio = fechaServicio;
        this.horaServicio = horaServicio;
        this.descripcionservicioSolicitud = descripcionservicioSolicitud;
        this.ubicacionServicioPrestado = ubicacionServicioPrestado;
        this.observaciones = observaciones;
        this.referencia = referencia;
        this.fechaSolicitudServicio = fechaSolicitudServicio;
    }

    public Integer getIdSolicitudServicio() {
        return idSolicitudServicio;
    }

    public void setIdSolicitudServicio(Integer idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Date getHoraServicio() {
        return horaServicio;
    }

    public void setHoraServicio(Date horaServicio) {
        this.horaServicio = horaServicio;
    }

    public String getDescripcionservicioSolicitud() {
        return descripcionservicioSolicitud;
    }

    public void setDescripcionservicioSolicitud(String descripcionservicioSolicitud) {
        this.descripcionservicioSolicitud = descripcionservicioSolicitud;
    }

    public String getDescripcionServicioPrestado() {
        return descripcionServicioPrestado;
    }

    public void setDescripcionServicioPrestado(String descripcionServicioPrestado) {
        this.descripcionServicioPrestado = descripcionServicioPrestado;
    }

    public String getUbicaciónSolicitud() {
        return ubicaciónSolicitud;
    }

    public void setUbicaciónSolicitud(String ubicaciónSolicitud) {
        this.ubicaciónSolicitud = ubicaciónSolicitud;
    }

    public String getUbicacionServicioPrestado() {
        return ubicacionServicioPrestado;
    }

    public void setUbicacionServicioPrestado(String ubicacionServicioPrestado) {
        this.ubicacionServicioPrestado = ubicacionServicioPrestado;
    }

    public Boolean getFueAtendido() {
        return fueAtendido;
    }

    public void setFueAtendido(Boolean fueAtendido) {
        this.fueAtendido = fueAtendido;
    }

    public Boolean getFueSolucionado() {
        return fueSolucionado;
    }

    public void setFueSolucionado(Boolean fueSolucionado) {
        this.fueSolucionado = fueSolucionado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public Date getFechaSolicitudServicio() {
        return fechaSolicitudServicio;
    }

    public void setFechaSolicitudServicio(Date fechaSolicitudServicio) {
        this.fechaSolicitudServicio = fechaSolicitudServicio;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public TiposDeServiciosSolicitudDeServicios getTiposDeServiciosSolicitudDeServicios() {
        return tiposDeServiciosSolicitudDeServicios;
    }

    public void setTiposDeServiciosSolicitudDeServicios(TiposDeServiciosSolicitudDeServicios tiposDeServiciosSolicitudDeServicios) {
        this.tiposDeServiciosSolicitudDeServicios = tiposDeServiciosSolicitudDeServicios;
    }

    public Prioridades getIdPrioridades() {
        return idPrioridades;
    }

    public void setIdPrioridades(Prioridades idPrioridades) {
        this.idPrioridades = idPrioridades;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
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
