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
 * @author Adsim
 */
@Entity
@Table(name = "contratos_polizas_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratosPolizasUsuarios.findAll", query = "SELECT c FROM ContratosPolizasUsuarios c"),
    @NamedQuery(name = "ContratosPolizasUsuarios.findByIdContrato", query = "SELECT c FROM ContratosPolizasUsuarios c WHERE c.contratosPolizasUsuariosPK.idContrato = :idContrato"),
    @NamedQuery(name = "ContratosPolizasUsuarios.findByNumeroDePoliza", query = "SELECT c FROM ContratosPolizasUsuarios c WHERE c.contratosPolizasUsuariosPK.numeroDePoliza = :numeroDePoliza"),
    @NamedQuery(name = "ContratosPolizasUsuarios.findByFechaSesion", query = "SELECT c FROM ContratosPolizasUsuarios c WHERE c.fechaSesion = :fechaSesion"),
    @NamedQuery(name = "ContratosPolizasUsuarios.findByObservaciones", query = "SELECT c FROM ContratosPolizasUsuarios c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "ContratosPolizasUsuarios.findByIdUsuario", query = "SELECT c FROM ContratosPolizasUsuarios c WHERE c.contratosPolizasUsuariosPK.idUsuario = :idUsuario")})
public class ContratosPolizasUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratosPolizasUsuariosPK contratosPolizasUsuariosPK;
    @Column(name = "fecha_sesion")
    @Temporal(TemporalType.DATE)
    private Date fechaSesion;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "numero_de_poliza", referencedColumnName = "numero_de_poliza", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Polizas polizas;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contratos contratos;

    public ContratosPolizasUsuarios() {
    }

    public ContratosPolizasUsuarios(ContratosPolizasUsuariosPK contratosPolizasUsuariosPK) {
        this.contratosPolizasUsuariosPK = contratosPolizasUsuariosPK;
    }

    public ContratosPolizasUsuarios(int idContrato, int numeroDePoliza, int idUsuario) {
        this.contratosPolizasUsuariosPK = new ContratosPolizasUsuariosPK(idContrato, numeroDePoliza, idUsuario);
    }

    public ContratosPolizasUsuariosPK getContratosPolizasUsuariosPK() {
        return contratosPolizasUsuariosPK;
    }

    public void setContratosPolizasUsuariosPK(ContratosPolizasUsuariosPK contratosPolizasUsuariosPK) {
        this.contratosPolizasUsuariosPK = contratosPolizasUsuariosPK;
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

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Polizas getPolizas() {
        return polizas;
    }

    public void setPolizas(Polizas polizas) {
        this.polizas = polizas;
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
        hash += (contratosPolizasUsuariosPK != null ? contratosPolizasUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratosPolizasUsuarios)) {
            return false;
        }
        ContratosPolizasUsuarios other = (ContratosPolizasUsuarios) object;
        if ((this.contratosPolizasUsuariosPK == null && other.contratosPolizasUsuariosPK != null) || (this.contratosPolizasUsuariosPK != null && !this.contratosPolizasUsuariosPK.equals(other.contratosPolizasUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ContratosPolizasUsuarios[ contratosPolizasUsuariosPK=" + contratosPolizasUsuariosPK + " ]";
    }
    
}
