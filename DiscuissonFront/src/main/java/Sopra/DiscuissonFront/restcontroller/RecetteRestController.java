package perso.persoEshopSpringMVC.restcontroller;

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

import model.JsonViews;
import model.Recette;

import service.RecetteService;

@RestController
@RequestMapping("/api/recette")
public class RecetteRestController {
	@Autowired
	private RecetteService recetteService;
	
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
	//Liste recettes vegetariennes
	@GetMapping("")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findByVegetarien(Boolean obj){
		return recetteService.findByVegetarien(obj);
	}
	//Liste recettes vegetariennes
	@GetMapping("")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findByVegan(Boolean obj){
		return recetteService.findByVegan(obj);
	}
	//Liste recettes interval calories
	@GetMapping("")
	@JsonView(JsonViews.Recette.class)
	public List<Recette> findByCalorieBetween(int obj1, int obj2){
		
		return recetteService.findByCalorieBetween(obj1, obj2);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
			recetteService.deleteById(id);
		
	}
	@PutMapping("/{id}")
	@JsonView(JsonViews.Recette.class)
	public Recette update(@RequestBody Recette recette) {
	
		return recetteService.update(recette);
	}
	
	
	
}
