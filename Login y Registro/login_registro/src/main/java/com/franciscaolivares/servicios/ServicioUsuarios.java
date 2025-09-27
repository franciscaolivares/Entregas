package com.franciscaolivares.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscaolivares.modelos.Usuario;
import com.franciscaolivares.repositorios.RepositorioUsuarios;


@Service
public class ServicioUsuarios {
    
    @Autowired
    private final RepositorioUsuarios repositorioUsuarios;

    public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios){
        this.repositorioUsuarios = repositorioUsuarios;
        
    }

    public Usuario registrarUsuario(Usuario usuario){
        String hashed = BCrypt.hashpw(usuario.getContrasenia(), BCrypt.gensalt());
        usuario.setContrasenia(hashed);
        return repositorioUsuarios.save (usuario);
        
    }

    public Usuario loginUsuario (String nombreUsuario, String contrasenia){
        Usuario usuario = repositorioUsuarios.findByNombreUsuario(nombreUsuario);
        if (usuario == null){
            return null;
        }
        if (BCrypt.checkpw(contrasenia, usuario.getContrasenia())){
            return usuario;
        } else {
            return null;
        }
    }
}