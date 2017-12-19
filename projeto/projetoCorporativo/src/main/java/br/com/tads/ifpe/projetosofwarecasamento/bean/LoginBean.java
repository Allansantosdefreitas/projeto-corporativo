/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.bean;

import br.com.tads.ifpe.projetosofwarecasamento.model.Profissional;
import br.com.tads.ifpe.projetosofwarecasamento.repository.ConjugeRepository;
import br.com.tads.ifpe.projetosofwarecasamento.repository.ProfissionalRepository;
import br.com.tads.ifpe.projetosofwarecasamento.util.Recaptcha;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    
    @EJB
    private ConjugeRepository conjugeRepository;
    
    @EJB
    private ProfissionalRepository profissionalRepository;

    @NotBlank
    private String login;

    @NotBlank
    private String senha;
    private FacesContext facesContext;

    public String login() {

        try {

            facesContext = FacesContext.getCurrentInstance();
            Recaptcha recaptcha = new Recaptcha(facesContext);

            if (recaptcha.validar()) {
                HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
                request.login(login, senha);
                
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                
                session.setAttribute("loginUsuarioSessao", login);
                
                if(facesContext.getExternalContext().isUserInRole("conjuge")){
                    System.out.println("Encontrou a role de conjuge.");
                    Integer idCasamento = conjugeRepository.buscarCasamentoPorLogin(login);
                    session.setAttribute("idCasamento", idCasamento);

                    System.out.println("sessao casamento: " + session.getAttribute("idCasamento"));
                } else if(facesContext.getExternalContext().isUserInRole("profissional")){
                    
                    System.out.println("Encontrou a role de profissional.");
                    Profissional profissional = profissionalRepository.buscarPorLogin(login);
                    session.setAttribute("profissional", profissional);

                    System.out.println("sessao casamento: " + session.getAttribute("idCasamento"));
                }

                System.out.println("sessao usr: " + session.getAttribute("loginUsuarioSessao"));

//                EntityManager em = getEntityManager();
//                TypedQuery<Cliente> query = em.createNamedQuery("Cliente.PorLoginSQL");
                //query.setParameter(1, login);
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("LoginUsuarioSessao", login);
            } else {

                setLogin(null);
                adicionarMensagem("Captcha inválido!");

                return "falha";
            }

        } catch (ServletException ex) {

            ex.printStackTrace();
            setLogin(null);
            adicionarMensagem("Senha ou usuário inválidos!");

            return "falha";
        }

        return "sucesso";
    }

    private void adicionarMensagem(String mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
        facesContext.addMessage(null, message);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String usuario) {
        this.login = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
