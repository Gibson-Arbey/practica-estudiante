package co.edu.ufps.web.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "curso")
public class CursoEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private EstudianteEntity estudianteEntity;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private MateriaEntity materiaEntity;

    @ManyToOne
    @JoinColumn(name = "jornada_id", nullable = false)
    private JornadaEntity jornadaEntity;

    private LocalDateTime horario;

    @Column(length = 1)
    private String grupo;
}
