package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Estadistica;
import edu.eci.arsw.dinoni.model.Nps;
import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Resena;
import edu.eci.arsw.dinoni.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    /**
     * Metodo que retorna todos los productos
     * @return
     */
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    /**
     * Metodo que retorna un producto por su id
     * @param id
     * @return
     */
    public Optional<Producto> getProductoById(long id){
        return productoRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe un producto por su id
     * @param id
     * @return
     */
    public boolean existsById(long id){
        return productoRepository.existsById(id);
    }

    /**
     * Metodo que retorna un producto por su nombre
     * @param nombre
     * @return
     */
    public Optional<Producto> getProductoByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    /**
     * Metodo que retorna las resenas de un producto
     * @param producto
     * @return
     */
    public List<Resena> getResenasByProducto(String producto){
        return productoRepository.findResena(producto);
    }

    /**
     * Metodo que retorna el nps de un producto
     * @param producto
     * @return
     */
    public List<Nps> getNpsByProducto(String producto){
        return productoRepository.findNps(producto);
    }

    /**
     * Metodo que retorna las estadisticas de un producto
     * @param producto
     * @return
     */
    public List<Estadistica> getEstadisticasByProducto(String producto){
        return productoRepository.findEstadistica(producto);
    }

    /**
     * Metodo que retorna si existe un producto por su nombre
     * @param nombre
     * @return
     */
    public boolean existsByNombre(String nombre){
        return productoRepository.existsByNombre(nombre);
    }

    /**
     * Metodo que guarda un producto
     * @param producto
     */
    public void saveProducto(Producto producto){
        productoRepository.save(producto);
    }

    /**
     * Metodo que actualiza un producto
     * @param id id del producto a actualizar
     * @param producto producto con los nuevos datos
     */
    public void updateProducto(long id, Producto producto){
        Producto temp = productoRepository.findById(id).get();
        temp.setNombre(producto.getNombre());
        temp.setDescripcion(producto.getDescripcion());
        temp.setPrecio(producto.getPrecio());
        temp.setCantidad(producto.getCantidad());
        temp.setCategoria(producto.getCategoria());
        temp.setEstado(producto.getEstado());
        temp.setImagen(producto.getImagen());
        productoRepository.save(temp);
    }

    /**
     * Metodo que elimina un producto por su id
     * @param id
     */
    public void deleteProducto(long id){
        productoRepository.deleteById(id);
    }

    /**
     * Metodo que elimina todos los productos
     */
    public void deleteAllProductos(){
        productoRepository.deleteAll();
    }    
    
}
