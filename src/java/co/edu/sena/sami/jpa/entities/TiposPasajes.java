/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Usuario
 */
@Entity
@Table(name = "tipos_pasajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposPasajes.findAll", query = "SELECT t FROM TiposPasajes t"),
    @NamedQuery(name = "TiposPasajes.findByIdTipoPasaje", query = "SELECT t FROM TiposPasajes t WHERE t.idTipoPasaje = :idTipoPasaje"),
    @NamedQuery(name = "TiposPasajes.findByNombreTipoPasaje", query = "SELECT t FROM TiposPasajes t WHERE t.nombreTipoPasaje = :nombreTipoPasaje")})
public class TiposPasajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_pasaje")
    private Integer idTipoPasaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_pasaje")
    private String nombreTipoPasaje;
    @OneToMany(mappedBy = "idTipoPasaje")
    private List<Comisiones> comisionesList;

    public TiposPasajes() {
    }

    public TiposPasajes(Integer idTipoPasaje) {
        this.idTipoPasaje = idTipoPasaje;
    }

    public TiposPasajes(Integer idTipoPasaje, String nombreTipoPasaje) {
        this.idTipoPasaje = idTipoPasaje;
        this.nombreTipoPasaje = nombreTipoPasaje;
    }

    public Integer getIdTipoPasaje() {
        return idTipoPasaje;
    }

    public void setIdTipoPasaje(Integer idTipoPasaje) {
        this.idTipoPasaje = idTipoPasaje;
    }

    public String getNombreTipoPasaje() {
        return nombreTipoPasaje;
    }

    public void setNombreTipoPasaje(String nombreTipoPasaje) {
        this.nombreTipoPasaje = nombreTipoPasaje;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPasaje != null ? idTipoPasaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposPasajes)) {
            return false;
        }
        TiposPasajes other = (TiposPasajes) object;
        if ((this.idTipoPasaje == null && other.idTipoPasaje != null) || (this.idTipoPasaje != null && !this.idTipoPasaje.equals(other.idTipoPasaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.TiposPasajes[ idTipoPasaje=" + idTipoPasaje + " ]";
    }
    
}
