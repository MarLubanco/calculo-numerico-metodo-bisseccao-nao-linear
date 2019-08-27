package com.calculonumerico.calculonumerico.controller;

import com.calculonumerico.calculonumerico.model.Auditoria;
import com.calculonumerico.calculonumerico.model.EntradaFuncao;
import com.calculonumerico.calculonumerico.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calculo-numerico")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @CrossOrigin
    @PostMapping
    public List<Auditoria> calcularFuncao(@RequestBody EntradaFuncao entradaFuncao) {
       System.out.println("Start Calcular Funcao");
       return calculoService.aplicarFuncao(entradaFuncao);
    }

}