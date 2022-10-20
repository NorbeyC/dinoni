package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {

    Optional<Resena> findById(long id);

    boolean existsById(long id);

    void deleteById(long id);

    Optional<Resena> findByProducto(String producto);

    boolean existsByProducto(String producto);

    Optional<Resena> findByIdentificacionUsuario(String identificacionUsuario);

    boolean existsByIdentificacionUsuario(String identificacionUsuario);

}
 
