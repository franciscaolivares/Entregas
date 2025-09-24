package com.franciscaolivares.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.franciscaolivares.modelos.Artista;
import com.franciscaolivares.servicios.ServicioArtistas;

import jakarta.validation.Valid;


@Controller
public class ControladorArtistas {
    
    @Autowired
    private final ServicioArtistas servicioArtistas;
//
public ControladorArtistas(ServicioArtistas servicioArtistas) {
        this.servicioArtistas = servicioArtistas;
    }

    @GetMapping("/artistas")
    public String artistas (Model model) {
        List<Artista> artistas = this.servicioArtistas.desplegarArtistas();
        model.addAttribute("artistas", artistas);
        return "artistas";
    }

    @GetMapping("/artistas/detalle/{id}")
    public String desplegarDetalleArtista(@PathVariable Long id, Model model){
        Artista artista= this.servicioArtistas.obtenerArtistaPorId(id);

        if (artista == null){
            return "forward:/artistas/error";
        }
        model.addAttribute("artista", artista);
        return "detalleArtista";
    
    }

    @GetMapping("/artistas/error")
    public String artistaNoEncontrado(){
        return "<h1> El artista no se encuentra en nuestra lista ";
    }


    @GetMapping("/artistas/formulario/agregar") 
public String formularioAgregarArtista(@ModelAttribute("nuevoArtista") Artista nuevoArtista) {
    List<Artista> artistas = this.servicioArtistas.obtenerTodosLosArtistas();
    
    return "agregarArtista";
}
    @PostMapping("/artistas/procesa/agregar") 
    public String procesarAgregarArtista (@Valid @ModelAttribute("nuevoArtista") Artista nuevoArtista,
                                        BindingResult validaciones){
    if (validaciones.hasErrors()){
        return "agregarArtista";
    }

    this.servicioArtistas.agregarArtista(nuevoArtista); 
    return "redirect:/artistas";
}

}
