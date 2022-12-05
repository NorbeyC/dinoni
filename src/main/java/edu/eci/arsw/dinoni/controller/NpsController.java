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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.dinoni.service.NpsService;
import edu.eci.arsw.dinoni.service.UsuarioService;
import edu.eci.arsw.dinoni.model.Nps;
import edu.eci.arsw.dinoni.model.Usuario;

@Controller
@RequestMapping("/tienda")
public class NpsController {
    
    @Autowired
    NpsService npsService;

    @Autowired
    UsuarioService usuarioService;


    /**
     * Metodo que retorna todos los NPS
     * @return
     */
    @GetMapping("/allNps")
    public ResponseEntity<List<Nps>> getAllNps(){
        return new ResponseEntity<List<Nps>>(npsService.getAllNps(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que retorna el NPS por el ID
     * @param id
     * @return
     */
    @GetMapping("/nps/id/{id}")
    public ResponseEntity<?> getNpsById(@PathVariable("id") long id){
        if(!npsService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Nps ",HttpStatus.NOT_FOUND);
        }
        Nps nps = npsService.getNpsById(id).get();
        return new ResponseEntity<>(nps, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que guarda un nuevo NPS
     * @param nps
     * @return
     */
    @PostMapping("/guardarNps")
    public ResponseEntity<?> guardarNps(@RequestBody Nps nps){
        try {
            npsService.saveNps(nps);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear el nps " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que elimina un NPS
     * @param id
     * @return
     */
    @DeleteMapping("/deleteNps/{id}")
    public ResponseEntity<?> deleteNps(@PathVariable("id") long id){
        if(!npsService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Nps ",HttpStatus.NOT_FOUND);
        }
        npsService.deleteNps(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que actualiza un NPS
     * @param id
     * @param nps
     * @return
     */
    @PutMapping("/updateNps/{id}")
    public ResponseEntity<?> updateNps(@PathVariable("id") long id, @RequestBody Nps nps){
        if(!npsService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Nps ",HttpStatus.NOT_FOUND);
        }
        npsService.updateNps(id, nps);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }
    
    /**
     * Metodo que retorna el ModelAndView de un nuevo NPS
     * @param name
     * @return
     */
    @GetMapping(value = "nuevoNps", params = "name")
    public ModelAndView nuevoNps(@RequestParam("name") String name) {
        ModelAndView mav = new ModelAndView();
        Nps nps = new Nps();
        try {
            String producto = name;
            UserDetails UserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usuario = usuarioService.getUsuarioByNombre(UserDetails.getUsername()).get();
            mav.setViewName("nuevoNps");
            mav.addObject("nps", nps);
            mav.addObject("productoName",producto);
            mav.addObject("usuario",usuario);
        } catch (Exception e) {
            mav.setViewName("error");
        }
        
        return mav;
    }

    /**
     * Metodo que guarda un NPS estilo formulario
     * @param nps
     * @return
     */
    @PostMapping("/saveNps")
    public String saveNps(@ModelAttribute("nps") Nps nps){
        npsService.saveNps(nps);
        return "redirect:/tienda/viewProductos";
    }

    /**
     * Metodo que actualiza un NPS estlilo formulario
     * @param id
     * @param nps
     * @return
     */
    @PostMapping("/actualizarNps/{id}")
    public String actualizarNps(@PathVariable("id") long id, @ModelAttribute("nps") Nps nps){
        if(!npsService.existsById(id)){
            npsService.saveNps(nps);
        }
        npsService.updateNps(id, nps);
        return "redirect:/tienda/npsManagement";
    }

    /**
     * Metodo que retorna el ModelAndView de actualizar NPS
     * @param id
     * @return
     */
    @GetMapping("editarNps/{id}")
    public ModelAndView editarNps(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        Nps nps = npsService.getNpsById(id).get();
        mav.setViewName("editarNps");
        mav.addObject("nps", nps);
        return mav;
    }

    /**
     * Metodo que elimina un NPS desde el Management
     * @param id
     * @return
     */
    @GetMapping("eliminarNps/{id}")
    public String eliminarNps(@PathVariable("id") long id){
        if(npsService.existsById(id)){
            npsService.deleteNps(id);
        }
        return "redirect:/tienda/npsManagement";
    }

    /**
     * Metodo que retorna el ModelAndView del NpsManagement
     * @return
     */
    @GetMapping("/npsManagement")
    public ModelAndView npsManagement(){
        ModelAndView mav = new ModelAndView();
        try {
            List<Nps> nps = npsService.getAllNps();
            mav.setViewName("npsManagement");
            mav.addObject("nps", nps);
        } catch (Exception e) {
            mav.setViewName("error");
        }
        return mav;
    }
}

