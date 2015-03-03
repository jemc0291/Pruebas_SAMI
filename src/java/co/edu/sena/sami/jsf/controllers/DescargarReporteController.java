/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jsf.controllers;

import java.io.InputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Adsim
 */
@Named(value = "descargarReporteController")
@SessionScoped
public class DescargarReporteController implements Serializable {

    /**
     * Creates a new instance of DescargarReporteController
     */
    private StreamedContent file;
    
    public DescargarReporteController() {
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
        file = new DefaultStreamedContent(stream, "xls", "fileName");
    }
    
    public StreamedContent getFile() {
        return file;
    }
    
}
