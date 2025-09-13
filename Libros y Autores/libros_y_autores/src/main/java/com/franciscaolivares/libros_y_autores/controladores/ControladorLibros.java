package com.franciscaolivares.libros_y_autores.controladores;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller

public class ControladorLibros {
    
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    public ControladorLibros() {
	listaLibros.put("Odisea", "Homero");	
	listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
	listaLibros.put("El Código Da Vinci", "Dan Brown");		
	listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
	listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
	listaLibros.put("El alquimista", "Paulo Coelho");	
}
@GetMapping("/libros" )
public String obtenerTodosLosLibros (Model model) {
    model.addAttribute("libros", listaLibros);
    return "libros";
}
@GetMapping("/libros/{nombre}")
public String obtenerInformacionDeLibro(@PathVariable String nombre, Model model) {
    String infoLibros = listaLibros.get(nombre);
    if (infoLibros != null) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("autor", infoLibros);
        return "detalleLibro";
    } else {
        return "forward:/libros/error";
    }
}
@GetMapping("/libros/error")
@ResponseBody
public String libroNoEncontrado() {
    return "<h1>El libro no se encuentra en nuestra lista.</h1>";
    }


@GetMapping("/libros/formulario")
public String formularioLibro() {
    return "formularioLibros";
}
    
@PostMapping("/procesa/libro")
public String agregarLibro (@RequestParam String nombre,
                            @RequestParam String autor) {
    listaLibros.put(nombre, autor);
    return "redirect:/libros";
}

}