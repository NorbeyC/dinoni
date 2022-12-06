package edu.eci.arsw.dinoni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

import edu.eci.arsw.dinoni.model.Compra;
import edu.eci.arsw.dinoni.model.Producto;
import edu.eci.arsw.dinoni.model.Usuario;
import edu.eci.arsw.dinoni.service.CompraService;
import edu.eci.arsw.dinoni.service.ProductoService;
import edu.eci.arsw.dinoni.service.UsuarioService;

@Controller
@RequestMapping("/tienda")
public class CompraController {

    @Autowired
    ProductoService productoService;
    
    @Autowired
    CompraService compraService;

    @Autowired
    UsuarioService usuarioService;


    /**
     * Metodo que retorna todas las compras en formato JSON
     * @return
     */
    @GetMapping("/allCompras")
    public ResponseEntity<List<Compra>> getAllCompras(){
        return new ResponseEntity<List<Compra>>(compraService.getAllCompras(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que devuelve el ModelAndView de compras
     * @param name
     * @return
     */
    @GetMapping(value="/compras", params={"name","cantidad"})
    public ModelAndView compras(@RequestParam String name, @RequestParam int cantidad){
        ModelAndView mav = new ModelAndView();
        try {
            UserDetails UserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(UserDetails.getUsername() + " " + UserDetails.getPassword());
            Usuario usuario = usuarioService.getUsuarioByNombre(UserDetails.getUsername()).get();
            Producto producto = productoService.getProductoByNombre(name).get();
            if(producto.isDisponible()){
                mav.setViewName("compras");
                mav.addObject("producto", producto);
                mav.addObject("usuario", usuario);
                mav.addObject("cantidad", cantidad);
            }
            else{
                mav.setViewName("sinStock");
            }
        } catch (Exception e) {
            System.out.println(e);
            mav.setViewName("error");
        } 
        return mav;
    }

    /**
     * Metodo que guarda una compra
     * @param compra
     * @return
     */
    @PostMapping("/saveCompra")
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
        try {
            compraService.saveCompra(compra);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear la compra " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que elimina una compra
     * @param id
     * @return
     */
    @DeleteMapping("/deleteCompra/{id}")
    public ResponseEntity<?> deleteCompra(@PathVariable("id") long id){
        if(!compraService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Compra ",HttpStatus.NOT_FOUND);
        }
        compraService.deleteCompra(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que actualiza una compra
     * @param id
     * @param compra
     * @return
     */
    @PutMapping("/updateCompra/{id}")
    public ResponseEntity<?> updateCompra(@PathVariable("id") long id, @RequestBody Compra compra){
        if(!compraService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Compra ",HttpStatus.NOT_FOUND);
        }
        compraService.updateCompra(id, compra);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }
    
}
