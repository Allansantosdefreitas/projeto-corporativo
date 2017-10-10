/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import br.com.tads.ifpe.projetosofwarecasamento.repository.TarefaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.omnifaces.util.Messages;

/**
 *
 * @author aluno
 */
@Stateless
public class TarefaBean {
    
    private Tarefa tarefa;
    private List<Tarefa> listaTarefa;
    
    @EJB
    private TarefaRepository tarefaRepository; 
    
    @PostConstruct
    public void constroi(){
        tarefa = new Tarefa();
        
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
    
    public void inserir(){
        
        try{
            
            tarefaRepository.inserir(tarefa);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            
            tarefaRepository.atualizar(tarefa);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            tarefaRepository.deletar(tarefa);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
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
}
