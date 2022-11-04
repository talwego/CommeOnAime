package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.RecetteException;
import exception.RecetteIngredientException;
import model.RecetteIngredient;
import repository.IngredientRepository;
import repository.RecetteIngredientRepository;
import repository.RecetteRepository;


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
	
	public RecetteIngredient create(RecetteIngredient obj) {
		if (obj.getId() != null) {
			throw new RecetteIngredientException("recetteIngredient deja dans la base");
		}
		return save(obj);
	}

	public RecetteIngredient update(RecetteIngredient obj) {
		if (obj.getId() == null || !_recetteIngredientRepository.existsById(obj.getId())) {
			throw new RecetteIngredientException("id de la recetteIngredient pas dans la base");
		}
		return save(obj);
	}
	
	private RecetteIngredient save(RecetteIngredient obj) {
		if (_ingredientRepository.existsById(obj.getIngredient().getId()) && _recetteRepository.existsById(obj.getIngredient().getId())) {
			return _recetteIngredientRepository.save(obj);
		}
		else {
			throw new RecetteIngredientException("ingredient et/ou recette inconnu en BDD");
		}
	}
	
	public void delete(RecetteIngredient obj) {
		if (_ingredientRepository.existsById(obj.getId())) {
			_recetteIngredientRepository.delete(obj);
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
