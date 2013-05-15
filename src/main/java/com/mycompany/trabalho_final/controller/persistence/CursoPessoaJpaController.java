package com.mycompany.trabalho_final.controller.persistence;

import com.mycompany.trabalho_final.model.persistence.entity.Cursopessoa;
import com.mycompany.trabalho_final.model.persistence.entity.CursopessoaPK;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
public class CursoPessoaJpaController extends JpaController {

    public CursoPessoaJpaController() {
    }

    public void persist(Cursopessoa cp) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            // todo
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void update(Cursopessoa cp) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(cp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            // todo
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
   
    public boolean findByCpf(int id, Long cpf) {
        EntityManager em = null;

        try {
            CursopessoaPK cppk = new CursopessoaPK(id, cpf);
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cursopessoa> cq = cb.createQuery(Cursopessoa.class);
            Root<Cursopessoa> rt = cq.from(Cursopessoa.class);
            cq.where(cb.equal(rt.get("cursopessoaPK"), cppk));
            TypedQuery<Cursopessoa> q = em.createQuery(cq);
            return q.getSingleResult().getCursando();
        } catch (NoResultException ex) {
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
