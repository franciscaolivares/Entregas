package com.franciscaolivares.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.franciscaolivares.modelos.Cancion;
import com.franciscaolivares.servicios.ServicioArtistas;
import com.franciscaolivares.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.franciscaolivares.modelos.Artista;



@Controller
public class ControladorCanciones {

    @Autowired
    private final ServicioCanciones servicioCanciones;
    //Para el artista
    @Autowired
    private final ServicioArtistas servicioArtistas;

    //Constructor

    public ControladorCanciones(ServicioCanciones servicioCanciones,
                                ServicioArtistas servicioArtistas) {
        this.servicioCanciones = servicioCanciones;
        // Para el artista
        this.servicioArtistas = servicioArtistas;
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
    
    @GetMapping("/canciones/formulario/agregar") // agrega el objeto de modelo(en proceso para los artistas)
public String formularioAgregarCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion, Model modelo) {
    // Obtener la lista de artistas desde el servicio
    List<Artista> artistas = this.servicioArtistas.obtenerTodosLosArtistas();
    // Agregar la lista de artistas al modelo
    modelo.addAttribute("artistas", artistas);
    return "agregarCancion";
}
    @PostMapping("/canciones/procesa/agregar") //Para el artista agregar request param idArtista (nimbre del select en agregarCancion.jsp)
    public String procesarAgregarCancion (@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                        BindingResult validaciones, 
                                        @RequestParam Long idArtista){
    if (validaciones.hasErrors()){
        return "agregarCancion";
    }
    // extraer el artista seleccionado usando el idArtista,(seleccionado en el formulario)
    Artista artista =this.servicioArtistas.obtenerArtistaPorId(idArtista);
    // asignar el artista a la nueva canción
    nuevaCancion.setArtista(artista);

    this.servicioCanciones.agregarCancion(nuevaCancion); 
    return "redirect:/canciones";
                                        }

    @DeleteMapping ("/canciones/eliminar/{id}")
    public String procesarEliminarCancion(@PathVariable("id") Long idCancion){
        this.servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/editar/{id}")
    public String formularioEditarCancion (@PathVariable ("id") Long idCancion,
                                            Model modelo ){
        Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);

        return "editarCancion";
    }
    
    @PutMapping("/canciones/processa/editar/{id}")
    public String procesaEditarCancion (@Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult validaciones,
                                        @PathVariable ("id") Long idCancion){
        if (validaciones.hasErrors()){
            return "editarCancion";
                                        }  
        cancion.setId(idCancion); 
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";                                    
                                        }
    
}
