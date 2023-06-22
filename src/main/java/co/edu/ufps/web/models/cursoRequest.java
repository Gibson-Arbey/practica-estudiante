package co.edu.ufps.web.models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class cursoRequest {
    
    private String grupo;

    private LocalDateTime horario;

    private Integer jornada;

    private Integer materia;

    private Integer estudiante;
}
