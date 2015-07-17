package br.com.jogo.dao;


import br.com.jogo.enums.Premio;
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

    public List<Aposta> buscarApostasPremiadasPrimeiroPremio(String resultado, Premio PREMIO) {
        List<Aposta> apostas = new ArrayList<Aposta>();
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT a FROM Aposta a WHERE a.numero =:resultado AND a.valorAposta")
                .append(PREMIO.getTipo())
                .append("Premio > 0.0 ");
        Query query = getEntityManagerInstance().createQuery(jpql.toString());
        query.setParameter("resultado", resultado);
        apostas = query.getResultList();
        return apostas;
    }

}
