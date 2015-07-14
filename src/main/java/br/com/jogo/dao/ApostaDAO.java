package br.com.jogo.dao;


import br.com.jogo.model.Aposta;
import br.com.jogo.to.RelatorioMilharCentenaTO;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ApostaDAO extends DAOGenerico<Long, Aposta>{

    public void apagarApostas() throws Exception {
        String jpql = "DELETE FROM Aposta";
        try{
            beginTransaction();
            Query query = getEntityManagerInstance().createQuery(jpql);
            query.executeUpdate();
            commit();
        }catch (Exception e) {
            rollBack();
            throw new Exception(e);
        }

    }
}
