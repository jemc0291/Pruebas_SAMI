/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByIdServicio", query = "SELECT s FROM Servicios s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicios.findByCodigoUnspsc", query = "SELECT s FROM Servicios s WHERE s.codigoUnspsc = :codigoUnspsc"),
    @NamedQuery(name = "Servicios.findByNombreServicio", query = "SELECT s FROM Servicios s WHERE s.nombreServicio = :nombreServicio"),
    @NamedQuery(name = "Servicios.findByUbicaci\u00f3n", query = "SELECT s FROM Servicios s WHERE s.ubicaci\u00f3n = :ubicaci\u00f3n"),
    @NamedQuery(name = "Servicios.findByTipo", query = "SELECT s FROM Servicios s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "Servicios.findByMarca", query = "SELECT s FROM Servicios s WHERE s.marca = :marca"),
    @NamedQuery(name = "Servicios.findByModelo", query = "SELECT s FROM Servicios s WHERE s.modelo = :modelo"),
    @NamedQuery(name = "Servicios.findByCapacidad", query = "SELECT s FROM Servicios s WHERE s.capacidad = :capacidad"),
    @NamedQuery(name = "Servicios.findByDetalleMantenimiento", query = "SELECT s FROM Servicios s WHERE s.detalleMantenimiento = :detalleMantenimiento")})
public class Servicios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Size(max = 45)
    @Column(name = "codigo unspsc")
    private String codigoUnspsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_Servicio")
    private String nombreServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ubicaci\u00f3n")
    private String ubicación;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "capacidad")
    private String capacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "detalle_mantenimiento")
    private String detalleMantenimiento;
    @JoinColumn(name = "id_tipo_serv", referencedColumnName = "id_tipo_serv")
    @ManyToOne(optional = false)
    private TipoDeServicios idTipoServ;

    public Servicios() {
    }

    public Servicios(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicios(Integer idServicio, String nombreServicio, String ubicación, String detalleMantenimiento) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.ubicación = ubicación;
        this.detalleMantenimiento = detalleMantenimiento;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getCodigoUnspsc() {
        return codigoUnspsc;
    }

    public void setCodigoUnspsc(String codigoUnspsc) {
        this.codigoUnspsc = codigoUnspsc;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getUbicación() {
        return ubicación;
    }

    public void setUbicación(String ubicación) {
        this.ubicación = ubicación;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getDetalleMantenimiento() {
        return detalleMantenimiento;
    }

    public void setDetalleMantenimiento(String detalleMantenimiento) {
        this.detalleMantenimiento = detalleMantenimiento;
    }

    public TipoDeServicios getIdTipoServ() {
        return idTipoServ;
    }

    public void setIdTipoServ(TipoDeServicios idTipoServ) {
        this.idTipoServ = idTipoServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Servicios[ idServicio=" + idServicio + " ]";
    }
    
}
