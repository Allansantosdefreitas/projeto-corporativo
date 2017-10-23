/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.model.Convite;
import br.com.tads.ifpe.projetosofwarecasamento.repository.ConviteRepository;
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
@ManagedBean(name = "conviteBean")
@SessionScoped
public class ConviteBean {
    
    private Convite convite;
    private List<Convite> listaConvite;
    
    @EJB
    private ConviteRepository conviteRepository;
    
    @PostConstruct
    public void constroi(){
        convite = new Convite();
        
        listaConvite = new ArrayList<>();
    }

    public Convite getConvite() {
        return convite;
    }

    public void setConvite(Convite convite) {
        this.convite = convite;
    }

    public List<Convite> getListaConvite() {
        return listaConvite;
    }

    public void setListaConvite(List<Convite> listaConvite) {
        this.listaConvite = listaConvite;
    }
    
    public void inserir(){
        
        try{
            
            conviteRepository.inserir(convite);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            
            conviteRepository.atualizar(convite);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            conviteRepository.deletar(convite);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            
            convite = conviteRepository.buscar(Integer.MIN_VALUE);
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            listaConvite = conviteRepository.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
