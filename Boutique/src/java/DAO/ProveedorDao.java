
package DAO;

import Modelo.ProveedorBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


public class ProveedorDao {
    
    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    SimpleDateFormat formato;

    public ProveedorDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(ProveedorBean p){
        String sql = "insert into proveedor values(?,?,?,?,?)";
                
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, p.getIdproveedor());
            ps.setString(2,p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getEmail());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public List<ProveedorBean> mostrar() throws SQLException{
        List <ProveedorBean> lista = new LinkedList<>();
        String sql = "Select * from proveedor";
        ProveedorBean p;
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                p = new ProveedorBean(rs.getInt("idproveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
                p.setEmail(rs.getString("email"));
                lista.add(p);              
            }
             return lista;
        } catch (Exception e) {
            return null;
        }
    } 
    
    public List<ProveedorBean> mostrarporId(int idproveedor) throws SQLException{
        List <ProveedorBean> lista = new LinkedList<>();
        String sql = "Select * from proveedor where idproveedor=?";
        ProveedorBean p;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idproveedor);
            rs = ps.executeQuery();

            
            while(rs.next()){
                p = new ProveedorBean(rs.getInt("idproveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
                p.setEmail(rs.getString("email"));
                lista.add(p);                
            }
            return lista;
            
        } catch (Exception e) {
                return null;
        }
    }

    
    public boolean modificar(ProveedorBean p){
        String sql = "update proveedor set nombre=?, telefono=?, direccion=?, email=? where idproveedor=?";
        try {
            System.out.println(sql);
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.setString(4, p.getEmail());
            ps.setInt(5, p.getIdproveedor());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int idproveedor){
        String sql = "delete from proveedor where idproveedor=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idproveedor);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
