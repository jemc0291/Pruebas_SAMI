/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacen;
import co.edu.sena.sami.jpa.entities.SolicitudMaterialesAlmacenMateriales;
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
public class SolicitudMaterialesAlmacenMaterialesFacade extends AbstractFacade<SolicitudMaterialesAlmacenMateriales> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudMaterialesAlmacenMaterialesFacade() {
        super(SolicitudMaterialesAlmacenMateriales.class);
    }
    
    public List<SolicitudMaterialesAlmacenMateriales> findByIdSolicitud(SolicitudMaterialesAlmacen solicitud){
        Query q = getEntityManager().createNamedQuery("SolicitudMaterialesAlmacenMateriales.findByIdSolicitudMaterial");
        q.setParameter("idSolicitudMaterial", solicitud.getIdSolicitudMaterial());
        return q.getResultList();        
    }
    
}
