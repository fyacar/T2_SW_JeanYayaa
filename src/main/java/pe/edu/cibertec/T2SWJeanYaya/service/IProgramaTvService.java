package pe.edu.cibertec.T2SWJeanYaya.service;

import pe.edu.cibertec.T2SWJeanYaya.model.bd.ProgramaTv;

import java.util.List;
import java.util.Optional;

public interface IProgramaTvService {
    List<ProgramaTv> listarProgramas();
    ProgramaTv guardarPrograma(ProgramaTv programaTv);
    Optional<ProgramaTv> obtenerProgramatvxId(Integer id);
}
