package com.rollerspeed.rollerspeed.config;

import com.rollerspeed.rollerspeed.repository.UsuarioRepository;
import com.rollerspeed.rollerspeed.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Rene Zapata Hernadez
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/css/**","/login","/logout").permitAll()
            .anyRequest().authenticated()
            )
            .formLogin(form -> form
              .loginPage("/login")
              .defaultSuccessUrl("/", true)
              .permitAll()
            )
            .logout(logout -> logout
               .logoutUrl("/logout")
               .logoutSuccessUrl("/login?logout")
               .permitAll()            
           );
        return http.build();
    
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Usuario usuario = usuarioRepository.findByNombUsuario(username);
            if (usuario == null) {
                throw new RuntimeException("Usuario no encontrado");
            }
            return User
                .withUsername(usuario.getstrNomUsuario())
                .password(usuario.getStrClaveAcc())
                .roles(usuario.getStrNivelAcc())
                .disabled(!usuario.getStrActivo().equals("Sí"))
                .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
