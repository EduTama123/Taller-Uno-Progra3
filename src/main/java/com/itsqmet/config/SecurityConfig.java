package com.itsqmet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //encriptador para verifiar la contraseña
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //configuracion de la cadena de filtros o de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/inicio", "/login", "/cuentas/formCuenta", "/cuentas/registrarCuenta").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        //asignar privilegio por roles
                        .requestMatchers("/cuentas/**", "/admin/**").hasRole("ADMIN")
                        .requestMatchers("/test/**", "/usuarios").hasAnyRole("ADMIN", "USUARIO", "ESPECIALISTA")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/login/postLogin", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        //retornar la nueva configuracion
        return http.build();
    }
}
