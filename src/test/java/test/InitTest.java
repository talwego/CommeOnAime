package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.JpaConfig;
import model.Ingredient;
import model.Recette;
import model.RecetteIngredient;
import service.IngredientService;
import service.RecetteIngredientService;
import service.RecetteService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
class InitTest {
	@Autowired
	RecetteService recetteService;
	@Autowired
	IngredientService ingredientService;
	@Autowired
	RecetteIngredientService recetteIngredientService;
	
	@Test
	@Commit
	void initRecetteAndIngredient() {
		Recette recette1 = new Recette("test01", false, false, 10, 1, 11, "comm01", 0, LocalTime.of(1, 10), true);
		Recette recette2 = new Recette("test02", true, false, 20, 1, 11, "comm02", 2, LocalTime.of(12, 10), true);
		
		recetteService.create(recette1);
		recetteService.create(recette2);
		recetteService.create(new Recette("test03", true, true, 30, 1, 9, "comm03", 12, LocalTime.of(10, 1), false));
		recetteService.create(new Recette("test04", false, true, 40, 8, 5, "comm04", 6, LocalTime.of(5, 50), false));
		recetteService.create(new Recette("test05", false, true, 40, 11, 2, "comm05", 9, LocalTime.of(2, 1), false));
		
		Ingredient ingredient1 = new Ingredient("tomate", 18, 7, 10, true, true);
		Ingredient ingredient2 = new Ingredient("concombre", 15, 7, 9, true, true);
		
		ingredientService.create(ingredient1);
		ingredientService.create(ingredient2);
		ingredientService.create(new Ingredient("oeuf", 155, 1, 12, true, false));
		ingredientService.create(new Ingredient("steak hache", 204, 1, 12, false, false));
		
		recetteIngredientService.create(new RecetteIngredient(ingredient1, recette1, 10));
		recetteIngredientService.create(new RecetteIngredient(ingredient1, recette2, 20));
		recetteIngredientService.create(new RecetteIngredient(ingredient2, recette1, 30));
		recetteIngredientService.create(new RecetteIngredient(ingredient2, recette2, 40));
	}

}
