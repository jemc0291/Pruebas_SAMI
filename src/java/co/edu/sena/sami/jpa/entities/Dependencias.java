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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencias.findAll", query = "SELECT d FROM Dependencias d"),
    @NamedQuery(name = "Dependencias.findByCodigoDeDependencia", query = "SELECT d FROM Dependencias d WHERE d.codigoDeDependencia = :codigoDeDependencia"),
    @NamedQuery(name = "Dependencias.findByDescripcionDependencia", query = "SELECT d FROM Dependencias d WHERE d.descripcionDependencia = :descripcionDependencia")})
public class Dependencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_de_dependencia")
    private Integer codigoDeDependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_dependencia")
    private String descripcionDependencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDeDependencia")
    private List<Cdp> cdpList;
    @JoinColumn(name = "id_presupuestos", referencedColumnName = "id_presupuestos")
    @ManyToOne(optional = false)
    private Presupuestos idPresupuestos;

    public Dependencias() {
    }

    public Dependencias(Integer codigoDeDependencia) {
        this.codigoDeDependencia = codigoDeDependencia;
    }

    public Dependencias(Integer codigoDeDependencia, String descripcionDependencia) {
        this.codigoDeDependencia = codigoDeDependencia;
        this.descripcionDependencia = descripcionDependencia;
    }

    public Integer getCodigoDeDependencia() {
        return codigoDeDependencia;
    }

    public void setCodigoDeDependencia(Integer codigoDeDependencia) {
        this.codigoDeDependencia = codigoDeDependencia;
    }

    public String getDescripcionDependencia() {
        return descripcionDependencia;
    }

    public void setDescripcionDependencia(String descripcionDependencia) {
        this.descripcionDependencia = descripcionDependencia;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    public Presupuestos getIdPresupuestos() {
        return idPresupuestos;
    }

    public void setIdPresupuestos(Presupuestos idPresupuestos) {
        this.idPresupuestos = idPresupuestos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDeDependencia != null ? codigoDeDependencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependencias)) {
            return false;
        }
        Dependencias other = (Dependencias) object;
        if ((this.codigoDeDependencia == null && other.codigoDeDependencia != null) || (this.codigoDeDependencia != null && !this.codigoDeDependencia.equals(other.codigoDeDependencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + codigoDeDependencia;
    }
    
}
