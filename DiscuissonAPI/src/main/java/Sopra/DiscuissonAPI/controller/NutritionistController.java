package Sopra.DiscuissonFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Nutritionist;
import service.NutritionistService;


@Controller
@RequestMapping("/nutritionist")
public class NutritionistController {

	@Autowired
	private NutritionistService nutritionistSrv;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("nutritionist", nutritionistSrv.findAll());
		return "nutritionist/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		nutritionistSrv.deleteById(id);
		return "redirect:/nutritionist";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Nutritionist());
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		return goEdit(model, nutritionistSrv.findById(id));
	}
	
	private String goEdit(Model model,Nutritionist nutritionist) {
		model.addAttribute("nutritionist", nutritionist);
		return "nutritionist/edit";
	}
	
	@PostMapping("")
	public String save(@ModelAttribute Nutritionist nutritionist,BindingResult br,Model model) {
		System.out.println(br);
		if(br.hasErrors()) {
			return goEdit(model, nutritionist);
		}
		nutritionistSrv.save(nutritionist);
		return "redirect:/nutritionist";
	}
	
}
