package perso.persoEshopSpringMVC.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.expr.NewArray;
import perso.persoeshopspringback.model.Achat;
import perso.persoeshopspringback.model.Client;
import perso.persoeshopspringback.model.Produit;
import perso.persoeshopspringback.service.AchatService;
import perso.persoeshopspringback.service.ClientService;
import perso.persoeshopspringback.service.ProduitService;

@Controller
@RequestMapping("/achat")
public class AchatController {
	@Autowired
	private AchatService _achatService;
	@Autowired
	private ClientService _clientService;
	@Autowired
	private ProduitService _produitService;
	
	@GetMapping("")
	private String achat(Model model, HttpSession httpSession) {
		model.addAttribute("produits",_produitService.findAll());
		return "achat/achats";
	}
	
	@GetMapping("/ajouterQuantite/{id}")
	private String ajouterQuantite(@PathVariable Integer id, Model model, HttpSession httpSession) {
		Produit produit = _produitService.findById(id);
		if (httpSession.getAttribute("panier")==null) {
			httpSession.setAttribute("panier", new HashMap<Produit,Integer>());
		}
		Map<Produit,Integer> panier = (Map<Produit, Integer>) httpSession.getAttribute("panier");
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + 1);
		}
		else {
			panier.put(produit, 1);
		}
		return "redirect:/achat";
	}
	
	@GetMapping("/supprimerQuantite/{id}")
	private String supprimerQuantite(@PathVariable Integer id, Model model, HttpSession httpSession) {
		Produit produit = _produitService.findById(id);
		Map<Produit,Integer> panier = (Map<Produit, Integer>) httpSession.getAttribute("panier");
		if (panier.get(produit) > 1) {
			panier.put(produit, panier.get(produit) - 1);
		}
		else {
			panier.remove(produit);
		}
		return "redirect:/achat";
	}
	
	@GetMapping("/validerCommande")
	private String validerCommande(HttpSession httpSession, Model model) {
		model.addAttribute("user", new Client());
		model.addAttribute("clients", _clientService.findAll());
		return "achat/validerPanier";
	}
	
	@GetMapping("/nouveauClient")
	public String nouveauClient(Model model) {
		model.addAttribute("user", new Client());
		return "achat/nouveauClient";
	}
	
	@PostMapping("/ajouterClient")
	public String ajouterClient(HttpSession httpSession, Model model, @ModelAttribute("user") Client client) {
		_clientService.create(client);
		return validerCommande(httpSession, model);
	}
	
	@PostMapping("")
	public String sauvegarderPanier(HttpSession httpSession, Model model, @ModelAttribute("user") Client client) {
		Map<Produit,Integer> panier = (Map<Produit, Integer>) httpSession.getAttribute("panier");
		for (Produit obj : _produitService.findAll() ) {
			if (panier.get(obj) != null) {
				_achatService.create(new Achat(client, obj, panier.get(obj)));
			}
		}
		httpSession.invalidate();
		return "redirect:/achat";
	}
}
