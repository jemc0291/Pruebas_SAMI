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
@Table(name = "tipo_de_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeContrato.findAll", query = "SELECT t FROM TipoDeContrato t"),
    @NamedQuery(name = "TipoDeContrato.findByIdTipoContrato", query = "SELECT t FROM TipoDeContrato t WHERE t.idTipoContrato = :idTipoContrato"),
    @NamedQuery(name = "TipoDeContrato.findByNombreTipoContrato", query = "SELECT t FROM TipoDeContrato t WHERE t.nombreTipoContrato = :nombreTipoContrato")})
public class TipoDeContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_contrato")
    private Integer idTipoContrato;
    @Size(max = 45)
    @Column(name = "nombre_tipo_contrato")
    private String nombreTipoContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoContrato")
    private List<Contratos> contratosList;

    public TipoDeContrato() {
    }

    public TipoDeContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getNombreTipoContrato() {
        return nombreTipoContrato;
    }

    public void setNombreTipoContrato(String nombreTipoContrato) {
        this.nombreTipoContrato = nombreTipoContrato;
    }

    @XmlTransient
    public List<Contratos> getContratosList() {
        return contratosList;
    }

    public void setContratosList(List<Contratos> contratosList) {
        this.contratosList = contratosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoContrato != null ? idTipoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeContrato)) {
            return false;
        }
        TipoDeContrato other = (TipoDeContrato) object;
        if ((this.idTipoContrato == null && other.idTipoContrato != null) || (this.idTipoContrato != null && !this.idTipoContrato.equals(other.idTipoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTipoContrato;
    }
    
}
