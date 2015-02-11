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
 * @author Usuario
 */
@Entity
@Table(name = "descripciones_referencias_viaticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionesReferenciasViaticos.findAll", query = "SELECT d FROM DescripcionesReferenciasViaticos d"),
    @NamedQuery(name = "DescripcionesReferenciasViaticos.findByIdDescripcion", query = "SELECT d FROM DescripcionesReferenciasViaticos d WHERE d.idDescripcion = :idDescripcion"),
    @NamedQuery(name = "DescripcionesReferenciasViaticos.findByNombreDescripcion", query = "SELECT d FROM DescripcionesReferenciasViaticos d WHERE d.nombreDescripcion = :nombreDescripcion")})
public class DescripcionesReferenciasViaticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_descripcion")
    private Integer idDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "nombre_descripcion")
    private String nombreDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescripcion")
    private List<Comisiones> comisionesList;

    public DescripcionesReferenciasViaticos() {
    }

    public DescripcionesReferenciasViaticos(Integer idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public DescripcionesReferenciasViaticos(Integer idDescripcion, String nombreDescripcion) {
        this.idDescripcion = idDescripcion;
        this.nombreDescripcion = nombreDescripcion;
    }

    public Integer getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(Integer idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public String getNombreDescripcion() {
        return nombreDescripcion;
    }

    public void setNombreDescripcion(String nombreDescripcion) {
        this.nombreDescripcion = nombreDescripcion;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescripcion != null ? idDescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionesReferenciasViaticos)) {
            return false;
        }
        DescripcionesReferenciasViaticos other = (DescripcionesReferenciasViaticos) object;
        if ((this.idDescripcion == null && other.idDescripcion != null) || (this.idDescripcion != null && !this.idDescripcion.equals(other.idDescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.DescripcionesReferenciasViaticos[ idDescripcion=" + idDescripcion + " ]";
    }
    
}
