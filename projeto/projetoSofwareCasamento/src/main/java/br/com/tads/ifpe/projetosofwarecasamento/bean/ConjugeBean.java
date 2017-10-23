/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.repository.ConjugeRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Conjuge;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Messages;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "conjugeBean")
@SessionScoped
public class ConjugeBean {

    private Conjuge conjuge;
    private List<Conjuge> listaConjuge;
    
    @EJB
    private ConjugeRepository conjugeRepository;
    
    @PostConstruct
    public void constroi(){
        conjuge = new Conjuge();
        
        listaConjuge = new ArrayList<>();
    }
    
    public Conjuge getConjuge() {
        return conjuge;
    }

    public void setConjuge(Conjuge conjuge) {
        this.conjuge = conjuge;
    }

    public List<Conjuge> getListaConjuge() {
        return listaConjuge;
    }

    public void setListaConjuge(List<Conjuge> listaConjuge) {
        this.listaConjuge = listaConjuge;
    }
    
    public void inserir(){
        
        try{
            
            conjugeRepository.inserir(conjuge);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            
            conjugeRepository.atualizar(conjuge);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            conjugeRepository.deletar(conjuge);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
        }catch(Exception ex){
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            conjuge = conjugeRepository.buscar(Integer.MIN_VALUE);
        }catch(Exception ex){
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            listaConjuge = conjugeRepository.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
