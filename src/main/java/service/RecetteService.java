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
	private RecetteRepository recetteRepository;
	
	public List<Recette> findAll(){
		return recetteRepository.findAll();
	}
	
	public Recette findById(Integer _id) {
		return recetteRepository.findById(_id).orElseThrow(()->{
			throw new RecetteException("unknown id");
		});
	}
	
	private void debutSaisonIsValid(int _int) {
		if(_int < 1 || _int > 12) {
			throw new RecetteException("mois du debut de la saison < 1 ou > 12");
		}
	}
	
	private void finSaisonIsValid(int _int) {
		if(_int < 1 || _int > 12) {
			throw new RecetteException("mois de la fin de la saison < 1 ou > 12");
		}
	}
	
	private void calorieIsValid(int _int) {
		if(_int < 0) {
			throw new RecetteException("calorie < 0");
		}
	}
	
	private void noteIsValid(int _int) {
		if(_int < 0) {
			throw new RecetteException("note < 0");
		}
	}
	
	private Recette save(Recette _obj) {
		calorieIsValid(_obj.getCalorie());
		noteIsValid(_obj.getNote());
		debutSaisonIsValid(_obj.getDebutSaison());
		finSaisonIsValid(_obj.getFinSaison());
		return recetteRepository.save(_obj);
	}
	
	public Recette create(Recette _obj) {
		if (_obj.getId() != null) {
			throw new RecetteException("recette deja dans la base");
		}
		return save(_obj);
	}

	public Recette update(Recette _obj) {
		if (_obj.getId() == null || !recetteRepository.existsById(_obj.getId())) {
			throw new RecetteException("id de la recette pas dans la base");
		}
		return save(_obj);
	}
	
	public void delete(Recette _obj) {
		recetteRepository.delete(_obj);
	}
	
	public void deleteById(Integer _id) {
		delete(findById(_id));
	}
	
	public Recette findByIdFetch(Integer _id) {
		return recetteRepository.findByIdFetchRecetteIngredient(_id).orElseThrow(()->{
			throw new RecetteException("id inconnu");
		});
	}
	
	public List<Recette> findByName(String _name){
		return recetteRepository.findByNameContaining(_name);
	}
	
	public List<Recette> findByVegetarien(Boolean _vegetarien){
		return recetteRepository.findByVegetarien(_vegetarien);
	}
	
	public List<Recette> findByVegan(Boolean _vegan){
		return recetteRepository.findByVegan(_vegan);
	}
	
	public List<Recette> findByDebutSaisonLess(int _debutSaison){
		debutSaisonIsValid(_debutSaison);
		return recetteRepository.findByDebutSaisonLessThanEqual(_debutSaison);
	}
	
	public List<Recette> findByFinSaisonLess(int _finSaison){
		finSaisonIsValid(_finSaison);
		return recetteRepository.findByFinSaisonLessThanEqual(_finSaison);
	}
	
	public List<Recette> findByDebutSaisonGreater(int _debutSaison){
		debutSaisonIsValid(_debutSaison);
		return recetteRepository.findByDebutSaisonGreaterThanEqual(_debutSaison);
	}
	
	public List<Recette> findByFinSaisonGreater(int _finSaison){
		finSaisonIsValid(_finSaison);
		return recetteRepository.findByFinSaisonGreaterThanEqual(_finSaison);
	}
	
	public List<Recette> findBySaisonBetween(int _debutSaison, int _finSaison){
		debutSaisonIsValid(_debutSaison);
		finSaisonIsValid(_finSaison);
		if(_debutSaison <= _finSaison) {
			return recetteRepository.findBySaisonBetween(_debutSaison, _finSaison);
		}
		else {
			return recetteRepository.findBySaisonBetween(_debutSaison, _finSaison+12);
		}
	}
	
	public List<Recette> findByNoteBetween(int _note1, int _note2){
		noteIsValid(_note1);
		noteIsValid(_note2);
		return recetteRepository.findByNoteBetween(_note1, _note2);
	}
	
	public List<Recette> findByCalorieBetween(int _calorie1, int _calorie2){
		calorieIsValid(_calorie1);
		calorieIsValid(_calorie2);
		return recetteRepository.findByCalorieBetween(_calorie1, _calorie2);
	}
	
	public List<Recette> findByTempsDeCuisineBetween(LocalTime _tempsDeCuisine1, LocalTime _tempsDeCuisine2){
		return recetteRepository.findByTempsDeCuisineBetween(_tempsDeCuisine1, _tempsDeCuisine2);
	}
	
	public List<Recette> findByIsValidEquals(boolean _isValid){
		return recetteRepository.findByIsValidEquals(_isValid);
	}
}
