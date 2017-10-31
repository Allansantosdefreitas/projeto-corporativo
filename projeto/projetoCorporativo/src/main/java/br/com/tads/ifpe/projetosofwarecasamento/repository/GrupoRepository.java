package br.com.tads.ifpe.projetosofwarecasamento.repository;

import br.com.tads.ifpe.projetosofwarecasamento.model.Grupo;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
public class GrupoRepository extends Repository<Grupo> {

    public GrupoRepository() {
        super(Grupo.class);
    }
    
    @PermitAll
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Grupo getGrupo(String[] grupos) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g WHERE g.strNome = ?1", Grupo.class);

            int i = 1;
            for (String grupo : grupos) {
                query.setParameter(i++, grupo);
            }

            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
}
}
