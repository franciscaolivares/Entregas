package com.franciscaolivares.repositorios;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.franciscaolivares.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    /*SELECT */
    /*FROM CANCIONES */
    List<Cancion> findAll();

    /*INSERT INTO canciones (titulo, artista, album, genero, idioma, fecha_creacion, fecha_actualizacion)
     * VALUES()
     */
    /*Cancion save(Cancion cancion);*/

    
}
