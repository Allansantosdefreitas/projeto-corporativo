package br.com.tads.ifpe.projetosofwarecasamento.model;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T11:42:35")
@StaticMetamodel(Convite.class)
public class Convite_ { 

    public static volatile SingularAttribute<Convite, String> destinatarios;
    public static volatile SingularAttribute<Convite, String> mensagem;
    public static volatile SingularAttribute<Convite, Integer> idConvite;
    public static volatile SingularAttribute<Convite, Casamento> casamento;

}