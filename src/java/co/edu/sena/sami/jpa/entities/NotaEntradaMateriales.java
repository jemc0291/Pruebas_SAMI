/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "nota_entrada_materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaEntradaMateriales.findAll", query = "SELECT n FROM NotaEntradaMateriales n"),
    @NamedQuery(name = "NotaEntradaMateriales.findByIdNota", query = "SELECT n FROM NotaEntradaMateriales n WHERE n.notaEntradaMaterialesPK.idNota = :idNota"),
    @NamedQuery(name = "NotaEntradaMateriales.findByIdMaterial", query = "SELECT n FROM NotaEntradaMateriales n WHERE n.notaEntradaMaterialesPK.idMaterial = :idMaterial")})
public class NotaEntradaMateriales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotaEntradaMaterialesPK notaEntradaMaterialesPK;
    @JoinColumn(name = "id_material", referencedColumnName = "id_materiales", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materiales materiales;
    @JoinColumn(name = "id_Nota", referencedColumnName = "id_Nota", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NotaEntrada notaEntrada;

    public NotaEntradaMateriales() {
    }

    public NotaEntradaMateriales(NotaEntradaMaterialesPK notaEntradaMaterialesPK) {
        this.notaEntradaMaterialesPK = notaEntradaMaterialesPK;
    }

    public NotaEntradaMateriales(int idNota, int idMaterial) {
        this.notaEntradaMaterialesPK = new NotaEntradaMaterialesPK(idNota, idMaterial);
    }

    public NotaEntradaMaterialesPK getNotaEntradaMaterialesPK() {
        return notaEntradaMaterialesPK;
    }

    public void setNotaEntradaMaterialesPK(NotaEntradaMaterialesPK notaEntradaMaterialesPK) {
        this.notaEntradaMaterialesPK = notaEntradaMaterialesPK;
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }

    public NotaEntrada getNotaEntrada() {
        return notaEntrada;
    }

    public void setNotaEntrada(NotaEntrada notaEntrada) {
        this.notaEntrada = notaEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notaEntradaMaterialesPK != null ? notaEntradaMaterialesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaEntradaMateriales)) {
            return false;
        }
        NotaEntradaMateriales other = (NotaEntradaMateriales) object;
        if ((this.notaEntradaMaterialesPK == null && other.notaEntradaMaterialesPK != null) || (this.notaEntradaMaterialesPK != null && !this.notaEntradaMaterialesPK.equals(other.notaEntradaMaterialesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.NotaEntradaMateriales[ notaEntradaMaterialesPK=" + notaEntradaMaterialesPK + " ]";
    }
    
}
