package br.com.jogo.service;

import br.com.jogo.dao.ApostaDAO;
import br.com.jogo.model.Aposta;
import br.com.jogo.to.RelatorioMilharCentenaTO;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RelatorioApostasService implements Serializable{

    @Inject
    private ApostaDAO apostaDAO;

    public List<RelatorioMilharCentenaTO> montarRelatorioApostasMilharCentena() {
        List<RelatorioMilharCentenaTO> relatorioMilharCentenaTOs = new ArrayList<RelatorioMilharCentenaTO>();
        List<Aposta> apostas = new ArrayList<Aposta>();
        try {
            apostas = apostaDAO.findAll();

            for (Aposta a : apostas) {
                RelatorioMilharCentenaTO rmc =  new RelatorioMilharCentenaTO();
                rmc.setNumero(a.getNumero());
                rmc = getRelatorioMilharCentenaTOSeJaExiste(relatorioMilharCentenaTOs, rmc);
                acumularValoresNaMesmaAposta(a, rmc);
                if (!relatorioMilharCentenaTOs.contains(rmc)) {
                    relatorioMilharCentenaTOs.add(rmc);
                }
            }
            Collections.sort(relatorioMilharCentenaTOs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relatorioMilharCentenaTOs;
    }

    private RelatorioMilharCentenaTO getRelatorioMilharCentenaTOSeJaExiste(List<RelatorioMilharCentenaTO> relatorioMilharCentenaTOs, RelatorioMilharCentenaTO rmc) {
        if(relatorioMilharCentenaTOs.contains(rmc)){
            rmc = relatorioMilharCentenaTOs.get(relatorioMilharCentenaTOs.indexOf(rmc));
        }
        return rmc;
    }

    private void acumularValoresNaMesmaAposta(Aposta a, RelatorioMilharCentenaTO rmc) {
        if(isValorValido(a.getValorApostaPrimeiroPremio())){
            rmc.setQtdePrimeiroPremio(rmc.getQtdeQuartoPremio() + 1);
            rmc.setValorTotalPrimeiroPremio(rmc.getValorTotalPrimeiroPremio() + a.getValorApostaPrimeiroPremio());
        }
        if(isValorValido(a.getValorApostaSegundoPremio())){
            rmc.setQtdeSegundoPremio(rmc.getQtdeQuartoPremio() + 1);
            rmc.setValorTotalSegundoPremio(rmc.getValorTotalSegundoPremio() + a.getValorApostaSegundoPremio());
        }
        if(isValorValido(a.getValorApostaTerceiroPremio())){
            rmc.setQtdeTerceiroPremio(rmc.getQtdeQuartoPremio() + 1);
            rmc.setValorTotalTerceiroPremio(rmc.getValorTotalTerceiroPremio() + a.getValorApostaTerceiroPremio());
        }
        if(isValorValido(a.getValorApostaQuartoPremio())){
            rmc.setQtdeQuartoPremio(rmc.getQtdeQuartoPremio() + 1);
            rmc.setValorTotalQuartoPremio(rmc.getValorTotalQuartoPremio() + a.getValorApostaQuartoPremio());
        }
        if(isValorValido(a.getValorApostaQuintoPremio())){
            rmc.setQtdeQuintoPremio(rmc.getQtdeQuintoPremio() + 1);
            rmc.setValorTotalQuintoPremio(rmc.getValorTotalQuintoPremio() + a.getValorApostaQuintoPremio());
        }
        if(isValorValido(a.getValorApostaSextoPremio())){
            rmc.setQtdeSextoPremio(rmc.getQtdeSextoPremio() + 1);
            rmc.setValorTotalSextoPremio(rmc.getValorTotalSextoPremio() + a.getValorApostaSextoPremio());
        }
        if(isValorValido(a.getValorApostaSetimoPremio())){
            rmc.setQtdeSetimoPremio(rmc.getQtdeSetimoPremio() + 1);
            rmc.setValorTotalSetimoPremio(rmc.getValorTotalSetimoPremio() + a.getValorApostaSetimoPremio());
        }
    }

    private boolean isValorValido(Double valor) {
        return valor != null && valor > 0;
    }

}
