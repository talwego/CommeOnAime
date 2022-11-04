package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.JpaConfig;
import model.Recette;
import service.RecetteService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
class RecetteServiceTest {
	@Autowired
	RecetteService _recetteService;

	@Test
	@Disabled
	void InjectionTest() {
		assertNotNull(_recetteService);
	}

	@Test
	@Disabled
	void createTest() {
		Recette recette = new Recette("test100", false, false, 10, 1, 11, "comm01", 1, LocalTime.of(1, 10), true);
		recette = _recetteService.create(recette);
		assertNotNull(recette.getId());
		assertNotNull(_recetteService.findById(recette.getId()));
	}

	@Test
	@Disabled
	void findByIdFetchTest() {
		Recette recette = _recetteService.findByIdFetch(1);
		assertEquals(2, recette.getRecetteIngredients().size());
		recette = _recetteService.findByIdFetch(3);
		assertEquals(0, recette.getRecetteIngredients().size());
	}

	@Test
	@Disabled
	void findByNameTest() {
		assertEquals(1, _recetteService.findByName("test01").size());
		assertEquals(5, _recetteService.findByName("t").size());
		assertEquals(5, _recetteService.findByName("es").size());
		assertEquals(0, _recetteService.findByName("z").size());
	}

	@Test
	@Disabled
	void findByVegetarienTest() {
		assertEquals(2, _recetteService.findByVegetarien(true).size());
		assertEquals(3, _recetteService.findByVegetarien(false).size());
	}

	@Test
	@Disabled
	void findByVeganTest() {
		assertEquals(3, _recetteService.findByVegan(true).size());
		assertEquals(2, _recetteService.findByVegan(false).size());
	}

	@Test
	@Disabled
	public void findByDebutSaisonLessTest() {
		assertEquals(3, _recetteService.findByDebutSaisonLess(1).size());
		assertEquals(4, _recetteService.findByDebutSaisonLess(9).size());
		assertEquals(5, _recetteService.findByDebutSaisonLess(12).size());
	}

	@Test
	@Disabled
	public void findByFinSaisonLessTest() {
		assertEquals(0, _recetteService.findByFinSaisonLess(1).size());
		assertEquals(2, _recetteService.findByFinSaisonLess(7).size());
		assertEquals(3, _recetteService.findByFinSaisonLess(10).size());
		assertEquals(5, _recetteService.findByFinSaisonLess(12).size());
	}

	@Test
	@Disabled
	public void findByDebutSaisonGreaterTest() {
		assertEquals(5, _recetteService.findByDebutSaisonGreater(1).size());
		assertEquals(2, _recetteService.findByDebutSaisonGreater(2).size());
		assertEquals(1, _recetteService.findByDebutSaisonGreater(9).size());
		assertEquals(0, _recetteService.findByDebutSaisonGreater(12).size());
	}

	@Test
	@Disabled
	public void findByFinSaisonGreaterTest() {
		assertEquals(5, _recetteService.findByFinSaisonGreater(1).size());
		assertEquals(4, _recetteService.findByFinSaisonGreater(3).size());
		assertEquals(2, _recetteService.findByFinSaisonGreater(11).size());
		assertEquals(0, _recetteService.findByFinSaisonGreater(12).size());
	}

	@Test
	@Disabled
	public void findBySaisonBetweenTest() {
		assertEquals(2, _recetteService.findBySaisonBetween(12, 12).size());
		assertEquals(3, _recetteService.findBySaisonBetween(5, 6).size());
		assertEquals(1, _recetteService.findBySaisonBetween(11, 5).size());
		assertEquals(2, _recetteService.findBySaisonBetween(11, 12).size());
	}

	@Test
	@Disabled
	public void findByNoteBetweenTest() {
		assertEquals(5, _recetteService.findByNoteBetween(0, 12).size());
		assertEquals(1, _recetteService.findByNoteBetween(2, 2).size());
		assertEquals(2, _recetteService.findByNoteBetween(6, 9).size());
		assertEquals(0, _recetteService.findByNoteBetween(13, 14).size());
	}
	
	@Test
	@Disabled
	public void findByCalorieBetweenTest() {
		assertEquals(3, _recetteService.findByCalorieBetween(10, 30).size());
		assertEquals(1, _recetteService.findByCalorieBetween(20, 20).size());
		assertEquals(2, _recetteService.findByCalorieBetween(40, 40).size());
		assertEquals(5, _recetteService.findByCalorieBetween(0, 50).size());
	}

	@Test
	@Disabled
	public void findByTempsDeCuisineBetweenTest() {
		assertEquals(0,
				_recetteService.findByTempsDeCuisineBetween(LocalTime.of(0, 10, 0), LocalTime.of(0, 20, 0)).size());
		assertEquals(5,
				_recetteService.findByTempsDeCuisineBetween(LocalTime.of(0, 10, 0), LocalTime.of(13, 20, 0)).size());
		assertEquals(3,
				_recetteService.findByTempsDeCuisineBetween(LocalTime.of(1, 0, 0), LocalTime.of(6, 0, 0)).size());
		assertEquals(2,
				_recetteService.findByTempsDeCuisineBetween(LocalTime.of(10, 1, 0), LocalTime.of(12, 10, 0)).size());
	}

	@Test
	@Disabled
	public void findByIsValidEqualsTest() {
		assertEquals(2, _recetteService.findByIsValidEquals(true).size());
		assertEquals(3, _recetteService.findByIsValidEquals(false).size());
	}

	/**/
}