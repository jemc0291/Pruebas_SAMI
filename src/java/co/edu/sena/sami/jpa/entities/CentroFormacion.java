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
@Table(name = "centro_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroFormacion.findAll", query = "SELECT c FROM CentroFormacion c"),
    @NamedQuery(name = "CentroFormacion.findByIdCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.idCentroFormacion = :idCentroFormacion"),
    @NamedQuery(name = "CentroFormacion.findByNombreCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.nombreCentroFormacion = :nombreCentroFormacion"),
    @NamedQuery(name = "CentroFormacion.findByDireccionCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.direccionCentroFormacion = :direccionCentroFormacion"),
    @NamedQuery(name = "CentroFormacion.findByTelefonoCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.telefonoCentroFormacion = :telefonoCentroFormacion")})
public class CentroFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_centro_formacion")
    private Integer idCentroFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_centro_formacion")
    private String nombreCentroFormacion;
    @Size(max = 80)
    @Column(name = "direccion_centro_formacion")
    private String direccionCentroFormacion;
    @Size(max = 15)
    @Column(name = "telefono_centro_formacion")
    private String telefonoCentroFormacion;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @OneToMany(mappedBy = "idCentroFormacion")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroFormacion")
    private List<Comisiones> comisionesList;

    public CentroFormacion() {
    }

    public CentroFormacion(Integer idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public CentroFormacion(Integer idCentroFormacion, String nombreCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
        this.nombreCentroFormacion = nombreCentroFormacion;
    }

    public Integer getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(Integer idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public String getNombreCentroFormacion() {
        return nombreCentroFormacion;
    }

    public void setNombreCentroFormacion(String nombreCentroFormacion) {
        this.nombreCentroFormacion = nombreCentroFormacion;
    }

    public String getDireccionCentroFormacion() {
        return direccionCentroFormacion;
    }

    public void setDireccionCentroFormacion(String direccionCentroFormacion) {
        this.direccionCentroFormacion = direccionCentroFormacion;
    }

    public String getTelefonoCentroFormacion() {
        return telefonoCentroFormacion;
    }

    public void setTelefonoCentroFormacion(String telefonoCentroFormacion) {
        this.telefonoCentroFormacion = telefonoCentroFormacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
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
        hash += (idCentroFormacion != null ? idCentroFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroFormacion)) {
            return false;
        }
        CentroFormacion other = (CentroFormacion) object;
        if ((this.idCentroFormacion == null && other.idCentroFormacion != null) || (this.idCentroFormacion != null && !this.idCentroFormacion.equals(other.idCentroFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCentroFormacion + " ";
    }
    
}
