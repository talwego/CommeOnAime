package Sopra.DiscuissonAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Sopra.DiscuissonAPI.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	List<Ingredient> findByNameContaining(String obj);
	List<Ingredient> findByVegetarien(Boolean obj);
	List<Ingredient> findByVegan(Boolean obj);
	List<Ingredient> findByDateDebutRecolteLessThanEqual(int obj);
	List<Ingredient> findByDateFinRecolteLessThanEqual(int obj);
	List<Ingredient> findByDateDebutRecolteGreaterThanEqual(int obj);
	List<Ingredient> findByDateFinRecolteGreaterThanEqual(int obj);
	List<Ingredient> findByCalorieBetween(int obj1, int obj2);
	
	@Query("SELECT obj FROM Ingredient obj LEFT JOIN FETCH obj.recetteIngredients WHERE obj.id=:id")
	Optional<Ingredient> findByIdFetchRecetteIngredient(@Param("id") Integer id);
	@Query("SELECT obj FROM Ingredient obj WHERE (obj.dateDebutRecolte <= obj.dateFinRecolte AND ((obj.dateDebutRecolte <= :obj1 AND obj.dateFinRecolte >= :obj2) OR (obj.dateDebutRecolte <= :obj1 AND obj.dateFinRecolte >= (:obj2 - 12)%12))) OR (obj.dateDebutRecolte > obj.dateFinRecolte AND ((obj.dateDebutRecolte <= :obj1 AND obj.dateFinRecolte + 12 >= :obj2) OR (obj.dateDebutRecolte <= :obj1 + 12 AND obj.dateFinRecolte + 12 >= :obj2 + 12)))")
	//@Query("SELECT obj FROM Ingredient obj WHERE ((obj.dateDebutRecolte <= obj.dateFinRecolte AND obj.dateFinRecolte - obj.dateDebutRecolte)")
	List<Ingredient> findBySaisonBetween(@Param("obj1") Integer obj1, @Param("obj2") Integer obj2);
}
