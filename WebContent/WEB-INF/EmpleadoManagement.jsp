<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Empleado" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema online Vincenzo</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">
    <!-- Custom styles -->
    <link href="style/list.css" rel="stylesheet">
    
    <% LinkedList<Empleado> le = (LinkedList<Empleado>) request.getAttribute("listaEmpleados"); %>
</head>
<body class="bg-light">

    <div class="container-fluid min-vh-100">
        <!-- Título de la página -->
        <h1 class="text-center mb-4">Empleados</h1>

        <!-- Botón de volver -->
        <a class="btn btn-primary mb-3" href="Signin">Atrás</a>

        <!-- Tabla de empleados con espacio adecuado -->
        <div class="table-responsive mb-5">
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre de usuario</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Fecha de ingreso</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Empleado emp : le) { %>
                    <tr>
                        <td><%= emp.getIdUsuario() %></td>
                        <td><%= emp.getNomUsuario() %></td>
                        <td><%= emp.getNombre() %></td>
                        <td><%= emp.getApellido() %></td>
                        <td><%= emp.getEmail() %></td>
                        <td><%= emp.getDireccion() %></td>
                        <td><%= emp.getLocalidad() %></td>
                        <td><%= emp.getFechaIngreso() %></td>
                        <td><a href="EditEmpleado?updEmp=<%= emp.getIdUsuario() %>" class="btn btn-warning btn-sm">Editar</a></td>
                        <td><a href="Empleados?delEmp=<%= emp.getIdUsuario() %>" class="btn btn-danger btn-sm">Eliminar</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <!-- Formulario para crear nuevo empleado -->
        <div class="card p-4">
            <h2 class="h4 text-center mb-3">Crear nuevo Empleado</h2>
            <form action="Empleados" method="post">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="inputNomUsuario">Nombre de usuario</label>
                        <input id="inputNomUsuario" name="nomUsuario" class="form-control" placeholder="Nombre de usuario" required type="text">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputPassword">Password</label>
                        <input id="inputPassword" name="password" class="form-control" placeholder="Password" required type="password">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputNombre">Nombre</label>
                        <input id="inputNombre" name="nombre" class="form-control" placeholder="Nombre" required type="text">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputApellido">Apellido</label>
                        <input id="inputApellido" name="apellido" class="form-control" placeholder="Apellido" required type="text">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputEmail">Email</label>
                        <input id="inputEmail" name="email" class="form-control" placeholder="Email" required type="email">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputLocalidad">Localidad</label>
                        <input id="inputLocalidad" name="localidad" class="form-control" placeholder="Localidad" required type="text">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputDireccion">Dirección</label>
                        <input id="inputDireccion" name="direccion" class="form-control" placeholder="Dirección" required type="text">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputFechaIngreso">Fecha de Ingreso</label>
                        <input id="inputFechaIngreso" name="fechaIngreso" class="form-control" required type="date">
                    </div>
                </div>
                <button class="btn btn-success btn-block" type="submit">Registrar</button>
            </form>
        </div>
    </div>

</body>
</html>
