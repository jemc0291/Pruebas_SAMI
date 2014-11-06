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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "datos_onbase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosOnbase.findAll", query = "SELECT d FROM DatosOnbase d"),
    @NamedQuery(name = "DatosOnbase.findByIdDatosOnbase", query = "SELECT d FROM DatosOnbase d WHERE d.idDatosOnbase = :idDatosOnbase"),
    @NamedQuery(name = "DatosOnbase.findByNumRadicadoRecibida", query = "SELECT d FROM DatosOnbase d WHERE d.numRadicadoRecibida = :numRadicadoRecibida"),
    @NamedQuery(name = "DatosOnbase.findByNis", query = "SELECT d FROM DatosOnbase d WHERE d.nis = :nis"),
    @NamedQuery(name = "DatosOnbase.findByCodigoRegional", query = "SELECT d FROM DatosOnbase d WHERE d.codigoRegional = :codigoRegional"),
    @NamedQuery(name = "DatosOnbase.findByModoIngreso", query = "SELECT d FROM DatosOnbase d WHERE d.modoIngreso = :modoIngreso"),
    @NamedQuery(name = "DatosOnbase.findByEntregaALaMano", query = "SELECT d FROM DatosOnbase d WHERE d.entregaALaMano = :entregaALaMano"),
    @NamedQuery(name = "DatosOnbase.findByFechaProcedencia", query = "SELECT d FROM DatosOnbase d WHERE d.fechaProcedencia = :fechaProcedencia"),
    @NamedQuery(name = "DatosOnbase.findByNumeroRadicadoOrigen", query = "SELECT d FROM DatosOnbase d WHERE d.numeroRadicadoOrigen = :numeroRadicadoOrigen"),
    @NamedQuery(name = "DatosOnbase.findByTipoDocumento", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "DatosOnbase.findByTiempoRespuestaDias", query = "SELECT d FROM DatosOnbase d WHERE d.tiempoRespuestaDias = :tiempoRespuestaDias"),
    @NamedQuery(name = "DatosOnbase.findByFechaRespuesta", query = "SELECT d FROM DatosOnbase d WHERE d.fechaRespuesta = :fechaRespuesta"),
    @NamedQuery(name = "DatosOnbase.findByNumeroDeAnexos", query = "SELECT d FROM DatosOnbase d WHERE d.numeroDeAnexos = :numeroDeAnexos"),
    @NamedQuery(name = "DatosOnbase.findByAsunto", query = "SELECT d FROM DatosOnbase d WHERE d.asunto = :asunto"),
    @NamedQuery(name = "DatosOnbase.findByTipoPeticion", query = "SELECT d FROM DatosOnbase d WHERE d.tipoPeticion = :tipoPeticion"),
    @NamedQuery(name = "DatosOnbase.findByDescripcionAnexos", query = "SELECT d FROM DatosOnbase d WHERE d.descripcionAnexos = :descripcionAnexos"),
    @NamedQuery(name = "DatosOnbase.findByTipoDigitalizacion", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDigitalizacion = :tipoDigitalizacion")})
public class DatosOnbase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_datos_onbase")
    private Integer idDatosOnbase;
    @Size(max = 45)
    @Column(name = "num_radicado_recibida")
    private String numRadicadoRecibida;
    @Column(name = "nis")
    private Integer nis;
    @Column(name = "codigo_regional")
    private Integer codigoRegional;
    @Size(max = 45)
    @Column(name = "modo_ingreso")
    private String modoIngreso;
    @Size(max = 45)
    @Column(name = "entrega_a_la_mano")
    private String entregaALaMano;
    @Column(name = "fecha_procedencia")
    @Temporal(TemporalType.DATE)
    private Date fechaProcedencia;
    @Column(name = "numero_radicado_origen")
    private Integer numeroRadicadoOrigen;
    @Size(max = 45)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 30)
    @Column(name = "tiempo_respuesta_dias")
    private String tiempoRespuestaDias;
    @Column(name = "fecha_respuesta")
    @Temporal(TemporalType.DATE)
    private Date fechaRespuesta;
    @Column(name = "numero_de_anexos")
    private Integer numeroDeAnexos;
    @Size(max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 45)
    @Column(name = "tipo_peticion")
    private String tipoPeticion;
    @Size(max = 60)
    @Column(name = "descripcion_anexos")
    private String descripcionAnexos;
    @Size(max = 60)
    @Column(name = "tipo_digitalizacion")
    private String tipoDigitalizacion;
    @JoinTable(name = "empresa_datos_onbase", joinColumns = {
        @JoinColumn(name = "id_datos_onbase", referencedColumnName = "id_datos_onbase")}, inverseJoinColumns = {
        @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")})
    @ManyToMany
    private List<Empresa> empresaList;
    @JoinColumn(name = "id_usuario_admin", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioAdmin;
    @JoinColumn(name = "id_usuario_destino", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuarios idUsuarioDestino;

    public DatosOnbase() {
    }

    public DatosOnbase(Integer idDatosOnbase) {
        this.idDatosOnbase = idDatosOnbase;
    }

    public Integer getIdDatosOnbase() {
        return idDatosOnbase;
    }

    public void setIdDatosOnbase(Integer idDatosOnbase) {
        this.idDatosOnbase = idDatosOnbase;
    }

    public String getNumRadicadoRecibida() {
        return numRadicadoRecibida;
    }

    public void setNumRadicadoRecibida(String numRadicadoRecibida) {
        this.numRadicadoRecibida = numRadicadoRecibida;
    }

    public Integer getNis() {
        return nis;
    }

    public void setNis(Integer nis) {
        this.nis = nis;
    }

    public Integer getCodigoRegional() {
        return codigoRegional;
    }

    public void setCodigoRegional(Integer codigoRegional) {
        this.codigoRegional = codigoRegional;
    }

    public String getModoIngreso() {
        return modoIngreso;
    }

    public void setModoIngreso(String modoIngreso) {
        this.modoIngreso = modoIngreso;
    }

    public String getEntregaALaMano() {
        return entregaALaMano;
    }

    public void setEntregaALaMano(String entregaALaMano) {
        this.entregaALaMano = entregaALaMano;
    }

    public Date getFechaProcedencia() {
        return fechaProcedencia;
    }

    public void setFechaProcedencia(Date fechaProcedencia) {
        this.fechaProcedencia = fechaProcedencia;
    }

    public Integer getNumeroRadicadoOrigen() {
        return numeroRadicadoOrigen;
    }

    public void setNumeroRadicadoOrigen(Integer numeroRadicadoOrigen) {
        this.numeroRadicadoOrigen = numeroRadicadoOrigen;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTiempoRespuestaDias() {
        return tiempoRespuestaDias;
    }

    public void setTiempoRespuestaDias(String tiempoRespuestaDias) {
        this.tiempoRespuestaDias = tiempoRespuestaDias;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Integer getNumeroDeAnexos() {
        return numeroDeAnexos;
    }

    public void setNumeroDeAnexos(Integer numeroDeAnexos) {
        this.numeroDeAnexos = numeroDeAnexos;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTipoPeticion() {
        return tipoPeticion;
    }

    public void setTipoPeticion(String tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }

    public String getDescripcionAnexos() {
        return descripcionAnexos;
    }

    public void setDescripcionAnexos(String descripcionAnexos) {
        this.descripcionAnexos = descripcionAnexos;
    }

    public String getTipoDigitalizacion() {
        return tipoDigitalizacion;
    }

    public void setTipoDigitalizacion(String tipoDigitalizacion) {
        this.tipoDigitalizacion = tipoDigitalizacion;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    public Usuarios getIdUsuarioAdmin() {
        return idUsuarioAdmin;
    }

    public void setIdUsuarioAdmin(Usuarios idUsuarioAdmin) {
        this.idUsuarioAdmin = idUsuarioAdmin;
    }

    public Usuarios getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(Usuarios idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosOnbase != null ? idDatosOnbase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosOnbase)) {
            return false;
        }
        DatosOnbase other = (DatosOnbase) object;
        if ((this.idDatosOnbase == null && other.idDatosOnbase != null) || (this.idDatosOnbase != null && !this.idDatosOnbase.equals(other.idDatosOnbase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.DatosOnbase[ idDatosOnbase=" + idDatosOnbase + " ]";
    }
    
}
