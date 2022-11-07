package perso.persoEshopSpringMVC.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		model.addAttribute("fournisseurs", ingredientService.findAll());
		return "ingredient/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		ingredientService.deleteById(id);
		return "redirect:/ingredient";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Ingredient());
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		return goEdit(model, ingredientService.findById(id));
	}
	
	private String goEdit(Model model,Ingredient ingredient) {
		model.addAttribute("ingredient", ingredient);
		return "fournisseur/edit";
	}
	
	@PostMapping("")
	public String save(@Valid @ModelAttribute Ingredient ingredient,BindingResult br,Model model) {
		System.out.println(br);
		if (br.hasErrors()) {
			return goEdit(model, ingredient);
		}
		ingredientService.save(ingredient);
		return "redirect:/ingredient";
	}
}
