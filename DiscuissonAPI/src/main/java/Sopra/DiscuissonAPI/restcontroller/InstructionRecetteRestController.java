package Sopra.DiscuissonAPI.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Sopra.DiscuissonAPI.model.InstructionRecette;
import Sopra.DiscuissonAPI.model.JsonViews;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.service.InstructionRecetteService;
import Sopra.DiscuissonAPI.service.RecetteIngredientService;

@RestController
@RequestMapping("/api/instructionRecette")
@CrossOrigin(origins = {"*"})
public class InstructionRecetteRestController {
	@Autowired
	private InstructionRecetteService instructionRecetteService;
	
	@PostMapping("")
	@JsonView(JsonViews.InstructionRecette.class)
	public InstructionRecette create(@RequestBody InstructionRecette instructionRecette) {
		return instructionRecetteService.create(instructionRecette);
	}
	
	
	@GetMapping("")
	@JsonView(JsonViews.InstructionRecette.class)
	public List<InstructionRecette> findAll(){
		return instructionRecetteService.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public InstructionRecette findById(@PathVariable Integer id) {
		return instructionRecetteService.findById(id);
	}
	
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.InstructionRecette.class)
	public void deleteById(@PathVariable Integer id) {
		instructionRecetteService.deleteById(id);
		}
	
	
	
	
}


