package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Ingreso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngresoDAO {
    private static final Logger logger = LoggerFactory.getLogger(IngresoDAO.class);
    public List<Ingreso> listarIngresosConNombreProducto() throws SQLException {
        List<Ingreso> ingresos = new ArrayList<>();
        String sql = "SELECT ingresos.id_ingreso, ingresos.fecha, ingresos.cantidad, productos.nombre AS nombre_producto, " +
                "ingresos.id_proveedor, ingresos.id_usuario, ingresos.precio_unitario, ingresos.total " +
                "FROM ingresos JOIN productos ON ingresos.id = productos.id";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ingreso ingreso = new Ingreso();
                ingreso.setIdIngreso(rs.getInt("id_ingreso"));
                ingreso.setFecha(rs.getDate("fecha"));
                ingreso.setCantidad(rs.getInt("cantidad"));
                ingreso.setNombreProducto(rs.getString("nombre_producto"));
                ingreso.setIdProveedor(rs.getInt("id_proveedor"));
                ingreso.setIdUsuario(rs.getInt("id_usuario"));
                ingreso.setPrecioUnitario(rs.getDouble("precio_unitario"));
                ingreso.setTotal(rs.getDouble("total"));

                ingresos.add(ingreso);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al listar los ingresos: " + e.getMessage(), e);
        }
        return ingresos;
    }
    public boolean insertarIngreso(Ingreso ingreso) throws SQLException {
        String sql = "INSERT INTO ingresos (fecha, cantidad, id, id_proveedor, id_usuario, precio_unitario, total) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Conexion.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(ingreso.getFecha().getTime()));
            stmt.setInt(2, ingreso.getCantidad());
            stmt.setInt(3, ingreso.getId());
            stmt.setInt(4, ingreso.getIdProveedor());
            stmt.setInt(5, ingreso.getIdUsuario());
            stmt.setDouble(6, ingreso.getPrecioUnitario());
            stmt.setDouble(7, ingreso.getTotal());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.error("Error al insertar ingreso: ", e);
            throw new SQLException("Error al insertar ingreso: " + e.getMessage(), e);
        }
    }
    public List<Map<String, Object>> getAllIngresos() {
        List<Map<String, Object>> ingresos = new ArrayList<>();
        String sql = "SELECT id_ingreso, fecha, cantidad, id, id_proveedor, id_usuario, precio_unitario, total FROM ingresos";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("ID_Ingreso", rs.getInt("id_ingreso"));
                row.put("Fecha", rs.getDate("fecha").toString());
                row.put("Cantidad", rs.getInt("cantidad"));
                row.put("ID", rs.getInt("id"));
                row.put("ID_Proveedor", rs.getObject("id_proveedor") != null ? rs.getInt("id_proveedor") : "No disponible");
                row.put("ID_Usuario", rs.getObject("id_usuario") != null ? rs.getInt("id_usuario") : "No disponible");
                row.put("Precio_Unitario", rs.getObject("precio_unitario") != null ? rs.getDouble("precio_unitario") : "No disponible");
                row.put("Total", rs.getObject("total") != null ? rs.getDouble("total") : "No disponible");
                ingresos.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return ingresos;
    }
}