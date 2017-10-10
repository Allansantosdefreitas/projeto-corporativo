package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profissional database table.
 * 
 */
@Entity
@DiscriminatorValue(value = "pro")
@PrimaryKeyJoinColumn(name = "idUsuarioProfissional", referencedColumnName = "idUsuario")
@NamedQuery(name="Profissional.findAll", query="SELECT p FROM Profissional p")
public class Profissional extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idUsuarioProfissional;

	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="profissional")
	private List<Servico> servicos;

	public Profissional() {
	}

//	public int getIdUsuarioProfissional() {
//		return this.idUsuarioProfissional;
//	}
//
//	public void setIdUsuarioProfissional(int idUsuarioProfissional) {
//		this.idUsuarioProfissional = idUsuarioProfissional;
//	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setProfissional(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setProfissional(null);

		return servico;
	}

}