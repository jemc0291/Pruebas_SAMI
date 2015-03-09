package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jpa.entities.Informes;
import co.edu.sena.sami.jpa.sessions.ContratosFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.InformesFacade;

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
import javax.faces.event.ActionEvent;

@Named("informesController")
@SessionScoped
public class InformesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.InformesFacade ejbFacade;
    private List<Informes> items = null;
    private Informes selected;
    @EJB
    private co.edu.sena.sami.jpa.sessions.ContratosFacade contratosFacade;

    public InformesController() {
    }
    public ContratosFacade getContratosFacade() {
        return contratosFacade;
    }

    public void setContratosFacade(ContratosFacade contratosFacade) {
        this.contratosFacade = contratosFacade;
    }

    public Informes getSelected() {
        return selected;
    }

    public void setSelected(Informes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InformesFacade getFacade() {
        return ejbFacade;
    }

   public String prepareCreate() {
        selected = new Informes();
        return "/modulo3/GestionContractual/CreateInforme";
    }

    public String prepareEdit() {
        return "/modulo3/GestionContractual/EditInforme";
    }

    public String prepareView() {
        return "/modulo3/GestionContractual/viewInforme";
    }

    public String prepareList() {
        recargarLista();
        return "/modulo3/GestionContractual/ListInformes";
    }
    public String prepareBuzon() {
        return "/modulo3/GestionContractual/Buzon";
    }

    public void recargarLista() {
        items = null;
    }

    public String create(ActionEvent event) {
        //persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("InformesCreated"));
        try {
            Contratos c = (Contratos) event.getComponent().getAttributes().get("contrato");
            selected.setIdContrato(c);
            getFacade().create(selected);
            c.getInformesList().add(selected);
            getContratosFacade().edit(c);
            selected = null;
            recargarLista();
            addSuccesMessage("Crear Informe", "Informe Creado Exitosamente.");
            return "ListInformes";
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return "ListInformes";
        }
        //if (!JsfUtil.isValidationFailed()) {
          //  items = null;    // Invalidate list of items to trigger re-query.
        //}
    }

    public String update() {
        try{
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("InformesUpdated"));
        return "ListInformes";
        }catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("InformesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Informes> getItems() {
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
                    Contratos c = selected.getIdContrato();
                    c.getInformesList().remove(selected);
                    getContratosFacade().edit(c);
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

    public Informes getInformes(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Informes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Informes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Informes.class)
    public static class InformesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InformesController controller = (InformesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "informesController");
            return controller.getInformes(getKey(value));
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
            if (object instanceof Informes) {
                Informes o = (Informes) object;
                return getStringKey(o.getIdInformes());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Informes.class.getName()});
                return null;
            }
        }

    }
    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    private void addSuccesMessage(String title, String msg ){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

}
