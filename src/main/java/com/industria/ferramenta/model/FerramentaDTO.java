/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.industria.ferramenta.model;


/**
 *
 * @author ftana
 */
public class FerramentaDTO {
    
    private Long id;
    private String nome;
    private Integer horasDeUso;
    private int vidaUtilMaxima;

    public FerramentaDTO() {
    }

    public FerramentaDTO(Long id, String nome, Integer horasDeUso, int vidaUtilMaxima) {
        this.id = id;
        this.nome = nome;
        this.horasDeUso = horasDeUso;
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHorasDeUso() {
        return horasDeUso;
    }

    public void setHorasDeUso(Integer horasDeUso) {
        this.horasDeUso = horasDeUso;
    }

    public int getVidaUtilMaxima() {
        return vidaUtilMaxima;
    }

    public void setVidaUtilMaxima(int vidaUtilMaxima) {
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    
    
    
    // ----------- FUNC -----------
    
    public Double getPercentualDesgaste() {
        if (vidaUtilMaxima == 0) {
            return 0.0;
        }

        return (horasDeUso * 100.0) / vidaUtilMaxima;
    }
    
}