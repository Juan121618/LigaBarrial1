package servlets;

import DAO.ClasificacionDAO;
import Modelo.Clasificacion;
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
            ClasificacionDAO dao = new ClasificacionDAO();
            List<Clasificacion> usuarios = dao.listarclasificacion();
            boolean autenticado = false;
            for (Clasificacion usuarioDB : usuarios) {
                if (usuarioDB.getUsuario().equals(usuario) && usuarioDB.getContrasena().equals(contrasena)) {
                    autenticado = true;
                    break;
                }
            }
            
            // Redireccionar según el resultado de la autenticación
            if (autenticado) {
                response.sendRedirect("Clasificacion.jsp"); // Página de inicio después de iniciar sesión
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
