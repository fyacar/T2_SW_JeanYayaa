package pe.edu.cibertec.T2SWJeanYaya.service;

import pe.edu.cibertec.T2SWJeanYaya.model.bd.Personaje;
import pe.edu.cibertec.T2SWJeanYaya.model.bd.ProgramaTv;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {
    List<Personaje> listarPersonajes();
    Personaje guardarPersonaje(Personaje personaje);
    Optional<Personaje> obtenerPersonajexId(Integer id);
}
