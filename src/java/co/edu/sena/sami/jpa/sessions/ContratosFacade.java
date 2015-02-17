/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.Contratos;
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
public class ContratosFacade extends AbstractFacade<Contratos> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratosFacade() {
        super(Contratos.class);
    }
    public Contratos findByNumeroDeContrato(int numeroDeContrato) {
        Query q = getEntityManager().createNamedQuery("Contratos.findByNumeroDeContrato");
        q.setParameter("numeroDeContrato", numeroDeContrato);
        try {
            return (Contratos) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    public List<Contratos> findByNumeroContratoCompletar(int numeroContrato){
        Query q = getEntityManager().createNamedQuery("Contratos.findByNumeroDeContrato");
        q.setParameter("numeroDeContrato", numeroContrato + "%");
        q.setMaxResults(10);
        return q.getResultList();
    }
     public List<Contratos> findByContratos(String Contratos){
     return getEntityManager().createNativeQuery("LOAD DATA INFILE : fileName INTO TABLE contratos ").setParameter("fileName", Contratos).getResultList();
     }
}
