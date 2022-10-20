package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    Optional<Compra> findById(long id);

    boolean existsById(long id);

    void deleteById(long id);

    Optional<Compra> findByIdentificacionUsuario(String identificacionUsuario);

    boolean existsByIdentificacionUsuario(String identificacionUsuario);

}

