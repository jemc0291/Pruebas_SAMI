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
import javax.persistence.JoinColumns;
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
 * @author Usuario
 */
@Entity
@Table(name = "comisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comisiones.findAll", query = "SELECT c FROM Comisiones c"),
    @NamedQuery(name = "Comisiones.findByIdComision", query = "SELECT c FROM Comisiones c WHERE c.idComision = :idComision"),
    @NamedQuery(name = "Comisiones.findByObjetivoComision", query = "SELECT c FROM Comisiones c WHERE c.objetivoComision = :objetivoComision"),
    @NamedQuery(name = "Comisiones.findByFechaTramite", query = "SELECT c FROM Comisiones c WHERE c.fechaTramite = :fechaTramite"),
    @NamedQuery(name = "Comisiones.findByTranspIntermunicipal", query = "SELECT c FROM Comisiones c WHERE c.transpIntermunicipal = :transpIntermunicipal"),
    @NamedQuery(name = "Comisiones.findByNumComServicios", query = "SELECT c FROM Comisiones c WHERE c.numComServicios = :numComServicios"),
    @NamedQuery(name = "Comisiones.findByObservacionesOrden", query = "SELECT c FROM Comisiones c WHERE c.observacionesOrden = :observacionesOrden"),
    @NamedQuery(name = "Comisiones.findBySuministraVehiculo", query = "SELECT c FROM Comisiones c WHERE c.suministraVehiculo = :suministraVehiculo"),
    @NamedQuery(name = "Comisiones.findByObjetivos", query = "SELECT c FROM Comisiones c WHERE c.objetivos = :objetivos"),
    @NamedQuery(name = "Comisiones.findByMesaPlanificar", query = "SELECT c FROM Comisiones c WHERE c.mesaPlanificar = :mesaPlanificar"),
    @NamedQuery(name = "Comisiones.findByLlegadaEstimada", query = "SELECT c FROM Comisiones c WHERE c.llegadaEstimada = :llegadaEstimada"),
    @NamedQuery(name = "Comisiones.findBySalidaEstimada", query = "SELECT c FROM Comisiones c WHERE c.salidaEstimada = :salidaEstimada"),
    @NamedQuery(name = "Comisiones.findByNumDias", query = "SELECT c FROM Comisiones c WHERE c.numDias = :numDias"),
    @NamedQuery(name = "Comisiones.findByAprobado", query = "SELECT c FROM Comisiones c WHERE c.aprobado = :aprobado"),
    @NamedQuery(name = "Comisiones.findByTransIntermunicipal", query = "SELECT c FROM Comisiones c WHERE c.transIntermunicipal = :transIntermunicipal"),
    @NamedQuery(name = "Comisiones.findByTransComision", query = "SELECT c FROM Comisiones c WHERE c.transComision = :transComision"),
    @NamedQuery(name = "Comisiones.findByOtrosGastos", query = "SELECT c FROM Comisiones c WHERE c.otrosGastos = :otrosGastos"),
    @NamedQuery(name = "Comisiones.findByVehiculoSena", query = "SELECT c FROM Comisiones c WHERE c.vehiculoSena = :vehiculoSena"),
    @NamedQuery(name = "Comisiones.findByVehiculoComisionado", query = "SELECT c FROM Comisiones c WHERE c.vehiculoComisionado = :vehiculoComisionado"),
    @NamedQuery(name = "Comisiones.findByAuxilioManutencion", query = "SELECT c FROM Comisiones c WHERE c.auxilioManutencion = :auxilioManutencion"),
    @NamedQuery(name = "Comisiones.findByFechaEntregaInforme", query = "SELECT c FROM Comisiones c WHERE c.fechaEntregaInforme = :fechaEntregaInforme"),
    @NamedQuery(name = "Comisiones.findByActividadesOTemas", query = "SELECT c FROM Comisiones c WHERE c.actividadesOTemas = :actividadesOTemas"),
    @NamedQuery(name = "Comisiones.findByCompromisoSena", query = "SELECT c FROM Comisiones c WHERE c.compromisoSena = :compromisoSena"),
    @NamedQuery(name = "Comisiones.findByProdEntragados", query = "SELECT c FROM Comisiones c WHERE c.prodEntragados = :prodEntragados"),
    @NamedQuery(name = "Comisiones.findBySaldoNegativo", query = "SELECT c FROM Comisiones c WHERE c.saldoNegativo = :saldoNegativo"),
    @NamedQuery(name = "Comisiones.findBySaldoPositivo", query = "SELECT c FROM Comisiones c WHERE c.saldoPositivo = :saldoPositivo"),
    @NamedQuery(name = "Comisiones.findByPresupuesto", query = "SELECT c FROM Comisiones c WHERE c.presupuesto = :presupuesto")})
public class Comisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comision")
    private Integer idComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "objetivo_comision")
    private String objetivoComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_tramite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTramite;
    @Column(name = "transp_intermunicipal")
    private Boolean transpIntermunicipal;
    @Column(name = "num_com_servicios")
    private Integer numComServicios;
    @Size(max = 1000)
    @Column(name = "observaciones_orden")
    private String observacionesOrden;
    @Column(name = "suministra_vehiculo")
    private Boolean suministraVehiculo;
    @Size(max = 3000)
    @Column(name = "objetivos")
    private String objetivos;
    @Size(max = 45)
    @Column(name = "mesa_planificar")
    private String mesaPlanificar;
    @Column(name = "llegada_estimada")
    @Temporal(TemporalType.DATE)
    private Date llegadaEstimada;
    @Column(name = "salida_estimada")
    @Temporal(TemporalType.DATE)
    private Date salidaEstimada;
    @Column(name = "num_dias")
    private Integer numDias;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Column(name = "trans_intermunicipal")
    private Integer transIntermunicipal;
    @Column(name = "trans_comision")
    private Integer transComision;
    @Column(name = "otros_gastos")
    private Integer otrosGastos;
    @Column(name = "vehiculo_sena")
    private Integer vehiculoSena;
    @Column(name = "vehiculo_comisionado")
    private Integer vehiculoComisionado;
    @Column(name = "auxilio_manutencion")
    private Integer auxilioManutencion;
    @Column(name = "fecha_entrega_informe")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaInforme;
    @Size(max = 3000)
    @Column(name = "actividades_o_temas")
    private String actividadesOTemas;
    @Size(max = 3000)
    @Column(name = "compromiso_sena")
    private String compromisoSena;
    @Size(max = 3000)
    @Column(name = "prod_entragados")
    private String prodEntragados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_negativo")
    private Double saldoNegativo;
    @Column(name = "saldo_positivo")
    private Double saldoPositivo;
    @Size(max = 45)
    @Column(name = "presupuesto")
    private String presupuesto;
    @ManyToMany(mappedBy = "comisionesList")
    private List<Cdp> cdpList;
    @ManyToMany(mappedBy = "comisionesList")
    private List<Ciudad> ciudadList;
    @OneToMany(mappedBy = "idComision")
    private List<Notificaciones> notificacionesList;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private Grupos idGrupo;
    @JoinColumn(name = "id_tipo_pasaje", referencedColumnName = "id_tipo_pasaje")
    @ManyToOne
    private TiposPasajes idTipoPasaje;
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
    @ManyToOne(optional = false)
    private Bancos idBanco;
    @JoinColumn(name = "id_descripcion", referencedColumnName = "id_descripcion")
    @ManyToOne(optional = false)
    private DescripcionesReferenciasViaticos idDescripcion;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contratos idContrato;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormacion;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Comisiones() {
    }

    public Comisiones(Integer idComision) {
        this.idComision = idComision;
    }

    public Comisiones(Integer idComision, String objetivoComision, Date fechaTramite) {
        this.idComision = idComision;
        this.objetivoComision = objetivoComision;
        this.fechaTramite = fechaTramite;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getObjetivoComision() {
        return objetivoComision;
    }

    public void setObjetivoComision(String objetivoComision) {
        this.objetivoComision = objetivoComision;
    }

    public Date getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public Boolean getTranspIntermunicipal() {
        return transpIntermunicipal;
    }

    public void setTranspIntermunicipal(Boolean transpIntermunicipal) {
        this.transpIntermunicipal = transpIntermunicipal;
    }

    public Integer getNumComServicios() {
        return numComServicios;
    }

    public void setNumComServicios(Integer numComServicios) {
        this.numComServicios = numComServicios;
    }

    public String getObservacionesOrden() {
        return observacionesOrden;
    }

    public void setObservacionesOrden(String observacionesOrden) {
        this.observacionesOrden = observacionesOrden;
    }

    public Boolean getSuministraVehiculo() {
        return suministraVehiculo;
    }

    public void setSuministraVehiculo(Boolean suministraVehiculo) {
        this.suministraVehiculo = suministraVehiculo;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getMesaPlanificar() {
        return mesaPlanificar;
    }

    public void setMesaPlanificar(String mesaPlanificar) {
        this.mesaPlanificar = mesaPlanificar;
    }

    public Date getLlegadaEstimada() {
        return llegadaEstimada;
    }

    public void setLlegadaEstimada(Date llegadaEstimada) {
        this.llegadaEstimada = llegadaEstimada;
    }

    public Date getSalidaEstimada() {
        return salidaEstimada;
    }

    public void setSalidaEstimada(Date salidaEstimada) {
        this.salidaEstimada = salidaEstimada;
    }

    public Integer getNumDias() {
        return numDias;
    }

    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Integer getTransIntermunicipal() {
        return transIntermunicipal;
    }

    public void setTransIntermunicipal(Integer transIntermunicipal) {
        this.transIntermunicipal = transIntermunicipal;
    }

    public Integer getTransComision() {
        return transComision;
    }

    public void setTransComision(Integer transComision) {
        this.transComision = transComision;
    }

    public Integer getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(Integer otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public Integer getVehiculoSena() {
        return vehiculoSena;
    }

    public void setVehiculoSena(Integer vehiculoSena) {
        this.vehiculoSena = vehiculoSena;
    }

    public Integer getVehiculoComisionado() {
        return vehiculoComisionado;
    }

    public void setVehiculoComisionado(Integer vehiculoComisionado) {
        this.vehiculoComisionado = vehiculoComisionado;
    }

    public Integer getAuxilioManutencion() {
        return auxilioManutencion;
    }

    public void setAuxilioManutencion(Integer auxilioManutencion) {
        this.auxilioManutencion = auxilioManutencion;
    }

    public Date getFechaEntregaInforme() {
        return fechaEntregaInforme;
    }

    public void setFechaEntregaInforme(Date fechaEntregaInforme) {
        this.fechaEntregaInforme = fechaEntregaInforme;
    }

    public String getActividadesOTemas() {
        return actividadesOTemas;
    }

    public void setActividadesOTemas(String actividadesOTemas) {
        this.actividadesOTemas = actividadesOTemas;
    }

    public String getCompromisoSena() {
        return compromisoSena;
    }

    public void setCompromisoSena(String compromisoSena) {
        this.compromisoSena = compromisoSena;
    }

    public String getProdEntragados() {
        return prodEntragados;
    }

    public void setProdEntragados(String prodEntragados) {
        this.prodEntragados = prodEntragados;
    }

    public Double getSaldoNegativo() {
        return saldoNegativo;
    }

    public void setSaldoNegativo(Double saldoNegativo) {
        this.saldoNegativo = saldoNegativo;
    }

    public Double getSaldoPositivo() {
        return saldoPositivo;
    }

    public void setSaldoPositivo(Double saldoPositivo) {
        this.saldoPositivo = saldoPositivo;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    public Grupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    public TiposPasajes getIdTipoPasaje() {
        return idTipoPasaje;
    }

    public void setIdTipoPasaje(TiposPasajes idTipoPasaje) {
        this.idTipoPasaje = idTipoPasaje;
    }

    public Bancos getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Bancos idBanco) {
        this.idBanco = idBanco;
    }

    public DescripcionesReferenciasViaticos getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(DescripcionesReferenciasViaticos idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public Contratos getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contratos idContrato) {
        this.idContrato = idContrato;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComision != null ? idComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comisiones)) {
            return false;
        }
        Comisiones other = (Comisiones) object;
        if ((this.idComision == null && other.idComision != null) || (this.idComision != null && !this.idComision.equals(other.idComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Comisiones[ idComision=" + idComision + " ]";
    }
    
}
