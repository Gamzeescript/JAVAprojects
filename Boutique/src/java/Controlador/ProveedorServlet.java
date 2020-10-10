/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ProveedorDao;
import Modelo.ProveedorBean;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
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
 * @author liliana.gironusam
 */
public class ProveedorServlet extends HttpServlet {
    Conexion conn = new Conexion();
    List<ProveedorBean> lista = new LinkedList<>();
    ProveedorDao pd = new ProveedorDao(conn);
    String msg = "";
    RequestDispatcher rd;
    boolean res;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        
        String action = request.getParameter("action");
        switch (action){
            case "insertar": insertar(request, response); break;
            case "actualizar": actualizar(request, response); break;
            case "consultarTodos": consultarTodos(request, response); break;
            case "consultarporId": consultarporId(request, response); break;
            case "eliminar": eliminar(request, response); break;
            default: throw new AssertionError();
        }
       
    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        
        ProveedorBean p = new ProveedorBean(0);
        p.setNombre(nombre);
        p.setTelefono(telefono);
        p.setDireccion(direccion);
        p.setEmail(email);
        
        res = pd.insertar(p);
        if (res){
            msg = "registro guardado exitosamente";
        }
        else {
            msg = "error";
        }
        
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registro_proveedor.jsp");
        rd.forward(request, response);
        
    }
    
    
    protected void consultarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        
        lista = pd.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_proveedor.jsp");
        rd.forward(request, response);       
         
     
        
        
    }
    protected void consultarporId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        
        
        int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
        lista = pd.mostrarporId(idproveedor);
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/modificar_proveedor.jsp");
        rd.forward(request, response);
        
        
    }
    
        protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
            
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String email = request.getParameter("email");
            

            ProveedorBean p = new ProveedorBean(idproveedor);
            p.setNombre(nombre);
            p.setTelefono(telefono);
            p.setDireccion(direccion);
            p.setEmail(email);
            
            res = pd.modificar(p);
            if (res){
                msg = "Registro modificado";
            }
            else {
                msg = "error";
                
            }
            
            lista = pd.mostrar();
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_proveedor.jsp");
        rd.forward(request, response);       
            
    }
        
        
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        
        int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
        res = pd.eliminar(idproveedor);
        lista = pd.mostrar();
        
        
        if (res){
            msg = "registro eliminado";
        }        
        else{
            msg = "error";
        }
       
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_proveedor.jsp");
        rd.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
