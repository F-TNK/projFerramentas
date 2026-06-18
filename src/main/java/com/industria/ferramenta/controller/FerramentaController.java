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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("ferramenta", new FerramentaDTO());
        
        return "ferramentas";
    }
    
    @PostMapping("/ferramentas/salvar")
    public String salvar(@ModelAttribute FerramentaDTO ferramenta, Model model) {
        try {
            service.novaFerramenta(ferramenta);
            return "redirect:/ferramentas";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("listaFerramentas", service.listarFerramentas());
            model.addAttribute("ferramenta", ferramenta);
            return "lista";
        }
    }
    
    @GetMapping("/ferramentas/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        // RedirectAttributes e addFlashAttribute:
        // Criam um atributo temporario para mensagem de confirmacao/erro
        
        boolean removido = service.deleteById(id);
        if (removido) {
            redirectAttributes.addFlashAttribute("Sucesso", "Ferramenta removida com sucesso!");
        }
        return "redirect:/ferramentas";
    }
    
    @GetMapping("/ferramentas/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        List<FerramentaDTO> lista = service.listarFerramentas();
        FerramentaDTO ferramentaEditada = null;
        
        for (FerramentaDTO f : lista) {
            if (f.getId().equals(id)) {
                ferramentaEditada = f;
                break;
            }
        }
        model.addAttribute("ferramenta", ferramentaEditada);
        model.addAttribute("ferramentas", lista);

        return "ferramentas";
    }
    
    @PostMapping("/ferramentas/alterar")
    public String alterar(
            @ModelAttribute FerramentaDTO ferramenta,
            RedirectAttributes redirectAttributes
    ){
            // RedirectAttributes e addFlashAttribute:
            // Criam um atributo temporario para mensagem de confirmacao/erro
            
        service.update(ferramenta);
        redirectAttributes.addFlashAttribute("Sucesso", "Ferramenta atualizada com sucesso!");
        return "redirect:/ferramentas";
    }
    
}
