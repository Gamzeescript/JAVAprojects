<%-- 
    Document   : modificar_venta
    Created on : Oct 10, 2019, 5:19:52 PM
    Author     : Michelle Giron
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>Modificar registros</title>
    </head>
    <body>
        <h1>Registro de Ventas</h1>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="venta?action=actualizar" method="POST">
                        <c:forEach items="${lista}" var="v">
                            <label>Id registro:</label>
                            <input class="form-control" name="idventa"  readonly="readonly" value="${v.idventa}">
                            <label>Cliente:</label>
                            <input class="form-control" name="idcliente" value="${v.idcliente.idcliente}">
                            <label>Producto Lacteo:</label>
                            <input class="form-control" name="idlacteo" value="${v.idlacteo.idlacteo}">
                            <label>Precio:</label>
                            <input class="form-control" name="precio" value="${v.precio}">
                            <label>fecha de venta:</label>
                            <input class="form-control" name="fecha" type="date" value="${v.fecha}">
                            <br>
                            <button class="btn btn-info">Agregar venta</button>
                        </c:forEach> 
                    </form>
                    ${msg}
                    <br>
                    <a href="venta?action=mostrar">consultar registros</a>
                    <br>
                </div>
            </div>
        </div>
    </body>
</html>



