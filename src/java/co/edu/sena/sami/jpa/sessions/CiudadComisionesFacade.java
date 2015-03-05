/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.CiudadComisiones;
import co.edu.sena.sami.jpa.entities.Comisiones;
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
public class CiudadComisionesFacade extends AbstractFacade<CiudadComisiones> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadComisionesFacade() {
        super(CiudadComisiones.class);
    }
    
    public List<CiudadComisiones>findByDestinos(Comisiones comisiones){
    
        Query q= getEntityManager().createNamedQuery("CiudadComisiones.findByIdComision");
        q.setParameter("idComision", comisiones.getIdComision());
        return q.getResultList();
    }
    
}