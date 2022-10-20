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

import edu.eci.arsw.dinoni.service.NpsService;
import edu.eci.arsw.dinoni.model.Nps;

@Controller
@RequestMapping("/tienda")
public class NpsController {
    
    @Autowired
    NpsService npsService;

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

    @PostMapping("/saveNps")
    public ResponseEntity<?> saveNps(@RequestBody Nps nps){
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
    

}

