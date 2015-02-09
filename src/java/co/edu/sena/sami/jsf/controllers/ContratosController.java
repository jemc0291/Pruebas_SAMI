package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ContratosFacade;

import java.io.Serializable;
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
import javax.faces.validator.ValidatorException;

@Named("contratosController")
@SessionScoped
public class ContratosController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ContratosFacade ejbFacade;
    private List<Contratos> items = null;
    private Contratos selected;

    public ContratosController() {
    }

    public Contratos getSelected() {
        return selected;
    }

    public void setSelected(Contratos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ContratosFacade getFacade() {
        return ejbFacade;
    }

     
    public String prepareCreate() {
        selected = new Contratos();
        //initializeEmbeddableKey();
        return "/Modulo3/GestionContractual/CrearContrato";
    }
    
    public String prepareEdit(){
        return "/Modulo3/GestionContractual/EditarContrato";
    }
    
    public String prepareView(){
        return "VerContrato";
    }
    
//    public String create(){
//        try{
//            getFacade().create(selected);
//            return "/contratos/List";
//        }catch (Exception e) {
//            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
//            return null;
//        }
//    }
    public String create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "ListaContratos";
//return "/index";
    }

    public String update() {
        try{
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosUpdated"));
        return "ListaContratos";
        }catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "ListaContratos";
    }

    public List<Contratos> getItems() {
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

    public Contratos getContratos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Contratos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Contratos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Contratos.class)
    public static class ContratosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ContratosController controller = (ContratosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "contratosController");
            return controller.getContratos(getKey(value));
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
            if (object instanceof Contratos) {
                Contratos o = (Contratos) object;
                return getStringKey(o.getIdContrato());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Contratos.class.getName()});
                return null;
            }
        }

    }
    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    
    public void validarContrato(FacesContext contex, UIComponent component, Object value)
            throws ValidatorException {
        if (getFacade().findByNumeroDeContrato((int) value) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrato ya existente", "El contrato ya existe en la base de datos !!!!"));
        } else {
            selected.setNumeroDeContrato((int) value);
        }

    }
}
