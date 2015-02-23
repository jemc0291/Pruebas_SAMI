/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "presupuestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuestos.findAll", query = "SELECT p FROM Presupuestos p"),
    @NamedQuery(name = "Presupuestos.findByIdPresupuestos", query = "SELECT p FROM Presupuestos p WHERE p.idPresupuestos = :idPresupuestos"),
    @NamedQuery(name = "Presupuestos.findByNombrePresupuesto", query = "SELECT p FROM Presupuestos p WHERE p.nombrePresupuesto = :nombrePresupuesto")})
public class Presupuestos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presupuestos")
    private Integer idPresupuestos;
    @Size(max = 45)
    @Column(name = "nombre_presupuesto")
    private String nombrePresupuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuestos")
    private List<Dependencias> dependenciasList;

    public Presupuestos() {
    }

    public Presupuestos(Integer idPresupuestos) {
        this.idPresupuestos = idPresupuestos;
    }

    public Integer getIdPresupuestos() {
        return idPresupuestos;
    }

    public void setIdPresupuestos(Integer idPresupuestos) {
        this.idPresupuestos = idPresupuestos;
    }

    public String getNombrePresupuesto() {
        return nombrePresupuesto;
    }

    public void setNombrePresupuesto(String nombrePresupuesto) {
        this.nombrePresupuesto = nombrePresupuesto;
    }

    @XmlTransient
    public List<Dependencias> getDependenciasList() {
        return dependenciasList;
    }

    public void setDependenciasList(List<Dependencias> dependenciasList) {
        this.dependenciasList = dependenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuestos != null ? idPresupuestos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuestos)) {
            return false;
        }
        Presupuestos other = (Presupuestos) object;
        if ((this.idPresupuestos == null && other.idPresupuestos != null) || (this.idPresupuestos != null && !this.idPresupuestos.equals(other.idPresupuestos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Presupuestos[ idPresupuestos=" + idPresupuestos + " ]";
    }
    
}
