package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.UsuariosContratos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.UsuariosContratosFacade;

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

@Named("usuariosContratosController")
@SessionScoped
public class UsuariosContratosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.UsuariosContratosFacade ejbFacade;
    private List<UsuariosContratos> items = null;
    private UsuariosContratos selected;

    public UsuariosContratosController() {
    }

    public UsuariosContratos getSelected() {
        return selected;
    }

    public void setSelected(UsuariosContratos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getUsuariosContratosPK().setIdUsuario(selected.getUsuarios().getIdUsuario());
        selected.getUsuariosContratosPK().setIdContrato(selected.getContratos().getIdContrato());
        selected.getUsuariosContratosPK().setIdRol(selected.getRol().getIdRol());
    }

    protected void initializeEmbeddableKey() {
        selected.setUsuariosContratosPK(new co.edu.sena.sami.jpa.entities.UsuariosContratosPK());
    }

    private UsuariosContratosFacade getFacade() {
        return ejbFacade;
    }

    public UsuariosContratos prepareCreate() {
        selected = new UsuariosContratos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("UsuariosContratosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("UsuariosContratosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("UsuariosContratosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<UsuariosContratos> getItems() {
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

    public UsuariosContratos getUsuariosContratos(co.edu.sena.sami.jpa.entities.UsuariosContratosPK id) {
        return getFacade().find(id);
    }

    public List<UsuariosContratos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<UsuariosContratos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = UsuariosContratos.class)
    public static class UsuariosContratosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuariosContratosController controller = (UsuariosContratosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuariosContratosController");
            return controller.getUsuariosContratos(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.UsuariosContratosPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.UsuariosContratosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.UsuariosContratosPK();
            key.setIdContrato(Integer.parseInt(values[0]));
            key.setIdUsuario(Integer.parseInt(values[1]));
            key.setIdRol(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.UsuariosContratosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdContrato());
            sb.append(SEPARATOR);
            sb.append(value.getIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getIdRol());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof UsuariosContratos) {
                UsuariosContratos o = (UsuariosContratos) object;
                return getStringKey(o.getUsuariosContratosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), UsuariosContratos.class.getName()});
                return null;
            }
        }

    }

}
