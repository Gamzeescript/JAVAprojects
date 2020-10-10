<%-- 
    Document   : registro_joyeria
    Created on : 09-04-2019, 03:45:37 PM
    Author     : liliana.gironusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>Joyeria</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Joyeria San Hipoclorito</h1>
                    <form action="joyeria?action=insertar" method="POST">
                        <label>Tipo de Metal:</label>
                         <input class="form-control" name="idmetal">
                         <br>
                        <label>Proveedor:</label>
                        <input  class="form-control" name="idproveedor">
                        <label>Departamento:</label>
                        <input class="form-control" name="iddepartamento">
                        <label>Nombre:</label>
                        <input class="form-control" name="nombre">
                        <label>precio:</label>
                        <input class="form-control" name="precio">
                        <br>
                        <button class="btn btn-outline-dark">Agregar</button>
                    </form>
                    ${msg}
                </div>
                <a href="joyeria?action=mostrarTodo">Consultar registros</a>
            </div>
        </div>
    </body>
</html>
