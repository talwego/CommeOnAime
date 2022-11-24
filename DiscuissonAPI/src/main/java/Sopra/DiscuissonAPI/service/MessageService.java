package Sopra.DiscuissonAPI.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.exception.MessageException;
import Sopra.DiscuissonAPI.exception.RecetteIngredientException;
import Sopra.DiscuissonAPI.model.Compte;
import Sopra.DiscuissonAPI.model.Ingredient;
import Sopra.DiscuissonAPI.model.Message;
import Sopra.DiscuissonAPI.model.Nutritionist;
import Sopra.DiscuissonAPI.model.User;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.model.RecetteIngredient;
import Sopra.DiscuissonAPI.repository.MessageRepository;
import Sopra.DiscuissonAPI.repository.RecetteRepository;
import Sopra.DiscuissonAPI.repository.CompteRepository;
import net.bytebuddy.asm.Advice.Return;

@Service
public class MessageService {
		
		@Autowired
		private MessageRepository messageRepo;
		@Autowired
		private CompteRepository compteRepo;
		
		
		public List<Message> findAll(){
			return messageRepo.findAll();
		}

		public Message findById(Integer id) {
			return messageRepo.findById(id).orElseThrow(()->{
				throw new MessageException("id inconnu");
			});
		}
		
		public List<Message> findByUserQuiVoit(Integer id) {
			return messageRepo.findByUserQuiVoit(id);
		}
		
		public Message create(String text, int idEnvoyeur, int idRecepteur) {
			Compte envoyeur = compteRepo.findById(idEnvoyeur).orElseThrow(()->{
				throw new MessageException("envoyeur inconnu");
			});
			Compte recepteur = compteRepo.findById(idRecepteur).orElseThrow(()->{
				throw new MessageException("recepteur inconnu");
			});
			return save(new Message(text, envoyeur, recepteur));
		
		}
		
		
		public Message create(Message message) {
			if (message.getId() != null) {
				throw new MessageException("Message deja dans la base");
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


