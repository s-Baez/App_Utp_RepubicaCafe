package Controller;
import DAO.UsuarioDataDAO;
import Model.UsuarioData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/ListaUsuariosControl")
public class ListaUsuariosControl extends HttpServlet {
    private UsuarioDataDAO usuarioDataDAO;
    @Override
    public void init() {
        usuarioDataDAO = new UsuarioDataDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UsuarioData> listaUsuarios = usuarioDataDAO.listarUsuarios();
        request.setAttribute("Usuarios.jsp", listaUsuarios);
        request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
    }
}