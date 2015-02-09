package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacen;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenFacade;

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

@Named("solicitudMaterialesAlmacenController")
@SessionScoped
public class SolicitudMaterialesAlmacenController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenFacade ejbFacade;
    private List<SolicitudMaterialesAlmacen> items = null;
    private SolicitudMaterialesAlmacen selected;

    public SolicitudMaterialesAlmacenController() {
    }

    public SolicitudMaterialesAlmacen getSelected() {
        return selected;
    }

    public void setSelected(SolicitudMaterialesAlmacen selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SolicitudMaterialesAlmacenFacade getFacade() {
        return ejbFacade;
    }

    public SolicitudMaterialesAlmacen prepareCreate() {
        selected = new SolicitudMaterialesAlmacen();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SolicitudMaterialesAlmacen> getItems() {
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

    public SolicitudMaterialesAlmacen getSolicitudMaterialesAlmacen(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SolicitudMaterialesAlmacen> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SolicitudMaterialesAlmacen> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SolicitudMaterialesAlmacen.class)
    public static class SolicitudMaterialesAlmacenControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SolicitudMaterialesAlmacenController controller = (SolicitudMaterialesAlmacenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "solicitudMaterialesAlmacenController");
            return controller.getSolicitudMaterialesAlmacen(getKey(value));
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
            if (object instanceof SolicitudMaterialesAlmacen) {
                SolicitudMaterialesAlmacen o = (SolicitudMaterialesAlmacen) object;
                return getStringKey(o.getIdSolicitudMaterial());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SolicitudMaterialesAlmacen.class.getName()});
                return null;
            }
        }

    }

}
