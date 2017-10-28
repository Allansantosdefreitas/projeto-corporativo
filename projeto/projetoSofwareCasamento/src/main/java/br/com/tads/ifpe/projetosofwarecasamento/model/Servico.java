package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servico database table.
 * 
 */
@Entity
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idServico;
        
	private String titulo;

	private String descricao;

	private float preco;

	private Boolean statusDisponibilizado;

	//bi-directional many-to-one association to Profissional
	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_profissional", referencedColumnName = "idUsuarioProfissional")
	private Profissional profissional;

	//bi-directional many-to-one association to Tarefa
	@OneToMany(mappedBy="servico", fetch = FetchType.LAZY,
                cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Tarefa> tarefas;

	public Servico() {
	}

	public Long getIdServico() {
		return this.idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Boolean getStatusDisponibilizado() {
		return this.statusDisponibilizado;
	}

	public void setStatusDisponibilizado(Boolean statusDisponibilizado) {
		this.statusDisponibilizado = statusDisponibilizado;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Profissional getProfissional() {
		return this.profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

//	public Tarefa addTarefa(Tarefa tarefa) {
//		getTarefas().add(tarefa);
//		tarefa.setServico(this);
//
//		return tarefa;
//	}
//
//	public Tarefa removeTarefa(Tarefa tarefa) {
//		getTarefas().remove(tarefa);
//		tarefa.setServico(null);
//
//		return tarefa;
//	}

}