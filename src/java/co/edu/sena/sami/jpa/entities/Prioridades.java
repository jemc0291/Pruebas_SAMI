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
@Table(name = "prioridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridades.findAll", query = "SELECT p FROM Prioridades p"),
    @NamedQuery(name = "Prioridades.findByIdPrioridades", query = "SELECT p FROM Prioridades p WHERE p.idPrioridades = :idPrioridades"),
    @NamedQuery(name = "Prioridades.findByNombrePrioridad", query = "SELECT p FROM Prioridades p WHERE p.nombrePrioridad = :nombrePrioridad")})
public class Prioridades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prioridades")
    private Integer idPrioridades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_prioridad")
    private String nombrePrioridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrioridades")
    private List<Avance> avanceList;

    public Prioridades() {
    }

    public Prioridades(Integer idPrioridades) {
        this.idPrioridades = idPrioridades;
    }

    public Prioridades(Integer idPrioridades, String nombrePrioridad) {
        this.idPrioridades = idPrioridades;
        this.nombrePrioridad = nombrePrioridad;
    }

    public Integer getIdPrioridades() {
        return idPrioridades;
    }

    public void setIdPrioridades(Integer idPrioridades) {
        this.idPrioridades = idPrioridades;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    @XmlTransient
    public List<Avance> getAvanceList() {
        return avanceList;
    }

    public void setAvanceList(List<Avance> avanceList) {
        this.avanceList = avanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrioridades != null ? idPrioridades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridades)) {
            return false;
        }
        Prioridades other = (Prioridades) object;
        if ((this.idPrioridades == null && other.idPrioridades != null) || (this.idPrioridades != null && !this.idPrioridades.equals(other.idPrioridades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePrioridad;
    }
    
}
