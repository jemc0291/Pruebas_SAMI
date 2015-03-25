package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Cargo;
import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jpa.entities.Polizas;
import co.edu.sena.sami.jpa.entities.Rol;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jpa.entities.UsuariosContratos;
import co.edu.sena.sami.jpa.entities.UsuariosContratosPK;
import co.edu.sena.sami.jpa.sessions.CargoFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ContratosFacade;
import co.edu.sena.sami.jpa.sessions.PolizasFacade;
import co.edu.sena.sami.jpa.sessions.UsuariosContratosFacade;

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
import javax.faces.validator.ValidatorException;

@Named("contratosController")
@SessionScoped
public class ContratosController implements Serializable {

    @EJB
    private PolizasFacade polizasFacade;
    @EJB
    private co.edu.sena.sami.jpa.sessions.ContratosFacade ejbFacade;
    @EJB
    private UsuariosContratosFacade usuariosContratosFacade;
    @EJB
    private CargoFacade cargoFacade;
    private List<Contratos> items = null;
    private Contratos selected;
    private Polizas selectedPolizas;
    private UsuariosContratos selectedUsuariosContratos;
    private Usuarios selectedUsuarios;
    private Rol selectedRol;
    private Usuarios selectedSupervisor;
    private UsuariosContratos selectedSupervisorContratos;
    private Date fechaInicio;
    private Date fechaFin;

    public ContratosController() {
    }
    public CargoFacade getCargoFacade() {
        return cargoFacade;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCargoFacade(CargoFacade cargoFacade) {
        this.cargoFacade = cargoFacade;
    }

    public Contratos getSelected() {
        return selected;
    }

    public Polizas getSelectedPolizas() {
        return selectedPolizas;
    }

    public void setSelectedPolizas(Polizas selectedPolizas) {
        this.selectedPolizas = selectedPolizas;
    }

    public PolizasFacade getPolizasFacade() {
        return polizasFacade;
    }

    public UsuariosContratosFacade getUsuariosContratosFacade() {
        return usuariosContratosFacade;
    }
    

    public void setSelected(Contratos selected) {
        this.selected = selected;
    }

    public Usuarios getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(Usuarios selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public Rol getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(Rol selectedRol) {
        this.selectedRol = selectedRol;
    }

    public UsuariosContratos getSelectedUsuariosContratos() {
        return selectedUsuariosContratos;
    }

    public void setSelectedUsuariosContratos(UsuariosContratos selectedUsuariosContratos) {
        this.selectedUsuariosContratos = selectedUsuariosContratos;
    }
    
    public Usuarios getSelectedSupervisor() {
        return selectedSupervisor;
    }

    public void setSelectedSupervisor(Usuarios selectedSupervisor) {
        this.selectedSupervisor = selectedSupervisor;
    }

    public UsuariosContratos getSelectedSupervisorContratos() {
        return selectedSupervisorContratos;
    }

    public void setSelectedSupervisorContratos(UsuariosContratos selectedSupervisorContratos) {
        this.selectedSupervisorContratos = selectedSupervisorContratos;
    }
    
    public UsuariosContratos getUsuariosByContratos(Contratos contrato) {
        if (getUsuariosContratosFacade().findByIdContrato(contrato)== null){
            return new UsuariosContratos();
        } else {
        return getUsuariosContratosFacade().findByIdContrato(contrato);
        }
    }
    
    public List<UsuariosContratos> getUsuariosSupervisores(Contratos contrato) {
        if (contrato != null) {
            return getUsuariosContratosFacade().findByIdContratoSupervisor(contrato);
        } else {
            return null;
        }
    }

    public String obtenerCargo(Rol r) {
        Cargo c = new Cargo();
        switch (r.getIdRol()) {
            case 1:
                c = getCargoFacade().find(15);
                break;
            case 2:
                c = getCargoFacade().find(13);
                break;
            default:
                return null;
        }
        return c.getNombreCargo();
    }

    public UsuariosContratos getSupervisoresByRol(Contratos c) {
        if (getUsuariosContratosFacade().findByIdRol(c) == null) {
            return new UsuariosContratos();
        } else {
            return getUsuariosContratosFacade().findByIdRol(c);
        }
    }

    public UsuariosContratos getContratistasByRol(Contratos c) {
        if (getUsuariosContratosFacade().findByIdRol(c) == null) {
            return new UsuariosContratos();
        } else {
            return getUsuariosContratosFacade().findByIdRol(c);
        }
    }
    public List<Contratos> contratosConInforme() {
        List<Contratos> csi = new ArrayList<>();
        for (Contratos c : getItems()) {
            if (!c.getInformesList().isEmpty()) {
                csi.add(c);
            }
        }
        return csi;
    }

    public List<Contratos> contratosSinInforme() {
        List<Contratos> csi = new ArrayList<>();
        items = null;
        for (Contratos c : getItems()) {
            if (c.getInformesList().isEmpty()) {
                csi.add(c);
            }
        }
        return csi;
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
        selectedPolizas = new Polizas();
        selectedUsuariosContratos = new UsuariosContratos();
        selectedUsuariosContratos.setUsuariosContratosPK(new UsuariosContratosPK());
        selectedUsuarios = new Usuarios();
        selectedRol = new Rol();
        selectedSupervisor = new Usuarios();
        selectedSupervisorContratos = new UsuariosContratos();
        selectedSupervisorContratos.setUsuariosContratosPK(new UsuariosContratosPK());
        //initializeEmbeddableKey();        
        return "/modulo3/GestionContractual/CrearContrato";
    }
    
    public String prepareEdit(){
        return "/modulo3/GestionContractual/EditarContrato";
    }
    
    public String prepareView(){
        return "VerContrato";
    }
    public String prepareList(){
        limpiarLista();
        return "/modulo3/GestionContractual/ListaContratos";
    }
    public void limpiarLista(){
        fechaInicio=null;
        fechaFin=null;
        getContratosRango();
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
        createPolizas();
        selectedUsuariosContratos.setContratos(selected);
        selectedUsuariosContratos.setPolizas(selectedPolizas);
        selectedUsuariosContratos.setRol(new Rol(1));
        selectedUsuariosContratos.setUsuarios(selectedUsuarios);
        
        selectedSupervisorContratos.setContratos(selected);
        selectedSupervisorContratos.setPolizas(selectedPolizas);
        selectedSupervisorContratos.setRol(new Rol(2));
        selectedSupervisorContratos.setUsuarios(selectedSupervisor);
        
        selectedSupervisorContratos.getUsuariosContratosPK().setIdContrato(selectedSupervisorContratos.getContratos().getIdContrato());
        selectedSupervisorContratos.getUsuariosContratosPK().setIdRol(selectedSupervisorContratos.getRol().getIdRol());
        selectedSupervisorContratos.getUsuariosContratosPK().setIdUsuario(selectedSupervisorContratos.getUsuarios().getIdUsuario());
        selectedSupervisorContratos.getUsuariosContratosPK().setNumeroDePoliza(selectedSupervisorContratos.getPolizas().getNumeroDePoliza());
        
        selectedUsuariosContratos.getUsuariosContratosPK().setIdContrato(selectedUsuariosContratos.getContratos().getIdContrato());
        selectedUsuariosContratos.getUsuariosContratosPK().setIdRol(selectedUsuariosContratos.getRol().getIdRol());
        selectedUsuariosContratos.getUsuariosContratosPK().setIdUsuario(selectedUsuariosContratos.getUsuarios().getIdUsuario());
        selectedUsuariosContratos.getUsuariosContratosPK().setNumeroDePoliza(selectedUsuariosContratos.getPolizas().getNumeroDePoliza());
        try {
            getUsuariosContratosFacade().create(selectedUsuariosContratos);
            getUsuariosContratosFacade().create(selectedSupervisorContratos);
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "ListaContratos";
//return "/index";
    }
     public void createPolizas(){
        try{
            getPolizasFacade().create(selectedPolizas);
        }catch(Exception e){
            
        }
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

    public Contratos getContratos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Contratos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Contratos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    public List<Contratos> getContratosRango() {//Metodo que permite utilizar la consulta que nos trae las facturas en determinado rango de fechas
        return getFacade().rangoFechas(fechaInicio,fechaFin);
    }
    public List<Contratos> getListNumeroContratoAutoComplete(String query) {//se agrego metodo de autocompletar
        try {
            return getFacade().findByNumeroContratoCompletar(query);
        } catch (Exception ex) {
            Logger.getLogger(ContratosController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @FacesConverter(forClass = Contratos.class, value = "contratosConverter")
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
        if (getFacade().findByNumeroDeContrato((String) value) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrato ya existente", "El contrato ya existe en la base de datos !!!!"));
        } else {
            selected.setNumeroDeContrato((String) value);
        }

    }
}
