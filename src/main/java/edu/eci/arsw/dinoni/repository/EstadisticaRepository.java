package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Estadistica;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

    Optional<Estadistica> findById(long id);

    boolean existsById(long id);

    void deleteById(long id);

    Optional<Estadistica> findByProducto(String producto);

    boolean existsByProducto(String producto);

}

