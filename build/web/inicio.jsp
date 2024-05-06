<%@ page import="java.util.List" %>
<%@ page import="DAO.ClasificacionDAO" %>
<%@ page import="Modelo.Clasificacion" %>
<%@ page import="DAO.RepresentanteDAO" %>
<%@ page import="Modelo.Representante" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String tipoUsuario = (String) request.getSession().getAttribute("tipoUsuario");

    if (tipoUsuario == null) {
        // Si no hay ningún tipo de usuario en la sesión, redireccionar a la página de login
        response.sendRedirect("login.jsp");
    }
%>


<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Liga Barrial Semillitas del Futuro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <!--
            
        TemplateMo 559 Zay Shop
        
        https://templatemo.com/tm-559-zay-shop
        
        -->
    </head>

    <body>
        


        <!-- Header -->
        <nav class="navbar navbar-expand-lg navbar-light shadow">
            <div class="container d-flex justify-content-between align-items-center">

                <a class="navbar-brand text-success logo h1 align-self-center" href="index.jsp">
                    SF
                </a>

                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                    <div class="flex-fill">
                        <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="about.jsp">Acerca</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="contact.jsp">Contacto</a>
                            </li>
                        </ul>
                    </div>
                  
                </div>

            </div>
        </nav>
        <!-- Close Header -->
      <% if (tipoUsuario.equals("usuarios")) { %>
       <div class="row">
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="Clasificacion.jsp"><img src="./assets/img/category_img_01.png" class="rounded-circle img-fluid border"></a>
                    <h5 class="text-center mt-3 mb-3">Administrador</h5>
                    <p class="text-center"><a class="btn btn-success" href="Clasificacion.jsp">Ingresar</a></p>
                </div>
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="Representante.jsp"><img src="./assets/img/category_img_02.png" class="rounded-circle img-fluid border"></a>
                    <h2 class="h5 text-center mt-3 mb-3">Representante</h2>
                    <p class="text-center"><a class="btn btn-success" href="Representante.jsp">Ingresar</a></p>
                </div>
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="login.jsp"><img src="./assets/img/category_img_03.png" class="rounded-circle img-fluid border"></a>
                    <h2 class="h5 text-center mt-3 mb-3">Digitador</h2>
                    <p class="text-center"><a class="btn btn-success" href="login.jsp">Ingresar</a></p>
                </div>
            </div>
    <% } else if (tipoUsuario.equals("representantes")) { %>
        <div class="row">
                
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="Representante.jsp"><img src="./assets/img/category_img_02.png" class="rounded-circle img-fluid border"></a>
                    <h2 class="h5 text-center mt-3 mb-3">Representante</h2>
                    <p class="text-center"><a class="btn btn-success" href="Representante.jsp">Ingresar</a></p>
                </div>
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="login.jsp"><img src="./assets/img/category_img_03.png" class="rounded-circle img-fluid border"></a>
                    <h2 class="h5 text-center mt-3 mb-3">Digitador</h2>
                    <p class="text-center"><a class="btn btn-success" href="login.jsp">Ingresar</a></p>
                </div>
            </div>
    <% } %>

                <!-- Start Footer -->
        <footer class="bg-dark" id="tempaltemo_footer">
            <div class="container">
                <div class="row">

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-success border-bottom pb-3 border-light logo">Información</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li>
                                <i class="fas fa-map-marker-alt fa-fw"></i>
                                Av. Eloy Alfaro y 6 de Diciembre
                            </li>
                            <li>
                                <i class="fa fa-phone fa-fw"></i>
                                <a class="text-decoration-none" href="tel:0998832377">0998832377</a>
                            </li>
                            <li>
                                <i class="fa fa-envelope fa-fw"></i>
                                <a class="text-decoration-none" href="mailto:info@company.com">info@semillitas.com</a>
                            </li>
                        </ul>
                    </div>

                   

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Navega</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="#">Inicio</a></li>
                            <li><a class="text-decoration-none" href="#">Acerca</a></li>
                            <li><a class="text-decoration-none" href="#">Direcciones</a></li>
                            <li><a class="text-decoration-none" href="#">Contacto</a></li>
                        </ul>
                    </div>

                </div>

                <div class="row text-light mb-4">
                    <div class="col-12 mb-3">
                        <div class="w-100 my-3 border-top border-light"></div>
                    </div>
                    <div class="col-auto me-auto">
                        <ul class="list-inline text-left footer-icons">
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                            </li>
                        </ul>
                    </div>
                    
                </div>
            </div>

            <div class="w-100 bg-black py-3">
                <div class="container">
                    <div class="row pt-2">
                        <div class="col-12">
                            <p class="text-left text-light">
                                Copyright &copy; 2024 Juan Valdez
                               
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </footer>
        <!-- End Footer -->

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
        <!-- End Script -->
    </body>

</html>


