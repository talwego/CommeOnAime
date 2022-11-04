package service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.RecetteException;
import model.Recette;
import repository.RecetteRepository;

@Service
public class RecetteService {
	@Autowired
	private RecetteRepository _recetteRepository;
	
	public List<Recette> findAll(){
		return _recetteRepository.findAll();
	}
	
	public Recette findById(Integer id) {
		return _recetteRepository.findById(id).orElseThrow(()->{
			throw new RecetteException("unknown id");
		});
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
	
	private void noteIsValid(int obj) {
		if(obj < 0) {
			throw new RecetteException("note < 0");
		}
	}
	
	private Recette save(Recette obj) {
		calorieIsValid(obj.getCalorie());
		noteIsValid(obj.getNote());
		debutSaisonIsValid(obj.getDebutSaison());
		finSaisonIsValid(obj.getFinSaison());
		return _recetteRepository.save(obj);
	}
	
	public Recette create(Recette obj) {
		if (obj.getId() != null) {
			throw new RecetteException("recette deja dans la base");
		}
		return save(obj);
	}

	public Recette update(Recette obj) {
		if (obj.getId() == null || !_recetteRepository.existsById(obj.getId())) {
			throw new RecetteException("id de la recette pas dans la base");
		}
		return save(obj);
	}
	
	public void delete(Recette obj) {
		_recetteRepository.delete(obj);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
	
	public Recette findByIdFetch(Integer id) {
		return _recetteRepository.findByIdFetchRecetteIngredient(id).orElseThrow(()->{
			throw new RecetteException("id inconnu");
		});
	}
	
	public List<Recette> findByName(String obj){
		return _recetteRepository.findByNameContaining(obj);
	}
	
	public List<Recette> findByVegetarien(Boolean obj){
		return _recetteRepository.findByVegetarien(obj);
	}
	
	public List<Recette> findByVegan(Boolean obj){
		return _recetteRepository.findByVegan(obj);
	}
	
	public List<Recette> findByDebutSaisonLess(int obj){
		debutSaisonIsValid(obj);
		return _recetteRepository.findByDebutSaisonLessThanEqual(obj);
	}
	
	public List<Recette> findByFinSaisonLess(int obj){
		finSaisonIsValid(obj);
		return _recetteRepository.findByFinSaisonLessThanEqual(obj);
	}
	
	public List<Recette> findByDebutSaisonGreater(int obj){
		debutSaisonIsValid(obj);
		return _recetteRepository.findByDebutSaisonGreaterThanEqual(obj);
	}
	
	public List<Recette> findByFinSaisonGreater(int obj){
		finSaisonIsValid(obj);
		return _recetteRepository.findByFinSaisonGreaterThanEqual(obj);
	}
	
	public List<Recette> findBySaisonBetween(int obj1, int obj2){
		debutSaisonIsValid(obj1);
		finSaisonIsValid(obj2);
		if(obj1 <= obj2) {
			return _recetteRepository.findBySaisonBetween(obj1, obj2);
		}
		else {
			return _recetteRepository.findBySaisonBetween(obj1, obj2+12);
		}
	}
	
	public List<Recette> findByNoteBetween(int obj1, int obj2){
		noteIsValid(obj1);
		noteIsValid(obj2);
		return _recetteRepository.findByNoteBetween(obj1, obj2);
	}
	
	public List<Recette> findByCalorieBetween(int obj1, int obj2){
		calorieIsValid(obj1);
		calorieIsValid(obj2);
		return _recetteRepository.findByCalorieBetween(obj1, obj2);
	}
	
	public List<Recette> findByTempsDeCuisineBetween(LocalTime obj1, LocalTime obj2){
		return _recetteRepository.findByTempsDeCuisineBetween(obj1, obj2);
	}
	
	public List<Recette> findByIsValidEquals(boolean obj){
		return _recetteRepository.findByIsValidEquals(obj);
	}
}
