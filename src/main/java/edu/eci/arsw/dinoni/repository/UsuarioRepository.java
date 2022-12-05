package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Retorna el usuario por su ID
     * @param id
     * @return
     */
    Optional<Usuario> findById(long id);

    /**
     * Retorna si existe el usuario
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Elimina un usuario
     * @param id
     */
    void deleteById(long id);

    /**
     * Retorna un usuario por su nombre
     * @param nombre
     * @return
     */
    Optional<Usuario> findByNombre(String nombre);

    /**
     * Retorna si existe un usuario por su nombre
     * @param nombre
     * @return
     */
    boolean existsByNombre(String nombre);

    /**
     * Retorna el usuario por su correo
     * @param correo
     * @return
     */
    Optional<Usuario> findByCorreo(String correo);

    /**
     * Retorna si existe un usuario por su correo
     * @param correo
     * @return
     */
    boolean existsByCorreo(String correo);

    /**
     * Retorna el usuario por su identificacion
     * @param identificacion
     * @return
     */
    Optional<Usuario> findByIdentificacion(String identificacion);

    /**
     * Retorna si existe un usuario por su identificacion
     * @param identificacion
     * @return
     */
    boolean existsByIdentificacion(String identificacion);

}
