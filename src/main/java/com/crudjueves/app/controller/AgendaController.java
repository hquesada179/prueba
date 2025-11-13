package com.crudjueves.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudjueves.app.entidades.Agenda;
import com.crudjueves.app.entidades.repositorio.ReposotorioAgenda;

@Controller
public class AgendaController {

    @Autowired
    private ReposotorioAgenda agendaRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("agenda", new Agenda());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(Agenda agenda) {
        agendaRepository.save(agenda);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("contactos", agendaRepository.findAll());
        return "listar";
    }
}
