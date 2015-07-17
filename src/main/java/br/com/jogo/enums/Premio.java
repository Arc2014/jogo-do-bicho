package br.com.jogo.enums;

public enum Premio {
    PRIMEIRO("Primeiro"),
    SEGUNDO("Segundo"),
    TERCEIRO("Terceiro"),
    QUARTO("Quarto"),
    QUINTO("Quinto"),
    SEXTO("Sexto"),
    SETIMO("Setimo");

    private String tipo;

    Premio(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
