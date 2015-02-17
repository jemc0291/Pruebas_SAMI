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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "ordenes_de_viaje_crp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDeViajeCrp.findAll", query = "SELECT o FROM OrdenesDeViajeCrp o"),
    @NamedQuery(name = "OrdenesDeViajeCrp.findByNumeroCrp", query = "SELECT o FROM OrdenesDeViajeCrp o WHERE o.numeroCrp = :numeroCrp")})
public class OrdenesDeViajeCrp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_crp")
    private String numeroCrp;
    @JoinColumn(name = "numero_crp", referencedColumnName = "numero_crp", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Crp crp;

    public OrdenesDeViajeCrp() {
    }

    public OrdenesDeViajeCrp(String numeroCrp) {
        this.numeroCrp = numeroCrp;
    }

    public String getNumeroCrp() {
        return numeroCrp;
    }

    public void setNumeroCrp(String numeroCrp) {
        this.numeroCrp = numeroCrp;
    }

    public Crp getCrp() {
        return crp;
    }

    public void setCrp(Crp crp) {
        this.crp = crp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCrp != null ? numeroCrp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDeViajeCrp)) {
            return false;
        }
        OrdenesDeViajeCrp other = (OrdenesDeViajeCrp) object;
        if ((this.numeroCrp == null && other.numeroCrp != null) || (this.numeroCrp != null && !this.numeroCrp.equals(other.numeroCrp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.OrdenesDeViajeCrp[ numeroCrp=" + numeroCrp + " ]";
    }
    
}
