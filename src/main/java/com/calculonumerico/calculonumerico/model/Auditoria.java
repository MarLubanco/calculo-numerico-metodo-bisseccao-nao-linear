package com.calculonumerico.calculonumerico.model;

import java.util.List;

public class Auditoria {

    private Double raizDaFuncaoEncontrada = 0.0;
    private Intervalo intervalo;
    private Double raizDaFuncao;
    private List<Intervalo> intervalosIniciais;

    public Auditoria(Double raizDaFuncaEncontrada, Intervalo intervalo, Double raizDaFuncao) {
        this.raizDaFuncaoEncontrada = raizDaFuncaEncontrada;
        this.intervalo = intervalo;
        this.raizDaFuncao = raizDaFuncao;
    }

    public Auditoria(Intervalo intervalo, Double raizDaFuncao) {
        this.intervalo = intervalo;
        this.raizDaFuncao = raizDaFuncao;
    }

    public Auditoria(Double raizDaFuncaoEncontrada, Intervalo intervalo, Double raizDaFuncao, List<Intervalo> intervalosIniciais) {
        this.raizDaFuncaoEncontrada = raizDaFuncaoEncontrada;
        this.intervalo = intervalo;
        this.raizDaFuncao = raizDaFuncao;
        this.intervalosIniciais = intervalosIniciais;
    }

    public Auditoria() {
    }

    public List<Intervalo> getIntervalosIniciais() {
        return intervalosIniciais;
    }

    public void setIntervalosIniciais(List<Intervalo> intervalosIniciais) {
        this.intervalosIniciais = intervalosIniciais;
    }

    public Double getRaizDaFuncaoEncontrada() {
        return raizDaFuncaoEncontrada;
    }

    public void setRaizDaFuncaoEncontrada(Double raizDaFuncaoEncontrada) {
        this.raizDaFuncaoEncontrada = raizDaFuncaoEncontrada;
    }

    public Intervalo getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Intervalo intervalo) {
        this.intervalo = intervalo;
    }

    public Double getRaizDaFuncao() {
        return raizDaFuncao;
    }

    public void setRaizDaFuncao(Double raizDaFuncao) {
        this.raizDaFuncao = raizDaFuncao;
    }

    @Override
    public String toString() {
        return "Auditoria { " +
                "raizDaFuncaoEncontrada= " + raizDaFuncaoEncontrada +
                ", intervalo= " + intervalo +
                ", raizDaFuncao= " + raizDaFuncao +
                '}';
    }
}
