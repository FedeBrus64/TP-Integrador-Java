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
    	<h1 class="text-center">Compras realizadas</h1>
    	<a class="btn btn-secondary mb-3" href='Signin'>Atrás</a>
           <!-- Tabla de Ventas -->
		    <div class="card shadow p-4">
		        <div class="table-responsive">
		            <table class="table table-striped table-hover">
		                <thead class="table-dark">
                    			<tr>
                    				<th>Fecha</th>
                    		    	<th>Importe total</th>
                    		    	<th>Forma de Pago</th>
                        			<th>Prenda</th>
                        			<th>Talle</th>
                        			<th>Color</th>
                        			<th>Marca</th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Venta ven : lv) { %>
                    			<tr>
                    				<td><%=ven.getFechaVenta()%></td>
                    				<td><%=ven.getImporteTotal()%></td>
                    				<td><%=ven.getFormaPago()%></td>
                    				<td><%=ven.get_prenda().getNombrePrenda()%></td>
                    				<td><%=ven.get_prenda().getTalle()%></td>
                    				<td><%=ven.get_prenda().getColor()%></td>
                    				<td><%=ven.get_prenda().getMarca()%></td>
                    			</tr>
                    		<% } %>
                    		</tbody>	
                    	</table>
					</div> 
				</div>
			</div>
<!-- Bootstrap JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>