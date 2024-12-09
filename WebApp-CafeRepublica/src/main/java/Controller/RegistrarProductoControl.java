package Controller;

import DAO.ProductoDAO;
import Model.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrarProductoControl")
public class RegistrarProductoControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre");
        String tamano = request.getParameter("tamano");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String stock = request.getParameter("stock");
        int categoriaId = Integer.parseInt(request.getParameter("categoria_id"));
        String imagen = request.getParameter("imagen");

        Producto producto = new Producto(0, nombre, tamano, precio, stock, categoriaId, imagen);
        ProductoDAO productoDAO = new ProductoDAO();
        boolean registroExitoso = productoDAO.registrarProducto(producto);

        if (registroExitoso) {

            response.sendRedirect("correctoregistro.jsp?mensaje=registro_exitoso");
        } else {

            response.sendRedirect("errorregistro.jsp?mensaje=registro_fallido");
        }
    }
}