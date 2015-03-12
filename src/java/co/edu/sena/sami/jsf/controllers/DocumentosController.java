/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template archivo, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.Documentos;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jpa.sessions.DocumentosFacade;
import co.edu.sena.sami.jpa.sessions.TiposDocumentoGdFacade;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil;
import co.edu.sena.sami.jsf.controllers.util.JsfUtil.PersistAction;
import javax.faces.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Usuario
 */
@Named("documentosController")
@SessionScoped
public class DocumentosController implements Serializable {

    /**
     * Creates a new instance of DocumentosController
     */
    @EJB
    private co.edu.sena.sami.jpa.sessions.DocumentosFacade documentoFacade;
    private List<Documentos> items = null;
    private Documentos documentoActual;
    @EJB
    private TiposDocumentoGdFacade tiposDocumentoGdFacade;
    private UploadedFile archivo;
    private String destination = "/var/sami/ges_doc";
 

    public DocumentosController() {
    }

    public TiposDocumentoGdFacade getTiposDocumentoGdFacade() {
        return tiposDocumentoGdFacade;
    }

    public void setTiposDocumentoGdFacade(TiposDocumentoGdFacade tiposDocumentoGdFacade) {
        this.tiposDocumentoGdFacade = tiposDocumentoGdFacade;
    }  
 
    public Documentos getDocumentoActual() {
        return documentoActual;
    }

    public void setDocumentoActual(Documentos documentoActual) {
        this.documentoActual = documentoActual;
    }

    public DocumentosFacade getDocumentoFacade() {
        return documentoFacade;
    }


    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public String prepareCreate() {
        documentoActual = new Documentos();
        destination ="";
        initializeEmbeddableKey();
        return "crearGesdoc";
    }
    
     public String prepareConsultar() {
       return "consultarGesdoc";
   }
     
   public String prepareListDocumentos() {
       return "/modulo5/Normas/listaNormas";
   }
     
    public List<Documentos> getItems() {
        if (items == null) {
            items = getDocumentoFacade().findAll();
        }
        return items;
    }

    public Documentos getDocumentos(java.lang.Integer id) {
        return getDocumentoFacade().find(id);
    }

    public List<Documentos> getItemsAvailableSelectMany() {
        return getDocumentoFacade().findAll();
    }

    public List<Documentos> getItemsAvailableSelectOne() {
        return getDocumentoFacade().findAll();
    }

    public String create() {    
         try {
        
        documentoActual.setFechaIngreso(new Date());
        documentoActual.setActivo(Boolean.TRUE);
        getDocumentoFacade().create(documentoActual);
            
             
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }   
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoDocumentoGdCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        return "listaDocumentos";
    }
    
      public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoDocumentoGdDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            documentoActual = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (documentoActual != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getDocumentoFacade().edit(documentoActual);
                } else {
                    getDocumentoFacade().remove(documentoActual);
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
    
    public void openFile(){
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +documentoActual.getUrl());
        } catch (IOException e) {
                e.printStackTrace();
}
    }

    //boton para cargar documentos
    
//

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

      public void upload(ActionEvent event) {
//        if (archivo != null) {
//            FacesMessage message = new FacesMessage("Succesful", archivo.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
        
        // Do what you want with the archivo        
        try {
            documentoActual.setIdUsuario((Usuarios) event.getComponent().getAttributes().get("usuario"));
            copyFile(archivo.getFileName(), archivo.getInputstream());
            FacesMessage msg = new FacesMessage("Éxito! ", archivo.getFileName() + " ha sido Cargado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }
    }
//
//    }
    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + documentoActual.getIdDocumentos()+ fileName));
            documentoActual.setUrl(destination + documentoActual.getIdDocumentos() + fileName);
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
    
    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

}
