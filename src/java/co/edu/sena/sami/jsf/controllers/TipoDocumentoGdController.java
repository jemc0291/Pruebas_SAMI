/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.entities.TipoDocumentos;
import co.edu.sena.sami.jpa.entities.TiposDocumentoGd;
import co.edu.sena.sami.jpa.sessions.TiposDocumentoGdFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "tipoDocumentoGdController")
@SessionScoped
public class TipoDocumentoGdController implements Serializable {

    
    @EJB
    private co.edu.sena.sami.jpa.sessions.TiposDocumentoGdFacade tipoDocumentogd;
    private List<TiposDocumentoGd> items = null;
    private TiposDocumentoGd documentoActual;
    /**
     * Creates a new instance of TipoDocumentoGdController
     */
    public TipoDocumentoGdController() {
    }

    public TiposDocumentoGd getDocumentoActual() {
        return documentoActual;
    }

    public void setDocumentoActual(TiposDocumentoGd documentoActual) {
        this.documentoActual = documentoActual;
    }
    
    public TiposDocumentoGdFacade getTipoDocumentogd() {
        return tipoDocumentogd;
    }
    
    public String prepareCreate() {
        documentoActual = new TiposDocumentoGd();
  
        return "AgregarTipoDocumento ";
    }
    
     public String prepareListTipoDocumentos () {
        return "/Configuracion/Tipo Documento/ListarTipoDocumento";
    }

    public List<TiposDocumentoGd> getItems() {
        if (items == null) {
            items = getTipoDocumentogd().findAll();
        }
        return items;
    }

    public TiposDocumentoGd getTipoDocumentos(java.lang.Integer id) {
        return getTipoDocumentogd().find(id);
    }

    public List<TiposDocumentoGd> getItemsAvailableSelectMany() {
        return getTipoDocumentogd().findAll();
    }

    public List<TiposDocumentoGd> getItemsAvailableSelectOne() {
        return getTipoDocumentogd().findAll();
    }

    @FacesConverter(forClass = TiposDocumentoGd.class)
    public static class TipoDocumentoGdControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoDocumentoGdController controller = (TipoDocumentoGdController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoDocumentoGdController");
            return controller.getTipoDocumentos(getKey(value));
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
            if (object instanceof TiposDocumentoGd) {
                TiposDocumentoGd o = (TiposDocumentoGd) object;
                return getStringKey(o.getIdtiposDocumentoGd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoDocumentos.class.getName()});
                return null;
            }
        }

    }
    
}
