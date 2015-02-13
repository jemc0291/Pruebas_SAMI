/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByNitEmpresa", query = "SELECT e FROM Empresa e WHERE e.nitEmpresa = :nitEmpresa"),
    @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Empresa.findByCargoRmEmpresa", query = "SELECT e FROM Empresa e WHERE e.cargoRmEmpresa = :cargoRmEmpresa"),
    @NamedQuery(name = "Empresa.findByCiudadEmpresa", query = "SELECT e FROM Empresa e WHERE e.ciudadEmpresa = :ciudadEmpresa"),
    @NamedQuery(name = "Empresa.findByDireccionEmpresa", query = "SELECT e FROM Empresa e WHERE e.direccionEmpresa = :direccionEmpresa"),
    @NamedQuery(name = "Empresa.findByEmailEmpresa", query = "SELECT e FROM Empresa e WHERE e.emailEmpresa = :emailEmpresa"),
    @NamedQuery(name = "Empresa.findByTelefonoEmpresa", query = "SELECT e FROM Empresa e WHERE e.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "Empresa.findByNombrePerosna", query = "SELECT e FROM Empresa e WHERE e.nombrePerosna = :nombrePerosna"),
    @NamedQuery(name = "Empresa.findByCargoPersonaODependencia", query = "SELECT e FROM Empresa e WHERE e.cargoPersonaODependencia = :cargoPersonaODependencia"),
    @NamedQuery(name = "Empresa.findByMunicipio", query = "SELECT e FROM Empresa e WHERE e.municipio = :municipio"),
    @NamedQuery(name = "Empresa.findByDepartamento", query = "SELECT e FROM Empresa e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empresa.findByPais", query = "SELECT e FROM Empresa e WHERE e.pais = :pais")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Column(name = "nit_empresa")
    private Integer nitEmpresa;
    @Size(max = 45)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Size(max = 45)
    @Column(name = "cargo_rm_empresa")
    private String cargoRmEmpresa;
    @Size(max = 45)
    @Column(name = "ciudad_empresa")
    private String ciudadEmpresa;
    @Size(max = 45)
    @Column(name = "direccion_empresa")
    private String direccionEmpresa;
    @Size(max = 45)
    @Column(name = "email_empresa")
    private String emailEmpresa;
    @Column(name = "telefono_empresa")
    private Integer telefonoEmpresa;
    @Size(max = 50)
    @Column(name = "nombre_perosna")
    private String nombrePerosna;
    @Size(max = 50)
    @Column(name = "cargo_persona_o_dependencia")
    private String cargoPersonaODependencia;
    @Size(max = 45)
    @Column(name = "municipio")
    private String municipio;
    @Size(max = 45)
    @Column(name = "departamento")
    private String departamento;
    @Size(max = 45)
    @Column(name = "pais")
    private String pais;
    @ManyToMany(mappedBy = "empresaList")
    private List<DatosOnbase> datosOnbaseList;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(Integer nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargoRmEmpresa() {
        return cargoRmEmpresa;
    }

    public void setCargoRmEmpresa(String cargoRmEmpresa) {
        this.cargoRmEmpresa = cargoRmEmpresa;
    }

    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public Integer getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(Integer telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getNombrePerosna() {
        return nombrePerosna;
    }

    public void setNombrePerosna(String nombrePerosna) {
        this.nombrePerosna = nombrePerosna;
    }

    public String getCargoPersonaODependencia() {
        return cargoPersonaODependencia;
    }

    public void setCargoPersonaODependencia(String cargoPersonaODependencia) {
        this.cargoPersonaODependencia = cargoPersonaODependencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public List<DatosOnbase> getDatosOnbaseList() {
        return datosOnbaseList;
    }

    public void setDatosOnbaseList(List<DatosOnbase> datosOnbaseList) {
        this.datosOnbaseList = datosOnbaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
