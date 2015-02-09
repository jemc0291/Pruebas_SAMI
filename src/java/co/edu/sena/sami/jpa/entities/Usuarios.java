/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.entities;

import co.edu.sena.sami.jsf.controllers.util.DigestUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByCodigodestinoONBASE", query = "SELECT u FROM Usuarios u WHERE u.codigodestinoONBASE = :codigodestinoONBASE"),
    @NamedQuery(name = "Usuarios.findByNumeroDoc", query = "SELECT u FROM Usuarios u WHERE u.numeroDoc = :numeroDoc"),
    @NamedQuery(name = "Usuarios.findByFechaExpedicionDoc", query = "SELECT u FROM Usuarios u WHERE u.fechaExpedicionDoc = :fechaExpedicionDoc"),
    @NamedQuery(name = "Usuarios.findByRazonSocial", query = "SELECT u FROM Usuarios u WHERE u.razonSocial = :razonSocial"),
    @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuarios.findByNombreRepreLegal", query = "SELECT u FROM Usuarios u WHERE u.nombreRepreLegal = :nombreRepreLegal"),
    @NamedQuery(name = "Usuarios.findByFechaNac", query = "SELECT u FROM Usuarios u WHERE u.fechaNac = :fechaNac"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByTelefonoPrincipalUsu", query = "SELECT u FROM Usuarios u WHERE u.telefonoPrincipalUsu = :telefonoPrincipalUsu"),
    @NamedQuery(name = "Usuarios.findByTelefonoAlternoUsu", query = "SELECT u FROM Usuarios u WHERE u.telefonoAlternoUsu = :telefonoAlternoUsu"),
    @NamedQuery(name = "Usuarios.findByDireccionUsu", query = "SELECT u FROM Usuarios u WHERE u.direccionUsu = :direccionUsu"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByGpRh", query = "SELECT u FROM Usuarios u WHERE u.gpRh = :gpRh"),
    @NamedQuery(name = "Usuarios.findByCalificacion", query = "SELECT u FROM Usuarios u WHERE u.calificacion = :calificacion"),
    @NamedQuery(name = "Usuarios.findByFechaDeCreacion", query = "SELECT u FROM Usuarios u WHERE u.fechaDeCreacion = :fechaDeCreacion"),
    @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "codigo_destino_ONBASE")
    private Integer codigodestinoONBASE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_doc")
    private String numeroDoc;
    @Column(name = "fecha_expedicion_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicionDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "razon_social")
    private String razonSocial;
    @Size(max = 20)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 45)
    @Column(name = "nombre_repre_legal")
    private String nombreRepreLegal;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono_principal_usu")
    private String telefonoPrincipalUsu;
    @Size(max = 15)
    @Column(name = "telefono_alterno_usu")
    private String telefonoAlternoUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion_usu")
    private String direccionUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password")
    private String password;
    @Size(max = 3)
    @Column(name = "gp_rh")
    private String gpRh;
    @Size(max = 10)
    @Column(name = "calificacion")
    private String calificacion;
    @Column(name = "fecha_de_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;
    @Column(name = "estado")
    private Boolean estado;
    @JoinTable(name = "usuarios_crp", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "numero_crp", referencedColumnName = "numero_crp")})
    @ManyToMany
    private List<Crp> crpList;
    @JoinTable(name = "rol_usuarios", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")})
    @ManyToMany
    private List<Rol> rolList;
    @JoinTable(name = "usuario_formacion_academica", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_formacion", referencedColumnName = "id_formacion")})
    @ManyToMany
    private List<FormacionAcademica> formacionAcademicaList;
    @JoinTable(name = "usuarios_cdp", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "numero_cdp", referencedColumnName = "numero_cdp")})
    @ManyToMany
    private List<Cdp> cdpList;
    @JoinTable(name = "usuarios_ficha_caracterizacion", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")})
    @ManyToMany
    private List<FichaCaracterizacion> fichaCaracterizacionList;
    @JoinTable(name = "usuarios_solicitud_servicios", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_solicitud_servicio", referencedColumnName = "id_solicitud_servicio")})
    @ManyToMany
    private List<SolicitudServicios> solicitudServiciosList;
    @JoinTable(name = "usuarios_riesgos_laborales", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_riesgos_laborales", referencedColumnName = "id_riesgos_laborales")})
    @ManyToMany
    private List<RiesgosLaborales> riesgosLaboralesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Documentos> documentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<InformesDeComisiones> informesDeComisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Novedades> novedadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Pagos> pagosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<RelacionesGastosDeTransporte> relacionesGastosDeTransporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<OrdenesDeviaje> ordenesDeviajeList;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_doc")
    @ManyToOne(optional = false)
    private TipoDocumentos idTipoDoc;
    @JoinColumn(name = "id_estrato_social", referencedColumnName = "id_estrato_social")
    @ManyToOne
    private EstratoSocial idEstratoSocial;
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil")
    @ManyToOne
    private EstadoCivil idEstadoCivil;
    @JoinColumn(name = "id_sexo", referencedColumnName = "id_sexo")
    @ManyToOne
    private Sexo idSexo;
    @JoinColumn(name = "id_ccf", referencedColumnName = "id_ccf")
    @ManyToOne
    private Ccf idCcf;
    @JoinColumn(name = "id_fondo_pensiones", referencedColumnName = "id_fondo_pensiones")
    @ManyToOne
    private FondoDePensiones idFondoPensiones;
    @JoinColumn(name = "id_eps", referencedColumnName = "id_eps")
    @ManyToOne
    private Eps idEps;
    @JoinColumn(name = "id_arl", referencedColumnName = "id_arl")
    @ManyToOne
    private Arl idArl;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad_exp_doc", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto_exp_doc", referencedColumnName = "id_dpto")})
    @ManyToOne
    private Ciudad ciudad;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad_residencia", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_dpto_residencia", referencedColumnName = "id_dpto")})
    @ManyToOne(optional = false)
    private Ciudad ciudad1;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne
    private CentroFormacion idCentroFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<UsuariosSolicitudMaterialesAlmacen> usuariosSolicitudMaterialesAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ActaVerificacion> actaVerificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Comisiones> comisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<UsuariosContratos> usuariosContratosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Facturas> facturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<CuentasBancarias> cuentasBancariasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioAdmin")
    private List<DatosOnbase> datosOnbaseList;
    @OneToMany(mappedBy = "idUsuarioDestino")
    private List<DatosOnbase> datosOnbaseList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<ContratosPolizasUsuarios> contratosPolizasUsuariosList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String numeroDoc, String razonSocial, String primerApellido, String email, String telefonoPrincipalUsu, String direccionUsu, String password) {
        this.idUsuario = idUsuario;
        this.numeroDoc = numeroDoc;
        this.razonSocial = razonSocial;
        this.primerApellido = primerApellido;
        this.email = email;
        this.telefonoPrincipalUsu = telefonoPrincipalUsu;
        this.direccionUsu = direccionUsu;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCodigodestinoONBASE() {
        return codigodestinoONBASE;
    }

    public void setCodigodestinoONBASE(Integer codigodestinoONBASE) {
        this.codigodestinoONBASE = codigodestinoONBASE;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Date getFechaExpedicionDoc() {
        return fechaExpedicionDoc;
    }

    public void setFechaExpedicionDoc(Date fechaExpedicionDoc) {
        this.fechaExpedicionDoc = fechaExpedicionDoc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreRepreLegal() {
        return nombreRepreLegal;
    }

    public void setNombreRepreLegal(String nombreRepreLegal) {
        this.nombreRepreLegal = nombreRepreLegal;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoPrincipalUsu() {
        return telefonoPrincipalUsu;
    }

    public void setTelefonoPrincipalUsu(String telefonoPrincipalUsu) {
        this.telefonoPrincipalUsu = telefonoPrincipalUsu;
    }

    public String getTelefonoAlternoUsu() {
        return telefonoAlternoUsu;
    }

    public void setTelefonoAlternoUsu(String telefonoAlternoUsu) {
        this.telefonoAlternoUsu = telefonoAlternoUsu;
    }

    public String getDireccionUsu() {
        return direccionUsu;
    }

    public void setDireccionUsu(String direccionUsu) {
        this.direccionUsu = direccionUsu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         try {
            this.password = DigestUtil.generateDigest(password);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getGpRh() {
        return gpRh;
    }

    public void setGpRh(String gpRh) {
        this.gpRh = gpRh;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Crp> getCrpList() {
        return crpList;
    }

    public void setCrpList(List<Crp> crpList) {
        this.crpList = crpList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<FormacionAcademica> getFormacionAcademicaList() {
        return formacionAcademicaList;
    }

    public void setFormacionAcademicaList(List<FormacionAcademica> formacionAcademicaList) {
        this.formacionAcademicaList = formacionAcademicaList;
    }

    @XmlTransient
    public List<Cdp> getCdpList() {
        return cdpList;
    }

    public void setCdpList(List<Cdp> cdpList) {
        this.cdpList = cdpList;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @XmlTransient
    public List<SolicitudServicios> getSolicitudServiciosList() {
        return solicitudServiciosList;
    }

    public void setSolicitudServiciosList(List<SolicitudServicios> solicitudServiciosList) {
        this.solicitudServiciosList = solicitudServiciosList;
    }

    @XmlTransient
    public List<RiesgosLaborales> getRiesgosLaboralesList() {
        return riesgosLaboralesList;
    }

    public void setRiesgosLaboralesList(List<RiesgosLaborales> riesgosLaboralesList) {
        this.riesgosLaboralesList = riesgosLaboralesList;
    }

    @XmlTransient
    public List<Documentos> getDocumentosList() {
        return documentosList;
    }

    public void setDocumentosList(List<Documentos> documentosList) {
        this.documentosList = documentosList;
    }

    @XmlTransient
    public List<InformesDeComisiones> getInformesDeComisionesList() {
        return informesDeComisionesList;
    }

    public void setInformesDeComisionesList(List<InformesDeComisiones> informesDeComisionesList) {
        this.informesDeComisionesList = informesDeComisionesList;
    }

    @XmlTransient
    public List<Novedades> getNovedadesList() {
        return novedadesList;
    }

    public void setNovedadesList(List<Novedades> novedadesList) {
        this.novedadesList = novedadesList;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @XmlTransient
    public List<RelacionesGastosDeTransporte> getRelacionesGastosDeTransporteList() {
        return relacionesGastosDeTransporteList;
    }

    public void setRelacionesGastosDeTransporteList(List<RelacionesGastosDeTransporte> relacionesGastosDeTransporteList) {
        this.relacionesGastosDeTransporteList = relacionesGastosDeTransporteList;
    }

    @XmlTransient
    public List<OrdenesDeviaje> getOrdenesDeviajeList() {
        return ordenesDeviajeList;
    }

    public void setOrdenesDeviajeList(List<OrdenesDeviaje> ordenesDeviajeList) {
        this.ordenesDeviajeList = ordenesDeviajeList;
    }

    public TipoDocumentos getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(TipoDocumentos idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public EstratoSocial getIdEstratoSocial() {
        return idEstratoSocial;
    }

    public void setIdEstratoSocial(EstratoSocial idEstratoSocial) {
        this.idEstratoSocial = idEstratoSocial;
    }

    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Sexo getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Sexo idSexo) {
        this.idSexo = idSexo;
    }

    public Ccf getIdCcf() {
        return idCcf;
    }

    public void setIdCcf(Ccf idCcf) {
        this.idCcf = idCcf;
    }

    public FondoDePensiones getIdFondoPensiones() {
        return idFondoPensiones;
    }

    public void setIdFondoPensiones(FondoDePensiones idFondoPensiones) {
        this.idFondoPensiones = idFondoPensiones;
    }

    public Eps getIdEps() {
        return idEps;
    }

    public void setIdEps(Eps idEps) {
        this.idEps = idEps;
    }

    public Arl getIdArl() {
        return idArl;
    }

    public void setIdArl(Arl idArl) {
        this.idArl = idArl;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(Ciudad ciudad1) {
        this.ciudad1 = ciudad1;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    @XmlTransient
    public List<UsuariosSolicitudMaterialesAlmacen> getUsuariosSolicitudMaterialesAlmacenList() {
        return usuariosSolicitudMaterialesAlmacenList;
    }

    public void setUsuariosSolicitudMaterialesAlmacenList(List<UsuariosSolicitudMaterialesAlmacen> usuariosSolicitudMaterialesAlmacenList) {
        this.usuariosSolicitudMaterialesAlmacenList = usuariosSolicitudMaterialesAlmacenList;
    }

    @XmlTransient
    public List<ActaVerificacion> getActaVerificacionList() {
        return actaVerificacionList;
    }

    public void setActaVerificacionList(List<ActaVerificacion> actaVerificacionList) {
        this.actaVerificacionList = actaVerificacionList;
    }

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    @XmlTransient
    public List<UsuariosContratos> getUsuariosContratosList() {
        return usuariosContratosList;
    }

    public void setUsuariosContratosList(List<UsuariosContratos> usuariosContratosList) {
        this.usuariosContratosList = usuariosContratosList;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @XmlTransient
    public List<CuentasBancarias> getCuentasBancariasList() {
        return cuentasBancariasList;
    }

    public void setCuentasBancariasList(List<CuentasBancarias> cuentasBancariasList) {
        this.cuentasBancariasList = cuentasBancariasList;
    }

    @XmlTransient
    public List<DatosOnbase> getDatosOnbaseList() {
        return datosOnbaseList;
    }

    public void setDatosOnbaseList(List<DatosOnbase> datosOnbaseList) {
        this.datosOnbaseList = datosOnbaseList;
    }

    @XmlTransient
    public List<DatosOnbase> getDatosOnbaseList1() {
        return datosOnbaseList1;
    }

    public void setDatosOnbaseList1(List<DatosOnbase> datosOnbaseList1) {
        this.datosOnbaseList1 = datosOnbaseList1;
    }

    @XmlTransient
    public List<ContratosPolizasUsuarios> getContratosPolizasUsuariosList() {
        return contratosPolizasUsuariosList;
    }

    public void setContratosPolizasUsuariosList(List<ContratosPolizasUsuarios> contratosPolizasUsuariosList) {
        this.contratosPolizasUsuariosList = contratosPolizasUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
