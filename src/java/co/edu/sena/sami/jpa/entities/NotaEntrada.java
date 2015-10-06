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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "nota_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaEntrada.findAll", query = "SELECT n FROM NotaEntrada n"),
    @NamedQuery(name = "NotaEntrada.findByIdNota", query = "SELECT n FROM NotaEntrada n WHERE n.idNota = :idNota"),
    @NamedQuery(name = "NotaEntrada.findByFecha", query = "SELECT n FROM NotaEntrada n WHERE n.fecha = :fecha")})
public class NotaEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Nota")
    private Integer idNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToMany(mappedBy = "notaEntradaList")
    private List<Facturas> facturasList;
    @ManyToMany(mappedBy = "notaEntradaList")
    private List<Materiales> materialesList;

    public NotaEntrada() {
    }

    public NotaEntrada(Integer idNota) {
        this.idNota = idNota;
    }

    public NotaEntrada(Integer idNota, Date fecha) {
        this.idNota = idNota;
        this.fecha = fecha;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @XmlTransient
    public List<Materiales> getMaterialesList() {
        return materialesList;
    }

    public void setMaterialesList(List<Materiales> materialesList) {
        this.materialesList = materialesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaEntrada)) {
            return false;
        }
        NotaEntrada other = (NotaEntrada) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.NotaEntrada[ idNota=" + idNota + " ]";
    }
    
}
