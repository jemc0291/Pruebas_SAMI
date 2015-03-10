/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jsf.controllers;


import co.edu.sena.sami.jpa.entities.TipoContrato;
import co.edu.sena.sami.jpa.sessions.TipoContratoFacade;
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

/**
 *
 * @author Adsim
 */
@Named(value = "tipoContratoController")
@SessionScoped
public class TipoContratoController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.TipoContratoFacade ejbFacade;
    private List<TipoContrato> items = null;
    private TipoContrato selected;
    @EJB
    private TipoContratoFacade tipoContratoFacade;
    /**
     * Creates a new instance of TipoContratoControlller
     */
    public TipoContratoController() {
    }
    
      public TipoContrato getSelected() {
        return selected;
    }

    public void setSelected(TipoContrato selected) {
        this.selected = selected;
    }

     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoContratoFacade getFacade() {
        return ejbFacade;
    }

    public TipoContratoFacade getTipoContratoFacade() {
        return tipoContratoFacade;
    }

    public String prepareCreate() {
        selected = new TipoContrato();
        initializeEmbeddableKey();
        return "TipoContratoFormacion";
    }

    public String prepareModificarTipoContrato() {
        return "ModificarTipoContrato";
    }

    public String prepareConsultarTipoContrato() {
        return "ConsultarTipoContrato";
    }

    public String prepareListTipoContrato() {
        return "/Configuracion/TipoContrato/ListarTipoContrato";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoContratoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoContratoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoContratoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TipoContrato> getItems() {
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

    public TipoContrato getTipoContrato(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<TipoContrato> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TipoContrato> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }


@FacesConverter(forClass = TipoContrato.class)
    public static class TipoContratoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoContratoController controller = (TipoContratoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoContratoController");
            return controller.getTipoContrato(getKey(value));
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
            if (object instanceof TipoContrato) {
                TipoContrato o = (TipoContrato) object;
                return getStringKey(o.getIdTipoContrato());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoContratoController.class.getName()});
                return null;
            }
        }
    }
}

