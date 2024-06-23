package pe.edu.cibertec.T2SWJeanYaya.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2SWJeanYaya.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2SWJeanYaya.model.bd.Personaje;
import pe.edu.cibertec.T2SWJeanYaya.service.IPersonajeService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("personaje")
public class PersonajeController {
    private IPersonajeService personajeService;
    @GetMapping("")
    public ResponseEntity<List<Personaje>> listarPersonajes(){
        List<Personaje> categoryList = new ArrayList<>(personajeService.listarPersonajes());
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaje> obtenerCategoriaXId(@PathVariable Integer id){
        Personaje category = personajeService.
                obtenerPersonajexId(id).orElseThrow( ()
                        -> new ResourceNotFoundException("El personaje con Id: " +
                        id + "no existe"));
        return  new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Personaje> registrarPersonaje(
            @RequestBody Personaje personaje){
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(personaje),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(@PathVariable Integer id,
                                                        @RequestBody Personaje personaje){
        Personaje newPersonaje = personajeService.obtenerPersonajexId(id).orElseThrow(
                ()-> new ResourceNotFoundException("EL personaje con ID " + id + " no existe")
        );
        newPersonaje.setApepersonaje(personaje.getApepersonaje());
        newPersonaje.setFechanacpersonaje(personaje.getFechanacpersonaje());
        newPersonaje.setNompersonaje(personaje.getNompersonaje());
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(newPersonaje),HttpStatus.OK
        );

    }

}
