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

import edu.eci.arsw.dinoni.service.UsuarioService;
import edu.eci.arsw.dinoni.model.Usuario;

@Controller
@RequestMapping("/tienda")
public class UsuarioController {

 

    @Autowired
    UsuarioService usuarioService;
    
    /**
     * Metodo que retorna todos los usarios en formato JSON
     * @return
     */
    @GetMapping("/allUsuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return new ResponseEntity<List<Usuario>>(usuarioService.getAllUsuarios(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que retorna un usuario por su ID
     * @param id
     * @return
     */
    @GetMapping("/usuarios/id/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") long id){
        if(!usuarioService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Usuario ",HttpStatus.NOT_FOUND);
        }
        Usuario usuario = usuarioService.getUsuarioById(id).get();
        return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que agrega un nuevo usuario
     * @param usuario
     * @return
     */
    @PostMapping("/newUsuario")
    public ResponseEntity<?> newUsuario(@RequestBody Usuario usuario){
        try {
            usuarioService.saveUsuario(usuario);
            return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear el usuario " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que elimina un usuario
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") long id){
        if(!usuarioService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Usuario ",HttpStatus.NOT_FOUND);
        }
        usuarioService.deleteUsuarioById(id);
        return new ResponseEntity<>("Se ha eliminado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que actualiza un usuario
     * @param id
     * @param usuario
     * @return
     */
    @PutMapping("/updateUsuario/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario){
        if(!usuarioService.existsById(id)){
            return new ResponseEntity<>("No se ha encontrado el Id del Usuario ",HttpStatus.NOT_FOUND);
        }
        usuarioService.updateUsuario(id, usuario);
        return new ResponseEntity<>("Se ha actualizado correctamente ",HttpStatus.ACCEPTED);
    }

    /**
     * Metodo que retorna el ModelAndView del formulario de nuevo usuario
     * @return
     */
    @GetMapping("nuevoUsuario")
    public ModelAndView nuevoUsuario(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("nuevoUsuario");
        Usuario usuario = new Usuario();
        mav.addObject("usuario", usuario);
        return mav;
    }

    /**
     * Metodo que guarda un nuevo Usuario
     * @param usuario
     * @return
     * @throws Exception
     */
    @PostMapping("/saveUsuario")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) throws Exception{
        try {
            if(!usuarioService.existsByNombre(usuario.getNombre())){
                usuarioService.saveUsuario(usuario);
            }
        } catch (Exception e) {
            return "redirect:/tienda/nuevoUsuario";
        }
        usuarioService.saveUsuario(usuario);
        return "redirect:/";
    }
    
}
