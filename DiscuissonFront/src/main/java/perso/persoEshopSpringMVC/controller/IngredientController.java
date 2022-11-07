package ajc.sopra.eshop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Ingredient;
import service.IngredientService;



@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("ingredient", ingredientService.findAll());
		return "ingredient/ingredients";
	}
	
	
	
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		ingredientService.deleteById(id);
		return "redirect:/ingredient";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Ingredient(), model);
	}
	
	private String goForm(Ingredient ingredient, Model model) {
		model.addAttribute("ingredient", ingredient);
		return "ingredient/edit";
	}
	
}