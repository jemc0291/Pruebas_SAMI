/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.PagosContratos;
import java.util.Date;
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
public class PagosContratosFacade extends AbstractFacade<PagosContratos> {
    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagosContratosFacade() {
        super(PagosContratos.class);
    }
    public PagosContratos findByIdPago(int idPago) {
        Query q = getEntityManager().createNamedQuery("PagosContratos.findByIdPago");
        q.setParameter("idPago", idPago);
        try {
            return (PagosContratos) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    public List<PagosContratos> rangoFechas(Date fechaInicio, Date fechaFin) {
        Query q = getEntityManager().createNamedQuery("PagosContratos.findByFechaFactura");
        q.setParameter("fechaInicio", fechaInicio);
        q.setParameter("fechaFin", fechaFin);
        return q.getResultList();

    }
}
