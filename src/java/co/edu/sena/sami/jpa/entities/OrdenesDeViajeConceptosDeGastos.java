/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "ordenes_de_viaje_conceptos_de_gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeViajeConceptosDeGastos.findAll", query = "SELECT o FROM OrdenesDeViajeConceptosDeGastos o"),
    @NamedQuery(name = "OrdenesDeViajeConceptosDeGastos.findByNumeroOrdendeviaje", query = "SELECT o FROM OrdenesDeViajeConceptosDeGastos o WHERE o.ordenesDeViajeConceptosDeGastosPK.numeroOrdendeviaje = :numeroOrdendeviaje"),
    @NamedQuery(name = "OrdenesDeViajeConceptosDeGastos.findByCodigoGasto", query = "SELECT o FROM OrdenesDeViajeConceptosDeGastos o WHERE o.ordenesDeViajeConceptosDeGastosPK.codigoGasto = :codigoGasto"),
    @NamedQuery(name = "OrdenesDeViajeConceptosDeGastos.findByCostoGasto", query = "SELECT o FROM OrdenesDeViajeConceptosDeGastos o WHERE o.costoGasto = :costoGasto")})
public class OrdenesDeViajeConceptosDeGastos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenesDeViajeConceptosDeGastosPK ordenesDeViajeConceptosDeGastosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_gasto")
    private int costoGasto;
    @JoinColumn(name = "numero_ordendeviaje", referencedColumnName = "numero_ordendeviaje", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenesDeviaje ordenesDeviaje;
    @JoinColumn(name = "codigo_gasto", referencedColumnName = "codigo_gasto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ConceptosDeGastos conceptosDeGastos;

    public OrdenesDeViajeConceptosDeGastos() {
    }

    public OrdenesDeViajeConceptosDeGastos(OrdenesDeViajeConceptosDeGastosPK ordenesDeViajeConceptosDeGastosPK) {
        this.ordenesDeViajeConceptosDeGastosPK = ordenesDeViajeConceptosDeGastosPK;
    }

    public OrdenesDeViajeConceptosDeGastos(OrdenesDeViajeConceptosDeGastosPK ordenesDeViajeConceptosDeGastosPK, int costoGasto) {
        this.ordenesDeViajeConceptosDeGastosPK = ordenesDeViajeConceptosDeGastosPK;
        this.costoGasto = costoGasto;
    }

    public OrdenesDeViajeConceptosDeGastos(int numeroOrdendeviaje, int codigoGasto) {
        this.ordenesDeViajeConceptosDeGastosPK = new OrdenesDeViajeConceptosDeGastosPK(numeroOrdendeviaje, codigoGasto);
    }

    public OrdenesDeViajeConceptosDeGastosPK getOrdenesDeViajeConceptosDeGastosPK() {
        return ordenesDeViajeConceptosDeGastosPK;
    }

    public void setOrdenesDeViajeConceptosDeGastosPK(OrdenesDeViajeConceptosDeGastosPK ordenesDeViajeConceptosDeGastosPK) {
        this.ordenesDeViajeConceptosDeGastosPK = ordenesDeViajeConceptosDeGastosPK;
    }

    public int getCostoGasto() {
        return costoGasto;
    }

    public void setCostoGasto(int costoGasto) {
        this.costoGasto = costoGasto;
    }

    public OrdenesDeviaje getOrdenesDeviaje() {
        return ordenesDeviaje;
    }

    public void setOrdenesDeviaje(OrdenesDeviaje ordenesDeviaje) {
        this.ordenesDeviaje = ordenesDeviaje;
    }

    public ConceptosDeGastos getConceptosDeGastos() {
        return conceptosDeGastos;
    }

    public void setConceptosDeGastos(ConceptosDeGastos conceptosDeGastos) {
        this.conceptosDeGastos = conceptosDeGastos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenesDeViajeConceptosDeGastosPK != null ? ordenesDeViajeConceptosDeGastosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeViajeConceptosDeGastos)) {
            return false;
        }
        OrdenesDeViajeConceptosDeGastos other = (OrdenesDeViajeConceptosDeGastos) object;
        if ((this.ordenesDeViajeConceptosDeGastosPK == null && other.ordenesDeViajeConceptosDeGastosPK != null) || (this.ordenesDeViajeConceptosDeGastosPK != null && !this.ordenesDeViajeConceptosDeGastosPK.equals(other.ordenesDeViajeConceptosDeGastosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastos[ ordenesDeViajeConceptosDeGastosPK=" + ordenesDeViajeConceptosDeGastosPK + " ]";
    }
    
}
