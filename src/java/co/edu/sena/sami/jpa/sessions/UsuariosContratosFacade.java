/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sami.jpa.sessions;

import co.edu.sena.sami.jpa.entities.Contratos;
import co.edu.sena.sami.jpa.entities.UsuariosContratos;
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
    public List<UsuariosContratos> findByIdContratoSupervisor(Contratos contrato) {
        Query q = getEntityManager().createNamedQuery("UsuariosContratos.findByIdContrato");
        q.setParameter("idContrato", contrato.getIdContrato());
        try{
        return (List<UsuariosContratos>) q.getResultList();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public UsuariosContratos findByIdRol(Contratos c){//Metodo para buscar los contratos donde el Id rol sea 2
        Query q = getEntityManager().createNamedQuery("UsuariosContratos.findByIdRol");
        q.setParameter("idRol", 2);
        q.setParameter("idContrato", c.getIdContrato());
        try{
        return (UsuariosContratos) q.getSingleResult();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public UsuariosContratos findByIdRolContratista(Contratos c){//Metodo para buscar los contratos donde el Id rol sea 1
        Query q = getEntityManager().createNamedQuery("UsuariosContratos.findByIdRol");
        q.setParameter("idRol", 1);
        q.setParameter("idContrato", c.getIdContrato());
        try{
        return (UsuariosContratos) q.getSingleResult();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
