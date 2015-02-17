/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "informes_de_comisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformesDeComisiones.findAll", query = "SELECT i FROM InformesDeComisiones i"),
    @NamedQuery(name = "InformesDeComisiones.findByIdInformeComision", query = "SELECT i FROM InformesDeComisiones i WHERE i.idInformeComision = :idInformeComision"),
    @NamedQuery(name = "InformesDeComisiones.findByDias", query = "SELECT i FROM InformesDeComisiones i WHERE i.dias = :dias"),
    @NamedQuery(name = "InformesDeComisiones.findByFechaEntregaInforme", query = "SELECT i FROM InformesDeComisiones i WHERE i.fechaEntregaInforme = :fechaEntregaInforme"),
    @NamedQuery(name = "InformesDeComisiones.findByActividadesTemasDesarrollados", query = "SELECT i FROM InformesDeComisiones i WHERE i.actividadesTemasDesarrollados = :actividadesTemasDesarrollados"),
    @NamedQuery(name = "InformesDeComisiones.findByCompromisosSena", query = "SELECT i FROM InformesDeComisiones i WHERE i.compromisosSena = :compromisosSena"),
    @NamedQuery(name = "InformesDeComisiones.findByProductosEntregados", query = "SELECT i FROM InformesDeComisiones i WHERE i.productosEntregados = :productosEntregados")})
public class InformesDeComisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_informe_comision")
    private Integer idInformeComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dias")
    private String dias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega_informe")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaInforme;
    @Size(max = 4500)
    @Column(name = "actividades_temas_desarrollados")
    private String actividadesTemasDesarrollados;
    @Size(max = 4500)
    @Column(name = "compromisos_sena")
    private String compromisosSena;
    @Size(max = 4500)
    @Column(name = "productos_entregados")
    private String productosEntregados;
    @JoinColumn(name = "id_comision", referencedColumnName = "id_comision")
    @ManyToOne(optional = false)
    private Comisiones idComision;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public InformesDeComisiones() {
    }

    public InformesDeComisiones(Integer idInformeComision) {
        this.idInformeComision = idInformeComision;
    }

    public InformesDeComisiones(Integer idInformeComision, String dias, Date fechaEntregaInforme) {
        this.idInformeComision = idInformeComision;
        this.dias = dias;
        this.fechaEntregaInforme = fechaEntregaInforme;
    }

    public Integer getIdInformeComision() {
        return idInformeComision;
    }

    public void setIdInformeComision(Integer idInformeComision) {
        this.idInformeComision = idInformeComision;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Date getFechaEntregaInforme() {
        return fechaEntregaInforme;
    }

    public void setFechaEntregaInforme(Date fechaEntregaInforme) {
        this.fechaEntregaInforme = fechaEntregaInforme;
    }

    public String getActividadesTemasDesarrollados() {
        return actividadesTemasDesarrollados;
    }

    public void setActividadesTemasDesarrollados(String actividadesTemasDesarrollados) {
        this.actividadesTemasDesarrollados = actividadesTemasDesarrollados;
    }

    public String getCompromisosSena() {
        return compromisosSena;
    }

    public void setCompromisosSena(String compromisosSena) {
        this.compromisosSena = compromisosSena;
    }

    public String getProductosEntregados() {
        return productosEntregados;
    }

    public void setProductosEntregados(String productosEntregados) {
        this.productosEntregados = productosEntregados;
    }

    public Comisiones getIdComision() {
        return idComision;
    }

    public void setIdComision(Comisiones idComision) {
        this.idComision = idComision;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
        hash += (idInformeComision != null ? idInformeComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformesDeComisiones)) {
            return false;
        }
        InformesDeComisiones other = (InformesDeComisiones) object;
        if ((this.idInformeComision == null && other.idInformeComision != null) || (this.idInformeComision != null && !this.idInformeComision.equals(other.idInformeComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.InformesDeComisiones[ idInformeComision=" + idInformeComision + " ]";
    }
    
}
