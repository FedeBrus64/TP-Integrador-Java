<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.TipoPrenda" %>
<%@ page import="data.DataTipoPrenda" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema Online Vincenzo - Tipos de Prenda</title>
    <!-- Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%
        DataTipoPrenda dtp = new DataTipoPrenda();
        LinkedList<TipoPrenda> ltp = (LinkedList<TipoPrenda>) request.getAttribute("listaTiposPrendas");
    %>
</head>
<body class="bg-light">
    <div class="container-fluid min-vh-100 d-flex justify-content-center align-items-center">
        <div class="row w-100">
            <div class="col-md-8 mx-auto">
                <div class="card shadow rounded p-4">
                    <h1 class="text-center">Tipos de Prenda</h1>
                    <hr>
                    <a class="btn btn-primary mb-3" href='Signin'>Atrás</a>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <thead class="table-dark">
                                <tr>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Editar</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (TipoPrenda tp : ltp) { %>
                                    <tr>
                                        <td><%=tp.getCodTipoPrenda()%></td>
                                        <td><%=tp.getDescTipoPrenda()%></td>
                                        <td><a href='EditTipoPrenda?updTp=<%=tp.getCodTipoPrenda()%>' class='btn btn-warning btn-sm'>Editar</a></td>
                                        <td><a href='TiposPrendas?delTp=<%=tp.getCodTipoPrenda()%>' class='btn btn-danger btn-sm'>Eliminar</a></td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card shadow rounded p-4 mt-4">
                    <h2 class="text-center">Crear Nuevo Tipo de Prenda</h2>
                    <form action="TiposPrendas" method="post">
                        <div class="mb-3">
                            <label for="inputDescripcion" class="form-label">Descripción</label>
                            <input id="inputDescripcion" name="descripcion" class="form-control" placeholder="Ingrese la descripción" required type="text">
                        </div>
                        <button class="btn btn-success w-100" type="submit">Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS desde CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
