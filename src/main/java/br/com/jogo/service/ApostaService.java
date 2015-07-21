package br.com.jogo.service;

import br.com.jogo.dao.ApostaDAO;
import br.com.jogo.enums.Premio;
import br.com.jogo.model.Aposta;
import br.com.jogo.to.ResultadoTO;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ApostaService implements Serializable{

    @Inject
    private ApostaDAO dao;

    public void save(Aposta aposta) throws Exception{
        dao.update(aposta);
        dao.atualizarDataApostasSemelhantes(aposta);
    }

    @Transactional
    public void apagarApostas() throws Exception{
        dao.apagarApostas();
    }

    public List<Aposta> listarApostas() throws Exception{
        List<Aposta> apostas = dao.findAll();
        Collections.sort(apostas);
        return apostas;
    }

    public void apagarAposta(Aposta aposta) throws Exception {
        dao.delete(aposta);
    }

    public ResultadoTO buscarApostasPremiadas(ResultadoTO resultadoTO) throws Exception{

        resultadoTO.setApostasPrimeiroPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getPrimeiroPremio(), Premio.PRIMEIRO));
        resultadoTO.setApostasSegundoPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getSegundoPremio(), Premio.SEGUNDO));
        resultadoTO.setApostasTerceiroPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getTerceiroPremio(),Premio.TERCEIRO));
        resultadoTO.setApostasQuartoPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getQuartoPremio(), Premio.QUARTO));
        resultadoTO.setApostasQuintoPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getQuintoPremio(), Premio.QUINTO));
        resultadoTO.setApostasSextoPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getSextoPremio(), Premio.SEXTO));
        resultadoTO.setApostasSetimoPremio(dao.buscarApostasPremiadasPrimeiroPremio(resultadoTO.getSetimoPremio(), Premio.SETIMO));

        return resultadoTO;
    }

    public List<Aposta> buscarUltimasApostas() throws  Exception {
        return dao.buscarUltimasApostas();
    }
}
