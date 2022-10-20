package edu.eci.arsw.dinoni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private String producto;
    private int cantidad;
    private int total;

    public Compra() {
    }

    /**
     * Constructor de la clase Compra
     * @param id
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param producto
     * @param cantidad
     * @param total
     */
    public Compra(long id, String identificacionUsuario, String nombreUsuario, String producto, int cantidad, int total) {
        this.id = id;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    /**
     * Constructor de la clase Compra sin recibir id
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param producto
     * @param cantidad
     * @param total
     */
    public Compra(String identificacionUsuario, String nombreUsuario, String producto, int cantidad, int total) {
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificacionUsuario() {
        return this.identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", identificacionUsuario='" + getIdentificacionUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }
}
