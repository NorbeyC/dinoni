package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Compra;
import edu.eci.arsw.dinoni.repository.CompraRepository;

@Service
public class CompraService {

    @Autowired
    CompraRepository compraRepository;

    /**
     * Metodo que retorna todas las compras
     * @return
     */

    public List<Compra> getAllCompras(){
        return compraRepository.findAll();
    }

    /**
     * Metodo que retorna una compra por su id
     * @param id
     * @return
     */

    public Optional<Compra> getCompraById(long id){
        return compraRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe una compra por su id
     * @param id
     * @return
     */
    public boolean existsById(long id){
        return compraRepository.existsById(id);
    }

    /**
     * Metodo que retorna una compra por su identificacion de usuario
     * @param identificacionUsuario
     * @return
     */
    public Optional<Compra> getCompraByIdentificacionUsuario(String identificacionUsuario){
        return compraRepository.findByIdentificacionUsuario(identificacionUsuario);
    }

    /**
     * Metodo que retorna si existe una compra por su identificacion de usuario
     * @param identificacionUsuario
     * @return
     */

    public boolean existsByIdentificacionUsuario(String identificacionUsuario){
        return compraRepository.existsByIdentificacionUsuario(identificacionUsuario);
    }

    /**
     * Metodo que guarda una compra
     * @param compra 
     */
    public void saveCompra(Compra compra){
        compraRepository.save(compra);
    }

    /**
     * Metodo que actualiza una compra
     * @param id identificador de la compra a actualizar
     * @param compra
     */
    public void updateCompra(long id, Compra compra){
        Compra temp = compraRepository.findById(id).get();
        temp.setIdentificacionUsuario(compra.getIdentificacionUsuario());
        temp.setNombreUsuario(compra.getNombreUsuario());
        temp.setProducto(compra.getProducto());
        temp.setCantidad(compra.getCantidad());
        temp.setTotal(compra.getTotal());
        compraRepository.save(temp);
    }

    /**
     * Metodo que elimina una compra por su id
     * @param id
     */
    public void deleteCompra(long id){
        compraRepository.deleteById(id);
    }

    /**
     * Metodo que elimina todas las compras
     */
    public void deleteAllCompras(){
        compraRepository.deleteAll();
    }
    
}
