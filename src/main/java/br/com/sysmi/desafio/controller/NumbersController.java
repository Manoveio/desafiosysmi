package br.com.sysmi.desafio.controller;

import br.com.sysmi.desafio.model.Resultado;
import br.com.sysmi.desafio.service.CountNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NumbersController {

    @Autowired
    CountNumbersService countNumbers;


    @GetMapping("/contanumeros")
    public String contaNumeros(Model model) {

        model.addAttribute("resultado", new Resultado());
        return "contanumeros";
    }

    @PostMapping("/contanumeros")
    public String resultadoConta(@ModelAttribute Resultado resultado) {

        countNumbers.countNumbers(resultado);

        return "resultadoconta";
    }






}
