<%-- 
    Document   : registro_proveedor
    Created on : 09-02-2019, 03:15:53 PM
    Author     : liliana.gironusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css"  type="text/css"/>
        <title>Registro de Proveedores</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    banner
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">
                    <form action="proveedor?action=insertar" method="POST">
                        <br>
                        <label>Nombre:</label>
                        <input name="nombre" class="form-control">
                        <br><br>
                        <label>Telefono:</label>
                        <input name="telefono" class="form-control">
                        <br><br>
                        <label>Direccion:</label>
                        <input name="direccion" class="form-control">
                        <br><br>
                        <label>Email:</label>
                        <input name="email" class="form-control">
                        <br><br>
                        <button class="btn btn-dark"> Enviar</button>
                        <br>
                    </form>
                    ${msg}
                </div>
                <a href="proveedor?action=consultarTodos">Consultar Registros</a> 
            </div>
        </div>
    </body>
</html>
