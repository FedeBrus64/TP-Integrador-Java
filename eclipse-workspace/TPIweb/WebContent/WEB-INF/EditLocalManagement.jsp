<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Local" %>
<%@ page import="data.DataLocal" %>
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
    	LinkedList<Local> ll = (LinkedList<Local>)request.getAttribute("listaLocales");
    	Local locu = (Local)request.getAttribute("updateLocal");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Usuarios</h1>
            	<div class="col-12 col-sm-12 col-lg-12">
                	<div class="table-responsive">
                    	<table class="table">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Descripción del local/th>
                    		    	<th>Dirección del local</th>
                    		    	<th>Teléfono del local</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Local loc : ll) { %>
                    			<tr>
                    				<td><%=loc.getCodLocal()%></td>
                    				<td><%=loc.getDescLocal()%></td>
                    				<td><%=loc.getDireccionLocal()%></td>
                    				<td><%=loc.getTelefonoLocal()%></td>
         
                    				<td><a href='EditLocal?updLoc=<%=loc.getCodLocal()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
                    		</table>
					</div> <!-- /container -->
				</div>
			</div>
		</div>
	<a class="btn btn-lg btn-primary btn-block" href='Usuarios'>Atras</a>
	<div class ='col-12 col-sm-12 col-lg-12'>
	<form class="form-list" action="EditLocal" method="post">
      <h2 class="h3 mb-3 font-weight-normal">Editar Local</h2>
      
      <label for="inputCodLocal" class="sr-only">ID de Local Actual</label>
      <input id="inputCodLocal" name="codLocal" class="form-control" required type="number" readonly value="<%=locu.getCodLocal()%>">
      
      <label for="inputDescLocal" class="sr-only">Descripción del local</label>
      <input id="inputDescLocal" name="descLocal" class="form-control" placeholder="Descripción" required type="text" value="<%=locu.getDescLocal()%>">
      
      <label for="inputDireccionLocal" class="sr-only">Dirección del local</label>
      <input id="inputDireccionLocal" name="direccion" class="form-control" placeholder="Dirección" required type="text" value="<%=locu.getDireccionLocal()%>">
      
      <label for="inputTelefonoLocal" class="sr-only">Teléfono del local</label>
      <input id="inputTelefonoLocal" name="telefono" class="form-control" placeholder="Teléfono" required type="number" value="<%=locu.getTelefonoLocal()%>">
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
    </form>
    </div>
</body>
</html>