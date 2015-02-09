/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.DatosOnbase;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adsim
 */
@Stateless
public class DatosOnbaseFacade extends AbstractFacade<DatosOnbase> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosOnbaseFacade() {
        super(DatosOnbase.class);
    }
    
     public List<DatosOnbase> findByDatosOnBase(String datosOnBase) {
        return getEntityManager().createNativeQuery("LOAD DATA INFILE :fileName INTO TABLE datos_onbase").setParameter("fileName", datosOnBase).getResultList();

    }

}
