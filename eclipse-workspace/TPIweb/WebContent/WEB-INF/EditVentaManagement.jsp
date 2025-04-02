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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

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
<body class ="bg-light">
	 <div class="container py-5">
        <h1 class="text-center mb-4">Ventas</h1>
        <a class="btn btn-primary mb-3" href='Ventas'>Atrás</a>

        <div class="row">
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
                        			<th>Estado</th>
                        			<th></th>
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
                    				<td><%=ven.getEstado()%></td>
                    				
                    				<td><a href='EditVenta?updVen=<%=ven.getNroVenta()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
                  </table> <!-- /container -->
				</div>
			</div>
	<div class="card shadow p-4 mt-4">
         <h2 class="h4 text-center">Editar Venta</h2>
	<form action="EditVenta" method="post">
                        <div class="row g-3">
               
                    <div class="col-md-6">
                        <label for="inputNroVenta" class="form-label">Numero de la venta actual</label>
      					<input id="inputNroVenta" name="nroVenta" class="form-control" required type="number" readonly value="<%=uven.getNroVenta()%>">
                    </div>
                    <div class="col-md-6">
                        <label for="inputImporteTotal" class="form-label">Importe Total</label>
      					<input id="inputImporteTotal" name="importeTotal" class="form-control" placeholder="Importe total" required type="number" step="0.01" value="<%=uven.getImporteTotal()%>">
                    </div>
                    <div class="col-md-6">
                        <label for="inputVenta" class="form-label">Fecha de la Venta</label>
    					<input id="inputVenta" name="fechaVenta" class="form-control" required type="date" value="<%=uven.getFechaVenta()%>">
                    </div>
                    <div class="col-md-6">
                        <label for="inputCliente" class="form-label">Cliente</label>
					      <select name="cliente" id="inputCliente" class="sr-only">
					      	<% for (Cliente c : lc) { %>
					      		<option value ='<%=c.getIdUsuario()%>'><%=c.getNomUsuario()%></option>
					      	<% } %>
					      </select>
                    </div>
                    <div class="col-md-6">
                        <label for="inputPrenda" class="sr-only">Prenda</label>
					      <select name="prenda" id="inputPrenda" class="form-select">
					      	<% for (Prenda pre : lpre) { %>
					      		<option value ='<%=pre.getCodPrenda()%>'><%=pre.getNombrePrenda()%></option>
					      	<% } %>
					      </select>
                    </div>
                    <div class="col-md-6">
                    <label for="inputMetodoPago" class="form-label fw-bold">Método de pago</label>
			        <select name="formaPago" id="inputMetodoPago" class="form-select">
			            <option value="Transferencia">Transferencia</option>
			            <option value="Tarjeta de Débito">Tarjeta de Débito</option>
			            <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
			        </select>
			        </div>
			        <div class="col-md-6">
                        <label for="inputEstado" class="form-label fw-bold">Estado</label>
				        <select name="estado" id="inputEstado" class="form-select">
				            <option value="Pendiente">Pendiente</option>
				            <option value="Aprobado">Aprobado</option>
				            <option value="Entregado">Entregado</option>
				            <option value="Rechazado">Rechazado</option>
				        </select>
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