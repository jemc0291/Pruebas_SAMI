package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Sexo;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.SexoFacade;

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

@Named("sexoController")
@SessionScoped
public class SexoController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.SexoFacade ejbFacade;
    private List<Sexo> items = null;
    private Sexo selected;

    public SexoController() {
    }

    public Sexo getSelected() {
        return selected;
    }

    public void setSelected(Sexo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SexoFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new Sexo();
        initializeEmbeddableKey();
        return "AgregarSexo";
    }

    public String prepareListSexo() {
        return "/Configuracion/Sexo/ListarSexo";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("SexoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("SexoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("SexoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Sexo> getItems() {
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

    public Sexo getSexo(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<Sexo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Sexo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Sexo.class)
    public static class SexoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SexoController controller = (SexoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sexoController");
            return controller.getSexo(getKey(value));
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
            if (object instanceof Sexo) {
                Sexo o = (Sexo) object;
                return getStringKey(o.getIdSexo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Sexo.class.getName()});
                return null;
            }
        }

    }

}
