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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "legalizaciones_de_comisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalizacionesDeComisiones.findAll", query = "SELECT l FROM LegalizacionesDeComisiones l"),
    @NamedQuery(name = "LegalizacionesDeComisiones.findByIdLegalizacionDeComision", query = "SELECT l FROM LegalizacionesDeComisiones l WHERE l.idLegalizacionDeComision = :idLegalizacionDeComision"),
    @NamedQuery(name = "LegalizacionesDeComisiones.findByAnticipo", query = "SELECT l FROM LegalizacionesDeComisiones l WHERE l.anticipo = :anticipo"),
    @NamedQuery(name = "LegalizacionesDeComisiones.findByValorReintegro", query = "SELECT l FROM LegalizacionesDeComisiones l WHERE l.valorReintegro = :valorReintegro"),
    @NamedQuery(name = "LegalizacionesDeComisiones.findByRetefuente", query = "SELECT l FROM LegalizacionesDeComisiones l WHERE l.retefuente = :retefuente"),
    @NamedQuery(name = "LegalizacionesDeComisiones.findByNetoPagado", query = "SELECT l FROM LegalizacionesDeComisiones l WHERE l.netoPagado = :netoPagado")})
public class LegalizacionesDeComisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_legalizacion_de_comision")
    private Integer idLegalizacionDeComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anticipo")
    private double anticipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_reintegro")
    private Double valorReintegro;
    @Column(name = "retefuente")
    private Double retefuente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "neto_pagado")
    private double netoPagado;
    @ManyToMany(mappedBy = "legalizacionesDeComisionesList")
    private List<ConceptosDeGastos> conceptosDeGastosList;
    @JoinColumn(name = "id_comision", referencedColumnName = "id_comision")
    @ManyToOne(optional = false)
    private Comisiones idComision;

    public LegalizacionesDeComisiones() {
    }

    public LegalizacionesDeComisiones(Integer idLegalizacionDeComision) {
        this.idLegalizacionDeComision = idLegalizacionDeComision;
    }

    public LegalizacionesDeComisiones(Integer idLegalizacionDeComision, double anticipo, double netoPagado) {
        this.idLegalizacionDeComision = idLegalizacionDeComision;
        this.anticipo = anticipo;
        this.netoPagado = netoPagado;
    }

    public Integer getIdLegalizacionDeComision() {
        return idLegalizacionDeComision;
    }

    public void setIdLegalizacionDeComision(Integer idLegalizacionDeComision) {
        this.idLegalizacionDeComision = idLegalizacionDeComision;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public Double getValorReintegro() {
        return valorReintegro;
    }

    public void setValorReintegro(Double valorReintegro) {
        this.valorReintegro = valorReintegro;
    }

    public Double getRetefuente() {
        return retefuente;
    }

    public void setRetefuente(Double retefuente) {
        this.retefuente = retefuente;
    }

    public double getNetoPagado() {
        return netoPagado;
    }

    public void setNetoPagado(double netoPagado) {
        this.netoPagado = netoPagado;
    }

    @XmlTransient
    public List<ConceptosDeGastos> getConceptosDeGastosList() {
        return conceptosDeGastosList;
    }

    public void setConceptosDeGastosList(List<ConceptosDeGastos> conceptosDeGastosList) {
        this.conceptosDeGastosList = conceptosDeGastosList;
    }

    public Comisiones getIdComision() {
        return idComision;
    }

    public void setIdComision(Comisiones idComision) {
        this.idComision = idComision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLegalizacionDeComision != null ? idLegalizacionDeComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LegalizacionesDeComisiones)) {
            return false;
        }
        LegalizacionesDeComisiones other = (LegalizacionesDeComisiones) object;
        if ((this.idLegalizacionDeComision == null && other.idLegalizacionDeComision != null) || (this.idLegalizacionDeComision != null && !this.idLegalizacionDeComision.equals(other.idLegalizacionDeComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.LegalizacionesDeComisiones[ idLegalizacionDeComision=" + idLegalizacionDeComision + " ]";
    }
    
}
