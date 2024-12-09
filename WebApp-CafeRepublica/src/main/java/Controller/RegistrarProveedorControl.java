package Controller;
import DAO.ProveedorDAO;
import Model.Proveedor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@WebServlet("/RegistrarProveedorControl")
public class RegistrarProveedorControl extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RegistrarProveedorControl.class);
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String contacto = request.getParameter("contacto");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String distrito = request.getParameter("distrito");
        String ruc = request.getParameter("ruc");

        if (nombre.isEmpty() || contacto.isEmpty() || telefono.isEmpty() ||
                email.isEmpty() || direccion.isEmpty() || distrito.isEmpty() || ruc.isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("404.jsp").forward(request, response);
            return;
        }

        Proveedor nuevoProveedor = new Proveedor();
        nuevoProveedor.setNombre(nombre);
        nuevoProveedor.setContacto(contacto);
        nuevoProveedor.setTelefono(telefono);
        nuevoProveedor.setEmail(email);
        nuevoProveedor.setDireccion(direccion);
        nuevoProveedor.setDistrito(distrito);
        nuevoProveedor.setRuc(ruc);

        ProveedorDAO proveedorDAO = new ProveedorDAO();
        boolean registroExitoso = proveedorDAO.registrarProveedor(nuevoProveedor);

        if (registroExitoso) {
            logger.info("Proveedor registrado exitosamente: " + nombre);
            request.setAttribute("mensaje", "Proveedor registrado exitosamente.");
            request.getRequestDispatcher("ProveedorNuevo.jsp").forward(request, response);
        } else {
            logger.error("Error al registrar el proveedor: " + nuevoProveedor.getNombre());
            request.setAttribute("error", "Error al registrar el proveedor. Intenta de nuevo.");
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
}