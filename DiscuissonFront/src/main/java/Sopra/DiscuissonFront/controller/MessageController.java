package Sopra.DiscuissonFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Message;
import service.MessageService;
import service.UserService;

	@Controller
	@RequestMapping("/message")
	public class MessageController {

		@Autowired
		private MessageService messageSrv;
		@Autowired
		private UserService userSrv;
		
		private String goForm(Message message, Model model) {
			model.addAttribute("message", message);
			return "message/edit";
		}
		
		@GetMapping("")
		public String list(Model model) {
			model.addAttribute("messages", messageSrv.findAll());
			return "message/list";
		}
		
		@GetMapping("/add")
		public String add(Model model) {
			return goForm(new Message(), model);
		}
		
		@GetMapping("/edit")
		public String edit(@RequestParam Integer id, Model model) {
			return goForm(messageSrv.findById(id), model);
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam Integer id, Model model) {
			messageSrv.deleteById(id);
			return "redirect:/message";
		}
		
		@PostMapping("")
		public String save(@ModelAttribute Message message, BindingResult br, Model model) {
			if (br.hasErrors()) {
				return goForm(message, model);
			}
			messageSrv.save(message);
			return "redirect:/message";
		}
	}
