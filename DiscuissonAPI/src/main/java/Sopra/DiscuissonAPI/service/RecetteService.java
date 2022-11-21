package Sopra.DiscuissonAPI.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.RecetteException;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.repository.RecetteRepository;

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
	
	private void debutSaisonIsValid(int saison) {
		if(saison < 1 || saison > 12) {
			throw new RecetteException("mois du debut de la saison < 1 ou > 12");
		}
	}
	
	private void finSaisonIsValid(int saison) {
		if(saison < 1 || saison > 12) {
			throw new RecetteException("mois de la fin de la saison < 1 ou > 12");
		}
	}
	
	private void calorieIsValid(int calorie) {
		if(calorie < 0) {
			throw new RecetteException("calorie < 0");
		}
	}
	
	private void noteIsValid(double note) {
		if(note < 0) {
			throw new RecetteException("note < 0");
		}
	}
	
	public Recette save(Recette recette) {
		calorieIsValid(recette.getCalorie());
		noteIsValid(recette.getNote());
		debutSaisonIsValid(recette.getDebutSaison());
		finSaisonIsValid(recette.getFinSaison());
		return recetteRepository.save(recette);
	}
	
	public Recette create(Recette recette) {
		if (recette.getId() != null) {
			throw new RecetteException("recette deja dans la base");
		}
		return save(recette);
	}

	public Recette update(Recette recette) {
		if (recette.getId() == null || !recetteRepository.existsById(recette.getId())) {
			throw new RecetteException("id de la recette pas dans la base");
		}
		return save(recette);
	}
	
	public void delete(Recette recette) {
		recetteRepository.delete(recette);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
	
	public Recette findByIdFetch(Integer id) {
		return recetteRepository.findByIdFetchRecetteIngredient(id).orElseThrow(()->{
			throw new RecetteException("id inconnu");
		});
	}
	
	public List<Recette> findByName(String name){
		return recetteRepository.findByNameContaining(name);
	}
	
	public List<Recette> findByVegetarien(Boolean vegetarien){
		return recetteRepository.findByVegetarien(vegetarien);
	}
	
	public List<Recette> findByVegan(Boolean vegan){
		return recetteRepository.findByVegan(vegan);
	}
	
	public List<Recette> findByDebutSaisonLess(int obj){
		debutSaisonIsValid(obj);
		return recetteRepository.findByDebutSaisonLessThanEqual(obj);
	}
	
	public List<Recette> findByFinSaisonLess(int obj){
		finSaisonIsValid(obj);
		return recetteRepository.findByFinSaisonLessThanEqual(obj);
	}
	
	public List<Recette> findByDebutSaisonGreater(int obj){
		debutSaisonIsValid(obj);
		return recetteRepository.findByDebutSaisonGreaterThanEqual(obj);
	}
	
	public List<Recette> findByFinSaisonGreater(int obj){
		finSaisonIsValid(obj);
		return recetteRepository.findByFinSaisonGreaterThanEqual(obj);
	}
	
	public List<Recette> findBySaisonBetween(int obj1, int obj2){
		debutSaisonIsValid(obj1);
		finSaisonIsValid(obj2);
		if(obj1 <= obj2) {
			return recetteRepository.findBySaisonBetween(obj1, obj2);
		}
		else {
			return recetteRepository.findBySaisonBetween(obj1, obj2+12);
		}
	}
	
	public List<Recette> findByNoteBetween(int obj1, int obj2){
		noteIsValid(obj1);
		noteIsValid(obj2);
		return recetteRepository.findByNoteBetween(obj1, obj2);
	}
	
	public List<Recette> findByCalorieBetween(int obj1, int obj2){
		calorieIsValid(obj1);
		calorieIsValid(obj2);
		return recetteRepository.findByCalorieBetween(obj1, obj2);
	}
	
	public List<Recette> findByTempsDeCuisineBetween(Duration obj1, Duration obj2){
		return recetteRepository.findByTempsDeCuisineBetween(obj1, obj2);
	}
	
	public List<Recette> findByIsValidEquals(boolean obj){
		return recetteRepository.findByIsValidEquals(obj);
	}

	public List<Recette> saveAll(List<Recette> recettes) {
		return recetteRepository.findAll();
	}
}
