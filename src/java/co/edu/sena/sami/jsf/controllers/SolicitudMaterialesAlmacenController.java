package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Areas;
import co.edu.sena.sami.jpa.entities.FichaCaracterizacion;
import co.edu.sena.sami.jpa.entities.Materiales;
import co.edu.sena.sami.jpa.entities.Rol;
import co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacen;
import co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMateriales;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jpa.entities.UsuariosSolicitudMaterialesAlmacen;
import co.edu.sena.sami.jpa.sessions.AreasFacade;
import co.edu.sena.sami.jpa.sessions.FichaCaracterizacionFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenFacade;
import co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenMaterialesFacade;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.primefaces.event.CellEditEvent;

@Named("solicitudMaterialesAlmacenController")
@SessionScoped
public class SolicitudMaterialesAlmacenController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenFacade ejbFacade;
    private List<SolicitudMaterialesAlmacen> items = null;
    private SolicitudMaterialesAlmacen selected;

    @EJB
    private co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenMaterialesFacade ejbSolMaterial;
    private List<SolicitudMaterialesAlmacenMateriales> itemsSolMaterial = null;
    private SolicitudMaterialesAlmacenMateriales selectedSolMaterial;

    @EJB
    private co.edu.sena.sami.jpa.sessions.SolicitudMaterialesAlmacenMaterialesFacade ejbFacadeSolicitudMateriales;
    
    @EJB
    private co.edu.sena.sami.jpa.sessions.AreasFacade areaFacade;

    @EJB
    private co.edu.sena.sami.jpa.sessions.FichaCaracterizacionFacade fichaFacade;

    @EJB
    private co.edu.sena.sami.jpa.sessions.MaterialesFacade ejbFacadeMateriales;
    
    private FichaCaracterizacionFacade getFichaFacade() {
        return fichaFacade;
    }
    
    public FichaCaracterizacion getFichaCaracterizacion(java.lang.Integer id) {
        return getFichaFacade().find(id);
    }

    public List<FichaCaracterizacion> getFichasAvailableSelectMany() {
        return getFichaFacade().findAll();
    }

    public List<FichaCaracterizacion> getFichasAvailableSelectOne() {
        return getFichaFacade().findAll();
    }

    private AreasFacade getAreaFacade() {
        return areaFacade;
    }

    private SolicitudMaterialesAlmacenMaterialesFacade getSolicitudMaterialesFacade() {
        return ejbFacadeSolicitudMateriales;
    }

    public Areas getAreas(java.lang.Integer id) {
        return getAreaFacade().find(id);
    }

    public List<Areas> getAreasAvailableSelectMany() {
        return getAreaFacade().findAll();
    }

    public List<Areas> getAreasAvailableSelectOne() {
        return getAreaFacade().findAll();
    }

    public List<SolicitudMaterialesAlmacenMateriales> getItemsSolicitudMateriales() {
        if (itemsSolMaterial == null) {
            itemsSolMaterial = getSolicitudMaterialesFacade().findByIdSolicitud(selected);
        }
        return itemsSolMaterial;
    }

    public SolicitudMaterialesAlmacenController() {
    }
    
    public SolicitudMaterialesAlmacen getSelected() {
        return selected;
    }

    public void setSelected(SolicitudMaterialesAlmacen selected) {
        this.selected = selected;
    }

    public SolicitudMaterialesAlmacenMateriales getSelectedSolMaterial() {
        return selectedSolMaterial;
    }

    public void setSelectedSolMaterial(SolicitudMaterialesAlmacenMateriales selected) {
        this.selectedSolMaterial = selected;
    }
     
    protected void setEmbeddableKeysSolMaterial() {
        selectedSolMaterial.getSolicitudMaterialesAlmacenMaterialesPK().setIdMateriales(selectedSolMaterial.getMateriales().getIdMateriales());
        selectedSolMaterial.getSolicitudMaterialesAlmacenMaterialesPK().setIdSolicitudMaterial(selectedSolMaterial.getSolicitudMaterialesAlmacen().getIdSolicitudMaterial());
    }    
    protected void initializeEmbeddableKeySolMaterial() {
        selectedSolMaterial.setSolicitudMaterialesAlmacenMaterialesPK(new co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMaterialesPK());
    }
    
    private SolicitudMaterialesAlmacenMaterialesFacade getFacadeSolMaterial() {
        return ejbSolMaterial;
    }
    
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SolicitudMaterialesAlmacenFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new SolicitudMaterialesAlmacen();
        initializeEmbeddableKey();
        selectedSolMaterial = new SolicitudMaterialesAlmacenMateriales();
        initializeEmbeddableKeySolMaterial();
        itemsSolMaterial = new ArrayList<>();
        return "/modulo6/GestionMaterialesFormacion/Admin/Coordinacion/SolicitudesMateriales/Create.xhtml";
    }

        public String prepareCreateIns() {
        selected = new SolicitudMaterialesAlmacen();
        initializeEmbeddableKey();
        selectedSolMaterial = new SolicitudMaterialesAlmacenMateriales();
        initializeEmbeddableKeySolMaterial();
        itemsSolMaterial = new ArrayList<>();
        return "/modulo6/GestionMaterialesFormacion/Instructor/SolicitudMateriales/SolicitudMateriales.xhtml";
    }
    
    public String cargarSolicitudes() {
        return "/modulo6/GestionMaterialesFormacion/Admin/Coordinacion/SolicitudesMateriales/Solicitudes.xhtml";
    }
    
    public String viewRedireccion() {
        return "/modulo6/GestionMaterialesFormacion/Instructor/SolicitudMateriales/ViewRedireccion.xhtml";
    }

    public String prepareEdit() {
        itemsSolMaterial = null;
        return "/modulo6/GestionMaterialesFormacion/Admin/Coordinacion/SolicitudesMateriales/Edit.xhtml";
    }

    public String prepareEditAlmacenista() {
        itemsSolMaterial = null;
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/Materiales/EditObservacion.xhtml";
    }

    public String prepareViewIns() {
        itemsSolMaterial = null;
        return "/modulo6/GestionMaterialesFormacion/Instructor/SolicitudMateriales/View.xhtml";
    }

    public String prepareView() {
        return "/modulo6/GestionMaterialesFormacion/Admin/Coordinacion/SolicitudesMateriales/View";
    }

    public void agregarMateriales() {
        itemsSolMaterial.add(selectedSolMaterial);
        selectedSolMaterial = new SolicitudMaterialesAlmacenMateriales();
        initializeEmbeddableKeySolMaterial();
    }

    public List<SolicitudMaterialesAlmacenMateriales> getItemsSolMaterial() {
        return itemsSolMaterial;
    }
    
    public void create() {
        selected.setFechaDeSolicitud(new Date());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenCreated"));
        for (SolicitudMaterialesAlmacenMateriales item : itemsSolMaterial) {
            selectedSolMaterial = item;
            selectedSolMaterial.setSolicitudMaterialesAlmacen(selected);
            persistSolMaterial(PersistAction.CREATE, null);
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        
    }
        
    public void eliminar() {
        itemsSolMaterial.remove(selectedSolMaterial);
    }
     
    
    public String update() {
        selected.setSolicitudMaterialesAlmacenMaterialesList(itemsSolMaterial);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenUpdated"));
        for (SolicitudMaterialesAlmacenMateriales item : itemsSolMaterial) {
            selectedSolMaterial = item;
            persistSolMaterial(PersistAction.UPDATE, null);
        }
        items = null;
        return "/modulo6/GestionMaterialesFormacion/Admin/Coordinacion/SolicitudesMateriales/Solicitudes.xhtml";
    }
    
    public String updateDos() {
        selected.setSolicitudMaterialesAlmacenMaterialesList(itemsSolMaterial);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenUpdated"));
        for (SolicitudMaterialesAlmacenMateriales item : itemsSolMaterial) {
            selectedSolMaterial = item;
            persistSolMaterial(PersistAction.UPDATE, null);
        }
        items = null;
        return "/modulo6/GestionMaterialesFormacion/Admin/Almacen/Materiales/SolicitudesAprobadas.xhtml";
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("SolicitudMaterialesAlmacenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SolicitudMaterialesAlmacen> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.CREATE) {
                    getFacade().create(selected);
                } else if (persistAction == PersistAction.UPDATE) {
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
    
    private void persistSolMaterial(PersistAction persistAction, String successMessage) {
        if (selectedSolMaterial != null) {
            setEmbeddableKeysSolMaterial();
            try {
                if (persistAction == PersistAction.CREATE) {
                    getFacadeSolMaterial().create(selectedSolMaterial);
                } else if (persistAction == PersistAction.UPDATE) {
                    getFacadeSolMaterial().edit(selectedSolMaterial);
                } else {
                    getFacadeSolMaterial().remove(selectedSolMaterial);
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

    public SolicitudMaterialesAlmacen getSolicitudMaterialesAlmacen(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SolicitudMaterialesAlmacen> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SolicitudMaterialesAlmacen> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
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
    

    @FacesConverter(forClass = SolicitudMaterialesAlmacen.class)
    public static class SolicitudMaterialesAlmacenControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SolicitudMaterialesAlmacenController controller = (SolicitudMaterialesAlmacenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "solicitudMaterialesAlmacenController");
            return controller.getSolicitudMaterialesAlmacen(getKey(value));
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
            if (object instanceof SolicitudMaterialesAlmacen) {
                SolicitudMaterialesAlmacen o = (SolicitudMaterialesAlmacen) object;
                return getStringKey(o.getIdSolicitudMaterial());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SolicitudMaterialesAlmacen.class.getName()});
                return null;
            }
        }

    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}