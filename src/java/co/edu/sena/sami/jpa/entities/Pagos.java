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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdPagos", query = "SELECT p FROM Pagos p WHERE p.idPagos = :idPagos"),
    @NamedQuery(name = "Pagos.findByValorCuota", query = "SELECT p FROM Pagos p WHERE p.valorCuota = :valorCuota"),
    @NamedQuery(name = "Pagos.findByHorasEjecutadas", query = "SELECT p FROM Pagos p WHERE p.horasEjecutadas = :horasEjecutadas")})
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pagos")
    private Integer idPagos;
    @Column(name = "valor_cuota")
    private Long valorCuota;
    @Column(name = "horas_ejecutadas")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horasEjecutadas;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contratos idContrato;

    public Pagos() {
    }

    public Pagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Integer getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Long getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Long valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Date getHorasEjecutadas() {
        return horasEjecutadas;
    }

    public void setHorasEjecutadas(Date horasEjecutadas) {
        this.horasEjecutadas = horasEjecutadas;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idPagos != null ? idPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPagos == null && other.idPagos != null) || (this.idPagos != null && !this.idPagos.equals(other.idPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Pagos[ idPagos=" + idPagos + " ]";
    }
    
}
