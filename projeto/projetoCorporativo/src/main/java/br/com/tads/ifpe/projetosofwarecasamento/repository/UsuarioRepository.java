package br.com.tads.ifpe.projetosofwarecasamento.repository;

import static br.com.tads.ifpe.projetosofwarecasamento.Papel.*;
import br.com.tads.ifpe.projetosofwarecasamento.model.Usuario;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

@Stateless
@DeclareRoles({CONJUGE, PROFISSIONAL, CONVIDADO})
public class UsuarioRepository extends Repository<Usuario> {

    public UsuarioRepository() {
        super(Usuario.class);
    }
}
