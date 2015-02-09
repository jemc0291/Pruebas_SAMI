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
@Table(name = "ccf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ccf.findAll", query = "SELECT c FROM Ccf c"),
    @NamedQuery(name = "Ccf.findByIdCcf", query = "SELECT c FROM Ccf c WHERE c.idCcf = :idCcf"),
    @NamedQuery(name = "Ccf.findByNombreCcf", query = "SELECT c FROM Ccf c WHERE c.nombreCcf = :nombreCcf")})
public class Ccf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ccf")
    private Short idCcf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_ccf")
    private String nombreCcf;
    @OneToMany(mappedBy = "idCcf")
    private List<Usuarios> usuariosList;

    public Ccf() {
    }

    public Ccf(Short idCcf) {
        this.idCcf = idCcf;
    }

    public Ccf(Short idCcf, String nombreCcf) {
        this.idCcf = idCcf;
        this.nombreCcf = nombreCcf;
    }

    public Short getIdCcf() {
        return idCcf;
    }

    public void setIdCcf(Short idCcf) {
        this.idCcf = idCcf;
    }

    public String getNombreCcf() {
        return nombreCcf;
    }

    public void setNombreCcf(String nombreCcf) {
        this.nombreCcf = nombreCcf;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCcf != null ? idCcf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ccf)) {
            return false;
        }
        Ccf other = (Ccf) object;
        if ((this.idCcf == null && other.idCcf != null) || (this.idCcf != null && !this.idCcf.equals(other.idCcf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCcf + "";
    }
    
}
