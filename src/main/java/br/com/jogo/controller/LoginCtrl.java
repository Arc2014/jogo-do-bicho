package br.com.jogo.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.UsuarioService;

import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginCtrl implements Serializable{

    @Inject
    private UsuarioService usuarioService;

    private String senha;
    private String login;
    private Usuario usuario;

    public void efetuarLogin() throws IOException{
        usuario = usuarioService.getUsuario(login, senha);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
        if(usuario != null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }

    public  void efetuarLogout() throws IOException{
        usuario = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
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

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean logado() {
        return usuario != null;
    }
}
