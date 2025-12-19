package com.itsqmet.service;

import com.itsqmet.entity.Usuario;
import com.itsqmet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    // Inyeccion de dependencias
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Leer
    public List<Usuario> mostrarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar por id
    public Optional<Usuario> buscarUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Buscar por nombre O cédula (EXACTO como LibroService)
    public List<Usuario> buscarUsuarioPorNombreOCedula(String buscar) {
        if (buscar == null || buscar.isEmpty()) {
            return usuarioRepository.findAll();
        } else {
            // Buscar en nombre Y cédula usando los métodos del Repository
            List<Usuario> porNombre = usuarioRepository.findByNombreContainingIgnoreCase(buscar);
            List<Usuario> porCedula = usuarioRepository.findByCedulaContaining(buscar);

            // Combinar resultados sin duplicados
            List<Usuario> resultados = new ArrayList<>(porNombre);

            for (Usuario usuario : porCedula) {
                if (!resultados.contains(usuario)) {
                    resultados.add(usuario);
                }
            }

            return resultados;
        }
    }

    // Guardar usuario
    public Usuario guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    // Actualizar usuario
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = buscarUsuarioById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setCedula(usuario.getCedula());
        usuarioExistente.setDireccion(usuario.getDireccion());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setEdad(usuario.getEdad());

        return usuarioRepository.save(usuarioExistente);
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        Usuario usuario = buscarUsuarioById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuario no existe"));
        usuarioRepository.delete(usuario);
    }
}