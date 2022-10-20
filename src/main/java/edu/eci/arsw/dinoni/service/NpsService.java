package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Nps;
import edu.eci.arsw.dinoni.repository.NpsRepository;

@Service
public class NpsService {

    @Autowired
    NpsRepository npsRepository;

    /**
     * Metodo que retorna todos los nps
     * @return
     */

    public List<Nps> getAllNps(){
        return npsRepository.findAll();
    }

    /**
     * Metodo que retorna un nps por su id
     * @param id
     * @return
     */

    public Optional<Nps> getNpsById(long id){
        return npsRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe un nps por su id
     * @param id
     * @return
     */

    public boolean existsById(long id){
        return npsRepository.existsById(id);
    }

    /**
     * Metodo que retorna un nps por su producto
     * @param producto
     * @return
     */

    public Optional<Nps> getNpsByProducto(String producto){
        return npsRepository.findByProducto(producto);
    }

    /**
     * Metodo que retorna si existe un nps por su producto
     * @param producto
     * @return
     */

    public boolean existsByProducto(String producto){
        return npsRepository.existsByProducto(producto);
    }

    /**
     * Metodo que retorna un nps por su identificacion de usuario
     * @param identificacionUsuario
     * @return
     */

    public Optional<Nps> getNpsByIdentificacionUsuario(String identificacionUsuario){
        return npsRepository.findByIdentificacionUsuario(identificacionUsuario);
    }

    /**
     * Metodo que retorna si existe un nps por su identificacion de usuario
     * @param identificacionUsuario
     * @return
     */

    public boolean existsByIdentificacionUsuario(String identificacionUsuario){
        return npsRepository.existsByIdentificacionUsuario(identificacionUsuario);
    }

    /**
     * Metodo que guarda un nps
     * @param nps
     */

    public void saveNps(Nps nps){
        npsRepository.save(nps);
    }


    /**
     * Metodo que actualiza un nps
     * @param id identificador del nps a actualizar
     * @param nps
     */
    public void updateNps(long id, Nps nps){
        Nps temp = npsRepository.findById(id).get();
        temp.setProducto(nps.getProducto());
        temp.setIdentificacionUsuario(nps.getIdentificacionUsuario());
        temp.setIdentificacionUsuario(nps.getIdentificacionUsuario());
        temp.setSatisfaccion(nps.getSatisfaccion());
        npsRepository.save(temp);
    }


    /**
     * Metodo que elimina un nps por su id
     * @param id
     */
    public void deleteNps(long id){
        npsRepository.deleteById(id);
    }
    
}
