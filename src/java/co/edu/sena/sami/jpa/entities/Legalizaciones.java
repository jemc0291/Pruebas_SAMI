/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "legalizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Legalizaciones.findAll", query = "SELECT l FROM Legalizaciones l"),
    @NamedQuery(name = "Legalizaciones.findByNumeroLegalizacion", query = "SELECT l FROM Legalizaciones l WHERE l.numeroLegalizacion = :numeroLegalizacion"),
    @NamedQuery(name = "Legalizaciones.findBySubtotal", query = "SELECT l FROM Legalizaciones l WHERE l.subtotal = :subtotal"),
    @NamedQuery(name = "Legalizaciones.findByMenosRetefuente", query = "SELECT l FROM Legalizaciones l WHERE l.menosRetefuente = :menosRetefuente"),
    @NamedQuery(name = "Legalizaciones.findByValorNetoAReconocer", query = "SELECT l FROM Legalizaciones l WHERE l.valorNetoAReconocer = :valorNetoAReconocer"),
    @NamedQuery(name = "Legalizaciones.findBySaldo", query = "SELECT l FROM Legalizaciones l WHERE l.saldo = :saldo"),
    @NamedQuery(name = "Legalizaciones.findBySaldoAFavor", query = "SELECT l FROM Legalizaciones l WHERE l.saldoAFavor = :saldoAFavor"),
    @NamedQuery(name = "Legalizaciones.findByValorAReintegrar", query = "SELECT l FROM Legalizaciones l WHERE l.valorAReintegrar = :valorAReintegrar"),
    @NamedQuery(name = "Legalizaciones.findByFechaSalida", query = "SELECT l FROM Legalizaciones l WHERE l.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Legalizaciones.findByFechaLlegada", query = "SELECT l FROM Legalizaciones l WHERE l.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "Legalizaciones.findByDias", query = "SELECT l FROM Legalizaciones l WHERE l.dias = :dias"),
    @NamedQuery(name = "Legalizaciones.findByValorLegalizar", query = "SELECT l FROM Legalizaciones l WHERE l.valorLegalizar = :valorLegalizar"),
    @NamedQuery(name = "Legalizaciones.findByMenosValorAnticipo", query = "SELECT l FROM Legalizaciones l WHERE l.menosValorAnticipo = :menosValorAnticipo"),
    @NamedQuery(name = "Legalizaciones.findBySaldooPositivo", query = "SELECT l FROM Legalizaciones l WHERE l.saldooPositivo = :saldooPositivo"),
    @NamedQuery(name = "Legalizaciones.findByPresupuesto", query = "SELECT l FROM Legalizaciones l WHERE l.presupuesto = :presupuesto"),
    @NamedQuery(name = "Legalizaciones.findBySolicitaOrdenaSaldo", query = "SELECT l FROM Legalizaciones l WHERE l.solicitaOrdenaSaldo = :solicitaOrdenaSaldo")})
public class Legalizaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_legalizacion")
    private Integer numeroLegalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private double subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menos_retefuente")
    private double menosRetefuente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_neto_a_reconocer")
    private Double valorNetoAReconocer;
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "saldo_a_favor")
    private Double saldoAFavor;
    @Column(name = "valor_a_reintegrar")
    private Double valorAReintegrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dias")
    private String dias;
    @Column(name = "valor_legalizar")
    private Double valorLegalizar;
    @Column(name = "menos_valor_anticipo")
    private Double menosValorAnticipo;
    @Column(name = "saldoo_positivo")
    private Double saldooPositivo;
    @Column(name = "presupuesto")
    private Double presupuesto;
    @Size(max = 45)
    @Column(name = "solicita_ordena_saldo")
    private String solicitaOrdenaSaldo;
    @JoinColumn(name = "numero_crp", referencedColumnName = "numero_crp")
    @ManyToOne(optional = false)
    private Crp numeroCrp;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "codigo_gasto", referencedColumnName = "codigo_gasto")
    @ManyToOne(optional = false)
    private ConceptosDeGastos codigoGasto;

    public Legalizaciones() {
    }

    public Legalizaciones(Integer numeroLegalizacion) {
        this.numeroLegalizacion = numeroLegalizacion;
    }

    public Legalizaciones(Integer numeroLegalizacion, double subtotal, double menosRetefuente, Date fechaSalida, Date fechaLlegada, String dias) {
        this.numeroLegalizacion = numeroLegalizacion;
        this.subtotal = subtotal;
        this.menosRetefuente = menosRetefuente;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.dias = dias;
    }

    public Integer getNumeroLegalizacion() {
        return numeroLegalizacion;
    }

    public void setNumeroLegalizacion(Integer numeroLegalizacion) {
        this.numeroLegalizacion = numeroLegalizacion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMenosRetefuente() {
        return menosRetefuente;
    }

    public void setMenosRetefuente(double menosRetefuente) {
        this.menosRetefuente = menosRetefuente;
    }

    public Double getValorNetoAReconocer() {
        return valorNetoAReconocer;
    }

    public void setValorNetoAReconocer(Double valorNetoAReconocer) {
        this.valorNetoAReconocer = valorNetoAReconocer;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldoAFavor() {
        return saldoAFavor;
    }

    public void setSaldoAFavor(Double saldoAFavor) {
        this.saldoAFavor = saldoAFavor;
    }

    public Double getValorAReintegrar() {
        return valorAReintegrar;
    }

    public void setValorAReintegrar(Double valorAReintegrar) {
        this.valorAReintegrar = valorAReintegrar;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Double getValorLegalizar() {
        return valorLegalizar;
    }

    public void setValorLegalizar(Double valorLegalizar) {
        this.valorLegalizar = valorLegalizar;
    }

    public Double getMenosValorAnticipo() {
        return menosValorAnticipo;
    }

    public void setMenosValorAnticipo(Double menosValorAnticipo) {
        this.menosValorAnticipo = menosValorAnticipo;
    }

    public Double getSaldooPositivo() {
        return saldooPositivo;
    }

    public void setSaldooPositivo(Double saldooPositivo) {
        this.saldooPositivo = saldooPositivo;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getSolicitaOrdenaSaldo() {
        return solicitaOrdenaSaldo;
    }

    public void setSolicitaOrdenaSaldo(String solicitaOrdenaSaldo) {
        this.solicitaOrdenaSaldo = solicitaOrdenaSaldo;
    }

    public Crp getNumeroCrp() {
        return numeroCrp;
    }

    public void setNumeroCrp(Crp numeroCrp) {
        this.numeroCrp = numeroCrp;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ConceptosDeGastos getCodigoGasto() {
        return codigoGasto;
    }

    public void setCodigoGasto(ConceptosDeGastos codigoGasto) {
        this.codigoGasto = codigoGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLegalizacion != null ? numeroLegalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Legalizaciones)) {
            return false;
        }
        Legalizaciones other = (Legalizaciones) object;
        if ((this.numeroLegalizacion == null && other.numeroLegalizacion != null) || (this.numeroLegalizacion != null && !this.numeroLegalizacion.equals(other.numeroLegalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Legalizaciones[ numeroLegalizacion=" + numeroLegalizacion + " ]";
    }
    
}
