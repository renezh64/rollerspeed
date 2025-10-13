package com.rollerspeed.rollerspeed.config;

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
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.rollerspeed.rollerspeed.model.Usuario;
import com.rollerspeed.rollerspeed.repository.UsuarioRepository;

@Configuration
@EnableJdbcHttpSession
@SessionAttributes({"usuario"})
public class SecurityConfig {
    @Autowired
    private UsuarioRepository usuarioRepository;
     
    // Configuración del PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración del usuario por defecto en memoria
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
       /* UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("1234")) // contraseña encriptada
                .roles("ADMIN")
                .build(); 
        return new InMemoryUserDetailsManager(user);
       */ 
       return username -> {
            // Buscar el usuario en la base de datos
            Usuario usuario = usuarioRepository.findByNombUsuario(username);
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }
            // Devolver un UserDetails con el nombre de usuario, contraseña encriptada y roles
            return org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getStrNomUsuario())
                    .password(usuario.getStrClaveAcc())
                    .roles(usuario.getStrNivelAcc())
                    .build();
        };
    }

    // Configuración de seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/css/**", "/js/**", "/images/**", "/login", "/" , "/swagger-ui/**", "/v3/api-docs/**"// recursos públicos
                ).permitAll()
                .requestMatchers("/usuario/registrar").permitAll() // Permitir registro
                .requestMatchers("/usuario/**").authenticated() // Proteger rutas de usuario    
                .anyRequest().authenticated()  // cualquier otra ruta requiere login
            )
            .formLogin(form -> form
                .loginPage("/login")          // tu página de login
                .defaultSuccessUrl("/", true) // redirige al inicio después de login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")         // URL para cerrar sesión
                .logoutSuccessUrl("/login?logout") // redirige al login con mensaje
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.IF_REQUIRED)
            );

        return http.build();
    }
}
