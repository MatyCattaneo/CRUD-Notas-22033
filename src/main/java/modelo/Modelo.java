/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author Matias
 */
public interface Modelo {
    
    public List<Nota> getNotas();
    
    public Nota getNota(int id);
    
    public int addNota(Nota nota);
    
    public int updateNota(Nota nota);
    
    public int removeNota(int id);
}
