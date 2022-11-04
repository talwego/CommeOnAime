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

import perso.persoeshopspringback.model.Produit;
import perso.persoeshopspringback.service.FournisseurService;
import perso.persoeshopspringback.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService _produitService;
	@Autowired
	private FournisseurService _fournisseurService;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", _produitService.findAll());
		return "produit/produits";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		_produitService.deleteById(id);
		return "redirect:/produit";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		return goForm(_produitService.findById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Produit(), model);
	}

	private String goForm(Produit produit, Model model) {
		model.addAttribute("produit", produit);
		model.addAttribute("fournisseurs", _fournisseurService.findAll());
		return "produit/edit";
	}
	
	@PostMapping("")
	public String save(@Valid @ModelAttribute Produit produit, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return goForm(produit, model);
		}
		if (produit.getId() == null) {
			_produitService.create(produit);
		} else {
			_produitService.update(produit);
		}
		return "redirect:/produit";
	}
}
