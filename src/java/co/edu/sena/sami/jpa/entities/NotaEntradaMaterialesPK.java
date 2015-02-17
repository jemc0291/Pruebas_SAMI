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
public class NotaEntradaMaterialesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Nota")
    private int idNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_material")
    private int idMaterial;

    public NotaEntradaMaterialesPK() {
    }

    public NotaEntradaMaterialesPK(int idNota, int idMaterial) {
        this.idNota = idNota;
        this.idMaterial = idMaterial;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idNota;
        hash += (int) idMaterial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaEntradaMaterialesPK)) {
            return false;
        }
        NotaEntradaMaterialesPK other = (NotaEntradaMaterialesPK) object;
        if (this.idNota != other.idNota) {
            return false;
        }
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK[ idNota=" + idNota + ", idMaterial=" + idMaterial + " ]";
    }
    
}
