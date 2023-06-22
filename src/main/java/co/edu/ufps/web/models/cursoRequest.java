package co.edu.ufps.web.models;


import java.time.LocalTime;

import lombok.Data;

@Data
public class cursoRequest {
    
    private String grupo;

    private LocalTime horarioInicio;

    private LocalTime horarioFin;

    private String dia;

    private Integer jornada;

    private Integer materia;

    private Integer estudiante;
}
