package pe.edu.cibertec.T2SWJeanYaya.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2SWJeanYaya.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2SWJeanYaya.model.bd.ProgramaTv;
import pe.edu.cibertec.T2SWJeanYaya.service.IPersonajeService;
import pe.edu.cibertec.T2SWJeanYaya.service.IProgramaTvService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("programatv")
public class ProgramaTvController {
    private IProgramaTvService programaTvService;
    @GetMapping("")
    public ResponseEntity<List<ProgramaTv>> listarProgramas(){
        List<ProgramaTv> programaList = new ArrayList<>(programaTvService.listarProgramas());
        if(programaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(programaList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProgramaTv> obtenerCategoriaXId(@PathVariable Integer id){
        ProgramaTv programa = programaTvService.
                obtenerProgramatvxId(id).orElseThrow( ()
                        -> new ResourceNotFoundException("El programa con Id: " +
                        id + "no existe"));
        return  new ResponseEntity<>(programa, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProgramaTv> registrarCategoria(
            @RequestBody ProgramaTv programa){
        return new ResponseEntity<>(
                programaTvService.guardarPrograma(programa),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaTv> actualizarPrograma(@PathVariable Integer id,
                                                        @RequestBody ProgramaTv programatv){
        ProgramaTv newPrograma = programaTvService.obtenerProgramatvxId(id).orElseThrow(
                ()-> new ResourceNotFoundException("La categoría con ID " + id + " no existe")
        );
        newPrograma.setFechainicio(new Date());
        newPrograma.setTitulo(programatv.getTitulo());
        newPrograma.setResumen(programatv.getResumen());
        newPrograma.setIdprogramatv(programatv.getIdprogramatv());
        return new ResponseEntity<>(
                programaTvService.guardarPrograma(newPrograma),HttpStatus.OK
        );

    }
}
