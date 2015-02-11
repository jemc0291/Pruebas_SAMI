/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.SoportesDeDocumentos;
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
public class SoportesDeDocumentosFacade extends AbstractFacade<SoportesDeDocumentos> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoportesDeDocumentosFacade() {
        super(SoportesDeDocumentos.class);
    }
    public SoportesDeDocumentos findByIdSoporte(int idSoporte) {
        Query q = getEntityManager().createNamedQuery("SoportesDeDocumentos.findByIdSoporte");
        q.setParameter("idSoporte", idSoporte);
        try {
            return (SoportesDeDocumentos) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
