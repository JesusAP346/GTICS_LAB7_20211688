package org.example.gtics_lab7_20211688.controller;


import org.example.gtics_lab7_20211688.repository.FuncionesRepository;
import org.example.gtics_lab7_20211688.repository.ObrasRepository;
import org.example.gtics_lab7_20211688.repository.RoomSeatsRepository;
import org.example.gtics_lab7_20211688.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TeatroController {

    /*CREDENCIALES:
       ADMIN:
       admin@gmail.com
       admin

       GERENTE:
       gerente@gmail.com
       gerente

    * */






    @Autowired
    FuncionesRepository funcionesRepository;

    @Autowired
    RoomsRepository salasRepository;

    @Autowired
    ObrasRepository obrasRepository;

    @GetMapping({"/Admin/listaFunciones","/Admin"})
    public String funcionesAdmin(Model model){

        model.addAttribute("listaFunciones",funcionesRepository.findAll());
        return "listaFunciones";
    }

    @GetMapping({"/Gerente/listaSalas","/Gerente"})
    public String salasGerente(Model model){

        model.addAttribute("listaSalas",salasRepository.findAll());
        return "listaSalas";
    }

    @GetMapping({"/Gerente/listaObras"})
    public String obrasGerente(Model model){

        model.addAttribute("listaObras",obrasRepository.findAll());
        return "listaObras";
    }
}
