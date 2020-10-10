<%-- 
    Document   : mostrar_venta
    Created on : Oct 10, 2019, 5:19:36 PM
    Author     : Michelle Giron
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>Registro Venta de lacteos</title>
    </head>
    <body>
        <h1>Registro de Ventas</h1>
        <div class="container">
            <div class="row">
                <div class="col-12">
                        <table class="table table-bordered">
                            <thead class="table table-dark">
                               <tr>
                                      <td>Id registro</td>
                                      <td>Cliente</td>
                                      <td>Producto Lacteo</td>
                                      <td>precio</td>
                                      <td>fecha</td>
                                      <td>Acciones</td>
                               </tr>  
                        </thead>
                        <tbody>
                            
                               <c:forEach items="${lista}" var="v">
                                   <tr>
                                       <td>${v.idventa}</td>
                                      <td>${v.idcliente.idcliente}</td>
                                      <td>${v.idlacteo.idlacteo}</td>
                                      <td>${v.precio}</td>
                                      <td>${v.fecha}</td>
                                      <td>
                                          <a href="venta?action=mostrarporId&idventa=${v.idventa}" class="btn bg-success">Modificar</a>  
                                        <a href="venta?action=eliminar&idventa=${v.idventa}" class="btn bg-danger">Eliminar</a>
                                      </td>
                                   </tr>
                        </c:forEach>  
                        </tbody>
                        </table>
                    <br>
                    <a href="registro_itinerario.jsp">insertar registros</a>
                </div>
            </div>
        </div>
    </body>
</html>
