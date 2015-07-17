package br.com.jogo.controller;

import br.com.jogo.model.Aposta;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.ApostaService;
import br.com.jogo.service.MediaService;
import br.com.jogo.service.RelatorioApostasService;
import br.com.jogo.to.RelatorioMilharCentenaTO;
import br.com.jogo.to.ResultadoTO;
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
import java.util.ArrayList;
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

    @Inject
    private ResultadoTO resultadoTO;

    private List<RelatorioMilharCentenaTO> relatorioMilharCentenaTOs;

    private List<Aposta> apostas;

    private List<Aposta> apostasPremiadas;

    @PostConstruct
    public void carregarRelatorio () {
        setRelatorioMilharCentenaTOs(relatorioApostasService.montarRelatorioApostasMilharCentena());
        setApostas(carregarApostas());
    }

    public List<Aposta> carregarApostas() {
        try {
            return apostaService.listarApostas();
        } catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.carregar.apostas");
            return Collections.emptyList();
        }
    }

    public void apagarAposta(Aposta aposta){
        try {
            apostaService.apagarAposta(aposta);
            carregarRelatorio();
            FacesUtil.mostrarMensagemSucesso("mensagem.sucesso.apagar.aposta");
        } catch (Exception e) {
            FacesUtil.mostrarMensagemSucesso("mensagem.erro.apagar.apostas");
        }
    }

    private void tocarAlarme (){
        for (RelatorioMilharCentenaTO relatorioMilharCentenaTO : relatorioMilharCentenaTOs) {
            if (relatorioMilharCentenaTO.getNumero().equals(aposta.getNumero()) && aposta.getValorApostaPrimeiroPremio() != null && aposta.getValorApostaPrimeiroPremio() > 0) {
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
                carregarApostas();
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
            apostas = Collections.emptyList();
            FacesUtil.mostrarMensagemSucesso("mensagem.sucesso.apagar.apostas");
        }catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.apagar.apostas");
        }
    }

    public void buscarResultadoApostas(){

        try {
            resultadoTO = apostaService.buscarApostasPremiadas(resultadoTO);
        } catch (Exception e) {
            FacesUtil.mostrarMensagemErro("mensagem.erro.carregar.premios");
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

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }

    public ResultadoTO getResultadoTO() {
        return resultadoTO;
    }

    public void setResultadoTO(ResultadoTO resultadoTO) {
        this.resultadoTO = resultadoTO;
    }

}
