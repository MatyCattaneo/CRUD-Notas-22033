/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
public class ModeloMySQL implements Modelo {
    
    private static final String GET_ALL_QUERY = "SELECT * FROM notas";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM notas WHERE id = ?";
    private static final String ADD_QUERY = "INSERT INTO notas VALUES (null, ?)";
    private static final String UPDATE_QUERY = "UPDATE notas SET descripcion = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM notas WHERE id = ?";

    @Override
    public List<Nota> getNotas() {
        List<Nota> notas = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                notas.add(rsToNota(rs));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
        
        return notas;
    }
    
    @Override
    public Nota getNota(int id){
        Nota nota = null;
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery();) {
                rs.next();
                nota = rsToNota(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
        return nota;
    }

    @Override
    public int addNota(Nota nota) {
       int registrosAgregados = 0;
       try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(ADD_QUERY);
            ps.setString(1, nota.getDescripcion());
            registrosAgregados = ps.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
       
       return registrosAgregados;
    }

    @Override
    public int updateNota(Nota nota) {
       int registrosEditados = 0;
       try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, nota.getDescripcion());
            ps.setInt(2, nota.getId());
            registrosEditados = ps.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
       
       return registrosEditados;
    }

    @Override
    public int removeNota(int id) {
       int registrosEliminados = 0;
       try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, id);
            registrosEliminados = ps.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
       
       return registrosEliminados;        
    }
    
    private Nota rsToNota(ResultSet rs)throws SQLException{
        int id = rs.getInt(1);
        String descripcion = rs.getString(2);
        return new Nota(id, descripcion);
    }
}
