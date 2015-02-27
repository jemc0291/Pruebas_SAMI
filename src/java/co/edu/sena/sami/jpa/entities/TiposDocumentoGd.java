/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tipos_documento_gd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDocumentoGd.findAll", query = "SELECT t FROM TiposDocumentoGd t"),
    @NamedQuery(name = "TiposDocumentoGd.findByIdtiposDocumentoGd", query = "SELECT t FROM TiposDocumentoGd t WHERE t.idtiposDocumentoGd = :idtiposDocumentoGd"),
    @NamedQuery(name = "TiposDocumentoGd.findByNombreDocumento", query = "SELECT t FROM TiposDocumentoGd t WHERE t.nombreDocumento = :nombreDocumento")})
public class TiposDocumentoGd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipos_documento_gd")
    private Integer idtiposDocumentoGd;
    @Size(max = 45)
    @Column(name = "nombre_documento")
    private String nombreDocumento;

    public TiposDocumentoGd() {
    }

    public TiposDocumentoGd(Integer idtiposDocumentoGd) {
        this.idtiposDocumentoGd = idtiposDocumentoGd;
    }

    public Integer getIdtiposDocumentoGd() {
        return idtiposDocumentoGd;
    }

    public void setIdtiposDocumentoGd(Integer idtiposDocumentoGd) {
        this.idtiposDocumentoGd = idtiposDocumentoGd;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiposDocumentoGd != null ? idtiposDocumentoGd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDocumentoGd)) {
            return false;
        }
        TiposDocumentoGd other = (TiposDocumentoGd) object;
        if ((this.idtiposDocumentoGd == null && other.idtiposDocumentoGd != null) || (this.idtiposDocumentoGd != null && !this.idtiposDocumentoGd.equals(other.idtiposDocumentoGd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreDocumento();
    }
    
}
