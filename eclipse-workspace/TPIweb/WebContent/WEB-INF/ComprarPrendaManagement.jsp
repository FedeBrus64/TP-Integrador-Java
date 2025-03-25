<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Prenda" %>
<%@ page import="entities.TipoPrenda" %>
<%@ page import="data.DataTipoPrenda" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Usuario" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comprar prenda</title>

<!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

	<%
	DataTipoPrenda dtp = new DataTipoPrenda();
	LinkedList<TipoPrenda> ltp =  dtp.getAll();
	LinkedList<Prenda> lp = (LinkedList<Prenda>)request.getAttribute("listaPrendas");
	
	Usuario usu= (Usuario)session.getAttribute("usuario");
	%>
</head>
<body class="bg-light">
<div class="container mt-4">
    <h1 class="text-center">Comprar una prenda</h1>
    <a class="btn btn-secondary mb-3" href='Signin?usuario=<%=usu.getEmail()%>'>Atrás</a>

    <!-- Tabla de Prendas -->
    <div class="card shadow p-4">
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    			<tr>
                    				<th>ID</th>
                    				<th>Nombre</th>
                    		    	<th>Talle</th>
                        			<th>Color</th>
                        			<th>Marca</th>
                        			<th>Tipo de prenda</th>
                        			<th>Precio</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Prenda pre : lp) { %>
                    			<tr>
                    				<td><%=pre.getCodPrenda()%></td>
                    				<td><%=pre.getNombrePrenda()%></td>
                    				<td><%=pre.getTalle()%></td>
                    				<td><%=pre.getColor()%></td>
                    				<td><%=pre.getMarca()%></td>
                    				<td><%=pre.get_tipoPrenda().getDescTipoPrenda()%></td>
                    				<td><%=pre.getPrecioUnitario()%></td>
                    				
                    				<td><a href='Checkout?prenda=<%=pre.getCodPrenda()%>' class=''>Comprar</a></td>
                    			</tr>
                    		<% } %>
                    		</tbody>	
	</div> <!-- /container -->
				</div>
			</div>
		</div>
		
	<!-- Bootstrap JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>