/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.model.Usuario;
import br.com.tads.ifpe.projetosofwarecasamento.repository.UsuarioRepository;
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
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
    
    private Usuario usuario;
    private List<Usuario> listaUsuario;
    
    @EJB
    private UsuarioRepository usuarioRepository;
    
    @PostConstruct
    public void constroi(){
        usuario = new Usuario();
        
        listaUsuario = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
 
    public void inserir(){
        
        try{
            
            usuarioRepository.inserir(usuario);
            
            Messages.addGlobalInfo("cadastrado com sucesso!");
            
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void atualizar(){
        
        try{
            
            usuarioRepository.atualizar(usuario);
            
            Messages.addGlobalInfo("atualizado com sucesso!");
            
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void deletar(){
        
        try{
            
            usuarioRepository.deletar(usuario);
            
            Messages.addGlobalInfo("Deletado com sucesso!");
            
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void buscar(){
        
        try{
            
            usuarioRepository.buscar(Integer.MIN_VALUE);
            
        }catch(Exception ex){
            
            Messages.addGlobalError("Ocorreu algum erro.");
            ex.printStackTrace();
        }
    }
    
    public void listar(){
        
        try{
            
            listaUsuario = usuarioRepository.listar();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
