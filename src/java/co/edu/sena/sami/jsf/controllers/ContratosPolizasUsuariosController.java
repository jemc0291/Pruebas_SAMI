package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.ContratosPolizasUsuarios;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ContratosPolizasUsuariosFacade;

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

@Named("contratosPolizasUsuariosController")
@SessionScoped
public class ContratosPolizasUsuariosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ContratosPolizasUsuariosFacade ejbFacade;
    private List<ContratosPolizasUsuarios> items = null;
    private ContratosPolizasUsuarios selected;

    public ContratosPolizasUsuariosController() {
    }

    public ContratosPolizasUsuarios getSelected() {
        return selected;
    }

    public void setSelected(ContratosPolizasUsuarios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getContratosPolizasUsuariosPK().setIdContrato(selected.getContratos().getIdContrato());
        selected.getContratosPolizasUsuariosPK().setNumeroDePoliza(selected.getPolizas().getNumeroDePoliza());
        selected.getContratosPolizasUsuariosPK().setIdUsuario(selected.getUsuarios().getIdUsuario());
    }

    protected void initializeEmbeddableKey() {
        selected.setContratosPolizasUsuariosPK(new co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK());
    }

    private ContratosPolizasUsuariosFacade getFacade() {
        return ejbFacade;
    }

    public ContratosPolizasUsuarios prepareCreate() {
        selected = new ContratosPolizasUsuarios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosPolizasUsuariosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosPolizasUsuariosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosPolizasUsuariosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ContratosPolizasUsuarios> getItems() {
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

    public ContratosPolizasUsuarios getContratosPolizasUsuarios(co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK id) {
        return getFacade().find(id);
    }

    public List<ContratosPolizasUsuarios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ContratosPolizasUsuarios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ContratosPolizasUsuarios.class)
    public static class ContratosPolizasUsuariosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ContratosPolizasUsuariosController controller = (ContratosPolizasUsuariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "contratosPolizasUsuariosController");
            return controller.getContratosPolizasUsuarios(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK();
            key.setIdContrato(Integer.parseInt(values[0]));
            key.setNumeroDePoliza(Integer.parseInt(values[1]));
            key.setIdUsuario(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.ContratosPolizasUsuariosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdContrato());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroDePoliza());
            sb.append(SEPARATOR);
            sb.append(value.getIdUsuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ContratosPolizasUsuarios) {
                ContratosPolizasUsuarios o = (ContratosPolizasUsuarios) object;
                return getStringKey(o.getContratosPolizasUsuariosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ContratosPolizasUsuarios.class.getName()});
                return null;
            }
        }

    }

}
