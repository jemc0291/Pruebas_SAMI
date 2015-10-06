/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adsim
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
      public Usuarios findByNumeroDocumento(String Query) {
        Query q = getEntityManager().createNamedQuery("Usuarios.findByNumeroDoc");
        q.setParameter("numeroDoc", Query);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
     public List<Usuarios> findByNumeroDoc(String numeroDoc) {
        Query q= getEntityManager().createNamedQuery("Usuarios.findByNumeroDoc");
        q.setParameter("numeroDoc", numeroDoc + "%");
        return q.getResultList();

    }
    public List<Usuarios> findByRazonSocialCompletar(String razonSocial) {
        Query q = getEntityManager().createNamedQuery("Usuarios.findByRazonSocial");
        q.setParameter("razonSocial", razonSocial + "%");
        //q.setMaxResults(10);
        return q.getResultList();
    }

    public List<Usuarios> findByPrimerNombreCompletar(String primerNombre) {
        Query q = getEntityManager().createNamedQuery("Usuarios.findByPrimerNombre");
        q.setParameter("primerNombre", primerNombre + "%");
//        //q.setMaxResults(10);
        return q.getResultList();
    }
}
