/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jpa.entities.Usuarios;
import co.edu.sena.sami.jpa.entities.UsuariosContratos;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Adsim
 */
@Stateless
public class UsuariosContratosFacade extends AbstractFacade<UsuariosContratos> {

    @PersistenceContext(unitName = "SAMIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosContratosFacade() {
        super(UsuariosContratos.class);
    }

    public UsuariosContratos findByIdContrato(Contratos contrato) {
        Query q = getEntityManager().createNamedQuery("UsuariosContratos.findByIdContrato");
        q.setParameter("idContrato", contrato.getIdContrato());
        try {
            return (UsuariosContratos) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public UsuariosContratos findByIdUsuario(Usuarios usuarios) {
        Query q = getEntityManager().createNamedQuery("UsuariosContratos.findByUsuarioFecha");
        q.setParameter("idUsuario", usuarios);
        q.setParameter("fechaActual", new Date(), TemporalType.DATE);
        try {
            return (UsuariosContratos) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
