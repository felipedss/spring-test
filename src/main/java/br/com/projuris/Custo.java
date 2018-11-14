package br.com.projuris;

import java.math.BigDecimal;

public abstract class Custo {

    private String descricao;
    private BigDecimal custo;

    public Custo(String descricao, BigDecimal custo) {
        this.descricao = descricao;
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

}
