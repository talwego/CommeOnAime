package Sopra.DiscuissonAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.CompteException;
import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.exception.MessageException;
import Sopra.DiscuissonAPI.model.Compte;
import Sopra.DiscuissonAPI.repository.CompteRepository;




@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	
	public List<Compte> findAll() 
	{
		return compteRepo.findAll();
	}
	
	public Compte findById(Integer id) 
	{

		return compteRepo.findById(id).orElseThrow(()->{
			throw new MessageException("id inconnu");
		});
	}
	
	public List<Compte> findByLogin(String login) 
	{
		return compteRepo.findByLoginContaining(login);
	}
	
	public List<Compte> findByPassword(String password) 
	{
		return compteRepo.findByPasswordContaining(password);
	}
	
	public Compte findByIdFetch(Integer id) {
		return compteRepo.findByIdFetchMessage(id).orElseThrow(()->{
			throw new CompteException("id inconnu");
		});
	}
	
	public Compte create(Compte compte) 
	{
		if (compte.getId() != null) 
		{
			throw new CompteException("produit deja dans la base");
		}
		return save(compte);
	}
	
	public Compte update(Compte compte) 
	{
		if (compte.getId() == null || !compteRepo.existsById(compte.getId()))
		{
			throw new IdException();
		}
		return save(compte);
	}
	
	public Compte save(Compte compte) 
	{
		if (compte.getLogin() == null || compte.getLogin().isBlank() || compte.getLogin().length() > 30) 
		{
			throw new CompteException("probleme libelle");
		}
		if (compte.getPassword() == null || compte.getPassword().isBlank() || compte.getPassword().length() > 30) 
		{
			throw new CompteException("probleme libelle");
		}
		
		return compteRepo.save(compte);
	}
	
	public void delete(Compte compte) 
	{
		compteRepo.delete(compte);
	}

	public void deleteId(Integer id) 
	{
		compteRepo.deleteById(id);
	}
	
	
}