<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Prenda" %>
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
	
	<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/list.css" rel="stylesheet">
    
    <%
    	DataTipoPrenda dtp = new DataTipoPrenda();
		LinkedList<TipoPrenda> ltp =  dtp.getAll();
    	LinkedList<Prenda> lp = (LinkedList<Prenda>)request.getAttribute("listaPrendas");
    	Prenda upre = (Prenda)request.getAttribute("updatePrenda");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Prendas</h1>
        	<a class="btn btn-lg btn-primary btn-block" href='Signin'>Atras</a>
            	<div class="col-12 col-sm-12 col-lg-12">
                	<div class="table-responsive">
                    	<table class="table">
                    		<thead>
                    			<tr>
                    				<th>ID</th>
                    				<th>Nombre</th>
                    		    	<th>Talle</th>
                        			<th>Color</th>
                        			<th>Marca</th>
                        			<th>Tipo de prenda</th>
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
                    				
                    				<td><a href='EditPrenda?updPre=<%=pre.getCodPrenda()%>' class=''>Edit</a></td><!-- editar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
	</div> <!-- /container -->
				</div>
			</div>
		</div>
	<div class ='col-12 col-sm-12 col-lg-12'>
	<form class="form-list" action="EditPrenda" method="post">
      <h2 class="h3 mb-3 font-weight-normal">Editar prenda</h2>
      
      <label for="inputCodPrenda" class="sr-only">Codigo de la prenda actual</label>
      <input id="inputCodPrenda" name="codPrenda" class="form-control" required type="number" readonly value="<%=upre.getCodPrenda()%>">
      
      <label for="inputNombrePrenda" class="sr-only">Nombre de la prenda</label>
      <input id="inputNombrePrenda" name="nombrePrenda" class="form-control" placeholder="Nombre de la prenda" required type="text" value="<%=upre.getNombrePrenda()%>">
      
      <label for="inputTalle" class="sr-only">Talle</label>
      <input id="inputTalle" name="talle" class="form-control" placeholder="Talle" required type="text" value="<%=upre.getTalle()%>">
      
      <label for="inputColor" class="sr-only">Color</label>
      <input id="inputColor" name="color" class="form-control" placeholder="Color" required type="text" value="<%=upre.getColor()%>">
      
      <label for="inputMarca" class="sr-only">Marca</label>
      <input id="inputMarca" name="marca" class="form-control" placeholder="Marca" required type="text" value="<%=upre.getMarca()%>">
      
      <label for="inputTipoPrenda" class="sr-only">Tipo de Prenda</label>
      <select name="tipoPrenda" id="inputTipoPrenda" class="sr-only">
      	<% for (TipoPrenda tp : ltp) { %>
      		<option value ='<%=tp.getCodTipoPrenda()%>'><%=tp.getDescTipoPrenda()%></option>
      	<% } %>
      </select>

      <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
    </form>
    </div>
</body>
</html>