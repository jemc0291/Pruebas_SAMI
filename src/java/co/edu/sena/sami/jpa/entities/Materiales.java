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
@Table(name = "materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m"),
    @NamedQuery(name = "Materiales.findByIdMateriales", query = "SELECT m FROM Materiales m WHERE m.idMateriales = :idMateriales"),
    @NamedQuery(name = "Materiales.findByNombreMaterial", query = "SELECT m FROM Materiales m WHERE m.nombreMaterial = :nombreMaterial"),
    @NamedQuery(name = "Materiales.findByUnidadMedida", query = "SELECT m FROM Materiales m WHERE m.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Materiales.findByTipoMaterial", query = "SELECT m FROM Materiales m WHERE m.tipoMaterial = :tipoMaterial"),
    @NamedQuery(name = "Materiales.findByDescripcionelemento", query = "SELECT m FROM Materiales m WHERE m.descripcionelemento = :descripcionelemento")})
public class Materiales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materiales")
    private Integer idMateriales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombre_material")
    private String nombreMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "tipo_material")
    private Character tipoMaterial;
    @Size(max = 200)
    @Column(name = "Descripcion_elemento")
    private String descripcionelemento;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiales")
    private List<SolicitudMaterialesAlmacenMateriales> solicitudMaterialesAlmacenMaterialesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiales")
    private List<NotaEntradaMateriales> notaEntradaMaterialesList;

    public Materiales() {
    }

    public Materiales(Integer idMateriales) {
        this.idMateriales = idMateriales;
    }

    public Materiales(Integer idMateriales, String nombreMaterial, String unidadMedida) {
        this.idMateriales = idMateriales;
        this.nombreMaterial = nombreMaterial;
        this.unidadMedida = unidadMedida;
    }

    public Integer getIdMateriales() {
        return idMateriales;
    }

    public void setIdMateriales(Integer idMateriales) {
        this.idMateriales = idMateriales;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Character getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(Character tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getDescripcionelemento() {
        return descripcionelemento;
    }

    public void setDescripcionelemento(String descripcionelemento) {
        this.descripcionelemento = descripcionelemento;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public List<SolicitudMaterialesAlmacenMateriales> getSolicitudMaterialesAlmacenMaterialesList() {
        return solicitudMaterialesAlmacenMaterialesList;
    }

    public void setSolicitudMaterialesAlmacenMaterialesList(List<SolicitudMaterialesAlmacenMateriales> solicitudMaterialesAlmacenMaterialesList) {
        this.solicitudMaterialesAlmacenMaterialesList = solicitudMaterialesAlmacenMaterialesList;
    }

    @XmlTransient
    public List<NotaEntradaMateriales> getNotaEntradaMaterialesList() {
        return notaEntradaMaterialesList;
    }

    public void setNotaEntradaMaterialesList(List<NotaEntradaMateriales> notaEntradaMaterialesList) {
        this.notaEntradaMaterialesList = notaEntradaMaterialesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriales != null ? idMateriales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.idMateriales == null && other.idMateriales != null) || (this.idMateriales != null && !this.idMateriales.equals(other.idMateriales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Materiales[ idMateriales=" + idMateriales + " ]";
    }
    
}
