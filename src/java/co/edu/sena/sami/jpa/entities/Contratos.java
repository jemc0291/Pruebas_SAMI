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
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratos.findAll", query = "SELECT c FROM Contratos c"),
    @NamedQuery(name = "Contratos.findByIdContrato", query = "SELECT c FROM Contratos c WHERE c.idContrato = :idContrato"),
    @NamedQuery(name = "Contratos.findByNumeroDeContrato", query = "SELECT c FROM Contratos c WHERE c.numeroDeContrato = :numeroDeContrato"),
    @NamedQuery(name = "Contratos.findByFechasuscripcion", query = "SELECT c FROM Contratos c WHERE c.fechasuscripcion = :fechasuscripcion"),
    @NamedQuery(name = "Contratos.findByFechaInicioContrato", query = "SELECT c FROM Contratos c WHERE c.fechaInicioContrato = :fechaInicioContrato"),
    @NamedQuery(name = "Contratos.findByFechaFinContrato", query = "SELECT c FROM Contratos c WHERE c.fechaFinContrato = :fechaFinContrato"),
    @NamedQuery(name = "Contratos.findByPlazoDias", query = "SELECT c FROM Contratos c WHERE c.plazoDias = :plazoDias"),
    @NamedQuery(name = "Contratos.findByPlazoMeses", query = "SELECT c FROM Contratos c WHERE c.plazoMeses = :plazoMeses"),
    @NamedQuery(name = "Contratos.findByObjetoContractual", query = "SELECT c FROM Contratos c WHERE c.objetoContractual = :objetoContractual"),
    @NamedQuery(name = "Contratos.findByObligaciones", query = "SELECT c FROM Contratos c WHERE c.obligaciones = :obligaciones"),
    @NamedQuery(name = "Contratos.findByValorContrato", query = "SELECT c FROM Contratos c WHERE c.valorContrato = :valorContrato"),
    @NamedQuery(name = "Contratos.findByPrimerPago", query = "SELECT c FROM Contratos c WHERE c.primerPago = :primerPago"),
    @NamedQuery(name = "Contratos.findByUltimoPago", query = "SELECT c FROM Contratos c WHERE c.ultimoPago = :ultimoPago"),
    @NamedQuery(name = "Contratos.findByNumeroDeMensualidades", query = "SELECT c FROM Contratos c WHERE c.numeroDeMensualidades = :numeroDeMensualidades"),
    @NamedQuery(name = "Contratos.findByValorMensual", query = "SELECT c FROM Contratos c WHERE c.valorMensual = :valorMensual"),
    @NamedQuery(name = "Contratos.findByFechaAnexo", query = "SELECT c FROM Contratos c WHERE c.fechaAnexo = :fechaAnexo"),
    @NamedQuery(name = "Contratos.findByFechaDeAutorizacion", query = "SELECT c FROM Contratos c WHERE c.fechaDeAutorizacion = :fechaDeAutorizacion"),
    @NamedQuery(name = "Contratos.findByFechaDeEstudioPrevio", query = "SELECT c FROM Contratos c WHERE c.fechaDeEstudioPrevio = :fechaDeEstudioPrevio"),
    @NamedQuery(name = "Contratos.findByFechaDeIdoneidad", query = "SELECT c FROM Contratos c WHERE c.fechaDeIdoneidad = :fechaDeIdoneidad"),
    @NamedQuery(name = "Contratos.findByAdicionPresupuestal", query = "SELECT c FROM Contratos c WHERE c.adicionPresupuestal = :adicionPresupuestal"),
    @NamedQuery(name = "Contratos.findByAdicionPlazoNuevaFecha", query = "SELECT c FROM Contratos c WHERE c.adicionPlazoNuevaFecha = :adicionPlazoNuevaFecha"),
    @NamedQuery(name = "Contratos.findByIdPoliza", query = "SELECT c FROM Contratos c WHERE c.idPoliza = :idPoliza"),
    @NamedQuery(name = "Contratos.findByIdCuentasBancarias", query = "SELECT c FROM Contratos c WHERE c.idCuentasBancarias = :idCuentasBancarias"),
    @NamedQuery(name = "Contratos.findByObservaciones", query = "SELECT c FROM Contratos c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "Contratos.findByJustificacion", query = "SELECT c FROM Contratos c WHERE c.justificacion = :justificacion")})
public class Contratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contrato")
    private Integer idContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_de_contrato")
    private int numeroDeContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_suscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechasuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_contrato")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_contrato")
    @Temporal(TemporalType.DATE)
    private Date fechaFinContrato;
    @Column(name = "plazo_dias")
    private Integer plazoDias;
    @Column(name = "plazo_meses")
    private Short plazoMeses;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objeto_contractual")
    private String objetoContractual;
    @Size(max = 4000)
    @Column(name = "obligaciones")
    private String obligaciones;
    @Column(name = "valor_contrato")
    private Long valorContrato;
    @Column(name = "primer_pago")
    private Integer primerPago;
    @Column(name = "ultimo_pago")
    private Long ultimoPago;
    @Column(name = "numero_de_mensualidades")
    private Short numeroDeMensualidades;
    @Column(name = "valor_mensual")
    private Integer valorMensual;
    @Column(name = "fecha_anexo")
    @Temporal(TemporalType.DATE)
    private Date fechaAnexo;
    @Column(name = "fecha_de_autorizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAutorizacion;
    @Column(name = "fecha_de_estudio_previo")
    @Temporal(TemporalType.DATE)
    private Date fechaDeEstudioPrevio;
    @Column(name = "fecha_de_idoneidad")
    @Temporal(TemporalType.DATE)
    private Date fechaDeIdoneidad;
    @Column(name = "adicion_presupuestal")
    private Integer adicionPresupuestal;
    @Column(name = "adicion_plazo_nueva_fecha")
    @Temporal(TemporalType.DATE)
    private Date adicionPlazoNuevaFecha;
    @Column(name = "id_poliza")
    private Integer idPoliza;
    @Column(name = "id_cuentas_bancarias")
    private Integer idCuentasBancarias;
    @Size(max = 5000)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 500)
    @Column(name = "justificacion")
    private String justificacion;
    @JoinTable(name = "estados_contratos", joinColumns = {
        @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")}, inverseJoinColumns = {
        @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")})
    @ManyToMany
    private List<Estados> estadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<SoportesDeDocumentos> soportesDeDocumentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<Pagos> pagosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<PagosContratos> pagosContratosList;
    @JoinColumn(name = "id_tipo_contrato", referencedColumnName = "id_tipo_contrato")
    @ManyToOne(optional = false)
    private TipoDeContrato idTipoContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<Comisiones> comisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratos")
    private List<UsuariosContratos> usuariosContratosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratos")
    private List<ContratosPolizasUsuarios> contratosPolizasUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<Informes> informesList;

    public Contratos() {
    }

    public Contratos(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Contratos(Integer idContrato, int numeroDeContrato, Date fechasuscripcion, Date fechaInicioContrato, Date fechaFinContrato, String objetoContractual) {
        this.idContrato = idContrato;
        this.numeroDeContrato = numeroDeContrato;
        this.fechasuscripcion = fechasuscripcion;
        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.objetoContractual = objetoContractual;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public int getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(int numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
    }

    public Date getFechasuscripcion() {
        return fechasuscripcion;
    }

    public void setFechasuscripcion(Date fechasuscripcion) {
        this.fechasuscripcion = fechasuscripcion;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Integer getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(Integer plazoDias) {
        this.plazoDias = plazoDias;
    }

    public Short getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(Short plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public String getObjetoContractual() {
        return objetoContractual;
    }

    public void setObjetoContractual(String objetoContractual) {
        this.objetoContractual = objetoContractual;
    }

    public String getObligaciones() {
        return obligaciones;
    }

    public void setObligaciones(String obligaciones) {
        this.obligaciones = obligaciones;
    }

    public Long getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Long valorContrato) {
        this.valorContrato = valorContrato;
    }

    public Integer getPrimerPago() {
        return primerPago;
    }

    public void setPrimerPago(Integer primerPago) {
        this.primerPago = primerPago;
    }

    public Long getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(Long ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    public Short getNumeroDeMensualidades() {
        return numeroDeMensualidades;
    }

    public void setNumeroDeMensualidades(Short numeroDeMensualidades) {
        this.numeroDeMensualidades = numeroDeMensualidades;
    }

    public Integer getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(Integer valorMensual) {
        this.valorMensual = valorMensual;
    }

    public Date getFechaAnexo() {
        return fechaAnexo;
    }

    public void setFechaAnexo(Date fechaAnexo) {
        this.fechaAnexo = fechaAnexo;
    }

    public Date getFechaDeAutorizacion() {
        return fechaDeAutorizacion;
    }

    public void setFechaDeAutorizacion(Date fechaDeAutorizacion) {
        this.fechaDeAutorizacion = fechaDeAutorizacion;
    }

    public Date getFechaDeEstudioPrevio() {
        return fechaDeEstudioPrevio;
    }

    public void setFechaDeEstudioPrevio(Date fechaDeEstudioPrevio) {
        this.fechaDeEstudioPrevio = fechaDeEstudioPrevio;
    }

    public Date getFechaDeIdoneidad() {
        return fechaDeIdoneidad;
    }

    public void setFechaDeIdoneidad(Date fechaDeIdoneidad) {
        this.fechaDeIdoneidad = fechaDeIdoneidad;
    }

    public Integer getAdicionPresupuestal() {
        return adicionPresupuestal;
    }

    public void setAdicionPresupuestal(Integer adicionPresupuestal) {
        this.adicionPresupuestal = adicionPresupuestal;
    }

    public Date getAdicionPlazoNuevaFecha() {
        return adicionPlazoNuevaFecha;
    }

    public void setAdicionPlazoNuevaFecha(Date adicionPlazoNuevaFecha) {
        this.adicionPlazoNuevaFecha = adicionPlazoNuevaFecha;
    }

    public Integer getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Integer idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Integer getIdCuentasBancarias() {
        return idCuentasBancarias;
    }

    public void setIdCuentasBancarias(Integer idCuentasBancarias) {
        this.idCuentasBancarias = idCuentasBancarias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @XmlTransient
    public List<Estados> getEstadosList() {
        return estadosList;
    }

    public void setEstadosList(List<Estados> estadosList) {
        this.estadosList = estadosList;
    }

    @XmlTransient
    public List<SoportesDeDocumentos> getSoportesDeDocumentosList() {
        return soportesDeDocumentosList;
    }

    public void setSoportesDeDocumentosList(List<SoportesDeDocumentos> soportesDeDocumentosList) {
        this.soportesDeDocumentosList = soportesDeDocumentosList;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @XmlTransient
    public List<PagosContratos> getPagosContratosList() {
        return pagosContratosList;
    }

    public void setPagosContratosList(List<PagosContratos> pagosContratosList) {
        this.pagosContratosList = pagosContratosList;
    }

    public TipoDeContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoDeContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    @XmlTransient
    public List<UsuariosContratos> getUsuariosContratosList() {
        return usuariosContratosList;
    }

    public void setUsuariosContratosList(List<UsuariosContratos> usuariosContratosList) {
        this.usuariosContratosList = usuariosContratosList;
    }

    @XmlTransient
    public List<ContratosPolizasUsuarios> getContratosPolizasUsuariosList() {
        return contratosPolizasUsuariosList;
    }

    public void setContratosPolizasUsuariosList(List<ContratosPolizasUsuarios> contratosPolizasUsuariosList) {
        this.contratosPolizasUsuariosList = contratosPolizasUsuariosList;
    }

    @XmlTransient
    public List<Informes> getInformesList() {
        return informesList;
    }

    public void setInformesList(List<Informes> informesList) {
        this.informesList = informesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Contratos[ idContrato=" + idContrato + " ]";
    }
    
}
