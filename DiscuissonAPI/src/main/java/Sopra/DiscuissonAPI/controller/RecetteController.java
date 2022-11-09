package Sopra.DiscuissonAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.service.RecetteService;



@Controller
@RequestMapping("/recette")
public class RecetteController {
	
	@Autowired
	private RecetteService recetteService;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("recettes", recetteService.findAll());
		return "recette/recettes";
	}
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		recetteService.deleteById(id);
		return "redirect:/recette";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Recette(), model);
	}
	
	private String goForm(Recette recette, Model model) {
		model.addAttribute("recette", recette);
		return "recette/edit";
	}
	
}