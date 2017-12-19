/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.Papel;
import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.repository.ConvidadoRepository;
import br.com.tads.ifpe.projetosofwarecasamento.model.Convidado;
import br.com.tads.ifpe.projetosofwarecasamento.model.StatusConvidado;
import br.com.tads.ifpe.projetosofwarecasamento.repository.CasamentoRepository;
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
@ManagedBean(name = "convidadoBean")
@SessionScoped
public class ConvidadoBean implements Serializable{
    
    private Convidado convidado;
    private Casamento casamento;
    private List<Convidado> listaConvidado;
    
    @EJB
    private ConvidadoRepository convidadoRepository;
    
    @EJB
    private GrupoRepository grupoRepository;
    
    @EJB
    private CasamentoRepository casamentoRepository;
    
    @PostConstruct
    public void constroi(){
        convidado = new Convidado();
        casamento = new Casamento();
        
        listaConvidado = new ArrayList<>();
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public Casamento getCasamento() {
        return casamento;
    }

    public void setCasamento(Casamento casamento) {
        this.casamento = casamento;
    }

    public List<Convidado> getListaConvidado() {
        return listaConvidado;
    }

    public void setListaConvidado(List<Convidado> listaConvidado) {
        this.listaConvidado = listaConvidado;
    }
    
    public void inserir(){
        
        try{

            casamento = casamentoRepository.buscarCasamentoPorCodigo(casamento.getCodigo());
            
            if(casamento == null){
                Messages.addGlobalError("O casamento com este código não existe.");
            }else{
            
                convidado.setCasamento(casamento);
                convidado.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONVIDADO}));
                convidado.setStatusConvidado(StatusConvidado.PENDENTE);

                convidadoRepository.inserir(convidado);

                Messages.addGlobalInfo("cadastrado com sucesso!");
            }
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
