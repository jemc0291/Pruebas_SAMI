package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.ActaVerificacion;
import co.edu.sena.sami.jpa.entities.Facturas;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ActaVerificacionFacade;

import java.io.Serializable;
import java.util.Date;
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
import javax.faces.event.ActionEvent;

@Named("actaVerificacionController")
@SessionScoped
public class ActaVerificacionController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ActaVerificacionFacade ejbFacade;
    private List<ActaVerificacion> items = null;
    private ActaVerificacion selected;

    @EJB
    private co.edu.sena.sami.jpa.sessions.UsuariosFacade ejbFacadeUsuarios;
    private List<Usuarios> itemsUsuarios = null;
    private Usuarios selectedUsuarios;
    
    @EJB
    private co.edu.sena.sami.jpa.sessions.FacturasFacade ejbFacadeFacturas;
    private List<Facturas> itemsFacturas = null;
    private Facturas selectedFacturas;

    
    /**
     * @return the ejbFacadeUsuarios
     */
    public co.edu.sena.sami.jpa.sessions.UsuariosFacade getFacadeUsuarios() {
        return ejbFacadeUsuarios;
    }

    /**
     * @return the ejbFacadeFacturas
     */
    public co.edu.sena.sami.jpa.sessions.FacturasFacade getFacadeFacturas() {
        return ejbFacadeFacturas;
    }
    
    
     public Usuarios getUsuarios(java.lang.Integer id) {
        return getFacadeUsuarios().find(id);
    }

    public List<Usuarios> getItemsAvailableSelectManyUsuarios() {
        return getFacadeUsuarios().findAll();
    }

    public List<Usuarios> getItemsAvailableSelectOneUsuarios() {
        return getFacadeUsuarios().findAll();
    }
    
    
    public Facturas getFacturas(java.lang.Integer id) {
        return getFacadeFacturas().find(id);
    }

    public List<Facturas> getItemsAvailableSelectManyFacturas() {
        return getFacadeFacturas().findAll();
    }

    public List<Facturas> getItemsAvailableSelectOneFacturas() {
        return getFacadeFacturas().findAll();
    }
    
    public ActaVerificacionController() {
    }

    public ActaVerificacion getSelected() {
        return selected;
    }

    public void setSelected(ActaVerificacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ActaVerificacionFacade getFacade() {
        return ejbFacade;
    }

    public String recargarLista(){
    return "Actas";
    }
    
    public String prepareCreate() {
        selected = new ActaVerificacion();
        initializeEmbeddableKey();
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/ActasVerificacion/Create.xhtml";
    }
    
    public String prepareEdit() {
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/ActasVerificacion/Edit.xhtml";
    }

    public String prepareView() {
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/ActasVerificacion/View.xhtml";
    }
    
    public void create(ActionEvent event) {
        selected.setIdUsuario((Usuarios) event.getComponent().getAttributes().get("usuario"));
        selected.setHora(new Date());
        selected.setFecha(new Date());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ActaVerificacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public String update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ActaVerificacionUpdated"));
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/ActasVerificacion/View.xhtml";
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ActaVerificacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ActaVerificacion> getItems() {
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

    public ActaVerificacion getActaVerificacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ActaVerificacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ActaVerificacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }


    @FacesConverter(forClass = ActaVerificacion.class)
    public static class ActaVerificacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActaVerificacionController controller = (ActaVerificacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actaVerificacionController");
            return controller.getActaVerificacion(getKey(value));
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
            if (object instanceof ActaVerificacion) {
                ActaVerificacion o = (ActaVerificacion) object;
                return getStringKey(o.getIdActaVerificacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ActaVerificacion.class.getName()});
                return null;
            }
        }

    }

}
