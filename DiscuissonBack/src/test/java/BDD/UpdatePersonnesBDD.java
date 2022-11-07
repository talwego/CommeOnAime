package BDD;

import java.time.LocalTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JpaConfig;
import model.Admin;
import model.Genre;
import model.Nutritionist;
import model.User;
import service.AdminService;
import service.NutritionistService;
import service.UserService;

public class UpdatePersonnesBDD {
	public static void main(String[] args) {
	
	
	/********************Users*******************/
	
		AnnotationConfigApplicationContext _ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		UserService _userService = _ctx.getBean(UserService.class);
		User _user = new User();
	

		/* User 1 */
		_user.setId(null);
		_user.setLogin("Rachel");
		_user.setPassword("bernadette");
		_user.setGenre(Genre.femme);
		_user.setAge(27);
		_user.setTaille(175);
		_user.setPoids(70);
		_user.setCompteVIP(true);
		_user.setVegetarien(false);
		_user.setVegan(false);
		_user.setMessages(null);
		_user = _userService.create(_user);
		
		/* User 2 */
		_user.setId(null);
		_user.setLogin("Phoebe");
		_user.setPassword("bernadette");
		_user.setGenre(Genre.femme);
		_user.setAge(26);
		_user.setTaille(170);
		_user.setPoids(60);
		_user.setCompteVIP(false);
		_user.setVegetarien(true);
		_user.setVegan(false);
		_user.setMessages(null);
		_user = _userService.create(_user);
		
		/* User 4 */
		_user.setId(null);
		_user.setLogin("Joey");
		_user.setPassword("bernadette");
		_user.setGenre(Genre.homme);
		_user.setAge(28);
		_user.setTaille(170);
		_user.setPoids(60);
		_user.setCompteVIP(false);
		_user.setVegetarien(false);
		_user.setVegan(false);
		_user.setMessages(null);
		_user = _userService.create(_user);
		
		/* User 5 */
		_user.setId(null);
		_user.setLogin("Ross");
		_user.setPassword("bernadette");
		_user.setGenre(Genre.homme);
		_user.setAge(29);
		_user.setTaille(185);
		_user.setPoids(75);
		_user.setCompteVIP(false);
		_user.setVegetarien(false);
		_user.setVegan(true);
		_user.setMessages(null);
		_user = _userService.create(_user);
		
		/* User 6 */
		_user.setId(null);
		_user.setLogin("Monica");
		_user.setPassword("bernadette");
		_user.setGenre(Genre.femme);
		_user.setAge(27);
		_user.setTaille(170);
		_user.setPoids(65);
		_user.setCompteVIP(true);
		_user.setVegetarien(false);
		_user.setVegan(false);
		_user.setMessages(null);
		_user = _userService.create(_user);
		
		/* User 7 */
		_user.setId(null);
		_user.setLogin("Chandler");
		_user.setPassword("bernadette");
		_user.setGenre(Genre.homme);
		_user.setAge(28);
		_user.setTaille(190);
		_user.setPoids(100);
		_user.setCompteVIP(true);
		_user.setVegetarien(false);
		_user.setVegan(false);
		_user.setMessages(null);
		_user = _userService.create(_user);
		
		/********************Admins*******************/
		AdminService _adminService = _ctx.getBean(AdminService.class);
		Admin _admin = new Admin();
		
		/* Admins 1 */
		_admin.setId(null);
		_admin.setLogin("lapin");
		_admin.setPassword("carotte");
		_admin = _adminService.create(_admin);

		/* Admins 2 */
		_admin.setId(null);
		_admin.setLogin("chat");
		_admin.setPassword("raisin");
		_admin = _adminService.create(_admin);

		
		/********************Nutritionist*******************/
		NutritionistService _nutritionistService = _ctx.getBean(NutritionistService.class);
		Nutritionist _nutritionist = new Nutritionist();
		/* Nutritioniste 1 */
		_nutritionist.setId(null);
		_nutritionist.setLogin("DrFAIM");
		_nutritionist.setPassword("raclette");
		_nutritionist.setMessages(null);
		_nutritionist = _nutritionistService.create(_nutritionist);


		
	}

	
}
