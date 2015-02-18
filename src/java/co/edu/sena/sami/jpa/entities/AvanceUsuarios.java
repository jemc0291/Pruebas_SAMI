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
@Table(name = "avance_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvanceUsuarios.findAll", query = "SELECT a FROM AvanceUsuarios a"),
    @NamedQuery(name = "AvanceUsuarios.findByIdAvance", query = "SELECT a FROM AvanceUsuarios a WHERE a.avanceUsuariosPK.idAvance = :idAvance"),
    @NamedQuery(name = "AvanceUsuarios.findByIdUsuario", query = "SELECT a FROM AvanceUsuarios a WHERE a.avanceUsuariosPK.idUsuario = :idUsuario")})
public class AvanceUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvanceUsuariosPK avanceUsuariosPK;
    @JoinColumn(name = "idtipo_usuario", referencedColumnName = "idtipo_usuario")
    @ManyToOne(optional = false)
    private TipoUsuario idtipoUsuario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_avance", referencedColumnName = "id_avance", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avance avance;

    public AvanceUsuarios() {
    }

    public AvanceUsuarios(AvanceUsuariosPK avanceUsuariosPK) {
        this.avanceUsuariosPK = avanceUsuariosPK;
    }

    public AvanceUsuarios(int idAvance, int idUsuario) {
        this.avanceUsuariosPK = new AvanceUsuariosPK(idAvance, idUsuario);
    }

    public AvanceUsuariosPK getAvanceUsuariosPK() {
        return avanceUsuariosPK;
    }

    public void setAvanceUsuariosPK(AvanceUsuariosPK avanceUsuariosPK) {
        this.avanceUsuariosPK = avanceUsuariosPK;
    }

    public TipoUsuario getIdtipoUsuario() {
        return idtipoUsuario;
    }

    public void setIdtipoUsuario(TipoUsuario idtipoUsuario) {
        this.idtipoUsuario = idtipoUsuario;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Avance getAvance() {
        return avance;
    }

    public void setAvance(Avance avance) {
        this.avance = avance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avanceUsuariosPK != null ? avanceUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvanceUsuarios)) {
            return false;
        }
        AvanceUsuarios other = (AvanceUsuarios) object;
        if ((this.avanceUsuariosPK == null && other.avanceUsuariosPK != null) || (this.avanceUsuariosPK != null && !this.avanceUsuariosPK.equals(other.avanceUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.AvanceUsuarios[ avanceUsuariosPK=" + avanceUsuariosPK + " ]";
    }
    
}
