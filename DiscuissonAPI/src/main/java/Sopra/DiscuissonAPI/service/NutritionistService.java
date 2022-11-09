package Sopra.DiscuissonAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Sopra.DiscuissonAPI.exception.AdminException;
import Sopra.DiscuissonAPI.exception.IdException;
import Sopra.DiscuissonAPI.exception.MessageException;
import Sopra.DiscuissonAPI.exception.NutritionistException;
import Sopra.DiscuissonAPI.model.Nutritionist;
import Sopra.DiscuissonAPI.repository.NutritionistRepository;


	@Service
	public class NutritionistService {
			
			@Autowired
			private NutritionistRepository nutritionistRepo;
			@Autowired
			private PasswordEncoder passwordEncoder;
			
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
			
			public Nutritionist creation(Nutritionist nutritionist) {
				nutritionist.setPassword(passwordEncoder.encode(nutritionist.getPassword()));
				return create(nutritionist);
			}

			public Nutritionist update(Nutritionist nutritionist) {
				if (nutritionist.getId() == null || !nutritionistRepo.existsById(nutritionist.getId())) {
					throw new IdException();
				}
				return save(nutritionist);
			}

			public Nutritionist save(Nutritionist nutritionist) {
				if (nutritionist.getLogin() == null || nutritionist.getLogin().isBlank() || nutritionist.getLogin().length() > 50) 
				{
					throw new NutritionistException("probleme login");
				}
				if (nutritionist.getPassword() == null || nutritionist.getPassword().isBlank() || nutritionist.getPassword().length() > 255) 
				{
					throw new NutritionistException("probleme password");
				}
				return nutritionistRepo.save(nutritionist);
			}

			public void delete(Nutritionist nutritionist) {
				nutritionistRepo.delete(nutritionist);
			}
					
						
			public void deleteById(Integer id) {
				delete(findById(id));
			}

			public Nutritionist findByIdFetchMessage(Integer id) {
				// TODO Auto-generated method stub
				return null;
			}
			
		
		}


