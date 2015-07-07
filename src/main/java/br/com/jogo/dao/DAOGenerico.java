package br.com.jogo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DAOGenerico<PK, T> {
    @PersistenceUnit(name = "jogo", unitName = "jogo")
    private EntityManager entityManager;

    public DAOGenerico(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManagerInstance(){
        return this.entityManager;
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

