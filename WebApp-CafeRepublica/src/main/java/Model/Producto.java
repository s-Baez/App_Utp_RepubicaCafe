package Model;

public class Producto {

    private int id;
    private String nombre;
    private String tamano;
    private double precio;
    private String stock;
    private int categoriaId;
    private String imagen;

    public Producto(int id, String nombre, String tamano, double precio, String stock, int categoriaId, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
        this.imagen = imagen;
    }


    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTamano() { return tamano; }
    public double getPrecio() { return precio; }
    public String getStock() { return stock; }
    public int getCategoriaId() { return categoriaId; }
    public String getImagen() { return imagen; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
