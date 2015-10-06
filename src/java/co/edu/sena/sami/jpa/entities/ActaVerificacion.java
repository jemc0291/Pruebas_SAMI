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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Snyck
 */
@Entity
@Table(name = "acta_verificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActaVerificacion.findAll", query = "SELECT a FROM ActaVerificacion a"),
    @NamedQuery(name = "ActaVerificacion.findByIdActaVerificacion", query = "SELECT a FROM ActaVerificacion a WHERE a.idActaVerificacion = :idActaVerificacion"),
    @NamedQuery(name = "ActaVerificacion.findByProveedores", query = "SELECT a FROM ActaVerificacion a WHERE a.proveedores = :proveedores"),
    @NamedQuery(name = "ActaVerificacion.findByNumContrato", query = "SELECT a FROM ActaVerificacion a WHERE a.numContrato = :numContrato"),
    @NamedQuery(name = "ActaVerificacion.findByEntrega", query = "SELECT a FROM ActaVerificacion a WHERE a.entrega = :entrega"),
    @NamedQuery(name = "ActaVerificacion.findByLugarRecepcion", query = "SELECT a FROM ActaVerificacion a WHERE a.lugarRecepcion = :lugarRecepcion"),
    @NamedQuery(name = "ActaVerificacion.findByFecha", query = "SELECT a FROM ActaVerificacion a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "ActaVerificacion.findByHora", query = "SELECT a FROM ActaVerificacion a WHERE a.hora = :hora"),
    @NamedQuery(name = "ActaVerificacion.findByValor", query = "SELECT a FROM ActaVerificacion a WHERE a.valor = :valor"),
    @NamedQuery(name = "ActaVerificacion.findByTotalRecibidoFactura", query = "SELECT a FROM ActaVerificacion a WHERE a.totalRecibidoFactura = :totalRecibidoFactura"),
    @NamedQuery(name = "ActaVerificacion.findByTipoVerificacion", query = "SELECT a FROM ActaVerificacion a WHERE a.tipoVerificacion = :tipoVerificacion"),
    @NamedQuery(name = "ActaVerificacion.findByUnidadesRevisadas", query = "SELECT a FROM ActaVerificacion a WHERE a.unidadesRevisadas = :unidadesRevisadas"),
    @NamedQuery(name = "ActaVerificacion.findByAprobo", query = "SELECT a FROM ActaVerificacion a WHERE a.aprobo = :aprobo"),
    @NamedQuery(name = "ActaVerificacion.findByPendienteEntrega", query = "SELECT a FROM ActaVerificacion a WHERE a.pendienteEntrega = :pendienteEntrega"),
    @NamedQuery(name = "ActaVerificacion.findByObservaciones", query = "SELECT a FROM ActaVerificacion a WHERE a.observaciones = :observaciones")})
public class ActaVerificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acta_verificacion")
    private Integer idActaVerificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "proveedores")
    private String proveedores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_contrato")
    private int numContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entrega")
    private String entrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugar_recepcion")
    private String lugarRecepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_recibido_factura")
    private int totalRecibidoFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_verificacion")
    private String tipoVerificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades_revisadas")
    private int unidadesRevisadas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "aprobo")
    private String aprobo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pendiente_entrega")
    private boolean pendienteEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private Facturas idFactura;

    public ActaVerificacion() {
    }

    public ActaVerificacion(Integer idActaVerificacion) {
        this.idActaVerificacion = idActaVerificacion;
    }

    public ActaVerificacion(Integer idActaVerificacion, String proveedores, int numContrato, String entrega, String lugarRecepcion, Date fecha, Date hora, int valor, int totalRecibidoFactura, String tipoVerificacion, int unidadesRevisadas, String aprobo, boolean pendienteEntrega, String observaciones) {
        this.idActaVerificacion = idActaVerificacion;
        this.proveedores = proveedores;
        this.numContrato = numContrato;
        this.entrega = entrega;
        this.lugarRecepcion = lugarRecepcion;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.totalRecibidoFactura = totalRecibidoFactura;
        this.tipoVerificacion = tipoVerificacion;
        this.unidadesRevisadas = unidadesRevisadas;
        this.aprobo = aprobo;
        this.pendienteEntrega = pendienteEntrega;
        this.observaciones = observaciones;
    }

    public Integer getIdActaVerificacion() {
        return idActaVerificacion;
    }

    public void setIdActaVerificacion(Integer idActaVerificacion) {
        this.idActaVerificacion = idActaVerificacion;
    }

    public String getProveedores() {
        return proveedores;
    }

    public void setProveedores(String proveedores) {
        this.proveedores = proveedores;
    }

    public int getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(int numContrato) {
        this.numContrato = numContrato;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getLugarRecepcion() {
        return lugarRecepcion;
    }

    public void setLugarRecepcion(String lugarRecepcion) {
        this.lugarRecepcion = lugarRecepcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTotalRecibidoFactura() {
        return totalRecibidoFactura;
    }

    public void setTotalRecibidoFactura(int totalRecibidoFactura) {
        this.totalRecibidoFactura = totalRecibidoFactura;
    }

    public String getTipoVerificacion() {
        return tipoVerificacion;
    }

    public void setTipoVerificacion(String tipoVerificacion) {
        this.tipoVerificacion = tipoVerificacion;
    }

    public int getUnidadesRevisadas() {
        return unidadesRevisadas;
    }

    public void setUnidadesRevisadas(int unidadesRevisadas) {
        this.unidadesRevisadas = unidadesRevisadas;
    }

    public String getAprobo() {
        return aprobo;
    }

    public void setAprobo(String aprobo) {
        this.aprobo = aprobo;
    }

    public boolean getPendienteEntrega() {
        return pendienteEntrega;
    }

    public void setPendienteEntrega(boolean pendienteEntrega) {
        this.pendienteEntrega = pendienteEntrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActaVerificacion != null ? idActaVerificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActaVerificacion)) {
            return false;
        }
        ActaVerificacion other = (ActaVerificacion) object;
        if ((this.idActaVerificacion == null && other.idActaVerificacion != null) || (this.idActaVerificacion != null && !this.idActaVerificacion.equals(other.idActaVerificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sami.jpa.entities.ActaVerificacion[ idActaVerificacion=" + idActaVerificacion + " ]";
    }
    
}
