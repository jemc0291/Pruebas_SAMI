package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.FondoDePensiones;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.FondoDePensionesFacade;

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

@Named("fondoDePensionesController")
@SessionScoped
public class FondoDePensionesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.FondoDePensionesFacade ejbFacade;
    private List<FondoDePensiones> items = null;
    private FondoDePensiones selected;

    public FondoDePensionesController() {
    }

    public FondoDePensiones getSelected() {
        return selected;
    }

    public void setSelected(FondoDePensiones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FondoDePensionesFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new FondoDePensiones();
        initializeEmbeddableKey();
        return "AgregarFondoPensiones";
    }
       public String prepareModificarFondoDePensiones() {
        return "ModificarFondoPensiones";
    }

    public String prepareConsultarFondoDePensiones() {
        return "ConsultarFondoPensiones";
    }

   public String prepareListFondoPensiones() {
        return "/Configuracion/Fondo de Pensiones/ListarFondoPensiones";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("FondoDePensionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("FondoDePensionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("FondoDePensionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FondoDePensiones> getItems() {
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

    public FondoDePensiones getFondoDePensiones(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<FondoDePensiones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FondoDePensiones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FondoDePensiones.class)
    public static class FondoDePensionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FondoDePensionesController controller = (FondoDePensionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fondoDePensionesController");
            return controller.getFondoDePensiones(getKey(value));
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
            if (object instanceof FondoDePensiones) {
                FondoDePensiones o = (FondoDePensiones) object;
                return getStringKey(o.getIdFondoPensiones());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FondoDePensiones.class.getName()});
                return null;
            }
        }

    }

}
