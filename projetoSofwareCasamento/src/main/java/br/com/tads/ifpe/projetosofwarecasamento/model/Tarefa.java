package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tarefa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarefa.findAll", query="SELECT t FROM Tarefa t")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarefa;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String descricao;

	private StatusTarefa status;

	private String titulo;

	//bi-directional many-to-one association to Casamento
	@ManyToOne(fetch=FetchType.EAGER)
	private Casamento casamento;

	//bi-directional many-to-one association to Servico
	@ManyToOne(fetch=FetchType.EAGER)
	private Servico servico;

	public Tarefa() {
	}

	public int getIdTarefa() {
		return this.idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusTarefa getStatus() {
		return this.status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Casamento getCasamento() {
		return this.casamento;
	}

	public void setCasamento(Casamento casamento) {
		this.casamento = casamento;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}