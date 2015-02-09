package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Departamentos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.DepartamentosFacade;

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

@Named("departamentosController")
@SessionScoped
public class DepartamentosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.DepartamentosFacade ejbFacade;
    private List<Departamentos> items = null;
    private Departamentos selected;

    public DepartamentosController() {
    }

    public Departamentos getSelected() {
        return selected;
    }

    public void setSelected(Departamentos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DepartamentosFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new Departamentos();
        initializeEmbeddableKey();
        return "AgregarDepartamentos";
    }
    
    public String prepareModificarDepartamentos() {
        return "ModificarDepartamentos";
    }

    public String prepareConsultarDepartamentos() {
        return "ConsultarDepartamentos";
    }

    public String prepareListDepartamentos() {
        return "/Configuracion/Departamentos/ListarDepartamentos";
    }
    

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("DepartamentosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("DepartamentosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("DepartamentosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Departamentos> getItems() {
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

    public Departamentos getDepartamentos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Departamentos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Departamentos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Departamentos.class)
    public static class DepartamentosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DepartamentosController controller = (DepartamentosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "departamentosController");
            return controller.getDepartamentos(getKey(value));
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
            if (object instanceof Departamentos) {
                Departamentos o = (Departamentos) object;
                return getStringKey(o.getIdDpto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Departamentos.class.getName()});
                return null;
            }
        }

    }

}
