package co.edu.ufps.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.web.entities.CursoEntity;
import co.edu.ufps.web.entities.EstudianteEntity;
import co.edu.ufps.web.entities.JornadaEntity;
import co.edu.ufps.web.entities.MateriaEntity;
import co.edu.ufps.web.models.cursoRequest;
import co.edu.ufps.web.services.CursoService;

@RestController
@RequestMapping("/curso")
@Validated
public class CursoController {
    
    @Autowired
    CursoService cursoService;

    /*
     * Metodo para inscribir un estudiante en una materia
     */
    @PostMapping("/inscribir")
    public ResponseEntity<String> crearCurso(@Valid @RequestBody cursoRequest cursoRequest){
        CursoEntity cursoEntity = new CursoEntity();

        EstudianteEntity estudianteEntity = cursoService.buscarEstudiante(cursoRequest.getEstudiante());
        cursoEntity.setEstudianteEntity(estudianteEntity);

        MateriaEntity materiaEntity = cursoService.buscarMateria(cursoRequest.getMateria());
        cursoEntity.setMateriaEntity(materiaEntity);

        JornadaEntity jornadaEntity = cursoService.buscarJornada(cursoRequest.getJornada());
        cursoEntity.setJornadaEntity(jornadaEntity);

        cursoEntity.setHorarioInicio(cursoRequest.getHorarioInicio());
        cursoEntity.setHorarioFin(cursoRequest.getHorarioFin());
        cursoEntity.setDia(cursoRequest.getDia());
        cursoEntity.setGrupo(cursoRequest.getGrupo());
        
        cursoService.guardar(cursoEntity);
        return ResponseEntity.ok("Estudiante inscrito en el curso exitosamente");
    }

    /*
     * Metodo para listar todos los cursos de un estudiante
     */
    @GetMapping("/listarCursoEstudiante/{id}")
    public List<CursoEntity> listadoCursoEstudiante(@PathVariable("id") Integer id){
        EstudianteEntity estudianteEntity = cursoService.buscarEstudiante(id);
        return cursoService.listarCursoEstudiante(estudianteEntity);
    }

    /*
     * Metodo para listar todos los cursos de una materia
     */
    @GetMapping("/listarCursoMateria/{id}")
    public List<CursoEntity> listarCursoMateria(@PathVariable("id") Integer id){
        MateriaEntity materiaEntity = cursoService.buscarMateria(id);
        return cursoService.listarCursoMateria(materiaEntity);
    }

    /*
     * Metodo para listar todos los grupos de un curso
     */
    @GetMapping("/listarCursoGrupo/{grupo}")
    public List<CursoEntity> listarCursoGrupo(@PathVariable("grupo") String grupo){
        return cursoService.listarCursoGrupo(grupo);
    }

    /*
     * Meotodo para listar todos los cursos por jornada
     */
    @GetMapping("/listarCursoJornada/{id}")
    public List<CursoEntity> listadoCursoJornada(@PathVariable("id") Integer id){
        JornadaEntity jornadaEntity = cursoService.buscarJornada(id);
        return cursoService.listarCursoJornada(jornadaEntity);
    }
}
