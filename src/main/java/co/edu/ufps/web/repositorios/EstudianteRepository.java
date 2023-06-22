package co.edu.ufps.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.ufps.web.entities.EstudianteEntity;
import java.util.List;


public interface EstudianteRepository  extends JpaRepository<EstudianteEntity, Integer>{
    
    @Query("SELECT e FROM EstudianteEntity e WHERE YEAR(CURRENT_DATE) - YEAR(e.fechaNacimiento) = :edad")
    List<EstudianteEntity> findByEdad(@Param("edad") Integer edad);

    @Query("SELECT e FROM EstudianteEntity e WHERE YEAR(CURRENT_DATE) - YEAR(e.fechaNacimiento) < :edad")
    List<EstudianteEntity> findByEdadMenor(@Param("edad") Integer edad);

    @Query("SELECT e FROM EstudianteEntity e WHERE YEAR(CURRENT_DATE) - YEAR(e.fechaNacimiento) > :edad")
    List<EstudianteEntity> findByEdadMayor(@Param("edad") Integer edad);

    @Query("SELECT e FROM EstudianteEntity e WHERE e.nombre LIKE %:nombre%")
    List<EstudianteEntity> findByNombreContaining(@Param("nombre") String nombre);

    @Query("SELECT e FROM EstudianteEntity e WHERE e.apellido LIKE %:apellido%")
    List<EstudianteEntity> findByApellidoContaining(@Param("apellido") String apellido);

    @Query("SELECT e FROM EstudianteEntity e where (e.nota1 + e.nota2 + e.nota3) / 3 = :promedio")
    List<EstudianteEntity> findByPromedio(@Param("promedio") Float promedio);

    @Query("SELECT e FROM EstudianteEntity e where (e.nota1 + e.nota2 + e.nota3) / 3 < :promedio")
    List<EstudianteEntity> findByPromedioMenor(@Param("promedio") Float promedio);

    @Query("SELECT e FROM EstudianteEntity e where (e.nota1 + e.nota2 + e.nota3) / 3 > :promedio")
    List<EstudianteEntity> findByPromedioMayor(@Param("promedio") Float promedio);

}
