<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Cliente" %>
<%@ page import="java.util.LinkedList" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <%
    	LinkedList<Cliente> lc = (LinkedList<Cliente>)request.getAttribute("listaClientes");
   		Cliente ucli = (Cliente)request.getAttribute("updateCliente");
	%>
	
</head>
<body class="bg-light">
	<div class="container py-5">
        <h1 class="text-center mb-4">Clientes</h1>
        <a class="btn btn-primary mb-3" href='Clientess'>Atrás</a>
            	 <div class="row">
            <!-- Tabla de Clientes -->
            <div class="card shadow p-4">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                    			<tr>
                    				<th>ID</th>
                    				<th>Nombre de usuario</th>
                    		    	<th>nombre</th>
                        			<th>apellido</th>
                        			<th>email</th>
                        			<th>dirección</th>
                        			<th>localidad</th>
                        			<th>Codigo postal</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Cliente cli : lc) { %>
                    			<tr>
                    				<td><%=cli.getIdUsuario()%></td>
                    				<td><%=cli.getNomUsuario()%></td>
                    				<td><%=cli.getNombre()%></td>
                    				<td><%=cli.getApellido()%></td>
                    				<td><%=cli.getEmail()%></td>
                    				<td><%=cli.getDireccion()%></td>
                    				<td><%=cli.getLocalidad()%></td>
                    				<td><%=cli.getCodigoPostal()%></td>
                    				
                    				<td><a href='EditCliente?updCli=<%=cli.getIdUsuario()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
                    	</table>
					</div> <!-- /container -->
				</div>
				
	<!-- Formulario de Edición -->
            <div class="card shadow p-4 mt-4">
                    <h2 class="h4 text-center">Editar Cliente</h2>
                    <form action="EditCliente" method="post">
                        <div class="row g-3">
      
      
      <div class="col-md-6">
      <label for="inputIdUsuario" class="form-label">ID del cliente actual</label>
      <input id="inputIdUsuario" name="idUsuario" class="form-control" required type="number" readonly value="<%=ucli.getIdUsuario()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputNomUsuario" class="form-label">Nombre de usuario</label>
      <input id="inputNomUsuario" name="nomUsuario" class="form-control" placeholder="Nombre de usuario" required type="text" value="<%=ucli.getNomUsuario()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputPassword" class="form-label">Password</label>
      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required type="password" value="<%=ucli.getContraseña()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputNombre" class="form-label">Nombre</label>
      <input id="inputNombre" name="nombre" class="form-control" placeholder="Nombre" required type="text" value="<%=ucli.getNombre()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputApellido" class="form-label">Apellido</label>
      <input id="inputApellido" name="apellido" class="form-control" placeholder="Apellido" required type="text" value="<%=ucli.getApellido()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputEmail" class="form-label">Email</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email" required type="email" value="<%=ucli.getEmail()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputLocalidad" class="form-label">Localidad</label>
      <input id="inputLocalidad" name="localidad" class="form-control" placeholder="Localidad" required type="text" value="<%=ucli.getLocalidad()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputDireccion" class="form-label">Direccion</label>
      <input id="inputDireccion" name="direccion" class="form-control" placeholder="Direccion" required type="text" value="<%=ucli.getDireccion()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputCodigoPostal" class="form-label">Codigo postal</label>
      <input id="inputCodigoPostal" name="codigoPostal" class="form-control" placeholder="Codigo Postal" required type="number" value="<%=ucli.getCodigoPostal()%>">
      </div>
      </div>
      <div class="text-center mt-4">
      <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
      </div>
      
    </form>
    </div>
    </div>
    </div>
</body>
</html>