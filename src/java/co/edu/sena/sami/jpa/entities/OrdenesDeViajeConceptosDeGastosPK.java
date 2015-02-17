/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adsim
 */
@Embeddable
public class OrdenesDeViajeConceptosDeGastosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_ordendeviaje")
    private int numeroOrdendeviaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_gasto")
    private int codigoGasto;

    public OrdenesDeViajeConceptosDeGastosPK() {
    }

    public OrdenesDeViajeConceptosDeGastosPK(int numeroOrdendeviaje, int codigoGasto) {
        this.numeroOrdendeviaje = numeroOrdendeviaje;
        this.codigoGasto = codigoGasto;
    }

    public int getNumeroOrdendeviaje() {
        return numeroOrdendeviaje;
    }

    public void setNumeroOrdendeviaje(int numeroOrdendeviaje) {
        this.numeroOrdendeviaje = numeroOrdendeviaje;
    }

    public int getCodigoGasto() {
        return codigoGasto;
    }

    public void setCodigoGasto(int codigoGasto) {
        this.codigoGasto = codigoGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroOrdendeviaje;
        hash += (int) codigoGasto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeViajeConceptosDeGastosPK)) {
            return false;
        }
        OrdenesDeViajeConceptosDeGastosPK other = (OrdenesDeViajeConceptosDeGastosPK) object;
        if (this.numeroOrdendeviaje != other.numeroOrdendeviaje) {
            return false;
        }
        if (this.codigoGasto != other.codigoGasto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK[ numeroOrdendeviaje=" + numeroOrdendeviaje + ", codigoGasto=" + codigoGasto + " ]";
    }
    
}
