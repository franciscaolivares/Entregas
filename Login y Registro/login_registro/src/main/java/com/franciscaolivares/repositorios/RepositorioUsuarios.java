package com.franciscaolivares.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franciscaolivares.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {

    Usuario findByNombreUsuario (String nombreUsuario);
    
    Usuario save (Usuario nuevoUsuario);
    
}
