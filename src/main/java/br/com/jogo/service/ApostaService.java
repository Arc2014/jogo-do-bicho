package br.com.jogo.service;

import br.com.jogo.dao.ApostaDAO;
import br.com.jogo.model.Aposta;

import javax.inject.Inject;
import java.io.Serializable;

public class ApostaService implements Serializable{

    @Inject
    private ApostaDAO dao;

    public void save(Aposta aposta) throws Exception{
        dao.update(aposta);
    }
}
