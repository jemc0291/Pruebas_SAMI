package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.DatosOnbase;
import co.edu.sena.sami.jpa.sessions.DatosOnbaseFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

@Named("datosOnbaseController")
@SessionScoped
public class DatosOnbaseController implements Serializable {

    @EJB
    private co.edu.sena.sami.jpa.sessions.DatosOnbaseFacade ejbFacade;

    private List<DatosOnbase> items = null;
    private DatosOnbase selected;

    public DatosOnbaseController() {
    }

    public DatosOnbase getSelected() {
        return selected;
    }

    public void setSelected(DatosOnbase selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DatosOnbaseFacade getFacade() {
        return ejbFacade;
    }

    public DatosOnbase prepareCreate() {
        selected = new DatosOnbase();
        initializeEmbeddableKey();
        return selected;
    }

    public String prepareConsultarRecibidas() {
        return "ConsultarRecibidas";
    }
    
    public String prepareConsultarProducidas() {
        return "ConsultarProducidas";
    }
    
     public String prepareConsultarInforme() {
        return "ConsultarInforme";
    }

    public String prepareListaRecibidas() {
        return "modulo5/Gestion Documental/Pqrsf/ListarRecibidas";
    }

    public String prepareListaProducidas() {
        return "modulo5/Gestion Documental/Pqrsf/ListarProducidas";
    }

    public void create() {
        getFacade().loadDatosOnBase(urlFileName);
//        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("DatosOnbaseCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("DatosOnbaseUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("DatosOnbaseDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DatosOnbase> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<DatosOnbase> getItemsRecibidas() {
        return getFacade().findByRecibidas();
    }

    public List<DatosOnbase> getItemsProducidas() {
        return getFacade().findByProducidas();
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

    public DatosOnbase getDatosOnbase(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<DatosOnbase> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DatosOnbase> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DatosOnbase.class)
    public static class DatosOnbaseControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DatosOnbaseController controller = (DatosOnbaseController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "datosOnbaseController");
            return controller.getDatosOnbase(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = String.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DatosOnbase) {
                DatosOnbase o = (DatosOnbase) object;
                return getStringKey(o.getNumRadicadoRecibida());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DatosOnbase.class.getName()});
                return null;
            }
        }

    }

    public List<DatosOnbase> consulta() {
        List<DatosOnbase> dob = new ArrayList<>();
        boolean x ;
        String nis=null;
        String r1;
        String r2=null;
        for (DatosOnbase d1 : getFacade().findByRecibidas()) {
            r1=d1.getNumRadicadoRecibida().substring(2, 13);
            x = true;
            for (DatosOnbase d2 : getFacade().findByProducidas()) {
                r2=d2.getNumRadicadoRecibida().substring(2, 13);
                nis = d1.getNis().substring(5, 7);
                if ((r1.equals(r2))|| nis.equals("01")||nis.equals("02")) {
                    x = false;
                }
            }
            if (x) {
                dob.add(d1);
            }
        }
        return dob;
    }

    //boton para importar los datos//
    private UploadedFile file;
private String destination = "/var/sami/ges_doc";
    private String urlFileName = "";

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
//        if (file != null) {
//            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
        FacesMessage msg = new FacesMessage("Éxito! ", file.getFileName() + " ha sido Cargado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(file.getFileName(), file.getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }
    }

//    public void upload(FileUploadEvent event) {
//       
//
//    }
    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            urlFileName = destination + fileName;
            OutputStream out = new FileOutputStream(new File(urlFileName));

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

    //boton descargar 
//    private StreamedContent file;
//
//    public FileDownloadView() {
//        InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
//        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
//    }
//
//    public StreamedContent getFile() {
//        return file;
//    }
}
