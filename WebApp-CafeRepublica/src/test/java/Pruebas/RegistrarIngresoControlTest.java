package Pruebas;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import DAO.IngresoDAO;
import Model.Ingreso;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import Controller.RegistrarIngresoControl;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrarIngresoControlTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private IngresoDAO ingresoDAO;

    private TestableRegistrarIngresoControl registrarIngresoControl;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        registrarIngresoControl = new TestableRegistrarIngresoControl();
    }

    private class TestableRegistrarIngresoControl extends RegistrarIngresoControl {
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            super.doPost(request, response);
        }
    }

    @Test
    public void testRegistrarIngresoExitoso() throws Exception {
        when(request.getParameter("fecha")).thenReturn("2024-10-01");
        when(request.getParameter("cantidad")).thenReturn("10");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("id_proveedor")).thenReturn("2");
        when(request.getParameter("id_usuario")).thenReturn("3");
        when(request.getParameter("precio_unitario")).thenReturn("100.0");
        when(request.getRequestDispatcher("IngresoNuevo.jsp")).thenReturn(dispatcher);

        when(ingresoDAO.insertarIngreso(any(Ingreso.class))).thenReturn(true);

        registrarIngresoControl.doPost(request, response);

        verify(request).setAttribute("mensaje", "Ingreso registrado exitosamente.");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testRegistrarIngresoCamposFaltantes() throws Exception {
        when(request.getParameter("fecha")).thenReturn(null);
        when(request.getRequestDispatcher("IngresoNuevo.jsp")).thenReturn(dispatcher);

        registrarIngresoControl.doPost(request, response);

        verify(request).setAttribute("errorMessage", "Todos los campos son obligatorios.");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testRegistrarIngresoFormatoInvalido() throws Exception {
        when(request.getParameter("fecha")).thenReturn("fechaIncorrecta");
        when(request.getParameter("cantidad")).thenReturn("10");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("id_proveedor")).thenReturn("2");
        when(request.getParameter("id_usuario")).thenReturn("3");
        when(request.getParameter("precio_unitario")).thenReturn("100.0");
        when(request.getRequestDispatcher("IngresoNuevo.jsp")).thenReturn(dispatcher);

        registrarIngresoControl.doPost(request, response);

        verify(request).setAttribute("errorMessage", "Formato de fecha incorrecto: Unparseable date: \"fechaIncorrecta\"");
        verify(dispatcher).forward(request, response);
    }
    @Test
    public void testRegistrarIngresoErrorSQL() throws Exception {
        when(request.getParameter("fecha")).thenReturn("2024-10-01");
        when(request.getParameter("cantidad")).thenReturn("10");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("id_proveedor")).thenReturn("2");
        when(request.getParameter("id_usuario")).thenReturn("3");
        when(request.getParameter("precio_unitario")).thenReturn("100.0");
        when(request.getRequestDispatcher("404.jsp")).thenReturn(dispatcher);

        when(ingresoDAO.insertarIngreso(any(Ingreso.class))).thenThrow(new SQLException("Error en la base de datos"));
        registrarIngresoControl.doPost(request, response);
        verify(request).setAttribute("errorMessage", "Error en la base de datos: Error en la base de datos");
        verify(dispatcher).forward(request, response);
    }
}