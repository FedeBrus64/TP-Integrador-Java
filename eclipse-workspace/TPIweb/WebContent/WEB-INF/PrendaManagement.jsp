<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Prenda" %>
<%@ page import="entities.TipoPrenda" %>
<%@ page import="data.DataTipoPrenda" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema online Vincenzo - Prendas</title>

    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <%
        DataTipoPrenda dtp = new DataTipoPrenda();
        LinkedList<TipoPrenda> ltp = dtp.getAll();
        LinkedList<Prenda> lp = (LinkedList<Prenda>) request.getAttribute("listaPrendas");
    %>
</head>

<body class="bg-light">

<div class="container mt-4">
    <h1 class="text-center">Gestión de Prendas</h1>
    <a class="btn btn-secondary mb-3" href='Signin'>Atrás</a>

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
                        <th>Tipo de Prenda</th>
                        <th>Precio</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Prenda pre : lp) { %>
                        <tr>
                            <td><%= pre.getCodPrenda() %></td>
                            <td><%= pre.getNombrePrenda() %></td>
                            <td><%= pre.getTalle() %></td>
                            <td><%= pre.getColor() %></td>
                            <td><%= pre.getMarca() %></td>
                            <td><%= pre.get_tipoPrenda().getDescTipoPrenda() %></td>
                            <td><%= pre.getPrecioUnitario() %></td>
                            <td>
                                <a href='EditPrenda?updPre=<%= pre.getCodPrenda() %>' class='btn btn-warning btn-sm'>Editar</a>
                                <a href='Prendas?delPre=<%= pre.getCodPrenda() %>' class='btn btn-danger btn-sm'>Eliminar</a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Formulario para agregar nueva prenda -->
    <div class="card mt-4 shadow p-4">
        <h2 class="text-center mb-3">Registrar Nueva Prenda</h2>
        <form action="Prendas" method="post">
            <div class="mb-3">
                <label for="inputNombrePrenda" class="form-label">Nombre de la prenda</label>
                <input id="inputNombrePrenda" name="nombrePrenda" class="form-control" placeholder="Nombre de la prenda" required type="text">
            </div>

            <div class="mb-3">
                <label for="inputTalle" class="form-label">Talle</label>
                <input id="inputTalle" name="talle" class="form-control" placeholder="Talle" required type="text">
            </div>

            <div class="mb-3">
                <label for="inputColor" class="form-label">Color</label>
                <input id="inputColor" name="color" class="form-control" placeholder="Color" required type="text">
            </div>

            <div class="mb-3">
                <label for="inputMarca" class="form-label">Marca</label>
                <input id="inputMarca" name="marca" class="form-control" placeholder="Marca" required type="text">
            </div>

            <div class="mb-3">
                <label for="inputTipoPrenda" class="form-label">Tipo de Prenda</label>
                <select name="tipoPrenda" id="inputTipoPrenda" class="form-select">
                    <% for (TipoPrenda tp : ltp) { %>
                        <option value='<%= tp.getCodTipoPrenda() %>'><%= tp.getDescTipoPrenda() %></option>
                    <% } %>
                </select>
            </div>
            
            <div class="mb-3">
                <label for="inputPrecioUnitario" class="form-label">Precio Unitario</label>
                <input id="inputPrecioUnitario" name="precioUnitario" class="form-control" placeholder="Precio Unitario" required type="number" step="0.01">
            </div>

            <button class="btn btn-primary w-100" type="submit">Registrar</button>
        </form>
    </div>
</div>

<!-- Bootstrap JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
