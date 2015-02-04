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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "conceptos_de_gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptosDeGastos.findAll", query = "SELECT c FROM ConceptosDeGastos c"),
    @NamedQuery(name = "ConceptosDeGastos.findByCodigoGasto", query = "SELECT c FROM ConceptosDeGastos c WHERE c.codigoGasto = :codigoGasto"),
    @NamedQuery(name = "ConceptosDeGastos.findByNombreGasto", query = "SELECT c FROM ConceptosDeGastos c WHERE c.nombreGasto = :nombreGasto")})
public class ConceptosDeGastos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_gasto")
    private Integer codigoGasto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "nombre_gasto")
    private String nombreGasto;
    @JoinTable(name = "crp_conceptos_de_gastos", joinColumns = {
        @JoinColumn(name = "codigo_gasto", referencedColumnName = "codigo_gasto")}, inverseJoinColumns = {
        @JoinColumn(name = "numero_crp", referencedColumnName = "numero_crp")})
    @ManyToMany
    private List<Crp> crpList;
    @ManyToMany(mappedBy = "conceptosDeGastosList")
    private List<Cdp> cdpList;
    @JoinTable(name = "legalizaciones_de_comisiones_conceptos_de_gastos", joinColumns = {
        @JoinColumn(name = "codigo_gasto", referencedColumnName = "codigo_gasto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_legalizacion_de_comision", referencedColumnName = "id_legalizacion_de_comision")})
    @ManyToMany
    private List<LegalizacionesDeComisiones> legalizacionesDeComisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoGasto")
    private List<Legalizaciones> legalizacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conceptosDeGastos")
    private List<OrdenesDeViajeConceptosDeGastos> ordenesDeViajeConceptosDeGastosList;

    public ConceptosDeGastos() {
    }

    public ConceptosDeGastos(Integer codigoGasto) {
        this.codigoGasto = codigoGasto;
    }

    public ConceptosDeGastos(Integer codigoGasto, String nombreGasto) {
        this.codigoGasto = codigoGasto;
        this.nombreGasto = nombreGasto;
    }

    public Integer getCodigoGasto() {
        return codigoGasto;
    }

    public void setCodigoGasto(Integer codigoGasto) {
        this.codigoGasto = codigoGasto;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    @XmlTransient
    public List<Crp> getCrpList() {
        return crpList;
    }

    public void setCrpList(List<Crp> crpList) {
        this.crpList = crpList;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    @XmlTransient
    public List<LegalizacionesDeComisiones> getLegalizacionesDeComisionesList() {
        return legalizacionesDeComisionesList;
    }

    public void setLegalizacionesDeComisionesList(List<LegalizacionesDeComisiones> legalizacionesDeComisionesList) {
        this.legalizacionesDeComisionesList = legalizacionesDeComisionesList;
    }

    @XmlTransient
    public List<Legalizaciones> getLegalizacionesList() {
        return legalizacionesList;
    }

    public void setLegalizacionesList(List<Legalizaciones> legalizacionesList) {
        this.legalizacionesList = legalizacionesList;
    }

    @XmlTransient
    public List<OrdenesDeViajeConceptosDeGastos> getOrdenesDeViajeConceptosDeGastosList() {
        return ordenesDeViajeConceptosDeGastosList;
    }

    public void setOrdenesDeViajeConceptosDeGastosList(List<OrdenesDeViajeConceptosDeGastos> ordenesDeViajeConceptosDeGastosList) {
        this.ordenesDeViajeConceptosDeGastosList = ordenesDeViajeConceptosDeGastosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGasto != null ? codigoGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptosDeGastos)) {
            return false;
        }
        ConceptosDeGastos other = (ConceptosDeGastos) object;
        if ((this.codigoGasto == null && other.codigoGasto != null) || (this.codigoGasto != null && !this.codigoGasto.equals(other.codigoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ConceptosDeGastos[ codigoGasto=" + codigoGasto + " ]";
    }
    
}
