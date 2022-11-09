package Sopra.DiscuissonAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.CompteException;
import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.exception.RecetteIngredientException;
import Sopra.DiscuissonAPI.model.InstructionRecette;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.repository.InstructionRecetteRepository;
import Sopra.DiscuissonAPI.repository.RecetteRepository;




@Service
public class InstructionRecetteService {
	
	@Autowired
	private InstructionRecetteRepository _instructionRecetteRepository;
	@Autowired
	private RecetteRepository _recetteRepository;
	
	public List<InstructionRecette> findAll() 
	{
		return _instructionRecetteRepository.findAll();
	}
	
	public InstructionRecette findById(Integer id) 
	{
		// A faire : IdException
		return _instructionRecetteRepository.findById(id).orElseThrow(IdException::new);
	}
	
	public InstructionRecette create(InstructionRecette instructionRecette) 
	{
		if (instructionRecette.getId() != null) 
		{
			throw new CompteException("deja dans la base");
		}
		return save(instructionRecette);
	}
	
	public InstructionRecette create(Recette recette, String instruction) 
	{
		return save(new InstructionRecette(recette, instruction));
	}
	
	public InstructionRecette create(Integer idRecette, String instruction) 
	{
		Recette recette = _recetteRepository.findById(idRecette).orElseThrow(()->{
			throw new RecetteIngredientException("recette inconnu");
		});
		return save(new InstructionRecette(recette, instruction));
	}
	
	private InstructionRecette save(InstructionRecette instructionRecette) 
	{
		return _instructionRecetteRepository.save(instructionRecette);
	}
	
	public void delete(InstructionRecette instructionRecette) 
	{
		_instructionRecetteRepository.delete(instructionRecette);
	}

	public void deleteId(Integer id) 
	{
		_instructionRecetteRepository.deleteById(id);
	}
	
	
}
