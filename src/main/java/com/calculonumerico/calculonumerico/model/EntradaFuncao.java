package com.calculonumerico.calculonumerico.model;

public class EntradaFuncao {

    private Double entradaUm;
    private Double entradaDois;
    private Double entradaTres;
    private Double entradaQuatro;
    private Double entradaCinco;
    private Double entradaSeis;
    private Double entradaEpsilon;


    public EntradaFuncao() {
    }

    public EntradaFuncao(Double entradaUm, Double entradaDois, Double entradaTres, Double entradaQuatro, Double entradaCinco, Double entradaSeis, Double entradaEpsilon) {
        this.entradaUm = entradaUm;
        this.entradaDois = entradaDois;
        this.entradaTres = entradaTres;
        this.entradaQuatro = entradaQuatro;
        this.entradaCinco = entradaCinco;
        this.entradaSeis = entradaSeis;
        this.entradaEpsilon = entradaEpsilon;
    }

    public Double getEntradaUm() {
        return entradaUm;
    }

    public void setEntradaUm(Double entradaUm) {
        this.entradaUm = entradaUm;
    }

    public Double getEntradaDois() {
        return entradaDois;
    }

    public void setEntradaDois(Double entradaDois) {
        this.entradaDois = entradaDois;
    }

    public Double getEntradaTres() {
        return entradaTres;
    }

    public void setEntradaTres(Double entradaTres) {
        this.entradaTres = entradaTres;
    }

    public Double getEntradaQuatro() {
        return entradaQuatro;
    }

    public void setEntradaQuatro(Double entradaQuatro) {
        this.entradaQuatro = entradaQuatro;
    }

    public Double getEntradaCinco() {
        return entradaCinco;
    }

    public void setEntradaCinco(Double entradaCinco) {
        this.entradaCinco = entradaCinco;
    }

    public Double getEntradaSeis() {
        return entradaSeis;
    }

    public void setEntradaSeis(Double entradaSeis) {
        this.entradaSeis = entradaSeis;
    }

    public Double getEntradaEpsilon() {
        return entradaEpsilon;
    }

    public void setEntradaEpsilon(Double entradaEpsilon) {
        this.entradaEpsilon = entradaEpsilon;
    }
}
