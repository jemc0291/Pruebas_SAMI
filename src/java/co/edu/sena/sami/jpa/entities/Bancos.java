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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "bancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findByIdBanco", query = "SELECT b FROM Bancos b WHERE b.idBanco = :idBanco"),
    @NamedQuery(name = "Bancos.findByNitBanco", query = "SELECT b FROM Bancos b WHERE b.nitBanco = :nitBanco"),
    @NamedQuery(name = "Bancos.findByNombreDeBanco", query = "SELECT b FROM Bancos b WHERE b.nombreDeBanco = :nombreDeBanco")})
public class Bancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banco")
    private Integer idBanco;
    @Size(max = 15)
    @Column(name = "nit_banco")
    private String nitBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre_de_banco")
    private String nombreDeBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanco")
    private List<CuentasBancarias> cuentasBancariasList;

    public Bancos() {
    }

    public Bancos(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Bancos(Integer idBanco, String nombreDeBanco) {
        this.idBanco = idBanco;
        this.nombreDeBanco = nombreDeBanco;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNitBanco() {
        return nitBanco;
    }

    public void setNitBanco(String nitBanco) {
        this.nitBanco = nitBanco;
    }

    public String getNombreDeBanco() {
        return nombreDeBanco;
    }

    public void setNombreDeBanco(String nombreDeBanco) {
        this.nombreDeBanco = nombreDeBanco;
    }

    @XmlTransient
    public List<CuentasBancarias> getCuentasBancariasList() {
        return cuentasBancariasList;
    }

    public void setCuentasBancariasList(List<CuentasBancarias> cuentasBancariasList) {
        this.cuentasBancariasList = cuentasBancariasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Bancos[ idBanco=" + idBanco + " ]";
    }
    
}
