/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DepartamentoDao;
import Modelo.DepartamentoBean;
import conexion.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
 * @author Michelle Giron
 */
public class DepartamentoServlet extends HttpServlet {

    Conexion conn = new Conexion();
    List<DepartamentoBean> lista = new LinkedList<>();
    DepartamentoDao dd = new DepartamentoDao(conn);
    String msg = "";
    RequestDispatcher rd;
    boolean res;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insertar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "consultarTodos":
                consultarTodos(request, response);
                break;
            case "consultarporId":
                consultarporId(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        String departamento = request.getParameter("departamento");

        DepartamentoBean d = new DepartamentoBean(0);
        d.setDepartamento(departamento);

        res = dd.insertar(d);
        if (res) {
            msg = "registro guardado exitosamente";
        } else {
            msg = "error";
        }

        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/registro_departamento.jsp");
        rd.forward(request, response);

    }

    protected void consultarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        lista = dd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_departamento.jsp");
        rd.forward(request, response);

    }

    protected void consultarporId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        int idproveedor = Integer.parseInt(request.getParameter("iddepartamento"));
        lista = dd.mostrarporId(idproveedor);

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/modificar_departamento.jsp");
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
        String departamento = request.getParameter("departamento");

        DepartamentoBean d = new DepartamentoBean(iddepartamento);
        d.setDepartamento(departamento);

        res = dd.modificar(d);
        if (res) {
            msg = "Registro modificado";
        } else {
            msg = "error";

        }

        lista = dd.mostrar();

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_departamento.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
        res = dd.eliminar(iddepartamento);
        lista = dd.mostrar();

        if (res) {
            msg = "registro eliminado";
        } else {
            msg = "error";
        }

        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_departamento.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DepartamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DepartamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
