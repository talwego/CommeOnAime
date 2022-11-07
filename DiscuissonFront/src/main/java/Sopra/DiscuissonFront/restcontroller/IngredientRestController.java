package Sopra.DiscuissonFront.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import model.Ingredient;
import model.JsonViews;
import service.IngredientService;


@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController {
	@Autowired
	private IngredientService ingredientService;
	
	@PostMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public Ingredient create(@RequestBody Ingredient ingredient) {
			
		return ingredientService.save(ingredient);
	}
	
	@JsonView(JsonViews.Ingredient.class)
	@PostMapping("/list")
	public List<Ingredient> create(@RequestBody List<Ingredient> ingredients) {
			
		return ingredientService.saveAll(ingredients);
	}
	
	@GetMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public List<Ingredient> findByVegetarien(Boolean obj){
		return ingredientService.findByVegetarien(obj);
	}
	@GetMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public List<Ingredient> findByVegan(Boolean obj){
		return ingredientService.findByVegan(obj);
	}
	
	public List<Ingredient> findByCalorieBetween(int obj1, int obj2){
		
		return ingredientService.findByCalorieBetween(obj1, obj2);
	}

	
	
	@GetMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public List<Ingredient> findAll(){
		return ingredientService.findAll();
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
