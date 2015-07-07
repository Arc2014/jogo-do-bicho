package br.com.jogo.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.UsuarioService;

@ManagedBean
@SessionScoped
public class LoginCtrl {

    @Inject
    private UsuarioService usuarioService;

    private String senha;

    private String login;

    public void efetuarLogin(){
        Usuario u = usuarioService.getUsuario(login, senha);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
    }

    public static void efetuarLogout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
