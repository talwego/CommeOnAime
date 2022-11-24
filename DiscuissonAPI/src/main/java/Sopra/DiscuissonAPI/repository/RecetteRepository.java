package Sopra.DiscuissonAPI.repository;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Sopra.DiscuissonAPI.model.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Integer>{
	List<Recette> findByNameContaining(String obj);
	List<Recette> findByVegetarien(Boolean obj);
	List<Recette> findByVegan(Boolean obj);
	List<Recette> findByDebutSaisonLessThanEqual(int obj);
	List<Recette> findByFinSaisonLessThanEqual(int obj);
	List<Recette> findByDebutSaisonGreaterThanEqual(int obj);
	List<Recette> findByFinSaisonGreaterThanEqual(int obj);
	List<Recette> findByNoteBetween(int obj1, int obj2);
	List<Recette> findByCalorieBetween(int obj1, int obj2);
	List<Recette> findByTempsDeCuisineBetween(LocalTime obj1, LocalTime obj2);
	List<Recette> findByIsValidEquals(boolean obj);
	
	@Query("SELECT obj FROM Recette obj LEFT JOIN FETCH obj.recetteIngredients WHERE obj.id=:id")
	Optional<Recette> findByIdFetchRecetteIngredient(@Param("id") Integer id);
	@Query("SELECT obj FROM Recette obj WHERE (obj.debutSaison <= obj.finSaison AND obj.debutSaison <= :obj1 AND obj.finSaison >= :obj2) OR (obj.debutSaison > obj.finSaison AND obj.debutSaison <= :obj1 AND obj.finSaison + 12 >= :obj2)")
	List<Recette> findBySaisonBetween(@Param("obj1") Integer obj1, @Param("obj2") Integer obj2);
	
	
	@Query("SELECT obj FROM Recette obj WHERE ((obj.debutSaison <= obj.finSaison AND obj.debutSaison<=:saison AND obj.finSaison>=:saison) OR (obj.debutSaison > obj.finSaison AND obj.debutSaison>=:saison AND obj.finSaison<=:saison))")
	List<Recette> findBySaison(@Param("saison") Integer saison);
	
}
