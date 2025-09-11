package com.franciscaolivares.peliculas_y_directores.controladores;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String mostrarPeliculas(Model model) {
        model.addAttribute("peliculas", listaPeliculas);
        return "peliculas.jsp"; 
    }
    
}
