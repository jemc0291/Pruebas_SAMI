package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Facturas;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.FacturasFacade;
import co.edu.sena.sami.jpa.sessions.UsuariosFacade;

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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;

@Named("facturasController")
@SessionScoped
public class FacturasController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.FacturasFacade ejbFacade;
    private List<Facturas> items = null;
    private Facturas selected;
    
    @EJB
    private co.edu.sena.sami.jpa.sessions.UsuariosFacade ejbFacadeUsuarios;
    
    private UsuariosFacade getFacadeUsuarios() {
        return ejbFacadeUsuarios;
    }
    
    public List<Usuarios> getItemsAvailableSelectManyUsuarios() {
        return getFacadeUsuarios().findAll();
    }

    public List<Usuarios> getItemsAvailableSelectOneUsuarios() {
        return getFacadeUsuarios().findAll();
    }
    
   
    public FacturasController() {
    }

    public Facturas getSelected() {
        return selected;
    }

    public void setSelected(Facturas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FacturasFacade getFacade() {
        return ejbFacade;
    }
    
    public String redirigir(){
        return "Create";
    }

    public String prepareCreate() {
        selected = new Facturas();
        initializeEmbeddableKey();
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/Facturas/Create.xhtml";
        
    }
    
    public String recargarLista(){
    return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/Facturas/Facturas.xhtml";
    }

    public String createDos(ActionEvent event) {
        try{
        selected.setIdUsuario((Usuarios) event.getComponent().getAttributes().get("usuario"));
            selected.setFecha(new Date());
            getFacade().create(selected);
            addSuccessMessage("Crear Cliente", "Factura Creada Exitosamente");
            items=null;
            return"Facturas";
            
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("FacturasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("FacturasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("FacturasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Facturas> getItems() {
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

    public Facturas getFacturas(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Facturas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Facturas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Facturas.class)
    public static class FacturasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FacturasController controller = (FacturasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "facturasController");
            return controller.getFacturas(getKey(value));
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
            if (object instanceof Facturas) {
                Facturas o = (Facturas) object;
                return getStringKey(o.getIdFactura());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Facturas.class.getName()});
                return null;
            }
        }

    }
    
    
    @FacesConverter(forClass = Usuarios.class, value = "usuariosConverter")
    public static class UsuariosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuariosController controller = (UsuariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuariosController");
            return controller.getUsuarios(getKey(value));
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
            if (object instanceof Usuarios) {
                Usuarios o = (Usuarios) object;
                return getStringKey(o.getIdUsuario());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuarios.class.getName()});
                return null;
            }
        }

    }

    
    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    } 

}
