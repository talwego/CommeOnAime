package perso.persoEshopSpringMVC.restcontroller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import perso.persoeshopspringback.model.Client;
import perso.persoeshopspringback.model.JsonViews;
import perso.persoeshopspringback.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	@Autowired
	private ClientService _clientService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Client findById(@PathVariable Integer id) {
		return _clientService.findById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Client> findAll() {
		return _clientService.findAll();
	}
	
	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public Client inscription(@Valid @RequestBody Client client, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "entree pas valide");
		}
		return _clientService.create(client);
	}
}
