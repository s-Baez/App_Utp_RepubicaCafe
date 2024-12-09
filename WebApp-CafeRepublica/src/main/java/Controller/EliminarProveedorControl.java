package Controller;
import DAO.ProveedorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
@WebServlet("/EliminarProveedorControl")
public class EliminarProveedorControl extends HttpServlet {
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encodedId = request.getParameter("id");
        if (encodedId != null) {
            String decodedId = URLDecoder.decode(encodedId, StandardCharsets.UTF_8.toString());
            proveedorDAO.eliminarProveedor(decodedId);
            response.sendRedirect("Proveedores.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del proveedor es inválido o falta.");
        }
    }
}