package com.franciscaolivares.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.franciscaolivares.modelos.Usuario;
import com.franciscaolivares.servicios.ServicioUsuarios;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControladorUsuarios {
    
    @Autowired
    private final ServicioUsuarios servicioUsuarios;

    public ControladorUsuarios(ServicioUsuarios servicioUsuarios){
        this.servicioUsuarios = servicioUsuarios;
        
    }

    @GetMapping("/")
    public String index (Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/procesa/registro")
    public String procesaRegistro(@Valid @ModelAttribute ("usuario") Usuario usuario,
                                BindingResult validaciones,
                                Model modelo){
        if (!usuario.getContrasenia().equals(usuario.getConfirmarContrasenia())){
            validaciones.rejectValue("confirmarContrasenia","error.usuario","Las contraseñas no coinciden");
        }
        if (validaciones.hasErrors()){
            return "index";
        }
        servicioUsuarios.registrarUsuario(usuario);
        return "redirect:/inicio";
    }   

    @PostMapping("/procesa/login")
    public String procesaLogin(@RequestParam("nombreUsuario") String nombreUsuario,
                            @RequestParam("contrasenia") String contrasenia,
                            Model modelo){
        Usuario usuario = servicioUsuarios.loginUsuario(nombreUsuario, contrasenia);
        if (usuario == null){
            modelo.addAttribute("error", "Nombre de usuario o contraseña inválidos");
            modelo.addAttribute("usuario", new Usuario());
            return "index";
        }
        return "redirect:/inicio";
    }

        @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }
}



