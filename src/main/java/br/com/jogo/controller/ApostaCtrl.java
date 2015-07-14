package br.com.jogo.controller;

import br.com.jogo.model.Aposta;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.ApostaService;
import br.com.jogo.service.MediaService;
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
import java.util.Collections;
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

    private void tocarAlarme (){
        for (RelatorioMilharCentenaTO relatorioMilharCentenaTO : relatorioMilharCentenaTOs) {
            if (relatorioMilharCentenaTO.getNumero().equals(aposta.getNumero()) && aposta.getValorApostaPrimeiroPremio() > 0) {
                MediaService.play();
            }
            if (aposta.isApostaValorSperior10()) {
                MediaService.play();
            }
        }
    }

    public void save() {
        try {
            if (!aposta.isApostaInvalida()){
                apostaService.save(aposta);
                tocarAlarme();
                carregarRelatorio();
                aposta = new Aposta();
            } else {
                FacesUtil.mostrarDialogMensagemErro("mensagem.erro.aposta.invalida");
            }
        } catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.salvar.aposta");
        }
    }

    public void apagarApostas () {
        try {
            apostaService.apagarApostas();
            relatorioMilharCentenaTOs = Collections.emptyList();
            FacesUtil.mostrarMensagemSucesso("mensagem.sucesso.apagar.apostas");
        }catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.apagar.apostas");
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
