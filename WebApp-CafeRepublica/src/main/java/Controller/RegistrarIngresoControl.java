package Controller;

import DAO.IngresoDAO;
import Model.Ingreso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegistrarIngresoControl")
public class RegistrarIngresoControl extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RegistrarIngresoControl.class);
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fechaStr = request.getParameter("fecha");
        String cantidadStr = request.getParameter("cantidad");
        String idProductoStr = request.getParameter("id");
        String idProveedorStr = request.getParameter("id_proveedor");
        String idUsuarioStr = request.getParameter("id_usuario");
        String precioUnitarioStr = request.getParameter("precio_unitario");
        if (fechaStr == null || cantidadStr == null || idProductoStr == null ||
                idProveedorStr == null || idUsuarioStr == null || precioUnitarioStr == null ||
                fechaStr.isEmpty() || cantidadStr.isEmpty() || idProductoStr.isEmpty() ||
                idProveedorStr.isEmpty() || idUsuarioStr.isEmpty() || precioUnitarioStr.isEmpty()) {
            System.out.println("Error: Todos los campos son obligatorios.");
            request.setAttribute("errorMessage", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("IngresoNuevo.jsp").forward(request, response);
            return;
        }

        try {

            int cantidad = Integer.parseInt(cantidadStr);
            int idProducto = Integer.parseInt(idProductoStr);
            int idProveedor = Integer.parseInt(idProveedorStr);
            int idUsuario = Integer.parseInt(idUsuarioStr);
            double precioUnitario = Double.parseDouble(precioUnitarioStr);
            double total = cantidad * precioUnitario;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(fechaStr);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            Ingreso ingreso = new Ingreso();
            ingreso.setFecha(sqlDate);
            ingreso.setCantidad(cantidad);
            ingreso.setId(idProducto);
            ingreso.setIdProveedor(idProveedor);
            ingreso.setIdUsuario(idUsuario);
            ingreso.setPrecioUnitario(precioUnitario);
            ingreso.setTotal(total);
            IngresoDAO ingresoDAO = new IngresoDAO();
            boolean registroExitoso = ingresoDAO.insertarIngreso(ingreso);
            if (registroExitoso) {
                System.out.println("Ingreso registrado exitosamente: ID Producto " + idProducto);
                request.setAttribute("mensaje", "Ingreso registrado exitosamente.");
                request.getRequestDispatcher("IngresoNuevo.jsp").forward(request, response);
            } else {
                System.out.println("Error al registrar el ingreso: ID Producto " + idProducto);
                request.setAttribute("errorMessage", "Error al registrar el ingreso. Intenta de nuevo.");
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            System.out.println("Error SQL al registrar el ingreso: " + e.getMessage());
            request.setAttribute("errorMessage", "Error en la base de datos: " + e.getMessage());
            request.getRequestDispatcher("404.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("Error en los datos ingresados: " + e.getMessage());
            request.setAttribute("errorMessage", "Formato de datos incorrecto: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            request.setAttribute("errorMessage", "Formato de fecha incorrecto: " + e.getMessage());
            request.getRequestDispatcher("IngresoNuevo.jsp").forward(request, response);
        }
    }
}