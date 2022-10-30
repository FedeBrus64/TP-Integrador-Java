<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
    <link href="style/menu.css" rel="stylesheet">
</head>
<body>
	<h1>Bienvenido/a al sistema. Por favor, seleccione una opción</h1>
	<div class='containerButtons'>
		<form action='usuarios'>
			<button type='submit'>Ver Usuarios</button>
		</form>
		<form action='clientes'>
			<button class='buttonMenu' type='submit'>Ver Clientes</button>
		</form>
		<form action='empleados'>
			<button class='buttonMenu' type='submit'>Ver Empleados</button>
		</form>
		<form action='tiposprendas'>
			<button class='buttonMenu' type='submit'>Ver Tipos de prenda</button>
		</form>
		<form action='prendas'>
			<button class='buttonMenu' type='submit'>Ver Prendas</button>
		</form>
		<form action='ventas'>
			<button class='buttonMenu' type='submit'>Ver Ventas</button>
		</form>
	</div>
</body>
</html>