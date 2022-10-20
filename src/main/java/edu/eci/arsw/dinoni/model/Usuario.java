package edu.eci.arsw.dinoni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String tipoIdentificacion;
    private String identificacion;
    private String correo;
    private String passwd;
    private long telefono;

    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario
     * @param id
     * @param nombre
     * @param tipoIdentificacion
     * @param identificacion
     * @param correo
     * @param passwd
     * @param telefono
     */
    public Usuario(long id, String nombre, String tipoIdentificacion, String identificacion, String correo, String passwd, long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.correo = correo;
        this.passwd = passwd;
        this.telefono = telefono;
    }

    /**
     * Constructor de la clase Usuario sin recibir id
     * @param nombre
     * @param tipoIdentificacion
     * @param identificacion
     * @param correo
     * @param passwd
     * @param telefono
     */
    public Usuario(String nombre, String tipoIdentificacion, String identificacion, String correo, String passwd, long telefono) {
        this.nombre = nombre;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.correo = correo;
        this.passwd = passwd;
        this.telefono = telefono;
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

    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public long getTelefono() {
        return this.telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", tipoIdentificacion='" + getTipoIdentificacion() + "'" +
            ", identificacion='" + getIdentificacion() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", passwd='" + getPasswd() + "'" +
            ", telefono='" + getTelefono() + "'" +
            "}";
    }
}
