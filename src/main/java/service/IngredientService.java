package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.ProduitException;
import model.Ingredient;



@Service
public class IngredientService {

	@Autowired
	private IngredientService ingredientRepo;

	public List<Ingredient> findAll() {
		return ingredientRepo.findAll();
	}

	public Ingredient findById(Integer id) {
//		return produitRepo.findById(id).orElseThrow(()->{
//			throw new IdException();
//		});
		return ingredientRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Ingredient> findByName(String Name) {
		return ingredientRepo.findByName(Name);
	}

	public Ingredient create(Ingredient ingredient) {
		if (ingredient.getId() != null) {
			throw new IngredientException("ingredient deja dans la base");
		}
		return save(ingredient);

	}

	public Ingredient update(Ingredient ingredient) {
		if (ingredient.getId() == null || !ingredientRepo.existsById(ingredient.getId())) {
			throw new IdException();
		}
		return save(ingredient);
	}

	private Ingredient save(Ingredient ingredient) {
		f (ingredient.getId() == null || !ingredientRepo.existsById(ingredient.getId())) {
			throw new IdException();
		}
		
		if (ingredient.getCalorie() < 0 ) {
			throw new IngredientException("le nombre de calories doit être positif");
		}
		if (ingredient.getName() == null || ingredient.getName().isBlank() || ingredient.getName().length() > 30) {
			throw new IngredientException("probleme de nom");
		}
		if (ingredient.getDateDebutRecolte() <1 || ingredient.getDateDebutRecolte() >12 || ingredient.getDateDebutRecolte() > ingredient.getDateFinRecolte()) {
			throw new IngredientException("probleme de mois");
		}
		if (ingredient.getDateFinRecolte() <1 || ingredient.getDateFinRecolte() >12 || ingredient.getDateDebutRecolte() > ingredient.getDateFinRecolte()) {
			throw new IngredientException("probleme de mois");
		}
		return ingredientRepo.save(ingredient);
	}

	
	
	public void delete(Ingredient ingredient) {
		ingredientRepo.delete(ingredient);
	}

	public void deleteId(Integer id) {
		ingredientRepo.deleteById(id);
	}
}
