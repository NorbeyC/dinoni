package edu.eci.arsw.dinoni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Estadistica;
import edu.eci.arsw.dinoni.model.Nps;
import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Resena;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Retorna el producto por su ID
     * @param id
     * @return
     */
    Optional<Producto> findById(long id);

    /**
     * Retorna si existe el producto
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Retorna si existe el producto por su nombre
     * @param nombre
     * @return
     */
    Optional<Producto> findByNombre(String nombre);

    /**
     * Retorna las resenas encontradas del producto
     * @param producto
     * @return
     */
    @Query("SELECT p FROM Resena p WHERE p.producto = ?1")
    List<Resena> findResena(String producto);

    /**
     * Retorna los NPS encontrados del producto
     * @param producto
     * @return
     */
    @Query("SELECT p FROM Nps p WHERE p.producto = ?1")
    List<Nps> findNps(String producto);

    /**
     * Retorna las estadisticas encontradas del producto
     * @param producto
     * @return
     */
    @Query("SELECT p FROM Estadistica p WHERE p.producto = ?1")
    List<Estadistica> findEstadistica(String producto);

    /**
     * Retorna si existe el producto por su nombre
     * @param nombre
     * @return
     */
    boolean existsByNombre(String nombre);

    /**
     * Elimina el producto
     * @param id
     */
    void deleteById(long id);


}
    

