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
 * @author Adsim
 */
@Entity
@Table(name = "usuarios_contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosContratos.findAll", query = "SELECT u FROM UsuariosContratos u"),
    @NamedQuery(name = "UsuariosContratos.findByIdContrato", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.idContrato = :idContrato"),
    @NamedQuery(name = "UsuariosContratos.findByIdUsuario", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosContratos.findByIdRol", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.idRol = :idRol")})
public class UsuariosContratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosContratosPK usuariosContratosPK;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contratos contratos;

    public UsuariosContratos() {
    }

    public UsuariosContratos(UsuariosContratosPK usuariosContratosPK) {
        this.usuariosContratosPK = usuariosContratosPK;
    }

    public UsuariosContratos(int idContrato, int idUsuario, int idRol) {
        this.usuariosContratosPK = new UsuariosContratosPK(idContrato, idUsuario, idRol);
    }

    public UsuariosContratosPK getUsuariosContratosPK() {
        return usuariosContratosPK;
    }

    public void setUsuariosContratosPK(UsuariosContratosPK usuariosContratosPK) {
        this.usuariosContratosPK = usuariosContratosPK;
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

    public Contratos getContratos() {
        return contratos;
    }

    public void setContratos(Contratos contratos) {
        this.contratos = contratos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosContratosPK != null ? usuariosContratosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosContratos)) {
            return false;
        }
        UsuariosContratos other = (UsuariosContratos) object;
        if ((this.usuariosContratosPK == null && other.usuariosContratosPK != null) || (this.usuariosContratosPK != null && !this.usuariosContratosPK.equals(other.usuariosContratosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.UsuariosContratos[ usuariosContratosPK=" + usuariosContratosPK + " ]";
    }
    
}
