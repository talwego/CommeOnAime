package Sopra.DiscuissonAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.RecetteException;
import Sopra.DiscuissonAPI.exception.RecetteIngredientException;
import Sopra.DiscuissonAPI.model.Ingredient;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.repository.IngredientRepository;
import Sopra.DiscuissonAPI.repository.RecetteIngredientRepository;
import Sopra.DiscuissonAPI.repository.RecetteRepository;


@Service
public class RecetteIngredientService {
	@Autowired
	private RecetteIngredientRepository _recetteIngredientRepository;
	@Autowired
	private RecetteRepository _recetteRepository;
	@Autowired
	private IngredientRepository _ingredientRepository;
	
	public List<RecetteIngredient> findAll(){
		return _recetteIngredientRepository.findAll();
	}
	
	public RecetteIngredient findById(Integer id) {
		return _recetteIngredientRepository.findById(id).orElseThrow(()->{
			throw new RecetteIngredientException("unknown id");
		});
	}
	
	public RecetteIngredient create(Recette recette, Ingredient ingredient, int quantite) {
		if (!_ingredientRepository.existsById(ingredient.getId()) || !_recetteRepository.existsById(recette.getId())) {
			throw new RecetteIngredientException("recetteIngredient deja dans la base");
		}
		return save(new RecetteIngredient(ingredient, recette, quantite));
	}
	
	public RecetteIngredient create(int idRecette, int idIngredient, int quantite) {
		Recette recette = _recetteRepository.findById(idRecette).orElseThrow(()->{
			throw new RecetteIngredientException("recette inconnu");
		});
		Ingredient ingredient = _ingredientRepository.findById(idIngredient).orElseThrow(()->{
			throw new RecetteIngredientException("ingredient inconnu");
		});
		return save(new RecetteIngredient(ingredient, recette, quantite));
	}
	
	public RecetteIngredient create(RecetteIngredient recetteIngredient) {
		if (recetteIngredient.getId() != null) {
			throw new RecetteIngredientException("recetteIngredient deja dans la base");
		}
		return save(recetteIngredient);
	}

	public RecetteIngredient update(RecetteIngredient recetteIngredient) {
		if (recetteIngredient.getId() == null || !_recetteIngredientRepository.existsById(recetteIngredient.getId())) {
			throw new RecetteIngredientException("id de la recetteIngredient pas dans la base");
		}
		return save(recetteIngredient);
	}
	
	public RecetteIngredient save(RecetteIngredient recetteIngredient) {
		if (_ingredientRepository.existsById(recetteIngredient.getIngredient().getId()) && _recetteRepository.existsById(recetteIngredient.getRecette().getId())) {
			return _recetteIngredientRepository.save(recetteIngredient);
		}
		else {
			throw new RecetteIngredientException("ingredient et/ou recette inconnu en BDD");
		}
	}
	
	public void delete(RecetteIngredient recetteIngredient) {
		System.out.println("======>>>");
		System.out.println(recetteIngredient);
		if (_recetteIngredientRepository.existsById(recetteIngredient.getId())) {
			_recetteIngredientRepository.delete(recetteIngredient);
		}
		else {
			throw new RecetteIngredientException("recetteIngredient inconnu en BDD");
		}
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
	
	private void quantiteIsValid(int obj) {
		if(obj < 0) {
			throw new RecetteException("quantite < 0");
		}
	}
}
