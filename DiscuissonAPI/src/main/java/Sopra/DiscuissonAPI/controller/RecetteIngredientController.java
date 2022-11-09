package Sopra.DiscuissonAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.service.RecetteIngredientService;



@Controller
@RequestMapping("/recette")
public class RecetteIngredientController {
	
	@Autowired
	private RecetteIngredientService recetteIngredientService;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("recettesIngredient", recetteIngredientService.findAll());
		return "recetteIngredient/recetteIngredients";
	}
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		recetteIngredientService.deleteById(id);
		return "redirect:/recetteIngredient";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new RecetteIngredient(), model);
	}
	
	private String goForm(RecetteIngredient recetteIngredient, Model model) {
		model.addAttribute("recetteIngredient", recetteIngredient);
		return "recetteIngredient/edit";
	}
	
}