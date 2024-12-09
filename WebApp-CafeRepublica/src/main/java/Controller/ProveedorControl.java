package Controller;

import DAO.ProveedorDAO;
import Model.Proveedor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/proveedorControl")
public class ProveedorControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Proveedor> proveedores = ProveedorDAO.obtenerProveedores();
            request.setAttribute("proveedores", proveedores);
            request.getRequestDispatcher("Proveedores.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al cargar la lista de proveedores.");
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
}