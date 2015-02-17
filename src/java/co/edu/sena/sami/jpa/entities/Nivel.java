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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByIdNivel", query = "SELECT n FROM Nivel n WHERE n.idNivel = :idNivel"),
    @NamedQuery(name = "Nivel.findByMinimo", query = "SELECT n FROM Nivel n WHERE n.minimo = :minimo"),
    @NamedQuery(name = "Nivel.findByMaximo", query = "SELECT n FROM Nivel n WHERE n.maximo = :maximo")})
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private Integer idNivel;
    @Column(name = "minimo")
    private Integer minimo;
    @Column(name = "maximo")
    private Integer maximo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private List<ValorGasto> valorGastoList;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    @XmlTransient
    public List<ValorGasto> getValorGastoList() {
        return valorGastoList;
    }

    public void setValorGastoList(List<ValorGasto> valorGastoList) {
        this.valorGastoList = valorGastoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Nivel[ idNivel=" + idNivel + " ]";
    }
    
}
