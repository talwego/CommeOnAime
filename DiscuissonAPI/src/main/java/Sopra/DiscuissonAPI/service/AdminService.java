package Sopra.DiscuissonAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.AdminException;
import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.model.Admin;
import Sopra.DiscuissonAPI.repository.AdminRepository;



@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	public List<Admin> findAll() 
	{
		return adminRepo.findAll();
	}
	
	public Admin findById(Integer id) 
	{
		return adminRepo.findById(id).orElseThrow(IdException::new);
	}
	
	public List<Admin> findByLogin(String login) 
	{
		return adminRepo.findByLoginContaining(login);
	}
	
	public List<Admin> findByPassword(String password) 
	{
		return adminRepo.findByPasswordContaining(password);
	}
	
	
	public Admin create(Admin admin) 
	{
		if (admin.getId() != null) 
		{
			// TO DO AdminException
			throw new AdminException("produit deja dans la base");
		}
		return save(admin);
	}
	
	public Admin update(Admin admin) 
	{
		if (admin.getId() == null || !adminRepo.existsById(admin.getId()))
		{
			throw new IdException();
		}
		return save(admin);
	}
	
	public Admin save(Admin admin) 
	{
		if (admin.getLogin() == null || admin.getLogin().isBlank() || admin.getLogin().length() > 30) 
		{
			throw new AdminException("probleme libelle");
		}
		if (admin.getPassword() == null || admin.getPassword().isBlank() || admin.getPassword().length() > 30) 
		{
			throw new AdminException("probleme libelle");
		}
		
		return adminRepo.save(admin);
	}
	
	public void delete(Admin admin) 
	{
		adminRepo.delete(admin);
	}

	public void deleteId(Integer id) 
	{
		adminRepo.deleteById(id);
	}
	
	
}
