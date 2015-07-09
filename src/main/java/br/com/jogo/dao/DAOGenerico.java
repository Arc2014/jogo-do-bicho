package br.com.jogo.dao;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DAOGenerico<PK, T> implements Serializable{

    @Inject
    private EntityManager entityManager;

    public EntityManager getEntityManagerInstance(){
        return entityManager;
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public void save(T entity) throws Exception{
        beginTransaction();
        entityManager.persist(entity);
        commit();
    }

    public void update(T entity) throws Exception{
        beginTransaction();
        entityManager.merge(entity);
        commit();
    }

    public void delete(T entity) throws Exception{
        beginTransaction();
        entityManager.remove(entity);
        commit();
    }

    public List<T> findAll() throws Exception{
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
    public void beginTransaction() throws Exception{
        entityManager.getTransaction().begin();
    }

    public void commit() throws Exception{
        entityManager.getTransaction().commit();
    }

    public void close() throws Exception{
        entityManager.close();
        entityManager.getEntityManagerFactory().close();
    }

    public void rollBack() throws Exception{
        entityManager.getTransaction().rollback();
    }
}

