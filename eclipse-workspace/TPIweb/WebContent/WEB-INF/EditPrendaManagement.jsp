<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Prenda" %>
<%@ page import="entities.TipoPrenda" %>
<%@ page import="data.DataTipoPrenda" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Local" %>
<%@ page import="data.DataLocal" %>


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
    	DataLocal dl = new DataLocal();
		LinkedList<TipoPrenda> ltp =  dtp.getAll();
		LinkedList<Local> lloc = dl.getAll();
    	LinkedList<Prenda> lp = (LinkedList<Prenda>)request.getAttribute("listaPrendas");
    	Prenda upre = (Prenda)request.getAttribute("updatePrenda");
	%>
	
</head>
<body class="bg-light">
	<div class="container py-5">
        <h1 class="text-center mb-4">Prendas</h1>
        <a class="btn btn-primary mb-3" href='Prendas'>Atrás</a>

        <div class="row">
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
                        			<th>Local de la prenda</th>
                        			<th>Precio unitario de la prenda</th>
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
                    				<td><%=pre.get_local().getDescLocal() %></td>
                    				<td><%=pre.getPrecioUnitario()%></td>
                    				<td></td>
                    				
                    				<td><a href='EditPrenda?updPre=<%=pre.getCodPrenda()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>
                    	</table>	
					</div> <!-- /container -->
				</div>
				
	<!-- Formulario de Edición -->
            <div class="card shadow p-4 mt-4">
                    <h2 class="h4 text-center">Editar Prenda</h2>
                    <form action="EditPrenda" method="post">
                        <div class="row g-3">
      
      <div class="col-md-6">
      <label for="inputCodPrenda" class="form-label">Codigo de la prenda actual</label>
      <input id="inputCodPrenda" name="codPrenda" class="form-control" required type="number" readonly value="<%=upre.getCodPrenda()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputNombrePrenda" class="form-label">Nombre de la prenda</label>
      <input id="inputNombrePrenda" name="nombrePrenda" class="form-control" placeholder="Nombre de la prenda" required type="text" value="<%=upre.getNombrePrenda()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputTalle" class="form-label">Talle</label>
      <input id="inputTalle" name="talle" class="form-control" placeholder="Talle" required type="text" value="<%=upre.getTalle()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputColor" class="form-label">Color</label>
      <input id="inputColor" name="color" class="form-control" placeholder="Color" required type="text" value="<%=upre.getColor()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputMarca" class="form-label">Marca</label>
      <input id="inputMarca" name="marca" class="form-control" placeholder="Marca" required type="text" value="<%=upre.getMarca()%>">
      </div>
      
      <div class="col-md-6">
      <label for="inputTipoPrenda" class="form-label">Tipo de Prenda</label>
      <select name="tipoPrenda" id="inputTipoPrenda" class="form-select">
      	<% for (TipoPrenda tp : ltp) { %>
      		<option value ='<%=tp.getCodTipoPrenda()%>'><%=tp.getDescTipoPrenda()%></option>
      	<% } %>
      </select>
      </div>
      
     <div class="col-md-6">
         <label for="inputLocal" class="form-label">Local en el que se vende la prenda</label>
         <select name="local" id="inputLocal" class="form-select">
             <% for (Local l : lloc) { %>
                 <option value='<%= l.getCodLocal() %>'><%= l.getDescLocal() %></option>
             <% } %>
         </select>
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