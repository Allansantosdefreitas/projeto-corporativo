package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conjuge database table.
 * 
 */
@Entity
@DiscriminatorValue(value = "con")
@PrimaryKeyJoinColumn(name = "idUsuarioProfissional", referencedColumnName = "idUsuario")
@NamedQuery(name="Conjuge.findAll", query="SELECT c FROM Conjuge c")
public class Conjuge extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idUsuarioProfissional;

	//bi-directional many-to-one association to Casamento
	@ManyToOne(fetch=FetchType.EAGER)
	private Casamento casamento;

	public Conjuge() {
	}

//	public int getIdUsuarioProfissional() {
//		return this.idUsuarioProfissional;
//	}
//
//	public void setIdUsuarioProfissional(int idUsuarioProfissional) {
//		this.idUsuarioProfissional = idUsuarioProfissional;
//	}

	public Casamento getCasamento() {
		return this.casamento;
	}

	public void setCasamento(Casamento casamento) {
		this.casamento = casamento;
	}

}