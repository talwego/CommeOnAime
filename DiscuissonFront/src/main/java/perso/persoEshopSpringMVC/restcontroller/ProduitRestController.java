package perso.persoEshopSpringMVC.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import perso.persoeshopspringback.model.JsonViews;
import perso.persoeshopspringback.model.Produit;
import perso.persoeshopspringback.service.FournisseurService;
import perso.persoeshopspringback.service.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {
	@Autowired
	private ProduitService _produitService;
	@Autowired
	private FournisseurService _fournisseurService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit findById(@PathVariable Integer id) {
		return _produitService.findById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public List<Produit> findAll() {
		return _produitService.findAll();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		if (produit.getFournisseur() != null && produit.getFournisseur().getId() != null) {
			produit.setFournisseur(_fournisseurService.findById(produit.getFournisseur().getId()));
		}
		return _produitService.create(produit);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			_produitService.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit update(@Valid @RequestBody Produit produit, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		produit.setId(id);
		return _produitService.update(produit);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Produit produit = _produitService.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("fournisseur")) {
				Map<String, Object> map = (Map<String, Object>) v;
				produit.setFournisseur(_fournisseurService.findById(Integer.parseInt(map.get("id").toString())));
			} else {
				Field field = ReflectionUtils.findField(Produit.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, produit, v);
			}
		});
		return _produitService.update(produit);
	}
}
