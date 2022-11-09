package Sopra.DiscuissonAPI.BDD;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import Sopra.DiscuissonAPI.model.Admin;
import Sopra.DiscuissonAPI.model.Genre;
import Sopra.DiscuissonAPI.model.Nutritionist;
import Sopra.DiscuissonAPI.model.User;
import Sopra.DiscuissonAPI.service.AdminService;
import Sopra.DiscuissonAPI.service.NutritionistService;
import Sopra.DiscuissonAPI.service.UserService;

@SpringBootTest
public class UpdatePersonnesBDD {
	@Autowired
	private UserService _userService;
	@Autowired
	private AdminService _adminService;
	@Autowired
	private NutritionistService _nutritionistService;
	
	@Test
	@Transactional
	@Commit
	public void updatePersonnesBDD() {
	
	/********************Users*******************/
	
		User _user = new User();
	

		
		_user.setId(null);
		_user.setLogin("Rachel");
		_user.setPassword("bernadette1");
		_user.setGenre(Genre.femme);
		_user.setAge(27);
		_user.setTaille(175);
		_user.setPoids(70);
		_user.setCompteVIP(true);
		_user.setVegetarien(false);
		_user.setVegan(false);
		_user.setMessages(null);
		_user = _userService.create(_user);

		User _user1 = new User();
		_user1.setId(null);
		_user1.setLogin("Phoebe");
		_user1.setPassword("bernadette2");
		_user1.setGenre(Genre.femme);
		_user1.setAge(26);
		_user1.setTaille(170);
		_user1.setPoids(60);
		_user1.setCompteVIP(false);
		_user1.setVegetarien(true);
		_user1.setVegan(false);
		_user1.setMessages(null);
		_user1 = _userService.create(_user1);
		
		
		User _user2 = new User();

		_user2.setId(null);
		_user2.setLogin("Joey");
		_user2.setPassword("bernadette3");
		_user2.setGenre(Genre.homme);
		_user2.setAge(28);
		_user2.setTaille(170);
		_user2.setPoids(60);
		_user2.setCompteVIP(false);
		_user2.setVegetarien(false);
		_user2.setVegan(false);
		_user2.setMessages(null);
		_user2 = _userService.create(_user2);
		
		
		User _user3 = new User();

		_user3.setId(null);
		_user3.setLogin("Ross");
		_user3.setPassword("bernadette4");
		_user3.setGenre(Genre.homme);
		_user3.setAge(29);
		_user3.setTaille(185);
		_user3.setPoids(75);
		_user3.setCompteVIP(false);
		_user3.setVegetarien(false);
		_user3.setVegan(true);
		_user3.setMessages(null);
		_user3 = _userService.create(_user3);
		
		
		User _user4 = new User();

		_user4.setId(null);
		_user4.setLogin("Monica");
		_user4.setPassword("bernadette5");
		_user4.setGenre(Genre.femme);
		_user4.setAge(27);
		_user4.setTaille(170);
		_user4.setPoids(65);
		_user4.setCompteVIP(true);
		_user4.setVegetarien(false);
		_user4.setVegan(false);
		_user4.setMessages(null);
		_user4 = _userService.create(_user4);
		
		User _user5 = new User();

		_user5.setId(null);
		_user5.setLogin("Chandler");
		_user5.setPassword("bernadette6");
		_user5.setGenre(Genre.homme);
		_user5.setAge(28);
		_user5.setTaille(190);
		_user5.setPoids(100);
		_user5.setCompteVIP(true);
		_user5.setVegetarien(false);
		_user5.setVegan(false);
		_user5.setMessages(null);
		_user5 = _userService.create(_user5);
		
		/********************Admins*******************/
		Admin _admin1 = new Admin();
		
		
		_admin1.setId(null);
		_admin1.setLogin("lapin");
		_admin1.setPassword("carotte");
		_admin1 = _adminService.create(_admin1);

		Admin _admin2 = new Admin();
		_admin2.setId(null);
		_admin2.setLogin("chat");
		_admin2.setPassword("raisin");
		_admin2 = _adminService.create(_admin2);

		
		/********************Nutritionist*******************/
		Nutritionist _nutritionist = new Nutritionist();
		/* Nutritioniste 1 */
		_nutritionist.setId(null);
		_nutritionist.setLogin("DrFAIM");
		_nutritionist.setPassword("raclette");
		_nutritionist.setMessages(null);
		_nutritionist = _nutritionistService.create(_nutritionist);


		
	}

	
}
