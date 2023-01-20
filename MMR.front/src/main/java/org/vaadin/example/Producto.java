package org.vaadin.example;

import com.google.gson.annotations.Expose;

public class Producto {

    @Expose
    private String nombre;
    @Expose
    private String categoria;
    @Expose
    private Float precio;
    @Expose
    private long ean13;
    private int id;

    public Producto() {

    }

    public Producto(String nombre, String categoria, Float precio, long ean13, int id) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.ean13 = ean13;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public long getEan13() {
        return ean13;
    }

    public void setEan13(long ean13) {
        this.ean13 = ean13;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", ean13=" + ean13 +
                ", id=" + id +
                '}';
    }
}
