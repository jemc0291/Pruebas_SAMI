/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "ciudad_comisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CiudadComisiones.findAll", query = "SELECT c FROM CiudadComisiones c"),
    @NamedQuery(name = "CiudadComisiones.findByIdCiudad", query = "SELECT c FROM CiudadComisiones c WHERE c.ciudadComisionesPK.idCiudad = :idCiudad"),
    @NamedQuery(name = "CiudadComisiones.findByIdDpto", query = "SELECT c FROM CiudadComisiones c WHERE c.ciudadComisionesPK.idDpto = :idDpto"),
    @NamedQuery(name = "CiudadComisiones.findByIdComision", query = "SELECT c FROM CiudadComisiones c WHERE c.ciudadComisionesPK.idComision = :idComision"),
    @NamedQuery(name = "CiudadComisiones.findBySalidaEstimada", query = "SELECT c FROM CiudadComisiones c WHERE c.salidaEstimada = :salidaEstimada"),
    @NamedQuery(name = "CiudadComisiones.findByLlegadaEstimada", query = "SELECT c FROM CiudadComisiones c WHERE c.llegadaEstimada = :llegadaEstimada"),
    @NamedQuery(name = "CiudadComisiones.findByEmpresaVereda", query = "SELECT c FROM CiudadComisiones c WHERE c.empresaVereda = :empresaVereda")})
public class CiudadComisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiudadComisionesPK ciudadComisionesPK;
    @Column(name = "salida_estimada")
    @Temporal(TemporalType.DATE)
    private Date salidaEstimada;
    @Column(name = "llegada_estimada")
    @Temporal(TemporalType.DATE)
    private Date llegadaEstimada;
    @Size(max = 100)
    @Column(name = "empresa_vereda")
    private String empresaVereda;
    @JoinColumn(name = "id_comision", referencedColumnName = "id_comision", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comisiones comisiones;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", insertable = false, updatable = false),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ciudad ciudad;

    public CiudadComisiones() {
    }

    public CiudadComisiones(CiudadComisionesPK ciudadComisionesPK) {
        this.ciudadComisionesPK = ciudadComisionesPK;
    }

    public CiudadComisiones(int idCiudad, int idDpto, int idComision) {
        this.ciudadComisionesPK = new CiudadComisionesPK(idCiudad, idDpto, idComision);
    }

    public CiudadComisionesPK getCiudadComisionesPK() {
        return ciudadComisionesPK;
    }

    public void setCiudadComisionesPK(CiudadComisionesPK ciudadComisionesPK) {
        this.ciudadComisionesPK = ciudadComisionesPK;
    }

    public Date getSalidaEstimada() {
        return salidaEstimada;
    }

    public void setSalidaEstimada(Date salidaEstimada) {
        this.salidaEstimada = salidaEstimada;
    }

    public Date getLlegadaEstimada() {
        return llegadaEstimada;
    }

    public void setLlegadaEstimada(Date llegadaEstimada) {
        this.llegadaEstimada = llegadaEstimada;
    }

    public String getEmpresaVereda() {
        return empresaVereda;
    }

    public void setEmpresaVereda(String empresaVereda) {
        this.empresaVereda = empresaVereda;
    }

    public Comisiones getComisiones() {
        return comisiones;
    }

    public void setComisiones(Comisiones comisiones) {
        this.comisiones = comisiones;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadComisionesPK != null ? ciudadComisionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadComisiones)) {
            return false;
        }
        CiudadComisiones other = (CiudadComisiones) object;
        if ((this.ciudadComisionesPK == null && other.ciudadComisionesPK != null) || (this.ciudadComisionesPK != null && !this.ciudadComisionesPK.equals(other.ciudadComisionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.sami.edu.jpa.entities.CiudadComisiones[ ciudadComisionesPK=" + ciudadComisionesPK + " ]";
    }
    
}
