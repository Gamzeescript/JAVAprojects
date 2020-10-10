<%-- 
    Document   : mostrar_joyeria
    Created on : 09-10-2019, 08:30:36 AM
    Author     : liliana.gironusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>Le Boutique Marie</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <table>
                        <thead class="table table-dark">
                            <tr>
                                <td>id</td>
                                <td>Metal</td>
                                <td>Proveedor</td>
                                <td>Departamento</td>
                                <td>Nombre</td>
                                <td>Precio</td>
                                <td>Acciones</td>
                            </tr>
                        </thead>
                        <tbody class="table table-bordered">
                        <c:forEach items="${lista}" var="j">
                            <tr>
                                <td>${j.idjoyeria}</td>
                                <td>${j.idmetal.idmetal}</td>
                                <td>${j.idproveedor.idproveedor}</td>
                                <td>${j.iddepartamento.iddepartamento}</td>
                                <td>${j.nombre}</td>
                                <td>${j.precio}</td>
                                <td>
                                    <a href="joyeria?action=mostrarporId&idjoyeria=${j.idjoyeria}" class="btn btn-info">Actualizar</a>
                                    <a href="joyeria?action=eliminar&idjoyeria=${j.idjoyeria}" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <a href="registro_joyeria.jsp">Regresar</a>
                    <a href="index.jsp">Regresar</a>
                </div>
            </div>
        </div>
    </body>
</html>
