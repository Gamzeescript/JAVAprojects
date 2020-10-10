
package Controlador;

import DAO.InventarioDao;
import Modelo.DepartamentoBean;
import Modelo.InventarioBean;
import Modelo.JoyeriaBean;
import Modelo.ProveedorBean;
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

public class InventarioServlet extends HttpServlet {
    
    Conexion conn = new Conexion();
    List<InventarioBean> lista = new LinkedList();
    InventarioDao id = new InventarioDao(conn);
    RequestDispatcher rd;
    String msg = "";
    boolean res;    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String action = (request.getParameter("action"));
        switch (action) {
            case ("insertar"):
                insertar(request, response);
                break;
            case ("mostrarTodo"):
                mostrarTodo(request, response);
                break;
            case ("mostrarporId"):
                mostrarporId(request, response);
                break;
            case ("actualizar"):
                actualizar(request, response);
                break;
            case ("eliminar"):
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();

        }

    }
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ProveedorBean idp =  new ProveedorBean(0);
            JoyeriaBean idj = new JoyeriaBean(0);
            RopaBean idr = new RopaBean(0);
            DepartamentoBean idd = new DepartamentoBean(0);
            
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            idp.setIdproveedor(idproveedor);
            int idjoyeria = Integer.parseInt(request.getParameter("idjoyeria"));
            idj.setIdjoyeria(idjoyeria);
            int idropa = Integer.parseInt(request.getParameter("idropa"));
            idr.setIdropa(idropa);
            int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            idd.setIddepartamento(iddepartamento);
        

            int existencia = Integer.parseInt(request.getParameter("existencia"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            InventarioBean i = new InventarioBean(0);
            i.setIdproveedor(idp);
            i.setIdjoyeria(idj);
            i.setIdropa(idr);
            i.setIddepartamento(idd);
            i.setExistencia(existencia);
            i.setStock(stock);
            
            res = id.insertar(i);
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
        
            lista = id.mostrar();
            
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/mostrar_inventario.jsp");
            rd.forward(request, response);
        

    }
    

    protected void mostrarporId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
            int idinventario = Integer.parseInt(request.getParameter("idinventario"));
            lista = id.mostrarporId(idinventario);
            
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/modificar_inventario.jsp");
            rd.forward(request, response);
            

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            
            ProveedorBean idp =  new ProveedorBean(0);
            JoyeriaBean idj = new JoyeriaBean(0);
            RopaBean idr = new RopaBean(0);
            DepartamentoBean idd = new DepartamentoBean(0);
            
            int idinventario = Integer.parseInt(request.getParameter("idinventario"));
            
            int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));
            idp.setIdproveedor(idproveedor);
            int idjoyeria = Integer.parseInt(request.getParameter("idjoyeria"));
            idj.setIdjoyeria(idjoyeria);
            int idropa = Integer.parseInt(request.getParameter("idropa"));
            idr.setIdropa(idropa);
            int iddepartamento = Integer.parseInt(request.getParameter("iddepartamento"));
            idd.setIddepartamento(iddepartamento);
        

            int existencia = Integer.parseInt(request.getParameter("existencia"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            InventarioBean i = new InventarioBean(idinventario);           
            i.setIdproveedor(idp);
            i.setIdjoyeria(idj);
            i.setIdropa(idr);
            i.setIddepartamento(idd);
            i.setExistencia(existencia);
            i.setStock(stock);
            
            res = id.modificar(i);
            if(res){
                msg="Registro modificado exitosamente";
            }
            else {
                msg="error modificando el registro";
            }
            
            lista = id.mostrar();
                   
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/mostrar_joyeria.jsp");
            rd.forward(request, response);
        
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idinventario = Integer.parseInt(request.getParameter("idinventario"));
        
        res = id.eliminar(idinventario);
        lista = id.mostrar();
        
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
            Logger.getLogger(InventarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
