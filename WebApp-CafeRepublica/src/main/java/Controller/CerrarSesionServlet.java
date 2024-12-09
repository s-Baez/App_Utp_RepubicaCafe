package Controller;
import DAO.UsuarioDAO;
import Model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/CerrarSesionServlet")
public class CerrarSesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidar la sesión
        HttpSession session = request.getSession(false); // false: no crear una nueva sesión si no existe
        if (session != null) {
            session.invalidate(); // Cierra la sesión actual
        }

        response.sendRedirect("index.jsp");
    }
}