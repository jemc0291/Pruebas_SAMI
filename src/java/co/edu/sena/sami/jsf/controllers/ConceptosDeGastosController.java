package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.ConceptosDeGastos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ConceptosDeGastosFacade;

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

@Named("conceptosDeGastosController")
@SessionScoped
public class ConceptosDeGastosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ConceptosDeGastosFacade ejbFacade;
    private List<ConceptosDeGastos> items = null;
    private ConceptosDeGastos selected;

    public ConceptosDeGastosController() {
    }

    public ConceptosDeGastos getSelected() {
        return selected;
    }

    public void setSelected(ConceptosDeGastos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ConceptosDeGastosFacade getFacade() {
        return ejbFacade;
    }

    public ConceptosDeGastos prepareCreate() {
        selected = new ConceptosDeGastos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ConceptosDeGastosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ConceptosDeGastosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ConceptosDeGastosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ConceptosDeGastos> getItems() {
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

    public ConceptosDeGastos getConceptosDeGastos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ConceptosDeGastos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ConceptosDeGastos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ConceptosDeGastos.class)
    public static class ConceptosDeGastosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ConceptosDeGastosController controller = (ConceptosDeGastosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "conceptosDeGastosController");
            return controller.getConceptosDeGastos(getKey(value));
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
            if (object instanceof ConceptosDeGastos) {
                ConceptosDeGastos o = (ConceptosDeGastos) object;
                return getStringKey(o.getCodigoGasto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ConceptosDeGastos.class.getName()});
                return null;
            }
        }

    }

}
