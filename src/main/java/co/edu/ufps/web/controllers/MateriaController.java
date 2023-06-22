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


import co.edu.ufps.web.entities.MateriaEntity;
import co.edu.ufps.web.services.MateriaService;

@RestController
@RequestMapping("/materia")
@Validated
public class MateriaController {
    

    @Autowired
    MateriaService materiaService;

    /*
     * Metodo para guardar una materia
     */
    @PostMapping("/guardar")
    public ResponseEntity<String> guardarMateria(@Valid @RequestBody MateriaEntity materiaEntity){
        materiaService.guardar(materiaEntity);
        return ResponseEntity.ok("Materia guardada exitosamente");
    }

    /*
     * Metodo para buscar una materia por su id
     */
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarMateria(@RequestParam("id") Integer id){
       Optional<MateriaEntity> materiaOptional = materiaService.buscarMateria(id);
    
        if (materiaOptional.isPresent()) {
            MateriaEntity materia = materiaOptional.get();
            return ResponseEntity.ok(materia);
        } else {
            String mensaje = "Materia con el id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    /*
     * Metodo para eliminar una materia
     */
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> elimiarMateria(@RequestParam("id") Integer id){
        Optional<MateriaEntity> materiaOptional = materiaService.buscarMateria(id);
    
        if (materiaOptional.isPresent()) {
            materiaService.elimiarMateria(id);
            return ResponseEntity.ok("Materia eliminada exitosamente");
        } else {
            String mensaje = "Materia con id: " + id + " no encontrada";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    /*
     * Metodo para actualizar una materia
     */
    @PutMapping("/editar")
    public ResponseEntity<String> editarEstudiante(@RequestParam("id") Integer id, @Valid @RequestBody MateriaEntity materiaActualizada){
         Optional<MateriaEntity> materiaOptional = materiaService.buscarMateria(id);
        if (materiaOptional.isPresent()) {
            MateriaEntity materiaExistente = materiaOptional.get();
    
            materiaExistente.setNombre(materiaActualizada.getNombre());
            materiaExistente.setCreditos(materiaActualizada.getCreditos());
            materiaService.guardar(materiaExistente);

            return ResponseEntity.ok("Materia actualizada exitosamente");

        } else {
            String mensaje = "Materia con id: " + id + " no encontrada";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }

    }

    /*
     * Meotodo para listar las materias por creditos
     */
    @GetMapping("/listarCreditos")
    public List<MateriaEntity> listarMateriasCreditos(@RequestParam("creditos") Integer creditos){
        return materiaService.listarMateriasCreditos(creditos);
    }

    /*
     * Meotodo para listar las materias por coincidencias en el nombre
     */
    @GetMapping("/listarNombre")
    public List<MateriaEntity> listarMateriasNombre(@RequestParam("nombre") String nombre){
        return materiaService.listarMateriasNombre(nombre);
    }
}
