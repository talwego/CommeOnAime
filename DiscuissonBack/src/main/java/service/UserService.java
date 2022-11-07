package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.UserException;
import exception.AdminException;
import exception.IdException;
import model.Genre;
import model.User;
import repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll() 
	{
		return userRepo.findAll();
	}
	
	public User findById(Integer id) 
	{
		// A faire : IdException
		return userRepo.findById(id).orElseThrow(IdException::new);
	}
	
	
	public List<User> findByPseudo(String pseudo) 
	{
		return userRepo.findByPseudoContaining(pseudo);
	}
	
	public List<User> findByGenre(Genre genre) 
	{
		return userRepo.findByGenreContaining(genre);
	}
	
	public List<User> findByAge(int age) 
	{
		return userRepo.findByAgeContaining(age);
	}
	
	public List<User> findByTaille(double taille) 
	{
		return userRepo.findByTailleContaining(taille);
	}
	
	public List<User> findByPoids(double poids) 
	{
		return userRepo.findByPoidsContaining(poids);
	}
	
	public List<User> findByCompteVIP(boolean compteVIP) 
	{
		return userRepo.findByCompteVIPContaining(compteVIP);
	}
	
	public List<User> findByVegetarien(boolean vegetarien) 
	{
		return userRepo.findByVegetarienContaining(vegetarien);
	}
	
	public List<User> findByVegan(boolean vegan) 
	{
		return userRepo.findByVeganContaining(vegan);
	}
	
	
	public User create(User user) 
	{
		if (user.getId() != null) 
		{
			// TO DO AdminException
			throw new UserException("user deja dans la base");
		}
		return save(user);
	}
	
	public User update(User user) 
	{
		if (user.getId() == null || !userRepo.existsById(user.getId()))
		{
			throw new IdException();
		}
		return save(user);
	}
	
	public User save(User user) 
	{
		if (user.getPseudo() == null || user.getPseudo().isBlank() || user.getPseudo().length() > 30) 
		{
			throw new AdminException("probleme pseudo");
		}
		
		
		return userRepo.save(user);
	}
	
	public void delete(User user) 
	{
		userRepo.delete(user);
	}

	public void deleteId(Integer id) 
	{
		userRepo.deleteById(id);
	}

}
