package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Cdp;
import co.edu.sena.sami.jpa.entities.Dependencias;
import co.edu.sena.sami.jpa.entities.Gestiones;
import co.edu.sena.sami.jpa.entities.Rubros;
import co.edu.sena.sami.jpa.entities.TiposDeSolicitudes;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.CdpFacade;

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

@Named("cdpController")
@SessionScoped
public class CdpController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.CdpFacade ejbFacade;
    private List<Cdp> items = null;
    private Cdp selected;
    @EJB
    private co.edu.sena.sami.jpa.sessions.RubrosFacade ejbFacadeRubro;
    @EJB
    private co.edu.sena.sami.jpa.sessions.TiposDeSolicitudesFacade ejbTiposDeSolicitudes;
    @EJB
    private co.edu.sena.sami.jpa.sessions.GestionesFacade ejbFacadeGestiones;
    @EJB
    private co.edu.sena.sami.jpa.sessions.DependenciasFacade ejbFacadeDependencias;
    

    public CdpController() {
    }

    public Cdp getSelected() {
        return selected;
    }

    public void setSelected(Cdp selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CdpFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new Cdp();
        initializeEmbeddableKey();
        return "Agregar";
    }

    public String prepareVerCdp() {
        return "/modulo4/Gestion_Talento_Humano/Solicitudcdp/verCDP.xhtml";
    }

    public String prepareEditarCdp() {
        return "/modulo4/Gestion_Talento_Humano/Solicitudcdp/Editar.xhtml";
    }

    public String loadCreate() {
        return "/modulo4/Gestion_Talento_Humano/Solicitudcdp/Listar.xhtml";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("CdpCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("CdpUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("CdpDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Cdp> getItems() {
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

    public Cdp getCdp(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Cdp> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cdp> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }


    public TiposDeSolicitudes getTiposDeSolicitudes(java.lang.Integer id) {
        return getEjbTiposDeSolicitudes().find(id);
    }

    public List<TiposDeSolicitudes> getItemsAvailableSelectManyTiposDeSolicitudes() {
        return getEjbTiposDeSolicitudes().findAll();
    }

    public List<TiposDeSolicitudes> getItemsAvailableSelectOneTiposDeSolicitudes() {
        return getEjbTiposDeSolicitudes().findAll();
    }
    
    public Rubros getRubros(java.lang.String id) {
        return getEjbFacadeRubro().find(id);
    }

    public List<Rubros> getItemsAvailableSelectManyRubros() {
        return getEjbFacadeRubro().findAll();
    }

    public List<Rubros> getItemsAvailableSelectOneRubros() {
        return getEjbFacadeRubro().findAll();
    }
        public Gestiones getGestiones(java.lang.String id) {
        return getEjbFacadeGestiones().find(id);
    }

    public List<Gestiones> getItemsAvailableSelectManyGestiones() {
        return getEjbFacadeGestiones().findAll();
    }

    public List<Gestiones> getItemsAvailableSelectOneGestiones() {
        return getEjbFacadeGestiones().findAll();
    }

    
    /**
     * @return the ejbTiposDeSolicitudes
     */
    public co.edu.sena.sami.jpa.sessions.TiposDeSolicitudesFacade getEjbTiposDeSolicitudes() {
        return ejbTiposDeSolicitudes;
    }

    /**
     * @return the ejbFacadeRubro
     */
    public co.edu.sena.sami.jpa.sessions.RubrosFacade getEjbFacadeRubro() {
        return ejbFacadeRubro;
    }

    /**
     * @return the ejbFacadeGestiones
     */
    public co.edu.sena.sami.jpa.sessions.GestionesFacade getEjbFacadeGestiones() {
        return ejbFacadeGestiones;
    }

    /**
     * @return the ejbFacadeDependencias
     */
    public co.edu.sena.sami.jpa.sessions.DependenciasFacade getEjbFacadeDependencias() {
        return ejbFacadeDependencias;
    }
       public Dependencias getDependencias(java.lang.Integer id) {
        return getEjbFacadeDependencias().find(id);
    }

    public List<Dependencias> getItemsAvailableSelectManyDependencias() {
        return getEjbFacadeDependencias().findAll();
    }

    public List<Dependencias> getItemsAvailableSelectOneDependencias() {
        return getEjbFacadeDependencias().findAll();
    }

    @FacesConverter(forClass = Cdp.class)
    public static class CdpControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CdpController controller = (CdpController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cdpController");
            return controller.getCdp(getKey(value));
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
            if (object instanceof Cdp) {
                Cdp o = (Cdp) object;
                return getStringKey(o.getNumeroCdp());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cdp.class.getName()});
                return null;
            }
        }

    }

}
