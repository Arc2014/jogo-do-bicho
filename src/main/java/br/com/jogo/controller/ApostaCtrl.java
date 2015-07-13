package br.com.jogo.controller;

import br.com.jogo.model.Aposta;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.ApostaService;
import br.com.jogo.service.RelatorioApostasService;
import br.com.jogo.to.RelatorioMilharCentenaTO;
import br.com.jogo.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ApostaCtrl implements Serializable{

    @Inject
    private ApostaService apostaService;

    @Inject
    private RelatorioApostasService relatorioApostasService;

    @Inject
    private Aposta aposta;

    private List<RelatorioMilharCentenaTO> relatorioMilharCentenaTOs;

    @PostConstruct
    public void carregarRelatorio () {
        setRelatorioMilharCentenaTOs(relatorioApostasService.montarRelatorioApostasMilharCentena());
    }

    public void save() {
        try {
            if (!aposta.isApostaInvalida()){
                apostaService.save(aposta);
                carregarRelatorio();
                aposta = new Aposta();
                FacesUtil.mostrarMensagemSucesso("mensagem.sucesso.salvar.aposta");
            } else {
                FacesUtil.mostrarMensagemErro("mensagem.erro.aposta.invalida");
            }
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

    public List<RelatorioMilharCentenaTO> getRelatorioMilharCentenaTOs() {
        return relatorioMilharCentenaTOs;
    }

    public void setRelatorioMilharCentenaTOs(List<RelatorioMilharCentenaTO> relatorioMilharCentenaTOs) {
        this.relatorioMilharCentenaTOs = relatorioMilharCentenaTOs;
    }
}
