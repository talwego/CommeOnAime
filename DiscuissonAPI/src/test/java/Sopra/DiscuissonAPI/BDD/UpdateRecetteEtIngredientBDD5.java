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
		
		_messageService.create("Je veux perdre 10 kilos en 1 semaine", 9, 1);
		_messageService.create("Ca va être compliqué", 1, 9);
		_messageService.create("noooooooooooooon qhxbezxbjz !!",9, 1);
		
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
		String comm1 ="Validé par la commu";
		String comm2="Validé par les modos";
		String comm3 ="Validé par la chef";
		String comm4="Validé par personne!!";
		
		
		/* Recette 1 */
		_recetteService.create(
				new Recette("Tartiflette sans lardons au gruyère léger", 8, comm1, 3.7, 51, LocalTime.of(1, 30), true));

		/// Ingredient 1 ///
		_ingredientService.create(new Ingredient("Pomme de terre", 73, 1, 12, true, true, Unite.g));
		// RecetteIngredient 1
		_recetteIngredientService.create(1, 1, 1000);

		/// Ingredient 2 ///
		_ingredientService.create(new Ingredient("Jambon maigre", 112, 1, 12, false, false, Unite.g));
		// RecetteIngredient 2
		_recetteIngredientService.create(1, 2, 100);

		/// Ingredient 3 ///
		_ingredientService.create(new Ingredient("Gruyere allégé", 213, 1, 12, true, false, Unite.g));
		// RecetteIngredient 3
		_recetteIngredientService.create(1, 3, 200);

		/// Ingredient 4 ///
		_ingredientService.create(new Ingredient("Oignon", 43, 1, 12, true, true, Unite.g));
		// RecetteIngredient 4
		_recetteIngredientService.create(1, 4, 300);

		/// Ingredient 5 ///
		_ingredientService.create(new Ingredient("Crème fraîche légère", 192, 1, 12, true, false, Unite.mL));
		// RecetteIngredient 5
		_recetteIngredientService.create(1, 5, 100);

		// -- Instruction 1 --//
		_instructionRecetteService.create(1, "Préchauffez le four à 210 degrés");
		// -- Instruction 2 --//
		_instructionRecetteService.create(1, "Pelez et coupez les pommes de terre en fines rondelles.");
		// -- Instruction 3 --//
		_instructionRecetteService.create(1, "Pelez et taillez les oignons en fines lamelles.");
		// -- Instruction 4 --//
		_instructionRecetteService.create(1,
				"Déposez une couche de pommes de terre puis une couche d'oignons dans le fond d'un plat à gratin.");
		// -- Instruction 5 --//
		_instructionRecetteService.create(1,
				"Recouvrez avec une couche de dés de jambon puis une couche de gruyère râpé.");
		// -- Instruction 6 --//
		_instructionRecetteService.create(1,
				"Redéposez une couche de pommes de terre, une couche d'oignons,..., et ainsi de suite jusqu'à épuisement des ingrédients, en terminant par une couche de pommes de terre.");
		// -- Instruction 7 --//
		_instructionRecetteService.create(1,
				"Mélangez si vous le souhaitez, la crème fraîche avec du persil ciselé, du sel et du poivre dans un bol.");
		// -- Instruction 8 --//
		_instructionRecetteService.create(1,
				"Versez la crème fraîche sur les pommes de terre dans le plat. Parsemez d'un peu de gruyère râpé.");
		// -- Instruction 9 --//
		_instructionRecetteService.create(1,
				"Enfournez pendant 1 heure à 1h15 de cuisson jusqu'à ce que la tartiflette soit bien dorée.");
		// -- Instruction 10 --//
		_instructionRecetteService.create(1, "Servez bien chaud accompagné d'une salade verte assaisonnée.");

		/* Recette 2 */
		_recetteService.create(new Recette("Lasagnes minceur au thon et au parmesan léger", 4, comm4, 4.3, 127,
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
		_instructionRecetteService.create(2, "Préchauffez le four à 180 degrés.");
		// -- Instruction 12 --//
		_instructionRecetteService.create(2, "Emiettez le thon dans un saladier à l'aide d'une fourchette.");
		// -- Instruction 13 --//
		_instructionRecetteService.create(2, "Ajoutez-y la sauce tomate et mélangez bien.");
		// -- Instruction 14 --//
		_instructionRecetteService.create(2, "Placez des feuilles à lasagnes dans le fond d'un plat à gratin.");
		// -- Instruction 15 --//
		_instructionRecetteService.create(2,
				"Recouvrez avec une couche de crème fraîche puis une couche de préparation thon-sauce tomate.");
		// -- Instruction 16 --//
		_instructionRecetteService.create(2,
				"Replacez des feuilles à lasagnes sur le dessus puis une nouvelle couche de crème fraîche et de préparation au thon.");
		// -- Instruction 17 --//
		_instructionRecetteService.create(2,
				"Répétez l'opération jusqu'à épuisement des ingrédients, en terminant par une couche de crème fraîche.");
		// -- Instruction 18 --//
		_instructionRecetteService.create(2, "Bonus: Parsemez le plat avec le parmesan râpé.");
		// -- Instruction 19 --//
		_instructionRecetteService.create(2,
				"Enfournez pendant 30 minutes jusqu'à ce que les lasagnes soient bien gratinées.");
		// -- Instruction 20 --//
		_instructionRecetteService.create(2, "Servez bien chaud accompagné d'une salade verte assaisonnée.");

		/* Recette 3 */
		_recetteService.create(new Recette("Dos de cabillaud à la crème légère à l'ail", 4, comm3, 3.9, 55,
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
				"Une fois les gousses d'ail cuites, égouttez-les et mixez-les avec la crème liquide dans un blender.");
		// -- Instruction 23 --//
		_instructionRecetteService.create(3,
				"Bonus: Ajouter du persil frais. Ajoutez-le au mélange avec un peu de sel et de poivre. Réservez.");
		// -- Instruction 24 --//
		_instructionRecetteService.create(3,
				"Faites fondre une noix de beurre dans une poêle et faites-y cuire de chaque côté les dos de cabillaud jusqu'à obtenir la cuisson désirée.");
		// -- Instruction 25 --//
		_instructionRecetteService.create(3,
				"Pendant ce temps, réchauffez la crème à l'ail dans une casserole à feu doux.");
		// -- Instruction 26 --//
		_instructionRecetteService.create(3,
				"Servez les dos de cabillaud dans les assiettes et nappez-les de crème à l'ail.");
		// -- Instruction 27 --//
		_instructionRecetteService.create(3, "Dégustez.");

		/* Recette 4 */
		_recetteService.create(new Recette("Quiche légère poulet, champignons et brocoli", 4, comm4, 3.6, 87,
				LocalTime.of(0, 50), true));

		/// Ingredient 11 ///
		_ingredientService.create(new Ingredient("Farine de blé", 149, 1, 12, true, true, Unite.g));
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
		_instructionRecetteService.create(4, "Faites fondre le beurre avec l’eau dans une casserole à feu doux.");
		// -- Instruction 29 --//
		_instructionRecetteService.create(4,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de blé et le sucre en poudre (en option).");
		// -- Instruction 30 --//
		_instructionRecetteService.create(4,
				"Malaxez bien le mélange avec vos mains, pendant plusieurs minutes, jusqu’à obtenir une boule de pâte bien lisse et homogène.");
		// -- Instruction 31 --//
		_instructionRecetteService.create(4,
				"Couvrez le saladier avec du film alimentaire et placez la boule de pâte au frais pendant 10 min minimum.");
		// -- Instruction 32 --//
		_instructionRecetteService.create(4,
				"C'est prêt ! Dégazez la pâte sur un plan de travail fariné.Pour cela, tapez énergiquement sur la pâte pour en enlever le gaz carbonique emprisonné dans les bulles d'air.");
		// -- Instruction 33 --//
		_instructionRecetteService.create(4,
				"Puis étalez-la à l'aide d'un rouleau à pâtisserie. Déposez ensuite votre fond de tarte dans un plat à tarte recouvert de papier sulfurisé et piquez son fond avec une fourchette.");

		// -- Instruction 34 --//
		_instructionRecetteService.create(4, "Préchauffez le four à 220°C.");
		// -- Instruction 35 --//
		_instructionRecetteService.create(4, "Foncez la pâte dans un moule à tarte recouvert de papier sulfurisé.");
		// -- Instruction 36 --//
		_instructionRecetteService.create(4, "Piquez le fond avec une fourchette. Réservez.");
		// -- Instruction 37 --//
		_instructionRecetteService.create(4, "Coupez les blancs de poulet en morceaux.");
		// -- Instruction 38 --//
		_instructionRecetteService.create(4, "Nettoyez et émincez en tranches les champignons de Paris.");
		// -- Instruction 39 --//
		_instructionRecetteService.create(4, "Faites dorer le poulet dans une poêle anti-adhésive pendant 5 minutes.");
		// -- Instruction 40 --//
		_instructionRecetteService.create(4,
				"Ajoutez les champignons émincés et laissez cuire jusqu'à ce qu'ils aient rendu leur eau.");
		// -- Instruction 41 --//
		_instructionRecetteService.create(4,
				"Pendant ce temps, faites cuire les fleurons de brocoli dans une casserole d'eau bouillante pendant 10 minutes.");
		// -- Instruction 42 --//
		_instructionRecetteService.create(4, "Répartissez le mélange poulet-champignons dans le fond de pâte.");
		// -- Instruction 43 --//
		_instructionRecetteService.create(4,
				"Egouttez les fleurons de brocoli et répartissez-les sur le dessus du mélange poulet-champignons.");
		// -- Instruction 44 --//
		_instructionRecetteService.create(4,
				"Battez les oeufs avec la crème fraîche et le lait dans un bol. Ajoutez du persil ciselé puis salez et poivrez.");
		// -- Instruction 45 --//
		_instructionRecetteService.create(4, "Versez le mélange aux oeufs sur la garniture au poulet dans le moule.");
		// -- Instruction 46 --//
		_instructionRecetteService.create(4, "Enfournez la quiche pendant 30 minutes jusqu'à ce qu'elle soit dorée.");
		// -- Instruction 47 --//
		_instructionRecetteService.create(4, "Dégustez chaud ou froid accompagné d'une salade verte assaisonnée.");

		/* Recette 5 */
		
				
		_recetteService.create(new Recette("Hachis parmentier sans viande aux légumes", 4, comm2, 3.6, 87,
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
				"Pelez et coupez en morceaux les carottes, le navet, les branches de céleri, les oignons et l'ail.");
		// -- Instruction 49 --//
		_instructionRecetteService.create(5,
				"Mixez les légumes dans un blender jusqu'à obtenir un hachis bien homogène. Réservez.");
		// -- Instruction 50 --//
		_instructionRecetteService.create(5,
				"Pelez les pommes de terre et coupez-les en cubes. Nettoyez et émincez en rondelles le poireau.");
		// -- Instruction 51 --//
		_instructionRecetteService.create(5,
				"Faites cuire les pommes de terre et le poireau dans une casserole d'eau bouillante salée pendant 20 minutes.");
		// -- Instruction 52 --//
		_instructionRecetteService.create(5, "Pendant ce temps, faites chauffer l'huile d'olive dans une sauteuse.");
		// -- Instruction 53 --//
		_instructionRecetteService.create(5,
				"Faites revenir le hachis de légumes dans la sauteuse pendant 15 minutes en remuant régulièrement. Salez et poivrez puis ajoutez le persil ciselé.");
		// -- Instruction 54 --//
		_instructionRecetteService.create(5, "Préchauffez le four à 200 degré.");
		// -- Instruction 55 --//
		_instructionRecetteService.create(5,
				"Répartissez le hachis de légumes dans le fond d'un plat à gratin. Réservez.");
		// -- Instruction 56 --//
		_instructionRecetteService.create(5,
				"Egouttez les pommes de terre et le poireau et écrasez-les en purée épaisse dans un saladier, à l'aide d'une fourchette. Rectifiez l'assaisonnement.");
		// -- Instruction 57 --//
		_instructionRecetteService.create(5,
				"Recouvrez le hachis de légumes avec la purée de pommes de terre au poireau.");
		// -- Instruction 58 --//
		_instructionRecetteService.create(5,
				"Striez le hachis avec les dents d'une fourchette puis enfournez pendant 35 minutes jusqu'à ce qu'il soit bien doré.");
		// -- Instruction 59 --//
		_instructionRecetteService.create(5, "Dégustez bien chaud.");

		/* Recette 6 */
		_recetteService.create(new Recette("Tagliatelles légères lentilles, potiron et roquefort", 4, comm2, 3.7, 46,
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
		_instructionRecetteService.create(6, "Faites chauffer 1 c. à soupe d'huile d'olive dans une poêle.");
		// -- Instruction 63 --//
		_instructionRecetteService.create(6,
				"Faites blondir l'oignon, les cubes de potiron et les lentilles vertes égouttées pendant 5 minutes en mélangeant bien.");
		// -- Instruction 64 --//
		_instructionRecetteService.create(6,
				"Versez le vin blanc puis salez et poivrez. Laissez compoter pendant 15 minutes.");
		// -- Instruction 65 --//
		_instructionRecetteService.create(6,
				"Pendant ce temps, faites cuire les tagliatelles fraîches dans une casserole d'eau bouillante en suivant le temps indiqué sur le paquet.");
		// -- Instruction 66 --//
		_instructionRecetteService.create(6,
				"Egouttez les tagliatelles en fin de cuisson et dressez-les dans les assiettes.");
		// -- Instruction 67 --//
		_instructionRecetteService.create(6,
				"Nappez-les de compotée au potiron puis parsemez-les de roquefort émietté et de basilic ciselé.");
		// -- Instruction 68 --//
		_instructionRecetteService.create(6, "Dégustez sans attendre.");

		/* Recette 7 */
		_recetteService.create(new Recette("Mijoté de boeuf maigre façon bourguignon à la tomate", 4, comm3, 3.6, 77,
				LocalTime.of(2, 0), true));

		/// Ingredient 25 ///
		_ingredientService.create(new Ingredient("Viande de boeuf dégraissée", 100, 1, 12, false, false, Unite.g));
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
		_instructionRecetteService.create(7, "Pelez et émincez les oignons et les carottes.");
		// -- Instruction 70 --//
		_instructionRecetteService.create(7, "Coupez en morceaux la viande de boeuf.");
		// -- Instruction 71 --//
		_instructionRecetteService.create(7, "Faites fondre le beurre avec un filet d'huile d'olive dans une cocotte.");
		// -- Instruction 72 --//
		_instructionRecetteService.create(7, "Faites-y suer les oignons jusqu'à ce qu'ils soient dorés.");
		// -- Instruction 73 --//
		_instructionRecetteService.create(7,
				"Ajoutez la viande de boeuf et laissez dorer en mélangeant régulièrement.");
		// -- Instruction 74 --//
		_instructionRecetteService.create(7,
				"Faites dissoudre le cube de bouillon dans le verre d'eau et versez dans la cocotte. Ajoutez les vinaigres puis salez et poivrez.");
		// -- Instruction 75 --//
		_instructionRecetteService.create(7, "Couvrez et laissez mijoter 20 minutes à feu doux.");
		// -- Instruction 76 --//
		_instructionRecetteService.create(7,
				"Ajoutez les carottes émincées puis poursuivez la cuisson pendant environ 1h10, toujours à feu doux et à couvert.");
		// -- Instruction 77 --//
		_instructionRecetteService.create(7,
				"En fin de cuisson, ajoutez la sauce tomate puis la fécule de maïs et mélangez bien.");
		// -- Instruction 78 --//
		_instructionRecetteService.create(7, "Rectifiez l'assaisonnement si besoin puis servez immédiatement.");

		/* Recette 8 */
		_recetteService
				.create(new Recette("Curry light de dinde aux légumes", 4, comm1, 3, 63, LocalTime.of(1, 15), true));

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
				"Mettez-y l'oignon, l'ail et toutes les épices puis faites suer jusqu'à ce que l'oignon soit translucide.");
		// -- Instruction 82 --//
		_instructionRecetteService.create(8,
				"Coupez les escalopes de dinde en dés puis ajoutez-les dans la sauteuse. Laissez cuire 5 minutes en mélangeant.");
		// -- Instruction 83 --//
		_instructionRecetteService.create(8,
				"Pelez et coupez en rondelles les carottes. Nettoyez et égouttez les haricots verts. Quand la dinde est dorée, ajoutez les légumes dans la sauteuse et mélangez.");
		// -- Instruction 84 --//
		_instructionRecetteService.create(8,
				"Versez 25 cl d'eau, remuez, couvrez et laissez cuire pendant 1 heure à feu doux.");
		// -- Instruction 85 --//
		_instructionRecetteService.create(8,
				"Au bout de ce temps, ajoutez la poudre de coco diluée dans 10 cl d'eau et remuez bien. Laissez mijoter encore 5 minutes.");
		// -- Instruction 86 --//
		_instructionRecetteService.create(8, "Rectifiez l'assaisonnement en sel et en poivre et mélangez.");
		// -- Instruction 87 --//
		_instructionRecetteService.create(8, "Servez accompagné de riz blanc.");

		/* Recette 9: 4 personnes */
		_recetteService.create(
				new Recette("Soupe de légumes diététique au quinoa", 4, comm1, 3.7, 30, LocalTime.of(0, 50), true));

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
		_instructionRecetteService.create(9, "Nettoyez et émincez en fines rondelles les poireaux.");
		// -- Instruction 90 --//
		_instructionRecetteService.create(9, "Pelez et hachez l'oignon.");
		// -- Instruction 91 --//
		_instructionRecetteService.create(9, "Faites fondre une noix de beurre dans une cocotte.");
		// -- Instruction 92 --//
		_instructionRecetteService.create(9, "Faites-y suer l'oignon jusqu'à ce qu'il soit translucide.");
		// -- Instruction 93 --//
		_instructionRecetteService.create(9, "Ajoutez les légumes puis recouvrez d'eau à hauteur.");
		// -- Instruction 94 --//
		_instructionRecetteService.create(9, "Couvrez et portez à ébullition à feu doux.");
		// -- Instruction 95 --//
		_instructionRecetteService.create(9,
				"Ajoutez le quinoa dans la cocotte puis faites cuire à couvert pendant 30 minutes, jusqu'à ce que les carottes et les pommes de terre soient tendres.");
		// -- Instruction 96 --//
		_instructionRecetteService.create(9,
				"Salez et poivrez à votre goût en fin de cuisson. Ajoutez le persil ciselé.");
		// -- Instruction 97 --//
		_instructionRecetteService.create(9, "Servez bien chaud.");

		/* Recette 10: 8 personnes */
		_recetteService.create(new Recette("Tarte light thon-épinards", 8, comm4, 4.9, 16, LocalTime.of(1, 0), false));

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
		_instructionRecetteService.create(10, "Faites fondre le beurre avec l’eau dans une casserole à feu doux.");
		// -- Instruction 99 --//
		_instructionRecetteService.create(10,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de blé et le sucre en poudre (en option).");
		// -- Instruction 100 --//
		_instructionRecetteService.create(10,
				"Malaxez bien le mélange avec vos mains, pendant plusieurs minutes, jusqu’à obtenir une boule de pâte bien lisse et homogène.");
		// -- Instruction 101 --//
		_instructionRecetteService.create(10,
				"Couvrez le saladier avec du film alimentaire et placez la boule de pâte au frais pendant 10 min minimum.");
		// -- Instruction 102 --//
		_instructionRecetteService.create(10,
				"C'est prêt ! Dégazez la pâte sur un plan de travail fariné.Pour cela, tapez énergiquement sur la pâte pour en enlever le gaz carbonique emprisonné dans les bulles d'air.");
		// -- Instruction 103 --//
		_instructionRecetteService.create(10,
				"Puis étalez-la à l'aide d'un rouleau à pâtisserie. Déposez ensuite votre fond de tarte dans un plat à tarte recouvert de papier sulfurisé et piquez son fond avec une fourchette.");

		// -- Instruction 104 --//
		_instructionRecetteService.create(10, "Préchauffez le four à 180°C.");
		// -- Instruction 105 --//
		_instructionRecetteService.create(10, "Foncez la pâte dans un moule à tarte recouvert de papier sulfurisé.");
		// -- Instruction 106 --//
		_instructionRecetteService.create(10, "Piquez le fond avec une fourchette. Réservez.");
		// -- Instruction 107 --//
		_instructionRecetteService.create(10, "Egouttez puis émiettez le thon à la fourchette dans un saladier.");
		// -- Instruction 108 --//
		_instructionRecetteService.create(10, "Ajoutez les épinards hachés et mélangez bien. Réservez.");
		// -- Instruction 109 --//
		_instructionRecetteService.create(10, "Battez les oeufs avec la crème fraîche dans un saladier.");
		// -- Instruction 110 --//
		_instructionRecetteService.create(10,
				"Ajoutez le mélange thon-épinards et remuez bien. Salez et poivrez à votre goût.");
		// -- Instruction 111 --//
		_instructionRecetteService.create(10,
				"Versez le mélange sur le fond de pâte dans le moule. Parsemez de gruyère râpé.");
		// -- Instruction 112 --//
		_instructionRecetteService.create(10, "Enfournez pendant 35 minutes jusqu'à ce que la tarte soit bien dorée.");
		// -- Instruction 113 --//
		_instructionRecetteService.create(10, "Servez chaud ou froid accompagné d'une salade verte assaisonnée.");

		/* Recette 11: 4 personnes */
		_recetteService.create(new Recette("Endives au jambon minceur gratinées au gruyère", 4, comm1, 4.4, 67,
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
		_instructionRecetteService.create(11, "Préchauffez le four à 180°C.");
		// -- Instruction 115 --//
		_instructionRecetteService.create(11,
				"Nettoyez les endives, puis enroulez-les dans une tranche de jambon. Déposez les endives dans un plat à gratin.");
		// -- Instruction 116 --//
		_instructionRecetteService.create(11,
				"Dans un bol, mélangez la crème, du sel, du poivre et la muscade. Versez sur les endives.");
		// -- Instruction 117 --//
		_instructionRecetteService.create(11,
				"Parsemez de gruyère râpé, puis ciselez le persil lavé par-dessus, et enfournez pour 35 à 40 minutes.");
		// -- Instruction 118 --//
		_instructionRecetteService.create(11, "Servez bien chaud et accompagnez d’une poêlée de légumes !");

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
		_instructionRecetteService.create(12, "Préchauffez le four à 180°C.");
		// -- Instruction 119 --//
		_instructionRecetteService.create(12,
				"Emincez et épluchez les échalotes en petits morceaux. Epluchez et coupez les carottes en petits cubes. Lavez, épépinez et coupez les poivrons en fines lamelles.");
		// -- Instruction 120 --//
		_instructionRecetteService.create(12,
				"Dans une poêle sur feu moyen, faites cuire les poivrons et les carottes avec un peu d'huile d'olive, jusqu'à ce qu'ils soient tendres.");
		// -- Instruction 121 --//
		_instructionRecetteService.create(12,
				"Sur 4 feuilles de papier sulfurisé, déposez les légumes revenus à la poêle, les échalotes, du sel, du poivre et les filets de merlan sur le dessus. Salez, poivrez et déposez quelques brins de persil haché. Arrosez d'un filet d'huile d'olive.");
		// -- Instruction 122 --//
		_instructionRecetteService.create(12,
				"Déposez les papillotes dans un plat allant au four. Versez le vin blanc et refermez-les définitivement. Enfournez pendant 30 minutes.");
		// -- Instruction 123 --//
		_instructionRecetteService.create(12, "Servez immédiatement à la sortie du four avec du riz nature.");

		/* Recette 13 */
		_recetteService.create(new Recette("Ragoût cramoisi de betterave, chou et bacon", 5, comm3, 2.1, 28,
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
				"Épluchez les betteraves et détaillez-les en dés. Pelez et émincez l’oignon. Coupez le trognon du chou et émincez-le. Pelez et écrasez l’ail. Coupez le bacon en dés.");
		// -- Instruction 125 --//
		_instructionRecetteService.create(13,
				"Faites fondre l’oignon quelques minutes avec l’huile dans une cocotte, puis ajoutez les légumes et les dés de bacon. Laissez cuire 5 minutes à feu moyen.");
		// -- Instruction 126 --//
		_instructionRecetteService.create(13,
				"Ajoutez le cube de bouillon et 25 cl d’eau. Salez, poivrez, ajoutez le persil et le laurier.");
		// -- Instruction 127 --//
		_instructionRecetteService.create(13, "Ramenez à feu doux et laissez mijoter 1 h 30.");
		// -- Instruction 128 --//
		_instructionRecetteService.create(13, "Servez chaud !");

		/* Recette 14 */
		_recetteService.create(new Recette("Omelette au saumon fumé", 2, comm2, 4.1, 11, LocalTime.of(0, 30), true));

		// RecetteIngredient 61
		_recetteIngredientService.create(14, 17, 480);

		/// Ingredient 38 ///
		_ingredientService.create(new Ingredient("Tranche de saumon fumé", 117, 2, 8, true, false, Unite.g));
		// RecetteIngredient 62
		_recetteIngredientService.create(14, 38, 200);

		/// Ingredient 39 ///
		_ingredientService.create(new Ingredient("Citron jaune", 29, 1, 4, true, true, Unite.g));
		// RecetteIngredient 63
		_recetteIngredientService.create(14, 39, 60);

		// -- Instruction 129 --//
		_instructionRecetteService.create(14, "Découpez les tranches de saumon fumé en fines lanières.");
		// -- Instruction 130 --//
		_instructionRecetteService.create(14,
				"Pressez le demi citron afin de récupérer son jus. Retirez-y les pépins si besoin.");
		// -- Instruction 131 --//
		_instructionRecetteService.create(14,
				"Placez les lanières de saumon fumé dans un bol et arrosez-les avec le jus de citron. Mélangez bien puis réservez de côté.");
		// -- Instruction 132 --//
		_instructionRecetteService.create(14, "Lavez les peluches de persil et épongez-les (facultatif).");
		// -- Instruction 133 --//
		_instructionRecetteService.create(14,
				"Battez 2 oeufs à la fourchette dans un récipient. Salez et poivrez selon vos goûts.");
		// -- Instruction 134 --//
		_instructionRecetteService.create(14,
				"Faites fondre la noix de beurre allégé dans une poêle anti-adhésive sur feu moyen.");
		// -- Instruction 135 --//
		_instructionRecetteService.create(14,
				"Versez-y les 2 oeufs battus puis faites-les cuire 3 à 4 minutes sur feu doux ou jusqu’à obtenir une omelette bien prise.");
		// -- Instruction 136 --//
		_instructionRecetteService.create(14,
				"Retirez alors l'omelette de la poêle et déposez-la dans une assiette. Réservez au chaud.");
		// -- Instruction 137 --//
		_instructionRecetteService.create(14,
				"Répétez l’opération de cuisson pour cuire les trois autres omelettes avec le restant d’oeufs frais.");
		// -- Instruction 138 --//
		_instructionRecetteService.create(14,
				"Quand toutes les omelettes sont cuites, répartissez les lanières de saumon fumé sur le dessus. Parsemez enfin de peluches de persil frais (facultatif), puis repliez un bord des omelettes sur l’autre.");
		// -- Instruction 139 --//
		_instructionRecetteService.create(14,
				"Servez tiède et dégustez ces omelettes en guise de plat principal, accompagnées d’une salade verte assaisonnée et de tranches de pain grillé. Pendant les fêtes de fin d’année, accompagnez cette recette avec un vin blanc ou rosé, pétillant ou non, bien fruité et frais.");
		// -- Instruction 140 --//
		_instructionRecetteService.create(14,
				"Astuce : Vous aimez l’aneth ? N’hésitez pas à en incorporer ciselé dans les oeufs battus avant cuisson des omelettes. Tout aussi bon !");

		/* Recette 15 */
		_recetteService.create(
				new Recette("Gratin de chou fleur persillé au comté", 4, comm3, 3.6, 56, LocalTime.of(1, 0), true));

		/// Ingredient 40 ///
		_ingredientService.create(new Ingredient("Chou fleur", 25, 5, 11, true, true, Unite.g));
		// RecetteIngredient 64
		_recetteIngredientService.create(15, 40, 60);

		/// Ingredient 41 ///
		_ingredientService.create(new Ingredient("Comté", 29, 1, 12, true, false, Unite.g));
		// RecetteIngredient 65
		_recetteIngredientService.create(15, 41, 390);

		/// Ingredient 42 ///
		_ingredientService.create(new Ingredient("Crème allégée", 108, 1, 12, true, false, Unite.mL));
		// RecetteIngredient 66
		_recetteIngredientService.create(15, 42, 300);

		// RecetteIngredient 67
		_recetteIngredientService.create(15, 10, 7);

		// -- Instruction 141 --//
		_instructionRecetteService.create(15, "Détacher les fleurs du chou et les cuire 5 minutes à l’auto-cuiseur.");
		// -- Instruction 142 --//
		_instructionRecetteService.create(15,
				"Dans un saladier, mélanger la crème, le Comté râpé, le persil haché et une gousse d’ail écrasée.");
		// -- Instruction 143 --//
		_instructionRecetteService.create(15,
				"Déposer les fleurs de chou dans un plat à gratin et arroser avec la préparation.");
		// -- Instruction 144 --//
		_instructionRecetteService.create(15,
				"Enfourner dans un four préchauffé à 180°C pour 30 minutes de cuisson environ.");
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
	
	@Test //2nd chose a faire => config spring => update
	@Transactional
	@Commit
	//@Disabled
	public void update2BDD() {
		updateRecetteWithVeganVegetarien();
	}
}
