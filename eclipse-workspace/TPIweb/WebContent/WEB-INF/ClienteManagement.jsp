<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Cliente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema online Vincenzo - Clientes</title>

    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <% LinkedList<Cliente> lc = (LinkedList<Cliente>) request.getAttribute("listaClientes"); %>
</head>
<body class="bg-light">
    <div class="container my-5">
        <h1 class="text-center mb-4">Clientes</h1>
        <a class="btn btn-primary mb-3" href='Signin'>Atrás</a>

        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Código Postal</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Cliente cli : lc) { %>
                    <tr>
                        <td><%= cli.getIdUsuario() %></td>
                        <td><%= cli.getNomUsuario() %></td>
                        <td><%= cli.getNombre() %></td>
                        <td><%= cli.getApellido() %></td>
                        <td><%= cli.getEmail() %></td>
                        <td><%= cli.getDireccion() %></td>
                        <td><%= cli.getLocalidad() %></td>
                        <td><%= cli.getCodigoPostal() %></td>
                        <td>
                            <a href='EditCliente?updCli=<%= cli.getIdUsuario() %>' class='btn btn-warning btn-sm'>Editar</a>
                        </td>
                        <td>
                            <a href='Clientes?delCli=<%= cli.getIdUsuario() %>' class='btn btn-danger btn-sm'>Eliminar</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <div class="card p-4 mt-4">
            <h2 class="h4 text-center mb-3">Crear nuevo Cliente</h2>
            <form action="Clientes" method="post">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Nombre de usuario</label>
                        <input type="text" name="nomUsuario" class="form-control" placeholder="Nombre de usuario" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" name="password" class="form-control" placeholder="Password" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Nombre</label>
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Apellido</label>
                        <input type="text" name="apellido" class="form-control" placeholder="Apellido" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" placeholder="Email" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Localidad</label>
                        <input type="text" name="localidad" class="form-control" placeholder="Localidad" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Dirección</label>
                        <input type="text" name="direccion" class="form-control" placeholder="Dirección" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Información de pago</label>
                        <input type="text" name="informacionPago" class="form-control" placeholder="Información de pago" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Código Postal</label>
                        <input type="number" name="codigoPostal" class="form-control" placeholder="Código Postal" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-success w-100">Registrar</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JavaScript Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
