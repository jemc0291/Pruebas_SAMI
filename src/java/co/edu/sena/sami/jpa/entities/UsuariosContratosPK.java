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
 * @author Usuario
 */
@Embeddable
public class UsuariosContratosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contrato")
    private int idContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_de_poliza")
    private int numeroDePoliza;

    public UsuariosContratosPK() {
    }

    public UsuariosContratosPK(int idContrato, int idUsuario, int idRol, int numeroDePoliza) {
        this.idContrato = idContrato;
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.numeroDePoliza = numeroDePoliza;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getNumeroDePoliza() {
        return numeroDePoliza;
    }

    public void setNumeroDePoliza(int numeroDePoliza) {
        this.numeroDePoliza = numeroDePoliza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idContrato;
        hash += (int) idUsuario;
        hash += (int) idRol;
        hash += (int) numeroDePoliza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosContratosPK)) {
            return false;
        }
        UsuariosContratosPK other = (UsuariosContratosPK) object;
        if (this.idContrato != other.idContrato) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.numeroDePoliza != other.numeroDePoliza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.UsuariosContratosPK[ idContrato=" + idContrato + ", idUsuario=" + idUsuario + ", idRol=" + idRol + ", numeroDePoliza=" + numeroDePoliza + " ]";
    }
    
}
