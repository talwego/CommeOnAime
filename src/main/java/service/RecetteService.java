package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.RecetteException;
import model.Recette;
import repository.RecetteRepository;

@Service
public class RecetteService {
	@Autowired
	private RecetteRepository recetteRepository;
	
	public List<Recette> findAll(){
		return recetteRepository.findAll();
	}
	
	public Recette findById(Integer id) {
		return recetteRepository.findById(id).orElseThrow(()->{
			throw new RecetteException("unknown id");
		});
	}
	
	public Recette create(Recette obj) {
		if (obj.getId() != null) {
			throw new RecetteException("recette deja dans la base");
		}
		return save(obj);
	}

	public Recette update(Recette obj) {
		if (obj.getId() == null || !recetteRepository.existsById(obj.getId())) {
			throw new RecetteException("id de la recette pas dans la base");
		}
		return save(obj);
	}
	
	private Recette save(Recette obj) {
		if(obj.getCalorie() < 0) {
			throw new RecetteException("calorie negative");
		}
		else if(obj.getDebutSaison() < 1 || obj.getDebutSaison() > 12) {
			throw new RecetteException("mois du debut saison < 1 ou > 12");
		}
		else if(obj.getFinSaison() < 1 || obj.getFinSaison() > 12) {
			throw new RecetteException("mois du debut saison < 1 ou > 12");
		}
		return recetteRepository.save(obj);
	}
	
	public void delete(Recette obj) {
		recetteRepository.delete(obj);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
	
	public Recette findByIdFetch(Integer id) {
		return recetteRepository.findByIdFetchRecetteIngredient(id).orElseThrow(()->{
			throw new RecetteException("id inconnu");
		});
	}
}
