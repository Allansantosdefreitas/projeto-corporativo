package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONJUGE;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONVIDADO;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.PROFISSIONAL;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@DeclareRoles({CONJUGE, PROFISSIONAL, CONVIDADO})
public class TarefaRepository extends Repository<Tarefa> {

    public TarefaRepository() {
        super(Tarefa.class);
    }

    public List<Tarefa> listarTarefaPorId(Integer idCasamento) {
        
        String sql = "From Tarefa c WHERE c.casamento = ?1";
        
        Query query = getEntityManager().createQuery(sql);
        query.setParameter(1, idCasamento);
        
        return query.getResultList();
    }
    
}
