package com.distribuida.loginspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login", "/logout").permitAll()  // Permitir acceso a login/logout sin autenticación
                                .anyRequest().authenticated()                     // Requiere autenticación para cualquier otra URL
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")                            // Página de login personalizada
                                .permitAll()                                    // Permitir acceso a la página de login sin autenticación
                                .defaultSuccessUrl("/", true)                    // Redirigir al home si el login es exitoso
                                .failureUrl("/login?error=true")                 // Redirigir a la página de login en caso de fallo
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")                          // URL personalizada para logout (por defecto es /logout)
                                .logoutSuccessUrl("/login?logout=true")          // Redirigir a la página de login después de logout
                                .permitAll()                                    // Permitir logout sin autenticación
                )
                .csrf(csrf -> csrf.disable());                         // Deshabilitar CSRF (solo si es necesario)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("admin123"))
                        .roles("USER")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usamos BCrypt para encriptar las contraseñas
    }
}
