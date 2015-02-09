package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.OrdenesDeViajeConceptosDeGastosFacade;

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

@Named("ordenesDeViajeConceptosDeGastosController")
@SessionScoped
public class OrdenesDeViajeConceptosDeGastosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.OrdenesDeViajeConceptosDeGastosFacade ejbFacade;
    private List<OrdenesDeViajeConceptosDeGastos> items = null;
    private OrdenesDeViajeConceptosDeGastos selected;

    public OrdenesDeViajeConceptosDeGastosController() {
    }

    public OrdenesDeViajeConceptosDeGastos getSelected() {
        return selected;
    }

    public void setSelected(OrdenesDeViajeConceptosDeGastos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getOrdenesDeViajeConceptosDeGastosPK().setNumeroOrdendeviaje(selected.getOrdenesDeviaje().getNumeroOrdendeviaje());
        selected.getOrdenesDeViajeConceptosDeGastosPK().setCodigoGasto(selected.getConceptosDeGastos().getCodigoGasto());
    }

    protected void initializeEmbeddableKey() {
        selected.setOrdenesDeViajeConceptosDeGastosPK(new co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK());
    }

    private OrdenesDeViajeConceptosDeGastosFacade getFacade() {
        return ejbFacade;
    }

    public OrdenesDeViajeConceptosDeGastos prepareCreate() {
        selected = new OrdenesDeViajeConceptosDeGastos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("OrdenesDeViajeConceptosDeGastosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("OrdenesDeViajeConceptosDeGastosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("OrdenesDeViajeConceptosDeGastosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OrdenesDeViajeConceptosDeGastos> getItems() {
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

    public OrdenesDeViajeConceptosDeGastos getOrdenesDeViajeConceptosDeGastos(co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK id) {
        return getFacade().find(id);
    }

    public List<OrdenesDeViajeConceptosDeGastos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OrdenesDeViajeConceptosDeGastos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OrdenesDeViajeConceptosDeGastos.class)
    public static class OrdenesDeViajeConceptosDeGastosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdenesDeViajeConceptosDeGastosController controller = (OrdenesDeViajeConceptosDeGastosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenesDeViajeConceptosDeGastosController");
            return controller.getOrdenesDeViajeConceptosDeGastos(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK();
            key.setNumeroOrdendeviaje(Integer.parseInt(values[0]));
            key.setCodigoGasto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.OrdenesDeViajeConceptosDeGastosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumeroOrdendeviaje());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoGasto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OrdenesDeViajeConceptosDeGastos) {
                OrdenesDeViajeConceptosDeGastos o = (OrdenesDeViajeConceptosDeGastos) object;
                return getStringKey(o.getOrdenesDeViajeConceptosDeGastosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OrdenesDeViajeConceptosDeGastos.class.getName()});
                return null;
            }
        }

    }

}
