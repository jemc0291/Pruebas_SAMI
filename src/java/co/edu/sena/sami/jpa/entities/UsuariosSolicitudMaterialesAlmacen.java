/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "usuarios_solicitud_materiales_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosSolicitudMaterialesAlmacen.findAll", query = "SELECT u FROM UsuariosSolicitudMaterialesAlmacen u"),
    @NamedQuery(name = "UsuariosSolicitudMaterialesAlmacen.findByIdUsuario", query = "SELECT u FROM UsuariosSolicitudMaterialesAlmacen u WHERE u.usuariosSolicitudMaterialesAlmacenPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosSolicitudMaterialesAlmacen.findByIdSolicitudMaterial", query = "SELECT u FROM UsuariosSolicitudMaterialesAlmacen u WHERE u.usuariosSolicitudMaterialesAlmacenPK.idSolicitudMaterial = :idSolicitudMaterial"),
    @NamedQuery(name = "UsuariosSolicitudMaterialesAlmacen.findByIdRol", query = "SELECT u FROM UsuariosSolicitudMaterialesAlmacen u WHERE u.usuariosSolicitudMaterialesAlmacenPK.idRol = :idRol")})
public class UsuariosSolicitudMaterialesAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosSolicitudMaterialesAlmacenPK usuariosSolicitudMaterialesAlmacenPK;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_solicitud_material", referencedColumnName = "id_solicitud_material", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SolicitudMaterialesAlmacen solicitudMaterialesAlmacen;

    public UsuariosSolicitudMaterialesAlmacen() {
    }

    public UsuariosSolicitudMaterialesAlmacen(UsuariosSolicitudMaterialesAlmacenPK usuariosSolicitudMaterialesAlmacenPK) {
        this.usuariosSolicitudMaterialesAlmacenPK = usuariosSolicitudMaterialesAlmacenPK;
    }

    public UsuariosSolicitudMaterialesAlmacen(int idUsuario, int idSolicitudMaterial, int idRol) {
        this.usuariosSolicitudMaterialesAlmacenPK = new UsuariosSolicitudMaterialesAlmacenPK(idUsuario, idSolicitudMaterial, idRol);
    }

    public UsuariosSolicitudMaterialesAlmacenPK getUsuariosSolicitudMaterialesAlmacenPK() {
        return usuariosSolicitudMaterialesAlmacenPK;
    }

    public void setUsuariosSolicitudMaterialesAlmacenPK(UsuariosSolicitudMaterialesAlmacenPK usuariosSolicitudMaterialesAlmacenPK) {
        this.usuariosSolicitudMaterialesAlmacenPK = usuariosSolicitudMaterialesAlmacenPK;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public SolicitudMaterialesAlmacen getSolicitudMaterialesAlmacen() {
        return solicitudMaterialesAlmacen;
    }

    public void setSolicitudMaterialesAlmacen(SolicitudMaterialesAlmacen solicitudMaterialesAlmacen) {
        this.solicitudMaterialesAlmacen = solicitudMaterialesAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosSolicitudMaterialesAlmacenPK != null ? usuariosSolicitudMaterialesAlmacenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosSolicitudMaterialesAlmacen)) {
            return false;
        }
        UsuariosSolicitudMaterialesAlmacen other = (UsuariosSolicitudMaterialesAlmacen) object;
        if ((this.usuariosSolicitudMaterialesAlmacenPK == null && other.usuariosSolicitudMaterialesAlmacenPK != null) || (this.usuariosSolicitudMaterialesAlmacenPK != null && !this.usuariosSolicitudMaterialesAlmacenPK.equals(other.usuariosSolicitudMaterialesAlmacenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacen[ usuariosSolicitudMaterialesAlmacenPK=" + usuariosSolicitudMaterialesAlmacenPK + " ]";
    }
    
}
