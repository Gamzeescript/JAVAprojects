/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import DAO.VentaDao;
import Modelo.ClienteBean;
import Modelo.LacteoBean;
import Modelo.VentaBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michelle Giron
 */
public class VentaServlet extends HttpServlet {
    
    Conexion conn = new Conexion();
    VentaDao ventad = new VentaDao(conn);
    List<VentaBean> lista;
    RequestDispatcher rd;
    boolean res;
    String msg = "";
    SimpleDateFormat formato;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        
        String action = request.getParameter("action");
        switch (action){
            case "insertar": insertar(request, response); break;
            case "mostrar": mostrar(request, response); break;
            case "mostrarporId": mostrarporId(request, response); break;
            case "actualizar": actualizar(request, response); break;
            case "eliminar": eliminar(request, response); break;
            default: throw new AssertionError();
        }
        
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        int idlacteo = Integer.parseInt(request.getParameter("idlacteo"));
        Double precio = Double.parseDouble(request.getParameter("precio"));
        String fecha = request.getParameter("fecha");
        
        ClienteBean clienteb = new ClienteBean();
        LacteoBean lacteob = new LacteoBean();
        
        VentaBean ventab = new VentaBean(0);
        clienteb.setIdcliente(idcliente);
        ventab.setIdcliente(clienteb);
        lacteob.setIdlacteo(idlacteo);
        ventab.setIdlacteo(lacteob);
        ventab.setPrecio(precio);
        ventab.setFecha(formato.parse(fecha));
        
        if(ventad.insertar(ventab)){
            msg = "exito insertando un registro";
        }
        
        else{
            msg = "error";
        }
        
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registro_venta.jsp");
        rd.forward(request, response);
        
        
        
    }
    
    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        lista = ventad.mostrar();
        
    request.setAttribute("lista", lista);
    rd = request.getRequestDispatcher("/mostrar_venta.jsp");
    rd.forward(request, response);
        
        
    }
    
    protected void mostrarporId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idventa = Integer.parseInt(request.getParameter("idventa"));
        
        lista = ventad.mostrarporId(idventa);
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/modificar_venta.jsp");
        rd.forward(request, response);
        
        
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        
        formato = new SimpleDateFormat("yyyy-MM-dd");
        
        int idventa = Integer.parseInt(request.getParameter("idventa"));
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        int idlacteo = Integer.parseInt(request.getParameter("idlacteo"));
        Double precio = Double.parseDouble(request.getParameter("precio"));
        String fecha = request.getParameter("fecha");
        
        ClienteBean clienteb = new ClienteBean();
        LacteoBean lacteob = new LacteoBean();
        
        VentaBean ventab = new VentaBean(idventa);
        clienteb.setIdcliente(idcliente);
        ventab.setIdcliente(clienteb);
        lacteob.setIdlacteo(idlacteo);
        ventab.setIdlacteo(lacteob);
        ventab.setPrecio(precio);
        ventab.setFecha(formato.parse(fecha));
        
        if(ventad.actualizar(ventab)){
            lista = ventad.mostrar();
        }
        
        else{
            msg = "error";
        }
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_venta.jsp");
        rd.forward(request, response);
    }

    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idventa = Integer.parseInt(request.getParameter("idventa"));
        
        ventad.eliminar(idventa);
        lista = ventad.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_venta.jsp");
        rd.forward(request, response);
        
        
    }
 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
