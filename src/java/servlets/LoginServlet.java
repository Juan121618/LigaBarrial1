package servlets;

import DAO.RepresentanteDAO;
import DAO.ClasificacionDAO;
import Modelo.Clasificacion;
import Modelo.Representante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Obtener los parámetros del formulario
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");
            
            // Verificar la autenticación del usuario en la base de datos
            RepresentanteDAO daor = new RepresentanteDAO();
            ClasificacionDAO dao = new ClasificacionDAO();
            List<Clasificacion> usuarios = dao.listarclasificacion();
            boolean autenticado = false;
            String tipoUsuario = ""; // Variable para almacenar el tipo de usuario autenticado
            
            for (Clasificacion usuarioDB : usuarios) {
                if (usuarioDB.getUsuario().equals(usuario) && usuarioDB.getContrasena().equals(contrasena)) {
                    autenticado = true;
                    tipoUsuario = "usuarios";
                    break;
                }
            }
            
            // Si el usuario no se encuentra en la tabla Usuarios, buscar en la tabla Representante
            if (!autenticado) {
                // Obtener usuarios de la tabla Representante
                List<Representante> representantes = daor.listarrepresentante();
                for (Representante representanteDB : representantes) {
                    if (representanteDB.getUsuario().equals(usuario) && representanteDB.getContrasena().equals(contrasena)) {
                        autenticado = true;
                        tipoUsuario = "representantes";
                        break;
                    }
                }
            }
            
            // Redireccionar según el resultado de la autenticación
            if (autenticado) {
                // Almacenar el tipo de usuario en la sesión
                request.getSession().setAttribute("tipoUsuario", tipoUsuario);
                response.sendRedirect("inicio.jsp"); // Página de inicio después de iniciar sesión
            } else {
                out.println("<script>alert('Usuario o contraseña incorrectos');</script>");
                request.getRequestDispatcher("login.jsp").include(request, response); // Volver a la página de login
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
