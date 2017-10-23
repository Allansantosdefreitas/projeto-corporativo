/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.repository.ProfissionalRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Profissional;
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
public class ProfissionalBean {
    
    private Profissional profissional;
    private List<Profissional>listaProfissional;
    
    @EJB
    private ProfissionalRepository profissionalRepository;
    
    @PostConstruct
    public void constroi(){
        profissional = new Profissional();
        
        listaProfissional = new ArrayList<>();
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public List<Profissional> getListaProfissional() {
        return listaProfissional;
    }

    public void setListaProfissional(List<Profissional> listaProfissional) {
        this.listaProfissional = listaProfissional;
    }
    
    
    public void inserir(){
        
        try{
            
            profissionalRepository.inserir(profissional);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            
            profissionalRepository.atualizar(profissional);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            profissionalRepository.deletar(profissional);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            
            profissional = profissionalRepository.buscar(Integer.MIN_VALUE);
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            
            listaProfissional = profissionalRepository.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
