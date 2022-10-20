package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    Optional<Venta> findById(long id);

    boolean existsById(long id);

    void deleteById(long id);

    Optional<Venta> findByFecha(String fecha);

    boolean existsByFecha(String fecha);

}
