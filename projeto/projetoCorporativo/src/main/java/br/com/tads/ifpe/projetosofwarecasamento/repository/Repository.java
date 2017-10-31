package br.com.tads.ifpe.projetosofwarecasamento.repository;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

public abstract class Repository<Entidade> {

    @PersistenceContext(unitName = "projetoSoftwareCasamentoPU")
    private EntityManager em;

    private final Class<Entidade> classe;

    public EntityManager getEntityManager() {
        return em;
    }

    public Repository(Class<Entidade> classe) {
        this.classe = classe;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(Entidade entidade) {

        em.persist(entidade);

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void atualizar(Entidade entidade) {
        em.merge(entidade);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deletar(Entidade entidade) {
        em.remove(em.merge(entidade));
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Entidade buscar(Integer idEntidade) {
        return em.find(classe, idEntidade);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @SuppressWarnings("unchecked")
    public List<Entidade> listar() {
        CriteriaQuery<Entidade> criteria = (CriteriaQuery<Entidade>) em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(classe));

        // return (List<Entidade>) em.createQuery("From " + classe + "
        // c").getResultList();
        return em.createQuery(criteria).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Entidade> getEntidades(String nomeQuery) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeQuery, classe);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Entidade> getEntidades(String nomeQuery, Object[] parametros) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Entidade getEntidade(String nomeQuery, Object[] parametros) {
        TypedQuery<Entidade> query = em.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getSingleResult();
    }
}
