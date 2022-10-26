package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.MessageException;
import model.Message;
import repository.MessageRepository;
import repository.NutritionistRepository;
import repository.UserRepository;

@Service
public class MessageService {
		
		@Autowired
		private MessageRepository messageRepo;
		
		
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

		private Message save(Message message) {
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


