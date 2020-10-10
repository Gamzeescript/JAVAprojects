/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.ClienteBean;
import Modelo.LacteoBean;
import Modelo.VentaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Michelle Giron
 */
public class VentaDao {
    
    Conexion conn;
    ClienteBean clienteb;
    LacteoBean lacteob;
    PreparedStatement ps;
    ResultSet rs;
    SimpleDateFormat formato;

    public VentaDao(Conexion conn) {
        this.conn = conn;
    }
    
    
    
    public boolean insertar(VentaBean ventab){
        String sql = "insert into venta values(?,?,?,?,?)";
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        clienteb = ventab.getIdcliente();
        lacteob = ventab.getIdlacteo();
        
        try {
           ps = conn.conectar().prepareStatement(sql);
           ps.setInt(1, ventab.getIdventa());
           ps.setInt(2, clienteb.getIdcliente());
           ps.setInt(3, lacteob.getIdlacteo());
           ps.setDouble(4, ventab.getPrecio());
           ps.setString(5, formato.format(ventab.getFecha()));
           ps.executeUpdate();
           
           return true;
            
        } catch (Exception e) {
            return false;
        }
 
       
    }
    
    public List<VentaBean> mostrar() throws SQLException{
        String sql = "select * from venta";
        List<VentaBean> lista = new LinkedList<>();
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            while(rs.next()){
                VentaBean ventab = new VentaBean(rs.getInt("idventa"));               
                ClienteBean clienteb = new ClienteBean(rs.getInt("idcliente"));
                LacteoBean lacteob = new LacteoBean(rs.getInt("idlacteo"));
                                
                ventab.setIdcliente(clienteb);
                ventab.setIdlacteo(lacteob);
                ventab.setPrecio(rs.getDouble("precio"));
                ventab.setFecha(rs.getDate("fecha"));
                lista.add(ventab);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<VentaBean> mostrarporId(int idventa) throws SQLException{
        String sql = "select * from venta where idventa=?";
        VentaBean ventab;
        List<VentaBean> lista = new LinkedList<>();
        formato = new SimpleDateFormat("yyyy-MM-dd"); 
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idventa);
            rs = ps.executeQuery();
            
            
            while(rs.next()){                
                ventab = new VentaBean(rs.getInt("idventa"));
                ClienteBean clienteb = new ClienteBean(rs.getInt("idcliente"));
                LacteoBean lacteob = new LacteoBean(rs.getInt("idlacteo"));
                               
                ventab.setIdcliente(clienteb);
                ventab.setIdlacteo(lacteob);
                ventab.setPrecio(rs.getDouble("precio"));
                ventab.setFecha(rs.getDate("fecha"));
                lista.add(ventab);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public boolean actualizar(VentaBean ventab){        
    String sql = "update venta set idcliente=?, idlacteo=?, precio=?, fecha=? where idventa=?";
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        clienteb = ventab.getIdcliente();
        lacteob = ventab.getIdlacteo();
        
        try {
           ps = conn.conectar().prepareStatement(sql);
           ps.setInt(1, clienteb.getIdcliente());
           ps.setInt(2, lacteob.getIdlacteo());
           ps.setDouble(3, ventab.getPrecio());
           ps.setString(4, formato.format(ventab.getFecha()));
           ps.setInt(5, ventab.getIdventa());
           ps.executeUpdate();
           
           return true;
            
        } catch (Exception e) {
            return false;
        }
 
       
    }
    
    public boolean eliminar(int idventa){
        String sql = "delete from venta where idventa=?";
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idventa);
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
    
}
