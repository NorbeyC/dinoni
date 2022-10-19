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
    private int categoria;
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
    public Producto(long id, String nombre, String descripcion, int precio, int cantidad, int categoria, char estado, String imagen) {
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
     * Constructor de la clase Producto sin recibir descripcion ni estado
     * @param id
     * @param nombre
     * @param precio
     * @param cantidad
     * @param Categoria
     * @param imagen
     */
    public Producto(long id, String nombre, int precio, int cantidad, int Categoria, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = Categoria;
        this.descripcion = "";
        this.estado = 'D';
        this.imagen = imagen;
    }
    
    public long getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getPrecio() {
        return precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
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

