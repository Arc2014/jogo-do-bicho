package br.com.jogo.controller;

import br.com.jogo.model.Aposta;
import br.com.jogo.model.Usuario;
import br.com.jogo.service.ApostaService;
import br.com.jogo.service.MediaService;
import br.com.jogo.service.RelatorioApostasService;
import br.com.jogo.to.RelatorioMilharCentenaTO;
import br.com.jogo.to.ResultadoTO;
import br.com.jogo.util.DataUtil;
import br.com.jogo.util.FacesUtil;
import br.com.jogo.util.ObjectUtil;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

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
import java.util.Date;
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

    private List<Aposta> ultimasApostasDuplicadas;

    @PostConstruct
    public void carregarRelatorio (){
        setRelatorioMilharCentenaTOs(relatorioApostasService.montarRelatorioApostasMilharCentena());
        setApostas(carregarApostas());
        setUltimasApostasDuplicadas(carregarUltimasApostas());
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
            if (MediaService.podeTocarAlarme(relatorioMilharCentenaTO, aposta)) {
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

    public void formatarPlanilha(Object o) {
        Date agora = new Date();
        HSSFWorkbook wb = (HSSFWorkbook) o;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        header.createCell(header.getLastCellNum() + 1).setCellValue("Data/Hora:");
        header.createCell(header.getLastCellNum()).setCellValue(DataUtil.formataDataPtBr(agora) + "--" + DataUtil.formataHoraPtBr(agora));
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        for (int i = 0; i < (header.getPhysicalNumberOfCells() - 2) ; i++) {
            header.getCell(i).setCellStyle(cellStyle);
        }

    }

    private List<Aposta> carregarUltimasApostas() {
        try {
            return apostaService.buscarUltimasApostas();
        } catch (Exception e) {
            return null;
        }
    }

    public int getProximaAposta () {
        return getApostas() == null ? 0 : (getApostas().size() + 1);
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

    public List<Aposta> getUltimasApostasDuplicadas() {
        return ultimasApostasDuplicadas;
    }

    public void setUltimasApostasDuplicadas(List<Aposta> ultimasApostasDuplicadas) {
        this.ultimasApostasDuplicadas = ultimasApostasDuplicadas;
    }
}
