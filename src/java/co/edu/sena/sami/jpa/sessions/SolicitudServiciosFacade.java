/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.SolicitudServicios;
import co.edu.sena.sami.jpa.entities.Usuarios;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adsim
 */
@Stateless
public class SolicitudServiciosFacade extends AbstractFacade<SolicitudServicios> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudServiciosFacade() {
        super(SolicitudServicios.class);
    }
    
        /**
     *
     * @param u
     * @return
     */
    public List<SolicitudServicios> consultaUsuario(Usuarios u){
        Query q = getEntityManager().createNamedQuery("SolicitudServicios.consultaUsuario");
        q.setParameter("idUsuario", u);
        return  q.getResultList();
    }
    
     public List<SolicitudServicios> rangoFecha(Date fechaInicio, Date fechaFin){
        Query q = getEntityManager().createNamedQuery("SolicitudServicios.findByFechaSolicitudInicioFin");
        q.setParameter("fechaInicio", fechaInicio);
        q.setParameter("fechaFin", fechaFin);
        return  q.getResultList();
    }
}
