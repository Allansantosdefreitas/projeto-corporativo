package br.com.tads.ifpe.projetosofwarecasamento.model;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.Servico;
import br.com.tads.ifpe.projetosofwarecasamento.model.StatusTarefa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-29T13:26:19")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ { 

    public static volatile SingularAttribute<Tarefa, Date> data;
    public static volatile SingularAttribute<Tarefa, String> titulo;
    public static volatile SingularAttribute<Tarefa, Long> idTarefa;
    public static volatile SingularAttribute<Tarefa, Servico> servico;
    public static volatile SingularAttribute<Tarefa, Casamento> casamento;
    public static volatile SingularAttribute<Tarefa, String> descricao;
    public static volatile SingularAttribute<Tarefa, StatusTarefa> status;

}