package br.com.jogo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aposta")
public class Aposta implements Serializable, Comparable<Aposta>{

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
        return valorApostaPrimeiroPremio;
    }

    public void setValorApostaPrimeiroPremio(Double valorApostaPrimeiroPremio) {
        this.valorApostaPrimeiroPremio = valorApostaPrimeiroPremio;
    }

    public Double getValorApostaSegundoPremio() {
        return valorApostaSegundoPremio;
    }

    public void setValorApostaSegundoPremio(Double valorApostaSegundoPremio) {
        this.valorApostaSegundoPremio = valorApostaSegundoPremio;
    }

    public Double getValorApostaTerceiroPremio() {
        return valorApostaTerceiroPremio;
    }

    public void setValorApostaTerceiroPremio(Double valorApostaTerceiroPremio) {
        this.valorApostaTerceiroPremio = valorApostaTerceiroPremio;
    }

    public Double getValorApostaQuartoPremio() {
        return valorApostaQuartoPremio;
    }

    public void setValorApostaQuartoPremio(Double valorApostaQuartoPremio) {
        this.valorApostaQuartoPremio = valorApostaQuartoPremio;
    }

    public Double getValorApostaQuintoPremio() {
        return valorApostaQuintoPremio;
    }

    public void setValorApostaQuintoPremio(Double valorApostaQuintoPremio) {
        this.valorApostaQuintoPremio = valorApostaQuintoPremio;
    }

    public Double getValorApostaSextoPremio() {
        return valorApostaSextoPremio;
    }

    public void setValorApostaSextoPremio(Double valorApostaSextoPremio) {
        this.valorApostaSextoPremio = valorApostaSextoPremio;
    }

    public Double getValorApostaSetimoPremio() {
        return valorApostaSetimoPremio;
    }

    public void setValorApostaSetimoPremio(Double valorApostaSetimoPremio) {
        this.valorApostaSetimoPremio = valorApostaSetimoPremio;
    }

    public boolean isApostaInvalida() {
        return numero == null || numero == "" || (
                (valorApostaPrimeiroPremio == null || valorApostaPrimeiroPremio <= 0) &&
                (valorApostaSegundoPremio == null || valorApostaSegundoPremio <= 0) &&
                (valorApostaTerceiroPremio == null || valorApostaTerceiroPremio <= 0) &&
                (valorApostaQuartoPremio == null || valorApostaQuartoPremio <= 0) &&
                (valorApostaQuintoPremio == null || valorApostaQuintoPremio <= 0) &&
                (valorApostaSextoPremio == null || valorApostaSextoPremio <= 0) &&
                (valorApostaSetimoPremio == null || valorApostaSetimoPremio <= 0)
        );
    }

    public Boolean isApostaValorSperior10() {
        return valorApostaPrimeiroPremio != null && valorApostaPrimeiroPremio > 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aposta aposta = (Aposta) o;

        return numero.equals(aposta.numero);

    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }

    public int compareTo(Aposta aposta) {
        return this.numero.compareTo(aposta.getNumero());
    }
}
