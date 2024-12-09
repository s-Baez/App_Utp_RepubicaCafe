package DAO;

import Model.UsuarioData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDataDAO {
    public static List<UsuarioData> listarUsuarios() {
        List<UsuarioData> listaUsuarios = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, dni, email, rol, fecha_creacion FROM usuario";
        try (Connection connection = Conexion.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UsuarioData usuario = new UsuarioData(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("email"),
                        null,
                        rs.getString("rol"),
                        rs.getTimestamp("fecha_creacion")
                );

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        }
        return listaUsuarios;
    }
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection connection = Conexion.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace(System.err);
            return false;
        }
    }
}