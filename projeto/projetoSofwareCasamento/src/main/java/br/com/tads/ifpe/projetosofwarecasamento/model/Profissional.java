package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profissional database table.
 * 
 */
@Entity
@Table(name = "TB_profissional")
@DiscriminatorValue(value = "PROF")
@PrimaryKeyJoinColumn(name = "idUsuarioProfissional", referencedColumnName = "idUsuario")
@NamedQuery(name="Profissional.findAll", query="SELECT p FROM Profissional p")
public class Profissional extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

        
	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="profissional", fetch = FetchType.LAZY, 
                cascade = CascadeType.ALL, orphanRemoval = true)
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
		this.getServicos().add(servico);
		servico.setProfissional(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		this.getServicos().remove(servico);
		servico.setProfissional(null);

		return servico;
	}

}