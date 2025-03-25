<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Usuario" %>
<%@ page import="data.DataUsuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Usuarios - Sistema Vincenzo</title>
    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%
        DataUsuario du = new DataUsuario();
        LinkedList<Usuario> lu = (LinkedList<Usuario>) request.getAttribute("listaUsuarios");
    %>
</head>
<body class="bg-light">
    <div class="container py-5">
        <h1 class="text-center mb-4">Usuarios</h1>
        <div class="card shadow p-4">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre de Usuario</th>
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
                                    <a href='Usuarios?delUsu=<%=usu.getIdUsuario()%>' class='btn btn-danger btn-sm'>Eliminar</a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="card shadow p-4 mt-4">
            <h2 class="text-center mb-3">Crear nuevo Usuario</h2>
            <form action="Usuarios" method="post">
                <div class="row g-3">
                    <div class="col-md-6">
                        <label for="inputNomUsuario" class="form-label">Nombre de Usuario</label>
                        <input id="inputNomUsuario" name="nomUsuario" class="form-control" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword" class="form-label">Contraseña</label>
                        <input id="inputPassword" name="password" class="form-control" required type="password">
                    </div>
                    <div class="col-md-6">
                        <label for="inputNombre" class="form-label">Nombre</label>
                        <input id="inputNombre" name="nombre" class="form-control" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputApellido" class="form-label">Apellido</label>
                        <input id="inputApellido" name="apellido" class="form-control" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputEmail" class="form-label">Email</label>
                        <input id="inputEmail" name="email" class="form-control" required type="email">
                    </div>
                    <div class="col-md-6">
                        <label for="inputLocalidad" class="form-label">Localidad</label>
                        <input id="inputLocalidad" name="localidad" class="form-control" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputDireccion" class="form-label">Dirección</label>
                        <input id="inputDireccion" name="direccion" class="form-control" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputTipoUsuario" class="form-label">Tipo de Usuario</label>
                        <select name="tipoUsuario" id="inputTipoUsuario" class="form-select">
                            <option value="cliente">Cliente</option>
                            <option value="empleado">Empleado</option>
                        </select>
                    </div>
                </div>
                <div class="text-center mt-4">
                    <button class="btn btn-success" type="submit">Registrar</button>
                    <a href='Signin' class="btn btn-secondary">Atrás</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
