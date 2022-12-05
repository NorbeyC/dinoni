package edu.eci.arsw.dinoni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.dinoni.model.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {

    /**
     * Retorna la resena por su ID
     * @param id
     * @return
     */
    Optional<Resena> findById(long id);

    /**
     * Retorna si existe la resena
     * @param id
     * @return
     */
    boolean existsById(long id);

    /**
     * Elimina la resena
     * @param id
     */
    void deleteById(long id);

    /**
     * Retorna las resenas por producto
     * @param producto
     * @return
     */
    List<Resena> findByProducto(String producto);

    /**
     * Retorna si existe una resena por su producto
     * @param producto
     * @return
     */
    boolean existsByProducto(String producto);

    /**
     * Retorna la resena por el usuario que la hice
     * @param identificacionUsuario
     * @return
     */
    Optional<Resena> findByIdentificacionUsuario(String identificacionUsuario);

    /**
     * Retorna si existe la resena
     * @param identificacionUsuario
     * @return
     */
    boolean existsByIdentificacionUsuario(String identificacionUsuario);

}
 
