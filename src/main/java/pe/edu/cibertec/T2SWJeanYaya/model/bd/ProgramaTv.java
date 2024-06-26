package pe.edu.cibertec.T2SWJeanYaya.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ProgramaTv")
public class ProgramaTv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprogramatv;
    private String titulo;
    private String resumen;
    private Date fechainicio;
    private Integer idpersonaje;

}
