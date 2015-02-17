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
@Table(name = "recursos_o_fuentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursosOFuentes.findAll", query = "SELECT r FROM RecursosOFuentes r"),
    @NamedQuery(name = "RecursosOFuentes.findByIdRecursos", query = "SELECT r FROM RecursosOFuentes r WHERE r.idRecursos = :idRecursos"),
    @NamedQuery(name = "RecursosOFuentes.findByNombreRecurso", query = "SELECT r FROM RecursosOFuentes r WHERE r.nombreRecurso = :nombreRecurso")})
public class RecursosOFuentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_recursos")
    private Integer idRecursos;
    @Size(max = 45)
    @Column(name = "nombre_recurso")
    private String nombreRecurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecursos")
    private List<Cdp> cdpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecursos")
    private List<Crp> crpList;

    public RecursosOFuentes() {
    }

    public RecursosOFuentes(Integer idRecursos) {
        this.idRecursos = idRecursos;
    }

    public Integer getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(Integer idRecursos) {
        this.idRecursos = idRecursos;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
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
        hash += (idRecursos != null ? idRecursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursosOFuentes)) {
            return false;
        }
        RecursosOFuentes other = (RecursosOFuentes) object;
        if ((this.idRecursos == null && other.idRecursos != null) || (this.idRecursos != null && !this.idRecursos.equals(other.idRecursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.RecursosOFuentes[ idRecursos=" + idRecursos + " ]";
    }
    
}
