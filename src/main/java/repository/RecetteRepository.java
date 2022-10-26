package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Integer>{
	@Query("SELECT obj FROM Recette obj LEFT JOIN FETCH obj.recetteIngredients where obj.id=:id")
	Optional<Recette> findByIdFetchRecetteIngredient(@Param("id") Integer id);
}
