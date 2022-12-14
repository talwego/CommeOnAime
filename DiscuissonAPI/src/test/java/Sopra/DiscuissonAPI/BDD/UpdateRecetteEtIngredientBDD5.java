package Sopra.DiscuissonAPI.BDD;

import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import Sopra.DiscuissonAPI.model.ActivitePhysique;
import Sopra.DiscuissonAPI.model.Admin;
import Sopra.DiscuissonAPI.model.Genre;
import Sopra.DiscuissonAPI.model.Ingredient;
import Sopra.DiscuissonAPI.model.Nutritionist;
import Sopra.DiscuissonAPI.model.Recette;
import Sopra.DiscuissonAPI.model.Unite;
import Sopra.DiscuissonAPI.model.User;
import Sopra.DiscuissonAPI.service.AdminService;
import Sopra.DiscuissonAPI.service.IngredientService;
import Sopra.DiscuissonAPI.service.InstructionRecetteService;
import Sopra.DiscuissonAPI.service.MessageService;
import Sopra.DiscuissonAPI.service.NutritionistService;
import Sopra.DiscuissonAPI.service.RecetteIngredientService;
import Sopra.DiscuissonAPI.service.RecetteService;
import Sopra.DiscuissonAPI.service.UserService;

/*
 * Code DEGUEULASSE mais normalement fonctionnel
 * PS: Ne pas oublier de se mettre en: create
 * changement de facon de faire...
 * 
 * Source: https://www.fourchette-et-bikini.fr/cuisine/recettes-minceur/15-plats-dhiver-legers-et-gourmands.html
 * https://www.cuisineaz.com/recettes/pate-a-tarte-maison-rapide-36657.aspx
 */

@SpringBootTest
public class UpdateRecetteEtIngredientBDD5 {
	@Autowired
	private UserService _userService;
	@Autowired
	private AdminService _adminService;
	@Autowired
	private NutritionistService _nutritionistService;
	
	@Autowired
	private IngredientService _ingredientService;
	@Autowired
	private RecetteIngredientService _recetteIngredientService;
	@Autowired
	private RecetteService _recetteService;
	@Autowired
	private InstructionRecetteService _instructionRecetteService;
	@Autowired
	private  MessageService _messageService;

	public void updateRecetteWithVeganVegetarien() {
		List<Recette> obj1 = _recetteService.findAll();
		for (int i=0; i<obj1.size(); i++) {
			obj1.get(i).setListeIngredient();
			obj1.get(i).setRegimeRecette();
			obj1.get(i).setDate();
			obj1.get(i).setCalorieAvecListeIngredient();
			_recetteService.update(obj1.get(i));
		}
	}
	
	public void updateMessage() {
		
		_messageService.create("Je veux perdre 10 kilos en 1 semaine", 1, 9);
		_messageService.create("Ca va ??tre compliqu?? madame", 9, 1);
		_messageService.create("noooooooooooooon qhxbezxbjz !!",1, 9);
		
	}

	public void updateCompte() {
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
		_user.setActivitePhysique(ActivitePhysique.peu);
		_user = _userService.creation(_user);

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
		_user1.setActivitePhysique(ActivitePhysique.peu);
		_user1 = _userService.creation(_user1);
		
		
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
		_user2.setActivitePhysique(ActivitePhysique.peu);
		_user2 = _userService.creation(_user2);
		
		
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
		_user3.setActivitePhysique(ActivitePhysique.peu);
		_user3 = _userService.creation(_user3);
		
		
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
		_user4.setActivitePhysique(ActivitePhysique.peu);
		_user4 = _userService.creation(_user4);
		
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
		_user5.setActivitePhysique(ActivitePhysique.peu);
		_user5 = _userService.creation(_user5);
		
		/********************Admins*******************/
		Admin _admin1 = new Admin();
		
		
		_admin1.setId(null);
		_admin1.setLogin("lapin");
		_admin1.setPassword("carotte");
		_admin1 = _adminService.creation(_admin1);

		Admin _admin2 = new Admin();
		_admin2.setId(null);
		_admin2.setLogin("chat");
		_admin2.setPassword("raisin");
		_admin2 = _adminService.creation(_admin2);

		
		/********************Nutritionist*******************/
		Nutritionist _nutritionist = new Nutritionist();
		/* Nutritioniste 1 */
		_nutritionist.setId(null);
		_nutritionist.setLogin("DrFAIM");
		_nutritionist.setPassword("raclette");
		_nutritionist.setMessages(null);
		_nutritionist = _nutritionistService.creation(_nutritionist);
	}
	
	public void updateRecetteEtIngredient() {
		
		//////Commentaires/////
		String comm1 ="Valid?? par la commu";
		String comm2="Valid?? par les modos";
		String comm3 ="Valid?? par la chef";
		String comm4="Valid?? par personne!!";
		
		
		/* Recette 1 */
		_recetteService.create(
				new Recette("Tartiflette sans lardons au gruy??re l??ger", 8, comm1, 3.7, 51, LocalTime.of(1, 30), true));

		/// Ingredient 1 ///
		_ingredientService.create(new Ingredient("Pomme de terre", 73, 1, 12, true, true, Unite.g));
		// RecetteIngredient 1
		_recetteIngredientService.create(1, 1, 1000);

		/// Ingredient 2 ///
		_ingredientService.create(new Ingredient("Jambon maigre", 112, 1, 12, false, false, Unite.g));
		// RecetteIngredient 2
		_recetteIngredientService.create(1, 2, 100);

		/// Ingredient 3 ///
		_ingredientService.create(new Ingredient("Gruyere all??g??", 213, 1, 12, true, false, Unite.g));
		// RecetteIngredient 3
		_recetteIngredientService.create(1, 3, 200);

		/// Ingredient 4 ///
		_ingredientService.create(new Ingredient("Oignon", 43, 1, 12, true, true, Unite.g));
		// RecetteIngredient 4
		_recetteIngredientService.create(1, 4, 300);

		/// Ingredient 5 ///
		_ingredientService.create(new Ingredient("Cr??me fra??che l??g??re", 192, 1, 12, true, false, Unite.mL));
		// RecetteIngredient 5
		_recetteIngredientService.create(1, 5, 100);

		// -- Instruction 1 --//
		_instructionRecetteService.create(1, "Pr??chauffez le four ?? 210 degr??s");
		// -- Instruction 2 --//
		_instructionRecetteService.create(1, "Pelez et coupez les pommes de terre en fines rondelles.");
		// -- Instruction 3 --//
		_instructionRecetteService.create(1, "Pelez et taillez les oignons en fines lamelles.");
		// -- Instruction 4 --//
		_instructionRecetteService.create(1,
				"D??posez une couche de pommes de terre puis une couche d'oignons dans le fond d'un plat ?? gratin.");
		// -- Instruction 5 --//
		_instructionRecetteService.create(1,
				"Recouvrez avec une couche de d??s de jambon puis une couche de gruy??re r??p??.");
		// -- Instruction 6 --//
		_instructionRecetteService.create(1,
				"Red??posez une couche de pommes de terre, une couche d'oignons,..., et ainsi de suite jusqu'?? ??puisement des ingr??dients, en terminant par une couche de pommes de terre.");
		// -- Instruction 7 --//
		_instructionRecetteService.create(1,
				"M??langez si vous le souhaitez, la cr??me fra??che avec du persil cisel??, du sel et du poivre dans un bol.");
		// -- Instruction 8 --//
		_instructionRecetteService.create(1,
				"Versez la cr??me fra??che sur les pommes de terre dans le plat. Parsemez d'un peu de gruy??re r??p??.");
		// -- Instruction 9 --//
		_instructionRecetteService.create(1,
				"Enfournez pendant 1 heure ?? 1h15 de cuisson jusqu'?? ce que la tartiflette soit bien dor??e.");
		// -- Instruction 10 --//
		_instructionRecetteService.create(1, "Servez bien chaud accompagn?? d'une salade verte assaisonn??e.");

		/* Recette 2 */
		_recetteService.create(new Recette("Lasagnes minceur au thon et au parmesan l??ger", 4, comm4, 4.3, 127,
				LocalTime.of(0, 40), true));

		/// Ingredient 6 ///
		_ingredientService.create(new Ingredient("Feuille de lasagnes", 284, 1, 12, true, false, Unite.g));
		// RecetteIngredient 6
		_recetteIngredientService.create(2, 6, 240);

		/// Ingredient 7 ///
		_ingredientService.create(new Ingredient("Thon", 132, 5, 9, false, false, Unite.g));
		// RecetteIngredient 7
		_recetteIngredientService.create(2, 7, 280);

		/// Ingredient 8 ///
		_ingredientService.create(new Ingredient("Sauce tomate", 29, 7, 9, true, true, Unite.g));
		// RecetteIngredient 8
		_recetteIngredientService.create(2, 8, 400);

		// RecetteIngredient 9
		_recetteIngredientService.create(2, 5, 500);

		// -- Instruction 11 --//
		_instructionRecetteService.create(2, "Pr??chauffez le four ?? 180 degr??s.");
		// -- Instruction 12 --//
		_instructionRecetteService.create(2, "Emiettez le thon dans un saladier ?? l'aide d'une fourchette.");
		// -- Instruction 13 --//
		_instructionRecetteService.create(2, "Ajoutez-y la sauce tomate et m??langez bien.");
		// -- Instruction 14 --//
		_instructionRecetteService.create(2, "Placez des feuilles ?? lasagnes dans le fond d'un plat ?? gratin.");
		// -- Instruction 15 --//
		_instructionRecetteService.create(2,
				"Recouvrez avec une couche de cr??me fra??che puis une couche de pr??paration thon-sauce tomate.");
		// -- Instruction 16 --//
		_instructionRecetteService.create(2,
				"Replacez des feuilles ?? lasagnes sur le dessus puis une nouvelle couche de cr??me fra??che et de pr??paration au thon.");
		// -- Instruction 17 --//
		_instructionRecetteService.create(2,
				"R??p??tez l'op??ration jusqu'?? ??puisement des ingr??dients, en terminant par une couche de cr??me fra??che.");
		// -- Instruction 18 --//
		_instructionRecetteService.create(2, "Bonus: Parsemez le plat avec le parmesan r??p??.");
		// -- Instruction 19 --//
		_instructionRecetteService.create(2,
				"Enfournez pendant 30 minutes jusqu'?? ce que les lasagnes soient bien gratin??es.");
		// -- Instruction 20 --//
		_instructionRecetteService.create(2, "Servez bien chaud accompagn?? d'une salade verte assaisonn??e.");

		/* Recette 3 */
		_recetteService.create(new Recette("Dos de cabillaud ?? la cr??me l??g??re ?? l'ail", 4, comm3, 3.9, 55,
				LocalTime.of(0, 30), true));

		/// Ingredient 9 ///
		_ingredientService.create(new Ingredient("Dos de cabillaud", 29, 2, 5, false, false, Unite.g));
		// RecetteIngredient 10
		_recetteIngredientService.create(3, 9, 700);

		/// Ingredient 10 ///
		_ingredientService.create(new Ingredient("Gousse d'ail", 149, 5, 2, true, true, Unite.g));
		// RecetteIngredient 11
		_recetteIngredientService.create(3, 10, 140);

		// RecetteIngredient 12
		_recetteIngredientService.create(3, 5, 200);

		// -- Instruction 21 --//
		_instructionRecetteService.create(3,
				"Epluchez les gousses d'ail. Faites-les cuire pendant 20 minutes dans une casserole d'eau bouillante.");
		// -- Instruction 22 --//
		_instructionRecetteService.create(3,
				"Une fois les gousses d'ail cuites, ??gouttez-les et mixez-les avec la cr??me liquide dans un blender.");
		// -- Instruction 23 --//
		_instructionRecetteService.create(3,
				"Bonus: Ajouter du persil frais. Ajoutez-le au m??lange avec un peu de sel et de poivre. R??servez.");
		// -- Instruction 24 --//
		_instructionRecetteService.create(3,
				"Faites fondre une noix de beurre dans une po??le et faites-y cuire de chaque c??t?? les dos de cabillaud jusqu'?? obtenir la cuisson d??sir??e.");
		// -- Instruction 25 --//
		_instructionRecetteService.create(3,
				"Pendant ce temps, r??chauffez la cr??me ?? l'ail dans une casserole ?? feu doux.");
		// -- Instruction 26 --//
		_instructionRecetteService.create(3,
				"Servez les dos de cabillaud dans les assiettes et nappez-les de cr??me ?? l'ail.");
		// -- Instruction 27 --//
		_instructionRecetteService.create(3, "D??gustez.");

		/* Recette 4 */
		_recetteService.create(new Recette("Quiche l??g??re poulet, champignons et brocoli", 4, comm4, 3.6, 87,
				LocalTime.of(0, 50), true));

		/// Ingredient 11 ///
		_ingredientService.create(new Ingredient("Farine de bl??", 149, 1, 12, true, true, Unite.g));
		// RecetteIngredient 13
		_recetteIngredientService.create(4, 11, 250);

		/// Ingredient 12 ///
		_ingredientService.create(new Ingredient("Beurre", 717, 1, 12, true, false, Unite.g));
		// RecetteIngredient 14
		_recetteIngredientService.create(4, 12, 125);

		/// Ingredient 13 ///
		_ingredientService.create(new Ingredient("Eau", 0, 1, 12, true, true, Unite.mL));
		// RecetteIngredient 15
		_recetteIngredientService.create(4, 13, 250);

		/// Ingredient 14 ///
		_ingredientService.create(new Ingredient("Blanc de poulet", 120, 1, 12, true, true, Unite.g));
		// RecetteIngredient 16
		_recetteIngredientService.create(4, 14, 500);

		/// Ingredient 15 ///
		_ingredientService.create(new Ingredient("Brocoli", 34, 9, 11, true, true, Unite.g));
		// RecetteIngredient 17
		_recetteIngredientService.create(4, 15, 300);

		/// Ingredient 16 ///
		_ingredientService.create(new Ingredient("Champignon", 22, 1, 12, true, true, Unite.g));
		// RecetteIngredient 18
		_recetteIngredientService.create(4, 16, 200);

		/// Ingredient 17 ///
		_ingredientService.create(new Ingredient("Oeuf", 22, 1, 12, true, false, Unite.g));
		// RecetteIngredient 19
		_recetteIngredientService.create(4, 17, 180);

		// RecetteIngredient 20
		_recetteIngredientService.create(4, 5, 100);

		// -- Instruction 28 --//
		_instructionRecetteService.create(4, "Faites fondre le beurre avec l???eau dans une casserole ?? feu doux.");
		// -- Instruction 29 --//
		_instructionRecetteService.create(4,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de bl?? et le sucre en poudre (en option).");
		// -- Instruction 30 --//
		_instructionRecetteService.create(4,
				"Malaxez bien le m??lange avec vos mains, pendant plusieurs minutes, jusqu????? obtenir une boule de p??te bien lisse et homog??ne.");
		// -- Instruction 31 --//
		_instructionRecetteService.create(4,
				"Couvrez le saladier avec du film alimentaire et placez la boule de p??te au frais pendant 10 min minimum.");
		// -- Instruction 32 --//
		_instructionRecetteService.create(4,
				"C'est pr??t ! D??gazez la p??te sur un plan de travail farin??.Pour cela, tapez ??nergiquement sur la p??te pour en enlever le gaz carbonique emprisonn?? dans les bulles d'air.");
		// -- Instruction 33 --//
		_instructionRecetteService.create(4,
				"Puis ??talez-la ?? l'aide d'un rouleau ?? p??tisserie. D??posez ensuite votre fond de tarte dans un plat ?? tarte recouvert de papier sulfuris?? et piquez son fond avec une fourchette.");

		// -- Instruction 34 --//
		_instructionRecetteService.create(4, "Pr??chauffez le four ?? 220??C.");
		// -- Instruction 35 --//
		_instructionRecetteService.create(4, "Foncez la p??te dans un moule ?? tarte recouvert de papier sulfuris??.");
		// -- Instruction 36 --//
		_instructionRecetteService.create(4, "Piquez le fond avec une fourchette. R??servez.");
		// -- Instruction 37 --//
		_instructionRecetteService.create(4, "Coupez les blancs de poulet en morceaux.");
		// -- Instruction 38 --//
		_instructionRecetteService.create(4, "Nettoyez et ??mincez en tranches les champignons de Paris.");
		// -- Instruction 39 --//
		_instructionRecetteService.create(4, "Faites dorer le poulet dans une po??le anti-adh??sive pendant 5 minutes.");
		// -- Instruction 40 --//
		_instructionRecetteService.create(4,
				"Ajoutez les champignons ??minc??s et laissez cuire jusqu'?? ce qu'ils aient rendu leur eau.");
		// -- Instruction 41 --//
		_instructionRecetteService.create(4,
				"Pendant ce temps, faites cuire les fleurons de brocoli dans une casserole d'eau bouillante pendant 10 minutes.");
		// -- Instruction 42 --//
		_instructionRecetteService.create(4, "R??partissez le m??lange poulet-champignons dans le fond de p??te.");
		// -- Instruction 43 --//
		_instructionRecetteService.create(4,
				"Egouttez les fleurons de brocoli et r??partissez-les sur le dessus du m??lange poulet-champignons.");
		// -- Instruction 44 --//
		_instructionRecetteService.create(4,
				"Battez les oeufs avec la cr??me fra??che et le lait dans un bol. Ajoutez du persil cisel?? puis salez et poivrez.");
		// -- Instruction 45 --//
		_instructionRecetteService.create(4, "Versez le m??lange aux oeufs sur la garniture au poulet dans le moule.");
		// -- Instruction 46 --//
		_instructionRecetteService.create(4, "Enfournez la quiche pendant 30 minutes jusqu'?? ce qu'elle soit dor??e.");
		// -- Instruction 47 --//
		_instructionRecetteService.create(4, "D??gustez chaud ou froid accompagn?? d'une salade verte assaisonn??e.");

		/* Recette 5 */
		
				
		_recetteService.create(new Recette("Hachis parmentier sans viande aux l??gumes", 4, comm2, 3.6, 87,
				LocalTime.of(0, 50), true));

		// RecetteIngredient 21
		_recetteIngredientService.create(5, 1, 400);
		/// Ingredient 18 ///
		_ingredientService.create(new Ingredient("Navet", 28, 11, 6, true, true, Unite.g));

		// RecetteIngredient 22
		_recetteIngredientService.create(5, 18, 300);
		/// Ingredient 19 ///
		_ingredientService.create(new Ingredient("Carotte", 41, 1, 12, true, true, Unite.g));

		// RecetteIngredient 23
		_recetteIngredientService.create(5, 19, 375);
		/// Ingredient 20 ///
		_ingredientService.create(new Ingredient("Poireau", 61, 1, 12, true, true, Unite.g));

		// RecetteIngredient 24
		_recetteIngredientService.create(5, 20, 160);

		// RecetteIngredient 25
		_recetteIngredientService.create(5, 4, 300);

		// RecetteIngredient 26
		_recetteIngredientService.create(5, 10, 7);

		// -- Instruction 48 --//
		_instructionRecetteService.create(5,
				"Pelez et coupez en morceaux les carottes, le navet, les branches de c??leri, les oignons et l'ail.");
		// -- Instruction 49 --//
		_instructionRecetteService.create(5,
				"Mixez les l??gumes dans un blender jusqu'?? obtenir un hachis bien homog??ne. R??servez.");
		// -- Instruction 50 --//
		_instructionRecetteService.create(5,
				"Pelez les pommes de terre et coupez-les en cubes. Nettoyez et ??mincez en rondelles le poireau.");
		// -- Instruction 51 --//
		_instructionRecetteService.create(5,
				"Faites cuire les pommes de terre et le poireau dans une casserole d'eau bouillante sal??e pendant 20 minutes.");
		// -- Instruction 52 --//
		_instructionRecetteService.create(5, "Pendant ce temps, faites chauffer l'huile d'olive dans une sauteuse.");
		// -- Instruction 53 --//
		_instructionRecetteService.create(5,
				"Faites revenir le hachis de l??gumes dans la sauteuse pendant 15 minutes en remuant r??guli??rement. Salez et poivrez puis ajoutez le persil cisel??.");
		// -- Instruction 54 --//
		_instructionRecetteService.create(5, "Pr??chauffez le four ?? 200 degr??.");
		// -- Instruction 55 --//
		_instructionRecetteService.create(5,
				"R??partissez le hachis de l??gumes dans le fond d'un plat ?? gratin. R??servez.");
		// -- Instruction 56 --//
		_instructionRecetteService.create(5,
				"Egouttez les pommes de terre et le poireau et ??crasez-les en pur??e ??paisse dans un saladier, ?? l'aide d'une fourchette. Rectifiez l'assaisonnement.");
		// -- Instruction 57 --//
		_instructionRecetteService.create(5,
				"Recouvrez le hachis de l??gumes avec la pur??e de pommes de terre au poireau.");
		// -- Instruction 58 --//
		_instructionRecetteService.create(5,
				"Striez le hachis avec les dents d'une fourchette puis enfournez pendant 35 minutes jusqu'?? ce qu'il soit bien dor??.");
		// -- Instruction 59 --//
		_instructionRecetteService.create(5, "D??gustez bien chaud.");

		/* Recette 6 */
		_recetteService.create(new Recette("Tagliatelles l??g??res lentilles, potiron et roquefort", 4, comm2, 3.7, 46,
				LocalTime.of(1, 30), true));

		/// Ingredient 21 ///
		_ingredientService.create(new Ingredient("Tagliatelle sans oeuf", 288, 1, 12, true, true, Unite.g));
		// RecetteIngredient 27
		_recetteIngredientService.create(6, 21, 200);

		/// Ingredient 22 ///
		_ingredientService.create(new Ingredient("Chair de potiron", 30, 11, 12, true, true, Unite.g));
		// RecetteIngredient 28
		_recetteIngredientService.create(6, 22, 300);

		/// Ingredient 23 ///
		_ingredientService.create(new Ingredient("Lentille verte", 127, 1, 12, true, true, Unite.g));
		// RecetteIngredient 29
		_recetteIngredientService.create(6, 23, 200);

		// RecetteIngredient 30
		_recetteIngredientService.create(6, 4, 150);

		/// Ingredient 24 ///
		_ingredientService.create(new Ingredient("Rocquefort", 369, 1, 12, true, true, Unite.g));
		// RecetteIngredient 31
		_recetteIngredientService.create(6, 24, 60);

		// -- Instruction 60 --//
		_instructionRecetteService.create(6, "Coupez la chair de potiron en petits cubes.");
		// -- Instruction 61 --//
		_instructionRecetteService.create(6, "Pelez et hachez l'oignon.");
		// -- Instruction 62 --//
		_instructionRecetteService.create(6, "Faites chauffer 1 c. ?? soupe d'huile d'olive dans une po??le.");
		// -- Instruction 63 --//
		_instructionRecetteService.create(6,
				"Faites blondir l'oignon, les cubes de potiron et les lentilles vertes ??goutt??es pendant 5 minutes en m??langeant bien.");
		// -- Instruction 64 --//
		_instructionRecetteService.create(6,
				"Versez le vin blanc puis salez et poivrez. Laissez compoter pendant 15 minutes.");
		// -- Instruction 65 --//
		_instructionRecetteService.create(6,
				"Pendant ce temps, faites cuire les tagliatelles fra??ches dans une casserole d'eau bouillante en suivant le temps indiqu?? sur le paquet.");
		// -- Instruction 66 --//
		_instructionRecetteService.create(6,
				"Egouttez les tagliatelles en fin de cuisson et dressez-les dans les assiettes.");
		// -- Instruction 67 --//
		_instructionRecetteService.create(6,
				"Nappez-les de compot??e au potiron puis parsemez-les de roquefort ??miett?? et de basilic cisel??.");
		// -- Instruction 68 --//
		_instructionRecetteService.create(6, "D??gustez sans attendre.");

		/* Recette 7 */
		_recetteService.create(new Recette("Mijot?? de boeuf maigre fa??on bourguignon ?? la tomate", 4, comm3, 3.6, 77,
				LocalTime.of(2, 0), true));

		/// Ingredient 25 ///
		_ingredientService.create(new Ingredient("Viande de boeuf d??graiss??e", 100, 1, 12, false, false, Unite.g));
		// RecetteIngredient 32
		_recetteIngredientService.create(7, 25, 800);

		// RecetteIngredient 33
		_recetteIngredientService.create(7, 19, 375);

		// RecetteIngredient 34
		_recetteIngredientService.create(7, 4, 300);

		// RecetteIngredient 35
		_recetteIngredientService.create(7, 13, 225);

		// RecetteIngredient 36
		_recetteIngredientService.create(7, 8, 45);

		// -- Instruction 69 --//
		_instructionRecetteService.create(7, "Pelez et ??mincez les oignons et les carottes.");
		// -- Instruction 70 --//
		_instructionRecetteService.create(7, "Coupez en morceaux la viande de boeuf.");
		// -- Instruction 71 --//
		_instructionRecetteService.create(7, "Faites fondre le beurre avec un filet d'huile d'olive dans une cocotte.");
		// -- Instruction 72 --//
		_instructionRecetteService.create(7, "Faites-y suer les oignons jusqu'?? ce qu'ils soient dor??s.");
		// -- Instruction 73 --//
		_instructionRecetteService.create(7,
				"Ajoutez la viande de boeuf et laissez dorer en m??langeant r??guli??rement.");
		// -- Instruction 74 --//
		_instructionRecetteService.create(7,
				"Faites dissoudre le cube de bouillon dans le verre d'eau et versez dans la cocotte. Ajoutez les vinaigres puis salez et poivrez.");
		// -- Instruction 75 --//
		_instructionRecetteService.create(7, "Couvrez et laissez mijoter 20 minutes ?? feu doux.");
		// -- Instruction 76 --//
		_instructionRecetteService.create(7,
				"Ajoutez les carottes ??minc??es puis poursuivez la cuisson pendant environ 1h10, toujours ?? feu doux et ?? couvert.");
		// -- Instruction 77 --//
		_instructionRecetteService.create(7,
				"En fin de cuisson, ajoutez la sauce tomate puis la f??cule de ma??s et m??langez bien.");
		// -- Instruction 78 --//
		_instructionRecetteService.create(7, "Rectifiez l'assaisonnement si besoin puis servez imm??diatement.");

		/* Recette 8 */
		_recetteService
				.create(new Recette("Curry light de dinde aux l??gumes", 4, comm1, 3, 63, LocalTime.of(1, 15), true));

		/// Ingredient 26 ///
		_ingredientService.create(new Ingredient("Escalope de dinde", 106, 1, 12, false, false, Unite.g));
		// RecetteIngredient 32
		_recetteIngredientService.create(8, 26, 600);

		// RecetteIngredient 38
		_recetteIngredientService.create(8, 4, 150);

		// RecetteIngredient 39
		_recetteIngredientService.create(8, 10, 7);

		// RecetteIngredient 40
		_recetteIngredientService.create(8, 19, 500);

		/// Ingredient 27 ///
		_ingredientService.create(new Ingredient("Haricot vert", 31, 7, 10, true, true, Unite.g));
		// RecetteIngredient 41
		_recetteIngredientService.create(8, 27, 300);

		// RecetteIngredient 42
		_recetteIngredientService.create(8, 13, 350);

		/// Ingredient 28 ///
		_ingredientService.create(new Ingredient("Lait de coco", 230, 1, 12, true, true, Unite.mL));
		// RecetteIngredient 41
		_recetteIngredientService.create(8, 28, 20);

		// -- Instruction 79 --//
		_instructionRecetteService.create(8, "Epluchez et hachez l'oignon et l'ail.");
		// -- Instruction 80 --//
		_instructionRecetteService.create(8, "Faites chauffer un filet d'huile dans une sauteuse.");
		// -- Instruction 81 --//
		_instructionRecetteService.create(8,
				"Mettez-y l'oignon, l'ail et toutes les ??pices puis faites suer jusqu'?? ce que l'oignon soit translucide.");
		// -- Instruction 82 --//
		_instructionRecetteService.create(8,
				"Coupez les escalopes de dinde en d??s puis ajoutez-les dans la sauteuse. Laissez cuire 5 minutes en m??langeant.");
		// -- Instruction 83 --//
		_instructionRecetteService.create(8,
				"Pelez et coupez en rondelles les carottes. Nettoyez et ??gouttez les haricots verts. Quand la dinde est dor??e, ajoutez les l??gumes dans la sauteuse et m??langez.");
		// -- Instruction 84 --//
		_instructionRecetteService.create(8,
				"Versez 25 cl d'eau, remuez, couvrez et laissez cuire pendant 1 heure ?? feu doux.");
		// -- Instruction 85 --//
		_instructionRecetteService.create(8,
				"Au bout de ce temps, ajoutez la poudre de coco dilu??e dans 10 cl d'eau et remuez bien. Laissez mijoter encore 5 minutes.");
		// -- Instruction 86 --//
		_instructionRecetteService.create(8, "Rectifiez l'assaisonnement en sel et en poivre et m??langez.");
		// -- Instruction 87 --//
		_instructionRecetteService.create(8, "Servez accompagn?? de riz blanc.");

		/* Recette 9: 4 personnes */
		_recetteService.create(
				new Recette("Soupe de l??gumes di??t??tique au quinoa", 4, comm1, 3.7, 30, LocalTime.of(0, 50), true));

		/// Ingredient 29 ///
		_ingredientService.create(new Ingredient("Quinoa", 75, 1, 12, true, true, Unite.g));
		// RecetteIngredient 41
		_recetteIngredientService.create(9, 29, 150);

		// RecetteIngredient 43
		_recetteIngredientService.create(9, 1, 960);

		// RecetteIngredient 44
		_recetteIngredientService.create(9, 19, 250);

		// RecetteIngredient 45
		_recetteIngredientService.create(9, 20, 300);

		// RecetteIngredient 46
		_recetteIngredientService.create(9, 4, 150);

		// -- Instruction 88 --//
		_instructionRecetteService.create(9,
				"Pelez et taillez en petits morceaux les pommes de terre et les carottes.");
		// -- Instruction 89 --//
		_instructionRecetteService.create(9, "Nettoyez et ??mincez en fines rondelles les poireaux.");
		// -- Instruction 90 --//
		_instructionRecetteService.create(9, "Pelez et hachez l'oignon.");
		// -- Instruction 91 --//
		_instructionRecetteService.create(9, "Faites fondre une noix de beurre dans une cocotte.");
		// -- Instruction 92 --//
		_instructionRecetteService.create(9, "Faites-y suer l'oignon jusqu'?? ce qu'il soit translucide.");
		// -- Instruction 93 --//
		_instructionRecetteService.create(9, "Ajoutez les l??gumes puis recouvrez d'eau ?? hauteur.");
		// -- Instruction 94 --//
		_instructionRecetteService.create(9, "Couvrez et portez ?? ??bullition ?? feu doux.");
		// -- Instruction 95 --//
		_instructionRecetteService.create(9,
				"Ajoutez le quinoa dans la cocotte puis faites cuire ?? couvert pendant 30 minutes, jusqu'?? ce que les carottes et les pommes de terre soient tendres.");
		// -- Instruction 96 --//
		_instructionRecetteService.create(9,
				"Salez et poivrez ?? votre go??t en fin de cuisson. Ajoutez le persil cisel??.");
		// -- Instruction 97 --//
		_instructionRecetteService.create(9, "Servez bien chaud.");

		/* Recette 10: 8 personnes */
		_recetteService.create(new Recette("Tarte light thon-??pinards", 8, comm4, 4.9, 16, LocalTime.of(1, 0), false));

		// RecetteIngredient 47
		_recetteIngredientService.create(10, 11, 250);

		// RecetteIngredient 48
		_recetteIngredientService.create(10, 12, 125);

		// RecetteIngredient 49
		_recetteIngredientService.create(10, 7, 125);

		/// Ingredient 30 ///
		_ingredientService.create(new Ingredient("Epinard", 23, 3, 1, true, true, Unite.g));
		// RecetteIngredient 50
		_recetteIngredientService.create(10, 30, 150);

		// RecetteIngredient 51
		_recetteIngredientService.create(10, 17, 125);

		// RecetteIngredient 52
		_recetteIngredientService.create(10, 5, 100);

		// -- Instruction 98 --//
		_instructionRecetteService.create(10, "Faites fondre le beurre avec l???eau dans une casserole ?? feu doux.");
		// -- Instruction 99 --//
		_instructionRecetteService.create(10,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de bl?? et le sucre en poudre (en option).");
		// -- Instruction 100 --//
		_instructionRecetteService.create(10,
				"Malaxez bien le m??lange avec vos mains, pendant plusieurs minutes, jusqu????? obtenir une boule de p??te bien lisse et homog??ne.");
		// -- Instruction 101 --//
		_instructionRecetteService.create(10,
				"Couvrez le saladier avec du film alimentaire et placez la boule de p??te au frais pendant 10 min minimum.");
		// -- Instruction 102 --//
		_instructionRecetteService.create(10,
				"C'est pr??t ! D??gazez la p??te sur un plan de travail farin??.Pour cela, tapez ??nergiquement sur la p??te pour en enlever le gaz carbonique emprisonn?? dans les bulles d'air.");
		// -- Instruction 103 --//
		_instructionRecetteService.create(10,
				"Puis ??talez-la ?? l'aide d'un rouleau ?? p??tisserie. D??posez ensuite votre fond de tarte dans un plat ?? tarte recouvert de papier sulfuris?? et piquez son fond avec une fourchette.");

		// -- Instruction 104 --//
		_instructionRecetteService.create(10, "Pr??chauffez le four ?? 180??C.");
		// -- Instruction 105 --//
		_instructionRecetteService.create(10, "Foncez la p??te dans un moule ?? tarte recouvert de papier sulfuris??.");
		// -- Instruction 106 --//
		_instructionRecetteService.create(10, "Piquez le fond avec une fourchette. R??servez.");
		// -- Instruction 107 --//
		_instructionRecetteService.create(10, "Egouttez puis ??miettez le thon ?? la fourchette dans un saladier.");
		// -- Instruction 108 --//
		_instructionRecetteService.create(10, "Ajoutez les ??pinards hach??s et m??langez bien. R??servez.");
		// -- Instruction 109 --//
		_instructionRecetteService.create(10, "Battez les oeufs avec la cr??me fra??che dans un saladier.");
		// -- Instruction 110 --//
		_instructionRecetteService.create(10,
				"Ajoutez le m??lange thon-??pinards et remuez bien. Salez et poivrez ?? votre go??t.");
		// -- Instruction 111 --//
		_instructionRecetteService.create(10,
				"Versez le m??lange sur le fond de p??te dans le moule. Parsemez de gruy??re r??p??.");
		// -- Instruction 112 --//
		_instructionRecetteService.create(10, "Enfournez pendant 35 minutes jusqu'?? ce que la tarte soit bien dor??e.");
		// -- Instruction 113 --//
		_instructionRecetteService.create(10, "Servez chaud ou froid accompagn?? d'une salade verte assaisonn??e.");

		/* Recette 11: 4 personnes */
		_recetteService.create(new Recette("Endives au jambon minceur gratin??es au gruy??re", 4, comm1, 4.4, 67,
				LocalTime.of(0, 50), false));

		// RecetteIngredient 53
		_recetteIngredientService.create(11, 3, 50);

		// RecetteIngredient 54
		_recetteIngredientService.create(11, 5, 400);

		/// Ingredient 31 ///
		_ingredientService.create(new Ingredient("Endive", 17, 10, 4, true, true, Unite.g));
		// RecetteIngredient 50
		_recetteIngredientService.create(11, 31, 600);

		// RecetteIngredient 51
		_recetteIngredientService.create(11, 2, 200);

		// -- Instruction 114 --//
		_instructionRecetteService.create(11, "Pr??chauffez le four ?? 180??C.");
		// -- Instruction 115 --//
		_instructionRecetteService.create(11,
				"Nettoyez les endives, puis enroulez-les dans une tranche de jambon. D??posez les endives dans un plat ?? gratin.");
		// -- Instruction 116 --//
		_instructionRecetteService.create(11,
				"Dans un bol, m??langez la cr??me, du sel, du poivre et la muscade. Versez sur les endives.");
		// -- Instruction 117 --//
		_instructionRecetteService.create(11,
				"Parsemez de gruy??re r??p??, puis ciselez le persil lav?? par-dessus, et enfournez pour 35 ?? 40 minutes.");
		// -- Instruction 118 --//
		_instructionRecetteService.create(11, "Servez bien chaud et accompagnez d???une po??l??e de l??gumes !");

		/* Recette 12 */
		_recetteService
				.create(new Recette("Papillote de merlan aux poivrons", 4, comm2, 3.6, 39, LocalTime.of(1, 00), true));

		/// Ingredient 32 ///
		_ingredientService.create(new Ingredient("Filet de merlan", 128, 1, 3, false, false, Unite.g));
		// RecetteIngredient 52
		_recetteIngredientService.create(12, 32, 360);

		// RecetteIngredient 53
		_recetteIngredientService.create(12, 19, 500);

		/// Ingredient 33 ///
		_ingredientService.create(new Ingredient("Poivron jaune, rouge ou vert", 26, 6, 9, true, true, Unite.g));
		// RecetteIngredient 54
		_recetteIngredientService.create(12, 33, 500);

		/// Ingredient 34 ///
		_ingredientService.create(new Ingredient("Echalote", 72, 1, 12, true, true, Unite.g));
		// RecetteIngredient 55
		_recetteIngredientService.create(12, 34, 40);

		// -- Instruction 118 --//
		_instructionRecetteService.create(12, "Pr??chauffez le four ?? 180??C.");
		// -- Instruction 119 --//
		_instructionRecetteService.create(12,
				"Emincez et ??pluchez les ??chalotes en petits morceaux. Epluchez et coupez les carottes en petits cubes. Lavez, ??p??pinez et coupez les poivrons en fines lamelles.");
		// -- Instruction 120 --//
		_instructionRecetteService.create(12,
				"Dans une po??le sur feu moyen, faites cuire les poivrons et les carottes avec un peu d'huile d'olive, jusqu'?? ce qu'ils soient tendres.");
		// -- Instruction 121 --//
		_instructionRecetteService.create(12,
				"Sur 4 feuilles de papier sulfuris??, d??posez les l??gumes revenus ?? la po??le, les ??chalotes, du sel, du poivre et les filets de merlan sur le dessus. Salez, poivrez et d??posez quelques brins de persil hach??. Arrosez d'un filet d'huile d'olive.");
		// -- Instruction 122 --//
		_instructionRecetteService.create(12,
				"D??posez les papillotes dans un plat allant au four. Versez le vin blanc et refermez-les d??finitivement. Enfournez pendant 30 minutes.");
		// -- Instruction 123 --//
		_instructionRecetteService.create(12, "Servez imm??diatement ?? la sortie du four avec du riz nature.");

		/* Recette 13 */
		_recetteService.create(new Recette("Rago??t cramoisi de betterave, chou et bacon", 5, comm3, 2.1, 28,
				LocalTime.of(2, 0), true));

		/// Ingredient 35 ///
		_ingredientService.create(new Ingredient("Chou blanc", 25, 6, 11, true, true, Unite.g));
		// RecetteIngredient 56
		_recetteIngredientService.create(13, 35, 700);

		/// Ingredient 36 ///
		_ingredientService.create(new Ingredient("Betterave", 19, 1, 12, true, true, Unite.g));
		// RecetteIngredient 57
		_recetteIngredientService.create(13, 36, 1800);

		/// Ingredient 37 ///
		_ingredientService.create(new Ingredient("Tranche de bacon", 541, 1, 12, false, false, Unite.g));
		// RecetteIngredient 58
		_recetteIngredientService.create(13, 37, 172);

		// RecetteIngredient 59
		_recetteIngredientService.create(13, 4, 150);

		// RecetteIngredient 60
		_recetteIngredientService.create(13, 10, 21);

		// -- Instruction 124 --//
		_instructionRecetteService.create(13,
				"??pluchez les betteraves et d??taillez-les en d??s. Pelez et ??mincez l???oignon. Coupez le trognon du chou et ??mincez-le. Pelez et ??crasez l???ail. Coupez le bacon en d??s.");
		// -- Instruction 125 --//
		_instructionRecetteService.create(13,
				"Faites fondre l???oignon quelques minutes avec l???huile dans une cocotte, puis ajoutez les l??gumes et les d??s de bacon. Laissez cuire 5 minutes ?? feu moyen.");
		// -- Instruction 126 --//
		_instructionRecetteService.create(13,
				"Ajoutez le cube de bouillon et 25 cl d???eau. Salez, poivrez, ajoutez le persil et le laurier.");
		// -- Instruction 127 --//
		_instructionRecetteService.create(13, "Ramenez ?? feu doux et laissez mijoter 1 h 30.");
		// -- Instruction 128 --//
		_instructionRecetteService.create(13, "Servez chaud !");

		/* Recette 14 */
		_recetteService.create(new Recette("Omelette au saumon fum??", 2, comm2, 4.1, 11, LocalTime.of(0, 30), true));

		// RecetteIngredient 61
		_recetteIngredientService.create(14, 17, 480);

		/// Ingredient 38 ///
		_ingredientService.create(new Ingredient("Tranche de saumon fum??", 117, 2, 8, true, false, Unite.g));
		// RecetteIngredient 62
		_recetteIngredientService.create(14, 38, 200);

		/// Ingredient 39 ///
		_ingredientService.create(new Ingredient("Citron jaune", 29, 1, 4, true, true, Unite.g));
		// RecetteIngredient 63
		_recetteIngredientService.create(14, 39, 60);

		// -- Instruction 129 --//
		_instructionRecetteService.create(14, "D??coupez les tranches de saumon fum?? en fines lani??res.");
		// -- Instruction 130 --//
		_instructionRecetteService.create(14,
				"Pressez le demi citron afin de r??cup??rer son jus. Retirez-y les p??pins si besoin.");
		// -- Instruction 131 --//
		_instructionRecetteService.create(14,
				"Placez les lani??res de saumon fum?? dans un bol et arrosez-les avec le jus de citron. M??langez bien puis r??servez de c??t??.");
		// -- Instruction 132 --//
		_instructionRecetteService.create(14, "Lavez les peluches de persil et ??pongez-les (facultatif).");
		// -- Instruction 133 --//
		_instructionRecetteService.create(14,
				"Battez 2 oeufs ?? la fourchette dans un r??cipient. Salez et poivrez selon vos go??ts.");
		// -- Instruction 134 --//
		_instructionRecetteService.create(14,
				"Faites fondre la noix de beurre all??g?? dans une po??le anti-adh??sive sur feu moyen.");
		// -- Instruction 135 --//
		_instructionRecetteService.create(14,
				"Versez-y les 2 oeufs battus puis faites-les cuire 3 ?? 4 minutes sur feu doux ou jusqu????? obtenir une omelette bien prise.");
		// -- Instruction 136 --//
		_instructionRecetteService.create(14,
				"Retirez alors l'omelette de la po??le et d??posez-la dans une assiette. R??servez au chaud.");
		// -- Instruction 137 --//
		_instructionRecetteService.create(14,
				"R??p??tez l???op??ration de cuisson pour cuire les trois autres omelettes avec le restant d???oeufs frais.");
		// -- Instruction 138 --//
		_instructionRecetteService.create(14,
				"Quand toutes les omelettes sont cuites, r??partissez les lani??res de saumon fum?? sur le dessus. Parsemez enfin de peluches de persil frais (facultatif), puis repliez un bord des omelettes sur l???autre.");
		// -- Instruction 139 --//
		_instructionRecetteService.create(14,
				"Servez ti??de et d??gustez ces omelettes en guise de plat principal, accompagn??es d???une salade verte assaisonn??e et de tranches de pain grill??. Pendant les f??tes de fin d???ann??e, accompagnez cette recette avec un vin blanc ou ros??, p??tillant ou non, bien fruit?? et frais.");
		// -- Instruction 140 --//
		_instructionRecetteService.create(14,
				"Astuce : Vous aimez l???aneth ? N???h??sitez pas ?? en incorporer cisel?? dans les oeufs battus avant cuisson des omelettes. Tout aussi bon !");

		/* Recette 15 */
		_recetteService.create(
				new Recette("Gratin de chou fleur persill?? au comt??", 4, comm3, 3.6, 56, LocalTime.of(1, 0), true));

		/// Ingredient 40 ///
		_ingredientService.create(new Ingredient("Chou fleur", 25, 5, 11, true, true, Unite.g));
		// RecetteIngredient 64
		_recetteIngredientService.create(15, 40, 60);

		/// Ingredient 41 ///
		_ingredientService.create(new Ingredient("Comt??", 29, 1, 12, true, false, Unite.g));
		// RecetteIngredient 65
		_recetteIngredientService.create(15, 41, 390);

		/// Ingredient 42 ///
		_ingredientService.create(new Ingredient("Cr??me all??g??e", 108, 1, 12, true, false, Unite.mL));
		// RecetteIngredient 66
		_recetteIngredientService.create(15, 42, 300);

		// RecetteIngredient 67
		_recetteIngredientService.create(15, 10, 7);

		// -- Instruction 141 --//
		_instructionRecetteService.create(15, "D??tacher les fleurs du chou et les cuire 5 minutes ?? l???auto-cuiseur.");
		// -- Instruction 142 --//
		_instructionRecetteService.create(15,
				"Dans un saladier, m??langer la cr??me, le Comt?? r??p??, le persil hach?? et une gousse d???ail ??cras??e.");
		// -- Instruction 143 --//
		_instructionRecetteService.create(15,
				"D??poser les fleurs de chou dans un plat ?? gratin et arroser avec la pr??paration.");
		// -- Instruction 144 --//
		_instructionRecetteService.create(15,
				"Enfourner dans un four pr??chauff?? ?? 180??C pour 30 minutes de cuisson environ.");
	}
	
	@Test //1er chose a faire => config spring => create
	@Transactional
	@Commit
	@Disabled
	public void createBDD() {
		updateCompte();
		updateRecetteEtIngredient();
		updateMessage();
	}
	//
	@Test //2nd chose a faire => config spring => update
	@Transactional
	@Commit
	//@Disabled
	public void update2BDD() {
		updateRecetteWithVeganVegetarien();
	}
}//
