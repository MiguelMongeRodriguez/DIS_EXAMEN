package es.ufv.dis.api.final2022.MMR;

import com.google.gson.annotations.Expose;

public class Producto {

    @Expose
    private String Nombre;
    @Expose
    private String Categoria;
    @Expose
    private Float Precio;
    @Expose
    private long EAN13;
    private int id;

    public Producto(String nombre, String categoria, Float precio, long EAN13, int id) {
        Nombre = nombre;
        Categoria = categoria;
        Precio = precio;
        this.EAN13 = EAN13;
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float precio) {
        Precio = precio;
    }

    public long getEAN13() {
        return EAN13;
    }

    public void setEAN13(long EAN13) {
        this.EAN13 = EAN13;
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
                "Nombre='" + Nombre + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Precio=" + Precio +
                ", EAN13=" + EAN13 +
                ", id=" + id +
                '}';
    }
}
