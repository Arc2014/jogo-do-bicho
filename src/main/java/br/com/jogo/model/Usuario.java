package br.com.jogo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    @Id
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void validate(){
        if(login == null || senha == null){
            throw new IllegalArgumentException("Nome e senha não podem ser nulos");
        }
    }

}