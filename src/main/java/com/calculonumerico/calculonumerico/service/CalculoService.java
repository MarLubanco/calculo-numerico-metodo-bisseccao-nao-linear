package com.calculonumerico.calculonumerico.service;

import com.calculonumerico.calculonumerico.model.EntradaFuncao;
import com.calculonumerico.calculonumerico.model.Funcao;
import com.calculonumerico.calculonumerico.model.Intervalo;
import org.springframework.stereotype.Service;

@Service
public class CalculoService {

    public void calcularMetodoBissecaoNaoLinear(EntradaFuncao entradaFuncao) {
        System.out.println("FUNCIONANDO");
    }

    //TODO refatorar para receber uma classe Intevarlo (Double a, Double b)
    public Double calcularMediaDeIntervalo(Intervalo intervalo) {
        return (intervalo.getA() + intervalo.getB()) / 2;
    }


    public Intervalo gerarIntervalo(Double a, Double b) {
        return new Intervalo(a, b);
    }

    public void analisarIntervaloNaFuncao(Intervalo intervalo, Funcao funcao) {

    }
}
