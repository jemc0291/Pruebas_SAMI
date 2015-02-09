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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Adsim
 */
@Entity
@Table(name = "ordenes_deviaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeviaje.findAll", query = "SELECT o FROM OrdenesDeviaje o"),
    @NamedQuery(name = "OrdenesDeviaje.findByNumeroOrdendeviaje", query = "SELECT o FROM OrdenesDeviaje o WHERE o.numeroOrdendeviaje = :numeroOrdendeviaje"),
    @NamedQuery(name = "OrdenesDeviaje.findByFechaTramite", query = "SELECT o FROM OrdenesDeviaje o WHERE o.fechaTramite = :fechaTramite"),
    @NamedQuery(name = "OrdenesDeviaje.findByObservacionesDeLaOrden", query = "SELECT o FROM OrdenesDeviaje o WHERE o.observacionesDeLaOrden = :observacionesDeLaOrden"),
    @NamedQuery(name = "OrdenesDeviaje.findByRuta", query = "SELECT o FROM OrdenesDeviaje o WHERE o.ruta = :ruta"),
    @NamedQuery(name = "OrdenesDeviaje.findBySubtotal", query = "SELECT o FROM OrdenesDeviaje o WHERE o.subtotal = :subtotal"),
    @NamedQuery(name = "OrdenesDeviaje.findByMenosRetefuente", query = "SELECT o FROM OrdenesDeviaje o WHERE o.menosRetefuente = :menosRetefuente"),
    @NamedQuery(name = "OrdenesDeviaje.findByValorNetoAReconocer", query = "SELECT o FROM OrdenesDeviaje o WHERE o.valorNetoAReconocer = :valorNetoAReconocer"),
    @NamedQuery(name = "OrdenesDeviaje.findByObjetvos", query = "SELECT o FROM OrdenesDeviaje o WHERE o.objetvos = :objetvos"),
    @NamedQuery(name = "OrdenesDeviaje.findByTotalAnticipoAPagar", query = "SELECT o FROM OrdenesDeviaje o WHERE o.totalAnticipoAPagar = :totalAnticipoAPagar"),
    @NamedQuery(name = "OrdenesDeviaje.findByEntidadSuministraVehiculo", query = "SELECT o FROM OrdenesDeviaje o WHERE o.entidadSuministraVehiculo = :entidadSuministraVehiculo")})
public class OrdenesDeviaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_ordendeviaje")
    private Integer numeroOrdendeviaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_tramite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTramite;
    @Size(max = 5000)
    @Column(name = "observaciones_de_la_orden")
    private String observacionesDeLaOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ruta")
    private String ruta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "menos_retefuente")
    private Double menosRetefuente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_neto_a_reconocer")
    private double valorNetoAReconocer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4500)
    @Column(name = "objetvos")
    private String objetvos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_anticipo_a_pagar")
    private double totalAnticipoAPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entidad_suministra_vehiculo")
    private boolean entidadSuministraVehiculo;
    @JoinTable(name = "ordenes_deviaje_trayectos", joinColumns = {
        @JoinColumn(name = "numero_ordendeviaje", referencedColumnName = "numero_ordendeviaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_trayecto", referencedColumnName = "id_trayecto")})
    @ManyToMany
    private List<Trayectos> trayectosList;
    @ManyToMany(mappedBy = "ordenesDeviajeList")
    private List<Categorias> categoriasList;
    @ManyToMany(mappedBy = "ordenesDeviajeList")
    private List<Ciudad> ciudadList;
    @ManyToMany(mappedBy = "ordenesDeviajeList")
    private List<Cdp> cdpList;
    @ManyToMany(mappedBy = "ordenesDeviajeList")
    private List<Crp> crpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroOrdendeviaje")
    private List<RelacionesGastosDeTransporte> relacionesGastosDeTransporteList;
    @JoinColumn(name = "id_tipo_pasaje", referencedColumnName = "id_tipo_pasaje")
    @ManyToOne(optional = false)
    private TiposPasajes idTipoPasaje;
    @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")
    @ManyToOne(optional = false)
    private Departamentos idDpto;
    @JoinColumn(name = "codigo_de_dependencia", referencedColumnName = "codigo_de_dependencia")
    @ManyToOne(optional = false)
    private Dependencias codigoDeDependencia;
    @JoinColumn(name = "id_trayecto", referencedColumnName = "id_trayecto")
    @ManyToOne(optional = false)
    private Trayectos idTrayecto;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(optional = false)
    private CuentasBancarias idCuenta;
    @JoinColumn(name = "id_relaciones_gastos_de_transporte", referencedColumnName = "id_relaciones_gastos_de_transporte")
    @ManyToOne(optional = false)
    private RelacionesGastosDeTransporte idRelacionesGastosDeTransporte;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_comision", referencedColumnName = "id_comision")
    @ManyToOne(optional = false)
    private Comisiones idComision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesDeviaje")
    private List<OrdenesDeViajeConceptosDeGastos> ordenesDeViajeConceptosDeGastosList;

    public OrdenesDeviaje() {
    }

    public OrdenesDeviaje(Integer numeroOrdendeviaje) {
        this.numeroOrdendeviaje = numeroOrdendeviaje;
    }

    public OrdenesDeviaje(Integer numeroOrdendeviaje, Date fechaTramite, String ruta, double valorNetoAReconocer, String objetvos, double totalAnticipoAPagar, boolean entidadSuministraVehiculo) {
        this.numeroOrdendeviaje = numeroOrdendeviaje;
        this.fechaTramite = fechaTramite;
        this.ruta = ruta;
        this.valorNetoAReconocer = valorNetoAReconocer;
        this.objetvos = objetvos;
        this.totalAnticipoAPagar = totalAnticipoAPagar;
        this.entidadSuministraVehiculo = entidadSuministraVehiculo;
    }

    public Integer getNumeroOrdendeviaje() {
        return numeroOrdendeviaje;
    }

    public void setNumeroOrdendeviaje(Integer numeroOrdendeviaje) {
        this.numeroOrdendeviaje = numeroOrdendeviaje;
    }

    public Date getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public String getObservacionesDeLaOrden() {
        return observacionesDeLaOrden;
    }

    public void setObservacionesDeLaOrden(String observacionesDeLaOrden) {
        this.observacionesDeLaOrden = observacionesDeLaOrden;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMenosRetefuente() {
        return menosRetefuente;
    }

    public void setMenosRetefuente(Double menosRetefuente) {
        this.menosRetefuente = menosRetefuente;
    }

    public double getValorNetoAReconocer() {
        return valorNetoAReconocer;
    }

    public void setValorNetoAReconocer(double valorNetoAReconocer) {
        this.valorNetoAReconocer = valorNetoAReconocer;
    }

    public String getObjetvos() {
        return objetvos;
    }

    public void setObjetvos(String objetvos) {
        this.objetvos = objetvos;
    }

    public double getTotalAnticipoAPagar() {
        return totalAnticipoAPagar;
    }

    public void setTotalAnticipoAPagar(double totalAnticipoAPagar) {
        this.totalAnticipoAPagar = totalAnticipoAPagar;
    }

    public boolean getEntidadSuministraVehiculo() {
        return entidadSuministraVehiculo;
    }

    public void setEntidadSuministraVehiculo(boolean entidadSuministraVehiculo) {
        this.entidadSuministraVehiculo = entidadSuministraVehiculo;
    }

    @XmlTransient
    public List<Trayectos> getTrayectosList() {
        return trayectosList;
    }

    public void setTrayectosList(List<Trayectos> trayectosList) {
        this.trayectosList = trayectosList;
    }

    @XmlTransient
    public List<Categorias> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<Categorias> categoriasList) {
        this.categoriasList = categoriasList;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    @XmlTransient
    public List<Crp> getCrpList() {
        return crpList;
    }

    public void setCrpList(List<Crp> crpList) {
        this.crpList = crpList;
    }

    @XmlTransient
    public List<RelacionesGastosDeTransporte> getRelacionesGastosDeTransporteList() {
        return relacionesGastosDeTransporteList;
    }

    public void setRelacionesGastosDeTransporteList(List<RelacionesGastosDeTransporte> relacionesGastosDeTransporteList) {
        this.relacionesGastosDeTransporteList = relacionesGastosDeTransporteList;
    }

    public TiposPasajes getIdTipoPasaje() {
        return idTipoPasaje;
    }

    public void setIdTipoPasaje(TiposPasajes idTipoPasaje) {
        this.idTipoPasaje = idTipoPasaje;
    }

    public Departamentos getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Departamentos idDpto) {
        this.idDpto = idDpto;
    }

    public Dependencias getCodigoDeDependencia() {
        return codigoDeDependencia;
    }

    public void setCodigoDeDependencia(Dependencias codigoDeDependencia) {
        this.codigoDeDependencia = codigoDeDependencia;
    }

    public Trayectos getIdTrayecto() {
        return idTrayecto;
    }

    public void setIdTrayecto(Trayectos idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public CuentasBancarias getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentasBancarias idCuenta) {
        this.idCuenta = idCuenta;
    }

    public RelacionesGastosDeTransporte getIdRelacionesGastosDeTransporte() {
        return idRelacionesGastosDeTransporte;
    }

    public void setIdRelacionesGastosDeTransporte(RelacionesGastosDeTransporte idRelacionesGastosDeTransporte) {
        this.idRelacionesGastosDeTransporte = idRelacionesGastosDeTransporte;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Comisiones getIdComision() {
        return idComision;
    }

    public void setIdComision(Comisiones idComision) {
        this.idComision = idComision;
    }

    @XmlTransient
    public List<OrdenesDeViajeConceptosDeGastos> getOrdenesDeViajeConceptosDeGastosList() {
        return ordenesDeViajeConceptosDeGastosList;
    }

    public void setOrdenesDeViajeConceptosDeGastosList(List<OrdenesDeViajeConceptosDeGastos> ordenesDeViajeConceptosDeGastosList) {
        this.ordenesDeViajeConceptosDeGastosList = ordenesDeViajeConceptosDeGastosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroOrdendeviaje != null ? numeroOrdendeviaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeviaje)) {
            return false;
        }
        OrdenesDeviaje other = (OrdenesDeviaje) object;
        if ((this.numeroOrdendeviaje == null && other.numeroOrdendeviaje != null) || (this.numeroOrdendeviaje != null && !this.numeroOrdendeviaje.equals(other.numeroOrdendeviaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.OrdenesDeviaje[ numeroOrdendeviaje=" + numeroOrdendeviaje + " ]";
    }
    
}
