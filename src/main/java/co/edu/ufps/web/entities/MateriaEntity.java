package co.edu.ufps.web.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "materia", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class MateriaEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nombre;

    @Max(value = 4, message = "El maximo de creditos es 4")
    @Min(value = 0, message = "El minimo de creditos es 0")
    private Integer creditos;

    @JsonIgnore
    @OneToMany(mappedBy = "materiaEntity", cascade = CascadeType.ALL)
    private List<CursoEntity> cursos = new ArrayList<>();
}
