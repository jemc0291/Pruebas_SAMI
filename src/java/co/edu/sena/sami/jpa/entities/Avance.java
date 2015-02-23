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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "avance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avance.findAll", query = "SELECT a FROM Avance a"),
    @NamedQuery(name = "Avance.findByIdAvance", query = "SELECT a FROM Avance a WHERE a.idAvance = :idAvance"),
    @NamedQuery(name = "Avance.findByFechaAvance", query = "SELECT a FROM Avance a WHERE a.fechaAvance = :fechaAvance"),
    @NamedQuery(name = "Avance.findByDescripcion", query = "SELECT a FROM Avance a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Avance.findByFueAtendido", query = "SELECT a FROM Avance a WHERE a.fueAtendido = :fueAtendido"),
    @NamedQuery(name = "Avance.findByFueSolucionado", query = "SELECT a FROM Avance a WHERE a.fueSolucionado = :fueSolucionado")})
public class Avance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avance")
    private Integer idAvance;
    @Column(name = "fecha_avance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAvance;
    @Size(max = 145)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fue_atendido")
    private Boolean fueAtendido;
    @Column(name = "fue_solucionado")
    private Boolean fueSolucionado;
    @JoinColumn(name = "id_solicitud_servicio", referencedColumnName = "id_solicitud_servicio")
    @ManyToOne(optional = false)
    private SolicitudServicios idSolicitudServicio;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estados idEstado;
    @JoinColumn(name = "id_prioridades", referencedColumnName = "id_prioridades")
    @ManyToOne(optional = false)
    private Prioridades idPrioridades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avance")
    private List<AvanceUsuarios> avanceUsuariosList;

    public Avance() {
    }

    public Avance(Integer idAvance) {
        this.idAvance = idAvance;
    }

    public Integer getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(Integer idAvance) {
        this.idAvance = idAvance;
    }

    public Date getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(Date fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public SolicitudServicios getIdSolicitudServicio() {
        return idSolicitudServicio;
    }

    public void setIdSolicitudServicio(SolicitudServicios idSolicitudServicio) {
        this.idSolicitudServicio = idSolicitudServicio;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
    }

    public Prioridades getIdPrioridades() {
        return idPrioridades;
    }

    public void setIdPrioridades(Prioridades idPrioridades) {
        this.idPrioridades = idPrioridades;
    }

    @XmlTransient
    public List<AvanceUsuarios> getAvanceUsuariosList() {
        return avanceUsuariosList;
    }

    public void setAvanceUsuariosList(List<AvanceUsuarios> avanceUsuariosList) {
        this.avanceUsuariosList = avanceUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvance != null ? idAvance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avance)) {
            return false;
        }
        Avance other = (Avance) object;
        if ((this.idAvance == null && other.idAvance != null) || (this.idAvance != null && !this.idAvance.equals(other.idAvance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Avance[ idAvance=" + idAvance + " ]";
    }
    
}
