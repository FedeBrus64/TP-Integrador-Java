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
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <%
    	LinkedList<Empleado> le = (LinkedList<Empleado>)request.getAttribute("listaEmpleados");
    	Empleado uemp = (Empleado)request.getAttribute("updateEmpleado");
	%>
	
</head>
<body class="bg-light">
	<div class="container py-5">
        <h1 class="text-center mb-4">Empleados</h1>
        <a class="btn btn-primary mb-3" href='Empleados'>Atrás</a>
            	<div class="row">
            <!-- Tabla de Empleados -->
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
                    	</table>
					</div> <!-- /container -->
				</div>
				
	<!-- Formulario de Edición -->
            <div class="card shadow p-4 mt-4">
                    <h2 class="h4 text-center">Editar Empleado</h2>
                    <form action="EditEmpleado" method="post">
                        <div class="row g-3">
      
      <div class="col-md-6">
      <label for="inputIdUsuario" class="form-label">ID del cliente actual</label>
      <input id="inputIdUsuario" name="idUsuario" class="form-control" required type="number" readonly value="<%=uemp.getIdUsuario()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputNomUsuario" class="form-label">Nombre de usuario</label>
      <input id="inputNomUsuario" name="nomUsuario" class="form-control" placeholder="Nombre de usuario" required type="text" value="<%=uemp.getNomUsuario()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputPassword" class="form-label">Password</label>
      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required type="password" value="<%=uemp.getContraseña()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputNombre" class="form-label">Nombre</label>
      <input id="inputNombre" name="nombre" class="form-control" placeholder="Nombre" required type="text" value="<%=uemp.getNombre()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputApellido" class="form-label">Apellido</label>
      <input id="inputApellido" name="apellido" class="form-control" placeholder="Apellido" required type="text" value="<%=uemp.getApellido()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputEmail" class="form-label">Email</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email" required type="email" value="<%=uemp.getEmail()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputLocalidad" class="form-label">Localidad</label>
      <input id="inputLocalidad" name="localidad" class="form-control" placeholder="Localidad" required type="text" value="<%=uemp.getLocalidad()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputDireccion" class="form-label">Dirección</label>
      <input id="inputDireccion" name="direccion" class="form-control" placeholder="Direccion" required type="text" value="<%=uemp.getDireccion()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputFechaIngreso" class="form-label">Fecha de Ingreso</label>
      <input id="inputFechaIngreso" name="fechaIngreso" class="form-control" required type="date" value="<%=uemp.getFechaIngreso()%>">
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