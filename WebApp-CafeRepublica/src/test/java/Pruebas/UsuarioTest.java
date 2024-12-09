package Pruebas;
import Model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
public class UsuarioTest {
    private Usuario usuario;
    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
    }
    @Test
    public void testCrearUsuario() {
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setDni("12345678");
        usuario.setEmail("juan.perez@example.com");
        usuario.setPassword("password123");
        usuario.setRol("Admin");
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Pérez", usuario.getApellido());
        assertEquals("12345678", usuario.getDni());
        assertEquals("juan.perez@example.com", usuario.getEmail());
        assertEquals("password123", usuario.getPassword());
        assertEquals("Admin", usuario.getRol());
    }
    @Test
    public void testSettersYGetters() {
        usuario.setNombre("Ana");
        assertEquals("Ana", usuario.getNombre());
        usuario.setApellido("García");
        assertEquals("García", usuario.getApellido());
        usuario.setDni("87654321");
        assertEquals("87654321", usuario.getDni());
        usuario.setEmail("ana.garcia@example.com");
        assertEquals("ana.garcia@example.com", usuario.getEmail());
        usuario.setPassword("newpassword");
        assertEquals("newpassword", usuario.getPassword());
        usuario.setRol("Usuario");
        assertEquals("Usuario", usuario.getRol());
    }
}