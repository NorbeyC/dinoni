package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    /**
     * Retorna la compra por su ID
     * @param id
     * @return
     */
    Optional<Compra> findById(long id);

    /**
     * Retorna ni existe la compra
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Elimina una compra por su ID
     * @param id
     */
    void deleteById(long id);

    /**
     * Retorna una compra por la identificacion de usuario
     * @param identificacionUsuario
     * @return
     */
    Optional<Compra> findByIdentificacionUsuario(String identificacionUsuario);

    /**
     * Retorna si existe la compra por el usuario
     * @param identificacionUsuario
     * @return
     */
    boolean existsByIdentificacionUsuario(String identificacionUsuario);

}

