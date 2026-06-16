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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ftana
 */
@RestController
@RequestMapping("/ferramentas")
public class FerramentaController {
    
    @Autowired
    private FerramentaService service;
    
    @PostMapping("/ferramentas/salvar")
    public String novaFerramenta(FerramentaDTO f){
        service.novaFerramenta(f);
        return "redirect:/ferramentas";
    }
    
    @GetMapping("/ferramentas")
    public List<FerramentaDTO> listarFerramentas(){
        return service.listarFerramentas();
    }
    
    @PutMapping
    public String update(FerramentaDTO ferramenta){
        service.update(ferramenta);
        return "redirect:/ferramentas";
    }
    
}
