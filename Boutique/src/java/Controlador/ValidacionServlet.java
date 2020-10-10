/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioDao;
import Modelo.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author liliana.gironusam
 */
@WebServlet(name = "ValidacionServlet", urlPatterns = {"/validacionServlet"})
public class ValidacionServlet extends HttpServlet {
    
    UsuarioBean u = new UsuarioBean();
    UsuarioDao udao = new UsuarioDao();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
      
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
          String action = request.getParameter("action");
        if (action.equalsIgnoreCase("ingresar")){
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            u = udao.validarUser(usuario, pass);
            if (u.getUsuario() != null) {
                request.getRequestDispatcher("usuarioServlet?action=index").forward(request, response);
             }
            else{
                request.getRequestDispatcher("usuarioServlet?action=login").forward(request, response);

                
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
