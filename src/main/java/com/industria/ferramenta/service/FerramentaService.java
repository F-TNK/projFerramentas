/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.industria.ferramenta.service;

import com.industria.ferramenta.model.FerramentaDTO;
import com.industria.ferramenta.repository.FerramentaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author ftana
 */
@Service
public class FerramentaService {
    
    @Autowired
    private FerramentaDAO fdao;
    
    public void novaFerramenta(FerramentaDTO f){
        String message = "";
        if (f.getNome().isEmpty()){
            message += "Nome não preenchido!";
        }
        if (f.getHorasDeUso() == null || f.getHorasDeUso() < 0){
            message += "Horas de uso invalidas!";
        }
        if (f.getVidaUtilMaxima() <= 0){
            message += "Vida util invalida!";
        }
        if (!message.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), message);
        }
        
        fdao.novaFerramenta(f);   
    }
    
    
    public List<FerramentaDTO> listarFerramentas(){
        return fdao.listarFerramentas();
    }
    
    public void update(FerramentaDTO ferramenta){
        String message = "";
        if (ferramenta.getNome().isEmpty()){
            message += "Nome não preenchido!";
        }
        if (ferramenta.getHorasDeUso() == null || ferramenta.getHorasDeUso() < 0){
            message += "Horas de uso invalidas!";
        }
        if (ferramenta.getVidaUtilMaxima() <= 0){
            message += "Vida util invalida!";
        }
        if (!message.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), message);
        }
        fdao.update(ferramenta);
    }
    
    
    public void deleteById(Long id){
        fdao.deleteById(id);
    }
}
