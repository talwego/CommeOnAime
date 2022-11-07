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

import model.JsonViews;
import model.Message;
import model.Nutritionist;
import service.NutritionistService;

@RestController
@RequestMapping("/api/nutritionist")
public class NutritionistRestController {

	@Autowired
	private NutritionistService nutritionistSrv;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Nutritionist> findAll() {
		return nutritionistSrv.findAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Nutritionist findById(@PathVariable Integer id) {
		return nutritionistSrv.findById(id);
	}

	@JsonView(JsonViews.NutritionistWithMessage.class)
	@GetMapping("/{id}/message")
	public Nutritionist findByIdWithMessage(@PathVariable Integer id) {
		return nutritionistSrv.findByIdFetchMessage(id);
	}

	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Nutritionist create(@RequestBody Nutritionist nutritionist, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return nutritionistSrv.save(nutritionist);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Nutritionist update(@RequestBody Nutritionist nutritionist, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && nutritionistSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return nutritionistSrv.save(nutritionist);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Nutritionist patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Nutritionist nutritionist = nutritionistSrv.findById(id);
		fields.forEach((l, w) -> {
			if (l.equals("message")) {
				Map<String, Object> mapMessage = (Map<String, Object>) w;
				mapMessage.forEach((lMessage, wMessage) -> {
					Field fieldMessage = ReflectionUtils.findField(Message.class, lMessage);
					ReflectionUtils.makeAccessible(fieldMessage);
					ReflectionUtils.setField(fieldMessage, nutritionist.getMessage(), wMessage);
				});
			} else {
				Field field = ReflectionUtils.findField(Nutritionist.class, l);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, nutritionist, w);
			}
		});
		return nutritionistSrv.save(nutritionist);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		nutritionistSrv.deleteById(id);
	}
}
