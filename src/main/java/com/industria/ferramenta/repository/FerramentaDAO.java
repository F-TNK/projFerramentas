/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.industria.ferramenta.repository;

import com.industria.ferramenta.model.FerramentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ftana
 */
@Repository
public class FerramentaDAO {
    
    
    public int novaFerramenta(FerramentaDTO f){
        int linhas = 0;
        // retorna linhas afetadas
        
        try {
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "insert into tb_ferramenta (nome, horas_de_uso, vida_util_maxima) values (?, ?, ?)");
            
            stmt.setString(1, f.getNome());
            stmt.setInt(2, f.getHorasDeUso());
            stmt.setInt(3, f.getVidaUtilMaxima());
            linhas = stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return linhas;
    }
    
    
    public List<FerramentaDTO> listarFerramentas(){
        List<FerramentaDTO> lista = new ArrayList<>();
        
        try {
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("select * from tb_ferramenta");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                FerramentaDTO f = new FerramentaDTO();
                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setHorasDeUso(rs.getInt("horas_de_uso"));
                f.setVidaUtilMaxima(rs.getInt("vida_util_maxima"));
                lista.add(f);    
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    
    public int update(FerramentaDTO ferramenta){
        int linhas = 0;
        
        try {
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("update tb_ferramenta SET nome=?, horas_de_uso=?, vida_util_maxima=? WHERE id=?");
            
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasDeUso());
            stmt.setInt(3, ferramenta.getVidaUtilMaxima());
            stmt.setLong(4, ferramenta.getId());
            
            linhas = stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return linhas;
    }
    
    public int deleteById(Long id){
        int linhas = 0;
        
        try{
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM tb_ferramenta WHERE id = ?");
            
            stmt.setLong(1, id);
            linhas = stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return linhas;
    }
}