package br.com.jogo.dao;


import br.com.jogo.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Long, Usuario>{

    public Usuario getUsuario(String senha, String login) {
        Usuario u = null;
        try {
            Query query = getEntityManagerInstance().createQuery("SELECT u FROM Usuario u WHERE u.login =:login AND senha =:senha");
            query.setParameter("senha", senha);
            query.setParameter("login", login);
            u = (Usuario) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
