package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Nps;

@Repository
public interface NpsRepository extends JpaRepository<Nps, Long> {

    Optional<Nps> findById(long id);

    boolean existsById(long id);

    void deleteById(long id);

    Optional<Nps> findByProducto(String producto);

    boolean existsByProducto(String producto);

    Optional<Nps> findByIdentificacionUsuario(String identificacionUsuario);

    boolean existsByIdentificacionUsuario(String identificacionUsuario);

}
