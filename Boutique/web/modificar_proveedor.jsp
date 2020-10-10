<%-- 
    Document   : modificar_proveedor
    Created on : 09-04-2019, 10:29:49 AM
    Author     : liliana.gironusam
--%>

<%-- 
    Document   : modificar_registro
    Created on : 09-04-2019, 08:35:44 AM
    Author     : liliana.gironusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>modificar registro</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                    <form action="proveedor?action=actualizar" method="POST">
                            <c:forEach items="${lista}" var="p" >
                            <label>Id:</label>
                            <input class="form-control" readonly="readonly" name="idproveedor" value="${p.idproveedor}">
                            <label>Nombre:</label>
                            <input class="form-control" name="nombre" value="${p.nombre}">
                            <label>Telefono:</label>
                            <input class="form-control" name="telefono" value="${p.telefono}">
                            <label>Direccion</label>
                            <input class="form-control" name="direccion" value="${p.direccion}">
                            <label>Email:</label>
                            <input class="form-control" name="email" value="${p.email}"> 
                            <br><br>
                            <button class="btn btn-dark">Modificar</button>
                    </c:forEach>
                        </form>
                    <a href="proveedor?action=consultarTodos">Regresar</a>
                    <a href="index.jsp">Inicio</a>
                </div>
            </div>
        </div>
    </body>
</html>
