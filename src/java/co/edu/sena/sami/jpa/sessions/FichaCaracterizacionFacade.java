/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.CentroFormacion;
import co.edu.sena.sami.jpa.entities.FichaCaracterizacion;
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
public class FichaCaracterizacionFacade extends AbstractFacade<FichaCaracterizacion> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichaCaracterizacionFacade() {
        super(FichaCaracterizacion.class);
    }
    
    public List<FichaCaracterizacion> findByNombre(String nombre) {
        Query q= getEntityManager().createNamedQuery("FichaCaracterizacion.findByCodigoFicha");
        q.setParameter("codigoFicha", "%" + nombre + "%");
        return q.getResultList();

    }
    
}
