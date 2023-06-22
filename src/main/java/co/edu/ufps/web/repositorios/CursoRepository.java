package co.edu.ufps.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.web.entities.CursoEntity;
import co.edu.ufps.web.entities.EstudianteEntity;
import co.edu.ufps.web.entities.JornadaEntity;
import co.edu.ufps.web.entities.MateriaEntity;

import java.util.List;
import java.time.LocalDateTime;


public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
    
    List<CursoEntity> findByHorarioInicio(LocalDateTime horario);

    List<CursoEntity> findByHorarioFin(LocalDateTime horario);

    List<CursoEntity> findByMateriaEntity(MateriaEntity materiaEntity);

    List<CursoEntity> findByEstudianteEntity(EstudianteEntity estudianteEntity);

    List<CursoEntity> findByJornadaEntity(JornadaEntity jornadaEntity);

    List<CursoEntity> findByGrupo(String grupo);
}
