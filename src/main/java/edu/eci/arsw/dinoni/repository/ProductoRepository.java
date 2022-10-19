package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findById(long id);

    boolean existsById(long id);

    Optional<Producto> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    void deleteById(long id);


}
    

