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
    @PostMapping("/{tipo}")
    public List<Auditoria> calcularFuncao(@RequestBody EntradaFuncao entradaFuncao, @PathVariable String tipo) {
       System.out.println("Start Calcular Funcao - " + tipo);
       return calculoService.aplicarFuncao(entradaFuncao);
    }

}