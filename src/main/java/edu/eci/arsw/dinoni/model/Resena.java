package edu.eci.arsw.dinoni.model;

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
    private String producto;
    private String identificacionUsuario;
    private String nombreUsuario;
    private String comentario;

    public Resena() {
    }

    /**
     * Constructor de la clase Resena
     * @param id
     * @param producto
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param comentario
     */

    public Resena(long id, String producto, String identificacionUsuario, String nombreUsuario, String comentario) {
        this.id = id;
        this.producto = producto;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
    }

    /**
     * Constructor de la clase Resena sin recibir id
     * @param producto
     * @param identificacionUsuario
     * @param nombreUsuario
     * @param comentario
     */

    public Resena(String producto, String identificacionUsuario, String nombreUsuario, String comentario) {
        this.producto = producto;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producto='" + getProducto() + "'" +
            ", identificacionUsuario='" + getIdentificacionUsuario() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", comentario='" + getComentario() + "'" +
            "}";
    }
}
