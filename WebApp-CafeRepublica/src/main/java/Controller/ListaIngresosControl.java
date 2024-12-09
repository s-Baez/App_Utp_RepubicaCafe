package Controller;
import DAO.IngresoDAO;
import Model.Ingreso;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public class ListaIngresosControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngresoDAO ingresoDAO = new IngresoDAO();

        try {

            List<Ingreso> ingresos = ingresoDAO.listarIngresosConNombreProducto();

            request.setAttribute("ingresos", ingresos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Ingreso.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al listar los ingresos.");
        }
    }
}