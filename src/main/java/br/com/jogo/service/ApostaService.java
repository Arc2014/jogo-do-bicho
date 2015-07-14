package br.com.jogo.service;

import br.com.jogo.dao.ApostaDAO;
import br.com.jogo.model.Aposta;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

public class ApostaService implements Serializable{

    @Inject
    private ApostaDAO dao;

    public void save(Aposta aposta) throws Exception{
        dao.update(aposta);
    }

    @Transactional
    public void apagarApostas() throws Exception{
        dao.apagarApostas();
    }
}
