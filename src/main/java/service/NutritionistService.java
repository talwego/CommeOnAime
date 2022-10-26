package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdException;
import exception.MessageException;
import exception.NutritionistException;
import model.Nutritionist;
import repository.MessageRepository;
import repository.NutritionistRepository;


	@Service
	public class NutritionistService {
			
			@Autowired
			private NutritionistRepository nutritionistRepo;
			
			@Autowired
			private MessageRepository messageRepo;
			
			public List<Nutritionist> findAll(){
				return nutritionistRepo.findAll();
			}

			public Nutritionist findById(Integer id) {
				return nutritionistRepo.findById(id).orElseThrow(()->{
					throw new NutritionistException("id inconnu");
				});
			}
			
			public Nutritionist findByIdFetch(Integer id) {
				return nutritionistRepo.findByIdFetchMessage(id).orElseThrow(()->{
					throw new NutritionistException("id inconnu");
				});
			}
			
			public Nutritionist create(Nutritionist nutritionist) {
				if (nutritionist.getId() != null) {
					throw new MessageException("Nutritionist deja dans la base");
				}				
				return save(nutritionist);
			}

			public Nutritionist update(Nutritionist nutritionist) {
				if (nutritionist.getId() == null || !nutritionistRepo.existsById(nutritionist.getId())) {
					throw new IdException();
				}
				return save(nutritionist);
			}

			private Nutritionist save(Nutritionist nutritionist) {
				return nutritionistRepo.save(nutritionist);
			}

			public void delete(Nutritionist nutritionist) {
				nutritionistRepo.delete(nutritionist);
			}
					
						
			public void deleteById(Integer id) {
				delete(findById(id));
			}
			
		
		}


