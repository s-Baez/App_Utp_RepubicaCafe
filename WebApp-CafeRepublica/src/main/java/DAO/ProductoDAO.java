package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Producto;

public class ProductoDAO {

    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT id, nombre, tamano, precio, stock, categoria_id, imagen FROM productos WHERE precio REGEXP '^[0-9]+(\\.[0-9]+)?$'";

        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tamano = rs.getString("tamano");

                double precio = 0.0;
                try {
                    precio = rs.getDouble("precio");
                } catch (SQLException | NumberFormatException e) {
                    System.out.println("Error al convertir el precio para el ID " + id + ": " + e.getMessage());
                    precio = 0.0;
                }
                String stock = rs.getString("stock");

                int categoriaId = rs.getInt("categoria_id");
                String imagen = rs.getString("imagen");


                productos.add(new Producto(id, nombre, tamano, precio, stock, categoriaId, imagen));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
    public boolean registrarProducto(Producto producto) {
        String query = "INSERT INTO productos (nombre, tamano, precio, stock, categoria_id, imagen) VALUES (?, ?, ?, ?, ?, ?)";
        boolean registroExitoso = false;

        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getTamano());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getStock());
            stmt.setInt(5, producto.getCategoriaId());
            stmt.setString(6, producto.getImagen());

            int filasAfectadas = stmt.executeUpdate();
            registroExitoso = filasAfectadas > 0;

            if (registroExitoso) {
                System.out.println("Producto registrado correctamente: " + producto.getNombre());
            } else {
                System.out.println("Error al registrar el producto: " + producto.getNombre());
            }

        } catch (SQLException e) {
            System.err.println("Error SQL al registrar el producto: " + e.getMessage());
            e.printStackTrace();
        }
        return registroExitoso;
    }
    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection connection = Conexion.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
            e.printStackTrace(System.err);
            return false;
        }
    }
    public List<Map<String, Object>> getAllProductos() {
        List<Map<String, Object>> productos = new ArrayList<>();
        String sql = "SELECT id, nombre, tamano, precio, stock, categoria_id, imagen FROM productos";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("ID", rs.getInt("id"));
                row.put("Nombre", rs.getString("nombre"));
                row.put("Tamano", rs.getString("tamano"));
                row.put("Precio", rs.getDouble("precio"));
                row.put("Stock", rs.getString("stock"));
                row.put("Categoria ID", rs.getInt("categoria_id"));
                row.put("Imagen", rs.getString("imagen"));
                productos.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}