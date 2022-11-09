package Sopra.DiscuissonAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.CompteException;
import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.model.InstructionRecette;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.repository.InstructionRecetteRepository;




@Service
public class InstructionRecetteService {
	
	@Autowired
	private InstructionRecetteRepository _instructionRecetteRepository;
	
	public List<InstructionRecette> findAll() 
	{
		return _instructionRecetteRepository.findAll();
	}
	
	public InstructionRecette findById(Integer id) 
	{
		// A faire : IdException
		return _instructionRecetteRepository.findById(id).orElseThrow(IdException::new);
	}
	
	public InstructionRecette create(InstructionRecette obj) 
	{
		if (obj.getId() != null) 
		{
			throw new CompteException("deja dans la base");
		}
		return save(obj);
	}
	
	public InstructionRecette create(Recette obj1, String ob2) 
	{
		return save(new InstructionRecette(obj1, ob2));
	}
	
	private InstructionRecette save(InstructionRecette obj) 
	{
		return _instructionRecetteRepository.save(obj);
	}
	
	public void delete(InstructionRecette obj) 
	{
		_instructionRecetteRepository.delete(obj);
	}

	public void deleteId(Integer id) 
	{
		_instructionRecetteRepository.deleteById(id);
	}
	
	
}
