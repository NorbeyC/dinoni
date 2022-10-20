package edu.eci.arsw.dinoni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nps")
public class Nps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String producto;
    private String identificacionUsuario;
    private String nombreUsuario;
    private float satisfaccion;

    public Nps() {
    }

    /**
     * Constructor de la clase Nps
     * @param id
     * @param producto
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param satisfaccion
     */

    public Nps(long id, String producto, String identificacionUsuario, String nombreUsuario, float satisfaccion) {
        this.id = id;
        this.producto = producto;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.satisfaccion = satisfaccion;
    }

    /**
     * Constructor de la clase Nps sin recibir id
     * @param producto
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param satisfaccion
     */

    public Nps(String producto, String identificacionUsuario, String nombreUsuario, float satisfaccion) {
        this.producto = producto;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.satisfaccion = satisfaccion;
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

    public float getSatisfaccion() {
        return this.satisfaccion;
    }

    public void setSatisfaccion(float satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producto='" + getProducto() + "'" +
            ", identificacionUsuario='" + getIdentificacionUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", satisfaccion='" + getSatisfaccion() + "'" +
            "}";
    }
    

}
