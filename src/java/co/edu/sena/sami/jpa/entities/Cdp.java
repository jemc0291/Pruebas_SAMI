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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "cdp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdp.findAll", query = "SELECT c FROM Cdp c"),
    @NamedQuery(name = "Cdp.findByNumeroCdp", query = "SELECT c FROM Cdp c WHERE c.numeroCdp = :numeroCdp"),
    @NamedQuery(name = "Cdp.findByFechaSolicitud", query = "SELECT c FROM Cdp c WHERE c.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Cdp.findByFechaRecepcion", query = "SELECT c FROM Cdp c WHERE c.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Cdp.findByObjetivoDelGasto", query = "SELECT c FROM Cdp c WHERE c.objetivoDelGasto = :objetivoDelGasto")})
public class Cdp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_cdp")
    private Integer numeroCdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "objetivo_del_gasto")
    private String objetivoDelGasto;
    @JoinTable(name = "comisiones_cdp", joinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")}, inverseJoinColumns = {
        @JoinColumn(name = "id_comision", referencedColumnName = "id_comision")})
    @ManyToMany
    private List<Comisiones> comisionesList;
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    @ManyToOne(optional = false)
    private Rubros idRubro;
    @JoinColumn(name = "codigo_gestion", referencedColumnName = "codigo_gestion")
    @ManyToOne(optional = false)
    private Gestiones codigoGestion;
    @JoinColumn(name = "codigo_de_dependencia", referencedColumnName = "codigo_de_dependencia")
    @ManyToOne(optional = false)
    private Dependencias codigoDeDependencia;
    @JoinColumn(name = "id_tipo_solicitud", referencedColumnName = "id_tipo_solicitud")
    @ManyToOne(optional = false)
    private TiposDeSolicitudes idTipoSolicitud;

    public Cdp() {
    }

    public Cdp(Integer numeroCdp) {
        this.numeroCdp = numeroCdp;
    }

    public Cdp(Integer numeroCdp, Date fechaSolicitud, Date fechaRecepcion, String objetivoDelGasto) {
        this.numeroCdp = numeroCdp;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRecepcion = fechaRecepcion;
        this.objetivoDelGasto = objetivoDelGasto;
    }

    public Integer getNumeroCdp() {
        return numeroCdp;
    }

    public void setNumeroCdp(Integer numeroCdp) {
        this.numeroCdp = numeroCdp;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getObjetivoDelGasto() {
        return objetivoDelGasto;
    }

    public void setObjetivoDelGasto(String objetivoDelGasto) {
        this.objetivoDelGasto = objetivoDelGasto;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    public Rubros getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Rubros idRubro) {
        this.idRubro = idRubro;
    }

    public Gestiones getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(Gestiones codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public Dependencias getCodigoDeDependencia() {
        return codigoDeDependencia;
    }

    public void setCodigoDeDependencia(Dependencias codigoDeDependencia) {
        this.codigoDeDependencia = codigoDeDependencia;
    }

    public TiposDeSolicitudes getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(TiposDeSolicitudes idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCdp != null ? numeroCdp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdp)) {
            return false;
        }
        Cdp other = (Cdp) object;
        if ((this.numeroCdp == null && other.numeroCdp != null) || (this.numeroCdp != null && !this.numeroCdp.equals(other.numeroCdp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Cdp[ numeroCdp=" + numeroCdp + " ]";
    }
    
}
