package Pruebas;
import Model.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProveedorTest {
    private Proveedor proveedor;
    @BeforeEach
    public void setUp() {
        proveedor = new Proveedor();
    }
    @Test
    public void testCrearProveedor() {
        proveedor.setIdProveedor(1);
        proveedor.setNombre("Proveedora S.A.");
        proveedor.setContacto("Juan Pérez");
        proveedor.setTelefono("987654321");
        proveedor.setEmail("contacto@proveedor.com");
        proveedor.setDireccion("Av. Principal 123");
        proveedor.setDistrito("Lima");
        proveedor.setRuc("12345678901");
        assertEquals(1, proveedor.getIdProveedor());
        assertEquals("Proveedora S.A.", proveedor.getNombre());
        assertEquals("Juan Pérez", proveedor.getContacto());
        assertEquals("987654321", proveedor.getTelefono());
        assertEquals("contacto@proveedor.com", proveedor.getEmail());
        assertEquals("Av. Principal 123", proveedor.getDireccion());
        assertEquals("Lima", proveedor.getDistrito());
        assertEquals("12345678901", proveedor.getRuc());
    }

    @Test
    public void testSettersYGetters() {
        proveedor.setIdProveedor(2);
        assertEquals(2, proveedor.getIdProveedor());

        proveedor.setNombre("Proveedor B");
        assertEquals("Proveedor B", proveedor.getNombre());

        proveedor.setContacto("Ana García");
        assertEquals("Ana García", proveedor.getContacto());

        proveedor.setTelefono("123456789");
        assertEquals("123456789", proveedor.getTelefono());

        proveedor.setEmail("ana.garcia@proveedorb.com");
        assertEquals("ana.garcia@proveedorb.com", proveedor.getEmail());

        proveedor.setDireccion("Calle Falsa 456");
        assertEquals("Calle Falsa 456", proveedor.getDireccion());

        proveedor.setDistrito("Callao");
        assertEquals("Callao", proveedor.getDistrito());

        proveedor.setRuc("09876543210");
        assertEquals("09876543210", proveedor.getRuc());
    }

    @Test
    public void testToString() {
        proveedor.setIdProveedor(3);
        proveedor.setNombre("Proveedor C");
        proveedor.setContacto("Carlos Ruiz");
        proveedor.setTelefono("456789123");
        proveedor.setEmail("carlos.ruiz@proveedorc.com");
        proveedor.setDireccion("Calle Verdadera 789");
        proveedor.setDistrito("San Isidro");
        proveedor.setRuc("32165498700");

        String expectedString = "Proveedor{" +
                "idProveedor=3, " +
                "nombre='Proveedor C', " +
                "contacto='Carlos Ruiz', " +
                "telefono='456789123', " +
                "email='carlos.ruiz@proveedorc.com', " +
                "direccion='Calle Verdadera 789', " +
                "distrito='San Isidro', " +
                "ruc='32165498700'}";

        assertEquals(expectedString, proveedor.toString());
    }
}