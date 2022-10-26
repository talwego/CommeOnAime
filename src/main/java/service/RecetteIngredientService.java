package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.GeneralException;
import model.Achat;
import repository.AchatRepository;
import repository.RecetteIngredientRepository;

@Service
public class RecetteIngredientService {
	@Autowired
	private RecetteIngredientRepository recetteIngredientRepository;
	
	public List<Achat> findAll(){
		return recetteIngredientRepository.findAll();
	}
	
	public Achat findById(Integer id) {
		return recetteIngredientRepository.findById(id).orElseThrow(()->{
			throw new GeneralException("unknown id");
		});
	}
	
	public void save(Achat obj) {
		if(obj.getClient() == null) {
			throw new GeneralException("client obligatoire");
		}
		if(obj.getProduit() == null) {
			throw new GeneralException("produit obligatoire");
		}
		recetteIngredientRepository.save(obj);
	}
	
	public void delete(Achat obj) {
		recetteIngredientRepository.delete(obj);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
}
