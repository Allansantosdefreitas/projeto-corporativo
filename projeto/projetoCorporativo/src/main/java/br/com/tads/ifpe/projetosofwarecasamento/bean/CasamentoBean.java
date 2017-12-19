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
import br.com.tads.ifpe.projetosofwarecasamento.model.Convidado;
import br.com.tads.ifpe.projetosofwarecasamento.model.StatusTarefa;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import br.com.tads.ifpe.projetosofwarecasamento.repository.ConvidadoRepository;
import br.com.tads.ifpe.projetosofwarecasamento.repository.GrupoRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    private List<Convidado> convidados;
    
    private int tarefasPendentes;
 
    @EJB
    private CasamentoRepository casamentoRepository;
    
    @EJB
    private GrupoRepository grupoRepository;
    
    @EJB
    private ConvidadoRepository convidadoRepository;
    
    @PostConstruct
    public void constroi(){
        casamento = new Casamento();
        
        noiva = new Conjuge();
        noivo = new Conjuge();
        
        conjuges = new ArrayList<>();
        listaCasamento = new ArrayList<>();
        
        if(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("conjuge")){
            carregaCasamento();
            calculaTarefasPendentes();
            listarConvidados();
        }
    }

    private void calculaTarefasPendentes(){
       
        List<Tarefa> listaTarefas = casamento.getTarefas();
        
        for(Tarefa tarefa: listaTarefas){
            
            if(tarefa.getStatus().equals(StatusTarefa.PENDENTE)){
                tarefasPendentes++;
            }
        }   
    }
    
    private void carregaCasamento(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Integer idCasamento = (Integer) session.getAttribute("idCasamento");
        
        this.casamento = casamentoRepository.buscar(idCasamento);
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

    public int getTarefasPendentes() {
        return tarefasPendentes;
    }

    public void setTarefasPendentes(int tarefasPendentes) {
        this.tarefasPendentes = tarefasPendentes;
    }

    public List<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }

    public void inserir(){
        
        try{
            
            //Atribui os papéis
            noivo.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONJUGE}));
            noiva.setGrupo(grupoRepository.getGrupo(new String[]{Papel.CONJUGE}));
            
            //Salva o casamento nos conjuges
            noivo.setCasamento(casamento);
            noiva.setCasamento(casamento);
            
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
    
    public void listarConvidados(){
        
        try{
            convidados = convidadoRepository.listarConvidadoPorCasamento(casamento);
        } catch(Exception ex){
            Messages.addGlobalError("Ocorreu algum erro ao tentar carregar os convidados.");
            ex.printStackTrace();
        }
    }
    
}
