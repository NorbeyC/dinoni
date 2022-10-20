package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Resena;
import edu.eci.arsw.dinoni.repository.ResenaRepository;

@Service
public class ResenaService {
    
    @Autowired
    ResenaRepository resenaRepository;

    /**
     * Metodo que retorna todas las resenas
     * @return
     */

    public List<Resena> getAllResenas(){
        return resenaRepository.findAll();
    }

    /**
     * Metodo que retorna una resena por su id
     * @param id
     * @return
     */

    public Optional<Resena> getResenaById(long id){
        return resenaRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe una resena por su id
     * @param id
     * @return
     */

    public boolean existsById(long id){
        return resenaRepository.existsById(id);
    }

    /**
     * Metodo que retorna una resena por su identificacion de usuario
     * @param identificacionUsuario
     * @return
     */

    public Optional<Resena> getResenaByIdentificacionUsuario(String identificacionUsuario){
        return resenaRepository.findByIdentificacionUsuario(identificacionUsuario);
    }

    /**
     * Metodo que retorna si existe una resena por su identificacion de usuario
     * @param identificacionUsuario
     * @return
     */

    public boolean existsByIdentificacionUsuario(String identificacionUsuario){
        return resenaRepository.existsByIdentificacionUsuario(identificacionUsuario);
    }

    /**
     * Metodo que retorna una resena por su producto
     * @param identificacionProducto
     * @return
     */

    public Optional<Resena> getResenaByIdentificacionProducto(String identificacionProducto){
        return resenaRepository.findByProducto(identificacionProducto);
    }

    /**
     * Metodo que retorna si existe una resena por su producto
     * @param identificacionProducto
     * @return
     */

    public boolean existsByIdentificacionProducto(String identificacionProducto){
        return resenaRepository.existsByProducto(identificacionProducto);
    }

    /**
     * Metodo que guarda una resena
     * @param resena
     */

    public void saveResena(Resena resena){
        resenaRepository.save(resena);
    }

    /**
     * Metodo que elimina una resena por su id
     * @param id
     */

    public void deleteResenaById(long id){
        resenaRepository.deleteById(id);
    }

    /**
     * Metodo que actualiza una resena
     * @param id identificador de la resena a actualizar
     * @param resena
     */
    public void updateResena(long id, Resena resena){
        Resena temp = resenaRepository.findById(id).get();
        temp.setProducto(resena.getProducto());
        temp.setIdentificacionUsuario(resena.getIdentificacionUsuario());
        temp.setNombreUsuario(resena.getNombreUsuario());
        temp.setComentario(resena.getComentario());
        resenaRepository.save(temp);
    }

    /**
     * Metodo que elimina todas las resenas
     */
    public void deleteAllResenas(){
        resenaRepository.deleteAll();
    }

}
