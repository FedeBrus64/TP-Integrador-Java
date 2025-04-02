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
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <%
    	LinkedList<Local> ll = (LinkedList<Local>)request.getAttribute("listaLocales");
    	Local locu = (Local)request.getAttribute("updateLocal");
	%>
	
</head>
<body class="bg-light">
    <div class="container py-5">
        <h1 class="text-center mb-4">Locales</h1>
        <a class="btn btn-primary mb-3" href='Locales'>Atrás</a>
                	<div class="row">
            <!-- Tabla de Locales -->
            <div class="card shadow p-4">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
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
				
	<!-- Formulario de Edición -->
            <div class="card shadow p-4 mt-4">
                <h2 class="h4 text-center">Editar Local</h2>
                    <form action="EditLocal" method="post">
                        <div class="row g-3">
      
      <div class="col-md-6">
      <label for="inputCodLocal" class="form-label">ID de Local Actual</label>
      <input id="inputCodLocal" name="codLocal" class="form-control" required type="number" readonly value="<%=locu.getCodLocal()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputDescLocal" class="form-label">Descripción del local</label>
      <input id="inputDescLocal" name="descLocal" class="form-control" placeholder="Descripción" required type="text" value="<%=locu.getDescLocal()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputDireccionLocal" class="form-label">Dirección del local</label>
      <input id="inputDireccionLocal" name="direccion" class="form-control" placeholder="Dirección" required type="text" value="<%=locu.getDireccionLocal()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputTelefonoLocal" class="sr-only">Teléfono del local</label>
      <input id="inputTelefonoLocal" name="telefono" class="form-control" placeholder="Teléfono" required type="number" value="<%=locu.getTelefonoLocal()%>">
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