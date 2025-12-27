package com.itsqmet.service;

import com.itsqmet.entity.Account;
import com.itsqmet.repository.AccountRepository;
import com.itsqmet.roles.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    //leer
    public List<Account> mostrarCuentas() {
        //findAll: "select*from productos" son metodos de JPA
        return accountRepository.findAll();
    }

    //buscar por ID
    //optional: EVITA QUE SE FORME UN BUCLE
    public Optional<Account> buscarUserById(Long id) {
        return accountRepository.findById(id);
    }


    //guardar usuario
    public Account guardarUsuario(Account account) {
        //encriptar la contraseña antes de guardar
        String passwordEncriptada = passwordEncoder.encode(account.getPassword());
        account.setPassword(passwordEncriptada);
        account.setRol(Rol.ROLE_USUARIO);
        return accountRepository.save(account);

    }

    //ACTUALIZAR usuario
    public Account actualizarUsuario(Long id, Account account) {
        Account cuentaExistente = buscarUserById(id)
                //manejo de escepciones
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        cuentaExistente.setNombre(account.getNombre());
        cuentaExistente.setUsername(account.getUsername());

        //actuaizar el pasword solo si el usuariol la cambia
        if (account.getPassword()!= null && !account.getPassword().isBlank()){
            cuentaExistente.setPassword(passwordEncoder.encode(account.getPassword()));
        }
        //metodo del JPA
        return accountRepository.save(cuentaExistente);
    }

    //ELIMINAR PRODUCTO
    public void eliminarCuenta(Long id){
        Account account = buscarUserById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no existe"));
        accountRepository.delete(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //buscar el usuario quye coincida y si n lo encuentra lanza una excepcion
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no existe: " + username));
        //usar builder para construir unn objeto al que se conoce como objeto autenicado
        return org.springframework.security.core.userdetails.User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .authorities(account.getRol().name())
                .build();

    }



}
