package Controller;
import DAO.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/EliminarProductoControl")
public class EliminarProductoControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && idParam.matches("\\d+")) {
            int idProducto = Integer.parseInt(idParam);
            ProductoDAO productoDAO = new ProductoDAO();
            boolean eliminado = productoDAO.eliminarProducto(idProducto);
            if (eliminado) {
                response.sendRedirect("productoslista.jsp");
            } else {
                request.setAttribute("error", "No se pudo eliminar el producto.");
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "ID de producto inválido.");
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
}