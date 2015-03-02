
package co.edu.sena.sami.jsf.controllers;

import co.edu.sena.sami.jpa.sessions.EmailSessionBean;
import java.io.Serializable;
import javax.inject.Named;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.naming.NamingException;

/**
 *
 * @author Adsim
 */
@Named("emailController")
@SessionScoped
public class EmailController implements Serializable {
    private String body;
    private String to;
    private String remitente;
    private String email;
    private String tipoMensaje;
    private String asunto;
    private String detalle;
    
    @EJB
    EmailSessionBean emailBean;

    /**
     * Creates a new instance of EmailController
     */
    public EmailController() {
    }
    
    public String sendMail (){
        try {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Remitente: ");
            mensaje.append(remitente);
            mensaje.append("\nCorreo electronico: ");
            mensaje.append(email);            
            mensaje.append(tipoMensaje);
            mensaje.append(detalle);                  
            
            
            emailBean.sendMail(tipoMensaje + " " + remitente, mensaje.toString());
            addSuccessMessage("Enviar Mensaje", "Mensaje Enviado Exitosamente");
            limpiar();
            return "confirmacion";
        } catch (NamingException | MessagingException ex) {
            addErrorMessage("Error sending message " + ex.getClass().getName(), "Message: " + ex.getMessage());
            return null;
        }
        
    }

    private void limpiar() {
        setBody("");
        setTo("");
        setRemitente("");
        setEmail("");
        setTipoMensage("");
        setAsunto("");
        setDetalle("");
        
    }

      public String getBody() {
        return body;
    }

   
    public void setBody(String body) {
        this.body = body;
    }    

    public String getTo() {
        return to;
    }

  
    public void setTo(String to) {
        this.to = to;
    }
    public String getRemitente() {
        return remitente;
    }
   public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
   public String getEmail() {
        return email;
    }
   public void setEmail(String email) {
        this.email = email;
    }
   public String getTipoMensage() {
        return tipoMensaje;
    }
   public void setTipoMensage(String tipoMensage) {
        this.tipoMensaje = tipoMensage;
    }
   public String getAsunto() {
        return asunto;
    }
   public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
   public String getDetalle() {
        return detalle;
    }
   public void setDetalle(String detalle) {
        this.detalle = detalle;
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
