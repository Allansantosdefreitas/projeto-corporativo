package br.com.tads.ifpe.projetosofwarecasamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

public abstract class Repository<Entidade> {

    private EntityManagerFactory EMF = Persistence.createEntityManagerFactory("projetoSoftwareCasamentoPU");
    private EntityManager em = EMF.createEntityManager();

    private final Class<Entidade> classe;

    public EntityManager getEntityManager() {
        return em;
    }

    public Repository(Class<Entidade> classe) {
        this.classe = classe;
    }

    public void inserir(Entidade entidade) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();

            em.persist(entidade);

            et.commit();
        } catch (Exception ex) {
            System.out.println("Deu erro na inser��o");
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }

    public void atualizar(Entidade entidade) {
        em.merge(entidade);
    }

    public void deletar(Entidade entidade) {
        em.remove(em.merge(entidade));
    }

    public Entidade buscar(Integer idEntidade) {
        return em.find(classe, idEntidade);
    }

    @SuppressWarnings("unchecked")
    public List<Entidade> listar() {
        CriteriaQuery<Entidade> criteria = (CriteriaQuery<Entidade>) em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(classe));

        // return (List<Entidade>) em.createQuery("From " + classe + "
        // c").getResultList();
        return em.createQuery(criteria).getResultList();
    }

    protected List<Entidade> getEntidades(String nomeQuery) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeQuery, classe);
        return query.getResultList();
    }

    protected List<Entidade> getEntidades(String nomeQuery, Object[] parametros) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getResultList();
    }

    protected Entidade getEntidade(String nomeQuery, Object[] parametros) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getSingleResult();
    }
}
