package Sopra.DiscuissonFront.restcontroller;

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
import service.MessageService;
import service.UserService;

@RestController
@RequestMapping("/api/message")
public class MessageRestController {

	@Autowired
	private MessageService messageSrv;
	@Autowired
	private UserService userSrv;	

	@JsonView(JsonViews.MessageWithUser.class)
	@GetMapping("/{id}")
	public Message findById(@PathVariable Integer id) {
		return messageSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Message> findAll() {
		return messageSrv.findAll();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Message create(@RequestBody Message message, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		if (message.getUser() != null && message.getUser().getId() != null) {
			message.setUser(userSrv.findById(message.getUser().getId()));
		}
		return messageSrv.create(message);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			messageSrv.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.MessageWithUser.class)
	public Message update(@RequestBody Message message, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		message.setId(id);
		return messageSrv.update(message);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.MessageWithUser.class)
	public Message update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Message message = messageSrv.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("message")) {
				Map<String, Object> map = (Map<String, Object>) v;
				message.setUser(messageSrv.findById(Integer.parseInt(map.get("id").toString())));
			} else {
				Field field = ReflectionUtils.findField(Message.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, message, v);
			}
		});

		return messageSrv.update(message);
	}
	
}
