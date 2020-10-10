/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.RopaDao;
import Modelo.MarcaBean;
import Modelo.ProveedorBean;
import Modelo.TallaBean;
import Modelo.DepartamentoBean;
import Modelo.RopaBean;
import conexion.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RopaServlet extends HttpServlet {
    
    Conexion conn = new Conexion();
    List<RopaBean> lista = new LinkedList();
    RopaDao rd = new RopaDao(conn);
    RequestDispatcher rqd;
    String msg = "";
    boolean res;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        String action = (request.getParameter("action"));
        
        switch (action){
            case "insertar": insertar(request, response); break;
            case "mostrarTodo": mostrarTodo(request, response); break;
            case "mostrarporId": mostrarporId(request, response); break;
            case "actualizar": actualizar(request, response); break;
            case "eliminar": eliminar(request, response); break;
            default: throw new AssertionError();
        }  
        
        }
  
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            MarcaBean idm = new MarcaBean(0);
            TallaBean idt = new TallaBean(0);
            ProveedorBean idp = new ProveedorBean(0);
            DepartamentoBean idd = new DepartamentoBean(0);
            
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            idm.setIdmarca(idmarca);
            int idtalla = Integer.parseInt(request.getParameter("idtalla"));
            idt.setIdtalla(idtalla);
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            idp.setIdproveedor(idproveedor);
            int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            idd.setIddepartamento(iddepartamento);
            
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            
            RopaBean r = new RopaBean(0);
            r.setIdmarca(idm);
            r.setIdtalla(idt);
            r.setIdproveedor(idp);
            r.setIddepartamento(idd);
            r.setNombre(nombre);
            r.setPrecio(precio);
            
            res = rd.insertar(r);
            if(res){
                msg = "registro guardado exitosamente";
            }
            else{
                msg = "error al guardar los datos";
            }
            
            request.setAttribute("msg", msg);
            rqd = request.getRequestDispatcher("/registro_ropa.jsp");
            rqd.forward(request, response);

        
        }
    
    protected void mostrarTodo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        lista = rd.mostrar();
            
            request.setAttribute("lista", lista);
            rqd = request.getRequestDispatcher("/mostrar_ropa.jsp");
            rqd.forward(request, response);
        
        
        
        }
    
    protected void mostrarporId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idropa = Integer.parseInt(request.getParameter("idropa"));
            lista = rd.mostrarporId(idropa);
            
            request.setAttribute("lista", lista);
            rqd = request.getRequestDispatcher("/modificar_ropa.jsp");
            rqd.forward(request, response);
        
        
        }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
            MarcaBean idm = new MarcaBean(0);
            TallaBean idt = new TallaBean(0);
            ProveedorBean idp = new ProveedorBean(0);
            DepartamentoBean idd = new DepartamentoBean(0);
            
            int idropa = Integer.parseInt(request.getParameter("idropa"));
            
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            idm.setIdmarca(idmarca);
            int idtalla = Integer.parseInt(request.getParameter("idtalla"));
            idt.setIdtalla(idtalla);
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            idp.setIdproveedor(idproveedor);
            int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            idd.setIddepartamento(iddepartamento);
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            
            RopaBean r = new RopaBean(idropa);
            r.setIdmarca(idm);
            r.setIdtalla(idt);
            r.setIdproveedor(idp);
            r.setIddepartamento(idd);
            r.setNombre(nombre);
            r.setPrecio(precio);
            
            res = rd.modificar(r);
            if(res){
                msg="Registro modificado exitosamente";
            }
            else {
                msg="error modificando el registro";
            }
            
            lista = rd.mostrar();
                   
            request.setAttribute("lista", lista);
            rqd = request.getRequestDispatcher("/mostrar_ropa.jsp");
            rqd.forward(request, response);
        
        
        
        }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idropa = Integer.parseInt(request.getParameter("idropa"));
        
        res = rd.eliminar(idropa);
        lista = rd.mostrar();
        
        if (res){
            msg = "eliminado con exito";
        }
        else{
            msg = "error";
        }
        
        request.setAttribute("lista", lista);
        rqd = request.getRequestDispatcher("/mostrar_ropa.jsp");
        rqd.forward(request, response);
        
        
        
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RopaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RopaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
