package Controller;

import DAO.DashboardDAO;
import com.mysql.jdbc.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instancia del DAO
        DashboardDAO dashboardDAO = new DashboardDAO();

        // Obtener los datos del DAO
        int totalVentas = dashboardDAO.obtenerTotalVentas();
        double totalGanancias = dashboardDAO.obtenerTotalGanancias();
        int ingresosAlInventario = dashboardDAO.obtenerIngresosAlInventario();
        int cantidadUsuarios = dashboardDAO.obtenerCantidadUsuarios();

        // Poner los datos en el request para que estén disponibles en el JSP
        request.setAttribute("totalVentas", totalVentas);
        request.setAttribute("totalGanancias", totalGanancias);
        request.setAttribute("ingresosAlInventario", ingresosAlInventario);
        request.setAttribute("cantidadUsuarios", cantidadUsuarios);
        System.out.println("Pasando datos al JSP: " + totalVentas + ", " + totalGanancias + ", " + ingresosAlInventario + ", " + cantidadUsuarios);
        // Redirigir a la vista JSP (inicio.jsp)
        request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
    }
}