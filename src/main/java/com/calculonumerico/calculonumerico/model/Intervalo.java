package com.calculonumerico.calculonumerico.model;

public class Intervalo {

    private Double a;
    private Double b;

    public Intervalo(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Intervalo() {
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }
}
