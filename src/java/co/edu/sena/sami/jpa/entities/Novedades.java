/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedades.findAll", query = "SELECT n FROM Novedades n"),
    @NamedQuery(name = "Novedades.findByIdNovedad", query = "SELECT n FROM Novedades n WHERE n.idNovedad = :idNovedad"),
    @NamedQuery(name = "Novedades.findByFechaNavedad", query = "SELECT n FROM Novedades n WHERE n.fechaNavedad = :fechaNavedad"),
    @NamedQuery(name = "Novedades.findByDescripcionNovedad", query = "SELECT n FROM Novedades n WHERE n.descripcionNovedad = :descripcionNovedad")})
public class Novedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad")
    private Integer idNovedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_navedad")
    @Temporal(TemporalType.DATE)
    private Date fechaNavedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion_novedad")
    private String descripcionNovedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "novedades")
    private List<NovedadesListasDeChequeos> novedadesListasDeChequeosList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Novedades() {
    }

    public Novedades(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Novedades(Integer idNovedad, Date fechaNavedad, String descripcionNovedad) {
        this.idNovedad = idNovedad;
        this.fechaNavedad = fechaNavedad;
        this.descripcionNovedad = descripcionNovedad;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Date getFechaNavedad() {
        return fechaNavedad;
    }

    public void setFechaNavedad(Date fechaNavedad) {
        this.fechaNavedad = fechaNavedad;
    }

    public String getDescripcionNovedad() {
        return descripcionNovedad;
    }

    public void setDescripcionNovedad(String descripcionNovedad) {
        this.descripcionNovedad = descripcionNovedad;
    }

    @XmlTransient
    public List<NovedadesListasDeChequeos> getNovedadesListasDeChequeosList() {
        return novedadesListasDeChequeosList;
    }

    public void setNovedadesListasDeChequeosList(List<NovedadesListasDeChequeos> novedadesListasDeChequeosList) {
        this.novedadesListasDeChequeosList = novedadesListasDeChequeosList;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedades)) {
            return false;
        }
        Novedades other = (Novedades) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Novedades[ idNovedad=" + idNovedad + " ]";
    }
    
}
