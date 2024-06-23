package pe.edu.cibertec.T2SWJeanYaya.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class MensajeErrorDto {
    private Integer codigo;
    private Date fechaError;
    private String mensaje;
    private String descripcion;
}
