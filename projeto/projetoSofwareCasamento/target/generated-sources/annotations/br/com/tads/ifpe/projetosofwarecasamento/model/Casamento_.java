package br.com.tads.ifpe.projetosofwarecasamento.model;

import br.com.tads.ifpe.projetosofwarecasamento.model.Conjuge;
import br.com.tads.ifpe.projetosofwarecasamento.model.Convidado;
import br.com.tads.ifpe.projetosofwarecasamento.model.Convite;
import br.com.tads.ifpe.projetosofwarecasamento.model.Despesa;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-30T20:27:02")
@StaticMetamodel(Casamento.class)
public class Casamento_ { 

    public static volatile SingularAttribute<Casamento, Long> idCasamento;
    public static volatile ListAttribute<Casamento, Conjuge> conjuges;
    public static volatile SingularAttribute<Casamento, Despesa> despesa;
    public static volatile ListAttribute<Casamento, Tarefa> tarefas;
    public static volatile ListAttribute<Casamento, Convidado> convidados;
    public static volatile SingularAttribute<Casamento, String> nome;
    public static volatile SingularAttribute<Casamento, Convite> convite;

}