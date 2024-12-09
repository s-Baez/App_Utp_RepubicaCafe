package DAO;

import Model.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ProveedorDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorDAO.class);
    public static List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT id_proveedor, nombre, contacto, telefono, email, direccion, distrito, ruc FROM proveedor";

        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id_proveedor = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String contacto = rs.getString("contacto");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String distrito = rs.getString("distrito");
                String ruc = rs.getString("ruc");

                Proveedor proveedor = new Proveedor(id_proveedor, nombre, contacto, telefono, email, direccion, distrito, ruc);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la lista de proveedores: " + e.getMessage());
            e.printStackTrace();
        }

        return proveedores;
    }
    public boolean registrarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (nombre, contacto, telefono, email, direccion, distrito, ruc) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Conexion.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setString(4, proveedor.getEmail());
            stmt.setString(5, proveedor.getDireccion());
            stmt.setString(6, proveedor.getDistrito());
            stmt.setString(7, proveedor.getRuc());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error al registrar proveedor: " + e.getMessage(), e);
            e.printStackTrace();
            return false;
        }
    }
    public void eliminarProveedor(String id) {
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Map<String, Object>> getAllProveedores() {
        List<Map<String, Object>> proveedores = new ArrayList<>();
        String sql = "SELECT id_proveedor, nombre, contacto, telefono, email, direccion, distrito, ruc FROM proveedor";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("ID", rs.getInt("id_proveedor"));
                row.put("Nombre", rs.getString("nombre"));
                row.put("Contacto", rs.getString("contacto") != null ? rs.getString("contacto") : "No disponible");
                row.put("Telefono", rs.getString("telefono") != null ? rs.getString("telefono") : "No disponible");
                row.put("Email", rs.getString("email") != null ? rs.getString("email") : "No disponible");
                row.put("Direccion", rs.getString("direccion") != null ? rs.getString("direccion") : "No disponible");
                row.put("Distrito", rs.getString("distrito") != null ? rs.getString("distrito") : "No disponible");
                row.put("RUC", rs.getString("ruc"));

                proveedores.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

}