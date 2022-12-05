package edu.eci.arsw.dinoni.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.dinoni.service.ProductoService;
import edu.eci.arsw.dinoni.model.Nps;
import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Resena;

@Controller
@RequestMapping("/tienda")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    /**
     * Metodo que retorna todos los productos en formato JSON
     * @return
     */
    @GetMapping("/allProductos")
    public ResponseEntity<List<Producto>> getAllProductos(){
        return new ResponseEntity<List<Producto>>(productoService.getAllProductos(), HttpStatus.ACCEPTED);
    }
    
    /**
     * Metodo que retorna un producto por su ID
     * @param id
     * @return
     */
    @GetMapping("/productos/id/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable("id") long id){
        if(!productoService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Producto ",HttpStatus.NOT_FOUND);
        }
        Producto producto = productoService.getProductoById(id).get();
        return new ResponseEntity<>(producto, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que retorna un producto por su nombre
     * @param nombre
     * @return
     */
    @GetMapping("/productos/nombre/{name}")
    public ResponseEntity<?> getProductoByName(@PathVariable("name") String nombre){
        if(!productoService.existsByNombre(nombre)){
            return new ResponseEntity<>("No se ha encontrado el nombre del Producto ",HttpStatus.NOT_FOUND);
        }
        Producto producto = productoService.getProductoByNombre(nombre).get();
        return new ResponseEntity<>(producto, HttpStatus.ACCEPTED);
    }
    
    /**
     * Metodo que guarda un producto
     * @param producto
     * @return
     */
    @PostMapping("/saveProducto")
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto){
        try {
            productoService.saveProducto(producto);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear el producto " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que elimina un producto
     * @param id
     * @return
     */
    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") long id){
        if(!productoService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Producto ",HttpStatus.NOT_FOUND);
        }
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que actualiza un producto
     * @param id
     * @param producto
     * @return
     */
    @PutMapping("/updateProducto/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id") long id, @RequestBody Producto producto){
        if(!productoService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Producto ",HttpStatus.NOT_FOUND);
        }
        productoService.updateProducto(id, producto);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que retorna el ModelAndView del catalogo de productos
     * @return
     */
    @GetMapping("/viewProductos")
    public ModelAndView viewProductos(){
        ModelAndView mav = new ModelAndView();
        try {
            List<Producto> productos = productoService.getAllProductos();
            mav.setViewName("viewProductos");
            mav.addObject("productos", productos);
        } catch (Exception e) {
            mav.setViewName("error");
        } 
        return mav;
    }

    /**
     * Metodo que busca un producto por su nombre y retorna el ModelAndView del catalogo de los productos encontrados 
     * @param search
     * @return
     */
    @GetMapping(value = "/viewProductos", params = "search")
    public ModelAndView searchProducto(@RequestParam("search") String search){
        ModelAndView mav = new ModelAndView();
        try {
            List<Producto> productos = productoService.getAllProductos().stream().filter(p -> p.getNombre().contains(search)).collect(Collectors.toList());
            mav.setViewName("search");
            mav.addObject("productos", productos);
        } catch (Exception e) {
            mav.setViewName("error");
        } 
        return mav;
    }

    /**
     * Metodo que retorna el ModelAndView del producto seleccionado
     * @param name
     * @return
     */
    @GetMapping(value="/viewSelectedProduct", params="name")
    public ModelAndView viewSelectedProduct(@RequestParam String name){
        ModelAndView mav = new ModelAndView();
        try {
            Producto producto = productoService.getProductoByNombre(name).get();
            mav.setViewName("viewSelectedProduct");
            mav.addObject("producto", producto);
            List<Resena> resenas = productoService.getResenasByProducto(producto.getNombre());
            mav.addObject("resenas", resenas);
            List<Nps> nps = productoService.getNpsByProducto(producto.getNombre());
            mav.addObject("nps", nps);
        } catch (Exception e) {
            mav.setViewName("error");
        } 
        return mav;
    }

    /**
     * Metodo que retorna el ModelAndView de nuevoProducto(Formulario)
     * @return
     */
    @GetMapping("nuevoProducto")
    public ModelAndView nuevoProducto(){
        ModelAndView mav = new ModelAndView();
        Producto producto = new Producto();
        mav.setViewName("nuevoProducto");
        mav.addObject("producto", producto);
        return mav;
    }

    /**
     * Metodo que agrega un nuevo producto estilo formulario
     * @param producto
     * @return
     */
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("producto") Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/tienda/productsManagement";
    }

    /**
     * Metodo que actualiza un producto
     * @param id
     * @param producto
     * @return
     */
    @PostMapping("/actualizarProducto/{id}")
    public String actualizarProducto(@PathVariable("id") long id, @ModelAttribute("producto") Producto producto){
        if(!productoService.existsById(id)){
            productoService.saveProducto(producto);
        }
        productoService.updateProducto(id, producto);
        return "redirect:/tienda/productsManagement";
    }

    /**
     * Metodo que retorna el ModelAndView de actualizarProducto
     * @param id
     * @return
     */
    @GetMapping("editarProducto/{id}")
    public ModelAndView actualizarProducto(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        Producto producto = productoService.getProductoById(id).get();
        mav.setViewName("editarProducto");
        mav.addObject("producto", producto);
        return mav;
    }

    /**
     * Metodo que elimina un producto
     * @param id
     * @return
     */
    @GetMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable("id") long id){
        if(productoService.existsById(id)){
            productoService.deleteProducto(id);
        }
        return "redirect:/tienda/productsManagement";
    }


    /**
     * Metodo que retorna el ModelAndView del Management de productos
     * @return
     */
    @GetMapping(value="productsManagement")
    public ModelAndView productsManagement(){
        ModelAndView mav = new ModelAndView();
        try {
            List<Producto> productos = productoService.getAllProductos();
            mav.setViewName("productsManagement");
            mav.addObject("productos", productos);
        } catch (Exception e) {
            mav.setViewName("error");
        } 
        return mav;
    }
}

