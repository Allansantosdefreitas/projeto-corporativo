/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.Papel;
import br.com.tads.ifpe.projetosofwarecasamento.repository.CasamentoRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
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
@ManagedBean(name = "casamentoBean")
@SessionScoped
public class CasamentoBean implements Serializable{
    
    private Conjuge noivo;
    private Conjuge noiva;
    private Casamento casamento;
    private List<Casamento> listaCasamento;
    private List<Conjuge> conjuges;
 
    @EJB
    private CasamentoRepository casamentoRepository;
    
    @EJB
    private GrupoRepository grupoRepository;
    
    @PostConstruct
    public void constroi(){
        casamento = new Casamento();
        
        noiva = new Conjuge();
        noivo = new Conjuge();
        
        conjuges = new ArrayList<>();
        listaCasamento = new ArrayList<>();
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

    public List<Conjuge> getConjuges() {
        return conjuges;
    }

    public void setConjuges(List<Conjuge> conjuges) {
        this.conjuges = conjuges;
    }
    
    
    public void inserir(){
        
        try{
            
            //Atribui os papéis
            noivo.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONJUGE}));
            noiva.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONJUGE}));
            
            //Adiciona na lista
            conjuges.add(noivo);
            conjuges.add(noiva);
            
            //Adiciona a lista no casamento
            casamento.setConjuges(conjuges);
            
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
//            casamento = casamentoRepository.buscar(Integer.MIN_VALUE);
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
