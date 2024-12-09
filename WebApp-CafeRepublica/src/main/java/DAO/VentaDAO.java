package DAO;

import Model.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VentaDAO {

    public List<Venta> obtenerVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT v.id_venta, v.codigo_factura, v.numero_venta, v.PrecioTotal, v.fecha, "
                + "p.nombre AS nombre_producto, p.precio, v.cantidad, v.metodo_pago "
                + "FROM Ventas v JOIN productos p ON v.id_producto = p.id";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setCodigoFactura(rs.getString("codigo_factura"));
                venta.setNumeroVenta(rs.getInt("numero_venta"));
                venta.setFecha(rs.getDate("fecha").toLocalDate());
                venta.setNombreProducto(rs.getString("nombre_producto"));
                venta.setPrecio(rs.getBigDecimal("precio"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setMetodoPago(rs.getString("metodo_pago"));
                venta.setPrecioTotal(rs.getDouble("PrecioTotal"));

                ventas.add(venta);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return ventas;
    }
    public List<Map<String, Object>> getAllVentas() {
        List<Map<String, Object>> ventas = new ArrayList<>();
        String sql = "SELECT id_venta, codigo_factura, numero_venta, fecha, id_producto, cantidad, metodo_pago, PrecioTotal FROM ventas";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("ID_Venta", rs.getInt("id_venta"));
                row.put("Codigo_Factura", rs.getString("codigo_factura") != null ? rs.getString("codigo_factura") : "No disponible"); // Puede ser nulo
                row.put("Numero_Venta", rs.getObject("numero_venta") != null ? rs.getInt("numero_venta") : "No disponible"); // Puede ser nulo
                row.put("Fecha", rs.getObject("fecha") != null ? rs.getDate("fecha").toString() : "No disponible"); // Puede ser nulo
                row.put("ID_Producto", rs.getObject("id_producto") != null ? rs.getInt("id_producto") : "No disponible"); // Puede ser nulo
                row.put("Cantidad", rs.getObject("cantidad") != null ? rs.getInt("cantidad") : "No disponible"); // Puede ser nulo
                row.put("Metodo_Pago", rs.getString("metodo_pago") != null ? rs.getString("metodo_pago") : "No disponible"); // Puede ser nulo
                row.put("Precio_Total", rs.getObject("PrecioTotal") != null ? rs.getDouble("PrecioTotal") : "No disponible"); // Puede ser nulo

                ventas.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }
}