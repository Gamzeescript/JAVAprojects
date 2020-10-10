/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DepartamentoBean;
import Modelo.JoyeriaBean;
import Modelo.MetalBean;
import Modelo.ProveedorBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liliana.gironusam
 */
public class JoyeriaDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    ProveedorBean p;
    MetalBean m;
    DepartamentoBean d;
    

    public JoyeriaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(JoyeriaBean j) {
        String sql = "insert into joyeria values(?,?,?,?,?,?)";
        p = j.getIdproveedor();
        d = j.getIddepartamento();
        m = j.getIdmetal();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, j.getIdjoyeria());
            ps.setInt(2, m.getIdmetal());
            ps.setInt(3, p.getIdproveedor());
            ps.setInt(4, d.getIddepartamento());
            ps.setString(5, j.getNombre());
            ps.setDouble(6, j.getPrecio());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<JoyeriaBean> mostrar() throws SQLException {
        List<JoyeriaBean> lista = new LinkedList<>();
        String sql = "Select * from joyeria";
        JoyeriaBean j;
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                j = new JoyeriaBean(rs.getInt("idjoyeria"));
                MetalBean m = new MetalBean(rs.getInt("idmetal"));
                ProveedorBean p = new ProveedorBean(rs.getInt("idproveedor"));
                DepartamentoBean d = new DepartamentoBean(rs.getInt("iddepartamento"));
                j.setIdmetal(m);
                j.setIdproveedor(p);
                j.setIddepartamento(d);
                j.setNombre(rs.getString("nombre"));
                j.setPrecio(rs.getDouble("precio"));
                lista.add(j);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<JoyeriaBean> mostrarporId(int idjoyeria) throws SQLException {
        List<JoyeriaBean> lista = new LinkedList<>();
        String sql = "Select * from joyeria where idjoyeria=?";
        JoyeriaBean j;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idjoyeria);
            rs = ps.executeQuery();

            while (rs.next()) {
                j = new JoyeriaBean(rs.getInt("idjoyeria"));
                MetalBean m = new MetalBean(rs.getInt("idmetal"));
                ProveedorBean p = new ProveedorBean(rs.getInt("idproveedor"));
                DepartamentoBean d = new DepartamentoBean(rs.getInt("iddepartamento"));
                j.setIdmetal(m);
                j.setIdproveedor(p);
                j.setIddepartamento(d);
                j.setNombre(rs.getString("nombre"));
                j.setPrecio(rs.getDouble("precio"));
                lista.add(j);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean modificar(JoyeriaBean j) {
        String sql = "update joyeria set idmetal=?, idproveedor=?, iddepartamento=?, nombre=?, precio=? where idjoyeria=?";
        m = j.getIdmetal();
        p = j.getIdproveedor();
        d = j.getIddepartamento();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, m.getIdmetal());
            ps.setInt(2, p.getIdproveedor());
            ps.setInt(3, d.getIddepartamento());
            ps.setString(4, j.getNombre());
            ps.setDouble(5, j.getPrecio());
            ps.setInt(6, j.getIdjoyeria());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int idjoyeria) {
        String sql = "delete from joyeria where idjoyeria=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idjoyeria);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
