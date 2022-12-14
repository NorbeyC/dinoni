package edu.eci.arsw.dinoni.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import edu.eci.arsw.dinoni.model.Usuario;
import edu.eci.arsw.dinoni.service.UsuarioService;


@Configuration
public class WebSecurityConfig{

    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
        "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };

    @Autowired
    UsuarioService usuarioService;
    
    /**
     * Implementa la seguridad, da acceso a las paginas de acuerdo al rol del usuario
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(resources).permitAll() //permitir el acceso a todos los recursos estaticos
            .mvcMatchers("/tienda/productsManagement").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/comentariosManagement").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/npsManagement").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/nuevoProducto").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/editarProducto").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/editarComentario").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/editarNps").hasAuthority("ADMIN")
            .antMatchers("/tienda/compras").hasAuthority("USER")
            .antMatchers("/tienda/nuevoComentario").hasAuthority("USER")
            .antMatchers("/tienda/nuevoNps").hasAuthority("USER")
            .antMatchers("/tienda/chat").hasAuthority("USER")
            .antMatchers("/tienda/venta").hasAuthority("USER")
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin();
        return http.build();
    }

    /**
     * Agrega los usuarios y les asigna el rol
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        users.add(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ADMIN")
                .build());
        for(Usuario u: usuarioService.getAllUsuarios()){
             users.add(User.withUsername(u.getNombre())
                .password(passwordEncoder().encode(u.getPasswd()))
                .authorities("USER")
                .build());
        }
        return new InMemoryUserDetailsManager(users);
    }

    /**
     * Encripta la contrase??a
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
