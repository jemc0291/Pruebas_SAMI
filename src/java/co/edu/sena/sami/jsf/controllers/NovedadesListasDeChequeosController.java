package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.NovedadesListasDeChequeosFacade;

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

@Named("novedadesListasDeChequeosController")
@SessionScoped
public class NovedadesListasDeChequeosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.NovedadesListasDeChequeosFacade ejbFacade;
    private List<NovedadesListasDeChequeos> items = null;
    private NovedadesListasDeChequeos selected;

    public NovedadesListasDeChequeosController() {
    }

    public NovedadesListasDeChequeos getSelected() {
        return selected;
    }

    public void setSelected(NovedadesListasDeChequeos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getNovedadesListasDeChequeosPK().setIdListaDeChequeo(selected.getListasDeChequeos().getIdListaDeChekeo());
        selected.getNovedadesListasDeChequeosPK().setIdNovedad(selected.getNovedades().getIdNovedad());
    }

    protected void initializeEmbeddableKey() {
        selected.setNovedadesListasDeChequeosPK(new co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK());
    }

    private NovedadesListasDeChequeosFacade getFacade() {
        return ejbFacade;
    }

    public NovedadesListasDeChequeos prepareCreate() {
        selected = new NovedadesListasDeChequeos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("NovedadesListasDeChequeosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("NovedadesListasDeChequeosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("NovedadesListasDeChequeosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<NovedadesListasDeChequeos> getItems() {
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

    public NovedadesListasDeChequeos getNovedadesListasDeChequeos(co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK id) {
        return getFacade().find(id);
    }

    public List<NovedadesListasDeChequeos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NovedadesListasDeChequeos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NovedadesListasDeChequeos.class)
    public static class NovedadesListasDeChequeosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NovedadesListasDeChequeosController controller = (NovedadesListasDeChequeosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "novedadesListasDeChequeosController");
            return controller.getNovedadesListasDeChequeos(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK();
            key.setIdNovedad(Integer.parseInt(values[0]));
            key.setIdListaDeChequeo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.NovedadesListasDeChequeosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdNovedad());
            sb.append(SEPARATOR);
            sb.append(value.getIdListaDeChequeo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NovedadesListasDeChequeos) {
                NovedadesListasDeChequeos o = (NovedadesListasDeChequeos) object;
                return getStringKey(o.getNovedadesListasDeChequeosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NovedadesListasDeChequeos.class.getName()});
                return null;
            }
        }

    }

}
