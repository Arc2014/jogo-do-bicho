package br.com.jogo.to;

import br.com.jogo.model.Aposta;

import java.io.Serializable;
import java.util.List;

public class ResultadoTO implements Serializable{

    private String primeiroPremio;
    private String segundoPremio;
    private String terceiroPremio;
    private String quartoPremio;
    private String quintoPremio;
    private String sextoPremio;
    private String setimoPremio;

    private List<Aposta> apostasPrimeiroPremio;
    private List<Aposta> apostasSegundoPremio;
    private List<Aposta> apostasTerceiroPremio;
    private List<Aposta> apostasQuartoPremio;
    private List<Aposta> apostasQuintoPremio;
    private List<Aposta> apostasSextoPremio;
    private List<Aposta> apostasSetimoPremio;


    public String getPrimeiroPremio() {
        return primeiroPremio;
    }

    public void setPrimeiroPremio(String primeiroPremio) {
        this.primeiroPremio = primeiroPremio;
    }

    public String getSegundoPremio() {
        return segundoPremio;
    }

    public void setSegundoPremio(String segundoPremio) {
        this.segundoPremio = segundoPremio;
    }

    public String getTerceiroPremio() {
        return terceiroPremio;
    }

    public void setTerceiroPremio(String terceiroPremio) {
        this.terceiroPremio = terceiroPremio;
    }

    public String getQuartoPremio() {
        return quartoPremio;
    }

    public void setQuartoPremio(String quartoPremio) {
        this.quartoPremio = quartoPremio;
    }

    public String getQuintoPremio() {
        return quintoPremio;
    }

    public void setQuintoPremio(String quintoPremio) {
        this.quintoPremio = quintoPremio;
    }

    public String getSextoPremio() {
        return sextoPremio;
    }

    public void setSextoPremio(String sextoPremio) {
        this.sextoPremio = sextoPremio;
    }

    public String getSetimoPremio() {
        return setimoPremio;
    }

    public void setSetimoPremio(String setimoPremio) {
        this.setimoPremio = setimoPremio;
    }

    public List<Aposta> getApostasPrimeiroPremio() {
        return apostasPrimeiroPremio;
    }

    public void setApostasPrimeiroPremio(List<Aposta> apostasPrimeiroPremio) {
        this.apostasPrimeiroPremio = apostasPrimeiroPremio;
    }

    public List<Aposta> getApostasSegundoPremio() {
        return apostasSegundoPremio;
    }

    public void setApostasSegundoPremio(List<Aposta> apostasSegundoPremio) {
        this.apostasSegundoPremio = apostasSegundoPremio;
    }

    public List<Aposta> getApostasTerceiroPremio() {
        return apostasTerceiroPremio;
    }

    public void setApostasTerceiroPremio(List<Aposta> apostasTerceiroPremio) {
        this.apostasTerceiroPremio = apostasTerceiroPremio;
    }

    public List<Aposta> getApostasQuartoPremio() {
        return apostasQuartoPremio;
    }

    public void setApostasQuartoPremio(List<Aposta> apostasQuartoPremio) {
        this.apostasQuartoPremio = apostasQuartoPremio;
    }

    public List<Aposta> getApostasQuintoPremio() {
        return apostasQuintoPremio;
    }

    public void setApostasQuintoPremio(List<Aposta> apostasQuintoPremio) {
        this.apostasQuintoPremio = apostasQuintoPremio;
    }

    public List<Aposta> getApostasSextoPremio() {
        return apostasSextoPremio;
    }

    public void setApostasSextoPremio(List<Aposta> apostasSextoPremio) {
        this.apostasSextoPremio = apostasSextoPremio;
    }

    public List<Aposta> getApostasSetimoPremio() {
        return apostasSetimoPremio;
    }

    public void setApostasSetimoPremio(List<Aposta> apostasSetimoPremio) {
        this.apostasSetimoPremio = apostasSetimoPremio;
    }
}
