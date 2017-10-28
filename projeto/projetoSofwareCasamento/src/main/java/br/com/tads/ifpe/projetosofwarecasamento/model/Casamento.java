package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TB_casamento")
@NamedQuery(name="Casamento.findAll", query="SELECT c FROM Casamento c")
public class Casamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCasamento;

	//bi-directional many-to-one association to Tarefa
	@OneToMany(mappedBy="casamento", fetch = FetchType.LAZY, 
                cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tarefa> tarefas;

        //one-to-one association to Despesa
        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
        @JoinColumn(name = "ID_despesa", referencedColumnName = "idDespesa")
        private Despesa despesa;
        
	//bi-directional many-to-one association to Conjuge
	@OneToMany(mappedBy="casamento", fetch = FetchType.LAZY, 
                cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Conjuge> conjuges;

	//bi-directional many-to-one association to Convidado
	@OneToMany(mappedBy="casamento",  fetch = FetchType.LAZY,
                cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Convidado> convidados;
        
        //one-to-one association to Convite
        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
        @JoinColumn(name = "ID_convite", referencedColumnName = "idConvite")
        private Convite convite;

	public Casamento() {
	}

	public Long getIdCasamento() {
		return this.idCasamento;
	}

	public void setIdCasamento(Long idCasamento) {
		this.idCasamento = idCasamento;
	}

	

//	public List<Conjuge> getConjuges() {
//		return this.conjuges;
//	}
//
//	public void setConjuges(List<Conjuge> conjuges) {
//		this.conjuges = conjuges;
//	}

//	public Conjuge addConjuge(Conjuge conjuge) {
//		getConjuges().add(conjuge);
//		conjuge.setCasamento(this);
//
//		return conjuge;
//	}
//
//	public Conjuge removeConjuge(Conjuge conjuge) {
//		getConjuges().remove(conjuge);
//		conjuge.setCasamento(null);
//
//		return conjuge;
//	}

//	public List<Convidado> getConvidados() {
//		return this.convidados;
//	}
//
//	public void setConvidados(List<Convidado> convidados) {
//		this.convidados = convidados;
//	}

//	public Convidado addConvidado(Convidado convidado) {
//		getConvidados().add(convidado);
//		convidado.setCasamento(this);
//
//		return convidado;
//	}
//
//	public Convidado removeConvidado(Convidado convidado) {
//		getConvidados().remove(convidado);
//		convidado.setCasamento(null);
//
//		return convidado;
//	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

//	public Tarefa addTarefa(Tarefa tarefa) {
//		getTarefas().add(tarefa);
//		tarefa.setCasamento(this);
//
//		return tarefa;
//	}
//
//	public Tarefa removeTarefa(Tarefa tarefa) {
//		getTarefas().remove(tarefa);
//		tarefa.setCasamento(null);
//
//		return tarefa;
//	}
//
//	public Convite getConvite() {
//		return this.convite;
//	}
//
//	public void setConvite(Convite convite) {
//		this.convite = convite;
//	}

}