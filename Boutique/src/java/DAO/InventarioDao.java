/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DepartamentoBean;
import Modelo.InventarioBean;
import Modelo.JoyeriaBean;
import Modelo.ProveedorBean;
import Modelo.RopaBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class InventarioDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    ProveedorBean p;
    JoyeriaBean j;
    RopaBean r;
    DepartamentoBean d;
    SimpleDateFormat formato;

    public InventarioDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(InventarioBean i) {
        String sql = "insert into inventario values(?,?,?,?,?,?,?,?,?)";
        formato = new SimpleDateFormat("yy-MM-dd");

        p = i.getIdproveedor();
        j = i.getIdjoyeria();
        r = i.getIdropa();
        d = i.getIddepartamento();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, i.getIdinventario());
            ps.setInt(2, p.getIdproveedor());
            ps.setInt(3, j.getIdjoyeria());
            ps.setInt(4, r.getIdropa());
            ps.setInt(5, d.getIddepartamento());
            ps.setInt(6, i.getExistencia());
            ps.setInt(7, i.getStock());
            ps.setString(8, formato.format(i.getFecha_entrada()));
            ps.setString(9, formato.format(i.getFecha_salida()));
            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public List<InventarioBean> mostrar() throws SQLException {
        List<InventarioBean> lista = new LinkedList<>();
        String sql = "select * from inventario";
        formato = new SimpleDateFormat("yy-MM-dd");
        InventarioBean i;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                i = new InventarioBean(rs.getInt("idinventario"));
                ProveedorBean p = new ProveedorBean(rs.getInt("idproveedor"));
                JoyeriaBean j = new JoyeriaBean(rs.getInt("idjoyeria"));
                RopaBean r = new RopaBean(rs.getInt("idropa"));
                DepartamentoBean d = new DepartamentoBean(rs.getInt("iddepartamento"));

                i.setIdproveedor(p);
                i.setIdjoyeria(j);
                i.setIdropa(r);
                i.setIddepartamento(d);
                i.setExistencia(rs.getInt("existencia"));
                i.setStock(rs.getInt("stock"));
                i.setFecha_entrada(rs.getDate("fecha_entrada"));
                i.setFecha_salida(rs.getDate("fecha_salida"));
                lista.add(i);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<InventarioBean> mostrarporId(int idinventario) throws SQLException {
        List<InventarioBean> lista = new LinkedList<>();
        String sql = "select * from inventario where idinventario=?";
        formato = new SimpleDateFormat("yy-MM-dd");
        InventarioBean i;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idinventario);
            rs = ps.executeQuery();

            while (rs.next()) {
                i = new InventarioBean(rs.getInt("idinventario"));
                ProveedorBean p = new ProveedorBean(rs.getInt("idproveedor"));
                JoyeriaBean j = new JoyeriaBean(rs.getInt("idjoyeria"));
                RopaBean r = new RopaBean(rs.getInt("idropa"));
                DepartamentoBean d = new DepartamentoBean(rs.getInt("iddepartamento"));

                i.setIdproveedor(p);
                i.setIdjoyeria(j);
                i.setIdropa(r);
                i.setIddepartamento(d);
                i.setExistencia(rs.getInt("existencia"));
                i.setStock(rs.getInt("stock"));
                i.setFecha_entrada(rs.getDate("fecha_entrada"));
                i.setFecha_salida(rs.getDate("fecha_salida"));
                lista.add(i);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean modificar(InventarioBean i) {
        String sql = "update inventario set idproveedor=?, idjoyeria=?, idropa=?, iddepartamento=?, existencia=?, stock=?, fecha_entrada=?, fecha_salida=? where idinventario=?";        
        formato = new SimpleDateFormat("yy-MM-dd");

        p = i.getIdproveedor();
        j = i.getIdjoyeria();
        r = i.getIdropa();
        d = i.getIddepartamento();

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, i.getIdinventario());
            ps.setInt(2, p.getIdproveedor());
            ps.setInt(3, j.getIdjoyeria());
            ps.setInt(4, r.getIdropa());
            ps.setInt(5, d.getIddepartamento());
            ps.setInt(6, i.getExistencia());
            ps.setInt(7, i.getStock());
            ps.setString(8, formato.format(i.getFecha_entrada()));
            ps.setString(9, formato.format(i.getFecha_salida()));
            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            return false;
        }

    }



    public boolean eliminar(int idinventario) {
        String sql = "delete from inventario where idinventario=?";

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idinventario);
            ps.executeUpdate();
            
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
