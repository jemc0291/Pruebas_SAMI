/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.Polizas;
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
public class PolizasFacade extends AbstractFacade<Polizas> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PolizasFacade() {
        super(Polizas.class);
    }
    public Polizas findByNumeroDePoliza(String numeroDePoliza) {
        Query q = getEntityManager().createNamedQuery("Polizas.findByNumeroDePoliza");
        q.setParameter("numeroDePoliza", numeroDePoliza);
        try {
            return (Polizas) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
