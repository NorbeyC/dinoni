package edu.eci.arsw.dinoni.controller;

import java.util.List;

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
import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Resena;

@Controller
@RequestMapping("/tienda")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @GetMapping("/allProductos")
    public ResponseEntity<List<Producto>> getAllProductos(){
        return new ResponseEntity<List<Producto>>(productoService.getAllProductos(), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/productos/id/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable("id") long id){
        if(!productoService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Producto ",HttpStatus.NOT_FOUND);
        }
        Producto producto = productoService.getProductoById(id).get();
        return new ResponseEntity<>(producto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/productos/nombre/{name}")
    public ResponseEntity<?> getProductoByName(@PathVariable("name") String nombre){
        if(!productoService.existsByNombre(nombre)){
            return new ResponseEntity<>("No se ha encontrado el nombre del Producto ",HttpStatus.NOT_FOUND);
        }
        Producto producto = productoService.getProductoByNombre(nombre).get();
        return new ResponseEntity<>(producto, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/saveProducto")
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto){
        try {
            productoService.saveProducto(producto);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear el producto " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") long id){
        if(!productoService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Producto ",HttpStatus.NOT_FOUND);
        }
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateProducto/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id") long id, @RequestBody Producto producto){
        if(!productoService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Producto ",HttpStatus.NOT_FOUND);
        }
        productoService.updateProducto(id, producto);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }

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

    @GetMapping(value="/viewSelectedProduct", params="name")
    public ModelAndView viewSelectedProduct(@RequestParam String name){
        ModelAndView mav = new ModelAndView();
        try {
            Producto producto = productoService.getProductoByNombre(name).get();
            mav.setViewName("viewSelectedProduct");
            mav.addObject("producto", producto);
            List<Resena> resenas = productoService.getResenasByProducto(producto.getNombre());
            mav.addObject("resenas", resenas);
        } catch (Exception e) {
            mav.setViewName("error");
        } 
        return mav;
    }

    @GetMapping("nuevoProducto")
    public ModelAndView nuevoProducto(){
        ModelAndView mav = new ModelAndView();
        Producto producto = new Producto();
        mav.setViewName("nuevoProducto");
        mav.addObject("producto", producto);
        return mav;
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("producto") Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/tienda/productsManagement";
    }

    @PostMapping("/actualizarProducto/{id}")
    public String actualizarProducto(@PathVariable("id") long id, @ModelAttribute("producto") Producto producto){
        if(!productoService.existsById(id)){
            productoService.saveProducto(producto);
        }
        productoService.updateProducto(id, producto);
        return "redirect:/tienda/productsManagement";
    }

    @GetMapping("editarProducto/{id}")
    public ModelAndView actualizarProducto(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        Producto producto = productoService.getProductoById(id).get();
        mav.setViewName("editarProducto");
        mav.addObject("producto", producto);
        return mav;
    }

    @GetMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable("id") long id){
        if(productoService.existsById(id)){
            productoService.deleteProducto(id);
        }
        return "redirect:/tienda/productsManagement";
    }


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

