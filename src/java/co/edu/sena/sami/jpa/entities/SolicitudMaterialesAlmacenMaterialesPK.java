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
 * @author Snyck
 */
@Embeddable
public class SolicitudMaterialesAlmacenMaterialesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitud_material")
    private int idSolicitudMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materiales")
    private int idMateriales;

    public SolicitudMaterialesAlmacenMaterialesPK() {
    }

    public SolicitudMaterialesAlmacenMaterialesPK(int idSolicitudMaterial, int idMateriales) {
        this.idSolicitudMaterial = idSolicitudMaterial;
        this.idMateriales = idMateriales;
    }

    public int getIdSolicitudMaterial() {
        return idSolicitudMaterial;
    }

    public void setIdSolicitudMaterial(int idSolicitudMaterial) {
        this.idSolicitudMaterial = idSolicitudMaterial;
    }

    public int getIdMateriales() {
        return idMateriales;
    }

    public void setIdMateriales(int idMateriales) {
        this.idMateriales = idMateriales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSolicitudMaterial;
        hash += (int) idMateriales;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudMaterialesAlmacenMaterialesPK)) {
            return false;
        }
        SolicitudMaterialesAlmacenMaterialesPK other = (SolicitudMaterialesAlmacenMaterialesPK) object;
        if (this.idSolicitudMaterial != other.idSolicitudMaterial) {
            return false;
        }
        if (this.idMateriales != other.idMateriales) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK[ idSolicitudMaterial=" + idSolicitudMaterial + ", idMateriales=" + idMateriales + " ]";
    }
    
}
