package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Materiales;
import co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMateriales;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenMaterialesFacade;

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
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@Named("solicitudMaterialesAlmacenMaterialesController")
@SessionScoped
public class SolicitudMaterialesAlmacenMaterialesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenMaterialesFacade ejbFacadeSolicitudMateriales;
    private List<SolicitudMaterialesAlmacenMateriales> items = null;
    private SolicitudMaterialesAlmacenMateriales selected;

    @EJB
    private co.edu.sena.sami.jpa.sessions.MaterialesFacade ejbFacadeMateriales;
    
    public co.edu.sena.sami.jpa.sessions.MaterialesFacade getFacadeMateriales() {
        return ejbFacadeMateriales;
    }
    
    public Materiales getMateriales(java.lang.Integer id) {
        return getFacadeMateriales().find(id);
    }

    public List<Materiales> getItemsAvailableSelectManyMateriales() {
        return getFacadeMateriales().findAll();
    }

    public List<Materiales> getItemsAvailableSelectOneMateriales() {
        return getFacadeMateriales().findAll();
    }

        
    public SolicitudMaterialesAlmacenMaterialesController() {
    }

    public SolicitudMaterialesAlmacenMateriales getSelected() {
        return selected;
    }

    public void setSelected(SolicitudMaterialesAlmacenMateriales selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSolicitudMaterialesAlmacenMaterialesPK().setIdMateriales(selected.getMateriales().getIdMateriales());
        selected.getSolicitudMaterialesAlmacenMaterialesPK().setIdSolicitudMaterial(selected.getSolicitudMaterialesAlmacen().getIdSolicitudMaterial());
    }

    protected void initializeEmbeddableKey() {
        selected.setSolicitudMaterialesAlmacenMaterialesPK(new co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK());
    }

    private SolicitudMaterialesAlmacenMaterialesFacade getFacade() {
        return ejbFacadeSolicitudMateriales;
    }

    public SolicitudMaterialesAlmacenMateriales prepareCreate() {
        selected = new SolicitudMaterialesAlmacenMateriales();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenMaterialesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenMaterialesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenMaterialesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SolicitudMaterialesAlmacenMateriales> getItems() {
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

    public SolicitudMaterialesAlmacenMateriales getSolicitudMaterialesAlmacenMateriales(co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK id) {
        return getFacade().find(id);
    }

    public List<SolicitudMaterialesAlmacenMateriales> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SolicitudMaterialesAlmacenMateriales> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SolicitudMaterialesAlmacenMateriales.class)
    public static class SolicitudMaterialesAlmacenMaterialesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SolicitudMaterialesAlmacenMaterialesController controller = (SolicitudMaterialesAlmacenMaterialesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "solicitudMaterialesAlmacenMaterialesController");
            return controller.getSolicitudMaterialesAlmacenMateriales(getKey(value));
        }

        co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK getKey(String value) {
            co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK();
            key.setIdSolicitudMaterial(Integer.parseInt(values[0]));
            key.setIdMateriales(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdSolicitudMaterial());
            sb.append(SEPARATOR);
            sb.append(value.getIdMateriales());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SolicitudMaterialesAlmacenMateriales) {
                SolicitudMaterialesAlmacenMateriales o = (SolicitudMaterialesAlmacenMateriales) object;
                return getStringKey(o.getSolicitudMaterialesAlmacenMaterialesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SolicitudMaterialesAlmacenMateriales.class.getName()});
                return null;
            }
        }

    }

     public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
     public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cantidad Editada", ((SolicitudMaterialesAlmacenMateriales) event.getObject()).getCantidad());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((SolicitudMaterialesAlmacenMateriales) event.getObject()).getCantidad());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
