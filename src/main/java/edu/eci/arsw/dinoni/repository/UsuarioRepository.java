package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(long id);

    boolean existsById(long id);

    void deleteById(long id);

    Optional<Usuario> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

    Optional<Usuario> findByIdentificacion(String identificacion);

    boolean existsByIdentificacion(String identificacion);

}
