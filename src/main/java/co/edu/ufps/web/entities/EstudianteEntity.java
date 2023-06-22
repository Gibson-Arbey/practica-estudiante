package co.edu.ufps.web.entities;



import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "estudiante")
public class EstudianteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Max(value = 5, message = "La nota1 debe ser menor o igual a 5")
    @DecimalMax(value = "5", inclusive = true, message = "La nota1 debe ser menor o igual a 5")
    @Min(value = 0, message = "La nota1 debe ser mayor o igual a 0")
    @DecimalMin(value = "0", inclusive = true, message = "La nota1 debe ser mayor o igual a 0")
    private Float nota1;

    @Max(value = 5, message = "La nota2 debe ser menor o igual a 5")
    @DecimalMax(value = "5", inclusive = true, message = "La nota2 debe ser menor o igual a 5")
    @Min(value = 0, message = "La nota2 debe ser mayor o igual a 0")
    @DecimalMin(value = "0", inclusive = true, message = "La nota2 debe ser mayor o igual a 0")
    private Float nota2;

    @Max(value = 5, message = "La nota3 debe ser menor o igual a 5")
    @DecimalMax(value = "5", inclusive = true, message = "La nota3 debe ser menor o igual a 5")
    @Min(value = 0, message = "La nota3 debe ser mayor o igual a 0")
    @DecimalMin(value = "0", inclusive = true, message = "La nota3 debe ser mayor o igual a 0")
    private Float nota3;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Transient
	private Float promedio;
	
	@Transient
	private Integer edad;

    @JsonIgnore
    @OneToMany(mappedBy = "estudianteEntity", cascade = CascadeType.ALL)
    private List<CursoEntity> cursos = new ArrayList<>();

    public Float getPromedio() {
		return this.promedio = (this.nota1+this.nota2+this.nota3)/3;
	}
	
	public Integer getEdad() {
		Date fechaActual = new Date();
		LocalDate localDateNacimiento = this.fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateActual = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(localDateNacimiento, localDateActual);
        return this.edad = periodo.getYears();
	}
}
