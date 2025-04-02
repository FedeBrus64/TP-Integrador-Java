<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.TipoPrenda" %>
<%@ page import="data.DataTipoPrenda" %>
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
		DataTipoPrenda dtp = new DataTipoPrenda();
    	LinkedList<TipoPrenda> ltp = (LinkedList<TipoPrenda>)request.getAttribute("listaTiposPrendas");
    	TipoPrenda utp = (TipoPrenda)request.getAttribute("updateTipoPrenda");
	%>
	
</head>
<body class="bg-light">
	<div class="container py-5">
	        <h1 class="text-center mb-4">Tipos de prenda</h1>
	        <a class="btn btn-primary mb-3" href='TiposPrendas'>Atrás</a>
	
	        <div class="row">
	            <!-- Tabla de tipos de prenda -->
	           <div class="card shadow p-4">
	                <div class="table-responsive">
	                    <table class="table table-striped table-hover">
                    		<thead class="table-dark">
                    			<tr>
                    				<th>Codigo</th>
                    				<th>Descripcion</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (TipoPrenda tp : ltp) { %>
                    			<tr>
                    				<td><%=tp.getCodTipoPrenda()%></td>
                    				<td><%=tp.getDescTipoPrenda()%></td>
                    				
                    				<td><a href='TiposPrendas?updTp=<%=tp.getCodTipoPrenda()%>' class=''>Edit</a></td>
                    			</tr>
                    		<% } %>
                    		</tbody>	
                    		</table>
					</div> <!-- /container -->
				</div>
				
	<div class="card shadow p-4 mt-4">
         <h2 class="h4 text-center">Editar Tipo de Prenda</h2>
	<form action="EditTipoPrenda" method="post">
		<div class="row g-3">
      
	      <div class="col-md-6">
		      <label for="inputId" class="form-label">ID del tipo de prenda a editar</label>
		      <input id="inputId" name="codtipoprenda" value="<%=utp.getCodTipoPrenda()%>" class="form-control" required type="number" readonly>
		  </div>
	      
	      <div class="col-md-6">
	      	<label for="inputDescripcion" class="form-label">Descripcion</label>
	      	<input id="inputDescripcion" name="descripcion" value="<%=utp.getDescTipoPrenda()%>" class="form-control" placeholder="Descripcion" required type="text">
	      </div>
	      
	    </div>
	    <div class="text-center mt-4">
	      <button class="btn btn-success" type="submit">Editar</button>
      	</div>
    </form>
    </div>
  </div>
 </div>
</body>
</html>