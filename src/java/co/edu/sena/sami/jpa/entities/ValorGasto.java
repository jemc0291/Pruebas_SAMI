/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author Snyck
 */
@Entity
@Table(name = "valor_gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorGasto.findAll", query = "SELECT v FROM ValorGasto v"),
    @NamedQuery(name = "ValorGasto.findByIdValorGasto", query = "SELECT v FROM ValorGasto v WHERE v.idValorGasto = :idValorGasto"),
    @NamedQuery(name = "ValorGasto.findByValorGastos", query = "SELECT v FROM ValorGasto v WHERE v.valorGastos = :valorGastos")})
public class ValorGasto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_valor_gasto")
    private Integer idValorGasto;
    @Size(max = 45)
    @Column(name = "valor_gastos")
    private String valorGastos;
    @OneToMany(mappedBy = "idValorGasto")
    private List<Ciudad> ciudadList;
    @JoinColumn(name = "id_tarifa", referencedColumnName = "id_tarifa")
    @ManyToOne(optional = false)
    private Tarifas idTarifa;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private Nivel idNivel;

    public ValorGasto() {
    }

    public ValorGasto(Integer idValorGasto) {
        this.idValorGasto = idValorGasto;
    }

    public Integer getIdValorGasto() {
        return idValorGasto;
    }

    public void setIdValorGasto(Integer idValorGasto) {
        this.idValorGasto = idValorGasto;
    }

    public String getValorGastos() {
        return valorGastos;
    }

    public void setValorGastos(String valorGastos) {
        this.valorGastos = valorGastos;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public Tarifas getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Tarifas idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValorGasto != null ? idValorGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorGasto)) {
            return false;
        }
        ValorGasto other = (ValorGasto) object;
        if ((this.idValorGasto == null && other.idValorGasto != null) || (this.idValorGasto != null && !this.idValorGasto.equals(other.idValorGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ValorGasto[ idValorGasto=" + idValorGasto + " ]";
    }
    
}
