package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.EstadoCivil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.EstadoCivilFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("estadoCivilController")
@SessionScoped
public class EstadoCivilController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.EstadoCivilFacade ejbFacade;
    private List<EstadoCivil> items = null;
    private EstadoCivil selected;

    public EstadoCivilController() {
    }

    public EstadoCivil getSelected() {
        return selected;
    }

    public void setSelected(EstadoCivil selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstadoCivilFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new EstadoCivil();
        initializeEmbeddableKey();
        return "AgregarEstadoCivil";
    }

    public String prepareModificarEstadoCivil() {
        return "ModificarEstadoCivil";
    }

    public String prepareConsultarEstadoCivil() {
        return "ConsultarEstadoCivil";
    }

    public String prepareListEstadoCivil() {
        return "/Configuracion/Estado Civil/ListarEstadoCivil";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("EstadoCivilCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("EstadoCivilUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("EstadoCivilDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EstadoCivil> getItems() {
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

    public EstadoCivil getEstadoCivil(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<EstadoCivil> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EstadoCivil> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EstadoCivil.class)
    public static class EstadoCivilControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstadoCivilController controller = (EstadoCivilController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estadoCivilController");
            return controller.getEstadoCivil(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EstadoCivil) {
                EstadoCivil o = (EstadoCivil) object;
                return getStringKey(o.getIdEstadoCivil());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EstadoCivil.class.getName()});
                return null;
            }
        }

    }

}
