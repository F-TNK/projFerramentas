/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.industria.ferramenta.controller;

import com.industria.ferramenta.model.FerramentaDTO;
import com.industria.ferramenta.service.FerramentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ftana
 */
@Controller
// @RequestMapping
public class FerramentaController {
    
    @Autowired
    private FerramentaService service;
    
    @GetMapping("/")
    public String index() {
        return "redirect:/ferramentas";
    }
    
    @GetMapping("/ferramentas")
    public String listarFerramentas(Model model){
        List<FerramentaDTO> lista = service.listarFerramentas();

        model.addAttribute("ferramentas", lista);
        
        return "ferramentas";
    }
    
    @PostMapping("/salvar")
    public String novaFerramenta(FerramentaDTO f){
        service.novaFerramenta(f);
        return "redirect:/ferramentas";
    }
    
    @PutMapping("/alterar")
    public String update(FerramentaDTO ferramenta){
        service.update(ferramenta);
        return "redirect:/ferramentas";
    }
    
}
