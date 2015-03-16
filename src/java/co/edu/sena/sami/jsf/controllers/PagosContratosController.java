package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.PagosContratos;
import co.edu.sena.sami.jpa.sessions.ContratosFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.PagosContratosFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.SelectEvent;

@Named("pagosContratosController")
@SessionScoped
public class PagosContratosController implements Serializable {

    @EJB
    private ContratosFacade contratosFacade;
    @EJB
    private co.edu.sena.sami.jpa.sessions.PagosContratosFacade ejbFacade;
    private List<PagosContratos> items = null;
    private PagosContratos selected;
    private Date fechaInicio;
    private Date fechaFin;

    public PagosContratosController() {
    }

    public PagosContratos getSelected() {
        return selected;
    }

    public void setSelected(PagosContratos selected) {
        this.selected = selected;
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PagosContratosFacade getFacade() {
        return ejbFacade;
    }
    public ContratosFacade getContratosFacade() {
        return contratosFacade;
    }

    public String prepareCreate() {
        selected = new PagosContratos();
        return "/modulo3/GestionContractual/CreatePagoContrato";
    }

    public String prepareEdit() {
        return "/modulo3/GestionContractual/EditarFactura";
    }

    public String prepareView() {
        return "VerFactura";
    }
///Modulo3/GestionContractual/
    public String prepareList() {
        recargarLista();
        return "/modulo3/GestionContractual/";
    }

    public void recargarLista() {
        items = null;
    }

    public String create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("PagosContratosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "ListaFacturas";
    }

    public String update() {
        try{
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("PagosContratosUpdated"));
        return "ListaFacturas";
        }catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("PagosContratosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PagosContratos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public PagosContratos getPagosContratos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<PagosContratos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PagosContratos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    public List<PagosContratos> getFacturasRango() {
        return getFacade().rangoFechas(fechaInicio,fechaFin);
    }

    @FacesConverter(forClass = PagosContratos.class)
    public static class PagosContratosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PagosContratosController controller = (PagosContratosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pagosContratosController");
            return controller.getPagosContratos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PagosContratos) {
                PagosContratos o = (PagosContratos) object;
                return getStringKey(o.getIdPago());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PagosContratos.class.getName()});
                return null;
            }
        }

    }
    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    public void updateFecha(SelectEvent event){
        selected.setFechaDePago(selected.getFechaFactura());
    }

}
