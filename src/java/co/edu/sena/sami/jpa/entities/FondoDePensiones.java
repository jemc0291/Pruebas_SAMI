/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "fondo_de_pensiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FondoDePensiones.findAll", query = "SELECT f FROM FondoDePensiones f"),
    @NamedQuery(name = "FondoDePensiones.findByIdFondoPensiones", query = "SELECT f FROM FondoDePensiones f WHERE f.idFondoPensiones = :idFondoPensiones"),
    @NamedQuery(name = "FondoDePensiones.findByNombreFondoPensiones", query = "SELECT f FROM FondoDePensiones f WHERE f.nombreFondoPensiones = :nombreFondoPensiones")})
public class FondoDePensiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fondo_pensiones")
    private Short idFondoPensiones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_fondo_pensiones")
    private String nombreFondoPensiones;
    @OneToMany(mappedBy = "idFondoPensiones")
    private List<Usuarios> usuariosList;

    public FondoDePensiones() {
    }

    public FondoDePensiones(Short idFondoPensiones) {
        this.idFondoPensiones = idFondoPensiones;
    }

    public FondoDePensiones(Short idFondoPensiones, String nombreFondoPensiones) {
        this.idFondoPensiones = idFondoPensiones;
        this.nombreFondoPensiones = nombreFondoPensiones;
    }

    public Short getIdFondoPensiones() {
        return idFondoPensiones;
    }

    public void setIdFondoPensiones(Short idFondoPensiones) {
        this.idFondoPensiones = idFondoPensiones;
    }

    public String getNombreFondoPensiones() {
        return nombreFondoPensiones;
    }

    public void setNombreFondoPensiones(String nombreFondoPensiones) {
        this.nombreFondoPensiones = nombreFondoPensiones;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFondoPensiones != null ? idFondoPensiones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FondoDePensiones)) {
            return false;
        }
        FondoDePensiones other = (FondoDePensiones) object;
        if ((this.idFondoPensiones == null && other.idFondoPensiones != null) || (this.idFondoPensiones != null && !this.idFondoPensiones.equals(other.idFondoPensiones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreFondoPensiones;
    }
    
}
