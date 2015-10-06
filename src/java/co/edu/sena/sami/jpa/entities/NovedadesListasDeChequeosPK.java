/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Snyck
 */
@Embeddable
public class NovedadesListasDeChequeosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_novedad")
    private int idNovedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lista_de_chequeo")
    private int idListaDeChequeo;

    public NovedadesListasDeChequeosPK() {
    }

    public NovedadesListasDeChequeosPK(int idNovedad, int idListaDeChequeo) {
        this.idNovedad = idNovedad;
        this.idListaDeChequeo = idListaDeChequeo;
    }

    public int getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    public int getIdListaDeChequeo() {
        return idListaDeChequeo;
    }

    public void setIdListaDeChequeo(int idListaDeChequeo) {
        this.idListaDeChequeo = idListaDeChequeo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idNovedad;
        hash += (int) idListaDeChequeo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadesListasDeChequeosPK)) {
            return false;
        }
        NovedadesListasDeChequeosPK other = (NovedadesListasDeChequeosPK) object;
        if (this.idNovedad != other.idNovedad) {
            return false;
        }
        if (this.idListaDeChequeo != other.idListaDeChequeo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK[ idNovedad=" + idNovedad + ", idListaDeChequeo=" + idListaDeChequeo + " ]";
    }
    
}
