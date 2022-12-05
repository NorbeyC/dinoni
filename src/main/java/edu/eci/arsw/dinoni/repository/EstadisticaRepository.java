package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Estadistica;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

    /**
     * Retorna la estadistica por su ID
     * @param id
     * @return
     */
    Optional<Estadistica> findById(long id);

    /**
     * Retorna si existe la estadistica
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Elimina una estadistica
     * @param id
     */
    void deleteById(long id);

    /**
     * Retorna una estadistica por su producto
     * @param producto
     * @return
     */
    Optional<Estadistica> findByProducto(String producto);

    /**
     * Retorna si existe la estadistica por el producto
     * @param producto
     * @return
     */
    boolean existsByProducto(String producto);

}

