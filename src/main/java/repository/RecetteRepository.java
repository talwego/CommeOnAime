package repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Integer>{
	List<Recette> findByNameContaining(String _name);
	List<Recette> findByVegetarien(Boolean _vegetarien);
	List<Recette> findByVegan(Boolean _vegan);
	List<Recette> findByDebutSaisonLessThanEqual(int _debutSaison);
	List<Recette> findByFinSaisonLessThanEqual(int _finSaison);
	List<Recette> findByDebutSaisonGreaterThanEqual(int _debutSaison);
	List<Recette> findByFinSaisonGreaterThanEqual(int _finSaison);
	List<Recette> findByNoteBetween(int _note1, int _note2);
	List<Recette> findByCalorieBetween(int _calorie1, int _calorie2);
	List<Recette> findByTempsDeCuisineBetween(LocalTime _tempsDeCuisine1, LocalTime _tempsDeCuisine2);
	List<Recette> findByIsValidEquals(boolean _isValid);
	
	@Query("SELECT obj FROM Recette obj LEFT JOIN FETCH obj.recetteIngredients WHERE obj.id=:id")
	Optional<Recette> findByIdFetchRecetteIngredient(@Param("id") Integer _id);
	@Query("SELECT obj FROM Recette obj WHERE (obj.debutSaison <= obj.finSaison AND obj.debutSaison <= :debutSaison AND obj.finSaison >= :finSaison) OR (obj.debutSaison > obj.finSaison AND obj.debutSaison <= :debutSaison AND obj.finSaison + 12 >= :finSaison)")
	List<Recette> findBySaisonBetween(@Param("debutSaison") Integer _debutSaison, @Param("finSaison") Integer _finSaison);
}
