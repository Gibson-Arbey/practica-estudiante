package co.edu.ufps.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.web.entities.JornadaEntity;

public interface JornadaRepository extends JpaRepository<JornadaEntity, Integer> {
    
}
