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
                        .requestMatchers("/", "/inicio", "/login", "/cuentas/formCuenta",
                                "/cuentas/registrarCuenta", "/login/postLogin").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                        // NUEVAS RUTAS PARA PANELES
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/usuario").hasRole("USUARIO")
                        .requestMatchers("/especialista").hasRole("ESPECIALISTA")

                        // ASIGNAR PRIVILEGIOS POR ROLES
                        .requestMatchers("/cuentas/**", "/admin/**").hasRole("ADMIN")
                        .requestMatchers("/test/**").hasAnyRole("ADMIN", "USUARIO", "ESPECIALISTA")

                        // PERMISOS ESPECÍFICOS PARA /usuarios
                        .requestMatchers("/usuarios/formUsuario").hasAnyRole("ADMIN", "ESPECIALISTA", "USUARIO")
                        .requestMatchers("/usuarios/registrarUsuario").hasAnyRole("ADMIN", "ESPECIALISTA", "USUARIO")
                        .requestMatchers("/usuarios/editarUsuario/**").hasAnyRole("ADMIN", "ESPECIALISTA")
                        .requestMatchers("/usuarios/eliminarUsuario/**").hasRole("ADMIN")
                        .requestMatchers("/usuarios/**").hasAnyRole("ADMIN", "ESPECIALISTA")

                        // NUEVAS RUTAS PARA RECOMENDACIONES
                        .requestMatchers("/recomendaciones").hasAnyRole("ADMIN", "ESPECIALISTA", "USUARIO")
                        .requestMatchers("/recomendaciones/form").hasAnyRole("ADMIN", "ESPECIALISTA")
                        .requestMatchers("/recomendaciones/editar/**").hasAnyRole("ADMIN", "ESPECIALISTA")
                        .requestMatchers("/recomendaciones/guardar").hasAnyRole("ADMIN", "ESPECIALISTA")
                        .requestMatchers("/recomendaciones/eliminar/**").hasRole("ADMIN")

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
        return http.build();
    }
}