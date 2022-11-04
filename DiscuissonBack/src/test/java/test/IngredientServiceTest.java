package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
	IngredientService _ingredientService;

	@Test
	@Disabled
	void InjectionTest() {
		assertNotNull(_ingredientService);
	}
	
	@Test
	@Disabled
	void createTest() {
		Ingredient ingredient = new Ingredient("test01", 18, 7, 10, true, true);
		ingredient = _ingredientService.create(ingredient);
		assertNotNull(ingredient.getId());
		assertNotNull(_ingredientService.findById(ingredient.getId()));
	}
	
	@Test
	@Disabled
	void findByIdFetchTest() {
		Ingredient ingredient = _ingredientService.findByIdFetch(1);
		assertEquals(2, ingredient.getRecetteIngredients().size());
		ingredient = _ingredientService.findByIdFetch(3);
		assertEquals(0, ingredient.getRecetteIngredients().size());
	}

	@Test
	@Disabled
	void findByNameTest() {
		assertEquals(1, _ingredientService.findByName("tomate").size());
		assertEquals(3, _ingredientService.findByName("o").size());
		assertEquals(4, _ingredientService.findByName("te").size());
		assertEquals(0, _ingredientService.findByName("z").size());
	}

	@Test
	@Disabled
	void findByVegetarienTest() {
		assertEquals(5, _ingredientService.findByVegetarien(true).size());
		assertEquals(1, _ingredientService.findByVegetarien(false).size());
	}

	@Test
	@Disabled
	void findByVeganTest() {
		assertEquals(3, _ingredientService.findByVegan(true).size());
		assertEquals(3, _ingredientService.findByVegan(false).size());
	}

	@Test
	@Disabled
	public void findByDateDebutRecolteLessTest() {
		assertEquals(2, _ingredientService.findByDateDebutRecolteLess(1).size());
		assertEquals(4, _ingredientService.findByDateDebutRecolteLess(7).size());
		assertEquals(6, _ingredientService.findByDateDebutRecolteLess(12).size());
	}

	@Test
	@Disabled
	public void findByDateFinRecolteLessTest() {
		assertEquals(1, _ingredientService.findByDateFinRecolteLess(1).size());
		assertEquals(2, _ingredientService.findByDateFinRecolteLess(4).size());
		assertEquals(4, _ingredientService.findByDateFinRecolteLess(10).size());
		assertEquals(6, _ingredientService.findByDateFinRecolteLess(12).size());
	}

	@Test
	@Disabled
	public void findByDateDebutRecolteGreaterTest() {
		assertEquals(6, _ingredientService.findByDateDebutRecolteGreater(1).size());
		assertEquals(4, _ingredientService.findByDateDebutRecolteGreater(6).size());
		assertEquals(2, _ingredientService.findByDateDebutRecolteGreater(8).size());
		assertEquals(0, _ingredientService.findByDateDebutRecolteGreater(12).size());
	}

	@Test
	@Disabled
	public void findByDateFinRecolteGreaterTest() {
		assertEquals(6, _ingredientService.findByDateFinRecolteGreater(1).size());
		assertEquals(5, _ingredientService.findByDateFinRecolteGreater(3).size());
		assertEquals(3, _ingredientService.findByDateFinRecolteGreater(10).size());
		assertEquals(2, _ingredientService.findByDateFinRecolteGreater(12).size());
	}

	@Test
	//@Disabled
	public void findBySaisonBetweenTest() {
		assertEquals(3, _ingredientService.findBySaisonBetween(3, 3).size());
		assertEquals(3, _ingredientService.findBySaisonBetween(7, 10));
		assertEquals(2, _ingredientService.findBySaisonBetween(10, 3).size());
		assertEquals(1, _ingredientService.findBySaisonBetween(8, 1).size());
	}

	@Test
	@Disabled
	public void findByCalorieBetweenTest() {
		assertEquals(2, _ingredientService.findByCalorieBetween(10, 20).size());
		assertEquals(3, _ingredientService.findByCalorieBetween(100, 210).size());
		assertEquals(0, _ingredientService.findByCalorieBetween(400, 600).size());
		assertEquals(6, _ingredientService.findByCalorieBetween(0, 250).size());
	}

	/**/
}