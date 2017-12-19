package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONJUGE;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONVIDADO;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.PROFISSIONAL;
import br.com.tads.ifpe.projetosofwarecasamento.model.Profissional;
import br.com.tads.ifpe.projetosofwarecasamento.model.Servico;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@DeclareRoles({CONJUGE, PROFISSIONAL, CONVIDADO})
public class ServicoRepository extends Repository<Servico> {

    public ServicoRepository() {
        super(Servico.class);
    }
    
    public List<Servico> listaServicosPorProfissional(Profissional profissional){
        String sql = "From Servico c WHERE c.profissional = ?1";
//        String sqlNativa = "SELECT * From tb_tarefa c WHERE c.ID_casamento = ?1";
        
        Query query = getEntityManager().createQuery(sql);
        query.setParameter(1, profissional);
        
        return query.getResultList();
    }
}
