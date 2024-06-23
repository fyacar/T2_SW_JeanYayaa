package pe.edu.cibertec.T2SWJeanYaya.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2SWJeanYaya.model.bd.ProgramaTv;
import pe.edu.cibertec.T2SWJeanYaya.repository.ProgramaTvRespository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProgramaTvService implements IProgramaTvService {
    private ProgramaTvRespository programaTvRepository;
    @Override
    public List<ProgramaTv> listarProgramas() {
        return programaTvRepository.findAll();
    }

    @Override
    public ProgramaTv guardarPrograma(ProgramaTv programaTv) {
        return programaTvRepository.save(programaTv);
    }

    @Override
    public Optional<ProgramaTv> obtenerProgramatvxId(Integer id) {
        Optional<ProgramaTv> programa = programaTvRepository.findById(id);
        if(programa.isEmpty()){
            return Optional.empty();
        }
        return programa;
    }
}
