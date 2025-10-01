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

@Configuration
public class SecurityConfig {

    // Configuración del PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración del usuario por defecto en memoria
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("1234")) // contraseña encriptada
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    // Configuración de seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/css/**", "/js/**", "/images/**", "/login", "/" // recursos públicos
                ).permitAll()
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
                .permitAll()
            );

        return http.build();
    }
}
