package Sopra.DiscuissonAPI.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.exception.MessageException;
import Sopra.DiscuissonAPI.exception.RecetteIngredientException;
import Sopra.DiscuissonAPI.model.Ingredient;
import Sopra.DiscuissonAPI.model.Message;
import Sopra.DiscuissonAPI.model.Nutritionist;
import Sopra.DiscuissonAPI.model.User;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.repository.MessageRepository;
import Sopra.DiscuissonAPI.repository.NutritionistRepository;
import Sopra.DiscuissonAPI.repository.RecetteRepository;
import Sopra.DiscuissonAPI.repository.UserRepository;
import net.bytebuddy.asm.Advice.Return;

@Service
public class MessageService {
		
		@Autowired
		private MessageRepository messageRepo;
		@Autowired
		private NutritionistRepository nutritionistRepo;
		@Autowired
		private UserRepository userRepo;
		
		
		public List<Message> findAll(){
			return messageRepo.findAll();
		}
		
		public Message findByDateMessageDate(LocalDate dateMessageDate) {
			return messageRepo.findByDateMessageDate(dateMessageDate).orElseThrow(()->{
				throw new MessageException("Date inconnu");
			});
		}

		public Message findById(Integer id) {
			return messageRepo.findById(id).orElseThrow(()->{
				throw new MessageException("id inconnu");
			});
		}
		
		public Message create(String sujet, String text, LocalDate dateMessage, int idNutritionnist, int idUser) {
			Nutritionist nutritionist = nutritionistRepo.findById(idNutritionnist).orElseThrow(()->{
				throw new MessageException("nutritionniste inconnu");
			});
			User user = userRepo.findById(idUser).orElseThrow(()->{
				throw new MessageException("user inconnu");
			});
			return save(new Message(sujet, text, dateMessage, nutritionist, user));
		
		}
		
		
		public Message create(Message message) {
			if (message.getId() != null) {
				throw new MessageException("Message deja dans la base");
			}
			if(message.getSujet()==null||message.getSujet().isBlank()) {

				throw new MessageException("Sujet obligatoire");
			}
			if(message.getText()==null||message.getText().isBlank()) {
				throw new MessageException("Text obligatoire");
			}
			return save(message);
		}

		public Message update(Message message) {
			if (message.getId() == null || !messageRepo.existsById(message.getId())) {
				throw new IdException();
			}
			return save(message);
		}

		public Message save(Message message) {
			if (message.getSujet() == null || message.getSujet().isBlank() || message.getSujet().length() > 30) {
				throw new MessageException("Probleme sujet");
			}
			if (message.getText() == null || message.getText().isBlank()){
				throw new MessageException("Probleme text");
			}
			return messageRepo.save(message);
		}

		public void delete(Message message) {
			messageRepo.delete(message);
		}
				
					
		public void deleteById(Integer id) {
			delete(findById(id));
		}
		
	
	}


