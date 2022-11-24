package Sopra.DiscuissonAPI.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import Sopra.DiscuissonAPI.model.Compte;
import Sopra.DiscuissonAPI.model.JsonViews;
import Sopra.DiscuissonAPI.model.Message;
import Sopra.DiscuissonAPI.service.CompteService;
import Sopra.DiscuissonAPI.service.MessageService;


@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = {"*"})
public class CompteRestController {
	
	@Autowired
	private MessageService messageSrv;
	@Autowired
	private CompteService compteSrv;
	
	
	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public Compte inscription(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compteSrv.save(compte);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> findAll() {
		return compteSrv.findAll();
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Compte findById(@PathVariable Integer id) {
		return compteSrv.findById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Compte create(@RequestBody Compte compte) {
		System.out.println(compte);
		return compteSrv.save(compte);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public void deleteById(@PathVariable Integer id) {
		compteSrv.deleteId(id);
		}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Message update(@RequestBody Message message) {
	
		return messageSrv.update(message);
	}
	
		
	
	
	
}