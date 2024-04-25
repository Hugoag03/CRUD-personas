package com.pruebaCurso.primeraPruebaSpringBoot.controller; // Paquete donde se encuentra la clase

import com.pruebaCurso.primeraPruebaSpringBoot.entities.Persona; // Importación de la clase Persona
import com.pruebaCurso.primeraPruebaSpringBoot.service.PersonaService; // Importación de la clase PersonaService
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired
import org.springframework.stereotype.Controller; // Importación de la anotación Controller
import org.springframework.ui.Model; // Importación de la clase Model
import org.springframework.web.bind.annotation.*; // Importación de las anotaciones para manejo de solicitudes web

import java.util.List; // Importación de la clase List

@Controller // Anotación que marca la clase como un controlador de Spring MVC
@RequestMapping(value = {"/personas", "/"}) // Anotación que mapea las URL que serán manejadas por este controlador
public class PersonaController {

    @Autowired // Anotación para la inyección de dependencias
    private PersonaService personaService; // Inyección del servicio PersonaService

    @GetMapping // Maneja las solicitudes GET a la raíz ("/personas" y "/")
    public String mostrarTodas(Model model) { // Método para mostrar todas las personas
        List<Persona> personas = personaService.obtenerTodas(); // Obtiene todas las personas del servicio PersonaService
        model.addAttribute("listaPersonas", personas); // Agrega la lista de personas al modelo
        return "listar"; // Devuelve el nombre de la vista a mostrar
    }

    @GetMapping("/nueva") // Maneja las solicitudes GET a "/personas/nueva"
    public String mostrarFormularioNuevaPersona(Model model) { // Método para mostrar el formulario de nueva persona
        model.addAttribute("persona", new Persona()); // Agrega un nuevo objeto Persona al modelo
        model.addAttribute("accion", "/personas/nueva"); // Agrega la acción del formulario al modelo
        return "formulario"; // Devuelve el nombre de la vista a mostrar
    }

    @PostMapping("/nueva") // Maneja las solicitudes POST a "/personas/nueva"
    public String guardarNuevaPersona(@ModelAttribute Persona persona) { // Método para guardar una nueva persona
        personaService.crearPersona(persona); // Guarda la nueva persona usando el servicio PersonaService
        return "redirect:/personas"; // Redirige a la página principal de personas después de guardar
    }

    @GetMapping("/editar/{id}") // Maneja las solicitudes GET a "/personas/editar/{id}"
    public String mostrarFormularioEditarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model model) { // Método para mostrar el formulario de edición de persona
        model.addAttribute("persona", persona); // Agrega la persona al modelo
        model.addAttribute("accion", "/personas/editar/" + id); // Agrega la acción del formulario al modelo
        return "formulario"; // Devuelve el nombre de la vista a mostrar
    }

    @PostMapping("/editar/{id}") // Maneja las solicitudes POST a "/personas/editar/{id}"
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona) { // Método para actualizar una persona
        personaService.modificarPersona(id, persona); // Actualiza la persona usando el servicio PersonaService
        return "redirect:/personas"; // Redirige a la página principal de personas después de actualizar
    }

    @GetMapping("/eliminar/{id}") // Maneja las solicitudes GET a "/personas/eliminar/{id}"
    public String eliminarPersona(@PathVariable Long id) { // Método para eliminar una persona
        personaService.eliminarPersona(id); // Elimina la persona usando el servicio PersonaService
        return "redirect:/personas"; // Redirige a la página principal de personas después de eliminar
    }
}
