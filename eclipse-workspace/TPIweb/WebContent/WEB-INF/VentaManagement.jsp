<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Venta" %>
<%@ page import="entities.Cliente" %>
<%@ page import="entities.Prenda" %>
<%@ page import="data.DataCliente" %>
<%@ page import="data.DataPrenda" %>
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
	
    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <%
		DataCliente dc = new DataCliente();
		LinkedList<Cliente> lc =  dc.getAll();
        DataPrenda dp = new DataPrenda();
    	LinkedList<Prenda> lpre =  dp.getAll();
    	LinkedList<Venta> lv = (LinkedList<Venta>)request.getAttribute("listaVentas");
	%>
	
</head>
<body class="bg-light">
	<div class="container mt-4">
    	<h1 class="text-center">Gestión de Ventas</h1>
    	<a class="btn btn-secondary mb-3" href='Signin'>Atrás</a>
           <!-- Tabla de Ventas -->
		    <div class="card shadow p-4">
		        <div class="table-responsive">
		            <table class="table table-striped table-hover">
		                <thead class="table-dark">
                    			<tr>
                    				<th>Numero</th>
                    				<th>Fecha</th>
                    		    	<th>Importe total</th>
                    		    	<th>Forma de pago</th>
                        			<th>Cliente</th>
                        			<th>Prenda</th>
                        			<th>Acciones</th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Venta ven : lv) { %>
                    			<tr>
                    				<td><%=ven.getNroVenta()%></td>
                    				<td><%=ven.getFechaVenta()%></td>
                    				<td><%=ven.getImporteTotal()%></td>
                    				<td><%=ven.getFormaPago()%></td>
                    				<td><%=ven.get_cliente().getNomUsuario()%></td>
                    				<td><%=ven.get_prenda().getNombrePrenda()%></td>
                    				<td>
                    					<a href='EditVenta?updVen=<%=ven.getNroVenta()%>' class='btn btn-warning btn-sm'>Editar</a><!-- editar -->
                    					<a href='Ventas?delVen=<%=ven.getNroVenta()%>' class='btn btn-danger btn-sm'>Eliminar</a><!-- borrar -->
                    				</td>
                    			</tr>
                    		<% } %>
                    		</tbody>	
                    	</table>
					</div> 
				</div>
			
	<div class="card mt-4 shadow p-4">
       <h2 class="text-center mb-3">Registrar Nueva Venta</h2>
	<form class="form-list" action="Ventas" method="post">
	<div class="mb-3">
      <label for="inputImporteTotal" class="form-label">Importe Total</label>
      <input id="inputImporteTotal" name="importeTotal" class="form-control" placeholder="Importe total" required type="number" step="0.01">
    </div> 
    <div class="mb-3">
      <label for="inputVenta" class="form-label">Fecha de la Venta</label>
      <input id="inputVenta" name="fechaVenta" class="form-control" required type="date">
    </div> 
    <div class="mb-3">
        <label for="inputFormaPago" class="form-label">Forma de pago</label>
        <input id="inputFormaPago" name="formaPago" class="form-control" placeholder="Ingrese la forma de pago" required type="text">
    </div>
    <div class="mb-3">
      <label for="inputCliente" class="form-label">Cliente</label>
      <select name="cliente" id="inputCliente" class="form-select">
      	<% for (Cliente c : lc) { %>
      		<option value ='<%=c.getIdUsuario()%>'><%=c.getNomUsuario()%></option>
      	<% } %>
      </select>
     </div>
     <div class="mb-3">
      <label for="inputPrenda" class="form-label">Prenda</label>
      <select name="prenda" id="inputPrenda" class="sr-only">
      	<% for (Prenda pre : lpre) { %>
      		<option value ='<%=pre.getCodPrenda()%>'><%=pre.getNombrePrenda()%></option>
      	<% } %>
      </select>
	 </div>
      <button class="btn btn-primary w-100" type="submit">Registrar</button>
    </form>
    </div>
    </div>
<!-- Bootstrap JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>