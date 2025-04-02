<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Usuario" %>
<%@ page import="data.DataUsuario" %>
<%@ page import="java.util.LinkedList" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
	<title>Sistema online Vincenzo</title>
	
	<!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    
    <%
		DataUsuario du = new DataUsuario();
    	LinkedList<Usuario> lu = (LinkedList<Usuario>)request.getAttribute("listaUsuarios");
	%>
	
</head>
<body class="bg-light">
	<div class="card mt-4 shadow p-4">
	<form class="form-list" action="Signup" method="post">
      <h2 class="text-center mb-3">Registrarse</h2>
      <a class="btn btn-secondary mb-3" href='index.html'>Atrás</a>
      <div id="error-message" class="alert alert-danger d-none"></div>
      <div class="mb-3">
      <label for="inputNomUsuario" class="form-label">Nombre de usuario</label>
      <input id="inputNomUsuario" name="nomUsuario" class="form-control" placeholder="Nombre de usuario" required type="text">
      </div>
      
      <div class="mb-3">
      <label for="inputPassword" class="form-label">Password</label>
      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required type="password">
      </div>
      
      <div class="mb-3">
      <label for="inputNombre" class="form-label">Nombre</label>
      <input id="inputNombre" name="nombre" class="form-control" placeholder="Nombre" required type="text">
      </div>
      
      <div class="mb-3">
      <label for="inputApellido" class="form-label">Apellido</label>
      <input id="inputApellido" name="apellido" class="form-control" placeholder="Apellido" required type="text">
      </div>
      
      <div class="mb-3">
      <label for="inputEmail" class="form-label">Email</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email" required type="email">
      </div>
      
      <div class="mb-3">
      <label for="inputLocalidad" class="form-label">Localidad</label>
      <input id="inputLocalidad" name="localidad" class="form-control" placeholder="Localidad" required type="text">
      </div>
      
      <div class="mb-3">
      <label for="inputDireccion" class="form-label">Direccion</label>
      <input id="inputDireccion" name="direccion" class="form-control" placeholder="Direccion" required type="text">
      </div>
      
      <div class="mb-3">
      <label for="inputCodigoPostal" class="form-label">Código Postal</label>
      <input id="inputCodigoPostal" name="codigoPostal" class="form-control" placeholder="Código postal" required type="number">
      </div>
      
      <button class="btn btn-primary w-100" type="submit">Registrar</button>
    </form>
    </div>
    
    <!-- Bootstrap JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		window.onload = function() {
		    let error = new URLSearchParams(window.location.search).get("error");
		    if (error) {
		        let errorMessage = document.getElementById("error-message");
		        errorMessage.textContent = error;
		        errorMessage.classList.remove("d-none");
		    }
		};
	</script>
</body>
</html>