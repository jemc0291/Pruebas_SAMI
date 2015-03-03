package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Bancos;
import co.edu.sena.sami.jpa.entities.CentroFormacion;
import co.edu.sena.sami.jpa.entities.Ciudad;
import co.edu.sena.sami.jpa.entities.CiudadComisiones;
import co.edu.sena.sami.jpa.entities.Comisiones;
import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jpa.entities.DescripcionesReferenciasViaticos;
import co.edu.sena.sami.jpa.entities.FichaCaracterizacion;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jpa.sessions.CentroFormacionFacade;
import co.edu.sena.sami.jpa.sessions.CiudadComisionesFacade;
import co.edu.sena.sami.jpa.sessions.ComisionesFacade;
import co.edu.sena.sami.jpa.sessions.UsuariosFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named("comisionesController")
@SessionScoped
public class ComisionesController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ComisionesFacade ejbFacade;
    @EJB
    private co.edu.sena.sami.jpa.sessions.CiudadComisionesFacade ciudadComisionesFacade;
    @EJB
    private co.edu.sena.sami.jpa.sessions.ContratosFacade ejbFacadeContratos;
    @EJB
    private co.edu.sena.sami.jpa.sessions.BancosFacade ejbFacadeBanco;
    @EJB
    private co.edu.sena.sami.jpa.sessions.CentroFormacionFacade ejbFacadeCentrosFormacion;
     @EJB
    private co.edu.sena.sami.jpa.sessions.CiudadFacade ejbFacadeCiudad;
     @EJB
    private co.edu.sena.sami.jpa.sessions.DescripcionesReferenciasViaticosFacade ejbFacadeDescripciones;
     @EJB
    private co.edu.sena.sami.jpa.sessions.FichaCaracterizacionFacade ejbFacadeFichas;
     @EJB
    private co.edu.sena.sami.jpa.sessions.UsuariosFacade ejbFacadeUsuarios;
     
    

    private List<Comisiones> items = null;
    private Comisiones selected;
    private List<CiudadComisiones> ciudadComisionesList;
    private CiudadComisiones ciudadComisionesActual;
    private List<Contratos> itemsContratos = null;
    private Contratos selectedContratos;
    private List<Bancos> itemsBanco = null;
    private Bancos selectedBanco;
    private List<CentroFormacion> itemsCentrosFormacion = null;
    private CentroFormacion selectedCentrosFormcion;
    private List<Ciudad> itemsCiudad = null;
    private Ciudad selectedCiudad;
    private List<DescripcionesReferenciasViaticos> itemsDescripciones = null;
    private DescripcionesReferenciasViaticos selectedDescripciones;
    private List<FichaCaracterizacion> itemsFichas = null;
    private FichaCaracterizacion selectedFichas;
    private List<Usuarios> itemsUsuarios = null;
    private Usuarios selectedUsuarios;


    public Contratos getContratos(java.lang.Integer id) {
        return getEjbFacadeContratos().find(id);
    }

    public List<Contratos> getItemsAvailableSelectManyContratos() {
        return getEjbFacadeContratos().findAll();
    }

    public List<Contratos> getItemsAvailableSelectOneContratos() {
        return getEjbFacadeContratos().findAll();
    }

    public CentroFormacion getCentroFormacion(java.lang.Integer id) {
        return getFacadeCentrosFormacion().find(id);
    }

    public CentroFormacionFacade getFacadeCentrosFormacion() {
        return ejbFacadeCentrosFormacion;
    }

    public List<CentroFormacion> getItemsAvailableSelectManyCentrosformacion() {
        return getFacadeCentrosFormacion().findAll();
    }

    public List<CentroFormacion> getItemsAvailableSelectOneCentrosFormacion() {
        return getFacadeCentrosFormacion().findAll();
    }
   
     public Ciudad getCiudad(co.edu.sena.sami.jpa.entities.CiudadPK id) {
        return getFacadeCiudad().find(id);
    }

    public List<Ciudad> getItemsAvailableSelectManyCiudad() {
        return getFacadeCiudad().findAll();
    }

    public List<Ciudad> getItemsAvailableSelectOneCiudad() {
        return getFacadeCiudad().findAll();
    }
    public DescripcionesReferenciasViaticos getDescripcionesReferenciasViaticos(java.lang.Integer id) {
        return getFacadeDescripciones().find(id);
    }

    public List<DescripcionesReferenciasViaticos> getItemsAvailableSelectManyDescripciones() {
        return getFacadeDescripciones().findAll();
    }

    public List<DescripcionesReferenciasViaticos> getItemsAvailableSelectOneDescripciones() {
        return getFacadeDescripciones().findAll();
    }

    public FichaCaracterizacion getFichaCaracterizacion(java.lang.Integer id) {
        return getFacadeFichas().find(id);
    }

    public List<FichaCaracterizacion> getItemsAvailableSelectManyFichas() {
        return getFacadeFichas().findAll();
    }

    public List<FichaCaracterizacion> getItemsAvailableSelectOneFichas() {
        return getFacadeFichas().findAll();
    }

    public Bancos getBancos(java.lang.Integer id) {
        return getFacadeBanco().find(id);
    }

    public CiudadComisionesFacade getCiudadComisionesFacade() {
        return ciudadComisionesFacade;
    }

    public List<CiudadComisiones> getCiudadComisionesList() {
        return ciudadComisionesList;
    }

    public CiudadComisiones getCiudadComisionesActual() {
        return ciudadComisionesActual;
    }

    public void setCiudadComisionesActual(CiudadComisiones ciudadComisionesActual) {
        this.ciudadComisionesActual = ciudadComisionesActual;
    }

    public List<Bancos> getItemsAvailableSelectManyBanco() {
        return getFacadeBanco().findAll();
    }

    public List<Bancos> getItemsAvailableSelectOneBanco() {
        return getFacadeBanco().findAll();
    }

    public UsuariosFacade getFacadeUsuarios() {
        return ejbFacadeUsuarios;
    }
    
    public List<Usuarios> getItemsAvailableSelectManyUsuarios() {
        return getFacadeUsuarios().findAll();
    }

    public List<Usuarios> getItemsAvailableSelectOneUsuarios() {
        return getFacadeUsuarios().findAll();
    }

    public ComisionesController() {
    }

    public Comisiones getSelected() {
        return selected;
    }

    public void setSelected(Comisiones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    protected void setEmbeddableKeysCiuComisiones(CiudadComisiones ciudadComisiones) {
        ciudadComisiones.getCiudadComisionesPK().setIdCiudad(ciudadComisiones.getCiudad().getCiudadPK().getIdCiudad());
        ciudadComisiones.getCiudadComisionesPK().setIdComision(ciudadComisiones.getComisiones().getIdComision());
        ciudadComisiones.getCiudadComisionesPK().setIdDpto(ciudadComisiones.getCiudad().getCiudadPK().getIdDpto());
    }

    protected void initializeEmbeddableKeyCiuComisiones() {
        ciudadComisionesActual.setCiudadComisionesPK(new co.edu.sena.sami.jpa.entities.CiudadComisionesPK());
    }

    private ComisionesFacade getFacade() {
        return ejbFacade;
    }

    public String prepareListComision() {
       return "/modulo4/Gestion_Talento_Humano/Comisiones/comision.xhtml";
   }
    
    public String prepareConsultarComision() {
       return "VerComision";
   }
    
    public String prepareCreate() {
        selected = new Comisiones();
        ciudadComisionesList = new ArrayList<>();
        ciudadComisionesActual = new CiudadComisiones();
        initializeEmbeddableKeyCiuComisiones();
        initializeEmbeddableKey();
        return "/modulo4/Gestion_Talento_Humano/Comisiones/CrearComision.xhtml";
    }
    
    public String prepareCreateInformeComision() {
        return "/modulo4/Gestion_Talento_Humano/Comisiones/informeComision.xhtml";
    }

    public void adicionarCiudadComision() {
        for (CiudadComisiones item : ciudadComisionesList) {
            if (item.equals(ciudadComisionesActual)) {
                JsfUtil.addErrorMessage("Elemento ya existe.");
                return;
            }
        }
        ciudadComisionesList.add(ciudadComisionesActual);
        ciudadComisionesActual = new CiudadComisiones();
        JsfUtil.addSuccessMessage("Destino agregado correctamente");
    }
    
     public void adicionarSitioComision() {
        for (CiudadComisiones item : ciudadComisionesList) {
            if (item.equals(ciudadComisionesActual)) {
                JsfUtil.addErrorMessage("Elemento ya existe.");
                return;
            }
        }
        ciudadComisionesList.add(ciudadComisionesActual);
        ciudadComisionesActual = new CiudadComisiones();
        JsfUtil.addSuccessMessage("Destino agregado correctamente");
    }
     
    public String loadCreate(){
        return "/modulo4/Gestion_Talento_Humano/Comisiones/comision.xhtml";
    }
    
    public void create(ActionEvent event) {
        selected.setIdUsuario((Usuarios) event.getComponent().getAttributes().get("usuario"));
        selected.setFechaTramite(new Date());
        selected.setCiudad(selected.getIdCentroFormacion().getCiudad());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ComisionesCreated"));
        try {
            for (CiudadComisiones item : ciudadComisionesList) {
                item.setComisiones(selected);
                setEmbeddableKeysCiuComisiones(item);
                getCiudadComisionesFacade().create(item);
            }

        } catch (Exception ex) {
            JsfUtil.addErrorMessage("Error de persistencia");
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ComisionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ComisionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Comisiones> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                switch (persistAction) {
                    case CREATE:
                        getFacade().create(selected);
                        break;
                    case UPDATE:
                        getFacade().edit(selected);
                        break;
                    case DELETE:
                        getFacade().remove(selected);
                        break;
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

    public Comisiones getComisiones(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Comisiones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Comisiones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the ejbFacadeContratos
     */
    public co.edu.sena.sami.jpa.sessions.ContratosFacade getEjbFacadeContratos() {
        return ejbFacadeContratos;
    }

    /**
     * @return the ejbFacade
     */
    public co.edu.sena.sami.jpa.sessions.ComisionesFacade getEjbFacade() {
        return ejbFacade;
    }

    /**
     * @return the ejbFacadeDescripciones
     */
    public co.edu.sena.sami.jpa.sessions.DescripcionesReferenciasViaticosFacade getFacadeDescripciones() {
        return ejbFacadeDescripciones;
    }

    /**
     * @return the ejbFacadeFichas
     */
    public co.edu.sena.sami.jpa.sessions.FichaCaracterizacionFacade getFacadeFichas() {
        return ejbFacadeFichas;
    }

    /**
     * @return the ejbFacadeBanco
     */
    public co.edu.sena.sami.jpa.sessions.BancosFacade getFacadeBanco() {
        return ejbFacadeBanco;
    }

    /**
     * @return the ejbFacadeCiudad
     */
    public co.edu.sena.sami.jpa.sessions.CiudadFacade getFacadeCiudad() {
        return ejbFacadeCiudad;
    }

    @FacesConverter(forClass = Comisiones.class)
    public static class ComisionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComisionesController controller = (ComisionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comisionesController");
            return controller.getComisiones(getKey(value));
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
            if (object instanceof Comisiones) {
                Comisiones o = (Comisiones) object;
                return getStringKey(o.getIdComision());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Comisiones.class.getName()});
                return null;
            }
        }

    }

}
