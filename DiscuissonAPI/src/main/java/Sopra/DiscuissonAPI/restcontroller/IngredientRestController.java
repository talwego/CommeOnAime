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

import Sopra.DiscuissonAPI.model.Ingredient;
import Sopra.DiscuissonAPI.model.JsonViews;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.service.IngredientService;


@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = {"*"})
public class IngredientRestController {
	@Autowired
	private IngredientService ingredientService;
	
	@PostMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		System.out.println(ingredient);
		return ingredientService.save(ingredient);
	}
	
	@JsonView(JsonViews.Ingredient.class)
	@PostMapping("/list")
	public List<Ingredient> create(@RequestBody List<Ingredient> ingredients) {
			
		return ingredientService.saveAll(ingredients);
	}
	
	@GetMapping("/vegetarien")
	@JsonView(JsonViews.Ingredient.class)
	public List<Ingredient> findByVegetarien(){
		return ingredientService.findByVegetarien(true);
	}
	@GetMapping("/vegan")
	@JsonView(JsonViews.Ingredient.class)
	public List<Ingredient> findByVegan(){
		return ingredientService.findByVegan(true);
	}
	
	public List<Ingredient> findByCalorieBetween(int obj1, int obj2){
		
		return ingredientService.findByCalorieBetween(obj1, obj2);
	}

	
	
	@GetMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public List<Ingredient> findAll(){
		return ingredientService.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Ingredient findById(@PathVariable Integer id) {
		return ingredientService.findById(id);
	}
	
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Ingredient.class)
	public void deleteById(@PathVariable Integer id) {
		ingredientService.deleteById(id);
		}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Ingredient.class)
	public Ingredient update(@RequestBody Ingredient ingredient) {
	
		return ingredientService.update(ingredient);
	}
	
	
	
}
