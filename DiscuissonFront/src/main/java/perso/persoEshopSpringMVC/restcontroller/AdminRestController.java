package perso.persoEshopSpringMVC.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


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


import perso.persoEshopSpringMVC.controller.JsonViews;
import model.Admin;
import service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
	private AdminService adminSrv;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Admin> findAll() {
		return adminSrv.findAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Admin findById(@PathVariable Integer id) {
		return adminSrv.findById(id);
	}


	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Admin create(@RequestBody Admin admin, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminSrv.save(admin);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin update(@RequestBody Admin admin, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && adminSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminSrv.save(admin);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteId(@PathVariable Integer id) {
		adminSrv.deleteId(id);
	}
}
