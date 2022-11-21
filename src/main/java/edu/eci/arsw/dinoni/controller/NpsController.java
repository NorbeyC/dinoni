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

    @GetMapping("/allNps")
    public ResponseEntity<List<Nps>> getAllNps(){
        return new ResponseEntity<List<Nps>>(npsService.getAllNps(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/nps/id/{id}")
    public ResponseEntity<?> getNpsById(@PathVariable("id") long id){
        if(!npsService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Nps ",HttpStatus.NOT_FOUND);
        }
        Nps nps = npsService.getNpsById(id).get();
        return new ResponseEntity<>(nps, HttpStatus.ACCEPTED);
    }

    @PostMapping("/guardarNps")
    public ResponseEntity<?> guardarNps(@RequestBody Nps nps){
        try {
            npsService.saveNps(nps);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear el nps " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteNps/{id}")
    public ResponseEntity<?> deleteNps(@PathVariable("id") long id){
        if(!npsService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Nps ",HttpStatus.NOT_FOUND);
        }
        npsService.deleteNps(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateNps/{id}")
    public ResponseEntity<?> updateNps(@PathVariable("id") long id, @RequestBody Nps nps){
        if(!npsService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Nps ",HttpStatus.NOT_FOUND);
        }
        npsService.updateNps(id, nps);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }
    
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

    @PostMapping("/saveNps")
    public String saveNps(@ModelAttribute("nps") Nps nps){
        npsService.saveNps(nps);
        return "redirect:/tienda/viewProductos";
    }

    @PostMapping("/actualizarNps/{id}")
    public String actualizarNps(@PathVariable("id") long id, @ModelAttribute("nps") Nps nps){
        if(!npsService.existsById(id)){
            npsService.saveNps(nps);
        }
        npsService.updateNps(id, nps);
        return "redirect:/tienda/npsManagement";
    }

    @GetMapping("editarNps/{id}")
    public ModelAndView editarNps(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        Nps nps = npsService.getNpsById(id).get();
        mav.setViewName("editarNps");
        mav.addObject("nps", nps);
        return mav;
    }

    @GetMapping("eliminarNps/{id}")
    public String eliminarNps(@PathVariable("id") long id){
        if(npsService.existsById(id)){
            npsService.deleteNps(id);
        }
        return "redirect:/tienda/npsManagement";
    }

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

