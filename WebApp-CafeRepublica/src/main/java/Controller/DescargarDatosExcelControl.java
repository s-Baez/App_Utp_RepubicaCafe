package Controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;
import DAO.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
@WebServlet("/DescargarDatosExcelControl")
public class DescargarDatosExcelControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabla = request.getParameter("tabla");

        if (tabla == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'tabla'.");
            return;
        }
        List<Map<String, Object>> data = obtenerDatos(tabla);

        if (data != null && !data.isEmpty()) {

            try (XSSFWorkbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet(tabla);

                Row headerRow = sheet.createRow(0);
                Set<String> keys = data.get(0).keySet();
                int cellIndex = 0;
                for (String key : keys) {
                    headerRow.createCell(cellIndex++).setCellValue(key);
                }
                int rowIndex = 1;
                for (Map<String, Object> rowData : data) {
                    Row row = sheet.createRow(rowIndex++);
                    int cellIndexData = 0;
                    for (String key : keys) {
                        row.createCell(cellIndexData++).setCellValue(rowData.get(key).toString());
                    }
                }
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=" + tabla + ".xlsx");
                try (OutputStream out = response.getOutputStream()) {
                    workbook.write(out);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al generar el archivo Excel.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encontraron datos para la tabla " + tabla);
        }
    }
    private List<Map<String, Object>> obtenerDatos(String tabla) {

        switch (tabla) {
            case "proveedores":
                return new ProveedorDAO().getAllProveedores();
            case "usuarios":
                return new UsuarioDAO().getAllUsuarios();
            case "productos":
                return new ProductoDAO().getAllProductos();
            case "ingresos":
                return new IngresoDAO().getAllIngresos();
            case "ventas":
                return new VentaDAO().getAllVentas();
            default:
                return Collections.emptyList();
        }
    }
}
