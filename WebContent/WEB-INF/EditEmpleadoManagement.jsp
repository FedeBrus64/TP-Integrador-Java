<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Empleado" %>
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
	
	<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/list.css" rel="stylesheet">
    
    <%
    	LinkedList<Empleado> le = (LinkedList<Empleado>)request.getAttribute("listaEmpleados");
    	Empleado uemp = (Empleado)request.getAttribute("updateEmpleado");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Empleados</h1>
        	<a class="btn btn-lg btn-primary btn-block" href='Empleados'>Atras</a>
            	<div class="col-12 col-sm-12 col-lg-12">
                	<div class="table-responsive">
                    	<table class="table">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Nombre de usuario</th>
                    		    	<th>nombre</th>
                        			<th>apellido</th>
                        			<th>email</th>
                        			<th>dirección</th>
                        			<th>localidad</th>
                        			<th>Fecha de ingreso</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Empleado emp : le) { %>
                    			<tr>
                    				<td><%=emp.getIdUsuario()%></td>
                    				<td><%=emp.getNomUsuario()%></td>
                    				<td><%=emp.getNombre()%></td>
                    				<td><%=emp.getApellido()%></td>
                    				<td><%=emp.getEmail()%></td>
                    				<td><%=emp.getDireccion()%></td>
                    				<td><%=emp.getLocalidad()%></td>
                    				<td><%=emp.getFechaIngreso()%></td>
                    				
                    				<td><a href='EditEmpleado?updEmp=<%=emp.getIdUsuario()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
	</div> <!-- /container -->
				</div>
			</div>
		</div>
	<div class ='col-12 col-sm-12 col-lg-12'>
	<form class="form-list" action="EditEmpleado" method="post">
      <h2 class="h3 mb-3 font-weight-normal">Editar Empleado</h2>
      
      <label for="inputIdUsuario" class="sr-only">ID del cliente actual</label>
      <input id="inputIdUsuario" name="idUsuario" class="form-control" required type="number" readonly value="<%=uemp.getIdUsuario()%>">
      
      
      <label for="inputNomUsuario" class="sr-only">Nombre de usuario</label>
      <input id="inputNomUsuario" name="nomUsuario" class="form-control" placeholder="Nombre de usuario" required type="text" value="<%=uemp.getNomUsuario()%>">
      
      <label for="inputPassword" class="sr-only">Password</label>
      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required type="password" value="<%=uemp.getContraseña()%>">
      
      <label for="inputNombre" class="sr-only">Nombre</label>
      <input id="inputNombre" name="nombre" class="form-control" placeholder="Nombre" required type="text" value="<%=uemp.getNombre()%>">
      
      <label for="inputApellido" class="sr-only">Apellido</label>
      <input id="inputApellido" name="apellido" class="form-control" placeholder="Apellido" required type="text" value="<%=uemp.getApellido()%>">
      
      <label for="inputEmail" class="sr-only">Email</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email" required type="email" value="<%=uemp.getEmail()%>">
      
      <label for="inputLocalidad" class="sr-only">Localidad</label>
      <input id="inputLocalidad" name="localidad" class="form-control" placeholder="Localidad" required type="text" value="<%=uemp.getLocalidad()%>">
      
      <label for="inputDireccion" class="sr-only">Direccion</label>
      <input id="inputDireccion" name="direccion" class="form-control" placeholder="Direccion" required type="text" value="<%=uemp.getDireccion()%>">
      
      <label for="inputFechaIngreso" class="sr-only">Fecha de Ingreso</label>
      <input id="inputFechaIngreso" name="fechaIngreso" class="form-control" required type="date" value="<%=uemp.getFechaIngreso()%>">
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
    </form>
    </div>
</body>
</html>