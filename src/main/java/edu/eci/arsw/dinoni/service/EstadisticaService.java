package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Estadistica;
import edu.eci.arsw.dinoni.repository.EstadisticaRepository;

@Service
public class EstadisticaService {

    @Autowired
    EstadisticaRepository estadisticaRepository;

    /**
     * Metodo que retorna todas las estadisticas
     * @return
     */

    public List<Estadistica> getAllEstadisticas(){
        return estadisticaRepository.findAll();
    }

    /**
     * Metodo que retorna una estadistica por su id
     * @param id
     * @return
     */

    public Optional<Estadistica> getEstadisticaById(long id){
        return estadisticaRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe una estadistica por su id
     * @param id
     * @return
     */

    public boolean existsById(long id){
        return estadisticaRepository.existsById(id);
    }

    /**
     * Metodo que retorna una estadistica por su producto
     * @param producto
     * @return
     */

    public Optional<Estadistica> getEstadisticaByProducto(String producto){
        return estadisticaRepository.findByProducto(producto);
    }

    /**
     * Metodo que retorna si existe una estadistica por su producto
     * @param producto
     * @return
     */

    public boolean existsByProducto(String producto){
        return estadisticaRepository.existsByProducto(producto);
    }

    /**
     * Metodo que guarda una estadistica
     * @param estadistica
     */

    public void saveEstadistica(Estadistica estadistica){
        estadisticaRepository.save(estadistica);
    }

    /**
     * Metodo que elimina una estadistica por su id
     * @param id
     */

    public void deleteEstadistica(long id){
        estadisticaRepository.deleteById(id);
    }

    /**
     * Metodo que elimina todas las estadisticas
     */

    public void deleteAllEstadisticas(){
        estadisticaRepository.deleteAll();
    }

    /**
     * Metodo que actualiza una estadistica
     * @param id
     * @param estadistica
     */
    public void updateEstadistica(long id, Estadistica estadistica){
        Estadistica temp = estadisticaRepository.findById(id).get();
        temp.setProducto(estadistica.getProducto());
        temp.setVentas(estadistica.getVentas());
        estadisticaRepository.save(temp);
    }
    
}
