

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet"  type="text/css" href="css/bootstrap.css"/>
        <title>Boutique Le Marie</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <table>
                        <thead class="table table-dark">
                            <tr>
                                <td>Id proveedor</td>
                                <td>Nombre</td>
                                <td>Telefono</td>
                                <td>Direccion</td>
                                <td>Email</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody class="table table-bordered">   
                        <c:forEach items="${lista}" var="p">
                            <tr>
                                <td>${p.idproveedor}</td>
                                <td>${p.nombre}</td>
                                <td>${p.telefono}</td>
                                <td>${p.direccion}</td>
                                <td>${p.email}</td>
                                <td>                            
                                    <a href="proveedor?action=consultarporId&idproveedor=${p.idproveedor}" class="btn bg-info" >Modificar</a>
                                    <a href="proveedor?action=eliminar&idproveedor=${p.idproveedor}" class="btn btn-danger">Eliminar</a>                            
                                </td>
                                
                            </tr>
                        </c:forEach>
                        </tbody>
                         
                    </table>
                    <a href="registro_proveedor.jsp">Regresar</a>
                </div>
            </div>
        </div>
    </body>
</html>

    
