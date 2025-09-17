package com.franciscaolivares.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.franciscaolivares.modelos.Cancion;
import com.franciscaolivares.servicios.ServicioCanciones;

import java.util.List;


@Controller
public class ControladorCanciones {
    @Autowired
    private ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones) {
        this.servicioCanciones = servicioCanciones;
    }
    
    @GetMapping("/canciones")
    public String canciones(Model model) {
        List<Cancion> canciones = this.servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "canciones";
    }
    
    @GetMapping("/canciones/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable Long id, Model model){
        Cancion cancion= this.servicioCanciones.obtenerCancionPorId(id);

        if (cancion == null){
            return "forward:/canciones/error";
        }
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    
    }

    @GetMapping("/canciones/error")
    public String cancionNoEncontrada(){
        return "<h1> La cancion no se encuentra en nuestra lista ";
    }
    
}
