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
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.dinoni.service.ResenaService;
import edu.eci.arsw.dinoni.model.Resena;


@Controller
@RequestMapping("/tienda")
public class ResenaController {

    @Autowired
    ResenaService resenaService;

    @GetMapping("/allResenas")
    public ResponseEntity<List<Resena>> getAllResenas(){
        return new ResponseEntity<List<Resena>>(resenaService.getAllResenas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/resenas/id/{id}")
    public ResponseEntity<?> getResenaById(@PathVariable("id") long id){
        if(!resenaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Reseña ",HttpStatus.NOT_FOUND);
        }
        Resena resena = resenaService.getResenaById(id).get();
        return new ResponseEntity<>(resena, HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveResena")
    public ResponseEntity<?> saveResena(@RequestBody Resena resena){
        try {
            resenaService.saveResena(resena);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear la reseña " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteResena/{id}")
    public ResponseEntity<?> deleteResena(@PathVariable("id") long id){
        if(!resenaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Reseña ",HttpStatus.NOT_FOUND);
        }
        resenaService.deleteResenaById(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateResena/{id}")
    public ResponseEntity<?> updateResena(@PathVariable("id") long id, @RequestBody Resena resena){
        if(!resenaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Reseña ",HttpStatus.NOT_FOUND);
        }
        resenaService.updateResena(id, resena);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }

    @GetMapping("nuevoComentario")
    public ModelAndView nuevoComentario(){
        ModelAndView mav = new ModelAndView();
        Resena resena = new Resena();
        mav.setViewName("nuevoComentario");
        mav.addObject("resena",resena);
        return mav;
    }
    
    @PostMapping("/saveComentario")
    public String saveComentario(@ModelAttribute("resena") Resena resena){
        resenaService.saveResena(resena);
        return "redirect:/tienda/viewProductos";
    }

    @PostMapping("/actualizarComentario/{id}")
    public String actualizarComentario(@PathVariable("id") long id, @ModelAttribute("resena") Resena resena){
        if(!resenaService.existsById(id)){
            resenaService.saveResena(resena);
        }
        resenaService.updateResena(id, resena);
        return "redirect:/tienda/comentariosManagement";
    }

    @GetMapping("/editarComentario/{id}")
    public ModelAndView editarComentario(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView();
        Resena resena = resenaService.getResenaById(id).get();
        mav.setViewName("editarComentario");
        mav.addObject("resena",resena);
        return mav;
    }

    @GetMapping("/eliminarComentario/{id}")
    public String eliminarComentario(@PathVariable("id") long id){
        if(resenaService.existsById(id)){
            resenaService.deleteResenaById(id);
        }
        return "redirect:/tienda/comentariosManagement";
    }
    
    @GetMapping("/comentariosManagement")
    public ModelAndView comentariosManagement(){
        ModelAndView mav = new ModelAndView();
        try {
            List<Resena> resenas = resenaService.getAllResenas();
            mav.setViewName("comentariosManagement");
            mav.addObject("resenas",resenas);
        } catch (Exception e) {
            mav.setViewName("error");
        }
        
        return mav;
    }
    
}
