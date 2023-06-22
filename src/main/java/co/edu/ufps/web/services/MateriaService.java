package co.edu.ufps.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.web.entities.MateriaEntity;
import co.edu.ufps.web.repositorios.MateriaRepository;

@Service
public class MateriaService {
    
    @Autowired
    MateriaRepository materiaRepository;

    /*
     * Metodo para guardar una materia
     */
    public void guardar(MateriaEntity materiaEntity){
        materiaRepository.save(materiaEntity);
    }

    /*
     * Metodo para buscar una materia por su id
     */
    public Optional<MateriaEntity> buscarMateria(Integer id){
        return materiaRepository.findById(id);
    }

    /*
     * Metodo para eliminar una materia por su id
     */
    public void elimiarMateria (Integer id){
        materiaRepository.deleteById(id);
    }

    /*
     * Metodo para listar materias por su cantidad de creditos
     */
    public List<MateriaEntity> listarMateriasCreditos(Integer creditos){
        return materiaRepository.findByCreditos(creditos);
    }


    public List<MateriaEntity> listarMateriasNombre(String nombre){
        return materiaRepository.findByNombreContaining(nombre);
    }
}
