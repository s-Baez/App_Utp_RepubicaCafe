package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroControl")
public class RegistroControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String rol = request.getParameter("rol");
        String dni = request.getParameter("dni");
        String password = request.getParameter("password");
        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || rol.isEmpty() || dni.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setRol(rol);
        nuevoUsuario.setDni(dni);
        nuevoUsuario.setPassword(password);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean registroExitoso = usuarioDAO.registrarUsuario(nuevoUsuario);

        if (registroExitoso) {
            request.setAttribute("mensaje", "Registro exitoso. Puedes iniciar sesión.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Error al registrar el usuario. Intenta de nuevo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}