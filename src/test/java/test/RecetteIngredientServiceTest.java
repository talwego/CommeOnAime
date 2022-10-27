package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import service.RecetteIngredientService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
class RecetteIngredientServiceTest {

	@Autowired
	private RecetteIngredientService recetteIngredientService;

	@Test
	void InjectionTest() {
		assertNotNull(recetteIngredientService);
	}
	
	@Test
	void createTest() {
		Ingredient ingredient = new Ingredient();
		Recette recette = new Recette();
		ingredient.setId(1);
		recette.setId(1);
		RecetteIngredient recetteIngredient = new RecetteIngredient(ingredient, recette, 50);
		recetteIngredient = recetteIngredientService.create(recetteIngredient);
		assertNotNull(recetteIngredient.getId());
		assertNotNull(recetteIngredientService.findById(recetteIngredient.getId()));
	}

}