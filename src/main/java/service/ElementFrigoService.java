package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ElementFrigoException;
import model.ElementFrigo;



@Service
public class ElementFrigoService {
	@Autowired
	private ElementFrigoService elementFrigoRepo;
	
	public List<ElementFrigoService> findAll(){
		return elementFrigoRepo.findAll();
	}
	
	public ElementFrigoService findById(Integer id) {
		return elementFrigoRepo.findById(id).orElseThrow(()->{
			throw new GeneralException("unknown id");
		});
	}
	
	public void save(ElementFrigo elementFrigo) {
		if(elementFrigo.getUser() == null) {
			throw new IdException("user obligatoire");
		}
		if(elementFrigo.getIngredient() == null) {
			throw new ElementFrigoException("ingredient obligatoire");
		}
		if(elementFrigo.getQuantite() == null) {
			throw new ElementFrigoException("quantite obligatoire");
		}
		
		return elementFrigo.save(elementFrigo);
		}
	
	public void delete(ElementFrigoService elementFrigo) {
		elementFrigo.delete(elementFrigo);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
}
