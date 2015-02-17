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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuentas_bancarias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasBancarias.findAll", query = "SELECT c FROM CuentasBancarias c"),
    @NamedQuery(name = "CuentasBancarias.findByNumeroDeCuenta", query = "SELECT c FROM CuentasBancarias c WHERE c.numeroDeCuenta = :numeroDeCuenta"),
    @NamedQuery(name = "CuentasBancarias.findByIdCuenta", query = "SELECT c FROM CuentasBancarias c WHERE c.idCuenta = :idCuenta")})
public class CuentasBancarias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "numero_de_cuenta")
    private String numeroDeCuenta;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<OrdenesDeviaje> ordenesDeviajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<Comisiones> comisionesList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
    @ManyToOne(optional = false)
    private Bancos idBanco;
    @JoinColumn(name = "id_tipo_de_cuenta", referencedColumnName = "id_tipo_de_cuenta")
    @ManyToOne(optional = false)
    private TipoDeCuenta idTipoDeCuenta;

    public CuentasBancarias() {
    }

    public CuentasBancarias(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Bancos getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Bancos idBanco) {
        this.idBanco = idBanco;
    }

    public TipoDeCuenta getIdTipoDeCuenta() {
        return idTipoDeCuenta;
    }

    public void setIdTipoDeCuenta(TipoDeCuenta idTipoDeCuenta) {
        this.idTipoDeCuenta = idTipoDeCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasBancarias)) {
            return false;
        }
        CuentasBancarias other = (CuentasBancarias) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.CuentasBancarias[ idCuenta=" + idCuenta + " ]";
    }
    
}
