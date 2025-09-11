package com.franciscaolivares.peliculas_y_directores.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/")

public class ControladorPeliculas {

    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
        public ControladorPeliculas() {
	listaPeliculas.put("Winnie the Pooh", "Don Hall");	
	listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
	listaPeliculas.put("Tarzán", "Kevin Lima");		
	listaPeliculas.put("Mulán", "Barry Cook");
	listaPeliculas.put("Oliver", "Kevin Lima");	
	listaPeliculas.put("Big Hero 6", "Don Hall");	
    }

    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas(Model model) {
        model.addAttribute("peliculas", listaPeliculas);
        return "peliculas"; 
    }
    
    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre, Model model) {
        for (String pelicula : listaPeliculas.keySet()) {
            if (pelicula.replace(" ", "").equals(nombre.replace(" ", ""))) {
                model.addAttribute("nombre", pelicula);
                model.addAttribute("director", listaPeliculas.get(pelicula));
                return "pelicula-por-nombre";
            }
        }
        model.addAttribute("nombre", nombre);
        model.addAttribute("director", null);
        return "pelicula-por-nombre";
    }

    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre, Model model) {
        ArrayList<String> peliculasDelDirector = new ArrayList<>();
        for (String pelicula : listaPeliculas.keySet()) {
            if (listaPeliculas.get(pelicula).replace(" ", "").equals(nombre.replace(" ", ""))) {
                peliculasDelDirector.add(pelicula);
            }
        }
        if (peliculasDelDirector.isEmpty()) {
            model.addAttribute("mensaje", "No contamos con peliculas con ese director en nuestra lista");
            return "error";
        } else {
            model.addAttribute("director", nombre);
            model.addAttribute("peliculas", peliculasDelDirector);
        }
        return "pelicula-por-director";
    }
    
}
