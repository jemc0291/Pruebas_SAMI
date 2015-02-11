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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "soportes_de_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoportesDeDocumentos.findAll", query = "SELECT s FROM SoportesDeDocumentos s"),
    @NamedQuery(name = "SoportesDeDocumentos.findByIdSoporte", query = "SELECT s FROM SoportesDeDocumentos s WHERE s.idSoporte = :idSoporte"),
    @NamedQuery(name = "SoportesDeDocumentos.findByUrlDocumento", query = "SELECT s FROM SoportesDeDocumentos s WHERE s.urlDocumento = :urlDocumento"),
    @NamedQuery(name = "SoportesDeDocumentos.findByObservacion", query = "SELECT s FROM SoportesDeDocumentos s WHERE s.observacion = :observacion"),
    @NamedQuery(name = "SoportesDeDocumentos.findByTipoSoporte", query = "SELECT s FROM SoportesDeDocumentos s WHERE s.tipoSoporte = :tipoSoporte")})
public class SoportesDeDocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_soporte")
    private Integer idSoporte;
    @Size(max = 500)
    @Column(name = "url_documento")
    private String urlDocumento;
    @Size(max = 1000)
    @Column(name = "observacion")
    private String observacion;
    @Lob
    @Column(name = "destino_archivo")
    private byte[] destinoArchivo;
    @Size(max = 45)
    @Column(name = "tipo_soporte")
    private String tipoSoporte;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contratos idContrato;

    public SoportesDeDocumentos() {
    }

    public SoportesDeDocumentos(Integer idSoporte) {
        this.idSoporte = idSoporte;
    }

    public Integer getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(Integer idSoporte) {
        this.idSoporte = idSoporte;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public byte[] getDestinoArchivo() {
        return destinoArchivo;
    }

    public void setDestinoArchivo(byte[] destinoArchivo) {
        this.destinoArchivo = destinoArchivo;
    }

    public String getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(String tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    public Contratos getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contratos idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoporte != null ? idSoporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoportesDeDocumentos)) {
            return false;
        }
        SoportesDeDocumentos other = (SoportesDeDocumentos) object;
        if ((this.idSoporte == null && other.idSoporte != null) || (this.idSoporte != null && !this.idSoporte.equals(other.idSoporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.SoportesDeDocumentos[ idSoporte=" + idSoporte + " ]";
    }
    
}
