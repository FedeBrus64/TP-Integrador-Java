<%@ page import="entities.Usuario" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema Online Vincenzo</title>
    
    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        /* Estilos personalizados */
        .containerButtons {
            max-width: 600px;
            margin: auto;
            padding-top: 20px;
        }
    </style>
    <%
    	Usuario usu= (Usuario)session.getAttribute("usuario");
	%>
</head>

<body class="bg-light">

    <!-- Menú de Navegación -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white shadow">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img src="https://d3ugyf2ht6aenh.cloudfront.net/stores/001/161/800/themes/common/logo-98315437-1587524306-acf261205df7188b90bbe4ec5f47475f1587524306-480-0.png?0" 
                     alt="Vincenzo" width="120">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="#">Inicio</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Productos</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Carrito</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Contacto</a></li>
                    <li class="nav-item"><a class="nav-link" href="index.html">Cerrar sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenido Principal -->
    <div class="container text-center mt-5">
        <h1 class="mb-4">¡Bienvenido/a <%=usu.getNombre()%> <%=usu.getApellido()%>! Por favor, seleccione una opción</h1>

        <div class="containerButtons">
            <div class="row row-cols-1 row-cols-md-2 g-3">
                <div class="col"><form action="compras"><button class="btn btn-primary btn-lg w-100">Ver Compras Realizadas</button></form></div>
                <div class="col"><form action="comprar"><button class="btn btn-success btn-lg w-100">Comprar una prenda</button></form></div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>