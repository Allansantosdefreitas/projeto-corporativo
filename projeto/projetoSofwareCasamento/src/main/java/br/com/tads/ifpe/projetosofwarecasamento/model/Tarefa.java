package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The persistent class for the tarefa database table.
 *
 */
@Entity
@Table(name = "TB_tarefa")
@NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t")
public class Tarefa implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @Column(name = "STR_titulo")
    private String titulo;

    @Column(name = "STR_descricao")
    private String descricao;

    @Column(name = "DTE_data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENM_status")
    private StatusTarefa status;

    //bi-directional many-to-one association to Casamento
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_casamento", referencedColumnName = "idCasamento")
    private Casamento casamento;

    //bi-directional many-to-one association to Servico
    @ManyToOne(fetch = FetchType.EAGER, optional = true) // Tarefa não precisa ter um serviço
    @JoinColumn(name = "ID_servico", referencedColumnName = "idServico")
    private Servico servico;

    public Tarefa() {
    }

    public Long getIdTarefa() {
        return this.idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idTarefa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.idTarefa, other.idTarefa)) {
            return false;
        }
        return true;
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

//	public Casamento getCasamento() {
//		return this.casamento;
//	}
//
//	public void setCasamento(Casamento casamento) {
//		this.casamento = casamento;
//	}
//
//	public Servico getServico() {
//		return this.servico;
//	}
//
//	public void setServico(Servico servico) {
//		this.servico = servico;
//	}
}
