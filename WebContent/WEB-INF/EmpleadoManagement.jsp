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
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Empleados</h1>
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
                    				
                    				<td></td><!-- editar -->
                    				<td></td><!-- borrar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
	</div> <!-- /container -->
</body>
</html>