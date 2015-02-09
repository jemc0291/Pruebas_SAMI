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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "pagos_contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagosContratos.findAll", query = "SELECT p FROM PagosContratos p"),
    @NamedQuery(name = "PagosContratos.findByIdPago", query = "SELECT p FROM PagosContratos p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "PagosContratos.findByNumFactura", query = "SELECT p FROM PagosContratos p WHERE p.numFactura = :numFactura"),
    @NamedQuery(name = "PagosContratos.findByFechaFactura", query = "SELECT p FROM PagosContratos p WHERE p.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "PagosContratos.findByValFactura", query = "SELECT p FROM PagosContratos p WHERE p.valFactura = :valFactura"),
    @NamedQuery(name = "PagosContratos.findByFechaDePago", query = "SELECT p FROM PagosContratos p WHERE p.fechaDePago = :fechaDePago")})
public class PagosContratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_factura")
    private int numFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_factura")
    private float valFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_de_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaDePago;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contratos idContrato;

    public PagosContratos() {
    }

    public PagosContratos(Integer idPago) {
        this.idPago = idPago;
    }

    public PagosContratos(Integer idPago, int numFactura, Date fechaFactura, float valFactura, Date fechaDePago) {
        this.idPago = idPago;
        this.numFactura = numFactura;
        this.fechaFactura = fechaFactura;
        this.valFactura = valFactura;
        this.fechaDePago = fechaDePago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public float getValFactura() {
        return valFactura;
    }

    public void setValFactura(float valFactura) {
        this.valFactura = valFactura;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public Contratos getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contratos idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosContratos)) {
            return false;
        }
        PagosContratos other = (PagosContratos) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.PagosContratos[ idPago=" + idPago + " ]";
    }
    
}
