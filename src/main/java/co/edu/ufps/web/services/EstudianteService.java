package co.edu.ufps.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.web.entities.EstudianteEntity;
import co.edu.ufps.web.repositorios.EstudianteRepository;

@Service
public class EstudianteService {
    
    @Autowired
    EstudianteRepository estudianteRepository;

    /*
     * Metodo para buscar un estudiante por su id
     */
    public Optional<EstudianteEntity> buscarEstudiante(Integer id){
        return estudianteRepository.findById(id);
    }

    /*
     * Metodo para guardar los datos de un estudiante;
     */
    public void guardar(EstudianteEntity estudianteEntity){
        estudianteRepository.save(estudianteEntity);
    }

    /*
     * Metodo para borrar a un estudiante
     */
    public void borrar(Integer id){
        estudianteRepository.deleteById(id);
    }

    /*
     * Metodo para listar los estudiantes que tengan la edad exacta a la que estan enviando
     */
    public List<EstudianteEntity> listarEstudiantesEdadExacta(Integer edad){
        return estudianteRepository.findByEdad(edad);
    }

    /*
     * Metodo para listar los estudiantes que sean menores a la edad que estan enviando
     */
    public List<EstudianteEntity> listarEstudiantesEdadMenor(Integer edad){
        return estudianteRepository.findByEdadMenor(edad);
    }

    /*
     * Metodo para listar los estudiantes que sean mayores a la edad que estan enviando
     */
    public List<EstudianteEntity> listarEstudiantesEdadMayor(Integer edad){
        return estudianteRepository.findByEdadMayor(edad);
    }

    /*
     * Metodo para listar los estudiantes por el nombre
     */
    public List<EstudianteEntity> listarEstudiantesNombre(String nombre){
        return estudianteRepository.findByNombreContaining(nombre);
    }

    /*
     * Metodo para listar los estudiantes por el nombre
     */
    public List<EstudianteEntity> listarEstudiantesApellido(String apellido){
        return estudianteRepository.findByApellidoContaining(apellido);
    }

    /*
     * Metodo para listar los estudiantes por tener un promedio exacto al que estan enviando
     */
    public List<EstudianteEntity> listarEstudiantesPromedio(Float promedio){
        return estudianteRepository.findByPromedio(promedio);
    }

    /*
     * Metodo para listar los estudiantes por tener un promedio menor al que estan enviando
     */
    public List<EstudianteEntity> listarEstudiantesPromedioMenor(Float promedio){
        return estudianteRepository.findByPromedioMenor(promedio);
    }

    /*
     * Metodo para listar los estudiantes por tener un promedio mayor al que estan enviando
     */
    public List<EstudianteEntity> listarEstudiantesPromedioMayor(Float promedio){
        return estudianteRepository.findByPromedioMayor(promedio);
    }


}
