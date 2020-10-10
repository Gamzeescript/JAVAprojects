package Controlador;

import DAO.JoyeriaDao;
import DAO.ProveedorDao;
import Modelo.DepartamentoBean;
import Modelo.JoyeriaBean;
import Modelo.MetalBean;
import Modelo.ProveedorBean;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JoyeriaServlet extends HttpServlet {
    
    Conexion conn = new Conexion();
    List<JoyeriaBean> lista = new LinkedList();
    JoyeriaDao jd = new JoyeriaDao(conn);
    RequestDispatcher rd;
    String msg = "";
    boolean res;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String action = (request.getParameter("action"));
        switch (action) {
            case ("insertar"): insertar(request, response); break;
            case ("mostrarTodo"): mostrarTodo(request, response); break;
            case ("mostrarporId"): mostrarporId(request, response); break;
            case ("actualizar"): actualizar(request, response); break;
            case ("eliminar"): eliminar(request, response); break;
            default: throw new AssertionError();

        }

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            MetalBean idm = new MetalBean(0);
            ProveedorBean idp =  new ProveedorBean(0);
            DepartamentoBean idd = new DepartamentoBean(0);
            
            int idmetal = Integer.parseInt(request.getParameter("idmetal"));
            idm.setIdmetal(idmetal);
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            idp.setIdproveedor(idproveedor);
            int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            idd.setIddepartamento(iddepartamento);
        

            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            
            JoyeriaBean j = new JoyeriaBean(0);
            j.setIdmetal(idm);
            j.setIdproveedor(idp);
            j.setIddepartamento(idd);
            j.setNombre(nombre);
            j.setPrecio(precio);
            
            res = jd.insertar(j);
            if(res){
                msg = "registro guardado exitosamente";
            }
            else{
                msg = "error al guardar los datos";
            }
            
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/registro_joyeria.jsp");
            rd.forward(request, response);
    }

    protected void mostrarTodo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
            lista = jd.mostrar();
            
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/mostrar_joyeria.jsp");
            rd.forward(request, response);
        

    }
    

    protected void mostrarporId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
            int idjoyeria = Integer.parseInt(request.getParameter("idjoyeria"));
            lista = jd.mostrarporId(idjoyeria);
            
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/modificar_joyeria.jsp");
            rd.forward(request, response);
            

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            
            MetalBean idm = new MetalBean(0);
            ProveedorBean idp = new ProveedorBean(0);
            DepartamentoBean idd = new DepartamentoBean(0);
            
            int idjoyeria = Integer.parseInt(request.getParameter("idjoyeria"));
            
            int idmetal = Integer.parseInt(request.getParameter("idmetal"));
            idm.setIdmetal(idmetal);
            
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            idp.setIdproveedor(idproveedor);
            
            int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            idd.setIddepartamento(iddepartamento);
            
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            
            JoyeriaBean j = new JoyeriaBean(idjoyeria);
            j.setIdmetal(idm);
            j.setIdproveedor(idp);
            j.setIddepartamento(idd);
            j.setNombre(nombre);
            j.setPrecio(precio);
            
            res = jd.modificar(j);
            if(res){
                msg="Registro modificado exitosamente";
            }
            else {
                msg="error modificando el registro";
            }
            
            lista = jd.mostrar();
                   
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/mostrar_joyeria.jsp");
            rd.forward(request, response);
        
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idjoyeria = Integer.parseInt(request.getParameter("idjoyeria"));
        
        res = jd.eliminar(idjoyeria);
        lista = jd.mostrar();
        
        if (res){
            msg = "eliminado con exito";
        }
        else{
            msg = "error";
        }
        
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrar_joyeria.jsp");
        rd.forward(request, response);
        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(JoyeriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(JoyeriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
