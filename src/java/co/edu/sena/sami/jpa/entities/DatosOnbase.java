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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsim
 */
@Entity
@Table(name = "datos_onbase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosOnbase.findAll", query = "SELECT d FROM DatosOnbase d"),
    @NamedQuery(name = "DatosOnbase.findByNumRadicadoRecibida", query = "SELECT d FROM DatosOnbase d WHERE d.numRadicadoRecibida LIKE :numRadicadoRecibida"),
    @NamedQuery(name = "DatosOnbase.findByNis", query = "SELECT d FROM DatosOnbase d WHERE d.nis = :nis"),
    @NamedQuery(name = "DatosOnbase.findByCodigoRegional", query = "SELECT d FROM DatosOnbase d WHERE d.codigoRegional = :codigoRegional"),
    @NamedQuery(name = "DatosOnbase.findByModoIngreso", query = "SELECT d FROM DatosOnbase d WHERE d.modoIngreso = :modoIngreso"),
    @NamedQuery(name = "DatosOnbase.findByEntragaALaMano", query = "SELECT d FROM DatosOnbase d WHERE d.entragaALaMano = :entragaALaMano"),
    @NamedQuery(name = "DatosOnbase.findByFechaProcedencia", query = "SELECT d FROM DatosOnbase d WHERE d.fechaProcedencia = :fechaProcedencia"),
    @NamedQuery(name = "DatosOnbase.findByNumeroRadicadoOrigen", query = "SELECT d FROM DatosOnbase d WHERE d.numeroRadicadoOrigen = :numeroRadicadoOrigen"),
    @NamedQuery(name = "DatosOnbase.findByTipoDocumento", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "DatosOnbase.findByTiempoRespuestaDias", query = "SELECT d FROM DatosOnbase d WHERE d.tiempoRespuestaDias = :tiempoRespuestaDias"),
    @NamedQuery(name = "DatosOnbase.findByFechaRespuesta", query = "SELECT d FROM DatosOnbase d WHERE d.fechaRespuesta = :fechaRespuesta"),
    @NamedQuery(name = "DatosOnbase.findByNumeroDeAnexos", query = "SELECT d FROM DatosOnbase d WHERE d.numeroDeAnexos = :numeroDeAnexos"),
    @NamedQuery(name = "DatosOnbase.findByDescripcionAnexos", query = "SELECT d FROM DatosOnbase d WHERE d.descripcionAnexos = :descripcionAnexos"),
    @NamedQuery(name = "DatosOnbase.findByTipoDigitalizacion", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDigitalizacion = :tipoDigitalizacion"),
    @NamedQuery(name = "DatosOnbase.findByAsunto", query = "SELECT d FROM DatosOnbase d WHERE d.asunto = :asunto"),
    @NamedQuery(name = "DatosOnbase.findByDpTipoDePeticion", query = "SELECT d FROM DatosOnbase d WHERE d.dpTipoDePeticion = :dpTipoDePeticion"),
    @NamedQuery(name = "DatosOnbase.findByTemaQYR", query = "SELECT d FROM DatosOnbase d WHERE d.temaQYR = :temaQYR"),
    @NamedQuery(name = "DatosOnbase.findByDescripcionAsunto", query = "SELECT d FROM DatosOnbase d WHERE d.descripcionAsunto = :descripcionAsunto"),
    @NamedQuery(name = "DatosOnbase.findByEmpresaTransportadora", query = "SELECT d FROM DatosOnbase d WHERE d.empresaTransportadora = :empresaTransportadora"),
    @NamedQuery(name = "DatosOnbase.findByNumeroGuiaR", query = "SELECT d FROM DatosOnbase d WHERE d.numeroGuiaR = :numeroGuiaR"),
    @NamedQuery(name = "DatosOnbase.findByCcNitRemitente", query = "SELECT d FROM DatosOnbase d WHERE d.ccNitRemitente = :ccNitRemitente"),
    @NamedQuery(name = "DatosOnbase.findByRemitenteNombreEntidadExterna", query = "SELECT d FROM DatosOnbase d WHERE d.remitenteNombreEntidadExterna = :remitenteNombreEntidadExterna"),
    @NamedQuery(name = "DatosOnbase.findByNombrePersona", query = "SELECT d FROM DatosOnbase d WHERE d.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "DatosOnbase.findByCargoPersonaODependencia", query = "SELECT d FROM DatosOnbase d WHERE d.cargoPersonaODependencia = :cargoPersonaODependencia"),
    @NamedQuery(name = "DatosOnbase.findByMunicipio", query = "SELECT d FROM DatosOnbase d WHERE d.municipio = :municipio"),
    @NamedQuery(name = "DatosOnbase.findByDepartamento", query = "SELECT d FROM DatosOnbase d WHERE d.departamento = :departamento"),
    @NamedQuery(name = "DatosOnbase.findByPais", query = "SELECT d FROM DatosOnbase d WHERE d.pais = :pais"),
    @NamedQuery(name = "DatosOnbase.findByDireccionRemitente", query = "SELECT d FROM DatosOnbase d WHERE d.direccionRemitente = :direccionRemitente"),
    @NamedQuery(name = "DatosOnbase.findByTelefonoRemitente", query = "SELECT d FROM DatosOnbase d WHERE d.telefonoRemitente = :telefonoRemitente"),
    @NamedQuery(name = "DatosOnbase.findByEmailRemitente", query = "SELECT d FROM DatosOnbase d WHERE d.emailRemitente = :emailRemitente"),
    @NamedQuery(name = "DatosOnbase.findByCodDependenciaCfpDestino", query = "SELECT d FROM DatosOnbase d WHERE d.codDependenciaCfpDestino = :codDependenciaCfpDestino"),
    @NamedQuery(name = "DatosOnbase.findByNombreRegionalDestino", query = "SELECT d FROM DatosOnbase d WHERE d.nombreRegionalDestino = :nombreRegionalDestino"),
    @NamedQuery(name = "DatosOnbase.findByCodRegionalDestino", query = "SELECT d FROM DatosOnbase d WHERE d.codRegionalDestino = :codRegionalDestino"),
    @NamedQuery(name = "DatosOnbase.findByFuncionarioDestino", query = "SELECT d FROM DatosOnbase d WHERE d.funcionarioDestino = :funcionarioDestino"),
    @NamedQuery(name = "DatosOnbase.findByEmailUsuario", query = "SELECT d FROM DatosOnbase d WHERE d.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "DatosOnbase.findByDependenciaDestino", query = "SELECT d FROM DatosOnbase d WHERE d.dependenciaDestino = :dependenciaDestino"),
    @NamedQuery(name = "DatosOnbase.findByCopiaCodDependencia", query = "SELECT d FROM DatosOnbase d WHERE d.copiaCodDependencia = :copiaCodDependencia"),
    @NamedQuery(name = "DatosOnbase.findByCopiaCodRegional", query = "SELECT d FROM DatosOnbase d WHERE d.copiaCodRegional = :copiaCodRegional"),
    @NamedQuery(name = "DatosOnbase.findByCopiaFuncionarioDestino", query = "SELECT d FROM DatosOnbase d WHERE d.copiaFuncionarioDestino = :copiaFuncionarioDestino"),
    @NamedQuery(name = "DatosOnbase.findByCopiaDependencia", query = "SELECT d FROM DatosOnbase d WHERE d.copiaDependencia = :copiaDependencia"),
    @NamedQuery(name = "DatosOnbase.findByCopiaNombreRegional", query = "SELECT d FROM DatosOnbase d WHERE d.copiaNombreRegional = :copiaNombreRegional"),
    @NamedQuery(name = "DatosOnbase.findByEstado", query = "SELECT d FROM DatosOnbase d WHERE d.estado = :estado"),
    @NamedQuery(name = "DatosOnbase.findBySwEnvioCorreo", query = "SELECT d FROM DatosOnbase d WHERE d.swEnvioCorreo = :swEnvioCorreo"),
    @NamedQuery(name = "DatosOnbase.findByStatus", query = "SELECT d FROM DatosOnbase d WHERE d.status = :status"),
    @NamedQuery(name = "DatosOnbase.findByWfUsuarioActual", query = "SELECT d FROM DatosOnbase d WHERE d.wfUsuarioActual = :wfUsuarioActual"),
    @NamedQuery(name = "DatosOnbase.findByFechaHora", query = "SELECT d FROM DatosOnbase d WHERE d.fechaHora = :fechaHora"),
    @NamedQuery(name = "DatosOnbase.findByUsername", query = "SELECT d FROM DatosOnbase d WHERE d.username = :username"),
    @NamedQuery(name = "DatosOnbase.findByCopiaEmailUsuario", query = "SELECT d FROM DatosOnbase d WHERE d.copiaEmailUsuario = :copiaEmailUsuario"),
    @NamedQuery(name = "DatosOnbase.findByCopiaUsername", query = "SELECT d FROM DatosOnbase d WHERE d.copiaUsername = :copiaUsername"),
    @NamedQuery(name = "DatosOnbase.findByUsarNameOd", query = "SELECT d FROM DatosOnbase d WHERE d.usarNameOd = :usarNameOd"),
    @NamedQuery(name = "DatosOnbase.findByCodArchivoFisico", query = "SELECT d FROM DatosOnbase d WHERE d.codArchivoFisico = :codArchivoFisico"),
    @NamedQuery(name = "DatosOnbase.findByMailMesageid", query = "SELECT d FROM DatosOnbase d WHERE d.mailMesageid = :mailMesageid"),
    @NamedQuery(name = "DatosOnbase.findByWfUsuarioBalanceo", query = "SELECT d FROM DatosOnbase d WHERE d.wfUsuarioBalanceo = :wfUsuarioBalanceo"),
    @NamedQuery(name = "DatosOnbase.findByEntregadoAInterno", query = "SELECT d FROM DatosOnbase d WHERE d.entregadoAInterno = :entregadoAInterno"),
    @NamedQuery(name = "DatosOnbase.findBySuperiorFuncionarioDestinoMail", query = "SELECT d FROM DatosOnbase d WHERE d.superiorFuncionarioDestinoMail = :superiorFuncionarioDestinoMail"),
    @NamedQuery(name = "DatosOnbase.findByMailCc", query = "SELECT d FROM DatosOnbase d WHERE d.mailCc = :mailCc"),
    @NamedQuery(name = "DatosOnbase.findByTipoDeProceso", query = "SELECT d FROM DatosOnbase d WHERE d.tipoDeProceso = :tipoDeProceso"),
    @NamedQuery(name = "DatosOnbase.findByRealizadoPor", query = "SELECT d FROM DatosOnbase d WHERE d.realizadoPor = :realizadoPor"),
    @NamedQuery(name = "DatosOnbase.findByFlag", query = "SELECT d FROM DatosOnbase d WHERE d.flag = :flag"),
    @NamedQuery(name = "DatosOnbase.findByCodDependenciaOCfpDestino", query = "SELECT d FROM DatosOnbase d WHERE d.codDependenciaOCfpDestino = :codDependenciaOCfpDestino"),
    @NamedQuery(name = "DatosOnbase.findByDependenciaDestinoOriginal", query = "SELECT d FROM DatosOnbase d WHERE d.dependenciaDestinoOriginal = :dependenciaDestinoOriginal"),
    @NamedQuery(name = "DatosOnbase.findByFuncionarioDestinoOriginal", query = "SELECT d FROM DatosOnbase d WHERE d.funcionarioDestinoOriginal = :funcionarioDestinoOriginal"),
    @NamedQuery(name = "DatosOnbase.findByHandle", query = "SELECT d FROM DatosOnbase d WHERE d.handle = :handle"),
    @NamedQuery(name = "DatosOnbase.findByNumeroAntecedentes", query = "SELECT d FROM DatosOnbase d WHERE d.numeroAntecedentes = :numeroAntecedentes"),
    @NamedQuery(name = "DatosOnbase.findByControlSecurityKeyword", query = "SELECT d FROM DatosOnbase d WHERE d.controlSecurityKeyword = :controlSecurityKeyword"),
    @NamedQuery(name = "DatosOnbase.findByEmailSuperiorDestino", query = "SELECT d FROM DatosOnbase d WHERE d.emailSuperiorDestino = :emailSuperiorDestino"),
    @NamedQuery(name = "DatosOnbase.findByRegionalRemitenteInterno", query = "SELECT d FROM DatosOnbase d WHERE d.regionalRemitenteInterno = :regionalRemitenteInterno"),
    @NamedQuery(name = "DatosOnbase.findByCodRegionalRemitenteInterno", query = "SELECT d FROM DatosOnbase d WHERE d.codRegionalRemitenteInterno = :codRegionalRemitenteInterno"),
    @NamedQuery(name = "DatosOnbase.findByFuncionarioRemitenteInterno", query = "SELECT d FROM DatosOnbase d WHERE d.funcionarioRemitenteInterno = :funcionarioRemitenteInterno"),
    @NamedQuery(name = "DatosOnbase.findByCodDependenciaRemitenteInterno", query = "SELECT d FROM DatosOnbase d WHERE d.codDependenciaRemitenteInterno = :codDependenciaRemitenteInterno"),
    @NamedQuery(name = "DatosOnbase.findByDependenciaRemitenteInterna", query = "SELECT d FROM DatosOnbase d WHERE d.dependenciaRemitenteInterna = :dependenciaRemitenteInterna"),
    @NamedQuery(name = "DatosOnbase.findByFechaDelDocumento", query = "SELECT d FROM DatosOnbase d WHERE d.fechaDelDocumento = :fechaDelDocumento")})
    
public class DatosOnbase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_radicado_recibida")
    private String numRadicadoRecibida;
    @Size(max = 45)
    @Column(name = "nis")
    private String nis;
    @Size(max = 45)
    @Column(name = "codigo_regional")
    private String codigoRegional;
    @Size(max = 45)
    @Column(name = "modo_ingreso")
    private String modoIngreso;
    @Size(max = 45)
    @Column(name = "entraga_a_la_mano")
    private String entragaALaMano;
    @Size(max = 45)
    @Column(name = "fecha_procedencia")
    private String fechaProcedencia;
    @Size(max = 45)
    @Column(name = "numero_radicado_origen")
    private String numeroRadicadoOrigen;
    @Size(max = 45)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 30)
    @Column(name = "tiempo_respuesta_dias")
    private String tiempoRespuestaDias;
    @Size(max = 45)
    @Column(name = "fecha_respuesta")
    private String fechaRespuesta;
    @Size(max = 45)
    @Column(name = "numero_de_anexos")
    private String numeroDeAnexos;
    @Size(max = 60)
    @Column(name = "descripcion_anexos")
    private String descripcionAnexos;
    @Size(max = 60)
    @Column(name = "tipo_digitalizacion")
    private String tipoDigitalizacion;
    @Size(max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 45)
    @Column(name = "dp_tipo_de_peticion")
    private String dpTipoDePeticion;
    @Size(max = 45)
    @Column(name = "tema_q_y_r")
    private String temaQYR;
    @Size(max = 70)
    @Column(name = "descripcion_asunto")
    private String descripcionAsunto;
    @Size(max = 60)
    @Column(name = "empresa_transportadora")
    private String empresaTransportadora;
    @Size(max = 45)
    @Column(name = "numero_guia_r")
    private String numeroGuiaR;
    @Size(max = 45)
    @Column(name = "cc_nit_remitente")
    private String ccNitRemitente;
    @Size(max = 70)
    @Column(name = "remitente_nombre_entidad_externa")
    private String remitenteNombreEntidadExterna;
    @Size(max = 70)
    @Column(name = "nombre_persona")
    private String nombrePersona;
    @Size(max = 70)
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
    @Size(max = 45)
    @Column(name = "direccion_remitente")
    private String direccionRemitente;
    @Size(max = 45)
    @Column(name = "telefono_remitente")
    private String telefonoRemitente;
    @Size(max = 70)
    @Column(name = "email_remitente")
    private String emailRemitente;
    @Size(max = 45)
    @Column(name = "cod_dependencia_cfp_destino")
    private String codDependenciaCfpDestino;
    @Size(max = 45)
    @Column(name = "nombre_regional_destino")
    private String nombreRegionalDestino;
    @Size(max = 45)
    @Column(name = "cod_regional_destino")
    private String codRegionalDestino;
    @Size(max = 45)
    @Column(name = "funcionario_destino")
    private String funcionarioDestino;
    @Size(max = 70)
    @Column(name = "email_usuario")
    private String emailUsuario;
    @Size(max = 100)
    @Column(name = "dependencia_destino")
    private String dependenciaDestino;
    @Size(max = 45)
    @Column(name = "copia_cod_dependencia")
    private String copiaCodDependencia;
    @Size(max = 45)
    @Column(name = "copia_cod_regional")
    private String copiaCodRegional;
    @Size(max = 45)
    @Column(name = "copia_funcionario_destino")
    private String copiaFuncionarioDestino;
    @Size(max = 45)
    @Column(name = "copia_dependencia")
    private String copiaDependencia;
    @Size(max = 45)
    @Column(name = "copia_nombre_regional")
    private String copiaNombreRegional;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 70)
    @Column(name = "sw_envio_correo")
    private String swEnvioCorreo;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "wf_usuario_actual")
    private String wfUsuarioActual;
    @Size(max = 45)
    @Column(name = "fecha_hora")
    private String fechaHora;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 70)
    @Column(name = "copia_email_usuario")
    private String copiaEmailUsuario;
    @Size(max = 45)
    @Column(name = "copia_username")
    private String copiaUsername;
    @Size(max = 45)
    @Column(name = "usar_name_od")
    private String usarNameOd;
    @Size(max = 45)
    @Column(name = "cod_archivo_fisico")
    private String codArchivoFisico;
    @Size(max = 45)
    @Column(name = "mail_mesageid")
    private String mailMesageid;
    @Size(max = 45)
    @Column(name = "wf_usuario_balanceo")
    private String wfUsuarioBalanceo;
    @Size(max = 45)
    @Column(name = "entregado_a_interno")
    private String entregadoAInterno;
    @Size(max = 45)
    @Column(name = "superior_funcionario_destino_mail")
    private String superiorFuncionarioDestinoMail;
    @Size(max = 45)
    @Column(name = "mail_cc")
    private String mailCc;
    @Size(max = 45)
    @Column(name = "tipo_de_proceso")
    private String tipoDeProceso;
    @Size(max = 45)
    @Column(name = "realizado_por")
    private String realizadoPor;
    @Size(max = 45)
    @Column(name = "flag")
    private String flag;
    @Size(max = 45)
    @Column(name = "cod_dependencia_o_cfp_destino")
    private String codDependenciaOCfpDestino;
    @Size(max = 100)
    @Column(name = "dependencia_destino_original")
    private String dependenciaDestinoOriginal;
    @Size(max = 60)
    @Column(name = "funcionario_destino_original")
    private String funcionarioDestinoOriginal;
    @Size(max = 45)
    @Column(name = "handle")
    private String handle;
    @Size(max = 60)
    @Column(name = "numero_antecedentes")
    private String numeroAntecedentes;
    @Size(max = 45)
    @Column(name = "control_security_keyword")
    private String controlSecurityKeyword;
    @Size(max = 70)
    @Column(name = "email_superior_destino")
    private String emailSuperiorDestino;
    @Size(max = 70)
    @Column(name = "regional_remitente_interno")
    private String regionalRemitenteInterno;
    @Size(max = 75)
    @Column(name = "cod_regional_remitente_interno")
    private String codRegionalRemitenteInterno;
    @Size(max = 45)
    @Column(name = "funcionario_remitente_interno")
    private String funcionarioRemitenteInterno;
    @Size(max = 45)
    @Column(name = "cod_dependencia_remitente_interno")
    private String codDependenciaRemitenteInterno;
    @Size(max = 45)
    @Column(name = "dependencia_remitente_interna")
    private String dependenciaRemitenteInterna;
    @Size(max = 45)
    @Column(name = "fecha_del_documento")
    private String fechaDelDocumento;

    public DatosOnbase() {
    }

    public DatosOnbase(String numRadicadoRecibida) {
        this.numRadicadoRecibida = numRadicadoRecibida;
    }

    public String getNumRadicadoRecibida() {
        return numRadicadoRecibida;
    }

    public void setNumRadicadoRecibida(String numRadicadoRecibida) {
        this.numRadicadoRecibida = numRadicadoRecibida;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getCodigoRegional() {
        return codigoRegional;
    }

    public void setCodigoRegional(String codigoRegional) {
        this.codigoRegional = codigoRegional;
    }

    public String getModoIngreso() {
        return modoIngreso;
    }

    public void setModoIngreso(String modoIngreso) {
        this.modoIngreso = modoIngreso;
    }

    public String getEntragaALaMano() {
        return entragaALaMano;
    }

    public void setEntragaALaMano(String entragaALaMano) {
        this.entragaALaMano = entragaALaMano;
    }

    public String getFechaProcedencia() {
        return fechaProcedencia;
    }

    public void setFechaProcedencia(String fechaProcedencia) {
        this.fechaProcedencia = fechaProcedencia;
    }

    public String getNumeroRadicadoOrigen() {
        return numeroRadicadoOrigen;
    }

    public void setNumeroRadicadoOrigen(String numeroRadicadoOrigen) {
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

    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getNumeroDeAnexos() {
        return numeroDeAnexos;
    }

    public void setNumeroDeAnexos(String numeroDeAnexos) {
        this.numeroDeAnexos = numeroDeAnexos;
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

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDpTipoDePeticion() {
        return dpTipoDePeticion;
    }

    public void setDpTipoDePeticion(String dpTipoDePeticion) {
        this.dpTipoDePeticion = dpTipoDePeticion;
    }

    public String getTemaQYR() {
        return temaQYR;
    }

    public void setTemaQYR(String temaQYR) {
        this.temaQYR = temaQYR;
    }

    public String getDescripcionAsunto() {
        return descripcionAsunto;
    }

    public void setDescripcionAsunto(String descripcionAsunto) {
        this.descripcionAsunto = descripcionAsunto;
    }

    public String getEmpresaTransportadora() {
        return empresaTransportadora;
    }

    public void setEmpresaTransportadora(String empresaTransportadora) {
        this.empresaTransportadora = empresaTransportadora;
    }

    public String getNumeroGuiaR() {
        return numeroGuiaR;
    }

    public void setNumeroGuiaR(String numeroGuiaR) {
        this.numeroGuiaR = numeroGuiaR;
    }

    public String getCcNitRemitente() {
        return ccNitRemitente;
    }

    public void setCcNitRemitente(String ccNitRemitente) {
        this.ccNitRemitente = ccNitRemitente;
    }

    public String getRemitenteNombreEntidadExterna() {
        return remitenteNombreEntidadExterna;
    }

    public void setRemitenteNombreEntidadExterna(String remitenteNombreEntidadExterna) {
        this.remitenteNombreEntidadExterna = remitenteNombreEntidadExterna;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
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

    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    public void setDireccionRemitente(String direccionRemitente) {
        this.direccionRemitente = direccionRemitente;
    }

    public String getTelefonoRemitente() {
        return telefonoRemitente;
    }

    public void setTelefonoRemitente(String telefonoRemitente) {
        this.telefonoRemitente = telefonoRemitente;
    }

    public String getEmailRemitente() {
        return emailRemitente;
    }

    public void setEmailRemitente(String emailRemitente) {
        this.emailRemitente = emailRemitente;
    }

    public String getCodDependenciaCfpDestino() {
        return codDependenciaCfpDestino;
    }

    public void setCodDependenciaCfpDestino(String codDependenciaCfpDestino) {
        this.codDependenciaCfpDestino = codDependenciaCfpDestino;
    }

    public String getNombreRegionalDestino() {
        return nombreRegionalDestino;
    }

    public void setNombreRegionalDestino(String nombreRegionalDestino) {
        this.nombreRegionalDestino = nombreRegionalDestino;
    }

    public String getCodRegionalDestino() {
        return codRegionalDestino;
    }

    public void setCodRegionalDestino(String codRegionalDestino) {
        this.codRegionalDestino = codRegionalDestino;
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

    public String getCopiaCodDependencia() {
        return copiaCodDependencia;
    }

    public void setCopiaCodDependencia(String copiaCodDependencia) {
        this.copiaCodDependencia = copiaCodDependencia;
    }

    public String getCopiaCodRegional() {
        return copiaCodRegional;
    }

    public void setCopiaCodRegional(String copiaCodRegional) {
        this.copiaCodRegional = copiaCodRegional;
    }

    public String getCopiaFuncionarioDestino() {
        return copiaFuncionarioDestino;
    }

    public void setCopiaFuncionarioDestino(String copiaFuncionarioDestino) {
        this.copiaFuncionarioDestino = copiaFuncionarioDestino;
    }

    public String getCopiaDependencia() {
        return copiaDependencia;
    }

    public void setCopiaDependencia(String copiaDependencia) {
        this.copiaDependencia = copiaDependencia;
    }

    public String getCopiaNombreRegional() {
        return copiaNombreRegional;
    }

    public void setCopiaNombreRegional(String copiaNombreRegional) {
        this.copiaNombreRegional = copiaNombreRegional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSwEnvioCorreo() {
        return swEnvioCorreo;
    }

    public void setSwEnvioCorreo(String swEnvioCorreo) {
        this.swEnvioCorreo = swEnvioCorreo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWfUsuarioActual() {
        return wfUsuarioActual;
    }

    public void setWfUsuarioActual(String wfUsuarioActual) {
        this.wfUsuarioActual = wfUsuarioActual;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCopiaEmailUsuario() {
        return copiaEmailUsuario;
    }

    public void setCopiaEmailUsuario(String copiaEmailUsuario) {
        this.copiaEmailUsuario = copiaEmailUsuario;
    }

    public String getCopiaUsername() {
        return copiaUsername;
    }

    public void setCopiaUsername(String copiaUsername) {
        this.copiaUsername = copiaUsername;
    }

    public String getUsarNameOd() {
        return usarNameOd;
    }

    public void setUsarNameOd(String usarNameOd) {
        this.usarNameOd = usarNameOd;
    }

    public String getCodArchivoFisico() {
        return codArchivoFisico;
    }

    public void setCodArchivoFisico(String codArchivoFisico) {
        this.codArchivoFisico = codArchivoFisico;
    }

    public String getMailMesageid() {
        return mailMesageid;
    }

    public void setMailMesageid(String mailMesageid) {
        this.mailMesageid = mailMesageid;
    }

    public String getWfUsuarioBalanceo() {
        return wfUsuarioBalanceo;
    }

    public void setWfUsuarioBalanceo(String wfUsuarioBalanceo) {
        this.wfUsuarioBalanceo = wfUsuarioBalanceo;
    }

    public String getEntregadoAInterno() {
        return entregadoAInterno;
    }

    public void setEntregadoAInterno(String entregadoAInterno) {
        this.entregadoAInterno = entregadoAInterno;
    }

    public String getSuperiorFuncionarioDestinoMail() {
        return superiorFuncionarioDestinoMail;
    }

    public void setSuperiorFuncionarioDestinoMail(String superiorFuncionarioDestinoMail) {
        this.superiorFuncionarioDestinoMail = superiorFuncionarioDestinoMail;
    }

    public String getMailCc() {
        return mailCc;
    }

    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }

    public String getTipoDeProceso() {
        return tipoDeProceso;
    }

    public void setTipoDeProceso(String tipoDeProceso) {
        this.tipoDeProceso = tipoDeProceso;
    }

    public String getRealizadoPor() {
        return realizadoPor;
    }

    public void setRealizadoPor(String realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCodDependenciaOCfpDestino() {
        return codDependenciaOCfpDestino;
    }

    public void setCodDependenciaOCfpDestino(String codDependenciaOCfpDestino) {
        this.codDependenciaOCfpDestino = codDependenciaOCfpDestino;
    }

    public String getDependenciaDestinoOriginal() {
        return dependenciaDestinoOriginal;
    }

    public void setDependenciaDestinoOriginal(String dependenciaDestinoOriginal) {
        this.dependenciaDestinoOriginal = dependenciaDestinoOriginal;
    }

    public String getFuncionarioDestinoOriginal() {
        return funcionarioDestinoOriginal;
    }

    public void setFuncionarioDestinoOriginal(String funcionarioDestinoOriginal) {
        this.funcionarioDestinoOriginal = funcionarioDestinoOriginal;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getNumeroAntecedentes() {
        return numeroAntecedentes;
    }

    public void setNumeroAntecedentes(String numeroAntecedentes) {
        this.numeroAntecedentes = numeroAntecedentes;
    }

    public String getControlSecurityKeyword() {
        return controlSecurityKeyword;
    }

    public void setControlSecurityKeyword(String controlSecurityKeyword) {
        this.controlSecurityKeyword = controlSecurityKeyword;
    }

    public String getEmailSuperiorDestino() {
        return emailSuperiorDestino;
    }

    public void setEmailSuperiorDestino(String emailSuperiorDestino) {
        this.emailSuperiorDestino = emailSuperiorDestino;
    }

    public String getRegionalRemitenteInterno() {
        return regionalRemitenteInterno;
    }

    public void setRegionalRemitenteInterno(String regionalRemitenteInterno) {
        this.regionalRemitenteInterno = regionalRemitenteInterno;
    }

    public String getCodRegionalRemitenteInterno() {
        return codRegionalRemitenteInterno;
    }

    public void setCodRegionalRemitenteInterno(String codRegionalRemitenteInterno) {
        this.codRegionalRemitenteInterno = codRegionalRemitenteInterno;
    }

    public String getFuncionarioRemitenteInterno() {
        return funcionarioRemitenteInterno;
    }

    public void setFuncionarioRemitenteInterno(String funcionarioRemitenteInterno) {
        this.funcionarioRemitenteInterno = funcionarioRemitenteInterno;
    }

    public String getCodDependenciaRemitenteInterno() {
        return codDependenciaRemitenteInterno;
    }

    public void setCodDependenciaRemitenteInterno(String codDependenciaRemitenteInterno) {
        this.codDependenciaRemitenteInterno = codDependenciaRemitenteInterno;
    }

    public String getDependenciaRemitenteInterna() {
        return dependenciaRemitenteInterna;
    }

    public void setDependenciaRemitenteInterna(String dependenciaRemitenteInterna) {
        this.dependenciaRemitenteInterna = dependenciaRemitenteInterna;
    }

    public String getFechaDelDocumento() {
        return fechaDelDocumento;
    }

    public void setFechaDelDocumento(String fechaDelDocumento) {
        this.fechaDelDocumento = fechaDelDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numRadicadoRecibida != null ? numRadicadoRecibida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosOnbase)) {
            return false;
        }
        DatosOnbase other = (DatosOnbase) object;
        if ((this.numRadicadoRecibida == null && other.numRadicadoRecibida != null) || (this.numRadicadoRecibida != null && !this.numRadicadoRecibida.equals(other.numRadicadoRecibida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.DatosOnbase[ numRadicadoRecibida=" + numRadicadoRecibida + " ]";
    }
    
}
