/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Usuario
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
    @NamedQuery(name = "DatosOnbase.findByFechaProcedencia", query = "SELECT d FROM DatosOnbase d WHERE d.fechaProcedencia = :fechaProcedencia"),
    @NamedQuery(name = "DatosOnbase.findByNumeroRadicadoOrigen", query = "SELECT d FROM DatosOnbase d WHERE d.numeroRadicadoOrigen = :numeroRadicadoOrigen"),
    @NamedQuery(name = "DatosOnbase.findByTipoDocumento", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "DatosOnbase.findByTiempoRespuestaDias", query = "SELECT d FROM DatosOnbase d WHERE d.tiempoRespuestaDias = :tiempoRespuestaDias"),
    @NamedQuery(name = "DatosOnbase.findByFechaRespuesta", query = "SELECT d FROM DatosOnbase d WHERE d.fechaRespuesta = :fechaRespuesta"),
    @NamedQuery(name = "DatosOnbase.findByNumeroDeAnexos", query = "SELECT d FROM DatosOnbase d WHERE d.numeroDeAnexos = :numeroDeAnexos"),
    @NamedQuery(name = "DatosOnbase.findByAsunto", query = "SELECT d FROM DatosOnbase d WHERE d.asunto = :asunto"),
    @NamedQuery(name = "DatosOnbase.findByTipoPeticion", query = "SELECT d FROM DatosOnbase d WHERE d.tipoPeticion = :tipoPeticion"),
    @NamedQuery(name = "DatosOnbase.findByDescripcionAnexos", query = "SELECT d FROM DatosOnbase d WHERE d.descripcionAnexos = :descripcionAnexos"),
    @NamedQuery(name = "DatosOnbase.findByTipoDigitalizacion", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDigitalizacion = :tipoDigitalizacion"),
    @NamedQuery(name = "DatosOnbase.findByCiudadEmpresa", query = "SELECT d FROM DatosOnbase d WHERE d.ciudadEmpresa = :ciudadEmpresa"),
    @NamedQuery(name = "DatosOnbase.findByDireccionEmpresa", query = "SELECT d FROM DatosOnbase d WHERE d.direccionEmpresa = :direccionEmpresa"),
    @NamedQuery(name = "DatosOnbase.findByEmailEmpresa", query = "SELECT d FROM DatosOnbase d WHERE d.emailEmpresa = :emailEmpresa"),
    @NamedQuery(name = "DatosOnbase.findByTelefonoEmpresa", query = "SELECT d FROM DatosOnbase d WHERE d.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "DatosOnbase.findByNombrePerosna", query = "SELECT d FROM DatosOnbase d WHERE d.nombrePerosna = :nombrePerosna"),
    @NamedQuery(name = "DatosOnbase.findByCargoPersonaODependencia", query = "SELECT d FROM DatosOnbase d WHERE d.cargoPersonaODependencia = :cargoPersonaODependencia"),
    @NamedQuery(name = "DatosOnbase.findByMunicipio", query = "SELECT d FROM DatosOnbase d WHERE d.municipio = :municipio"),
    @NamedQuery(name = "DatosOnbase.findByDepartamento", query = "SELECT d FROM DatosOnbase d WHERE d.departamento = :departamento"),
    @NamedQuery(name = "DatosOnbase.findByPais", query = "SELECT d FROM DatosOnbase d WHERE d.pais = :pais"),
    @NamedQuery(name = "DatosOnbase.findByRemitenteNombreEntidadExterna", query = "SELECT d FROM DatosOnbase d WHERE d.remitenteNombreEntidadExterna = :remitenteNombreEntidadExterna"),
    @NamedQuery(name = "DatosOnbase.findByCodDependenciaDestino", query = "SELECT d FROM DatosOnbase d WHERE d.codDependenciaDestino = :codDependenciaDestino"),
    @NamedQuery(name = "DatosOnbase.findByNombreRegionalDestino", query = "SELECT d FROM DatosOnbase d WHERE d.nombreRegionalDestino = :nombreRegionalDestino"),
    @NamedQuery(name = "DatosOnbase.findByCodigoRegionalDestino", query = "SELECT d FROM DatosOnbase d WHERE d.codigoRegionalDestino = :codigoRegionalDestino"),
    @NamedQuery(name = "DatosOnbase.findByFuncionarioDestino", query = "SELECT d FROM DatosOnbase d WHERE d.funcionarioDestino = :funcionarioDestino"),
    @NamedQuery(name = "DatosOnbase.findByEmailUsuario", query = "SELECT d FROM DatosOnbase d WHERE d.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "DatosOnbase.findByDependenciaDestino", query = "SELECT d FROM DatosOnbase d WHERE d.dependenciaDestino = :dependenciaDestino"),
    @NamedQuery(name = "DatosOnbase.findByTiempoDigitalizacion", query = "SELECT d FROM DatosOnbase d WHERE d.tiempoDigitalizacion = :tiempoDigitalizacion"),
    @NamedQuery(name = "DatosOnbase.findByFuncionarioRemitente", query = "SELECT d FROM DatosOnbase d WHERE d.funcionarioRemitente = :funcionarioRemitente"),
    @NamedQuery(name = "DatosOnbase.findByDestinatarioExterno", query = "SELECT d FROM DatosOnbase d WHERE d.destinatarioExterno = :destinatarioExterno"),
    @NamedQuery(name = "DatosOnbase.findByDependenciaDestinatario", query = "SELECT d FROM DatosOnbase d WHERE d.dependenciaDestinatario = :dependenciaDestinatario"),
    @NamedQuery(name = "DatosOnbase.findByFuncionarioDestinatario", query = "SELECT d FROM DatosOnbase d WHERE d.funcionarioDestinatario = :funcionarioDestinatario"),
    @NamedQuery(name = "DatosOnbase.findByDireccionDestintario", query = "SELECT d FROM DatosOnbase d WHERE d.direccionDestintario = :direccionDestintario")})
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
    @Size(max = 100)
    @Column(name = "remitente_nombre _entidad_externa")
    private String remitenteNombreEntidadExterna;
    @Column(name = "cod_dependencia_destino")
    private Integer codDependenciaDestino;
    @Size(max = 45)
    @Column(name = "nombre_regional_destino")
    private String nombreRegionalDestino;
    @Column(name = "codigo_regional_destino")
    private Integer codigoRegionalDestino;
    @Size(max = 100)
    @Column(name = "funcionario_destino")
    private String funcionarioDestino;
    @Size(max = 100)
    @Column(name = "email_usuario")
    private String emailUsuario;
    @Size(max = 45)
    @Column(name = "dependencia_destino")
    private String dependenciaDestino;
    @Column(name = "tiempo_digitalizacion")
    @Temporal(TemporalType.DATE)
    private Date tiempoDigitalizacion;
    @Size(max = 100)
    @Column(name = "funcionario_remitente")
    private String funcionarioRemitente;
    @Size(max = 100)
    @Column(name = "destinatario_externo")
    private String destinatarioExterno;
    @Size(max = 100)
    @Column(name = "dependencia_destinatario")
    private String dependenciaDestinatario;
    @Size(max = 100)
    @Column(name = "funcionario_destinatario")
    private String funcionarioDestinatario;
    @Size(max = 100)
    @Column(name = "direccion_destintario")
    private String direccionDestintario;
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

    public String getRemitenteNombreEntidadExterna() {
        return remitenteNombreEntidadExterna;
    }

    public void setRemitenteNombreEntidadExterna(String remitenteNombreEntidadExterna) {
        this.remitenteNombreEntidadExterna = remitenteNombreEntidadExterna;
    }

    public Integer getCodDependenciaDestino() {
        return codDependenciaDestino;
    }

    public void setCodDependenciaDestino(Integer codDependenciaDestino) {
        this.codDependenciaDestino = codDependenciaDestino;
    }

    public String getNombreRegionalDestino() {
        return nombreRegionalDestino;
    }

    public void setNombreRegionalDestino(String nombreRegionalDestino) {
        this.nombreRegionalDestino = nombreRegionalDestino;
    }

    public Integer getCodigoRegionalDestino() {
        return codigoRegionalDestino;
    }

    public void setCodigoRegionalDestino(Integer codigoRegionalDestino) {
        this.codigoRegionalDestino = codigoRegionalDestino;
    }

    public String getFuncionarioDestino() {
        return funcionarioDestino;
    }

    public void setFuncionarioDestino(String funcionarioDestino) {
        this.funcionarioDestino = funcionarioDestino;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public void setDependenciaDestino(String dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    public Date getTiempoDigitalizacion() {
        return tiempoDigitalizacion;
    }

    public void setTiempoDigitalizacion(Date tiempoDigitalizacion) {
        this.tiempoDigitalizacion = tiempoDigitalizacion;
    }

    public String getFuncionarioRemitente() {
        return funcionarioRemitente;
    }

    public void setFuncionarioRemitente(String funcionarioRemitente) {
        this.funcionarioRemitente = funcionarioRemitente;
    }

    public String getDestinatarioExterno() {
        return destinatarioExterno;
    }

    public void setDestinatarioExterno(String destinatarioExterno) {
        this.destinatarioExterno = destinatarioExterno;
    }

    public String getDependenciaDestinatario() {
        return dependenciaDestinatario;
    }

    public void setDependenciaDestinatario(String dependenciaDestinatario) {
        this.dependenciaDestinatario = dependenciaDestinatario;
    }

    public String getFuncionarioDestinatario() {
        return funcionarioDestinatario;
    }

    public void setFuncionarioDestinatario(String funcionarioDestinatario) {
        this.funcionarioDestinatario = funcionarioDestinatario;
    }

    public String getDireccionDestintario() {
        return direccionDestintario;
    }

    public void setDireccionDestintario(String direccionDestintario) {
        this.direccionDestintario = direccionDestintario;
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
