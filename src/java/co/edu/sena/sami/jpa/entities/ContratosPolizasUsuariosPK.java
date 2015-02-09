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
public class ContratosPolizasUsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contrato")
    private int idContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_de_poliza")
    private int numeroDePoliza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public ContratosPolizasUsuariosPK() {
    }

    public ContratosPolizasUsuariosPK(int idContrato, int numeroDePoliza, int idUsuario) {
        this.idContrato = idContrato;
        this.numeroDePoliza = numeroDePoliza;
        this.idUsuario = idUsuario;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getNumeroDePoliza() {
        return numeroDePoliza;
    }

    public void setNumeroDePoliza(int numeroDePoliza) {
        this.numeroDePoliza = numeroDePoliza;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idContrato;
        hash += (int) numeroDePoliza;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratosPolizasUsuariosPK)) {
            return false;
        }
        ContratosPolizasUsuariosPK other = (ContratosPolizasUsuariosPK) object;
        if (this.idContrato != other.idContrato) {
            return false;
        }
        if (this.numeroDePoliza != other.numeroDePoliza) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK[ idContrato=" + idContrato + ", numeroDePoliza=" + numeroDePoliza + ", idUsuario=" + idUsuario + " ]";
    }
    
}
