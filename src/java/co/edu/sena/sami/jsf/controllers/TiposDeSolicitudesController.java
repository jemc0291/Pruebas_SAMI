package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.TiposDeSolicitudes;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.TiposDeSolicitudesFacade;

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

@Named("tiposDeSolicitudesController")
@SessionScoped
public class TiposDeSolicitudesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.TiposDeSolicitudesFacade ejbFacade;
    private List<TiposDeSolicitudes> items = null;
    private TiposDeSolicitudes selected;

    public TiposDeSolicitudesController() {
    }

    public TiposDeSolicitudes getSelected() {
        return selected;
    }

    public void setSelected(TiposDeSolicitudes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TiposDeSolicitudesFacade getFacade() {
        return ejbFacade;
    }

    public TiposDeSolicitudes prepareCreate() {
        selected = new TiposDeSolicitudes();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("TiposDeSolicitudesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("TiposDeSolicitudesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("TiposDeSolicitudesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TiposDeSolicitudes> getItems() {
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

    public TiposDeSolicitudes getTiposDeSolicitudes(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TiposDeSolicitudes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TiposDeSolicitudes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TiposDeSolicitudes.class)
    public static class TiposDeSolicitudesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TiposDeSolicitudesController controller = (TiposDeSolicitudesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tiposDeSolicitudesController");
            return controller.getTiposDeSolicitudes(getKey(value));
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
            if (object instanceof TiposDeSolicitudes) {
                TiposDeSolicitudes o = (TiposDeSolicitudes) object;
                return getStringKey(o.getIdTipoSolicitud());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TiposDeSolicitudes.class.getName()});
                return null;
            }
        }

    }

}
