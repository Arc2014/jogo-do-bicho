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

    public List<Aposta> buscarApostasPremiadasPrimeiroPremio(String resultado, Premio PREMIO) throws Exception{
        List<Aposta> apostas = new ArrayList<Aposta>();
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT a FROM Aposta a WHERE a.numero LIKE :resultado AND a.valorAposta")
                .append(PREMIO.getTipo())
                .append("Premio > 0.0 ");
        Query query = getEntityManagerInstance().createQuery(jpql.toString());
        query.setParameter("resultado", "%" + resultado.substring(resultado.length() - 3, resultado.length()));
        apostas = query.getResultList();
        return apostas;
    }

    public List<Aposta> buscarUltimasApostas() throws  Exception{
        List<Aposta> apostas = new ArrayList<Aposta>();
        String jpql = "SELECT a FROM Aposta a GROUP BY a.numero HAVING COUNT(a.id) > 1 ORDER BY a.dataHora DESC";
        Query query = getEntityManagerInstance().createQuery(jpql);
        query.setMaxResults(5);
        apostas = query.getResultList();
        return apostas;
    }

    public void  atualizarDataApostasSemelhantes(Aposta a) throws Exception{
        String jpql = "UPDATE Aposta a SET a.dataHora =:dataHora WHERE a.numero =:numero";
        Query query = getEntityManagerInstance().createQuery(jpql);
        query.setParameter("dataHora", a.getDataHora());
        query.setParameter("numero", a.getNumero());
        beginTransaction();
        query.executeUpdate();
        commit();
    }

}
