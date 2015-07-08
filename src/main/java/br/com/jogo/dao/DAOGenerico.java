package br.com.jogo.dao;

import javax.annotation.Resource;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DAOGenerico<PK, T> implements Serializable{

    @PersistenceContext(unitName = "jogo")
    private EntityManager entityManager;

    private void carregarEntityManager () {
        try {
            EntityManagerFactory emf  = Persistence.createEntityManagerFactory("jogo");
            entityManager = emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public EntityManager getEntityManagerInstance(){
        if (entityManager == null) {
            carregarEntityManager();
        }
        return entityManager;
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public void save(T entity) {
        beginTransaction();
        entityManager.persist(entity);
        close();
    }

    public void update(T entity) {
        beginTransaction();
        entityManager.merge(entity);
        close();
    }

    public void delete(T entity) {
        beginTransaction();
        entityManager.remove(entity);
        close();
    }

    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }

    public void commit(){
        entityManager.getTransaction().commit();
    }

    public void close(){
        entityManager.close();
        entityManager.getEntityManagerFactory().close();
    }

    public void rollBack(){
        entityManager.getTransaction().rollback();
    }
}

