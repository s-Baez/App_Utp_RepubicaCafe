package com.RepublicaCafe;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.math3.util.Precision;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ApacheCommonsIngresoTest {

    public Map<String, Object> crearIngreso(int idIngreso, String fecha, int cantidad, int idProducto, int idProveedor, int idUsuario, double precioUnitario) {
        Validate.isTrue(idIngreso > 0, "El ID de ingreso debe ser mayor que 0");
        Validate.isTrue(cantidad > 0, "La cantidad debe ser mayor que 0");
        Validate.isTrue(idProducto > 0, "El ID de producto debe ser mayor que 0");
        Validate.isTrue(idProveedor > 0, "El ID de proveedor debe ser mayor que 0");
        Validate.isTrue(idUsuario > 0, "El ID de usuario debe ser mayor que 0");
        Validate.isTrue(precioUnitario > 0, "El precio unitario debe ser mayor que 0");

        double total = cantidad * precioUnitario;
        Map<String, Object> ingreso = new HashMap<>();
        ingreso.put("idIngreso", idIngreso);
        ingreso.put("fecha", fecha);
        ingreso.put("cantidad", cantidad);
        ingreso.put("idProducto", idProducto);
        ingreso.put("idProveedor", idProveedor);
        ingreso.put("idUsuario", idUsuario);
        ingreso.put("precioUnitario", precioUnitario);
        ingreso.put("total", total);

        return ingreso;
    }
    public List<Map<String, Object>> obtenerIngresosDePrueba() {
        List<Map<String, Object>> ingresos = new ArrayList<>();

        ingresos.add(crearIngreso(1, "2024-11-07", 50, 101, 201, 301, 15.0));
        ingresos.add(crearIngreso(2, "2024-11-08", 30, 102, 202, 302, 10.5));
        ingresos.add(crearIngreso(3, "2024-11-09", 20, 103, 203, 303, 20.0));

        return ingresos;
    }
    public Date sumarDiasAFecha(String fechaStr, int dias) throws ParseException {
        Date fecha = DateUtils.parseDate(fechaStr, "yyyy-MM-dd");
        return DateUtils.addDays(fecha, dias);
    }
    public boolean verificarSiIngresoExiste(List<Map<String, Object>> ingresos, int idIngreso) {
        return CollectionUtils.exists(ingresos, ingreso -> ingreso.get("idIngreso").equals(idIngreso));
    }
    public double redondearTotal(double total) {
        return Precision.round(total, 2);
    }

    public void mostrarIngreso(List<Map<String, Object>> ingresos) {
        for (Map<String, Object> ingreso : ingresos) {
            String fecha = MapUtils.getString(ingreso, "fecha", "Fecha no disponible");
            if (StringUtils.isEmpty(fecha)) {
                fecha = "Fecha desconocida";
            }
            System.out.println("Fecha: " + fecha);
        }
    }
    public static void main(String[] args) throws ParseException {
        ApacheCommonsIngresoTest test = new ApacheCommonsIngresoTest();
        Map<String, Object> ingreso = test.crearIngreso(4, "2024-11-10", 10, 104, 204, 304, 25.0);
        System.out.println("Ingreso creado: " + ingreso);
        List<Map<String, Object>> ingresos = test.obtenerIngresosDePrueba();
        System.out.println("Ingresos de prueba:");
        test.mostrarIngreso(ingresos);
        boolean existe = test.verificarSiIngresoExiste(ingresos, 2);
        System.out.println("¿Ingreso con ID 2 existe? " + existe);
        Date nuevaFecha = test.sumarDiasAFecha("2024-11-07", 5);
        System.out.println("Nueva fecha sumando 5 días: " + nuevaFecha);
        double totalRedondeado = test.redondearTotal((double) ingreso.get("total"));
        System.out.println("Total redondeado: " + totalRedondeado);
    }
}