package com.RepublicaCafe;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

public class GoogleGuavaIngresoTest {

    public Map<String, Object> crearIngreso(int idIngreso, String fecha, int cantidad, int idProducto, int idProveedor, int idUsuario, double precioUnitario) {
        Preconditions.checkArgument(idIngreso > 0, "El ID de ingreso debe ser mayor que 0");
        Preconditions.checkArgument(cantidad > 0, "La cantidad debe ser mayor que 0");
        Preconditions.checkArgument(idProducto > 0, "El ID de producto debe ser mayor que 0");
        Preconditions.checkArgument(idProveedor > 0, "El ID de proveedor debe ser mayor que 0");
        Preconditions.checkArgument(idUsuario > 0, "El ID de usuario debe ser mayor que 0");
        Preconditions.checkArgument(precioUnitario > 0, "El precio unitario debe ser mayor que 0");
        double total = cantidad * precioUnitario;
        return ImmutableMap.<String, Object>builder()
                .put("idIngreso", idIngreso)
                .put("fecha", fecha)
                .put("cantidad", cantidad)
                .put("idProducto", idProducto)
                .put("idProveedor", idProveedor)
                .put("idUsuario", idUsuario)
                .put("precioUnitario", precioUnitario)
                .put("total", total)
                .build();
    }
    public List<Map<String, Object>> obtenerIngresosDePrueba() {
        List<Map<String, Object>> ingresos = Lists.newArrayList();

        ingresos.add(crearIngreso(1, "2024-11-07", 50, 101, 201, 301, 15.0));
        ingresos.add(crearIngreso(2, "2024-11-08", 30, 102, 202, 302, 10.5));
        ingresos.add(crearIngreso(3, "2024-11-09", 20, 103, 203, 303, 20.0));

        return ingresos;
    }
    public static void main(String[] args) {
        GoogleGuavaIngresoTest test = new GoogleGuavaIngresoTest();

        Map<String, Object> ingreso = test.crearIngreso(4, "2024-11-10", 10, 104, 204, 304, 25.0);
        System.out.println("Ingreso creado: " + ingreso);

        List<Map<String, Object>> ingresos = test.obtenerIngresosDePrueba();
        System.out.println("Ingresos de prueba:");
        ingresos.forEach(System.out::println);
    }
}