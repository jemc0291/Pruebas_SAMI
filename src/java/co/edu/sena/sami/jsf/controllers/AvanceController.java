/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Prioridades;//Prioridades
import co.edu.sena.sami.jpa.entities.Estados;
import co.edu.sena.sami.jpa.entities.Avance;
import co.edu.sena.sami.jpa.entities.AvanceUsuarios;
import co.edu.sena.sami.jpa.entities.TipoDeServicios;
import co.edu.sena.sami.jpa.entities.TipoUsuario;
import co.edu.sena.sami.jpa.sessions.PrioridadesFacade;//PrioridadesFacade
import co.edu.sena.sami.jpa.sessions.EstadosFacade;
import co.edu.sena.sami.jpa.sessions.AvanceFacade;
import co.edu.sena.sami.jpa.sessions.TipoDeServiciosFacade;
import co.edu.sena.sami.jpa.sessions.TipoUsuarioFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Xervaelyx
 */
@ManagedBean
@SessionScoped
public class AvanceController implements Serializable {

    private Avance avanceActual;

    private List<Avance> listAvance = null;

    private List<Estados> listEstado = null;
    
    private List<Prioridades> listPrioridades = null;

    @EJB
    private AvanceFacade avanceFacade;

    @EJB
    private TipoUsuarioFacade tipoUsarioFacade;

    @EJB
    private PrioridadesFacade prioridadesFacade;

    @EJB
    private EstadosFacade estadosFacade;

    public AvanceController() {
    }

    public List<Avance> getListAvance() {
        return listAvance;
    }

    public AvanceFacade getAvanceFacade() {
        return avanceFacade;
    }

    public TipoUsuarioFacade getTipoUsarioFacade() {
        return tipoUsarioFacade;
    }

    public PrioridadesFacade getPrioridadesFacade() {
        return prioridadesFacade;
    }

    public List<Estados> getListEstado() {
        if (listEstado == null) {
            try {
                listEstado = getEstadosFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listEstado;
    }
    
        public List<Prioridades> getListPrioridades() {
        if (listPrioridades == null) {
            try {
                listPrioridades = getPrioridadesFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listPrioridades;
    }

    public EstadosFacade getEstadosFacade() {
        return estadosFacade;
    }

    public Avance getAvanceActual() {
        if (avanceActual == null) {
            avanceActual = new Avance();
        }
        return avanceActual;
    }

    public void setSolicitudActual(Avance avanceActual) {
        this.avanceActual = avanceActual;
    }

    public List<Prioridades> getListPrioridadesSelectOne() {
        return getPrioridadesFacade().findAll();
    }

    public List<Avance> getlistAvance() {
        if (listAvance == null) {
            try {
                listAvance = getAvanceFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listAvance;
    }

    public List<TipoUsuario> getListTipoUsusarioSelectOne() {
        return getTipoUsarioFacade().findAll();
    }

    public String prepareCreate() {
        avanceActual = new Avance();
        return "Create";
    }

    public String prepareEdit() {
        return "Edit";

    }

    public String prepareView() {
        return "View";

    }

    public String prepareList() {
        recargarLista();
        return "/Solicitud de Mantenimiento/List";
    }

    private void recargarLista() {
        listAvance = null;
    }

    public String addAvance() {
        try {
            avanceActual.setFechaAvance(new Date());
            getAvanceFacade().create(avanceActual);
            recargarLista();
            addSuccesMessage("Crear Avance", "Avance Creado Exitosamente");
            return "View";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateAvance() {
        try {
            getAvanceFacade().edit(avanceActual);
            recargarLista();
            addSuccesMessage("Actualizar Solicitud", "Avance Actualizado Exitosamente");
            return "View";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteAvance() {
        try {
            getAvanceFacade().remove(avanceActual);
            recargarLista();
            addSuccesMessage("Borrar Avance", "Avance Borrado Exitosamente");
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
    }

    private void addErrorMessage(String title, String msg) {
        FacesMessage faceMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, faceMsg);
    }

    private void addSuccesMessage(String title, String msg) {
        FacesMessage facesMessage
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
    }
}
