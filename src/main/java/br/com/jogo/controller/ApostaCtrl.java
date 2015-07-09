package br.com.jogo.controller;

import br.com.jogo.model.Aposta;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.ApostaService;
import br.com.jogo.util.FacesUtil;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class ApostaCtrl implements Serializable{

    @Inject
    private ApostaService apostaService;

    @Inject
    private Aposta aposta;

    public void save() {
        try {
            apostaService.save(aposta);
            aposta = new Aposta();
        } catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.salvar.aposta");
        }
    }

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }
}
