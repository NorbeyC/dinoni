package edu.eci.arsw.dinoni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
    private String categoria;
    private char estado; //D: Disponible, N: No Disponible, E: Eliminado
    private String imagen;
    
    public Producto(){   
    }

    /**
     * Constructor de la clase Producto
     * @param id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param cantidad
     * @param categoria
     * @param estado
     * @param imagen
     */
    public Producto(long id, String nombre, String descripcion, int precio, int cantidad, String categoria, char estado, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.estado = estado;
        this.imagen = imagen;
    }

    /**
     * Constructor de la clase Producto sin el id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param cantidad
     * @param categoria
     * @param estado
     * @param imagen
     */
    public Producto(String nombre, String descripcion, int precio, int cantidad, String categoria, char estado, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.estado = estado;
        this.imagen = imagen;
    }
    

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Verifica si el producto esta disponible o no
     * @return
     */
    public boolean isDisponible() {
        if(this.getCantidad() > 0 && this.getEstado() == 'D'){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Realiza la compra de un producto
     * @param cantidad
     */
    public void compra(int cantidad){
        if((this.getCantidad() - cantidad) >= 0){
            this.setCantidad(this.getCantidad() - cantidad);
        }
        else{
            this.setCantidad(0);
        }
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public char getEstado() {
        return this.estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", estado='" + getEstado() + "'" +
            ", imagen='" + getImagen() + "'" +
            "}";
    }

}

