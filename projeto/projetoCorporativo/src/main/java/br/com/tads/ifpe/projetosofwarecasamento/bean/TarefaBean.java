/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.model.StatusTarefa;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
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
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "tarefaBean")
@SessionScoped
public class TarefaBean implements Serializable{
    
    private String dataMarcada;
    
    private Tarefa tarefa;
    private List<Tarefa> listaTarefa;
    private StatusTarefa statusTarefa;
    
    @EJB
    private TarefaRepository tarefaRepository; 
    
    @PostConstruct
    public void constroi(){
        tarefa = new Tarefa();
        
        dataMarcada = new String();
        
        listaTarefa = new ArrayList<>();
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
    
    public StatusTarefa[] getStatusTarefas(){
        return StatusTarefa.values();
    }
    
    public void inserir(){
        
        try{
            
            setDataMarcada(dataMarcada);
            
            tarefaRepository.atualizar(tarefa);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(ActionEvent evento){
        
        tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaSelecionada"); // change
    }
    
    public void deletar(ActionEvent evento){
        
        tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaSelecionada"); // change
        
        try{
            
            tarefaRepository.deletar(tarefa);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
            
            constroi();
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            
            tarefa = tarefaRepository.buscar(Integer.MIN_VALUE);
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            
            listaTarefa = tarefaRepository.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void setDataMarcada(String dataMarcada) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = (Date)formatter.parse(dataMarcada);
        tarefa.setData(date);
    }
}
