package Sopra.DiscuissonAPI.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import Sopra.DiscuissonAPI.model.JsonViews;
import Sopra.DiscuissonAPI.model.User;
import Sopra.DiscuissonAPI.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userSrv;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<User> findAll() {
		return userSrv.findAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		return userSrv.findById(id);
	}


	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public User create(@RequestBody User user, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return userSrv.save(user);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public User update(@RequestBody User user, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && userSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return userSrv.save(user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteId(@PathVariable Integer id) {
		userSrv.deleteId(id);
	}
}