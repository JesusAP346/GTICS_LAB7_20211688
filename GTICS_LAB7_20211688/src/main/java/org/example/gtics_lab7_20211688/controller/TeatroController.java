package org.example.gtics_lab7_20211688.controller;


import org.example.gtics_lab7_20211688.repository.FuncionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TeatroController {
    @Autowired
    FuncionesRepository funcionesRepository;


    @GetMapping("/Admin")
    public String funcionesAdmin(Model model){

        model.addAttribute("listaFunciones",funcionesRepository.findAll());
        return "listaFunciones";
    }
}
