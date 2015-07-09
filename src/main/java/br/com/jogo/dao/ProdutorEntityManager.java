package br.com.jogo.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManager {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jogo");

    @Produces @RequestScoped
    public EntityManager criaEntityManager() {
        return factory.createEntityManager();
    }
}
