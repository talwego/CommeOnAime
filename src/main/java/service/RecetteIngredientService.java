package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PatientException;
import exception.RecetteException;
import exception.RecetteIngredientException;
import model.Patient;
import model.RecetteIngredient;
import repository.IngredientRepository;
import repository.RecetteIngredientRepository;
import repository.RecetteRepository;
import repository.VisiteRepository;

@Service
public class RecetteIngredientService {
	@Autowired
	private RecetteIngredientRepository recetteIngredientRepository;
	@Autowired
	private RecetteRepository recetteRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public List<RecetteIngredient> findAll(){
		return recetteIngredientRepository.findAll();
	}
	
	public RecetteIngredient findById(Integer id) {
		return recetteIngredientRepository.findById(id).orElseThrow(()->{
			throw new RecetteIngredientException("unknown id");
		});
	}
	
	public RecetteIngredient create(RecetteIngredient obj) {
		if (obj.getId() != null) {
			throw new RecetteException("recetteIngredient deja dans la base");
		}
		return save(obj);
	}

	public RecetteIngredient update(RecetteIngredient obj) {
		if (obj.getId() == null || !recetteIngredientRepository.existsById(obj.getId())) {
			throw new RecetteException("id de la recetteIngredient pas dans la base");
		}
		return save(obj);
	}
	
	private RecetteIngredient save(RecetteIngredient obj) {
		return recetteIngredientRepository.save(obj);
	}
	
	public void delete(RecetteIngredient obj) {
		recetteIngredientRepository.delete(obj);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
	
}
