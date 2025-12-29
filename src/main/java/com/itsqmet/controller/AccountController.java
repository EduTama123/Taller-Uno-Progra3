package com.itsqmet.controller;

import com.itsqmet.entity.Account;
import com.itsqmet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cuentas")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //leer
    @GetMapping
    public String listaCuentas(Model model){
        List<Account> accounts = accountService.mostrarCuentas();
        model.addAttribute("accounts", accounts);
        return "pages/listaCuentas";
    }

    //guardar
    //llamar al formulario
    @GetMapping("/formCuenta")
    public String crearCuenta(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "pages/userRegister";
    }

    //enviar datos ala base
    @PostMapping("/registrarCuenta")
    public String guardarUsuario(Account account){
        if (account.getId() != null){
            accountService.actualizarUsuario(account.getId(), account);
        }else{
            accountService.guardarUsuario(account);
        }
        //os devuelve a la lista libros
        return "redirect:/cuentas";
    }
    //actualizar
    @GetMapping("/editarCuenta/{id}")
    public String actualizarCuenta(@PathVariable Long id, Model model){
        Optional<Account> account = accountService.buscarUserById(id);
        model.addAttribute("account", account);
        return "pages/userForm";
    }

    //eliminar
    @DeleteMapping("/eliminarCuenta/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        accountService.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
}
