package Sopra.DiscuissonAPI.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Sopra.DiscuissonAPI.model.Admin;
import Sopra.DiscuissonAPI.service.AdminService;



@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminSrv;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("admins", adminSrv.findAll());
		return "admin/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		adminSrv.deleteId(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Admin());
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		return goEdit(model, adminSrv.findById(id));
	}
	
	private String goEdit(Model model, Admin admin) {
		model.addAttribute("admin", admin);
		return "admin/edit";
	}
	
	@PostMapping("")
	public String save(@ModelAttribute Admin admin,BindingResult br,Model model) {
		System.out.println(br);
		if(br.hasErrors()) {
			return goEdit(model, admin);
		}
		adminSrv.save(admin);
		return "redirect:/admin";
	}
	
}
