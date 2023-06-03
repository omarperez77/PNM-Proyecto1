package edu.tecmm.bytebuilders.foodservice;

public class Platillos {
    int id;
    String nombre, ingredientes, precio, temperatura, estado, imagen;

    public Platillos() {

    }

    public Platillos(int id, String nombre, String ingredientes, String precio, String temperatura, String estado,String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.temperatura = temperatura;
        this.estado = estado;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
