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
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.service.InstructionRecetteService;
import Sopra.DiscuissonAPI.service.RecetteIngredientService;
import Sopra.DiscuissonAPI.service.RecetteService;

@RestController
@RequestMapping("/api/recette")
@CrossOrigin(origins = {"*"})
public class RecetteRestController {
	@Autowired
	private RecetteService recetteService;
	@Autowired
	private RecetteIngredientService recetteIngredientService;
	@Autowired
	private InstructionRecetteService instructionRecetteService;
	
	@PostMapping("")
	@JsonView(JsonViews.Recette.class)
	public Recette create(@RequestBody Recette recette) {
			
		return recetteService.save(recette);
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Recette findById(@PathVariable Integer id) {
		return recetteService.findById(id);
	}
	
	@GetMapping("/details/{id}")
	@JsonView(JsonViews.RecetteWithInstructionAndIngredient.class)
	public Recette findByIdWithInstructionAndIngredient(@PathVariable Integer id) {
		return recetteService.findById(id);
	}
	
	@GetMapping("/details")
	@JsonView(JsonViews.RecetteWithInstructionAndIngredient.class)
	public List<Recette> findAllWithInstructionAndIngredient() {
		return recetteService.findAll();
	}
	
	@JsonView(JsonViews.Recette.class)
	@PostMapping("/list")
	public List<Recette> create(@RequestBody List<Recette> recettes) {
			
		return recetteService.saveAll(recettes);
	}
	
	
	@GetMapping("")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findAll(){
		return recetteService.findAll();
	}
	//Liste recettes saison
	@GetMapping("/saison/{saison}")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findBySaison(@PathVariable int saison){
		System.out.println(saison);
		return recetteService.findBySaison(saison);
	}
	
	//Liste recettes vegetariennes
	@GetMapping("/vegetarien")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findByVegetarien(){
		return recetteService.findByVegetarien(true);
	}
	//Liste recettes vegetariennes
	@GetMapping("/vegan")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findByVegan(){
		return recetteService.findByVegan(true);
	}
	//Liste recettes interval calories
	@GetMapping("/calorie")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findByCalorieBetween(int obj1, int obj2){
		
		return recetteService.findByCalorieBetween(obj1, obj2);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		List<RecetteIngredient> recetteIngredients = recetteIngredientService.findAll();
		for (RecetteIngredient r : recetteIngredients) {
			if (r.getRecette().getId()==id) {
				recetteIngredientService.deleteById(r.getId());
			}
		}
		
		List<InstructionRecette> instructionRecettes = instructionRecetteService.findAll();
		for (InstructionRecette i : instructionRecettes) {
			if (i.getRecette().getId()==id) {
				instructionRecetteService.deleteById(i.getId());
			}
		}
			recetteService.deleteById(id);
		
	}
	@PutMapping("/{id}")
	@JsonView(JsonViews.Recette.class)
	public Recette update(@RequestBody Recette recette) {
	
		return recetteService.update(recette);
	}
	
	
	
}
