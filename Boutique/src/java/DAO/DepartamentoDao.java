/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DepartamentoBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DepartamentoDao {
    
    
    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public DepartamentoDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(DepartamentoBean d){
        String sql = "insert into departamento values(?,?)";
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, d.getIddepartamento());
            ps.setString(2, d.getDepartamento());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public List<DepartamentoBean> mostrar() throws SQLException {
        List<DepartamentoBean> lista = new LinkedList<>();
        String sql = "select * from departamento";
        DepartamentoBean d;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                d = new DepartamentoBean(rs.getInt("iddepartamento"));
                d.setDepartamento(rs.getString("departamento"));
                lista.add(d);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<DepartamentoBean> mostrarporId(int iddepartamento) throws SQLException {
        List<DepartamentoBean> lista = new LinkedList<>();
        String sql = "select * from departamento where iddepartamento=?";
        DepartamentoBean d;
        
       try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, iddepartamento);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                d = new DepartamentoBean(rs.getInt("iddepartamento"));
                d.setDepartamento(rs.getString("departamento"));
                lista.add(d);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public boolean modificar(DepartamentoBean d) {
        String sql = "update departamento set departamento=? where iddepartamento=?";
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, d.getDepartamento());
            ps.setInt(2, d.getIddepartamento());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
        
        
    }
    
    
    public boolean eliminar(int iddepartamento) {
        String sql = "delete from departamento where iddepartamento=?";
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, iddepartamento);
            ps.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
}
