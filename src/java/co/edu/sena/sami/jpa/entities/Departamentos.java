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
 * @author Adsim
 */
@Entity
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIdDpto", query = "SELECT d FROM Departamentos d WHERE d.idDpto = :idDpto"),
    @NamedQuery(name = "Departamentos.findByNombreDpto", query = "SELECT d FROM Departamentos d WHERE d.nombreDpto = :nombreDpto")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    private Integer idDpto;
    @Size(max = 45)
    @Column(name = "nombre_dpto")
    private String nombreDpto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos")
    private List<Ciudad> ciudadList;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_Pais")
    @ManyToOne
    private Pais idPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private List<OrdenesDeviaje> ordenesDeviajeList;

    public Departamentos() {
    }

    public Departamentos(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public Integer getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDpto != null ? idDpto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.idDpto == null && other.idDpto != null) || (this.idDpto != null && !this.idDpto.equals(other.idDpto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreDpto + "";
    }
    
}
