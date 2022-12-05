package edu.eci.arsw.dinoni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Nps;

@Repository
public interface NpsRepository extends JpaRepository<Nps, Long> {

    /**
     * Retorna el NPS por su ID
     * @param id
     * @return
     */
    Optional<Nps> findById(long id);

    /**
     * Retorna si existe el NPS
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Elimina un NPS
     * @param id
     */
    void deleteById(long id);

    /**
     * Retorna un NPS por su producto
     * @param producto
     * @return
     */
    Optional<Nps> findByProducto(String producto);

    /**
     * Retorna si existe el NPS por el producto
     * @param producto
     * @return
     */
    boolean existsByProducto(String producto);

    /**
     * Retorna el NPS hecho por un usuario
     * @param identificacionUsuario
     * @return
     */
    Optional<Nps> findByIdentificacionUsuario(String identificacionUsuario);

    /**
     * Retorna si existe el NPS por un usuario en especifico
     * @param identificacionUsuario
     * @return
     */
    boolean existsByIdentificacionUsuario(String identificacionUsuario);

}
