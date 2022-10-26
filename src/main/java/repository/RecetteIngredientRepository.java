package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Ingredient;
import model.Recette;
import model.RecetteIngredient;

public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Integer>{
	
}
