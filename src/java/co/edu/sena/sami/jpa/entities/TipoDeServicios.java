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
@Table(name = "tipo_de_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeServicios.findAll", query = "SELECT t FROM TipoDeServicios t"),
    @NamedQuery(name = "TipoDeServicios.findByIdTipoServ", query = "SELECT t FROM TipoDeServicios t WHERE t.idTipoServ = :idTipoServ"),
    @NamedQuery(name = "TipoDeServicios.findByNombreServicio", query = "SELECT t FROM TipoDeServicios t WHERE t.nombreServicio = :nombreServicio")})
public class TipoDeServicios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_serv")
    private Integer idTipoServ;
    @Size(max = 45)
    @Column(name = "nombre_Servicio")
    private String nombreServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoServicio")
    private List<TiposDeServiciosSolicitudDeServicios> tiposDeServiciosSolicitudDeServiciosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoServ")
    private List<Servicios> serviciosList;

    public TipoDeServicios() {
    }

    public TipoDeServicios(Integer idTipoServ) {
        this.idTipoServ = idTipoServ;
    }

    public Integer getIdTipoServ() {
        return idTipoServ;
    }

    public void setIdTipoServ(Integer idTipoServ) {
        this.idTipoServ = idTipoServ;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    @XmlTransient
    public List<TiposDeServiciosSolicitudDeServicios> getTiposDeServiciosSolicitudDeServiciosList() {
        return tiposDeServiciosSolicitudDeServiciosList;
    }

    public void setTiposDeServiciosSolicitudDeServiciosList(List<TiposDeServiciosSolicitudDeServicios> tiposDeServiciosSolicitudDeServiciosList) {
        this.tiposDeServiciosSolicitudDeServiciosList = tiposDeServiciosSolicitudDeServiciosList;
    }

    @XmlTransient
    public List<Servicios> getServiciosList() {
        return serviciosList;
    }

    public void setServiciosList(List<Servicios> serviciosList) {
        this.serviciosList = serviciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServ != null ? idTipoServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeServicios)) {
            return false;
        }
        TipoDeServicios other = (TipoDeServicios) object;
        if ((this.idTipoServ == null && other.idTipoServ != null) || (this.idTipoServ != null && !this.idTipoServ.equals(other.idTipoServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.TipoDeServicios[ idTipoServ=" + idTipoServ + " ]";
    }
    
}
