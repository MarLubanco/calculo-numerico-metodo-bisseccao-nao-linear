package com.calculonumerico.calculonumerico.service;

import com.calculonumerico.calculonumerico.model.EntradaFuncao;
import com.calculonumerico.calculonumerico.model.Funcao;
import com.calculonumerico.calculonumerico.model.Intervalo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculoService {

    private List<Double> raizesDaFuncao = new ArrayList<>();

    public void calcularMetodoBissecaoNaoLinear(EntradaFuncao entradaFuncao) {
        System.out.println("FUNCIONANDO");
    }

    /**
     * Calcula a média do intervalo
     * @param intervalo
     * @return
     */
    public Double calcularMediaDeIntervalo(Intervalo intervalo) {
        return (intervalo.getA() + intervalo.getB()) / 2;
    }


    /**
     * Gerar um novo intervalo
     * @param a
     * @param b
     * @return
     */
    public Intervalo gerarIntervalo(Double a, Double b) {
        return new Intervalo(a, b);
    }

    @Scheduled(fixedDelay = 500000)
    public void testeFuncao() {
        Intervalo intervalo = new Intervalo(0.5, 1.0);
        EntradaFuncao entradaFuncao = new EntradaFuncao(5.0,1.0,3.0,null,null,null,0.01);
        Double mediaDeIntervalo = calcularMediaDeIntervalo(intervalo);
        refinarIntervalo(entradaFuncao, intervalo, mediaDeIntervalo);
        System.out.println("TESTE");
    }

    /**
     * É responsável por gerar a função.
     * @param entradaFuncao é o input passado pelo usuário no frontend
     * @param x é o valor a ser calculado, na maioria das vezes vaiser a média do intervalo e
     *          no começo os valores inciais do array principal
     * @return
     */
    public Double calcularFuncao(EntradaFuncao entradaFuncao, Double x) {
        Double a = 0.0;
        Double b = 0.0;
        Double c = 0.0;
        Double d = 0.0;
        Double e = 0.0;
        Double f = 0.0;
        if(entradaFuncao.getEntradaSeis() != null) {
            a = entradaFuncao.getEntradaSeis() * (Math.pow(x , 5));
        }
        if(entradaFuncao.getEntradaCinco() != null) {
            b = entradaFuncao.getEntradaCinco() * (Math.pow(x , 4));
        }
        if(entradaFuncao.getEntradaQuatro() != null) {
            c = entradaFuncao.getEntradaQuatro() * (Math.pow(x , 3));
        }
        if(entradaFuncao.getEntradaTres() != null) {
            d = entradaFuncao.getEntradaTres() * (Math.pow(x , 2));
        }
        if(entradaFuncao.getEntradaDois() != null) {
            e = entradaFuncao.getEntradaDois() * x;
        }
        if(entradaFuncao.getEntradaUm() != null) {
            f = entradaFuncao.getEntradaUm();
        }
        Double resultado = a + b + c + d + e + f;
        System.out.println("O resultado da funcao é: " + resultado);
        return resultado;
    }


    /**
     * É responsável por refinar os intervalos até encontrar o critério de parada e recuperar
     * as raízes reais.
     *
     * @param entradaFuncao
     * @param intervalo
     * @param mediaIntervalo
     */
    public void refinarIntervalo(EntradaFuncao entradaFuncao, Intervalo intervalo, Double mediaIntervalo) {
       while (isCriterioDeParada(intervalo, entradaFuncao.getEntradaEpsilon())) {
           System.out.println("O critério ainda não pe verdadeiro");
           Double resultadoFuncao = calcularFuncao(entradaFuncao, mediaIntervalo);
           System.out.println("Resultado da raiz da funcao: " + resultadoFuncao);
           if (resultadoFuncao > 0) {
               System.out.println("É positivo");
               intervalo.setB(mediaIntervalo);
           } else {
               System.out.println("É negativo");
               intervalo.setA(mediaIntervalo);
           }
           raizesDaFuncao.add(resultadoFuncao);
           mediaIntervalo = calcularMediaDeIntervalo(intervalo);

       }
       System.out.println("Finalização do calculo de raízes reais: " + raizesDaFuncao.get(raizesDaFuncao.size() -1));
//        return intervalo;
    }

    /**
     * Valida se o critério de parada já foi atendido, caso não continue refinando os intervalos
     *
     * @param intervalo
     * @param epsilon
     * @return
     */
    public boolean isCriterioDeParada(Intervalo intervalo, Double epsilon) {
        Double epsilonCalculado = epsilon; //calcularEpsilon(epsilon);
        Double modulo = intervalo.getB() - intervalo.getA();
        if (modulo < epsilonCalculado) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Calcula o valor do epsilon
     * @param epsilon
     * @return
     */
    public Double calcularEpsilon(Double epsilon) {
        return Math.pow(10, epsilon);
    }
}
