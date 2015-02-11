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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tarifas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifas.findAll", query = "SELECT t FROM Tarifas t"),
    @NamedQuery(name = "Tarifas.findByIdTarifa", query = "SELECT t FROM Tarifas t WHERE t.idTarifa = :idTarifa"),
    @NamedQuery(name = "Tarifas.findByValorTarifa", query = "SELECT t FROM Tarifas t WHERE t.valorTarifa = :valorTarifa")})
public class Tarifas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tarifa")
    private Integer idTarifa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_tarifa")
    private int valorTarifa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarifa")
    private List<ValorGasto> valorGastoList;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;

    public Tarifas() {
    }

    public Tarifas(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Tarifas(Integer idTarifa, int valorTarifa) {
        this.idTarifa = idTarifa;
        this.valorTarifa = valorTarifa;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(int valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    @XmlTransient
    public List<ValorGasto> getValorGastoList() {
        return valorGastoList;
    }

    public void setValorGastoList(List<ValorGasto> valorGastoList) {
        this.valorGastoList = valorGastoList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifa != null ? idTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifas)) {
            return false;
        }
        Tarifas other = (Tarifas) object;
        if ((this.idTarifa == null && other.idTarifa != null) || (this.idTarifa != null && !this.idTarifa.equals(other.idTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Tarifas[ idTarifa=" + idTarifa + " ]";
    }
    
}
