package Controller;
import DAO.VentaDAO;
import Model.Venta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

@WebServlet("/ventaControl")
public class VentaControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VentaDAO ventaDAO;

    @Override
    public void init() {
        ventaDAO = new VentaDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Venta> ventas = ventaDAO.obtenerVentas();
        request.setAttribute("ventas", ventas);

        request.getRequestDispatcher("Ventas.jsp").forward(request, response);
    }


}