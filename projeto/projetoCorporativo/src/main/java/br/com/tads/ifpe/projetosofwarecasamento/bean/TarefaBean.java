/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.StatusTarefa;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import br.com.tads.ifpe.projetosofwarecasamento.repository.CasamentoRepository;
import br.com.tads.ifpe.projetosofwarecasamento.repository.TarefaRepository;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "tarefaBean")
@SessionScoped
public class TarefaBean implements Serializable {

    private String dataMarcada;

    private Tarefa tarefa;
    private List<Tarefa> listaTarefa;
    private StatusTarefa statusTarefa;
    private Casamento casamento;
    private Date data;

    @EJB
    private TarefaRepository tarefaRepository;

    @EJB
    private CasamentoRepository casamentoRepository;

    @PostConstruct
    public void constroi() {
        tarefa = new Tarefa();
        inicializaCasamento();
        dataMarcada = new String();

        listaTarefa = new ArrayList<>();
        
        listar();
    }
    
    private void inicializaCasamento(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Integer idCasamento = (Integer) session.getAttribute("idCasamento");
        
        System.out.println("IDCASAMENTO na tarefa: " + idCasamento);
        
        casamento = casamentoRepository.buscar(idCasamento);
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getListaTarefa() {
        return listaTarefa;
    }

    public void setListaTarefa(List<Tarefa> listaTarefa) {
        this.listaTarefa = listaTarefa;
    }

    public StatusTarefa getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(StatusTarefa statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public StatusTarefa[] getStatusTarefas() {
        return StatusTarefa.values();
    }
    
    public Date getData() {
        return data;
    }
 
    public void setData(Date data) {
        this.data = data;
    }

    public void inserir() {

        try {
            tarefa.setCasamento(casamento);

//            setDataMarcada(dataMarcada);
            tarefa.setData(data);

            tarefaRepository.atualizar(tarefa);

            Messages.addGlobalInfo("cadastrado com sucesso!");
            
            listar();
        } catch (Exception ex) {

            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }

    public void atualizar(ActionEvent evento) {

        tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaSelecionada"); // change
    }

    public void deletar(ActionEvent evento) {

        tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaSelecionada"); // change

        try {

            tarefaRepository.deletar(tarefa);

            Messages.addGlobalInfo("Deletado com sucesso!");

            constroi();
        } catch (Exception ex) {

            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }

    public void buscar() {

        try {

            tarefa = tarefaRepository.buscar(Integer.MIN_VALUE);
        } catch (Exception ex) {

            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }

    public void listar() {

        try {
            
            
            System.out.println("id do casamento no listar: " + casamento.getIdCasamento());
            listaTarefa = tarefaRepository.listarTarefaPorId(casamento);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setDataMarcada(String dataMarcada) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) formatter.parse(dataMarcada);
        tarefa.setData(date);
    }
    
    public String getDataMarcada(){
        return this.dataMarcada;
    }
    
    public void onDateSelect(SelectEvent event) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        Messages.addGlobalInfo("Data selecionada:", format.format(event.getObject()));
    }
}
