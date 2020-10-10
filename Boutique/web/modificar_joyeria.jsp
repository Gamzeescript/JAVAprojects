<%-- 
    Document   : modificar_joyeria
    Created on : 09-10-2019, 10:19:14 AM
    Author     : liliana.gironusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>Le boutique </title>
    </head>
    <body>
        <h1 align="center">Modificar registro</h1>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="joyeria?action=actualizar" method="POST">
                           <c:forEach items="${lista}" var="j">
                            <label>id:</label>
                            <input class="form-control" name="idjoyeria" readonly="readonly" value="${j.idjoyeria}">
                            <label>Metal:</label>
                            <input class="form-control" name="idmetal" value="${j.idmetal.idmetal}">
                            <label>Proveedor:</label>
                            <input class="form-control" name="idproveedor" value="${j.idproveedor.idproveedor}">
                            <label>Departamento</label>
                            <input class="form-control" name="iddepartamento" value="${j.iddepartamento.iddepartamento}">
                            <label>Nombre:</label>
                            <input class="form-control" name="nombre" value="${j.nombre}">
                            <label>Precio:</label>
                            <input class="form-control" name="precio" value="${j.precio}">
                            <button class="btn btn-info">Modificar</button>
                        </c:forEach>
                    </form>        
                    <a href="joyeria?action=mostrarTodo">Consultar joyeria disponible</a>
                    <a href="index.jsp">Inicio</a>
                </div>
            </div>
        </div>
    </body>
</html>
