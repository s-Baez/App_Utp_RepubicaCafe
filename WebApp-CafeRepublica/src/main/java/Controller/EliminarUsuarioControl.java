package Controller;
import DAO.UsuarioDataDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EliminarUsuarioControl")
public class EliminarUsuarioControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && idParam.matches("\\d+")) {
            int idUsuario = Integer.parseInt(idParam);
            UsuarioDataDAO usuarioDataDAO = new UsuarioDataDAO();
            boolean eliminado = usuarioDataDAO.eliminarUsuario(idUsuario);

            if (eliminado) {
                response.sendRedirect("Usuarios.jsp");
            } else {
                request.setAttribute("error", "No se pudo eliminar el usuario.");
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "ID de usuario inválido.");
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
}