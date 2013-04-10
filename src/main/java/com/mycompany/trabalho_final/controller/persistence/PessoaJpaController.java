package com.mycompany.trabalho_final.controller.persistence;

import com.mycompany.trabalho_final.model.persistence.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PessoaJpaController extends JpaController {

    public PessoaJpaController() {
    }

    public void persist(Pessoa p) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            // todo
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Pessoa findByCpf(Long cpf) {
        Pessoa p = new Pessoa();
        EntityManager em = null;

        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
            Root<Pessoa> rt = cq.from(Pessoa.class);
            cq.where(cb.equal(rt.get("cpf"), cpf));
            TypedQuery<Pessoa> q = em.createQuery(cq);
            return q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /*public List<Pessoa> findAll() {
     EntityManager em = null;
     try {
     em = getEntityManager();
     CriteriaBuilder cb = em.getCriteriaBuilder();
     CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
     cq.from(Pessoa.class);
     TypedQuery<Pessoa> q = em.createQuery(cq);
     return q.getResultList();
     } finally {
     if (em != null) {
     em.close();
     }
     }
     }*/
}
