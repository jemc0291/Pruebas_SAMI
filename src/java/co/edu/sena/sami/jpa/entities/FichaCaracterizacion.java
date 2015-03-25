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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ficha_caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaCaracterizacion.findAll", query = "SELECT f FROM FichaCaracterizacion f"),
    @NamedQuery(name = "FichaCaracterizacion.findByIdFichaCaracterizacion", query = "SELECT f FROM FichaCaracterizacion f WHERE f.idFichaCaracterizacion = :idFichaCaracterizacion"),
    @NamedQuery(name = "FichaCaracterizacion.findByFechaInicio", query = "SELECT f FROM FichaCaracterizacion f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "FichaCaracterizacion.findByFechaFin", query = "SELECT f FROM FichaCaracterizacion f WHERE f.fechaFin = :fechaFin"),
    @NamedQuery(name = "FichaCaracterizacion.findByCodigoFicha", query = "SELECT f FROM FichaCaracterizacion f WHERE f.codigoFicha like :codigoFicha")})
public class FichaCaracterizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ficha_caracterizacion")
    private Integer idFichaCaracterizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
     @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_ficha")
    private String codigoFicha;
    @JoinTable(name = "proyectos_fichas", joinColumns = {
        @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_proyecto_formacion", referencedColumnName = "id_proyecto_formacion")})
    @ManyToMany
    private List<ProyectoFormacion> proyectoFormacionList;
    @ManyToMany(mappedBy = "fichaCaracterizacionList")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<SolicitudMaterialesAlmacen> solicitudMaterialesAlmacenList;
    @JoinColumn(name = "id_programa_formacion", referencedColumnName = "id_programa_formacion")
    @ManyToOne(optional = false)
    private ProgramaDeFormacion idProgramaFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<Comisiones> comisionesList;

    public FichaCaracterizacion() {
    }

    public FichaCaracterizacion(Integer idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public FichaCaracterizacion(Integer idFichaCaracterizacion, Date fechaInicio, Date fechaFin) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.codigoFicha = codigoFicha;
    }

    public Integer getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(Integer idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
        public String getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(String codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    @XmlTransient
    public List<ProyectoFormacion> getProyectoFormacionList() {
        return proyectoFormacionList;
    }

    public void setProyectoFormacionList(List<ProyectoFormacion> proyectoFormacionList) {
        this.proyectoFormacionList = proyectoFormacionList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<SolicitudMaterialesAlmacen> getSolicitudMaterialesAlmacenList() {
        return solicitudMaterialesAlmacenList;
    }

    public void setSolicitudMaterialesAlmacenList(List<SolicitudMaterialesAlmacen> solicitudMaterialesAlmacenList) {
        this.solicitudMaterialesAlmacenList = solicitudMaterialesAlmacenList;
    }

    public ProgramaDeFormacion getIdProgramaFormacion() {
        return idProgramaFormacion;
    }

    public void setIdProgramaFormacion(ProgramaDeFormacion idProgramaFormacion) {
        this.idProgramaFormacion = idProgramaFormacion;
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
        hash += (idFichaCaracterizacion != null ? idFichaCaracterizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaCaracterizacion)) {
            return false;
        }
        FichaCaracterizacion other = (FichaCaracterizacion) object;
        if ((this.idFichaCaracterizacion == null && other.idFichaCaracterizacion != null) || (this.idFichaCaracterizacion != null && !this.idFichaCaracterizacion.equals(other.idFichaCaracterizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoFicha;
    }

}
