package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacen;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.UsuariosSolicitudMaterialesAlmacenFacade;

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

@Named("usuariosSolicitudMaterialesAlmacenController")
@SessionScoped
public class UsuariosSolicitudMaterialesAlmacenController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.UsuariosSolicitudMaterialesAlmacenFacade ejbFacade;
    private List<UsuariosSolicitudMaterialesAlmacen> items = null;
    private UsuariosSolicitudMaterialesAlmacen selected;

    public UsuariosSolicitudMaterialesAlmacenController() {
    }

    public UsuariosSolicitudMaterialesAlmacen getSelected() {
        return selected;
    }

    public void setSelected(UsuariosSolicitudMaterialesAlmacen selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getUsuariosSolicitudMaterialesAlmacenPK().setIdRol(selected.getRol().getIdRol());
        selected.getUsuariosSolicitudMaterialesAlmacenPK().setIdSolicitudMaterial(selected.getSolicitudMaterialesAlmacen().getIdSolicitudMaterial());
        selected.getUsuariosSolicitudMaterialesAlmacenPK().setIdUsuario(selected.getUsuarios().getIdUsuario());
    }

    protected void initializeEmbeddableKey() {
        selected.setUsuariosSolicitudMaterialesAlmacenPK(new co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK());
    }

    private UsuariosSolicitudMaterialesAlmacenFacade getFacade() {
        return ejbFacade;
    }

    public UsuariosSolicitudMaterialesAlmacen prepareCreate() {
        selected = new UsuariosSolicitudMaterialesAlmacen();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("UsuariosSolicitudMaterialesAlmacenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("UsuariosSolicitudMaterialesAlmacenUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("UsuariosSolicitudMaterialesAlmacenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<UsuariosSolicitudMaterialesAlmacen> getItems() {
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

    public UsuariosSolicitudMaterialesAlmacen getUsuariosSolicitudMaterialesAlmacen(co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK id) {
        return getFacade().find(id);
    }

    public List<UsuariosSolicitudMaterialesAlmacen> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<UsuariosSolicitudMaterialesAlmacen> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = UsuariosSolicitudMaterialesAlmacen.class)
    public static class UsuariosSolicitudMaterialesAlmacenControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuariosSolicitudMaterialesAlmacenController controller = (UsuariosSolicitudMaterialesAlmacenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuariosSolicitudMaterialesAlmacenController");
            return controller.getUsuariosSolicitudMaterialesAlmacen(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK();
            key.setIdUsuario(Integer.parseInt(values[0]));
            key.setIdSolicitudMaterial(Integer.parseInt(values[1]));
            key.setIdRol(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacenPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getIdSolicitudMaterial());
            sb.append(SEPARATOR);
            sb.append(value.getIdRol());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof UsuariosSolicitudMaterialesAlmacen) {
                UsuariosSolicitudMaterialesAlmacen o = (UsuariosSolicitudMaterialesAlmacen) object;
                return getStringKey(o.getUsuariosSolicitudMaterialesAlmacenPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), UsuariosSolicitudMaterialesAlmacen.class.getName()});
                return null;
            }
        }

    }

}
