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

import perso.persoeshopspringback.model.Adresse;
import perso.persoeshopspringback.model.Fournisseur;
import perso.persoeshopspringback.model.JsonViews;
import perso.persoeshopspringback.service.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {
	@Autowired
	private FournisseurService _fournisseurService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Fournisseur findById(@PathVariable Integer id) {
		return _fournisseurService.findById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Fournisseur> findAll() {
		return _fournisseurService.findAll();
	}
	
	@JsonView(JsonViews.FournisseurWithProduits.class)
	@GetMapping("/{id}/produit")
	public Fournisseur findByIdWithProduit(@PathVariable Integer id) {
		return _fournisseurService.findByIdFetchProduits(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/create")
	@JsonView(JsonViews.Common.class)
	public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		return _fournisseurService.create(fournisseur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			_fournisseurService.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Fournisseur update(@Valid @RequestBody Fournisseur fournisseur, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		fournisseur.setId(id);
		return _fournisseurService.update(fournisseur);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Fournisseur update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Fournisseur fournisseur = _fournisseurService.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				Adresse adresse = new Adresse();
				Map<String,Integer> map = (Map<String, Integer>) v;
				map.forEach((k2,v2)->{
					Field field2 = ReflectionUtils.findField(Adresse.class, k2);
					ReflectionUtils.makeAccessible(field2);
					ReflectionUtils.setField(field2, adresse, v2);
				});
				fournisseur.setAdresse(adresse);
			} else {
				Field field = ReflectionUtils.findField(Fournisseur.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, fournisseur, v);
			}
		});
		return _fournisseurService.update(fournisseur);
	}
}
