package edu.eci.arsw.dinoni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Resena;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findById(long id);

    boolean existsById(long id);

    Optional<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Resena p WHERE p.producto = ?1")
    List<Resena> findResena(String producto);

    boolean existsByNombre(String nombre);

    void deleteById(long id);


}
    

