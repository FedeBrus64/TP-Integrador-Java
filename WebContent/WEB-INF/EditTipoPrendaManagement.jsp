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
	
	<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/list.css" rel="stylesheet">
    
    <%
		DataTipoPrenda dtp = new DataTipoPrenda();
    	LinkedList<TipoPrenda> ltp = (LinkedList<TipoPrenda>)request.getAttribute("listaTiposPrendas");
    	TipoPrenda utp = (TipoPrenda)request.getAttribute("updateTipoPrenda");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row">
        	<h1>Tipos de Prenda</h1>
        	<a class="btn btn-lg btn-primary btn-block" href='TiposPrendas'>Atras</a>
            	<div class="col-12 col-sm-12 col-lg-12">
                	<div class="table-responsive">
                    	<table class="table">
                    		<thead>
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
                    				
                    				<td><input type="Submit" name="edit_tipoprenda" value="Edit"/></td><!-- editar -->
                    				<td><a href='TiposPrendas?updTp=<%=tp.getCodTipoPrenda()%>' class=''>Edit</a></td>
                    			</tr>
                    		<% } %>
                    		</tbody>	
                    		</table>
					</div> <!-- /container -->
				</div>
			</div>
		</div>
	<div class ='col-12 col-sm-12 col-lg-12'>
	<form class="form-list" action="EditTipoPrenda" method="post">
      <h2 class="h3 mb-3 font-weight-normal">Editar Tipo de Prenda</h2>
      
      <label for="inputId" class="sr-only">ID del tipo de prenda a editar</label>
      <input id="inputId" name="codtipoprenda" value="<%=utp.getCodTipoPrenda()%>" class="form-control" required type="number" readonly>
      
      <label for="inputDescripcion" class="sr-only">Descripcion</label>
      <input id="inputDescripcion" name="descripcion" value="<%=utp.getDescTipoPrenda()%>" class="form-control" placeholder="Descripcion" required type="text">
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
    </form>
    </div>
</body>
</html>