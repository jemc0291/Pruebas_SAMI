/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "novedades_listas_de_chequeos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NovedadesListasDeChequeos.findAll", query = "SELECT n FROM NovedadesListasDeChequeos n"),
    @NamedQuery(name = "NovedadesListasDeChequeos.findByIdNovedad", query = "SELECT n FROM NovedadesListasDeChequeos n WHERE n.novedadesListasDeChequeosPK.idNovedad = :idNovedad"),
    @NamedQuery(name = "NovedadesListasDeChequeos.findByIdListaDeChequeo", query = "SELECT n FROM NovedadesListasDeChequeos n WHERE n.novedadesListasDeChequeosPK.idListaDeChequeo = :idListaDeChequeo"),
    @NamedQuery(name = "NovedadesListasDeChequeos.findByValorItem", query = "SELECT n FROM NovedadesListasDeChequeos n WHERE n.valorItem = :valorItem")})
public class NovedadesListasDeChequeos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NovedadesListasDeChequeosPK novedadesListasDeChequeosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_item")
    private boolean valorItem;
    @JoinColumn(name = "id_novedad", referencedColumnName = "id_novedad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Novedades novedades;
    @JoinColumn(name = "id_lista_de_chequeo", referencedColumnName = "id_lista_de_chekeo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ListasDeChequeos listasDeChequeos;

    public NovedadesListasDeChequeos() {
    }

    public NovedadesListasDeChequeos(NovedadesListasDeChequeosPK novedadesListasDeChequeosPK) {
        this.novedadesListasDeChequeosPK = novedadesListasDeChequeosPK;
    }

    public NovedadesListasDeChequeos(NovedadesListasDeChequeosPK novedadesListasDeChequeosPK, boolean valorItem) {
        this.novedadesListasDeChequeosPK = novedadesListasDeChequeosPK;
        this.valorItem = valorItem;
    }

    public NovedadesListasDeChequeos(int idNovedad, int idListaDeChequeo) {
        this.novedadesListasDeChequeosPK = new NovedadesListasDeChequeosPK(idNovedad, idListaDeChequeo);
    }

    public NovedadesListasDeChequeosPK getNovedadesListasDeChequeosPK() {
        return novedadesListasDeChequeosPK;
    }

    public void setNovedadesListasDeChequeosPK(NovedadesListasDeChequeosPK novedadesListasDeChequeosPK) {
        this.novedadesListasDeChequeosPK = novedadesListasDeChequeosPK;
    }

    public boolean getValorItem() {
        return valorItem;
    }

    public void setValorItem(boolean valorItem) {
        this.valorItem = valorItem;
    }

    public Novedades getNovedades() {
        return novedades;
    }

    public void setNovedades(Novedades novedades) {
        this.novedades = novedades;
    }

    public ListasDeChequeos getListasDeChequeos() {
        return listasDeChequeos;
    }

    public void setListasDeChequeos(ListasDeChequeos listasDeChequeos) {
        this.listasDeChequeos = listasDeChequeos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (novedadesListasDeChequeosPK != null ? novedadesListasDeChequeosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadesListasDeChequeos)) {
            return false;
        }
        NovedadesListasDeChequeos other = (NovedadesListasDeChequeos) object;
        if ((this.novedadesListasDeChequeosPK == null && other.novedadesListasDeChequeosPK != null) || (this.novedadesListasDeChequeosPK != null && !this.novedadesListasDeChequeosPK.equals(other.novedadesListasDeChequeosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeos[ novedadesListasDeChequeosPK=" + novedadesListasDeChequeosPK + " ]";
    }
    
}
