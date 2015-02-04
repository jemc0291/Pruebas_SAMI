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
@Table(name = "arl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arl.findAll", query = "SELECT a FROM Arl a"),
    @NamedQuery(name = "Arl.findByIdArl", query = "SELECT a FROM Arl a WHERE a.idArl = :idArl"),
    @NamedQuery(name = "Arl.findByNombreArl", query = "SELECT a FROM Arl a WHERE a.nombreArl = :nombreArl")})
public class Arl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arl")
    private Short idArl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_arl")
    private String nombreArl;
    @OneToMany(mappedBy = "idArl")
    private List<Usuarios> usuariosList;

    public Arl() {
    }

    public Arl(Short idArl) {
        this.idArl = idArl;
    }

    public Arl(Short idArl, String nombreArl) {
        this.idArl = idArl;
        this.nombreArl = nombreArl;
    }

    public Short getIdArl() {
        return idArl;
    }

    public void setIdArl(Short idArl) {
        this.idArl = idArl;
    }

    public String getNombreArl() {
        return nombreArl;
    }

    public void setNombreArl(String nombreArl) {
        this.nombreArl = nombreArl;
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
        hash += (idArl != null ? idArl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arl)) {
            return false;
        }
        Arl other = (Arl) object;
        if ((this.idArl == null && other.idArl != null) || (this.idArl != null && !this.idArl.equals(other.idArl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreArl + "";
    }
    
}
