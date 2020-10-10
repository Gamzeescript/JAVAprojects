/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DepartamentoBean;
import Modelo.MarcaBean;
import Modelo.ProveedorBean;
import Modelo.RopaBean;
import Modelo.TallaBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RopaDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    MarcaBean m;
    TallaBean t;
    ProveedorBean p;
    DepartamentoBean d;

    public RopaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(RopaBean r) {
        String sql = "insert into ropa values(?,?,?,?,?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            m = r.getIdmarca();
            t = r.getIdtalla();
            p = r.getIdproveedor();
            d = r.getIddepartamento();

            ps.setInt(1, r.getIdropa());
            ps.setInt(2, m.getIdmarca());
            ps.setInt(3, t.getIdtalla());
            ps.setInt(4, p.getIdproveedor());
            ps.setInt(5, d.getIddepartamento());
            ps.setString(6, r.getNombre());
            ps.setDouble(7, r.getPrecio());
            ps.executeQuery();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<RopaBean> mostrar() throws SQLException {
        List<RopaBean> lista = new LinkedList<>();
        String sql = "Select * from ropa";
        RopaBean r;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new RopaBean(rs.getInt("idropa"));
                MarcaBean m = new MarcaBean(rs.getInt("idmarca"));
                TallaBean t = new TallaBean(rs.getInt("idtalla"));
                ProveedorBean p = new ProveedorBean(rs.getInt("idproveedor"));
                DepartamentoBean d = new DepartamentoBean(rs.getInt("iddepartamento"));
                r.setIdmarca(m);
                r.setIdtalla(t);
                r.setIdproveedor(p);
                r.setIdproveedor(p);
                r.setNombre(rs.getString("nombre"));
                r.setPrecio(rs.getDouble("precio"));
                lista.add(r);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<RopaBean> mostrarporId(int idropa) throws SQLException {
        String sql = "Select * from ropa where idropa=?";
        List<RopaBean> lista = new LinkedList<>();
        RopaBean r;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idropa);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new RopaBean(rs.getInt("idropa"));
                MarcaBean m = new MarcaBean(rs.getInt("idmarca"));
                TallaBean t = new TallaBean(rs.getInt("idtalla"));
                ProveedorBean p = new ProveedorBean(rs.getInt("idproveedor"));
                DepartamentoBean d = new DepartamentoBean(rs.getInt("iddepartamento"));
                r.setIdmarca(m);
                r.setIdtalla(t);
                r.setIdproveedor(p);
                r.setIddepartamento(d);
                r.setNombre(rs.getString("nombre"));
                r.setPrecio(rs.getDouble("precio"));
                lista.add(r);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean modificar(RopaBean r) {
        String sql = "update ropa set idmarca=?, idtalla=?, idproveedor=?, iddepartamento=?, nombre=?, precio=? where idropa=?";
        m = r.getIdmarca();
        t = r.getIdtalla();
        p = r.getIdproveedor();
        d = r.getIddepartamento();
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, m.getIdmarca());
            ps.setInt(2, t.getIdtalla());
            ps.setInt(3, p.getIdproveedor());
            ps.setInt(4, d.getIddepartamento());
            ps.setString(5, r.getNombre());
            ps.setDouble(6, r.getPrecio());
            ps.setInt(7, r.getIdropa());
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
        return false;
        }

    }
    
     public boolean eliminar(int idropa){
     String sql = "delete from ropa where idropa=?";
     
         try {
             ps = conn.conectar().prepareStatement(sql);
             ps.setInt(1, idropa);
             ps.executeUpdate();
             return true;
             
         } catch (Exception e) {
             return false;
         }
             
     }
     

}
