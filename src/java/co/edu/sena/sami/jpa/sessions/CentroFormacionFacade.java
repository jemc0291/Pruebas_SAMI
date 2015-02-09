/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.CentroFormacion;
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
public class CentroFormacionFacade extends AbstractFacade<CentroFormacion> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroFormacionFacade() {
        super(CentroFormacion.class);
    }
    
     public List<CentroFormacion> findByNombre(String nombre) {
        Query q= getEntityManager().createNamedQuery("CentroFormacion.findByNombreCentroFormacion");
        q.setParameter("nombreCentroFormacion", nombre + "%");
        return q.getResultList();

    }
    
}
