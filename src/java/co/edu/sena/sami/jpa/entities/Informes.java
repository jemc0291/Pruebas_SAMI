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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Usuario
 */
@Entity
@Table(name = "informes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informes.findAll", query = "SELECT i FROM Informes i"),
    @NamedQuery(name = "Informes.findByIdInformes", query = "SELECT i FROM Informes i WHERE i.idInformes = :idInformes"),
    @NamedQuery(name = "Informes.findByFechaInforme", query = "SELECT i FROM Informes i WHERE i.fechaInforme = :fechaInforme"),
    @NamedQuery(name = "Informes.findByObservaciones", query = "SELECT i FROM Informes i WHERE i.observaciones = :observaciones")})
public class Informes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_informes")
    private Integer idInformes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_informe")
    @Temporal(TemporalType.DATE)
    private Date fechaInforme;
    @Size(max = 5000)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contratos idContrato;

    public Informes() {
    }

    public Informes(Integer idInformes) {
        this.idInformes = idInformes;
    }

    public Informes(Integer idInformes, Date fechaInforme) {
        this.idInformes = idInformes;
        this.fechaInforme = fechaInforme;
    }

    public Integer getIdInformes() {
        return idInformes;
    }

    public void setIdInformes(Integer idInformes) {
        this.idInformes = idInformes;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Contratos getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contratos idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformes != null ? idInformes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informes)) {
            return false;
        }
        Informes other = (Informes) object;
        if ((this.idInformes == null && other.idInformes != null) || (this.idInformes != null && !this.idInformes.equals(other.idInformes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Informes[ idInformes=" + idInformes + " ]";
    }
    
}
