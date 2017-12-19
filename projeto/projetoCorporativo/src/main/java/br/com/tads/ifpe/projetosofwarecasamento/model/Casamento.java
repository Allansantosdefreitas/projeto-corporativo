package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_casamento")
@NamedQuery(name = "Casamento.findAll", query = "SELECT c FROM Casamento c")
public class Casamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCasamento;

    private String nome;

    //bi-directional many-to-one association to Tarefa
    @OneToMany(mappedBy = "casamento", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> tarefas;

    //one-to-one association to Despesa
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_despesa", referencedColumnName = "idDespesa")
    private Despesa despesa;

    //bi-directional many-to-one association to Conjuge
    @OneToMany(mappedBy = "casamento", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Conjuge> conjuges;

    //bi-directional many-to-one association to Convidado
    @OneToMany(mappedBy = "casamento", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Convidado> convidados;

    //one-to-one association to Convite
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_convite", referencedColumnName = "idConvite")
    private Convite convite;
    
    private String codigo;

    public Casamento() {
    }
    
    @PrePersist
    private void gerarCodigo() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        setCodigo(Base64.getEncoder().encodeToString(randomBytes));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getIdCasamento() {
        return this.idCasamento;
    }

    public void setIdCasamento(Integer idCasamento) {
        this.idCasamento = idCasamento;
    }

    public List<Conjuge> getConjuges() {
        return this.conjuges;
    }

    public void setConjuges(List<Conjuge> conjuges) {
        this.conjuges = conjuges;
    }

    public Conjuge addConjuge(Conjuge conjuge) {
        this.getConjuges().add(conjuge);
        conjuge.setCasamento(this);

        return conjuge;
    }

    public Conjuge removeConjuge(Conjuge conjuge) {
        this.getConjuges().remove(conjuge);
        conjuge.setCasamento(null);

        return conjuge;
    }

    public List<Convidado> getConvidados() {
        return this.convidados;
    }

    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }

    public Convidado addConvidado(Convidado convidado) {
        this.getConvidados().add(convidado);
        convidado.setCasamento(this);

        return convidado;
    }

    public Convidado removeConvidado(Convidado convidado) {
        this.getConvidados().remove(convidado);
        convidado.setCasamento(null);

        return convidado;
    }

    public List<Tarefa> getTarefas() {
        return this.tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Tarefa addTarefa(Tarefa tarefa) {
        this.getTarefas().add(tarefa);
        tarefa.setCasamento(this);

        return tarefa;
    }

    public Tarefa removeTarefa(Tarefa tarefa) {
        this.getTarefas().remove(tarefa);
        tarefa.setCasamento(null);

        return tarefa;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public Convite getConvite() {
        return convite;
    }

    public void setConvite(Convite convite) {
        this.convite = convite;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
