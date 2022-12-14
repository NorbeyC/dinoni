package edu.eci.arsw.dinoni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.dinoni.service.EstadisticaService;
import edu.eci.arsw.dinoni.service.ProductoService;
import edu.eci.arsw.dinoni.service.VentaService;
import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Venta;

@Controller
@RequestMapping("/tienda")
public class VentaController {
    
    @Autowired
    VentaService ventaService;

    @Autowired
    ProductoService productoService;

    @Autowired
    EstadisticaService estadisticaService;

    /**
     * Metodo que retorna todas las ventas
     * @return
     */
    @GetMapping("/allVentas")
    public ResponseEntity<List<Venta>> getAllVentas(){
        return new ResponseEntity<List<Venta>>(ventaService.getAllVentas(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que retorna una venta por su ID
     * @param id
     * @return
     */
    @GetMapping("/ventas/id/{id}")
    public ResponseEntity<?> getVentaById(@PathVariable("id") long id){
        if(!ventaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Venta ",HttpStatus.NOT_FOUND);
        }
        Venta venta = ventaService.getVentaById(id).get();
        return new ResponseEntity<>(venta, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que guarda una venta
     * @param venta
     * @return
     */
    @PostMapping("/saveVenta")
    public ResponseEntity<?> saveVenta(@RequestBody Venta venta){
        try {
            ventaService.saveVenta(venta);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear la venta " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que elimina una venta
     * @param id
     * @return
     */
    @DeleteMapping("/deleteVenta/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable("id") long id){
        if(!ventaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Venta ",HttpStatus.NOT_FOUND);
        }
        ventaService.deleteVenta(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que actualiza una venta
     * @param id
     * @param venta
     * @return
     */
    @PutMapping("/updateVenta/{id}")
    public ResponseEntity<?> updateVenta(@PathVariable("id") long id, @RequestBody Venta venta){
        if(!ventaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Venta ",HttpStatus.NOT_FOUND);
        }
        ventaService.updateVenta(id, venta);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que se encarga de la venta de un producto
     * @param name
     * @param cantidad
     * @return
     */
    @GetMapping(value="/venta", params={"name","cantidad"})
    public ModelAndView venta(@RequestParam String name, @RequestParam int cantidad){
        ModelAndView mav = new ModelAndView();
        try{
            if(productoService.existsByNombre(name)){
                mav.setViewName("venta");
                Producto producto = productoService.getProductoByNombre(name).get();
                if(!producto.isDisponible()){
                    producto.setEstado('N');
                    mav.setViewName("sinStock");
                }
                else if(producto.getCantidad() < cantidad){
                    mav.setViewName("sinStock");
                }
                else{
                    producto.compra(cantidad);
                    estadisticaService.nuevaEstadistica(name, cantidad);
                }
                productoService.updateProducto(producto.getId(), producto);
                mav.addObject("producto", producto);
                mav.addObject("cantidad", cantidad);
            }
        } catch (Exception e) {
            System.out.println(e);
            mav.setViewName("error");
        } 
        return mav;
    }
}
