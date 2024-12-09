package DAO;

import java.sql.*;

public class DashboardDAO {

    // Método para obtener el total de ventas
    public int obtenerTotalVentas() {
        int totalVentas = 0;
        try (Connection con = Conexion.conectar()) {
            String query = "SELECT COUNT(*) FROM ventas";
            try (PreparedStatement stmt = con.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    totalVentas = rs.getInt(1); // El total de ventas
                }
                // Mostrar el total de ventas en consola
                System.out.println("Total de Ventas: " + totalVentas);
            }
        } catch (Exception e) {
            // Imprimir el error en caso de excepción
            System.out.println("Error al obtener el total de ventas: " + e.getMessage());
            e.printStackTrace();
        }
        return totalVentas;
    }

    // Método para obtener el total de ganancias
    public double obtenerTotalGanancias() {
        double totalGanancias = 0.0;
        try (Connection con = Conexion.conectar()) {
            String query = "SELECT SUM(PrecioTotal) FROM ventas";
            try (PreparedStatement stmt = con.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    totalGanancias = rs.getDouble(1);
                }
                // Mostrar el total de ganancias en consola
                System.out.println("Total de Ganancias: " + totalGanancias);
            }
        } catch (Exception e) {
            // Imprimir el error en caso de excepción
            System.out.println("Error al obtener el total de ganancias: " + e.getMessage());
            e.printStackTrace();
        }
        return totalGanancias;
    }

    // Método para obtener los ingresos al inventario
    public int obtenerIngresosAlInventario() {
        int ingresos = 0;
        try (Connection con = Conexion.conectar()) {
            String query = "SELECT COUNT(*) FROM ingresos";
            try (PreparedStatement stmt = con.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ingresos = rs.getInt(1); // El total de ingresos al inventario
                }
                // Mostrar los ingresos al inventario en consola
                System.out.println("Ingresos al Inventario: " + ingresos);
            }
        } catch (Exception e) {
            // Imprimir el error en caso de excepción
            System.out.println("Error al obtener los ingresos al inventario: " + e.getMessage());
            e.printStackTrace();
        }
        return ingresos;
    }

    // Método para obtener la cantidad de usuarios
    public int obtenerCantidadUsuarios() {
        int cantidad = 0;
        try (Connection con = Conexion.conectar()) {
            String query = "SELECT COUNT(*) FROM usuario";
            try (PreparedStatement stmt = con.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cantidad = rs.getInt(1); // La cantidad de usuarios
                }
                // Mostrar la cantidad de usuarios en consola
                System.out.println("Cantidad de Usuarios: " + cantidad);
            }
        } catch (Exception e) {
            // Imprimir el error en caso de excepción
            System.out.println("Error al obtener la cantidad de usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return cantidad;
    }
}