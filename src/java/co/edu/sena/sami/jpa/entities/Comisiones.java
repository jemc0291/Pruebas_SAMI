/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "comisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comisiones.findAll", query = "SELECT c FROM Comisiones c"),
    @NamedQuery(name = "Comisiones.findByIdComision", query = "SELECT c FROM Comisiones c WHERE c.idComision = :idComision"),
    @NamedQuery(name = "Comisiones.findByObjetivoComision", query = "SELECT c FROM Comisiones c WHERE c.objetivoComision = :objetivoComision"),
    @NamedQuery(name = "Comisiones.findByFechaComision", query = "SELECT c FROM Comisiones c WHERE c.fechaComision = :fechaComision"),
    @NamedQuery(name = "Comisiones.findByFechaTramite", query = "SELECT c FROM Comisiones c WHERE c.fechaTramite = :fechaTramite")})
public class Comisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comision")
    private Integer idComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "objetivo_comision")
    private String objetivoComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_comision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_tramite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTramite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComision")
    private List<InformesDeComisiones> informesDeComisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComision")
    private List<LegalizacionesDeComisiones> legalizacionesDeComisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComision")
    private List<OrdenesDeviaje> ordenesDeviajeList;
    @JoinColumn(name = "id_descripcion", referencedColumnName = "id_descripcion")
    @ManyToOne(optional = false)
    private DescripcionesReferenciasViaticos idDescripcion;
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    @ManyToOne(optional = false)
    private Contratos idContrato;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(optional = false)
    private CuentasBancarias idCuenta;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormacion;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobaciones idAprobacion;

    public Comisiones() {
    }

    public Comisiones(Integer idComision) {
        this.idComision = idComision;
    }

    public Comisiones(Integer idComision, String objetivoComision, Date fechaComision, Date fechaTramite) {
        this.idComision = idComision;
        this.objetivoComision = objetivoComision;
        this.fechaComision = fechaComision;
        this.fechaTramite = fechaTramite;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getObjetivoComision() {
        return objetivoComision;
    }

    public void setObjetivoComision(String objetivoComision) {
        this.objetivoComision = objetivoComision;
    }

    public Date getFechaComision() {
        return fechaComision;
    }

    public void setFechaComision(Date fechaComision) {
        this.fechaComision = fechaComision;
    }

    public Date getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    @XmlTransient
    public List<InformesDeComisiones> getInformesDeComisionesList() {
        return informesDeComisionesList;
    }

    public void setInformesDeComisionesList(List<InformesDeComisiones> informesDeComisionesList) {
        this.informesDeComisionesList = informesDeComisionesList;
    }

    @XmlTransient
    public List<LegalizacionesDeComisiones> getLegalizacionesDeComisionesList() {
        return legalizacionesDeComisionesList;
    }

    public void setLegalizacionesDeComisionesList(List<LegalizacionesDeComisiones> legalizacionesDeComisionesList) {
        this.legalizacionesDeComisionesList = legalizacionesDeComisionesList;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    public DescripcionesReferenciasViaticos getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(DescripcionesReferenciasViaticos idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public Contratos getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contratos idContrato) {
        this.idContrato = idContrato;
    }

    public CuentasBancarias getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentasBancarias idCuenta) {
        this.idCuenta = idCuenta;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Aprobaciones getIdAprobacion() {
        return idAprobacion;
    }

    public void setIdAprobacion(Aprobaciones idAprobacion) {
        this.idAprobacion = idAprobacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComision != null ? idComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comisiones)) {
            return false;
        }
        Comisiones other = (Comisiones) object;
        if ((this.idComision == null && other.idComision != null) || (this.idComision != null && !this.idComision.equals(other.idComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Comisiones[ idComision=" + idComision + " ]";
    }
    
}
