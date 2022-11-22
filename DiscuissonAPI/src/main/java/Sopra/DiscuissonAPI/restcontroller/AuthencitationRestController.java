package Sopra.DiscuissonAPI.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Sopra.DiscuissonAPI.model.Compte;
import Sopra.DiscuissonAPI.model.JsonViews;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthencitationRestController {

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Compte authentication(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
