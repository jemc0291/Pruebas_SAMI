package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Arl;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ArlFacade;

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

@Named("arlController")
@SessionScoped
public class ArlController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ArlFacade ejbFacade;
    private List<Arl> items = null;
    private Arl selected;

    public ArlController() {
    }

    public Arl getSelected() {
        return selected;
    }

    public void setSelected(Arl selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ArlFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new Arl();
        initializeEmbeddableKey();
        return "AgregarArl";
    }
    
     public String prepareModificarArl() {
        return "ModificarArl";
    }

    public String prepareConsultarArl() {
        return "ConsultarArl";
    }

    public String prepareListArl() {
        return "/Configuracion/Arl/ListarArl";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ArlCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ArlUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ArlDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Arl> getItems() {
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

    public Arl getArl(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<Arl> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Arl> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Arl.class)
    public static class ArlControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ArlController controller = (ArlController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "arlController");
            return controller.getArl(getKey(value));
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
            if (object instanceof Arl) {
                Arl o = (Arl) object;
                return getStringKey(o.getIdArl());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Arl.class.getName()});
                return null;
            }
        }

    }

}
