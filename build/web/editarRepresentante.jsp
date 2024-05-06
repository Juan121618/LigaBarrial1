<%@page import="Modelo.Representante"%>
<%@page import="DAO.RepresentanteDAO"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="DAO.ClasificacionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="h-100">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Representante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <link href="css/estilo.css" rel="stylesheet">
</head>

<body class="d-flex flex-column h-100">

    <!-- Begin page content -->
    <main class="flex-shrink-0">
        <div class="container">
            <h3 class="my-3">Editar Representante</h3>
            <% 
            try {
                // Recuperar el ID del usuario de la URL
                int idUsuario = Integer.parseInt(request.getParameter("id"));

                // Obtener el usuario de la base de datos utilizando el ID
                RepresentanteDAO dao = new RepresentanteDAO();
                Representante representanteEditar = dao.obtenerRepresentantePorId(idUsuario);
                if (representanteEditar != null) { // Verificar si se encontró el usuario
            %>
            <form action="GuardarEdicionRepresentanteServlet" method="post">
                <input type="hidden" name="idUsuario" value="<%= representanteEditar.getId() %>">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= representanteEditar.getNombre() %>">
                </div>
                <div class="mb-3">
                    <label for="usuario" class="form-label">Usuario</label>
                    <input type="text" class="form-control" id="usuario" name="usuario" value="<%= representanteEditar.getUsuario() %>">
                </div>
                <div class="mb-3">
                    <label for="contrasena" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="contrasena" name="contrasena" value="<%= representanteEditar.getContrasena() %>">
                </div>
                <button type="submit" class="btn btn-primary">Guardar cambios</button>
            </form>
            <% 
                } else {
            %>
            <p>El representante no existe o no se puede editar.</p>
            <% 
                }
            } catch (NumberFormatException e) {
            %>
            <p>Error: El ID del representante no es válido.</p>
            <% 
            }
            %>
        </div>
    </main>

    <!-- Pie de página -->
    <footer class="footer mt-auto py-3 bg-body-tertiary">
        <div class="container">
            <span class="text-body-secondary"> 2024 | Códigos de Programación</span>
        </div>
    </footer>

    <!-- Scripts y enlaces a JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>

</html>
