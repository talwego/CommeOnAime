package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ElementFrigoException;
import exception.IdException;
import model.ElementFrigo;
import repository.ElementFrigoRepository;



@Service
public class ElementFrigoService {
	@Autowired
	private ElementFrigoRepository elementFrigoRepo;
	
	public List<ElementFrigo> findAll(){
		return elementFrigoRepo.findAll();
	}
	
	public ElementFrigo findById(Integer id) {
		return elementFrigoRepo.findById(id).orElseThrow(()->{
			throw new ElementFrigoException("unknown id");
		});
	}
	
	public ElementFrigo save(ElementFrigo elementFrigo) {
		if(elementFrigo.getUser() == null) {
			throw new ElementFrigoException("user obligatoire");
		}
		if(elementFrigo.getIngredient() == null) {
			throw new ElementFrigoException("ingredient obligatoire");
		}
		if(elementFrigo.getQuantite() == 0) {
			throw new ElementFrigoException("quantite obligatoire");
		}
		
		return elementFrigo;
		}
	
	public void delete(ElementFrigo elementFrigo) {
		elementFrigoRepo.delete(elementFrigo);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
}
