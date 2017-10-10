/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.repository.CasamentoRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
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
public class CasamentoBean {
    
    private Casamento casamento;
    private List<Casamento> listaCasamento;
 
    @EJB
    private CasamentoRepository casamentoRepository;
    
    @PostConstruct
    public void constroi(){
        casamento = new Casamento();
        
        listaCasamento = new ArrayList<>();
    }

    public Casamento getCasamento() {
        return casamento;
    }

    public void setCasamento(Casamento casamento) {
        this.casamento = casamento;
    }

    public List<Casamento> getListaCasamento() {
        return listaCasamento;
    }

    public void setListaCasamento(List<Casamento> listaCasamento) {
        this.listaCasamento = listaCasamento;
    }
    
    
    public void inserir(){
        
        try{
            
            casamentoRepository.inserir(casamento);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            
            casamentoRepository.atualizar(casamento);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            casamentoRepository.deletar(casamento);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            casamento = casamentoRepository.buscar(Integer.MIN_VALUE);
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            
            listaCasamento = casamentoRepository.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
