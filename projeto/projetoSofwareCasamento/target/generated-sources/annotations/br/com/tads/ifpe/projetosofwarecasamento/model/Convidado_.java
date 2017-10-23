package br.com.tads.ifpe.projetosofwarecasamento.model;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.StatusConvidado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T11:42:35")
@StaticMetamodel(Convidado.class)
public class Convidado_ extends Usuario_ {

    public static volatile SingularAttribute<Convidado, StatusConvidado> statusConvidado;
    public static volatile SingularAttribute<Convidado, Casamento> casamento;

}