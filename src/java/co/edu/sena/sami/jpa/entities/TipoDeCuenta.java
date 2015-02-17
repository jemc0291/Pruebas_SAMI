/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "tipo_de_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeCuenta.findAll", query = "SELECT t FROM TipoDeCuenta t"),
    @NamedQuery(name = "TipoDeCuenta.findByIdTipoDeCuenta", query = "SELECT t FROM TipoDeCuenta t WHERE t.idTipoDeCuenta = :idTipoDeCuenta"),
    @NamedQuery(name = "TipoDeCuenta.findByNombreTipoDeCuenta", query = "SELECT t FROM TipoDeCuenta t WHERE t.nombreTipoDeCuenta = :nombreTipoDeCuenta")})
public class TipoDeCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_de_cuenta")
    private Integer idTipoDeCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_tipo_de_cuenta")
    private String nombreTipoDeCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDeCuenta")
    private List<CuentasBancarias> cuentasBancariasList;

    public TipoDeCuenta() {
    }

    public TipoDeCuenta(Integer idTipoDeCuenta) {
        this.idTipoDeCuenta = idTipoDeCuenta;
    }

    public TipoDeCuenta(Integer idTipoDeCuenta, String nombreTipoDeCuenta) {
        this.idTipoDeCuenta = idTipoDeCuenta;
        this.nombreTipoDeCuenta = nombreTipoDeCuenta;
    }

    public Integer getIdTipoDeCuenta() {
        return idTipoDeCuenta;
    }

    public void setIdTipoDeCuenta(Integer idTipoDeCuenta) {
        this.idTipoDeCuenta = idTipoDeCuenta;
    }

    public String getNombreTipoDeCuenta() {
        return nombreTipoDeCuenta;
    }

    public void setNombreTipoDeCuenta(String nombreTipoDeCuenta) {
        this.nombreTipoDeCuenta = nombreTipoDeCuenta;
    }

    @XmlTransient
    public List<CuentasBancarias> getCuentasBancariasList() {
        return cuentasBancariasList;
    }

    public void setCuentasBancariasList(List<CuentasBancarias> cuentasBancariasList) {
        this.cuentasBancariasList = cuentasBancariasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDeCuenta != null ? idTipoDeCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeCuenta)) {
            return false;
        }
        TipoDeCuenta other = (TipoDeCuenta) object;
        if ((this.idTipoDeCuenta == null && other.idTipoDeCuenta != null) || (this.idTipoDeCuenta != null && !this.idTipoDeCuenta.equals(other.idTipoDeCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.TipoDeCuenta[ idTipoDeCuenta=" + idTipoDeCuenta + " ]";
    }
    
}
