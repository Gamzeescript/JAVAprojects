
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    Connection conn = null;

     static String db = "boutique";
     static String user="root";
     static String pass="";
     static String url = "jdbc:mysql://localhost/"+db+"?useSSL=false";
    
    public Conexion(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                if(conn != null){
                    System.out.println("Conexion Establecida");
                }
            } catch (Exception e) {
                System.out.println("Conexion Rechazada " + e);
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


