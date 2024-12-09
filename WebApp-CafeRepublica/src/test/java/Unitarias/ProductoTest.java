package Unitarias;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import DAO.ProductoDAO;
import java.sql.*;
import java.util.List;

import Model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class ProductoTest {
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    private ProductoDAO productoDAO;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productoDAO = new ProductoDAO();
    }
    @Test
    public void testInsertarProducto() throws SQLException {

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        Producto producto = new Producto(0, "Café Latte", "Mediano", 4.00, "50", 1, "images/cafe-latte.jpg");
        boolean resultado = productoDAO.registrarProducto(producto);
        assertTrue(resultado);
    }
    @Test
    public void testEliminarProducto() throws SQLException {
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(11);
        boolean resultado = productoDAO.eliminarProducto(11);
        assertTrue(resultado);
    }
}