package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id, @RequestHeader(value="Autorization") String token) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Gerardo");
        usuario.setApellido("Torres");
        usuario.setEmail("Torresgerardo091@gmail.com");
        usuario.setPassword("12345");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value="Autorization") String token) {

        if (!validarToken(token)){
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Gerardo");
        usuario.setApellido("Torres");
        usuario.setEmail("Torresgerardo091@gmail.com");
        usuario.setPassword("12345");
        return usuario;
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id, @RequestHeader(value="Autorization") String token) {
        if (!validarToken(token)){
            return;
        }

        usuarioDao.eliminar(id);
    }

    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Gerardo");
        usuario.setApellido("Torres");
        usuario.setEmail("Torresgerardo091@gmail.com");
        usuario.setPassword("12345");
        return usuario;
    }
}
