package co.edu.ufps.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.web.entities.MateriaEntity;
import java.util.List;


public interface MateriaRepository extends JpaRepository<MateriaEntity, Integer> {
    
    List<MateriaEntity> findByCreditos(Integer creditos);

    List<MateriaEntity> findByNombreContaining(String nombre);
}
