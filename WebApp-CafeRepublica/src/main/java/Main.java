import DAO.Conexion;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try {
            Connection conexion = Conexion.conectar();
            if (conexion != null) {
                System.out.println("¡Conexión exitosa con la base de datos!");
                conexion.close();
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (Exception e) {

            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}