package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.TipoDeServicios;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.TipoDeServiciosFacade;

import java.io.Serializable;
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

@Named("tipoDeServiciosController")
@SessionScoped
public class TipoDeServiciosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.TipoDeServiciosFacade ejbFacade;
    private List<TipoDeServicios> items = null;
    private TipoDeServicios selected;
    private List<TipoDeServicios> listTipoDeServicios = null;
    @EJB
    private TipoDeServiciosFacade tipoDeServiciosFacade;

    public TipoDeServiciosController() {
    }

    public TipoDeServicios getSelected() {
        return selected;
    }

    public void setSelected(TipoDeServicios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoDeServiciosFacade getFacade() {
        return ejbFacade;
    }
    
     public TipoDeServiciosFacade getTipoDeServiciosFacade() {
        return tipoDeServiciosFacade;
    }
     
    public List<TipoDeServicios> getListTipoDeServicios() {
        if (listTipoDeServicios == null) {
            try {
                listTipoDeServicios = getTipoDeServiciosFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listTipoDeServicios;
    }

    public TipoDeServicios prepareCreate() {
        selected = new TipoDeServicios();
        initializeEmbeddableKey();
        return selected;
    }
    
    

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoDeServiciosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoDeServiciosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoDeServiciosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TipoDeServicios> getItems() {
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

    public TipoDeServicios getTipoDeServicios(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TipoDeServicios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TipoDeServicios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TipoDeServicios.class)
    public static class TipoDeServiciosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoDeServiciosController controller = (TipoDeServiciosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoDeServiciosController");
            return controller.getTipoDeServicios(getKey(value));
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
            if (object instanceof TipoDeServicios) {
                TipoDeServicios o = (TipoDeServicios) object;
                return getStringKey(o.getIdTipoServ());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoDeServicios.class.getName()});
                return null;
            }
        }

    }
    
     private void addErrorMessage(String title, String msg) {
        FacesMessage faceMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, faceMsg);
    }
}
