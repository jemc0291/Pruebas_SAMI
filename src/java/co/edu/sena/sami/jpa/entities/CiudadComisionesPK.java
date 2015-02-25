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
public class CiudadComisionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciudad")
    private int idCiudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    private int idDpto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comision")
    private int idComision;

    public CiudadComisionesPK() {
    }

    public CiudadComisionesPK(int idCiudad, int idDpto, int idComision) {
        this.idCiudad = idCiudad;
        this.idDpto = idDpto;
        this.idComision = idComision;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
    }

    public int getIdComision() {
        return idComision;
    }

    public void setIdComision(int idComision) {
        this.idComision = idComision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCiudad;
        hash += (int) idDpto;
        hash += (int) idComision;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadComisionesPK)) {
            return false;
        }
        CiudadComisionesPK other = (CiudadComisionesPK) object;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        if (this.idDpto != other.idDpto) {
            return false;
        }
        if (this.idComision != other.idComision) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.sami.edu.jpa.entities.CiudadComisionesPK[ idCiudad=" + idCiudad + ", idDpto=" + idDpto + ", idComision=" + idComision + " ]";
    }
    
}
