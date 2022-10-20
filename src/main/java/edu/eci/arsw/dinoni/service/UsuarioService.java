package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Usuario;
import edu.eci.arsw.dinoni.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Metodo que retorna todos los usuarios
     * @return
     */

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    /**
     * Metodo que retorna un usuario por su id
     * @param id
     * @return
     */

    public Optional<Usuario> getUsuarioById(long id){
        return usuarioRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe un usuario por su id
     * @param id
     * @return
     */

    public boolean existsById(long id){
        return usuarioRepository.existsById(id);
    }

    /**
     * Metodo que retorna un usuario por su nombre
     * @param nombre
     * @return
     */

    public Optional<Usuario> getUsuarioByNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    /**
     * Metodo que retorna si existe un usuario por su nombre
     * @param nombre
     * @return
     */

    public boolean existsByNombre(String nombre){
        return usuarioRepository.existsByNombre(nombre);
    }

    /**
     * Metodo que retorna un usuario por su correo
     * @param correo
     * @return
     */

    public Optional<Usuario> getUsuarioByCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }

    /**
     * Metodo que retorna si existe un usuario por su correo
     * @param correo
     * @return
     */

    public boolean existsByCorreo(String correo){
        return usuarioRepository.existsByCorreo(correo);
    }

    /**
     * Metodo que retorna un usuario por su identificacion
     * @param identificacion
     * @return
     */
    public Optional<Usuario> getUsuarioByIdentificacion(String identificacion){
        return usuarioRepository.findByIdentificacion(identificacion);
    }

    /**
     * Metodo que retorna si existe un usuario por su identificacion
     * @param identificacion
     * @return
     */

    public boolean existsByIdentificacion(String identificacion){
        return usuarioRepository.existsByIdentificacion(identificacion);
    }

    /**
     * Metodo que guarda un usuario
     * @param usuario
     */
    public void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    /**
     * Metodo que elimina un usuario por su id
     * @param id
     */

    public void deleteUsuarioById(long id){
        usuarioRepository.deleteById(id);
    }

    /**
     * Metodo que elimina todos los usuarios
     */

    public void deleteAllUsuarios(){
        usuarioRepository.deleteAll();
    }

    /**
     * Metodo que actualiza un usuario
     * @param id identificador del usuario a actualizar
     * @param usuario
     */

    public void updateUsuario(long id, Usuario usuario){
        Usuario temp = usuarioRepository.findById(id).get();
        temp.setNombre(usuario.getNombre());
        temp.setTipoIdentificacion(usuario.getTipoIdentificacion());
        temp.setIdentificacion(usuario.getIdentificacion());
        temp.setCorreo(usuario.getCorreo());
        temp.setPasswd(usuario.getPasswd());
        temp.setTelefono(usuario.getTelefono());
        usuarioRepository.save(temp);
    }
    
}
