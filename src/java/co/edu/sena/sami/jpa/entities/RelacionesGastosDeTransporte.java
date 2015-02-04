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
 * @author Adsim
 */
@Entity
@Table(name = "relaciones_gastos_de_transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacionesGastosDeTransporte.findAll", query = "SELECT r FROM RelacionesGastosDeTransporte r"),
    @NamedQuery(name = "RelacionesGastosDeTransporte.findByIdRelacionesGastosDeTransporte", query = "SELECT r FROM RelacionesGastosDeTransporte r WHERE r.idRelacionesGastosDeTransporte = :idRelacionesGastosDeTransporte"),
    @NamedQuery(name = "RelacionesGastosDeTransporte.findByFechaDeCreacion", query = "SELECT r FROM RelacionesGastosDeTransporte r WHERE r.fechaDeCreacion = :fechaDeCreacion"),
    @NamedQuery(name = "RelacionesGastosDeTransporte.findByObjetivoRelacionGastosDeTransporte", query = "SELECT r FROM RelacionesGastosDeTransporte r WHERE r.objetivoRelacionGastosDeTransporte = :objetivoRelacionGastosDeTransporte"),
    @NamedQuery(name = "RelacionesGastosDeTransporte.findByTotalGastosDeTransporte", query = "SELECT r FROM RelacionesGastosDeTransporte r WHERE r.totalGastosDeTransporte = :totalGastosDeTransporte"),
    @NamedQuery(name = "RelacionesGastosDeTransporte.findByDias", query = "SELECT r FROM RelacionesGastosDeTransporte r WHERE r.dias = :dias"),
    @NamedQuery(name = "RelacionesGastosDeTransporte.findByFechaSalida", query = "SELECT r FROM RelacionesGastosDeTransporte r WHERE r.fechaSalida = :fechaSalida")})
public class RelacionesGastosDeTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_relaciones_gastos_de_transporte")
    private Integer idRelacionesGastosDeTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_de_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objetivo_relacion_gastos_de_transporte")
    private String objetivoRelacionGastosDeTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_gastos_de_transporte")
    private int totalGastosDeTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dias")
    private String dias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @JoinTable(name = "relaciones_gastos_de_transporte_tarifas", joinColumns = {
        @JoinColumn(name = "id_relaciones_gastos_de_transporte", referencedColumnName = "id_relaciones_gastos_de_transporte")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tarifa", referencedColumnName = "id_tarifa")})
    @ManyToMany
    private List<Tarifas> tarifasList;
    @ManyToMany(mappedBy = "relacionesGastosDeTransporteList")
    private List<Ciudad> ciudadList;
    @JoinColumn(name = "numero_ordendeviaje", referencedColumnName = "numero_ordendeviaje")
    @ManyToOne(optional = false)
    private OrdenesDeviaje numeroOrdendeviaje;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRelacionesGastosDeTransporte")
    private List<OrdenesDeviaje> ordenesDeviajeList;

    public RelacionesGastosDeTransporte() {
    }

    public RelacionesGastosDeTransporte(Integer idRelacionesGastosDeTransporte) {
        this.idRelacionesGastosDeTransporte = idRelacionesGastosDeTransporte;
    }

    public RelacionesGastosDeTransporte(Integer idRelacionesGastosDeTransporte, Date fechaDeCreacion, String objetivoRelacionGastosDeTransporte, int totalGastosDeTransporte, String dias, Date fechaSalida) {
        this.idRelacionesGastosDeTransporte = idRelacionesGastosDeTransporte;
        this.fechaDeCreacion = fechaDeCreacion;
        this.objetivoRelacionGastosDeTransporte = objetivoRelacionGastosDeTransporte;
        this.totalGastosDeTransporte = totalGastosDeTransporte;
        this.dias = dias;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdRelacionesGastosDeTransporte() {
        return idRelacionesGastosDeTransporte;
    }

    public void setIdRelacionesGastosDeTransporte(Integer idRelacionesGastosDeTransporte) {
        this.idRelacionesGastosDeTransporte = idRelacionesGastosDeTransporte;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getObjetivoRelacionGastosDeTransporte() {
        return objetivoRelacionGastosDeTransporte;
    }

    public void setObjetivoRelacionGastosDeTransporte(String objetivoRelacionGastosDeTransporte) {
        this.objetivoRelacionGastosDeTransporte = objetivoRelacionGastosDeTransporte;
    }

    public int getTotalGastosDeTransporte() {
        return totalGastosDeTransporte;
    }

    public void setTotalGastosDeTransporte(int totalGastosDeTransporte) {
        this.totalGastosDeTransporte = totalGastosDeTransporte;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @XmlTransient
    public List<Tarifas> getTarifasList() {
        return tarifasList;
    }

    public void setTarifasList(List<Tarifas> tarifasList) {
        this.tarifasList = tarifasList;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public OrdenesDeviaje getNumeroOrdendeviaje() {
        return numeroOrdendeviaje;
    }

    public void setNumeroOrdendeviaje(OrdenesDeviaje numeroOrdendeviaje) {
        this.numeroOrdendeviaje = numeroOrdendeviaje;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelacionesGastosDeTransporte != null ? idRelacionesGastosDeTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionesGastosDeTransporte)) {
            return false;
        }
        RelacionesGastosDeTransporte other = (RelacionesGastosDeTransporte) object;
        if ((this.idRelacionesGastosDeTransporte == null && other.idRelacionesGastosDeTransporte != null) || (this.idRelacionesGastosDeTransporte != null && !this.idRelacionesGastosDeTransporte.equals(other.idRelacionesGastosDeTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.RelacionesGastosDeTransporte[ idRelacionesGastosDeTransporte=" + idRelacionesGastosDeTransporte + " ]";
    }
    
}
