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

import edu.eci.arsw.dinoni.service.EstadisticaService;
import edu.eci.arsw.dinoni.model.Estadistica;

@Controller
@RequestMapping("/tienda")
public class EstadisticaController {
    
    @Autowired
    EstadisticaService estadisticaService;

    @GetMapping("/allEstadisticas")
    public ResponseEntity<List<Estadistica>> getAllEstadisticas(){
        return new ResponseEntity<List<Estadistica>>(estadisticaService.getAllEstadisticas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/estadisticas/id/{id}")
    public ResponseEntity<?> getEstadisticaById(@PathVariable("id") long id){
        if(!estadisticaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Estadistica ",HttpStatus.NOT_FOUND);
        }
        Estadistica estadistica = estadisticaService.getEstadisticaById(id).get();
        return new ResponseEntity<>(estadistica, HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveEstadistica")
    public ResponseEntity<?> saveEstadistica(@RequestBody Estadistica estadistica){
        try {
            estadisticaService.saveEstadistica(estadistica);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear la estadistica " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEstadistica/{id}")
    public ResponseEntity<?> deleteEstadistica(@PathVariable("id") long id){
        if(!estadisticaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Estadistica ",HttpStatus.NOT_FOUND);
        }
        estadisticaService.deleteEstadistica(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateEstadistica/{id}")
    public ResponseEntity<?> updateEstadistica(@PathVariable("id") long id, @RequestBody Estadistica estadistica){
        if(!estadisticaService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id de la Estadistica ",HttpStatus.NOT_FOUND);
        }
        estadisticaService.updateEstadistica(id, estadistica);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }
    
}
