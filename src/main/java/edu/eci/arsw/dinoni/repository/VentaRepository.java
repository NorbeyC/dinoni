package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    /**
     * Retorna la venta
     * @param id
     * @return
     */
    Optional<Venta> findById(long id);

    /**
     * Retorna si existe la venta por su ID
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Elimina una venta
     */
    void deleteById(long id);

    /**
     * Retorna una venta por su fecha
     * @param fecha
     * @return
     */
    Optional<Venta> findByFecha(String fecha);

    /**
     * Retorna si existe la venta por su fecha
     * @param fecha
     * @return
     */
    boolean existsByFecha(String fecha);

}
