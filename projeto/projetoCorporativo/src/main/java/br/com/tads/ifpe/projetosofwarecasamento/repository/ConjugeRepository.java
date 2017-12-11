package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONJUGE;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.CONVIDADO;
import static br.com.tads.ifpe.projetosofwarecasamento.Papel.PROFISSIONAL;
import br.com.tads.ifpe.projetosofwarecasamento.model.Conjuge;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@DeclareRoles({CONJUGE, PROFISSIONAL, CONVIDADO})
public class ConjugeRepository extends Repository<Conjuge> {

    public ConjugeRepository() {
        super(Conjuge.class);
    }
    
    public Integer buscarCasamentoPorLogin(String login){
        
        String sql = "From Conjuge c inner join Usuario u ON c.idUsuario = u.idUsuario WHERE u.login = ?1";
        
        Query query = getEntityManager().createQuery(sql);
        query.setParameter(1, login);
        
        Conjuge conjuge = (Conjuge) query.getSingleResult();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Nome: " + conjuge.getNome());
        System.out.println("-------------------------------------------------------------------------------");
        return conjuge.getCasamento().getIdCasamento();
    }
}
