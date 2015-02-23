/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "usuarios_contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosContratos.findAll", query = "SELECT u FROM UsuariosContratos u"),
    @NamedQuery(name = "UsuariosContratos.findByIdContrato", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.idContrato = :idContrato"),
    @NamedQuery(name = "UsuariosContratos.findByIdUsuario", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosContratos.findByIdRol", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.idRol = :idRol"),
    @NamedQuery(name = "UsuariosContratos.findByNumeroDePoliza", query = "SELECT u FROM UsuariosContratos u WHERE u.usuariosContratosPK.numeroDePoliza = :numeroDePoliza"),
    @NamedQuery(name = "UsuariosContratos.findByFechaSesion", query = "SELECT u FROM UsuariosContratos u WHERE u.fechaSesion = :fechaSesion"),
    @NamedQuery(name = "UsuariosContratos.findByObservaciones", query = "SELECT u FROM UsuariosContratos u WHERE u.observaciones = :observaciones")})
public class UsuariosContratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosContratosPK usuariosContratosPK;
    @Column(name = "fecha_sesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSesion;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contratos contratos;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "numero_de_poliza", referencedColumnName = "numero_de_poliza", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Polizas polizas;

    public UsuariosContratos() {
    }

    public UsuariosContratos(UsuariosContratosPK usuariosContratosPK) {
        this.usuariosContratosPK = usuariosContratosPK;
    }

    public UsuariosContratos(int idContrato, int idUsuario, int idRol, int numeroDePoliza) {
        this.usuariosContratosPK = new UsuariosContratosPK(idContrato, idUsuario, idRol, numeroDePoliza);
    }

    public UsuariosContratosPK getUsuariosContratosPK() {
        return usuariosContratosPK;
    }

    public void setUsuariosContratosPK(UsuariosContratosPK usuariosContratosPK) {
        this.usuariosContratosPK = usuariosContratosPK;
    }

    public Date getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(Date fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Contratos getContratos() {
        return contratos;
    }

    public void setContratos(Contratos contratos) {
        this.contratos = contratos;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Polizas getPolizas() {
        return polizas;
    }

    public void setPolizas(Polizas polizas) {
        this.polizas = polizas;
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
