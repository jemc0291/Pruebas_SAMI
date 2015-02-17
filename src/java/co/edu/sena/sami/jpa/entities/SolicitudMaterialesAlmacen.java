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
@Table(name = "solicitud_materiales_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudMaterialesAlmacen.findAll", query = "SELECT s FROM SolicitudMaterialesAlmacen s"),
    @NamedQuery(name = "SolicitudMaterialesAlmacen.findByIdSolicitudMaterial", query = "SELECT s FROM SolicitudMaterialesAlmacen s WHERE s.idSolicitudMaterial = :idSolicitudMaterial"),
    @NamedQuery(name = "SolicitudMaterialesAlmacen.findByFechaDeSolicitud", query = "SELECT s FROM SolicitudMaterialesAlmacen s WHERE s.fechaDeSolicitud = :fechaDeSolicitud"),
    @NamedQuery(name = "SolicitudMaterialesAlmacen.findByObservaciones", query = "SELECT s FROM SolicitudMaterialesAlmacen s WHERE s.observaciones = :observaciones"),
    @NamedQuery(name = "SolicitudMaterialesAlmacen.findByAprobado", query = "SELECT s FROM SolicitudMaterialesAlmacen s WHERE s.aprobado = :aprobado"),
    @NamedQuery(name = "SolicitudMaterialesAlmacen.findByNoAprobado", query = "SELECT s FROM SolicitudMaterialesAlmacen s WHERE s.noAprobado = :noAprobado")})
public class SolicitudMaterialesAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud_material")
    private Integer idSolicitudMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_de_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeSolicitud;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Column(name = "no_aprobado")
    private Boolean noAprobado;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Areas idArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudMaterialesAlmacen")
    private List<UsuariosSolicitudMaterialesAlmacen> usuariosSolicitudMaterialesAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudMaterialesAlmacen")
    private List<SolicitudMaterialesAlmacenMateriales> solicitudMaterialesAlmacenMaterialesList;

    public SolicitudMaterialesAlmacen() {
    }

    public SolicitudMaterialesAlmacen(Integer idSolicitudMaterial) {
        this.idSolicitudMaterial = idSolicitudMaterial;
    }

    public SolicitudMaterialesAlmacen(Integer idSolicitudMaterial, Date fechaDeSolicitud) {
        this.idSolicitudMaterial = idSolicitudMaterial;
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public Integer getIdSolicitudMaterial() {
        return idSolicitudMaterial;
    }

    public void setIdSolicitudMaterial(Integer idSolicitudMaterial) {
        this.idSolicitudMaterial = idSolicitudMaterial;
    }

    public Date getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public void setFechaDeSolicitud(Date fechaDeSolicitud) {
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Boolean getNoAprobado() {
        return noAprobado;
    }

    public void setNoAprobado(Boolean noAprobado) {
        this.noAprobado = noAprobado;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public Areas getIdArea() {
        return idArea;
    }

    public void setIdArea(Areas idArea) {
        this.idArea = idArea;
    }

    @XmlTransient
    public List<UsuariosSolicitudMaterialesAlmacen> getUsuariosSolicitudMaterialesAlmacenList() {
        return usuariosSolicitudMaterialesAlmacenList;
    }

    public void setUsuariosSolicitudMaterialesAlmacenList(List<UsuariosSolicitudMaterialesAlmacen> usuariosSolicitudMaterialesAlmacenList) {
        this.usuariosSolicitudMaterialesAlmacenList = usuariosSolicitudMaterialesAlmacenList;
    }

    @XmlTransient
    public List<SolicitudMaterialesAlmacenMateriales> getSolicitudMaterialesAlmacenMaterialesList() {
        return solicitudMaterialesAlmacenMaterialesList;
    }

    public void setSolicitudMaterialesAlmacenMaterialesList(List<SolicitudMaterialesAlmacenMateriales> solicitudMaterialesAlmacenMaterialesList) {
        this.solicitudMaterialesAlmacenMaterialesList = solicitudMaterialesAlmacenMaterialesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudMaterial != null ? idSolicitudMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudMaterialesAlmacen)) {
            return false;
        }
        SolicitudMaterialesAlmacen other = (SolicitudMaterialesAlmacen) object;
        if ((this.idSolicitudMaterial == null && other.idSolicitudMaterial != null) || (this.idSolicitudMaterial != null && !this.idSolicitudMaterial.equals(other.idSolicitudMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacen[ idSolicitudMaterial=" + idSolicitudMaterial + " ]";
    }
    
}
