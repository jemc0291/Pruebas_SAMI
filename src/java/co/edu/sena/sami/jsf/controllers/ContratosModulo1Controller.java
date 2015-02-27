package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import co.edu.sena.sami.jpa.sessions.ContratosFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
import org.primefaces.model.UploadedFile;

@Named("contratosModulo1Controller")
@SessionScoped
public class ContratosModulo1Controller implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.ContratosFacade ejbFacade;
    private List<Contratos> items = null;
    private Contratos selected;

    public ContratosModulo1Controller() {
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
        initializeEmbeddableKey();
        return "/modulo1/ContratacionPrestacionDeServicios/Contratos/CreateContrato";
    }

    public String prepareEdit() {
        return "/modulo1/ContratacionPrestacionDeServicios/Contratos/EditContrato";
    }

    public String prepareView() {
        return "/modulo1/ContratacionPrestacionDeServicios/Contratos/ViewContrato";
    }

    public String create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "/modulo1/ContratacionPrestacionDeServicios/Contratos/ListContrato";
    }

    public String prepareListContratosModulo1() {
        return "/modulo1/ContratacionPrestacionDeServicios/Contratos/ListContrato";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("ContratosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
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
    public static class ContratosModulo1ControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ContratosModulo1Controller controller = (ContratosModulo1Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "contratosModulo1Controller");
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

    public void validarContrato(FacesContext contex, UIComponent component, Object value)
            throws ValidatorException {
        if (getFacade().findByNumeroDeContrato((int) value) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrato ya existente", "El contrato ya existe en la base de datos !!!!"));
        } else {
            selected.setNumeroDeContrato((int) value);
        }

    }
        //boton importar los datos
    //boton para importar los datos//
    private UploadedFile file;
    private String destination = "C:\\temp\\Archivos";

//
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
// if (file != null) {
// FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
// FacesContext.getCurrentInstance().addMessage(null, message);
        FacesMessage msg = new FacesMessage("Success! ",
                file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
// Do what you want with the file 
        try {
            copyFile(file.getFileName(), file.getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
// }
    }

// public void upload(FileUploadEvent event) {
// 
//
// }
    public void copyFile(String fileName, InputStream in) {
        try {

// write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}