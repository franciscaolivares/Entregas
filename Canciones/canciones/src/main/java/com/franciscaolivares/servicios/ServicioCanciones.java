package com.franciscaolivares.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscaolivares.modelos.Cancion;
import com.franciscaolivares.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    @Autowired
    private RepositorioCanciones repositorioCanciones;

    public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
        this.repositorioCanciones = repositorioCanciones;

    }

    public List<Cancion> obtenerTodasLasCanciones() {
        return this.repositorioCanciones.findAll();
    
}
    public Cancion obtenerCancionPorId(long id){
        return this.repositorioCanciones.findById(id).orElse(null);

    }
}