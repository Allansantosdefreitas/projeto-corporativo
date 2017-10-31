/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.Papel;
import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.repository.ConjugeRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Conjuge;
import br.com.tads.ifpe.projetosofwarecasamento.repository.GrupoRepository;
import java.io.Serializable;
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
public class ConjugeBean implements Serializable{

    private Conjuge conjuge;
    private Conjuge noivo;
    private Conjuge noiva;
    private List<Conjuge> listaConjuge;
    
    @EJB
    private ConjugeRepository conjugeRepository;
    
    @EJB
    private GrupoRepository grupoRepository;
    
    @PostConstruct
    public void constroi(){
        conjuge = new Conjuge();
        noivo = new Conjuge();
        noiva = new Conjuge();
        
        listaConjuge = new ArrayList<>();
    }
    
    public Conjuge getConjuge() {
        return conjuge;
    }

    public void setConjuge(Conjuge conjuge) {
        this.conjuge = conjuge;
    }

    public Conjuge getNoivo() {
        return noivo;
    }

    public void setNoivo(Conjuge noivo) {
        this.noivo = noivo;
    }

    public Conjuge getNoiva() {
        return noiva;
    }

    public void setNoiva(Conjuge noiva) {
        this.noiva = noiva;
    }

    public List<Conjuge> getListaConjuge() {
        return listaConjuge;
    }

    public void setListaConjuge(List<Conjuge> listaConjuge) {
        this.listaConjuge = listaConjuge;
    }
    
    public void inserir(){
        
        try{
            
            //Adiciona os conjuges na lista
            listaConjuge.add(noivo);
            listaConjuge.add(noiva);
            
            //Salva os conjuges no casamento
            Casamento casamento = new Casamento();
            casamento.setConjuges(listaConjuge);
            
            //Salva o casamento nos conjuges
            noivo.setCasamento(casamento);
            noiva.setCasamento(casamento);
            
            //Atribui os papéis
            noivo.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONJUGE}));
            noiva.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONJUGE}));
            
            //Insere os conjuges
            conjugeRepository.inserir(noivo);
            conjugeRepository.inserir(noiva);
            
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
