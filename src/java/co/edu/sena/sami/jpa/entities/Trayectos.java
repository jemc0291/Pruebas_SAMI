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
import javax.persistence.ManyToMany;
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
@Table(name = "trayectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trayectos.findAll", query = "SELECT t FROM Trayectos t"),
    @NamedQuery(name = "Trayectos.findByIdTrayecto", query = "SELECT t FROM Trayectos t WHERE t.idTrayecto = :idTrayecto"),
    @NamedQuery(name = "Trayectos.findByNombreTrayecto", query = "SELECT t FROM Trayectos t WHERE t.nombreTrayecto = :nombreTrayecto"),
    @NamedQuery(name = "Trayectos.findBySalidaEstimada", query = "SELECT t FROM Trayectos t WHERE t.salidaEstimada = :salidaEstimada"),
    @NamedQuery(name = "Trayectos.findByLlegadaEstimada", query = "SELECT t FROM Trayectos t WHERE t.llegadaEstimada = :llegadaEstimada"),
    @NamedQuery(name = "Trayectos.findByNumeroDias", query = "SELECT t FROM Trayectos t WHERE t.numeroDias = :numeroDias")})
public class Trayectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trayecto")
    private Integer idTrayecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_trayecto")
    private String nombreTrayecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salida_estimada")
    @Temporal(TemporalType.DATE)
    private Date salidaEstimada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "llegada_estimada")
    @Temporal(TemporalType.DATE)
    private Date llegadaEstimada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_dias")
    private String numeroDias;
    @ManyToMany(mappedBy = "trayectosList")
    private List<OrdenesDeviaje> ordenesDeviajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrayecto")
    private List<OrdenesDeviaje> ordenesDeviajeList1;

    public Trayectos() {
    }

    public Trayectos(Integer idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public Trayectos(Integer idTrayecto, String nombreTrayecto, Date salidaEstimada, Date llegadaEstimada, String numeroDias) {
        this.idTrayecto = idTrayecto;
        this.nombreTrayecto = nombreTrayecto;
        this.salidaEstimada = salidaEstimada;
        this.llegadaEstimada = llegadaEstimada;
        this.numeroDias = numeroDias;
    }

    public Integer getIdTrayecto() {
        return idTrayecto;
    }

    public void setIdTrayecto(Integer idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public String getNombreTrayecto() {
        return nombreTrayecto;
    }

    public void setNombreTrayecto(String nombreTrayecto) {
        this.nombreTrayecto = nombreTrayecto;
    }

    public Date getSalidaEstimada() {
        return salidaEstimada;
    }

    public void setSalidaEstimada(Date salidaEstimada) {
        this.salidaEstimada = salidaEstimada;
    }

    public Date getLlegadaEstimada() {
        return llegadaEstimada;
    }

    public void setLlegadaEstimada(Date llegadaEstimada) {
        this.llegadaEstimada = llegadaEstimada;
    }

    public String getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(String numeroDias) {
        this.numeroDias = numeroDias;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList1() {
        return ordenesDeviajeList1;
    }

    public void setOrdenesDeviajeList1(List<OrdenesDeviaje> ordenesDeviajeList1) {
        this.ordenesDeviajeList1 = ordenesDeviajeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrayecto != null ? idTrayecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trayectos)) {
            return false;
        }
        Trayectos other = (Trayectos) object;
        if ((this.idTrayecto == null && other.idTrayecto != null) || (this.idTrayecto != null && !this.idTrayecto.equals(other.idTrayecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Trayectos[ idTrayecto=" + idTrayecto + " ]";
    }
    
}
