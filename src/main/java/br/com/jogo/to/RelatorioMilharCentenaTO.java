package br.com.jogo.to;

public class RelatorioMilharCentenaTO implements Comparable<RelatorioMilharCentenaTO>{
    private String numero;

    private Integer qtdePrimeiroPremio = Integer.valueOf(0);
    private Double valorTotalPrimeiroPremio = Double.valueOf(0);

    private Integer qtdeSegundoPremio = Integer.valueOf(0);
    private Double valorTotalSegundoPremio = Double.valueOf(0);

    private Integer qtdeTerceiroPremio = Integer.valueOf(0);
    private Double valorTotalTerceiroPremio = Double.valueOf(0);

    private Integer qtdeQuartoPremio = Integer.valueOf(0);
    private Double valorTotalQuartoPremio = Double.valueOf(0);

    private Integer qtdeQuintoPremio = Integer.valueOf(0);
    private Double valorTotalQuintoPremio = Double.valueOf(0);

    private Integer qtdeSextoPremio = Integer.valueOf(0);
    private Double valorTotalSextoPremio = Double.valueOf(0);

    private Integer qtdeSetimoPremio = Integer.valueOf(0);
    private Double valorTotalSetimoPremio = Double.valueOf(0);

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getQtdePrimeiroPremio() {
        return qtdePrimeiroPremio;
    }

    public void setQtdePrimeiroPremio(Integer qtdePrimeiroPremio) {
        this.qtdePrimeiroPremio = qtdePrimeiroPremio;
    }

    public Double getValorTotalPrimeiroPremio() {
        return valorTotalPrimeiroPremio;
    }

    public void setValorTotalPrimeiroPremio(Double valorTotalPrimeiroPremio) {
        this.valorTotalPrimeiroPremio = valorTotalPrimeiroPremio;
    }

    public Integer getQtdeSegundoPremio() {
        return qtdeSegundoPremio;
    }

    public void setQtdeSegundoPremio(Integer qtdeSegundoPremio) {
        this.qtdeSegundoPremio = qtdeSegundoPremio;
    }

    public Double getValorTotalSegundoPremio() {
        return valorTotalSegundoPremio;
    }

    public void setValorTotalSegundoPremio(Double valorTotalSegundoPremio) {
        this.valorTotalSegundoPremio = valorTotalSegundoPremio;
    }

    public Integer getQtdeTerceiroPremio() {
        return qtdeTerceiroPremio;
    }

    public void setQtdeTerceiroPremio(Integer qtdeTerceiroPremio) {
        this.qtdeTerceiroPremio = qtdeTerceiroPremio;
    }

    public Double getValorTotalTerceiroPremio() {
        return valorTotalTerceiroPremio;
    }

    public void setValorTotalTerceiroPremio(Double valorTotalTerceiroPremio) {
        this.valorTotalTerceiroPremio = valorTotalTerceiroPremio;
    }

    public Integer getQtdeQuartoPremio() {
        return qtdeQuartoPremio;
    }

    public void setQtdeQuartoPremio(Integer qtdeQuartoPremio) {
        this.qtdeQuartoPremio = qtdeQuartoPremio;
    }

    public Double getValorTotalQuartoPremio() {
        return valorTotalQuartoPremio;
    }

    public void setValorTotalQuartoPremio(Double valorTotalQuartoPremio) {
        this.valorTotalQuartoPremio = valorTotalQuartoPremio;
    }

    public Integer getQtdeQuintoPremio() {
        return qtdeQuintoPremio;
    }

    public void setQtdeQuintoPremio(Integer qtdeQuintoPremio) {
        this.qtdeQuintoPremio = qtdeQuintoPremio;
    }

    public Double getValorTotalQuintoPremio() {
        return valorTotalQuintoPremio;
    }

    public void setValorTotalQuintoPremio(Double valorTotalQuintoPremio) {
        this.valorTotalQuintoPremio = valorTotalQuintoPremio;
    }

    public Integer getQtdeSextoPremio() {
        return qtdeSextoPremio;
    }

    public void setQtdeSextoPremio(Integer qtdeSextoPremio) {
        this.qtdeSextoPremio = qtdeSextoPremio;
    }

    public Double getValorTotalSextoPremio() {
        return valorTotalSextoPremio;
    }

    public void setValorTotalSextoPremio(Double valorTotalSextoPremio) {
        this.valorTotalSextoPremio = valorTotalSextoPremio;
    }

    public Integer getQtdeSetimoPremio() {
        return qtdeSetimoPremio;
    }

    public void setQtdeSetimoPremio(Integer qtdeSetimoPremio) {
        this.qtdeSetimoPremio = qtdeSetimoPremio;
    }

    public Double getValorTotalSetimoPremio() {
        return valorTotalSetimoPremio;
    }

    public void setValorTotalSetimoPremio(Double valorTotalSetimoPremio) {
        this.valorTotalSetimoPremio = valorTotalSetimoPremio;
    }

    public Boolean getIsValorApostaMaiorQue10() {
        return valorTotalPrimeiroPremio > 10;
    }

    public Boolean getIsDuplicouAposta() {
        return qtdePrimeiroPremio > 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelatorioMilharCentenaTO that = (RelatorioMilharCentenaTO) o;

        return numero.equals(that.numero);

    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }

    public int compareTo(RelatorioMilharCentenaTO relatorioMilharCentenaTO) {
        int r1 = relatorioMilharCentenaTO.getQtdePrimeiroPremio().compareTo(this.qtdePrimeiroPremio);
        int r2 = relatorioMilharCentenaTO.getValorTotalPrimeiroPremio().compareTo(this.valorTotalPrimeiroPremio);

        if (r1 == 0){
            return r2;
        } else {
            return r1;
        }
    }
}
