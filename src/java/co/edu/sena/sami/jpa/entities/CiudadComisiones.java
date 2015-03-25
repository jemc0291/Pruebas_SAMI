//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final CiudadComisiones other = (CiudadComisiones) obj;
//        if (!Objects.equals(this.salidaEstimada, other.salidaEstimada)) {
//            return false;
//        }
//        if (!Objects.equals(this.llegadaEstimada, other.llegadaEstimada)) {
//            return false;
//        }
//        if (!Objects.equals(this.ciudad, other.ciudad)) {
////
//            return false;
//        }
//        return true;
//    }
////<<<<<<< HEAD
//    
//
////>>>>>>> origin/master
//
//    public String toString() {
//        return "co.sena.sami.edu.jpa.entities.CiudadComisiones[ ciudadComisionesPK=" + ciudadComisionesPK + " ]";
//    }
//    
//}
//=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "CiudadComisiones.findByIdCiudad", query = "SELECT c FROM CiudadComisiones c WHERE c.ciudad = :idCiudad"),
    @NamedQuery(name = "CiudadComisiones.findByIdComision", query = "SELECT c FROM CiudadComisiones c WHERE c.idComision = :idComision"),
    @NamedQuery(name = "CiudadComisiones.findBySalidaEstimada", query = "SELECT c FROM CiudadComisiones c WHERE c.salidaEstimada = :salidaEstimada"),
    @NamedQuery(name = "CiudadComisiones.findByLlegadaEstimada", query = "SELECT c FROM CiudadComisiones c WHERE c.llegadaEstimada = :llegadaEstimada"),
    @NamedQuery(name = "CiudadComisiones.findByEmpresaVereda", query = "SELECT c FROM CiudadComisiones c WHERE c.empresaVereda = :empresaVereda"),
    @NamedQuery(name = "CiudadComisiones.findByValorViatico", query = "SELECT c FROM CiudadComisiones c WHERE c.valorViatico = :valorViatico"),
    @NamedQuery(name = "CiudadComisiones.findByIdciudadComision", query = "SELECT c FROM CiudadComisiones c WHERE c.idciudadComision = :idciudadComision")})
public class CiudadComisiones implements Serializable {
private static final long serialVersionUID = 1L;
    @Column(name = "salida_estimada")
    @Temporal(TemporalType.DATE)
    private Date salidaEstimada;
    @Column(name = "llegada_estimada")
    @Temporal(TemporalType.DATE)
    private Date llegadaEstimada;
    @Size(max = 100)
    @Column(name = "empresa_vereda")
    private String empresaVereda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_viatico")
    private Double valorViatico;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciudadComision")
    private Integer idciudadComision;
    @JoinColumn(name = "id_comision", referencedColumnName = "id_comision")
    @ManyToOne(optional = false)
    private Comisiones idComision;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;

        public CiudadComisiones() {
    }

    public CiudadComisiones(Integer idciudadComision) {
        this.idciudadComision = idciudadComision;
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

    public Double getValorViatico() {
        return valorViatico;
    }

    public void setValorViatico(Double valorViatico) {
        this.valorViatico = valorViatico;
    }

    public Integer getIdciudadComision() {
        return idciudadComision;
    }

    public void setIdciudadComision(Integer idciudadComision) {
        this.idciudadComision = idciudadComision;
    }

    public Comisiones getIdComision() {
        return idComision;
    }

    public void setIdComision(Comisiones idComision) {
        this.idComision = idComision;
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
        hash += (idciudadComision != null ? idciudadComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadComisiones)) {
            return false;
        }
        CiudadComisiones other = (CiudadComisiones) object;
        if ((this.idciudadComision == null && other.idciudadComision != null) 
                || (this.idciudadComision != null 
                && !this.idciudadComision.equals(other.idciudadComision))) {
            return false;
        }
        if (!Objects.equals(this.salidaEstimada, other.salidaEstimada)) {
            return false;
        }
        if (!Objects.equals(this.llegadaEstimada, other.llegadaEstimada)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Comisiones[ idComision=" + idComision + " ]";
    }

}
