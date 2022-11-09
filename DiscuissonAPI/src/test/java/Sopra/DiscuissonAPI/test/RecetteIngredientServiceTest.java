package Sopra.DiscuissonAPI.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Sopra.DiscuissonAPI.model.Ingredient;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.service.RecetteIngredientService;

@SpringBootTest
class RecetteIngredientServiceTest {

	@Autowired
	private RecetteIngredientService _recetteIngredientService;

	@Test
	void InjectionTest() {
		assertNotNull(_recetteIngredientService);
	}
	
	@Test
	void createTest() {
		Ingredient ingredient = new Ingredient();
		Recette recette = new Recette();
		ingredient.setId(1);
		recette.setId(1);
		RecetteIngredient recetteIngredient = new RecetteIngredient(ingredient, recette, 50);
		recetteIngredient = _recetteIngredientService.create(recetteIngredient);
		assertNotNull(recetteIngredient.getId());
		assertNotNull(_recetteIngredientService.findById(recetteIngredient.getId()));
	}

}