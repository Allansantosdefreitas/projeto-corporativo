package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONJUGE;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONVIDADO;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.PROFISSIONAL;
import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.Convidado;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@DeclareRoles({CONJUGE, CONVIDADO})
public class ConvidadoRepository extends Repository<Convidado> {

    public ConvidadoRepository() {
        super(Convidado.class);
    }
    
    public List<Convidado> listarConvidadoPorCasamento(Casamento casamento){
        String sql = "From Convidado c WHERE c.casamento = ?1";
        
        Query query = getEntityManager().createQuery(sql);
        query.setParameter(1, casamento);
        
        return query.getResultList();
    }
}
