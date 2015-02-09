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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "gestiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestiones.findAll", query = "SELECT g FROM Gestiones g"),
    @NamedQuery(name = "Gestiones.findByCodigoGestion", query = "SELECT g FROM Gestiones g WHERE g.codigoGestion = :codigoGestion"),
    @NamedQuery(name = "Gestiones.findByNombreGestion", query = "SELECT g FROM Gestiones g WHERE g.nombreGestion = :nombreGestion")})
public class Gestiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo_gestion")
    private String codigoGestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre_gestion")
    private String nombreGestion;
    @ManyToMany(mappedBy = "gestionesList")
    private List<Cdp> cdpList;
    @ManyToMany(mappedBy = "gestionesList")
    private List<Crp> crpList;

    public Gestiones() {
    }

    public Gestiones(String codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public Gestiones(String codigoGestion, String nombreGestion) {
        this.codigoGestion = codigoGestion;
        this.nombreGestion = nombreGestion;
    }

    public String getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(String codigoGestion) {
        this.codigoGestion = codigoGestion;
    }

    public String getNombreGestion() {
        return nombreGestion;
    }

    public void setNombreGestion(String nombreGestion) {
        this.nombreGestion = nombreGestion;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    @XmlTransient
    public List<Crp> getCrpList() {
        return crpList;
    }

    public void setCrpList(List<Crp> crpList) {
        this.crpList = crpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGestion != null ? codigoGestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestiones)) {
            return false;
        }
        Gestiones other = (Gestiones) object;
        if ((this.codigoGestion == null && other.codigoGestion != null) || (this.codigoGestion != null && !this.codigoGestion.equals(other.codigoGestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Gestiones[ codigoGestion=" + codigoGestion + " ]";
    }
    
}
