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
	
	<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/list.css" rel="stylesheet">
    
    <%
		DataCliente dc = new DataCliente();
		LinkedList<Cliente> lc =  dc.getAll();
        DataPrenda dp = new DataPrenda();
    	LinkedList<Prenda> lpre =  dp.getAll();
    	LinkedList<Venta> lv = (LinkedList<Venta>)request.getAttribute("listaVentas");
    	Venta uven = (Venta)request.getAttribute("updateVenta");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Ventas</h1>
            	<div class="col-12 col-sm-12 col-lg-12">
                	<div class="table-responsive">
                    	<table class="table">
                    		<thead>
                    			<tr>
                    				<th>Numero</th>
                    				<th>Fecha</th>
                    		    	<th>Importe total</th>
                        			<th>Cliente</th>
                        			<th>Prenda</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Venta ven : lv) { %>
                    			<tr>
                    				<td><%=ven.getNroVenta()%></td>
                    				<td><%=ven.getFechaVenta()%></td>
                    				<td><%=ven.getImporteTotal()%></td>
                    				<td><%=ven.get_cliente().getNomUsuario()%></td>
                    				<td><%=ven.get_prenda().getNombrePrenda()%></td>
                    				
                    				<td><a href='EditVenta?updVen=<%=ven.getNroVenta()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
	</div> <!-- /container -->
				</div>
			</div>
		</div>
	<a class="btn btn-lg btn-primary btn-block" href='Ventas'>Atras</a>
	<div class ='col-12 col-sm-12 col-lg-12'>
	<form class="form-list" action="EditVenta" method="post">
      <h2 class="h3 mb-3 font-weight-normal">Editar venta</h2>
      
      <label for="inputNroVenta" class="sr-only">Numero de la venta actual</label>
      <input id="inputNroVenta" name="nroVenta" class="form-control" required type="number" readonly value="<%=uven.getNroVenta()%>">
      
      
      <label for="inputImporteTotal" class="sr-only">Importe Total</label>
      <input id="inputImporteTotal" name="importeTotal" class="form-control" placeholder="Importe total" required type="number" step="0.01" value="<%=uven.getImporteTotal()%>">
      
      <label for="inputVenta" class="sr-only">Fecha de la Venta</label>
      <input id="inputVenta" name="fechaVenta" class="form-control" required type="date" value="<%=uven.getFechaVenta()%>">
      
      <label for="inputCliente" class="sr-only">Cliente</label>
      
      <select name="cliente" id="inputCliente" class="sr-only">
      	<% for (Cliente c : lc) { %>
      		<option value ='<%=c.getIdUsuario()%>'><%=c.getNomUsuario()%></option>
      	<% } %>
      </select>
      
      <label for="inputPrenda" class="sr-only">Prenda</label>
      
      <select name="prenda" id="inputPrenda" class="sr-only">
      	<% for (Prenda pre : lpre) { %>
      		<option value ='<%=pre.getCodPrenda()%>'><%=pre.getNombrePrenda()%></option>
      	<% } %>
      </select>

      <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
    </form>
    </div>
</body>
</html>