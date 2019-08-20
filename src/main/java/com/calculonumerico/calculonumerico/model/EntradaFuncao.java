package com.calculonumerico.calculonumerico.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class EntradaFuncao {

    private Float entradaUm;
    private Float entradaDois;
    private Float entradaTres;
    private Float entradaQuatro;
    private Float entradaCinco;
    private Float entradaSeis;
    private Float entradaEpsilon;
}
