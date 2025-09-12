package com.franciscaolivares.exploraador_de_recetas.controladores;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller

public class ControladorRecetas {

	private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
	private static HashMap<String, String[]> recetasConIngredientes = new HashMap<String, String[]>();

	static {
		String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
		recetasConIngredientes.put("Pizza", pizza);
		String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
		recetasConIngredientes.put("Espagueti", espagueti);
		String[] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
		recetasConIngredientes.put("Lasaña", lasaña);
	}

	@GetMapping("/recetas")
	public String obtenerTodasLasRecetas(Model model) {
		model.addAttribute("listaRecetas", listaRecetas);
		return "recetas";
	}
	@GetMapping("/recetas/{nombre}")
	public String obtenerRecetaPorNombre(Model model, @PathVariable String nombre) {
		String[] ingredientes = recetasConIngredientes.get(nombre);
		if (ingredientes != null) {
			model.addAttribute("nombreReceta", nombre);
			model.addAttribute("ingredientes", ingredientes);
			return "detalleReceta";
		} else {
			return "forward:/recetas/error"; 
		}
	}
	@GetMapping("/recetas/error")
	@ResponseBody
	public String recetaNoEncontrada() {
		return "<h1>La receta no se encuentra en nuestra lista</h1>";
	}
}
