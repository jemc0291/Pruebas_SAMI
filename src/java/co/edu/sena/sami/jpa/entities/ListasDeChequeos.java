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
 * @author Snyck
 */
@Entity
@Table(name = "listas_de_chequeos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListasDeChequeos.findAll", query = "SELECT l FROM ListasDeChequeos l"),
    @NamedQuery(name = "ListasDeChequeos.findByIdListaDeChekeo", query = "SELECT l FROM ListasDeChequeos l WHERE l.idListaDeChekeo = :idListaDeChekeo"),
    @NamedQuery(name = "ListasDeChequeos.findByItemDeChequeo", query = "SELECT l FROM ListasDeChequeos l WHERE l.itemDeChequeo = :itemDeChequeo"),
    @NamedQuery(name = "ListasDeChequeos.findByDescripcionItem", query = "SELECT l FROM ListasDeChequeos l WHERE l.descripcionItem = :descripcionItem")})
public class ListasDeChequeos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lista_de_chekeo")
    private Integer idListaDeChekeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "item_de_chequeo")
    private String itemDeChequeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "descripcion_item")
    private String descripcionItem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listasDeChequeos")
    private List<NovedadesListasDeChequeos> novedadesListasDeChequeosList;

    public ListasDeChequeos() {
    }

    public ListasDeChequeos(Integer idListaDeChekeo) {
        this.idListaDeChekeo = idListaDeChekeo;
    }

    public ListasDeChequeos(Integer idListaDeChekeo, String itemDeChequeo, String descripcionItem) {
        this.idListaDeChekeo = idListaDeChekeo;
        this.itemDeChequeo = itemDeChequeo;
        this.descripcionItem = descripcionItem;
    }

    public Integer getIdListaDeChekeo() {
        return idListaDeChekeo;
    }

    public void setIdListaDeChekeo(Integer idListaDeChekeo) {
        this.idListaDeChekeo = idListaDeChekeo;
    }

    public String getItemDeChequeo() {
        return itemDeChequeo;
    }

    public void setItemDeChequeo(String itemDeChequeo) {
        this.itemDeChequeo = itemDeChequeo;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    @XmlTransient
    public List<NovedadesListasDeChequeos> getNovedadesListasDeChequeosList() {
        return novedadesListasDeChequeosList;
    }

    public void setNovedadesListasDeChequeosList(List<NovedadesListasDeChequeos> novedadesListasDeChequeosList) {
        this.novedadesListasDeChequeosList = novedadesListasDeChequeosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaDeChekeo != null ? idListaDeChekeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListasDeChequeos)) {
            return false;
        }
        ListasDeChequeos other = (ListasDeChequeos) object;
        if ((this.idListaDeChekeo == null && other.idListaDeChekeo != null) || (this.idListaDeChekeo != null && !this.idListaDeChekeo.equals(other.idListaDeChekeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ListasDeChequeos[ idListaDeChekeo=" + idListaDeChekeo + " ]";
    }
    
}
