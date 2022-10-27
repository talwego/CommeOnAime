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
import service.IngredientService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
class IngredientServiceTest {

	@Autowired
	IngredientService ingredientService;

	@Test
	void InjectionTest() {
		assertNotNull(ingredientService);
	}
	
	@Test
	void createTest() {
		Ingredient ingredient = new Ingredient("test01", 18, 7, 10, true, true);
		ingredient = ingredientService.create(ingredient);
		assertNotNull(ingredient.getId());
		assertNotNull(ingredientService.findById(ingredient.getId()));
	}

}