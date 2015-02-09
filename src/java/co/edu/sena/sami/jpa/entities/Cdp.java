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
 * @author Adsim
 */
@Entity
@Table(name = "cdp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdp.findAll", query = "SELECT c FROM Cdp c"),
    @NamedQuery(name = "Cdp.findByNumeroCdp", query = "SELECT c FROM Cdp c WHERE c.numeroCdp = :numeroCdp"),
    @NamedQuery(name = "Cdp.findByFechaExpedicion", query = "SELECT c FROM Cdp c WHERE c.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "Cdp.findByFechaRecepcion", query = "SELECT c FROM Cdp c WHERE c.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Cdp.findByObjetivoDelGasto", query = "SELECT c FROM Cdp c WHERE c.objetivoDelGasto = :objetivoDelGasto"),
    @NamedQuery(name = "Cdp.findByTotal", query = "SELECT c FROM Cdp c WHERE c.total = :total"),
    @NamedQuery(name = "Cdp.findBySubtotal", query = "SELECT c FROM Cdp c WHERE c.subtotal = :subtotal")})
public class Cdp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_cdp")
    private String numeroCdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_expedicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "objetivo_del_gasto")
    private String objetivoDelGasto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @JoinTable(name = "gestiones_cdp", joinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_gestion", referencedColumnName = "codigo_gestion")})
    @ManyToMany
    private List<Gestiones> gestionesList;
    @JoinTable(name = "rubros_cdp", joinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")})
    @ManyToMany
    private List<Rubros> rubrosList;
    @ManyToMany(mappedBy = "cdpList")
    private List<Usuarios> usuariosList;
    @JoinTable(name = "conceptos_de_gastos_cdp", joinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_gasto", referencedColumnName = "codigo_gasto")})
    @ManyToMany
    private List<ConceptosDeGastos> conceptosDeGastosList;
    @JoinTable(name = "cdp_dependencias", joinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_de_dependencia", referencedColumnName = "codigo_de_dependencia")})
    @ManyToMany
    private List<Dependencias> dependenciasList;
    @JoinTable(name = "ordenes_de_viaje_cdp", joinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")}, inverseJoinColumns = {
        @JoinColumn(name = "numero_ordendeviaje", referencedColumnName = "numero_ordendeviaje")})
    @ManyToMany
    private List<OrdenesDeviaje> ordenesDeviajeList;
    @JoinColumn(name = "id_recursos", referencedColumnName = "id_recursos")
    @ManyToOne(optional = false)
    private RecursosOFuentes idRecursos;
    @JoinColumn(name = "id_tipo_solicitud", referencedColumnName = "id_tipo_solicitud")
    @ManyToOne(optional = false)
    private TiposDeSolicitudes idTipoSolicitud;

    public Cdp() {
    }

    public Cdp(String numeroCdp) {
        this.numeroCdp = numeroCdp;
    }

    public Cdp(String numeroCdp, Date fechaExpedicion, Date fechaRecepcion, String objetivoDelGasto, double total) {
        this.numeroCdp = numeroCdp;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaRecepcion = fechaRecepcion;
        this.objetivoDelGasto = objetivoDelGasto;
        this.total = total;
    }

    public String getNumeroCdp() {
        return numeroCdp;
    }

    public void setNumeroCdp(String numeroCdp) {
        this.numeroCdp = numeroCdp;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @XmlTransient
    public List<Gestiones> getGestionesList() {
        return gestionesList;
    }

    public void setGestionesList(List<Gestiones> gestionesList) {
        this.gestionesList = gestionesList;
    }

    @XmlTransient
    public List<Rubros> getRubrosList() {
        return rubrosList;
    }

    public void setRubrosList(List<Rubros> rubrosList) {
        this.rubrosList = rubrosList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<ConceptosDeGastos> getConceptosDeGastosList() {
        return conceptosDeGastosList;
    }

    public void setConceptosDeGastosList(List<ConceptosDeGastos> conceptosDeGastosList) {
        this.conceptosDeGastosList = conceptosDeGastosList;
    }

    @XmlTransient
    public List<Dependencias> getDependenciasList() {
        return dependenciasList;
    }

    public void setDependenciasList(List<Dependencias> dependenciasList) {
        this.dependenciasList = dependenciasList;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    public RecursosOFuentes getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(RecursosOFuentes idRecursos) {
        this.idRecursos = idRecursos;
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
