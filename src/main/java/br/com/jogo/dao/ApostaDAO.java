package br.com.jogo.dao;


import br.com.jogo.model.Aposta;

public class ApostaDAO extends DAOGenerico<Long, Aposta>{

    @Override
    public void save(Aposta aposta) throws Exception{
        super.save(aposta);
    }
}
