package edu.eci.arsw.dinoni.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig{

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .mvcMatchers("/tienda/productsManagement").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/comentariosManagement").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/npsManagement").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/nuevoProducto").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/editarProducto").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/editarComentario").hasAuthority("ADMIN")
            .mvcMatchers("/tienda/editarNps").hasAuthority("ADMIN")
            .antMatchers("/").hasAuthority("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("admin")
                .password("{noop}admin")
                .authorities("ADMIN")
                .build());
        return userDetailsManager;
    }
}
