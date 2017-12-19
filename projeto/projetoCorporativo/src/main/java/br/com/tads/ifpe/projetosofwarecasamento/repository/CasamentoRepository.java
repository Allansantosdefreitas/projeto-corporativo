package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONJUGE;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONVIDADO;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.PROFISSIONAL;
import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
@DeclareRoles({CONJUGE, PROFISSIONAL, CONVIDADO})
public class CasamentoRepository extends Repository<Casamento> {

    public CasamentoRepository() {
        super(Casamento.class);
    }

    @PermitAll
    @Override
    public void inserir(Casamento entidade) {
        EntityManager em = getEntityManager();
        
        em.persist(entidade);
    }
    
    public Casamento buscarCasamentoPorCodigo(String codigo){
        String sql = "From Casamento c WHERE c.codigo = ?1";
        try{
            Query query = getEntityManager().createQuery(sql);
            query.setParameter(1, codigo);

            return (Casamento) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
