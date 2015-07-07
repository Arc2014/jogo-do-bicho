package br.com.jogo.dao;


import br.com.jogo.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Long, Usuario>{
    public UsuarioDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Usuario getUsuario(String senha, String login) {
        Query query = getEntityManagerInstance().createQuery("SELECT u FROM Usuario u WHERE u.login =:login AND senha =:senha");
        query.setParameter("senha", senha);
        query.setParameter("login", login);
        Usuario u = (Usuario) query.getSingleResult();
        return u;
    }
}
