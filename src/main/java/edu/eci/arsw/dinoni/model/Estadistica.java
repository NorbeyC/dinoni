package edu.eci.arsw.dinoni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadisticas")
public class Estadistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String producto;
    private int ventas;

    public Estadistica() {
    }

    /**
     * Constructor de la clase Estadistica
     * 
     * @param id
     * @param producto
     * @param ventas
     */

    public Estadistica(long id, String producto, int ventas) {
        this.id = id;
        this.producto = producto;
        this.ventas = ventas;
    }

    /**
     * Constructor de la clase Estadistica sin recibir id
     * 
     * @param producto
     * @param ventas
     */

    public Estadistica(String producto, int ventas) {
        this.producto = producto;
        this.ventas = ventas;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getVentas() {
        return this.ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producto='" + getProducto() + "'" +
            ", ventas='" + getVentas() + "'" +
            "}";
    }    
}
