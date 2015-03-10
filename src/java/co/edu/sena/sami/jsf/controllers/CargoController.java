/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Cargo;
import co.edu.sena.sami.jpa.sessions.CargoFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Adsim
 */
@Named(value = "cargoController")
@SessionScoped
public class CargoController implements Serializable {

     @EJB
    private co.edu.sena.sami.jpa.sessions.CargoFacade ejbFacade;
    private List<Cargo> items = null;
    private Cargo selected;
    @EJB
    private CargoFacade cargoFacade;
    /**
     * Creates a new instance of CargoController
     */
    public CargoController() {
    }
    
       public Cargo getSelected() {
        return selected;
    }

    public void setSelected(Cargo selected) {
        this.selected = selected;
    }

     protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CargoFacade getFacade() {
        return ejbFacade;
    }

    public CargoFacade getCargoFacade() {
        return cargoFacade;
    }

    public String prepareCreate() {
        selected = new Cargo();
        initializeEmbeddableKey();
        return "Agregar";
    }

    public String prepareModificarCargo() {
        return "ModificarCargo";
    }

    public String prepareConsultarCargo() {
        return "ConsultarCargo";
    }

    public String prepareListCargo() {
        return "/Configuracion/Cargo/ListarCargo";
    }

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("CargoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("CargoUpdated"));
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("CargoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Cargo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
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

    public Cargo getCargo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Cargo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cargo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

  

    @FacesConverter(forClass = Cargo.class, value="cargoConverter")
    public static class CargoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CargoController controller = (CargoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cargoController");
            return controller.getCargo(getKey(value));
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
            if (object instanceof Cargo) {
                Cargo o = (Cargo) object;
                return getStringKey(o.getIdCargo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cargo.class.getName()});
                return null;
            }
        }

    }
    
}
