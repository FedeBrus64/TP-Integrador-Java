<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Usuario" %>
<%@ page import="data.DataUsuario" %>
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
	
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <%
    	LinkedList<Usuario> lu = (LinkedList<Usuario>)request.getAttribute("listaUsuarios");
    	Usuario uusu = (Usuario)request.getAttribute("updateUsuario");
	%>
	
</head>
<body class="bg-light">
    <div class="container py-5">
        <h1 class="text-center mb-4">Usuarios</h1>
        <a class="btn btn-primary mb-3" href='Usuarios'>Atrás</a>

        <div class="row">
            <!-- Tabla de Usuarios -->
            <div class="card shadow p-4">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre de usuario</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Dirección</th>
                                <th>Localidad</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Usuario usu : lu) { %>
                                <tr>
                                    <td><%=usu.getIdUsuario()%></td>
                                    <td><%=usu.getNomUsuario()%></td>
                                    <td><%=usu.getNombre()%></td>
                                    <td><%=usu.getApellido()%></td>
                                    <td><%=usu.getEmail()%></td>
                                    <td><%=usu.getDireccion()%></td>
                                    <td><%=usu.getLocalidad()%></td>
                                    <td>
                                        <a href='EditUsuario?updUsu=<%=usu.getIdUsuario()%>' class='btn btn-warning btn-sm'>Editar</a>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Formulario de Edición -->
            <div class="card shadow p-4 mt-4">
                    <h2 class="h4 text-center">Editar Usuario</h2>
                    <form action="EditUsuario" method="post">
                        <div class="row g-3">
               
                    <div class="col-md-6">
                        <label for="inputIdUsuario" class="form-label">ID del usuario</label>
                        <input id="inputIdUsuario" name="idUsuario" class="form-control" readonly value="<%=uusu.getIdUsuario()%>" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputNomUsuario" class="form-label">Nombre de Usuario</label>
                        <input id="inputNomUsuario" name="nomUsuario" class="form-control" value = "<%=uusu.getNomUsuario()%>" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword" class="form-label">Contraseña</label>
                        <input id="inputPassword" name="password" class="form-control" value = "<%=uusu.getContraseña()%>" required type="password">
                    </div>
                    <div class="col-md-6">
                        <label for="inputNombre" class="form-label">Nombre</label>
                        <input id="inputNombre" name="nombre" class="form-control" value = "<%=uusu.getNombre()%>" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputApellido" class="form-label">Apellido</label>
                        <input id="inputApellido" name="apellido" class="form-control" value = "<%=uusu.getApellido()%>" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputEmail" class="form-label">Email</label>
                        <input id="inputEmail" name="email" class="form-control" value = "<%=uusu.getEmail()%>" required type="email">
                    </div>
                    <div class="col-md-6">
                        <label for="inputLocalidad" class="form-label">Localidad</label>
                        <input id="inputLocalidad" name="localidad" class="form-control" value = "<%=uusu.getLocalidad()%>" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputDireccion" class="form-label">Dirección</label>
                        <input id="inputDireccion" name="direccion" class="form-control" value = "<%=uusu.getDireccion()%>" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputTipoUsuario" class="form-label">Tipo de Usuario</label>
                        <select name="tipoUsuario" id="inputTipoUsuario" value = "<%=uusu.getTipoUsuario()%>" class="form-select">
                            <option value="cliente">Cliente</option>
                            <option value="empleado">Empleado</option>
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