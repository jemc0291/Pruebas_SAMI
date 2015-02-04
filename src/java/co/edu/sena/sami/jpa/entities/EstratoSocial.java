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
@Table(name = "estrato_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstratoSocial.findAll", query = "SELECT e FROM EstratoSocial e"),
    @NamedQuery(name = "EstratoSocial.findByIdEstratoSocial", query = "SELECT e FROM EstratoSocial e WHERE e.idEstratoSocial = :idEstratoSocial"),
    @NamedQuery(name = "EstratoSocial.findByNombreEstrato", query = "SELECT e FROM EstratoSocial e WHERE e.nombreEstrato = :nombreEstrato")})
public class EstratoSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estrato_social")
    private Short idEstratoSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_estrato")
    private String nombreEstrato;
    @OneToMany(mappedBy = "idEstratoSocial")
    private List<Usuarios> usuariosList;

    public EstratoSocial() {
    }

    public EstratoSocial(Short idEstratoSocial) {
        this.idEstratoSocial = idEstratoSocial;
    }

    public EstratoSocial(Short idEstratoSocial, String nombreEstrato) {
        this.idEstratoSocial = idEstratoSocial;
        this.nombreEstrato = nombreEstrato;
    }

    public Short getIdEstratoSocial() {
        return idEstratoSocial;
    }

    public void setIdEstratoSocial(Short idEstratoSocial) {
        this.idEstratoSocial = idEstratoSocial;
    }

    public String getNombreEstrato() {
        return nombreEstrato;
    }

    public void setNombreEstrato(String nombreEstrato) {
        this.nombreEstrato = nombreEstrato;
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
        hash += (idEstratoSocial != null ? idEstratoSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstratoSocial)) {
            return false;
        }
        EstratoSocial other = (EstratoSocial) object;
        if ((this.idEstratoSocial == null && other.idEstratoSocial != null) || (this.idEstratoSocial != null && !this.idEstratoSocial.equals(other.idEstratoSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreEstrato + "";
    }
    
}
