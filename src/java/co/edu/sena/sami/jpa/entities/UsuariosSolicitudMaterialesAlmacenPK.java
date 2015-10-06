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
public class UsuariosSolicitudMaterialesAlmacenPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitud_material")
    private int idSolicitudMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private int idRol;

    public UsuariosSolicitudMaterialesAlmacenPK() {
    }

    public UsuariosSolicitudMaterialesAlmacenPK(int idUsuario, int idSolicitudMaterial, int idRol) {
        this.idUsuario = idUsuario;
        this.idSolicitudMaterial = idSolicitudMaterial;
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSolicitudMaterial() {
        return idSolicitudMaterial;
    }

    public void setIdSolicitudMaterial(int idSolicitudMaterial) {
        this.idSolicitudMaterial = idSolicitudMaterial;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idSolicitudMaterial;
        hash += (int) idRol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosSolicitudMaterialesAlmacenPK)) {
            return false;
        }
        UsuariosSolicitudMaterialesAlmacenPK other = (UsuariosSolicitudMaterialesAlmacenPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idSolicitudMaterial != other.idSolicitudMaterial) {
            return false;
        }
        if (this.idRol != other.idRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK[ idUsuario=" + idUsuario + ", idSolicitudMaterial=" + idSolicitudMaterial + ", idRol=" + idRol + " ]";
    }
    
}
