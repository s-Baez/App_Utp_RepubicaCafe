package Model;

import java.util.Date;

public class Ingreso {
    private int idIngreso;
    private Date fecha;
    private int cantidad;
    private int id;
    private String nombreProducto;
    private int idProveedor;
    private int idUsuario;
    private double precioUnitario;
    private double total;

    public Ingreso(int idIngreso, Date fecha, int cantidad, int id, String nombreProducto, int idProveedor, double precioUnitario, int idUsuario, double total) {
        this.idIngreso = idIngreso;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.idProveedor = idProveedor;
        this.precioUnitario = precioUnitario;
        this.idUsuario = idUsuario;
        this.total = total;
    }

    public Ingreso() {
        this.idIngreso = idIngreso;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.idProveedor = idProveedor;
        this.precioUnitario = precioUnitario;
        this.idUsuario = idUsuario;
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
