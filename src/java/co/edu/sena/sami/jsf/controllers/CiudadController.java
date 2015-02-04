package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Ciudad;
import co.edu.sena.sami.jpa.sessions.CiudadFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import static javax.management.Query.value;
import static javax.management.Query.value;

@Named("ciudadController")
@SessionScoped
public class CiudadController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.CiudadFacade ejbFacade;
    private List<Ciudad> items = null;
    private Ciudad selected;

    public CiudadController() {
    }

    public Ciudad getSelected() {
        return selected;
    }

    public void setSelected(Ciudad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCiudadPK().setIdDpto(selected.getDepartamentos().getIdDpto());
    }

    protected void initializeEmbeddableKey() {
        selected.setCiudadPK(new co.edu.sena.sami.jpa.entities.CiudadPK());
    }

    private CiudadFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new Ciudad();
        initializeEmbeddableKey();
        return "AgregarCiudad";
    }
    
    public String prepareModificarCiudad () {
        return "ModificarCiudad";
    }

    public String prepareConsultarCiudad () {
        return "ConsultarCiudad";
    }

    public String prepareListCiudad () {
        return "/Configuracion/Ciudad/ListarCiudad";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("CiudadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("CiudadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("CiudadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ciudad> getItems() {
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

    public Ciudad getCiudad(co.edu.sena.sami.jpa.entities.CiudadPK id) {
        return getFacade().find(id);
    }

    public List<Ciudad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ciudad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ciudad.class, value="ciudadConverter")
    public static class CiudadControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CiudadController controller = (CiudadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ciudadController");
            return controller.getCiudad(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.CiudadPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.CiudadPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.CiudadPK();
            key.setIdCiudad(Integer.parseInt(values[0]));
            key.setIdDpto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.CiudadPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCiudad());
            sb.append(SEPARATOR);
            sb.append(value.getIdDpto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ciudad) {
                Ciudad o = (Ciudad) object;
                return getStringKey(o.getCiudadPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ciudad.class.getName()});
                return null;
            }
        }

    }

}
