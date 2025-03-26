<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Local" %>
<%@ page import="data.DataLocal" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Locales - Sistema Vincenzo</title>
    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%
        DataLocal dl = new DataLocal();
        LinkedList<Local> ll = (LinkedList<Local>) request.getAttribute("listaLocales");
    %>
</head>
<body class="bg-light">
    <div class="container py-5">
        <h1 class="text-center mb-4">Locales</h1>
        <div class="card shadow p-4">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Descripción del Local</th>
                            <th>Dirección</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Local loc : ll) { %>
                            <tr>
                                <td><%=loc.getCodLocal()%></td>
                                <td><%=loc.getDescLocal()%></td>
                                <td><%=loc.getDireccionLocal()%></td>
                                <td>
                                    <a href='EditLocal?updLoc=<%=loc.getCodLocal()%>' class='btn btn-warning btn-sm'>Editar</a>
                                    <a href='Locales?delLoc=<%=loc.getCodLocal()%>' class='btn btn-danger btn-sm'>Eliminar</a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="card shadow p-4 mt-4">
            <h2 class="text-center mb-3">Crear nuevo Local</h2>
            <form action="Locales" method="post">
                <div class="row g-3">
                    <div class="col-md-6">
                        <label for="inputDescripcionLocal" class="form-label">Descripción del local</label>
                        <input id="inputDireccionLocal" name="descLocal" class="form-control" required type="text">
                    </div>
                    <div class="col-md-6">
                        <label for="inputDireccionLocal" class="form-label">Dirección del local</label>
                        <input id="inputDireccionLocal" name="direccion" class="form-control" required type="password">
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
