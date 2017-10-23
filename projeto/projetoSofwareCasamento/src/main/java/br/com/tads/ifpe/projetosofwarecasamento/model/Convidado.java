package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the convidado database table.
 * 
 */
@Entity
@DiscriminatorValue(value = "con")
@PrimaryKeyJoinColumn(name = "idUsuarioProfissional", referencedColumnName = "idUsuario")
@NamedQuery(name="Convidado.findAll", query="SELECT c FROM Convidado c")
public class Convidado extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idUsuarioProfissional;

	private StatusConvidado statusConvidado;

	//bi-directional many-to-one association to Casamento
	@ManyToOne(fetch=FetchType.EAGER)
	private Casamento casamento;

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