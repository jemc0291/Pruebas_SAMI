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
import javax.persistence.JoinColumns;
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
@Table(name = "comunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunas.findAll", query = "SELECT c FROM Comunas c"),
    @NamedQuery(name = "Comunas.findByIdComuna", query = "SELECT c FROM Comunas c WHERE c.idComuna = :idComuna"),
    @NamedQuery(name = "Comunas.findByNombreComuna", query = "SELECT c FROM Comunas c WHERE c.nombreComuna = :nombreComuna")})
public class Comunas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comuna")
    private Integer idComuna;
    @Size(max = 45)
    @Column(name = "nombre_comuna")
    private String nombreComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComuna")
    private List<Barrios> barriosList;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;

    public Comunas() {
    }

    public Comunas(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    @XmlTransient
    public List<Barrios> getBarriosList() {
        return barriosList;
    }

    public void setBarriosList(List<Barrios> barriosList) {
        this.barriosList = barriosList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComuna != null ? idComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunas)) {
            return false;
        }
        Comunas other = (Comunas) object;
        if ((this.idComuna == null && other.idComuna != null) || (this.idComuna != null && !this.idComuna.equals(other.idComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreComuna + " ";
    }
    
}
