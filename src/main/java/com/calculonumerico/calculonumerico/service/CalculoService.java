package com.calculonumerico.calculonumerico.service;

import com.calculonumerico.calculonumerico.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CalculoService {

    private List<Double> raizesDaFuncao = new ArrayList<>();
    private List<Intervalo> historicoIntervalos = new ArrayList<>();
    private List<Auditoria> auditoria = new ArrayList<>();
    private List<Controle> dadosAnalisadosEntrada = new ArrayList<>();
    private List<Integer> valoresDeRange = new ArrayList<>();

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

//    @Scheduled(fixedDelay = 500000)
    public List<Auditoria> aplicarFuncao(EntradaFuncao entradaFuncao) {
//        Intervalo intervalo = new Intervalo(0.5, 1.0);
        List<Auditoria> auditorias = new ArrayList<>();
//        EntradaFuncao entradaFuncao = new EntradaFuncao(3.0,9.0,null,1.0,null,null,0.01);
        List<Integer> valores = retornaRange(entradaFuncao);
        List<Controle> controladores = analisarEntradas(entradaFuncao, valores);
        List<Intervalo> intervalos = gerarIntervalos(controladores);
        for( Intervalo inter: intervalos) {
            System.out.println("Aplicando todo o calculo no intervalo " + inter.toString());
            Double mediaDeIntervalo = calcularMediaDeIntervalo(inter);
            auditorias = refinarIntervalo(entradaFuncao, inter, mediaDeIntervalo);
        }
        return auditorias;
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
        return resultado;
    }


    /**
     * É responsável por refinar os intervalos até encontrar o critério de parada e recuperar
     * as raízes reais.
     *  @param entradaFuncao
     * @param intervalo
     * @param mediaIntervalo
     */
    public List<Auditoria> refinarIntervalo(EntradaFuncao entradaFuncao, Intervalo intervalo, Double mediaIntervalo) {
       while (isCriterioDeParada(intervalo, entradaFuncao.getEntradaEpsilon())) {
           System.out.println("_________________________________________________________________ \n");
           System.out.println("O critério ainda não é verdadeiro " + intervalo.toString());
           Double resultadoFuncao = calcularFuncao(entradaFuncao, mediaIntervalo);
           System.out.println("Resultado da raiz da funcao: " + resultadoFuncao);
           if (resultadoFuncao > 0) {
               System.out.println(resultadoFuncao + " É positivo");
               intervalo.setB(mediaIntervalo);
           } else {
               System.out.println(resultadoFuncao + " É negativo");
               intervalo.setA(mediaIntervalo);
           }
           raizesDaFuncao.add(resultadoFuncao);
           mediaIntervalo = calcularMediaDeIntervalo(intervalo);
           auditoria.add(new Auditoria(new Intervalo(intervalo.getA(), intervalo.getB()), resultadoFuncao));
       }
        Double raizEncontrada = raizesDaFuncao.get(raizesDaFuncao.size() - 1);
        System.out.println("Finalização do calculo de raízes reais: " + raizEncontrada);
        auditoria.get(auditoria.size() - 1).setRaizDaFuncaoEncontrada(raizEncontrada);
        return listarAuditoria();
    }


    public List<Auditoria> listarAuditoria() {
        System.out.println("Auditoria");
        auditoria.forEach(intervalo -> System.out.println(intervalo.toString()));
        return auditoria;
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
        Double modulo = Math.abs(intervalo.getB() - intervalo.getA());
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

    /**
     * Calcular o array gerado pelo polinomio Ex: [-5,-4,-3,-2,-1,0,1,2,3,4,5]
     * e aplica esses valores na funcao para gerar o sinal
     *  @param entradaFuncao
     * @param valores
     * @return
     */
    public List<Controle> analisarEntradas(EntradaFuncao entradaFuncao, List<Integer> valores) {
        valores.forEach(valor -> {
            if(valor != null) {
                Double resultado = calcularFuncao(entradaFuncao, Double.valueOf(valor));
                Controle controle = gerarSinal(resultado, Double.valueOf(valor));
                dadosAnalisadosEntrada.add(controle);
            }
        });
        System.out.println("_________________________________________________");
        System.out.println("Gerado os valores com os sinais \n");
        dadosAnalisadosEntrada.forEach(c -> System.out.println(c.toString()));
        return dadosAnalisadosEntrada;
    }

    /**
     * É responsavel por gerar o sinal de acordo com o resultado
     *
     * @param resultado
     * @param elemento
     * @return
     */
    public Controle gerarSinal(Double resultado, Double elemento) {
        if (resultado > 0) {
            return new Controle("+", elemento);
        } else {
            return new Controle("-", elemento);
        }
    }

    /**
     * É responsavel por gerar o arra de range gerado pelo polinomio Ex: [-5,-4,-3,-2,-1,0,1,2,3,4,5]
     * @param entradaFuncao
     * @return
     */
    public List<Integer> retornaRange(EntradaFuncao entradaFuncao) {
        int contador = 0;
        if(entradaFuncao.getEntradaUm() != null) {
//            contador++;
            contador = 1;
        }

        if(entradaFuncao.getEntradaDois() != null) {
//            contador++;
            contador = 2;
        }
        if(entradaFuncao.getEntradaTres() != null) {
//            contador++;
            contador = 3;
        }

        if(entradaFuncao.getEntradaQuatro() != null) {
//            contador++;
            contador = 4;
        }

        if(entradaFuncao.getEntradaCinco() != null) {
//            contador++;
            contador = 5;
        }

        if(entradaFuncao.getEntradaSeis() != null) {
            contador = 6;
//            contador++;
        }

        List<Integer> valores = IntStream.range(-contador, contador).boxed().collect(Collectors.toList());
        valores.add(valores.get(valores.size() - 1) + 1);
        return valores;
    }



    public List<Intervalo> gerarIntervalos(List<Controle> controles) {
        List<Intervalo> intervalosNovos = new ArrayList<>();
        String sinalAtual = controles.get(0).getSinal();
        for(int i=0; i < controles.size();  i++) {
            if(!controles.get(i).getSinal().equals(sinalAtual)) {
                intervalosNovos.add(new Intervalo(controles.get(i-1).getValue(), controles.get(i).getValue()));
                sinalAtual = controles.get(i).getSinal();
            }
        }
        System.out.println("____________________________________________");
        System.out.println("Intervalos Gerados \n");
        intervalosNovos.forEach(i -> System.out.println(i.toString()));
        return intervalosNovos;
    }
}
