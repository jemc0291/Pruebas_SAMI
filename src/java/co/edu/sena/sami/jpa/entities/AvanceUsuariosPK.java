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
public class AvanceUsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avance")
    private int idAvance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public AvanceUsuariosPK() {
    }

    public AvanceUsuariosPK(int idAvance, int idUsuario) {
        this.idAvance = idAvance;
        this.idUsuario = idUsuario;
    }

    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
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
        hash += (int) idAvance;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvanceUsuariosPK)) {
            return false;
        }
        AvanceUsuariosPK other = (AvanceUsuariosPK) object;
        if (this.idAvance != other.idAvance) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.AvanceUsuariosPK[ idAvance=" + idAvance + ", idUsuario=" + idUsuario + " ]";
    }
    
}
