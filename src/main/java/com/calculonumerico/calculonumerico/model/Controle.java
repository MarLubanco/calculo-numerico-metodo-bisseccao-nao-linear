package com.calculonumerico.calculonumerico.model;

public class Controle {

    private String sinal;
    private Double value;

    public Controle(String sinal, Double value) {
        this.sinal = sinal;
        this.value = value;
    }

    public Controle() {
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Controle{" +
                "sinal='" + sinal + '\'' +
                ", value=" + value +
                '}';
    }
}
