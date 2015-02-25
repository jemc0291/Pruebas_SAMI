package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Ciudad;
import co.edu.sena.sami.jpa.entities.CiudadComisiones;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.CiudadComisionesFacade;

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

@Named("ciudadComisionesController")
@SessionScoped
public class CiudadComisionesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.CiudadComisionesFacade ejbFacade;
    private List<CiudadComisiones> items = null;
    private CiudadComisiones selected;

     @EJB
    private co.edu.sena.sami.jpa.sessions.CiudadFacade ejbFacadeCiudad;
    private List<Ciudad> itemsCiudad = null;
    private Ciudad selectedCiudad;
    
    
 
    
    public Ciudad getCiudad(co.edu.sena.sami.jpa.entities.CiudadPK id) {
        return getFacadeCiudad().find(id);
    }

    public List<Ciudad> getItemsAvailableSelectManyCiudad() {
        return getFacadeCiudad().findAll();
    }

    public List<Ciudad> getItemsAvailableSelectOneCiudad() {
        return getFacadeCiudad().findAll();
    }
    
    
    public CiudadComisionesController() {
    }

    public CiudadComisiones getSelected() {
        return selected;
    }
    
    

    public void setSelected(CiudadComisiones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCiudadComisionesPK().setIdCiudad(selected.getCiudad().getCiudadPK().getIdCiudad());
        selected.getCiudadComisionesPK().setIdComision(selected.getComisiones().getIdComision());
        selected.getCiudadComisionesPK().setIdDpto(selected.getCiudad().getCiudadPK().getIdDpto());
    }

    protected void initializeEmbeddableKey() {
        selected.setCiudadComisionesPK(new co.edu.sena.sami.jpa.entities.CiudadComisionesPK());
    }

    private CiudadComisionesFacade getFacade() {
        return getEjbFacade();
    }

    public CiudadComisiones prepareCreate() {
        selected = new CiudadComisiones();
        initializeEmbeddableKey();
        return selected;
    }

    public String create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("CiudadComisionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "/modulo4/Gestion_Talento_Humano/Comisiones/CrearComision.xhtml";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("CiudadComisionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("CiudadComisionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CiudadComisiones> getItems() {
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

    public CiudadComisiones getCiudadComisiones(co.edu.sena.sami.jpa.entities.CiudadComisionesPK id) {
        return getFacade().find(id);
    }

    public List<CiudadComisiones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CiudadComisiones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the ejbFacade
     */
    public co.edu.sena.sami.jpa.sessions.CiudadComisionesFacade getEjbFacade() {
        return ejbFacade;
    }

    /**
     * @return the ejbFacadeCiudad
     */
    public co.edu.sena.sami.jpa.sessions.CiudadFacade getFacadeCiudad() {
        return ejbFacadeCiudad;
    }

    /**
     * @param ejbFacadeCiudad the ejbFacadeCiudad to set
     */
    public void setEjbFacadeCiudad(co.edu.sena.sami.jpa.sessions.CiudadFacade ejbFacadeCiudad) {
        this.ejbFacadeCiudad = ejbFacadeCiudad;
    }

    @FacesConverter(forClass = CiudadComisiones.class)
    public static class CiudadComisionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CiudadComisionesController controller = (CiudadComisionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ciudadComisionesController");
            return controller.getCiudadComisiones(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.CiudadComisionesPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.CiudadComisionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.CiudadComisionesPK();
            key.setIdCiudad(Integer.parseInt(values[0]));
            key.setIdComision(Integer.parseInt(values[1]));
            key.setIdDpto(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.CiudadComisionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCiudad());
            sb.append(SEPARATOR);
            sb.append(value.getIdComision());
            sb.append(SEPARATOR);
            sb.append(value.getIdDpto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CiudadComisiones) {
                CiudadComisiones o = (CiudadComisiones) object;
                return getStringKey(o.getCiudadComisionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CiudadComisiones.class.getName()});
                return null;
            }
        }

    }

}
