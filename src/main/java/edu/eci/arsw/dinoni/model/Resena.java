package edu.eci.arsw.dinoni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resenas")
public class Resena {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="producto")
    private String producto;
    @Column(name = "identificacion_usuario")
    private String identificacionUsuario;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "comentario")
    private String comentario;
    @Column(name= "fecha")
    private String fecha;

    public Resena() {
    }

    /**
     * Constructor de la clase Resena
     * @param id
     * @param producto
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param comentario
     * @param fecha
     */
    public Resena(long id, String producto, String identificacionUsuario, String nombreUsuario, String comentario, String fecha) {
        this.id = id;
        this.producto = producto;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    /**
     * Constructor de la clase Resena sin id
     * @param producto
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param comentario
     * @param fecha
     */
    public Resena(String producto, String identificacionUsuario, String nombreUsuario, String comentario, String fecha) {
        this.producto = producto;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
        this.fecha = fecha;
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

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producto='" + getProducto() + "'" +
            ", identificacionUsuario='" + getIdentificacionUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", comentario='" + getComentario() + "'" +
            ", fecha='" + getFecha() + "'" +
            "}";
    }

}
