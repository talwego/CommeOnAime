package perso.persoEshopSpringMVC.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import perso.persoeshopspringback.model.Fournisseur;
import perso.persoeshopspringback.service.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
	@Autowired
	private FournisseurService _fournisseurService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("fournisseurs", _fournisseurService.findAll());
		return "fournisseur/fournisseurs";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		_fournisseurService.deleteById(id);
		return "redirect:/fournisseur";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Fournisseur());
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		return goEdit(model, _fournisseurService.findById(id));
	}

	private String goEdit(Model model, Fournisseur fournisseur) {
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/edit";
	}

	@PostMapping("")
	public String save(@Valid @ModelAttribute Fournisseur fournisseur, BindingResult br, Model model) {
		System.out.println(br);
		if (br.hasErrors()) {
			return goEdit(model, fournisseur);
		}
		_fournisseurService.save(fournisseur);
		return "redirect:/fournisseur";
	}
}
