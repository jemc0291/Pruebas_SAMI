/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad LIKE :nombreCiudad"),
    @NamedQuery(name = "Ciudad.findByIdDpto", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.idDpto = :idDpto")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiudadPK ciudadPK;
    @Size(max = 45)
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;
    @JoinTable(name = "ordenes_deviaje_ciudades", joinColumns = {
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")}, inverseJoinColumns = {
        @JoinColumn(name = "numero_ordendeviaje", referencedColumnName = "numero_ordendeviaje")})
    @ManyToMany
    private List<OrdenesDeviaje> ordenesDeviajeList;
    @JoinTable(name = "relaciones_gastos_de_transporte_ciudad", joinColumns = {
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_relaciones_gastos_de_transporte", referencedColumnName = "id_relaciones_gastos_de_transporte")})
    @ManyToMany
    private List<RelacionesGastosDeTransporte> relacionesGastosDeTransporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<InformesDeComisiones> informesDeComisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<CentroFormacion> centroFormacionList;
    @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Legalizaciones> legalizacionesList;
    @OneToMany(mappedBy = "ciudad")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad1")
    private List<Usuarios> usuariosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Comisiones> comisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Comunas> comunasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Tarifas> tarifasList;

    public Ciudad() {
    }

    public Ciudad(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public Ciudad(int idCiudad, int idDpto) {
        this.ciudadPK = new CiudadPK(idCiudad, idDpto);
    }

    public CiudadPK getCiudadPK() {
        return ciudadPK;
    }

    public void setCiudadPK(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    @XmlTransient
    public List<RelacionesGastosDeTransporte> getRelacionesGastosDeTransporteList() {
        return relacionesGastosDeTransporteList;
    }

    public void setRelacionesGastosDeTransporteList(List<RelacionesGastosDeTransporte> relacionesGastosDeTransporteList) {
        this.relacionesGastosDeTransporteList = relacionesGastosDeTransporteList;
    }

    @XmlTransient
    public List<InformesDeComisiones> getInformesDeComisionesList() {
        return informesDeComisionesList;
    }

    public void setInformesDeComisionesList(List<InformesDeComisiones> informesDeComisionesList) {
        this.informesDeComisionesList = informesDeComisionesList;
    }

    @XmlTransient
    public List<CentroFormacion> getCentroFormacionList() {
        return centroFormacionList;
    }

    public void setCentroFormacionList(List<CentroFormacion> centroFormacionList) {
        this.centroFormacionList = centroFormacionList;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @XmlTransient
    public List<Legalizaciones> getLegalizacionesList() {
        return legalizacionesList;
    }

    public void setLegalizacionesList(List<Legalizaciones> legalizacionesList) {
        this.legalizacionesList = legalizacionesList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList1() {
        return usuariosList1;
    }

    public void setUsuariosList1(List<Usuarios> usuariosList1) {
        this.usuariosList1 = usuariosList1;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    @XmlTransient
    public List<Comunas> getComunasList() {
        return comunasList;
    }

    public void setComunasList(List<Comunas> comunasList) {
        this.comunasList = comunasList;
    }

    @XmlTransient
    public List<Tarifas> getTarifasList() {
        return tarifasList;
    }

    public void setTarifasList(List<Tarifas> tarifasList) {
        this.tarifasList = tarifasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadPK != null ? ciudadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadPK == null && other.ciudadPK != null) || (this.ciudadPK != null && !this.ciudadPK.equals(other.ciudadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCiudad + ", " +getDepartamentos().getNombreDpto() + ", " + getDepartamentos().getIdPais().getNombrepais();
    }
    
}
