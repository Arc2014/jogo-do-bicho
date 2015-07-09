package br.com.jogo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aposta")
public class Aposta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero", length=4)
    private String numero;

    @Column(name = "valor_aposta_primeiro_premio")
    private Double valorApostaPrimeiroPremio;

    @Column(name = "valor_aposta_segundo_premio")
    private Double valorApostaSegundoPremio;

    @Column(name = "valor_aposta_terceiro_premio")
    private Double valorApostaTerceiroPremio;

    @Column(name = "valor_aposta_quarto_premio")
    private Double valorApostaQuartoPremio;

    @Column(name = "valor_aposta_quinto_premio")
    private Double valorApostaQuintoPremio;

    @Column(name = "valor_aposta_sexto_premio")
    private Double valorApostaSextoPremio;

    @Column(name = "valor_aposta_setimo_premio")
    private Double valorApostaSetimoPremio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getValorApostaPrimeiroPremio() {
        return valorApostaPrimeiroPremio == null ? 0 : valorApostaPrimeiroPremio;
    }

    public void setValorApostaPrimeiroPremio(Double valorApostaPrimeiroPremio) {
        this.valorApostaPrimeiroPremio = valorApostaPrimeiroPremio;
    }

    public Double getValorApostaSegundoPremio() {
        return valorApostaSegundoPremio == null ? 0 : valorApostaSegundoPremio;
    }

    public void setValorApostaSegundoPremio(Double valorApostaSegundoPremio) {
        this.valorApostaSegundoPremio = valorApostaSegundoPremio;
    }

    public Double getValorApostaTerceiroPremio() {
        return valorApostaTerceiroPremio == null ? 0 : valorApostaTerceiroPremio;
    }

    public void setValorApostaTerceiroPremio(Double valorApostaTerceiroPremio) {
        this.valorApostaTerceiroPremio = valorApostaTerceiroPremio;
    }

    public Double getValorApostaQuartoPremio() {
        return valorApostaQuartoPremio == null ? 0: valorApostaQuartoPremio;
    }

    public void setValorApostaQuartoPremio(Double valorApostaQuartoPremio) {
        this.valorApostaQuartoPremio = valorApostaQuartoPremio;
    }

    public Double getValorApostaQuintoPremio() {
        return valorApostaQuintoPremio == null ? 0 : valorApostaQuintoPremio;
    }

    public void setValorApostaQuintoPremio(Double valorApostaQuintoPremio) {
        this.valorApostaQuintoPremio = valorApostaQuintoPremio;
    }

    public Double getValorApostaSextoPremio() {
        return valorApostaSextoPremio == null ? 0 : valorApostaSextoPremio;
    }

    public void setValorApostaSextoPremio(Double valorApostaSextoPremio) {
        this.valorApostaSextoPremio = valorApostaSextoPremio;
    }

    public Double getValorApostaSetimoPremio() {
        return valorApostaSetimoPremio == null ? 0 : valorApostaSetimoPremio;
    }

    public void setValorApostaSetimoPremio(Double valorApostaSetimoPremio) {
        this.valorApostaSetimoPremio = valorApostaSetimoPremio;
    }
}
