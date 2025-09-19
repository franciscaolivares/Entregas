package com.franciscaolivares.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.franciscaolivares.modelos.Cancion;
import com.franciscaolivares.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;




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
    
    @GetMapping("/canciones/formulario/agregar")
public String formularioAgregarCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion) {
    return "agregarCancion";
}
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion (@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                        BindingResult validaciones){
    if (validaciones.hasErrors()){
        return "agregarCancion";
    }
    this.servicioCanciones.agregarCancion(nuevaCancion);
    return "redirect:/canciones";
                                        }
}
