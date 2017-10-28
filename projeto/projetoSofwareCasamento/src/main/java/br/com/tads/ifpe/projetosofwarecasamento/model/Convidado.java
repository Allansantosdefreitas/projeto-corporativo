package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TB_convidado")
@DiscriminatorValue(value = "CONV")
@PrimaryKeyJoinColumn(name = "idUsuarioConvidado", referencedColumnName = "idUsuario")
@NamedQuery(name = "Convidado.findAll", query = "SELECT c FROM Convidado c")
public class Convidado extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private StatusConvidado statusConvidado;

    //bi-directional many-to-one association to Casamento
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_casamento", referencedColumnName = "idCasamento")
    private Casamento casamento;

    //unidirectional one-to-one association to Convite
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_convite", referencedColumnName = "idConvite")
    private Convite convite;

    public Convidado() {
    }

//	public int getIdUsuarioProfissional() {
//		return this.idUsuarioProfissional;
//	}
//
//	public void setIdUsuarioProfissional(int idUsuarioProfissional) {
//		this.idUsuarioProfissional = idUsuarioProfissional;
//	}
    public StatusConvidado getStatusConvidado() {
        return this.statusConvidado;
    }

    public void setStatusConvidado(StatusConvidado statusConvidado) {
        this.statusConvidado = statusConvidado;
    }

    public Casamento getCasamento() {
        return this.casamento;
    }

    public void setCasamento(Casamento casamento) {
        this.casamento = casamento;
    }

}
