package com.calculonumerico.calculonumerico.model;

public class EntradaFuncao {

    private Float entradaUm;
    private Float entradaDois;
    private Float entradaTres;
    private Float entradaQuatro;
    private Float entradaCinco;
    private Float entradaSeis;
    private Float entradaEpsilon;

    public Double gerarFuncao(EntradaFuncao entradaFuncao, Double x) {
        Double a = null;
        Double b = null;
        Double c = null;
        Double d = null;
        Double e = null;
        Double f = null;
        if(entradaFuncao.getEntradaSeis() != null) {
           a = entradaFuncao.getEntradaSeis() * (Math.pow(x , 5));
        }
        if(entradaFuncao.getEntradaCinco() != null) {
            b = entradaFuncao.getEntradaCinco() * (Math.pow(x , 5));
        }
        if(entradaFuncao.getEntradaQuatro() != null) {
            c = entradaFuncao.getEntradaQuatro() * (Math.pow(x , 5));
        }
        if(entradaFuncao.getEntradaTres() != null) {
            d = entradaFuncao.getEntradaTres() * (Math.pow(x , 5));
        }
        if(entradaFuncao.getEntradaDois() != null) {
            e = entradaFuncao.getEntradaDois() * (Math.pow(x , 5));
        }
        if(entradaFuncao.getEntradaUm() != null) {
            f = entradaFuncao.getEntradaUm() * (Math.pow(x , 5));
        }

        return a + b + c + d + e + f;
    }

    public EntradaFuncao() {
    }

    public EntradaFuncao(Float entradaUm, Float entradaDois, Float entradaTres, Float entradaQuatro, Float entradaCinco, Float entradaSeis, Float entradaEpsilon) {
        this.entradaUm = entradaUm;
        this.entradaDois = entradaDois;
        this.entradaTres = entradaTres;
        this.entradaQuatro = entradaQuatro;
        this.entradaCinco = entradaCinco;
        this.entradaSeis = entradaSeis;
        this.entradaEpsilon = entradaEpsilon;
    }

    public Float getEntradaUm() {
        return entradaUm;
    }

    public void setEntradaUm(Float entradaUm) {
        this.entradaUm = entradaUm;
    }

    public Float getEntradaDois() {
        return entradaDois;
    }

    public void setEntradaDois(Float entradaDois) {
        this.entradaDois = entradaDois;
    }

    public Float getEntradaTres() {
        return entradaTres;
    }

    public void setEntradaTres(Float entradaTres) {
        this.entradaTres = entradaTres;
    }

    public Float getEntradaQuatro() {
        return entradaQuatro;
    }

    public void setEntradaQuatro(Float entradaQuatro) {
        this.entradaQuatro = entradaQuatro;
    }

    public Float getEntradaCinco() {
        return entradaCinco;
    }

    public void setEntradaCinco(Float entradaCinco) {
        this.entradaCinco = entradaCinco;
    }

    public Float getEntradaSeis() {
        return entradaSeis;
    }

    public void setEntradaSeis(Float entradaSeis) {
        this.entradaSeis = entradaSeis;
    }

    public Float getEntradaEpsilon() {
        return entradaEpsilon;
    }

    public void setEntradaEpsilon(Float entradaEpsilon) {
        this.entradaEpsilon = entradaEpsilon;
    }
}
