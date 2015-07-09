package br.com.jogo.service;

import br.com.jogo.dao.UsuarioDAO;
import br.com.jogo.model.Usuario;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class UsuarioService implements Serializable{

    @Inject
    private UsuarioDAO dao;

    public void save(Usuario usuario) throws Exception{
        usuario.validate();
        dao.save(usuario);
    }

    public List<Usuario> findAll() throws Exception{
        return dao.findAll();
    }

    public Usuario getUsuario(String senha, String login){
        return dao.getUsuario(senha, login);
    }
}
