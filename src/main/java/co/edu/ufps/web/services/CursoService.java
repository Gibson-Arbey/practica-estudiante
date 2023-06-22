package co.edu.ufps.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.web.entities.CursoEntity;
import co.edu.ufps.web.entities.EstudianteEntity;
import co.edu.ufps.web.entities.JornadaEntity;
import co.edu.ufps.web.entities.MateriaEntity;
import co.edu.ufps.web.repositorios.CursoRepository;
import co.edu.ufps.web.repositorios.JornadaRepository;

@Service
public class CursoService {
    
    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    JornadaRepository jornadaRepository;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    MateriaService materiaService;

    /*
     * Metodo para buscar un estudiante por su id
     */
    public EstudianteEntity buscarEstudiante(Integer id){
        return estudianteService.buscarEstudiante(id).get();
    }

    /*
     * Metodo para buscar una materia por su id
     */
    public MateriaEntity buscarMateria(Integer id){
        return materiaService.buscarMateria(id).get();
    }

    /*
     * Metodo para buscar un estudiante por su id
     */
    public JornadaEntity buscarJornada(Integer id){
        return jornadaRepository.findById(id).get();
    }

    /*
     * Metodo para inscribir un estudiante en un curso
     */
    public void guardar(CursoEntity cursoEntity){
        cursoRepository.save(cursoEntity);
    }

    public List<CursoEntity> listarCursoEstudiante(EstudianteEntity estudianteEntity){
        return cursoRepository.findByEstudianteEntity(estudianteEntity);
    }
    

}
