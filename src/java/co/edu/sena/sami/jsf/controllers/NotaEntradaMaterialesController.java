package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.NotaEntradaMateriales;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.NotaEntradaMaterialesFacade;

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

@Named("notaEntradaMaterialesController")
@SessionScoped
public class NotaEntradaMaterialesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.NotaEntradaMaterialesFacade ejbFacade;
    private List<NotaEntradaMateriales> items = null;
    private NotaEntradaMateriales selected;

    public NotaEntradaMaterialesController() {
    }

    public NotaEntradaMateriales getSelected() {
        return selected;
    }

    public void setSelected(NotaEntradaMateriales selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getNotaEntradaMaterialesPK().setIdMaterial(selected.getMateriales().getIdMateriales());
        selected.getNotaEntradaMaterialesPK().setIdNota(selected.getNotaEntrada().getIdNota());
    }

    protected void initializeEmbeddableKey() {
        selected.setNotaEntradaMaterialesPK(new co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK());
    }

    private NotaEntradaMaterialesFacade getFacade() {
        return ejbFacade;
    }

    public NotaEntradaMateriales prepareCreate() {
        selected = new NotaEntradaMateriales();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("NotaEntradaMaterialesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("NotaEntradaMaterialesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("NotaEntradaMaterialesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<NotaEntradaMateriales> getItems() {
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

    public NotaEntradaMateriales getNotaEntradaMateriales(co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK id) {
        return getFacade().find(id);
    }

    public List<NotaEntradaMateriales> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NotaEntradaMateriales> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NotaEntradaMateriales.class)
    public static class NotaEntradaMaterialesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NotaEntradaMaterialesController controller = (NotaEntradaMaterialesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "notaEntradaMaterialesController");
            return controller.getNotaEntradaMateriales(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK();
            key.setIdNota(Integer.parseInt(values[0]));
            key.setIdMaterial(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.NotaEntradaMaterialesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdNota());
            sb.append(SEPARATOR);
            sb.append(value.getIdMaterial());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NotaEntradaMateriales) {
                NotaEntradaMateriales o = (NotaEntradaMateriales) object;
                return getStringKey(o.getNotaEntradaMaterialesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NotaEntradaMateriales.class.getName()});
                return null;
            }
        }

    }

}
