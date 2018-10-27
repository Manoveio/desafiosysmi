package br.com.sysmi.desafio.controller;

import br.com.sysmi.desafio.model.Vagao;
import br.com.sysmi.desafio.service.TrainCompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrainController {

    @Autowired
    TrainCompositionService trainComposition;


    @GetMapping("/compoetrem")
    public String compoeTrem(Model model) {

        model.addAttribute("vagao", new Vagao());

        return "compoetrem";
    }

    @PostMapping("/compoetrem")
    public String adiciona(@ModelAttribute Vagao vagao, Model model) {

        model.addAttribute("trainComposition", trainComposition);
        if("E".equals(vagao.getEngate())) {
            trainComposition.adicionaVagaoEsquerda(vagao);
        } else
            trainComposition.adicionaVagaoDireita(vagao);

        return "adicionavagao";
    }

    @PostMapping("/removendo")
    public String removendo(@ModelAttribute Vagao vagao, Model model) {

        model.addAttribute("trainComposition", trainComposition);
        if("E".equals(vagao.getEngate()))
            trainComposition.removeVagaoEsquerda();
        else
            trainComposition.removeVagaoDireita();

        return "adicionavagao";
    }



}
