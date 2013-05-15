package com.mycompany.trabalho_final.controller.persistence;

import com.mycompany.trabalho_final.model.persistence.entity.Administracao;
import com.mycompany.trabalho_final.model.persistence.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AdministracaoJpaController extends JpaController {

    public AdministracaoJpaController() {
    }

    public Administracao findByUsername(String username) {
        Administracao a = new Administracao();
        EntityManager em = null;

        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Administracao> cq = cb.createQuery(Administracao.class);
            Root<Administracao> rt = cq.from(Administracao.class);
            cq.where(cb.equal(rt.get("username"), username));
            TypedQuery<Administracao> q = em.createQuery(cq);
            return q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}