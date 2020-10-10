/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Michelle Giron
 */
public class Conexion {
    
    Connection conn = null;
    
    static String db = "lacteos";
    static String user = "root";
    static String pass = "";
    static String url = "jdbc:mysql://localhost/"+ db + "?useSSL=false";

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if(conn != null){
                System.out.println("Conexion Establecida");
            }
        } catch (Exception e) {
            System.out.println("No se ha podido establecer conexion con el mundo");
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws Exception{
        conn.close();
    }
    
    public static void main(String args[]){
        Conexion c = new Conexion();
        c.conectar();
    }
    
    
    
}
