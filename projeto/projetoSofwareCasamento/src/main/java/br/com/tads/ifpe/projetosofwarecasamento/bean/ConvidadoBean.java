/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.repository.ConvidadoRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Convidado;
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
@ManagedBean(name = "convidadoBean")
@SessionScoped
public class ConvidadoBean {
    
    private Convidado convidado;
    private List<Convidado> listaConvidado;
    
    @EJB
    private ConvidadoRepository convidadoRepository;
    
    @PostConstruct
    public void constroi(){
        convidado = new Convidado();
        
        listaConvidado = new ArrayList<>();
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public List<Convidado> getListaConvidado() {
        return listaConvidado;
    }

    public void setListaConvidado(List<Convidado> listaConvidado) {
        this.listaConvidado = listaConvidado;
    }
    
    public void inserir(){
        
        try{
            
            convidadoRepository.inserir(convidado);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            convidadoRepository.atualizar(convidado);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            convidadoRepository.deletar(convidado);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            convidado = convidadoRepository.buscar(Integer.MIN_VALUE);
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            
            listaConvidado = convidadoRepository.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
