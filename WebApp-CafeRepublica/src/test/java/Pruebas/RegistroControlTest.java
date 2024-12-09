package Pruebas;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import Controller.RegistroControl;
import DAO.UsuarioDAO;
import Model.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class RegistroControlTest {
    @Mock
    private UsuarioDAO usuarioDAO;

    @InjectMocks
    private RegistroControl registroControl;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarUsuarioExitoso() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan.perez@example.com");
        usuario.setRol("user");
        usuario.setDni("12345678");
        usuario.setPassword("password123");
        when(usuarioDAO.registrarUsuario(usuario)).thenReturn(true);
        boolean resultado = usuarioDAO.registrarUsuario(usuario);
        assertTrue("El registro debería ser exitoso", resultado);
        verify(usuarioDAO, times(1)).registrarUsuario(usuario);
    }

    @Test
    public void testRegistrarUsuarioFallido() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan.perez@example.com");
        usuario.setRol("user");
        usuario.setDni("12345678");
        usuario.setPassword("password123");
        when(usuarioDAO.registrarUsuario(usuario)).thenReturn(false);
        boolean resultado = usuarioDAO.registrarUsuario(usuario);
        assertFalse("El registro debería fallar", resultado);
        verify(usuarioDAO, times(1)).registrarUsuario(usuario);
    }
}