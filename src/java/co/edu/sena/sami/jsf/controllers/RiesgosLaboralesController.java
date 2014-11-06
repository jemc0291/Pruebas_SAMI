package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.RiesgosLaborales;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.RiesgosLaboralesFacade;

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

@Named("riesgosLaboralesController")
@SessionScoped
public class RiesgosLaboralesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.RiesgosLaboralesFacade ejbFacade;
    private List<RiesgosLaborales> items = null;
    private RiesgosLaborales selected;

    public RiesgosLaboralesController() {
    }

    public RiesgosLaborales getSelected() {
        return selected;
    }

    public void setSelected(RiesgosLaborales selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RiesgosLaboralesFacade getFacade() {
        return ejbFacade;
    }

    public RiesgosLaborales prepareCreate() {
        selected = new RiesgosLaborales();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("RiesgosLaboralesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("RiesgosLaboralesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("RiesgosLaboralesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RiesgosLaborales> getItems() {
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

    public RiesgosLaborales getRiesgosLaborales(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<RiesgosLaborales> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RiesgosLaborales> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RiesgosLaborales.class)
    public static class RiesgosLaboralesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RiesgosLaboralesController controller = (RiesgosLaboralesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "riesgosLaboralesController");
            return controller.getRiesgosLaborales(getKey(value));
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
            if (object instanceof RiesgosLaborales) {
                RiesgosLaborales o = (RiesgosLaborales) object;
                return getStringKey(o.getIdRiesgosLaborales());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RiesgosLaborales.class.getName()});
                return null;
            }
        }

    }

}
