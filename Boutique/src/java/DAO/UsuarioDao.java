/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.UsuarioBean;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author liliana.gironusam
 */
public class UsuarioDao {
    
    Conexion conn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
    
    public UsuarioBean validarUser(String usuario, String pass){
    
         UsuarioBean u = new UsuarioBean();
         
        String sql = "select * from usuario where usuario=? and pass=?";

        try {
            con = conn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();//Guardo el resultado

            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));//Utilizar para validar
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("correo"));
                u.setUsuario(rs.getString("usuario"));
                u.setPass(rs.getString("pass"));//Utilizar para validar
                u.setDui(rs.getString("dui"));
   

                System.out.println("MetodoValidar:"+u);
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return u;

    }
    
}
