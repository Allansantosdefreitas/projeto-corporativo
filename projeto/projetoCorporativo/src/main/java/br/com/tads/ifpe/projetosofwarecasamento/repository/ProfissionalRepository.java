package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONJUGE;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONVIDADO;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.PROFISSIONAL;
import br.com.tads.ifpe.projetosofwarecasamento.model.Conjuge;
import br.com.tads.ifpe.projetosofwarecasamento.model.Profissional;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@DeclareRoles({CONJUGE, PROFISSIONAL, CONVIDADO})
public class ProfissionalRepository extends Repository<Profissional> {

    public ProfissionalRepository() {
        super(Profissional.class);
    }
    
    public Profissional buscarPorLogin(String login){
        String sql = "From Profissional p inner join Usuario u ON p.idUsuario = u.idUsuario WHERE u.login = ?1";
        
        Query query = getEntityManager().createQuery(sql);
        query.setParameter(1, login);
        
        return (Profissional) query.getSingleResult();
    }
}
