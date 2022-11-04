package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdException;
import exception.IngredientException;
import exception.RecetteException;
import exception.RecetteIngredientException;
import model.Ingredient;
import repository.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository  _ingredientRepository;

	public List<Ingredient> findAll() {
		return _ingredientRepository.findAll();
	}

	public Ingredient findById(Integer id) {
		return _ingredientRepository.findById(id).orElseThrow(()->{
			throw new RecetteIngredientException("unknown id");
		});
	}	

	public Ingredient create(Ingredient ingredient) {
		if (ingredient.getId() != null) {
			throw new IngredientException("ingredient deja dans la base");
		}
		return save(ingredient);
	}

	public Ingredient update(Ingredient ingredient) {
		if (ingredient.getId() == null || !_ingredientRepository.existsById(ingredient.getId())) {
			throw new IdException();
		}
		return save(ingredient);
	}

	private Ingredient save(Ingredient ingredient) {
		if (ingredient.getCalorie() < 0 ) {
			throw new IngredientException("le nombre de calories doit être positif");
		}
		if (ingredient.getName() == null || ingredient.getName().isBlank() || ingredient.getName().length() > 30) {
			throw new IngredientException("probleme de nom");
		}
		if (ingredient.getDateDebutRecolte() <1 || ingredient.getDateDebutRecolte() >12) {
			throw new IngredientException("probleme de mois");
		}
		if (ingredient.getDateFinRecolte() <1 || ingredient.getDateFinRecolte() >12) {
			throw new IngredientException("probleme de mois");
		}
		return _ingredientRepository.save(ingredient);
	}
	
	public void delete(Ingredient ingredient) {
		_ingredientRepository.delete(ingredient);
	}

	public void deleteById(Integer id) {
		delete(findById(id));
	}

	
	private void debutSaisonIsValid(int obj) {
		if(obj < 1 || obj > 12) {
			throw new RecetteException("mois du debut de la saison < 1 ou > 12");
		}
	}
	
	private void finSaisonIsValid(int obj) {
		if(obj < 1 || obj > 12) {
			throw new RecetteException("mois de la fin de la saison < 1 ou > 12");
		}
	}
	
	private void calorieIsValid(int obj) {
		if(obj < 0) {
			throw new RecetteException("calorie < 0");
		}
	}
	
	public Ingredient findByIdFetch(Integer id) {
		return _ingredientRepository.findByIdFetchRecetteIngredient(id).orElseThrow(()->{
			throw new RecetteException("id inconnu");
		});
	}
	
	public List<Ingredient> findByName(String obj){
		return _ingredientRepository.findByNameContaining(obj);
	}
	
	public List<Ingredient> findByVegetarien(Boolean obj){
		return _ingredientRepository.findByVegetarien(obj);
	}
	
	public List<Ingredient> findByVegan(Boolean obj){
		return _ingredientRepository.findByVegan(obj);
	}
	
	public List<Ingredient> findByDateDebutRecolteLess(int obj){
		debutSaisonIsValid(obj);
		return _ingredientRepository.findByDateDebutRecolteLessThanEqual(obj);
	}
	
	public List<Ingredient> findByDateFinRecolteLess(int obj){
		finSaisonIsValid(obj);
		return _ingredientRepository.findByDateFinRecolteLessThanEqual(obj);
	}
	
	public List<Ingredient> findByDateDebutRecolteGreater(int obj){
		debutSaisonIsValid(obj);
		return _ingredientRepository.findByDateDebutRecolteGreaterThanEqual(obj);
	}
	
	public List<Ingredient> findByDateFinRecolteGreater(int obj){
		finSaisonIsValid(obj);
		return _ingredientRepository.findByDateFinRecolteGreaterThanEqual(obj);
	}
	
	public List<Ingredient> findBySaisonBetween(int obj1, int obj2){
		debutSaisonIsValid(obj1);
		finSaisonIsValid(obj2);
		if(obj1 <= obj2) {
			return _ingredientRepository.findBySaisonBetween(obj1, obj2);
		}
		else {
			return _ingredientRepository.findBySaisonBetween(obj1, obj2+12);
		}
	}
	
	public List<Ingredient> findByCalorieBetween(int obj1, int obj2){
		calorieIsValid(obj1);
		calorieIsValid(obj2);
		return _ingredientRepository.findByCalorieBetween(obj1, obj2);
	}
}
