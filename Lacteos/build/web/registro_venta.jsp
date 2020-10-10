<%-- 
    Document   : registro_venta
    Created on : Oct 10, 2019, 5:19:18 PM
    Author     : Michelle Giron
--%>

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
                    <form action="venta?action=insertar" method="POST">
                       <label>Cliente:</label>
                       <input class="form-control" name="idcliente">
                       <label>Producto Lacteo:</label>
                       <input class="form-control" name="idlacteo">
                       <label>Precio:</label>
                       <input class="form-control" name="precio">
                       <label>fecha de venta:</label>
                       <input class="form-control" name="fecha" type="date">
                        <br>
                       <button class="btn btn-info">Agregar venta</button>
                        <br>
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
