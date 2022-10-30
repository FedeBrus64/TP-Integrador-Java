<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Prenda" %>
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

    	LinkedList<Prenda> lp = (LinkedList<Prenda>)request.getAttribute("listaPrendas");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Prendas</h1>
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
                    				
                    				<td></td><!-- editar -->
                    				<td></td><!-- borrar -->
                    			</tr>
                    		<% } %>
                    		</tbody>	
	</div> <!-- /container -->
</body>
</html>