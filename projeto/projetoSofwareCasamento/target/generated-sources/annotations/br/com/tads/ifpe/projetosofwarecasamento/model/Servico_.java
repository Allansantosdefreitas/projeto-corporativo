package br.com.tads.ifpe.projetosofwarecasamento.model;

import br.com.tads.ifpe.projetosofwarecasamento.model.Profissional;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-29T13:26:19")
@StaticMetamodel(Servico.class)
public class Servico_ { 

    public static volatile SingularAttribute<Servico, Float> preco;
    public static volatile SingularAttribute<Servico, Boolean> statusDisponibilizado;
    public static volatile ListAttribute<Servico, Tarefa> tarefas;
    public static volatile SingularAttribute<Servico, Long> idServico;
    public static volatile SingularAttribute<Servico, String> titulo;
    public static volatile SingularAttribute<Servico, Profissional> profissional;
    public static volatile SingularAttribute<Servico, String> descricao;

}