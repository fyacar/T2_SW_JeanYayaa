package pe.edu.cibertec.T2SWJeanYaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.T2SWJeanYaya.model.bd.ProgramaTv;

@Repository
public interface ProgramaTvRespository extends JpaRepository<ProgramaTv,Integer> {
}
