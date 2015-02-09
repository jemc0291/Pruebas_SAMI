/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jsf.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;



/**
 *
 * @author Usuario
 */
@Named(value = "documentosController")
@SessionScoped
public class DocumentosController implements Serializable {

    /**
     * Creates a new instance of DocumentosController
     */
    public DocumentosController() {
    }

   //boton para cargar documentos
    private UploadedFile file;
    private String destination = "C:\\Temp\\Archivo";
//

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
        FacesMessage msg = new FacesMessage("Success! ", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(file.getFileName(), file.getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    

//    public void upload(FileUploadEvent event) {
//       
//
//    }
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
