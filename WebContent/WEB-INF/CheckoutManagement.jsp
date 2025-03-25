<%@ page import="entities.Prenda" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <%
        Prenda cpre = (Prenda) request.getAttribute("checkoutPrenda");
    %>
</head>
<body class="bg-light">
    <div class="container min-vh-100 d-flex justify-content-center align-items-center">
        <div class="row w-100">
            <!-- Tarjeta de detalles del producto -->
            <div class="col-md-6 mx-auto">
                <div class="card shadow rounded p-4">
                    <h1 class="text-center">Compra a realizar</h1>
                    <hr>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><strong>Nombre:</strong> <%= cpre.getNombrePrenda() %></li>
                        <li class="list-group-item"><strong>Talle:</strong> <%= cpre.getTalle() %></li>
                        <li class="list-group-item"><strong>Color:</strong> <%= cpre.getColor() %></li>
                        <li class="list-group-item"><strong>Marca:</strong> <%= cpre.getMarca() %></li>
                        <li class="list-group-item"><strong>Precio:</strong> $<%= cpre.getPrecioUnitario() %></li>
                    </ul>
                </div>
            </div>

            <!-- Tarjeta de confirmación -->
            <div class="col-md-6 mx-auto mt-4">
                <div class="card shadow rounded p-4 text-center">
                    <h2 class="text-muted">¿Está seguro que desea realizar la compra?</h2>
                    <form action="Checkout" method="post">
                        <div class="mb-3">
                            <label for="inputMetodoPago" class="form-label fw-bold">Seleccione el método de pago:</label>
                            <select name="metodoPago" id="inputMetodoPago" class="form-select">
                                <option value="Efectivo/Transferencia">Efectivo/Transferencia</option>
                                <option value="Tarjeta de Débito">Tarjeta de Débito</option>
                                <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
                            </select>
                        </div>
                        <div class="d-flex justify-content-center gap-3">
                            <button class="btn btn-success px-4" type="submit">Comprar</button>
                            <a href="Comprar" class="btn btn-danger px-4">Volver</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
