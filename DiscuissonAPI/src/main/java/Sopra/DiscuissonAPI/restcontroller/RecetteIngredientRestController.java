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

import Sopra.DiscuissonAPI.model.JsonViews;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.service.RecetteIngredientService;

@RestController
@RequestMapping("/api/recetteIngredient")
@CrossOrigin(origins = {"*"})
public class RecetteIngredientRestController {
	@Autowired
	private RecetteIngredientService recetteIngredientService;
	
	@PostMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public RecetteIngredient create(@RequestBody RecetteIngredient recetteIngredient) {
		System.out.println(recetteIngredient);
		return recetteIngredientService.save(recetteIngredient);
	}
	
	
	@GetMapping("")
	@JsonView(JsonViews.RecetteIngredient.class)
	public List<RecetteIngredient> findAll(){
		return recetteIngredientService.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public RecetteIngredient findById(@PathVariable Integer id) {
		return recetteIngredientService.findById(id);
	}
	
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.RecetteIngredient.class)
	public void deleteById(@PathVariable Integer id) {
		recetteIngredientService.deleteById(id);
		}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Ingredient.class)
	public RecetteIngredient update(@RequestBody RecetteIngredient recetteIngredient) {
	
		return recetteIngredientService.update(recetteIngredient);
	}
	
	
	
}
