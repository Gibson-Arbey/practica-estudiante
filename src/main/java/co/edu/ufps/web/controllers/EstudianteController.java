package co.edu.ufps.web.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.web.entities.EstudianteEntity;
import co.edu.ufps.web.services.EstudianteService;

@RestController
@RequestMapping("/estudiante")
@Validated
public class EstudianteController {
    
    @Autowired
    EstudianteService estudianteService;

    /*
     * Metodo para buscar un estudiante por su id
     */
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarEstudiante(@RequestParam("id") Integer id){
       Optional<EstudianteEntity> estudianteOptional = estudianteService.buscarEstudiante(id);
    
        if (estudianteOptional.isPresent()) {
            EstudianteEntity estudiante = estudianteOptional.get();
            return ResponseEntity.ok(estudiante);
        } else {
            String mensaje = "Estudiante con el id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    /*
     * Metodo para guardar un estudiante
     */
    @PostMapping("/guardar")
    public ResponseEntity<String> agregarEstudiante(@Valid @RequestBody EstudianteEntity estudianteEntity){
        estudianteService.guardar(estudianteEntity);
        return ResponseEntity.ok("Estudiante guardado exitosamente");
    }

    /*
     * Metodo para eliminar un estudiante
     */
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> elimiarEstudiante(@RequestParam("id") Integer id){
        Optional<EstudianteEntity> estudianteOptional = estudianteService.buscarEstudiante(id);
    
        if (estudianteOptional.isPresent()) {
            estudianteService.borrar(id);
            return ResponseEntity.ok("Estudiante eliminado exitosamente");
        } else {
            String mensaje = "Estudiante con el id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    /*
     * Metodo para actualizar un estudiante
     */
    @PutMapping("/editar")
    public ResponseEntity<String> editarEstudiante(@RequestParam("id") Integer id, @Valid @RequestBody EstudianteEntity estudianteActualizado){
         Optional<EstudianteEntity> estudianteOptional = estudianteService.buscarEstudiante(id);
        if (estudianteOptional.isPresent()) {
            EstudianteEntity estudianteExistente = estudianteOptional.get();
    
            estudianteExistente.setNombre(estudianteActualizado.getNombre());
            estudianteExistente.setApellido(estudianteActualizado.getApellido());
            estudianteExistente.setNota1(estudianteActualizado.getNota1());
            estudianteExistente.setNota2(estudianteActualizado.getNota2());
            estudianteExistente.setNota3(estudianteActualizado.getNota3());
            estudianteExistente.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());

            estudianteService.guardar(estudianteExistente);
            return ResponseEntity.ok("Estudiante actualizado exitosamente");

        } else {
            String mensaje = "Estudiante con el id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }

    }

    /*
     * Metodo que lista los estudiantes que tengan la edad exacta
     */
    @GetMapping("/listar")
    public List<EstudianteEntity> listarEstudiantesPorEdadExacta(@RequestParam("edad") Integer edad){
        return estudianteService.listarEstudiantesEdadExacta(edad);
        
    }

    /*
     * Metodo que lista los estudiantes que sean menores a la edad que estan enviando
     */
    @GetMapping("/listarMenores")
    public List<EstudianteEntity> listarEstudiantesMenores(@RequestParam("edad") Integer edad){
        return estudianteService.listarEstudiantesEdadMenor(edad);
        
    }

    /*
     * Metodo que lista los estudiantes que sean mayores a la edad que estan enviando
     */
    @GetMapping("/listarMayores")
    public List<EstudianteEntity> listarEstudiantesMayores(@RequestParam("edad") Integer edad){
        return estudianteService.listarEstudiantesEdadMayor(edad);
    }

    /*
     * Metodo que lista los estudiantes que tengan coincidencias en el nombre
     */
    @GetMapping("/listarNombre")
    public List<EstudianteEntity> listarEstudiantesCoincidenciaNombre(@RequestParam("nombre") String nombre){
        return estudianteService.listarEstudiantesNombre(nombre);
    }

    /*
     * Metodo que lista los estudiantes que tengan coincidencias en el apellido
     */
    @GetMapping("/listarApellido")
    public List<EstudianteEntity> listarEstudiantesCoincidenciaApellido(@RequestParam("apellido") String apellido){
        return estudianteService.listarEstudiantesApellido(apellido);
    }

    /*
     * Metodo que lista los estudiantes que tengan coincidencias exactas en el promedio
     */
    @GetMapping("/listarPromedio")
    public List<EstudianteEntity> listarEstudiantesPromedio(@RequestParam("promedio") Float promedio){
        return estudianteService.listarEstudiantesPromedio(promedio);
    }

    /*
     * Metodo que lista los estudiantes que tengan promedio menor
     */
    @GetMapping("/listarPromedioMenor")
    public List<EstudianteEntity> listarEstudiantesPromedioMenor(@RequestParam("promedio") Float promedio){
        return estudianteService.listarEstudiantesPromedioMenor(promedio);
    }

    /*
     * Metodo que lista los estudiantes que tengan promedio mayor
     */
    @GetMapping("/listarPromedioMayor")
    public List<EstudianteEntity> listarEstudiantesPromedioMayor(@RequestParam("promedio") Float promedio){
        return estudianteService.listarEstudiantesPromedioMayor(promedio);
    }
}
