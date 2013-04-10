package com.mycompany.trabalho_final.controller.persistence;

import com.mycompany.trabalho_final.model.persistence.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
