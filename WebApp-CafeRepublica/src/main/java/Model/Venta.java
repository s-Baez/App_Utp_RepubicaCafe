package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venta {
    private int idVenta;
    private String codigoFactura;
    private int numeroVenta;
    private LocalDate fecha;
    private String nombreProducto;
    private BigDecimal precio;
    private int cantidad;
    private String metodoPago;
    private double precioTotal;

    public Venta(int idVenta, String codigoFactura, int numeroVenta, LocalDate fecha, String nombreProducto, BigDecimal precio, int cantidad, String metodoPago, double precioTotal) {
        this.idVenta = idVenta;
        this.codigoFactura = codigoFactura;
        this.numeroVenta = numeroVenta;
        this.fecha = fecha;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
        this.precioTotal = precioTotal;

    }

    public Venta() {

    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public BigDecimal calcularTotal() {
        return precio.multiply(BigDecimal.valueOf(cantidad));
    }
}