package perso.persoEshopSpringMVC.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.AdminService;
import service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userSrv;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("admins", userSrv.findAll());
		return "user/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		userSrv.deleteId(id);
		return "redirect:/user";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new User());
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		return goEdit(model, userSrv.findById(id));
	}
	
	private String goEdit(Model model, User user) {
		model.addAttribute("admin", user);
		return "user/edit";
	}
	
	@PostMapping("")
	public String save(@Valid @ModelAttribute User user,BindingResult br,Model model) {
		System.out.println(br);
		if(br.hasErrors()) {
			return goEdit(model, user);
		}
		userSrv.save(user);
		return "redirect:/user";
	}
	
}
