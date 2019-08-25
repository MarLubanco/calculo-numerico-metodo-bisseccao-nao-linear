package com.calculonumerico.calculonumerico.controller;

import com.calculonumerico.calculonumerico.model.Auditoria;
import com.calculonumerico.calculonumerico.model.EntradaFuncao;
import com.calculonumerico.calculonumerico.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/calculo-numerico")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping
    public List<Auditoria> calcularFuncao(@RequestBody EntradaFuncao entradaFuncao) {
       return calculoService.aplicarFuncao(entradaFuncao);
    }

}