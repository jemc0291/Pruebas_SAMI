/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "solicitud_materiales_almacen_materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudMaterialesAlmacenMateriales.findAll", query = "SELECT s FROM SolicitudMaterialesAlmacenMateriales s"),
    @NamedQuery(name = "SolicitudMaterialesAlmacenMateriales.findByIdSolicitudMaterial", query = "SELECT s FROM SolicitudMaterialesAlmacenMateriales s WHERE s.solicitudMaterialesAlmacenMaterialesPK.idSolicitudMaterial = :idSolicitudMaterial"),
    @NamedQuery(name = "SolicitudMaterialesAlmacenMateriales.findByIdMateriales", query = "SELECT s FROM SolicitudMaterialesAlmacenMateriales s WHERE s.solicitudMaterialesAlmacenMaterialesPK.idMateriales = :idMateriales"),
    @NamedQuery(name = "SolicitudMaterialesAlmacenMateriales.findByCantidad", query = "SELECT s FROM SolicitudMaterialesAlmacenMateriales s WHERE s.cantidad = :cantidad")})
public class SolicitudMaterialesAlmacenMateriales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudMaterialesAlmacenMaterialesPK solicitudMaterialesAlmacenMaterialesPK;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "id_solicitud_material", referencedColumnName = "id_solicitud_material", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SolicitudMaterialesAlmacen solicitudMaterialesAlmacen;
    @JoinColumn(name = "id_materiales", referencedColumnName = "id_materiales", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materiales materiales;

    public SolicitudMaterialesAlmacenMateriales() {
    }

    public SolicitudMaterialesAlmacenMateriales(SolicitudMaterialesAlmacenMaterialesPK solicitudMaterialesAlmacenMaterialesPK) {
        this.solicitudMaterialesAlmacenMaterialesPK = solicitudMaterialesAlmacenMaterialesPK;
    }

    public SolicitudMaterialesAlmacenMateriales(int idSolicitudMaterial, int idMateriales) {
        this.solicitudMaterialesAlmacenMaterialesPK = new SolicitudMaterialesAlmacenMaterialesPK(idSolicitudMaterial, idMateriales);
    }

    public SolicitudMaterialesAlmacenMaterialesPK getSolicitudMaterialesAlmacenMaterialesPK() {
        return solicitudMaterialesAlmacenMaterialesPK;
    }

    public void setSolicitudMaterialesAlmacenMaterialesPK(SolicitudMaterialesAlmacenMaterialesPK solicitudMaterialesAlmacenMaterialesPK) {
        this.solicitudMaterialesAlmacenMaterialesPK = solicitudMaterialesAlmacenMaterialesPK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public SolicitudMaterialesAlmacen getSolicitudMaterialesAlmacen() {
        return solicitudMaterialesAlmacen;
    }

    public void setSolicitudMaterialesAlmacen(SolicitudMaterialesAlmacen solicitudMaterialesAlmacen) {
        this.solicitudMaterialesAlmacen = solicitudMaterialesAlmacen;
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudMaterialesAlmacenMaterialesPK != null ? solicitudMaterialesAlmacenMaterialesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudMaterialesAlmacenMateriales)) {
            return false;
        }
        SolicitudMaterialesAlmacenMateriales other = (SolicitudMaterialesAlmacenMateriales) object;
        if ((this.solicitudMaterialesAlmacenMaterialesPK == null && other.solicitudMaterialesAlmacenMaterialesPK != null) || (this.solicitudMaterialesAlmacenMaterialesPK != null && !this.solicitudMaterialesAlmacenMaterialesPK.equals(other.solicitudMaterialesAlmacenMaterialesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMateriales[ solicitudMaterialesAlmacenMaterialesPK=" + solicitudMaterialesAlmacenMaterialesPK + " ]";
    }
    
}
