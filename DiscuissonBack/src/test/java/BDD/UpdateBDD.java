package BDD;

import java.time.LocalTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JpaConfig;
import model.Ingredient;
import model.Recette;
import model.Unite;
import service.IngredientService;
import service.InstructionRecetteService;
import service.RecetteIngredientService;
import service.RecetteService;

/*
 * Code DEGUEULASSE mais normalement fonctionnel
 * PS: Ne pas oublier de se mettre en: create
 * attribut vegan, vegetarien, date ne fonctionne pas!
 * 
 * Source: https://www.fourchette-et-bikini.fr/cuisine/recettes-minceur/15-plats-dhiver-legers-et-gourmands.html
 * https://www.cuisineaz.com/recettes/pate-a-tarte-maison-rapide-36657.aspx
 */

public class UpdateBDD {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext _ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		IngredientService _ingredientService = _ctx.getBean(IngredientService.class);
		RecetteIngredientService _recetteIngredientService = _ctx.getBean(RecetteIngredientService.class);
		RecetteService _recetteService = _ctx.getBean(RecetteService.class);
		InstructionRecetteService _instructionRecetteService = _ctx.getBean(InstructionRecetteService.class);
		Recette _recette = new Recette();
		Ingredient _ingredient = new Ingredient();

		/* Recette 1: 8 personnes */
		_recette.setId(null);
		_recette.setName("Tartiflette sans lardons au gruyère léger");
		_recette.setTempsDeCuisine(LocalTime.of(1, 30));
		_recette.setNote(4); // 3.7/5 - 51 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 1 ///
		_ingredient.setId(null);
		_ingredient.setName("Pomme de terre");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(73);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 1
		_recetteIngredientService.create(_recette, _ingredient, 1000);
		
		/// Ingredient 2 ///
		_ingredient.setId(null);
		_ingredient.setName("Jambon maigre");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(112);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);
		
		System.out.println(_recette.getId() + " + " + _ingredient.getId());

		// RecetteIngredient 2
		_recetteIngredientService.create(_recette, _ingredient, 100);
		
		/// Ingredient 3 ///
		_ingredient.setId(null);
		_ingredient.setName("Gruyere allégé");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(213);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		System.out.println(_recette.getId() + " + " + _ingredient.getId());
		
		// RecetteIngredient 3
		_recetteIngredientService.create(_recette, _ingredient, 200);

		/// Ingredient 4 ///
		_ingredient.setId(null);
		_ingredient.setName("Oignon");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(43);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);
		
		System.out.println(_recette.getId() + " + " + _ingredient.getId());

		// RecetteIngredient 4
		_recetteIngredientService.create(_recette, _ingredient, 300);

		/// Ingredient 5 ///
		_ingredient.setId(null);
		_ingredient.setName("Crème fraîche légère");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(192);
		_ingredient.setUnite(Unite.mL);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 5
		_recetteIngredientService.create(_recette, _ingredient, 100);

		// -- Instruction 1 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 210 degrés");
		// -- Instruction 2 --//
		_instructionRecetteService.create(_recette, "Pelez et coupez les pommes de terre en fines rondelles.");
		// -- Instruction 3 --//
		_instructionRecetteService.create(_recette, "Pelez et taillez les oignons en fines lamelles.");
		// -- Instruction 4 --//
		_instructionRecetteService.create(_recette,
				"Déposez une couche de pommes de terre puis une couche d'oignons dans le fond d'un plat à gratin.");
		// -- Instruction 5 --//
		_instructionRecetteService.create(_recette,
				"Recouvrez avec une couche de dés de jambon puis une couche de gruyère râpé.");
		// -- Instruction 6 --//
		_instructionRecetteService.create(_recette,
				"Redéposez une couche de pommes de terre, une couche d'oignons,..., et ainsi de suite jusqu'à épuisement des ingrédients, en terminant par une couche de pommes de terre.");
		// -- Instruction 7 --//
		_instructionRecetteService.create(_recette,
				"Mélangez si vous le souhaitez, la crème fraîche avec du persil ciselé, du sel et du poivre dans un bol.");
		// -- Instruction 8 --//
		_instructionRecetteService.create(_recette,
				"Versez la crème fraîche sur les pommes de terre dans le plat. Parsemez d'un peu de gruyère râpé.");
		// -- Instruction 9 --//
		_instructionRecetteService.create(_recette,
				"Enfournez pendant 1 heure à 1h15 de cuisson jusqu'à ce que la tartiflette soit bien dorée.");
		// -- Instruction 10 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud accompagné d'une salade verte assaisonnée.");

		/* Recette 2: 4 personnes */
		_recette.setId(null);
		_recette.setName("Lasagnes minceur au thon et au parmesan léger");
		_recette.setTempsDeCuisine(LocalTime.of(0, 40));
		_recette.setNote(4); // 4.3/5 - 127 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 6 ///
		_ingredient.setId(null);
		_ingredient.setName("Feuille de lasagnes");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(284);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 6
		_recetteIngredientService.create(_recette, _ingredient, 240);

		/// Ingredient 7 ///
		_ingredient.setName("Thon");
		_ingredient.setId(null);
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(132);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 7
		_recetteIngredientService.create(_recette, _ingredient, 280);

		/// Ingredient 8 ///
		_ingredient.setId(null);
		_ingredient.setName("Sauce tomate");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(29);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 8
		_recetteIngredientService.create(_recette, _ingredient, 400);

		// RecetteIngredient 9
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredient.setId(null);

		// -- Instruction 11 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 180 degrés.");
		// -- Instruction 12 --//
		_instructionRecetteService.create(_recette, "Emiettez le thon dans un saladier à l'aide d'une fourchette.");
		// -- Instruction 13 --//
		_instructionRecetteService.create(_recette, "Ajoutez-y la sauce tomate et mélangez bien.");
		// -- Instruction 14 --//
		_instructionRecetteService.create(_recette, "Placez des feuilles à lasagnes dans le fond d'un plat à gratin.");
		// -- Instruction 15 --//
		_instructionRecetteService.create(_recette,
				"Recouvrez avec une couche de crème fraîche puis une couche de préparation thon-sauce tomate.");
		// -- Instruction 16 --//
		_instructionRecetteService.create(_recette,
				"Replacez des feuilles à lasagnes sur le dessus puis une nouvelle couche de crème fraîche et de préparation au thon.");
		// -- Instruction 17 --//
		_instructionRecetteService.create(_recette,
				"Répétez l'opération jusqu'à épuisement des ingrédients, en terminant par une couche de crème fraîche.");
		// -- Instruction 18 --//
		_instructionRecetteService.create(_recette, "Bonus: Parsemez le plat avec le parmesan râpé.");
		// -- Instruction 19 --//
		_instructionRecetteService.create(_recette,
				"Enfournez pendant 30 minutes jusqu'à ce que les lasagnes soient bien gratinées.");
		// -- Instruction 20 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud accompagné d'une salade verte assaisonnée.");

		/* Recette 3: 4 personnes */
		_recette.setId(null);
		_recette.setName("Dos de cabillaud à la crème légère à l'ail");
		_recette.setTempsDeCuisine(LocalTime.of(0, 30));
		_recette.setNote(4); // 3.9/5 - 55 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 9 ///
		_ingredient.setId(null);
		_ingredient.setName("Dos de cabillaud");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(95);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 10
		_recetteIngredientService.create(_recette, _ingredient, 700);

		/// Ingredient 10 ///
		_ingredient.setId(null);
		_ingredient.setName("Gousse d'ail");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(149);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 11
		_recetteIngredientService.create(_recette, _ingredient, 140);

		// RecetteIngredient 12
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 200);
		_ingredient.setId(null);

		// -- Instruction 21 --//
		_instructionRecetteService.create(_recette,
				"Epluchez les gousses d'ail. Faites-les cuire pendant 20 minutes dans une casserole d'eau bouillante.");
		// -- Instruction 22 --//
		_instructionRecetteService.create(_recette,
				"Une fois les gousses d'ail cuites, égouttez-les et mixez-les avec la crème liquide dans un blender.");
		// -- Instruction 23 --//
		_instructionRecetteService.create(_recette,
				"Bonus: Ajouter du persil frais. Ajoutez-le au mélange avec un peu de sel et de poivre. Réservez.");
		// -- Instruction 24 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre une noix de beurre dans une poêle et faites-y cuire de chaque côté les dos de cabillaud jusqu'à obtenir la cuisson désirée.");
		// -- Instruction 25 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, réchauffez la crème à l'ail dans une casserole à feu doux.");
		// -- Instruction 26 --//
		_instructionRecetteService.create(_recette,
				"Servez les dos de cabillaud dans les assiettes et nappez-les de crème à l'ail.");
		// -- Instruction 27 --//
		_instructionRecetteService.create(_recette, "Dégustez.");

		/* Recette 4: 4 personnes */
		_recette.setId(null);
		_recette.setName("Quiche légère poulet, champignons et brocoli");
		_recette.setTempsDeCuisine(LocalTime.of(0, 50));
		_recette.setNote(4); // 3.6/5
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 11 ///
		_ingredient.setId(null);
		_ingredient.setName("Farine de blé");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(149);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 13
		_recetteIngredientService.create(_recette, _ingredient, 250);

		/// Ingredient 12 ///
		_ingredient.setId(null);
		_ingredient.setName("Beurre");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(717);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 14
		_recetteIngredientService.create(_recette, _ingredient, 125);

		/// Ingredient 13 ///
		_ingredient.setId(null);
		_ingredient.setName("Eau");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(0);
		_ingredient.setUnite(Unite.mL);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 15
		_recetteIngredientService.create(_recette, _ingredient, 250);

		/// Ingredient 14 ///
		_ingredient.setId(null);
		_ingredient.setName("Blanc de poulet");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(120);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 16
		_recetteIngredientService.create(_recette, _ingredient, 500);

		/// Ingredient 15 ///
		_ingredient.setId(null);
		_ingredient.setName("Brocoli");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(34);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 17
		_recetteIngredientService.create(_recette, _ingredient, 300);

		/// Ingredient 16 ///
		_ingredient.setId(null);
		_ingredient.setName("Champignon");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(22);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 18
		_recetteIngredientService.create(_recette, _ingredient, 200);

		/// Ingredient 17 ///
		_ingredient.setId(null);
		_ingredient.setName("Oeuf");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(155);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 19
		_recetteIngredientService.create(_recette, _ingredient, 180);

		// RecetteIngredient 20
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 100);
		_ingredient.setId(null);

		// -- Instruction 28 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre le beurre avec l’eau dans une casserole à feu doux.");
		// -- Instruction 29 --//
		_instructionRecetteService.create(_recette,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de blé et le sucre en poudre (en option).");
		// -- Instruction 30 --//
		_instructionRecetteService.create(_recette,
				"Malaxez bien le mélange avec vos mains, pendant plusieurs minutes, jusqu’à obtenir une boule de pâte bien lisse et homogène.");
		// -- Instruction 31 --//
		_instructionRecetteService.create(_recette,
				"Couvrez le saladier avec du film alimentaire et placez la boule de pâte au frais pendant 10 min minimum.");
		// -- Instruction 32 --//
		_instructionRecetteService.create(_recette,
				"C'est prêt ! Dégazez la pâte sur un plan de travail fariné.Pour cela, tapez énergiquement sur la pâte pour en enlever le gaz carbonique emprisonné dans les bulles d'air.");
		// -- Instruction 33 --//
		_instructionRecetteService.create(_recette,
				"Puis étalez-la à l'aide d'un rouleau à pâtisserie. Déposez ensuite votre fond de tarte dans un plat à tarte recouvert de papier sulfurisé et piquez son fond avec une fourchette.");

		// -- Instruction 34 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 220°C.");
		// -- Instruction 35 --//
		_instructionRecetteService.create(_recette,
				"Foncez la pâte dans un moule à tarte recouvert de papier sulfurisé.");
		// -- Instruction 36 --//
		_instructionRecetteService.create(_recette, "Piquez le fond avec une fourchette. Réservez.");
		// -- Instruction 37 --//
		_instructionRecetteService.create(_recette, "Coupez les blancs de poulet en morceaux.");
		// -- Instruction 38 --//
		_instructionRecetteService.create(_recette, "Nettoyez et émincez en tranches les champignons de Paris.");
		// -- Instruction 39 --//
		_instructionRecetteService.create(_recette,
				"Faites dorer le poulet dans une poêle anti-adhésive pendant 5 minutes.");
		// -- Instruction 40 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez les champignons émincés et laissez cuire jusqu'à ce qu'ils aient rendu leur eau.");
		// -- Instruction 41 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, faites cuire les fleurons de brocoli dans une casserole d'eau bouillante pendant 10 minutes.");
		// -- Instruction 42 --//
		_instructionRecetteService.create(_recette, "Répartissez le mélange poulet-champignons dans le fond de pâte.");
		// -- Instruction 43 --//
		_instructionRecetteService.create(_recette,
				"Egouttez les fleurons de brocoli et répartissez-les sur le dessus du mélange poulet-champignons.");
		// -- Instruction 44 --//
		_instructionRecetteService.create(_recette,
				"Battez les oeufs avec la crème fraîche et le lait dans un bol. Ajoutez du persil ciselé puis salez et poivrez.");
		// -- Instruction 45 --//
		_instructionRecetteService.create(_recette,
				"Versez le mélange aux oeufs sur la garniture au poulet dans le moule.");
		// -- Instruction 46 --//
		_instructionRecetteService.create(_recette,
				"Enfournez la quiche pendant 30 minutes jusqu'à ce qu'elle soit dorée.");
		// -- Instruction 47 --//
		_instructionRecetteService.create(_recette,
				"Dégustez chaud ou froid accompagné d'une salade verte assaisonnée.");

		/* Recette 5: 4 personnes */
		_recette.setId(null);
		_recette.setName(" Hachis parmentier sans viande aux légumes");
		_recette.setTempsDeCuisine(LocalTime.of(1, 15));
		_recette.setNote(3); // 3.3/5 - 60 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 21
		_ingredient.setId(1);
		_recetteIngredientService.create(_recette, _ingredient, 400);
		_ingredient.setId(null);

		/// Ingredient 18 ///
		_ingredient.setId(null);
		_ingredient.setName("Navet");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(28);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);
		
		// RecetteIngredient 22
		_recetteIngredientService.create(_recette, _ingredient, 300);

		/// Ingredient 19 ///
		_ingredient.setId(null);
		_ingredient.setName("Carotte");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(41);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 23
		_recetteIngredientService.create(_recette, _ingredient, 375);

		/// Ingredient 20 ///
		_ingredient.setId(null);
		_ingredient.setName("Poireau");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(61);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 24
		_recetteIngredientService.create(_recette, _ingredient, 160);

		// RecetteIngredient 25
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredient.setId(null);

		// RecetteIngredient 26
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 7);
		_ingredient.setId(null);

		// -- Instruction 48 --//
		_instructionRecetteService.create(_recette,
				"Pelez et coupez en morceaux les carottes, le navet, les branches de céleri, les oignons et l'ail.");
		// -- Instruction 49 --//
		_instructionRecetteService.create(_recette,
				"Mixez les légumes dans un blender jusqu'à obtenir un hachis bien homogène. Réservez.");
		// -- Instruction 50 --//
		_instructionRecetteService.create(_recette,
				"Pelez les pommes de terre et coupez-les en cubes. Nettoyez et émincez en rondelles le poireau.");
		// -- Instruction 51 --//
		_instructionRecetteService.create(_recette,
				"Faites cuire les pommes de terre et le poireau dans une casserole d'eau bouillante salée pendant 20 minutes.");
		// -- Instruction 52 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, faites chauffer l'huile d'olive dans une sauteuse.");
		// -- Instruction 53 --//
		_instructionRecetteService.create(_recette,
				"Faites revenir le hachis de légumes dans la sauteuse pendant 15 minutes en remuant régulièrement. Salez et poivrez puis ajoutez le persil ciselé.");
		// -- Instruction 54 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 200 degré.");
		// -- Instruction 55 --//
		_instructionRecetteService.create(_recette,
				"Répartissez le hachis de légumes dans le fond d'un plat à gratin. Réservez.");
		// -- Instruction 56 --//
		_instructionRecetteService.create(_recette,
				"Egouttez les pommes de terre et le poireau et écrasez-les en purée épaisse dans un saladier, à l'aide d'une fourchette. Rectifiez l'assaisonnement.");
		// -- Instruction 57 --//
		_instructionRecetteService.create(_recette,
				"Recouvrez le hachis de légumes avec la purée de pommes de terre au poireau.");
		// -- Instruction 58 --//
		_instructionRecetteService.create(_recette,
				"Striez le hachis avec les dents d'une fourchette puis enfournez pendant 35 minutes jusqu'à ce qu'il soit bien doré.");
		// -- Instruction 59 --//
		_instructionRecetteService.create(_recette, "Dégustez bien chaud.");

		/* Recette 6: 4 personnes */
		_recette.setId(null);
		_recette.setName("Tagliatelles légères lentilles, potiron et roquefort");
		_recette.setTempsDeCuisine(LocalTime.of(1, 30));
		_recette.setNote(4); // 3.7/5 - 46 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 21 ///
		_ingredient.setId(null);
		_ingredient.setName("Tagliatelle sans oeuf");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(288);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 27
		_recetteIngredientService.create(_recette, _ingredient, 200);

		/// Ingredient 22 ///
		_ingredient.setId(null);
		_ingredient.setName("Chair de potiron");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(30);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 28
		_recetteIngredientService.create(_recette, _ingredient, 300);

		/// Ingredient 23 ///
		_ingredient.setId(null);
		_ingredient.setName("Lentille verte");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(127);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 29
		_recetteIngredientService.create(_recette, _ingredient, 200);

		// RecetteIngredient 30
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredient.setId(null);

		/// Ingredient 24 ///
		_ingredient.setId(null);
		_ingredient.setName("Rocquefort");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(369);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 31
		_recetteIngredientService.create(_recette, _ingredient, 60);

		// -- Instruction 60 --//
		_instructionRecetteService.create(_recette, "Coupez la chair de potiron en petits cubes.");
		// -- Instruction 61 --//
		_instructionRecetteService.create(_recette, "Pelez et hachez l'oignon.");
		// -- Instruction 62 --//
		_instructionRecetteService.create(_recette, "Faites chauffer 1 c. à soupe d'huile d'olive dans une poêle.");
		// -- Instruction 63 --//
		_instructionRecetteService.create(_recette,
				"Faites blondir l'oignon, les cubes de potiron et les lentilles vertes égouttées pendant 5 minutes en mélangeant bien.");
		// -- Instruction 64 --//
		_instructionRecetteService.create(_recette,
				"Versez le vin blanc puis salez et poivrez. Laissez compoter pendant 15 minutes.");
		// -- Instruction 65 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, faites cuire les tagliatelles fraîches dans une casserole d'eau bouillante en suivant le temps indiqué sur le paquet.");
		// -- Instruction 66 --//
		_instructionRecetteService.create(_recette,
				"Egouttez les tagliatelles en fin de cuisson et dressez-les dans les assiettes.");
		// -- Instruction 67 --//
		_instructionRecetteService.create(_recette,
				"Nappez-les de compotée au potiron puis parsemez-les de roquefort émietté et de basilic ciselé.");
		// -- Instruction 68 --//
		_instructionRecetteService.create(_recette, "Dégustez sans attendre.");

		/* Recette 7 */
		_recette.setId(null);
		_recette.setName("Mijoté de boeuf maigre façon bourguignon à la tomate");
		_recette.setTempsDeCuisine(LocalTime.of(2, 0));
		_recette.setNote(4); // 3.6/5 - 77 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 25 ///
		_ingredient.setId(null);
		_ingredient.setName("Viande de boeuf dégraissée");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(100);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 32
		_recetteIngredientService.create(_recette, _ingredient, 800);

		// RecetteIngredient 33
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 375);
		_ingredient.setId(null);

		// RecetteIngredient 34
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredient.setId(null);

		// RecetteIngredient 35
		_ingredient.setId(13);
		_recetteIngredientService.create(_recette, _ingredient, 225);
		_ingredient.setId(null);

		// RecetteIngredient 36
		_ingredient.setId(8);
		_recetteIngredientService.create(_recette, _ingredient, 45);
		_ingredient.setId(null);

		// -- Instruction 69 --//
		_instructionRecetteService.create(_recette, "Pelez et émincez les oignons et les carottes.");
		// -- Instruction 70 --//
		_instructionRecetteService.create(_recette, "Coupez en morceaux la viande de boeuf.");
		// -- Instruction 71 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre le beurre avec un filet d'huile d'olive dans une cocotte.");
		// -- Instruction 72 --//
		_instructionRecetteService.create(_recette, "Faites-y suer les oignons jusqu'à ce qu'ils soient dorés.");
		// -- Instruction 73 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez la viande de boeuf et laissez dorer en mélangeant régulièrement.");
		// -- Instruction 74 --//
		_instructionRecetteService.create(_recette,
				"Faites dissoudre le cube de bouillon dans le verre d'eau et versez dans la cocotte. Ajoutez les vinaigres puis salez et poivrez.");
		// -- Instruction 75 --//
		_instructionRecetteService.create(_recette, "Couvrez et laissez mijoter 20 minutes à feu doux.");
		// -- Instruction 76 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez les carottes émincées puis poursuivez la cuisson pendant environ 1h10, toujours à feu doux et à couvert.");
		// -- Instruction 77 --//
		_instructionRecetteService.create(_recette,
				"En fin de cuisson, ajoutez la sauce tomate puis la fécule de maïs et mélangez bien.");
		// -- Instruction 78 --//
		_instructionRecetteService.create(_recette, "Rectifiez l'assaisonnement si besoin puis servez immédiatement.");

		/* Recette 8: 4 personnes */
		_recette.setId(null);
		_recette.setName("Curry light de dinde aux légumes");
		_recette.setTempsDeCuisine(LocalTime.of(1, 15));
		_recette.setNote(3); // 3/5 - 63 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 26 ///
		_ingredient.setId(null);
		_ingredient.setName("Escalope de dinde");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(106);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 32
		_recetteIngredientService.create(_recette, _ingredient, 600);

		// RecetteIngredient 38
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredient.setId(null);

		// RecetteIngredient 39
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 7);
		_ingredient.setId(null);

		// RecetteIngredient 40
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredient.setId(null);

		/// Ingredient 27 ///
		_ingredient.setId(null);
		_ingredient.setName("Haricot vert");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(31);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 41
		_recetteIngredientService.create(_recette, _ingredient, 300);

		// RecetteIngredient 42
		_ingredient.setId(13);
		_recetteIngredientService.create(_recette, _ingredient, 350);
		_ingredient.setId(null);

		/// Ingredient 28 ///
		_ingredient.setId(null);
		_ingredient.setName("Lait de coco");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(230);
		_ingredient.setUnite(Unite.mL);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 41
		_recetteIngredientService.create(_recette, _ingredient, 20);

		// -- Instruction 79 --//
		_instructionRecetteService.create(_recette, "Epluchez et hachez l'oignon et l'ail.");
		// -- Instruction 80 --//
		_instructionRecetteService.create(_recette, "Faites chauffer un filet d'huile dans une sauteuse.");
		// -- Instruction 81 --//
		_instructionRecetteService.create(_recette,
				"Mettez-y l'oignon, l'ail et toutes les épices puis faites suer jusqu'à ce que l'oignon soit translucide.");
		// -- Instruction 82 --//
		_instructionRecetteService.create(_recette,
				"Coupez les escalopes de dinde en dés puis ajoutez-les dans la sauteuse. Laissez cuire 5 minutes en mélangeant.");
		// -- Instruction 83 --//
		_instructionRecetteService.create(_recette,
				"Pelez et coupez en rondelles les carottes. Nettoyez et égouttez les haricots verts. Quand la dinde est dorée, ajoutez les légumes dans la sauteuse et mélangez.");
		// -- Instruction 84 --//
		_instructionRecetteService.create(_recette,
				"Versez 25 cl d'eau, remuez, couvrez et laissez cuire pendant 1 heure à feu doux.");
		// -- Instruction 85 --//
		_instructionRecetteService.create(_recette,
				"Au bout de ce temps, ajoutez la poudre de coco diluée dans 10 cl d'eau et remuez bien. Laissez mijoter encore 5 minutes.");
		// -- Instruction 86 --//
		_instructionRecetteService.create(_recette, "Rectifiez l'assaisonnement en sel et en poivre et mélangez.");
		// -- Instruction 87 --//
		_instructionRecetteService.create(_recette, "Servez accompagné de riz blanc.");

		/* Recette 9: 4 personnes */
		_recette.setId(null);
		_recette.setName("Soupe de légumes diététique au quinoa");
		_recette.setTempsDeCuisine(LocalTime.of(0, 50));
		_recette.setNote(4); // 3.7/5 - 30 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 29 ///
		_ingredient.setId(null);
		_ingredient.setName("Quinoa");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(75);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 41
		_recetteIngredientService.create(_recette, _ingredient, 150);

		// RecetteIngredient 43
		_ingredient.setId(1);
		_recetteIngredientService.create(_recette, _ingredient, 960);
		_ingredient.setId(null);

		// RecetteIngredient 44
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 250);
		_ingredient.setId(null);

		// RecetteIngredient 45
		_ingredient.setId(20);
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredient.setId(null);

		// RecetteIngredient 46
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredient.setId(null);

		// -- Instruction 88 --//
		_instructionRecetteService.create(_recette,
				"Pelez et taillez en petits morceaux les pommes de terre et les carottes.");
		// -- Instruction 89 --//
		_instructionRecetteService.create(_recette, "Nettoyez et émincez en fines rondelles les poireaux.");
		// -- Instruction 90 --//
		_instructionRecetteService.create(_recette, "Pelez et hachez l'oignon.");
		// -- Instruction 91 --//
		_instructionRecetteService.create(_recette, "Faites fondre une noix de beurre dans une cocotte.");
		// -- Instruction 92 --//
		_instructionRecetteService.create(_recette, "Faites-y suer l'oignon jusqu'à ce qu'il soit translucide.");
		// -- Instruction 93 --//
		_instructionRecetteService.create(_recette, "Ajoutez les légumes puis recouvrez d'eau à hauteur.");
		// -- Instruction 94 --//
		_instructionRecetteService.create(_recette, "Couvrez et portez à ébullition à feu doux.");
		// -- Instruction 95 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez le quinoa dans la cocotte puis faites cuire à couvert pendant 30 minutes, jusqu'à ce que les carottes et les pommes de terre soient tendres.");
		// -- Instruction 96 --//
		_instructionRecetteService.create(_recette,
				"Salez et poivrez à votre goût en fin de cuisson. Ajoutez le persil ciselé.");
		// -- Instruction 97 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud.");

		/* Recette 10: 8 personnes */
		_recette.setId(null);
		_recette.setName("Tarte light thon-épinards");
		_recette.setTempsDeCuisine(LocalTime.of(1, 0));
		_recette.setNote(5); // 4.9/5 - 16 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 47
		_ingredient.setId(11);
		_recetteIngredientService.create(_recette, _ingredient, 250);
		_ingredient.setId(null);

		// RecetteIngredient 48
		_ingredient.setId(12);
		_recetteIngredientService.create(_recette, _ingredient, 125);
		_ingredient.setId(null);

		// RecetteIngredient 49
		_ingredient.setId(7);
		_recetteIngredientService.create(_recette, _ingredient, 125);
		_ingredient.setId(null);

		/// Ingredient 30 ///
		_ingredient.setId(null);
		_ingredient.setName("Epinard");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(23);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 50
		_recetteIngredientService.create(_recette, _ingredient, 150);

		// RecetteIngredient 51
		_ingredient.setId(17);
		_recetteIngredientService.create(_recette, _ingredient, 125);
		_ingredient.setId(null);

		// RecetteIngredient 52
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 100);
		_ingredient.setId(null);

		// -- Instruction 98 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre le beurre avec l’eau dans une casserole à feu doux.");
		// -- Instruction 99 --//
		_instructionRecetteService.create(_recette,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de blé et le sucre en poudre (en option).");
		// -- Instruction 100 --//
		_instructionRecetteService.create(_recette,
				"Malaxez bien le mélange avec vos mains, pendant plusieurs minutes, jusqu’à obtenir une boule de pâte bien lisse et homogène.");
		// -- Instruction 101 --//
		_instructionRecetteService.create(_recette,
				"Couvrez le saladier avec du film alimentaire et placez la boule de pâte au frais pendant 10 min minimum.");
		// -- Instruction 102 --//
		_instructionRecetteService.create(_recette,
				"C'est prêt ! Dégazez la pâte sur un plan de travail fariné.Pour cela, tapez énergiquement sur la pâte pour en enlever le gaz carbonique emprisonné dans les bulles d'air.");
		// -- Instruction 103 --//
		_instructionRecetteService.create(_recette,
				"Puis étalez-la à l'aide d'un rouleau à pâtisserie. Déposez ensuite votre fond de tarte dans un plat à tarte recouvert de papier sulfurisé et piquez son fond avec une fourchette.");

		// -- Instruction 104 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 180°C.");
		// -- Instruction 105 --//
		_instructionRecetteService.create(_recette,
				"Foncez la pâte dans un moule à tarte recouvert de papier sulfurisé.");
		// -- Instruction 106 --//
		_instructionRecetteService.create(_recette, "Piquez le fond avec une fourchette. Réservez.");
		// -- Instruction 107 --//
		_instructionRecetteService.create(_recette, "Egouttez puis émiettez le thon à la fourchette dans un saladier.");
		// -- Instruction 108 --//
		_instructionRecetteService.create(_recette, "Ajoutez les épinards hachés et mélangez bien. Réservez.");
		// -- Instruction 109 --//
		_instructionRecetteService.create(_recette, "Battez les oeufs avec la crème fraîche dans un saladier.");
		// -- Instruction 110 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez le mélange thon-épinards et remuez bien. Salez et poivrez à votre goût.");
		// -- Instruction 111 --//
		_instructionRecetteService.create(_recette,
				"Versez le mélange sur le fond de pâte dans le moule. Parsemez de gruyère râpé.");
		// -- Instruction 112 --//
		_instructionRecetteService.create(_recette,
				"Enfournez pendant 35 minutes jusqu'à ce que la tarte soit bien dorée.");
		// -- Instruction 113 --//
		_instructionRecetteService.create(_recette, "Servez chaud ou froid accompagné d'une salade verte assaisonnée.");

		/* Recette 11: 4 personnes */
		_recette.setId(null);
		_recette.setName("Endives au jambon minceur gratinées au gruyère");
		_recette.setTempsDeCuisine(LocalTime.of(0, 50));
		_recette.setNote(4); // 4.4/5 - 67 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 53
		_ingredient.setId(3);
		_recetteIngredientService.create(_recette, _ingredient, 50);
		_ingredient.setId(null);

		// RecetteIngredient 54
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 400);
		_ingredient.setId(null);

		/// Ingredient 31 ///
		_ingredient.setId(null);
		_ingredient.setName("Endive");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(17);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 50
		_recetteIngredientService.create(_recette, _ingredient, 600);

		// RecetteIngredient 51
		_ingredient.setId(2);
		_recetteIngredientService.create(_recette, _ingredient, 200);
		_ingredient.setId(null);

		// -- Instruction 114 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 180°C.");
		// -- Instruction 115 --//
		_instructionRecetteService.create(_recette,
				"Nettoyez les endives, puis enroulez-les dans une tranche de jambon. Déposez les endives dans un plat à gratin.");
		// -- Instruction 116 --//
		_instructionRecetteService.create(_recette,
				"Dans un bol, mélangez la crème, du sel, du poivre et la muscade. Versez sur les endives.");
		// -- Instruction 117 --//
		_instructionRecetteService.create(_recette,
				"Parsemez de gruyère râpé, puis ciselez le persil lavé par-dessus, et enfournez pour 35 à 40 minutes.");
		// -- Instruction 118 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud et accompagnez d’une poêlée de légumes !");

		/* Recette 12: 4 personnes */
		_recette.setId(null);
		_recette.setName("Papillote de merlan aux poivrons");
		_recette.setTempsDeCuisine(LocalTime.of(1, 0));
		_recette.setNote(4); // 3.6/5 - 39 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 33 ///
		_ingredient.setId(null);
		_ingredient.setName("Filet de merlan");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(128);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 52
		_recetteIngredientService.create(_recette, _ingredient, 360);

		// RecetteIngredient 53
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredient.setId(null);

		/// Ingredient 33 ///
		_ingredient.setId(null);
		_ingredient.setName("Poivron jaune, rouge ou vert");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(26);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 54
		_recetteIngredientService.create(_recette, _ingredient, 500);

		/// Ingredient 34 ///
		_ingredient.setId(null);
		_ingredient.setName("Echalote");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(72);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 55
		_recetteIngredientService.create(_recette, _ingredient, 40);

		// -- Instruction 118 --//
		_instructionRecetteService.create(_recette, "Préchauffez le four à 180°C.");
		// -- Instruction 119 --//
		_instructionRecetteService.create(_recette,
				"Emincez et épluchez les échalotes en petits morceaux. Epluchez et coupez les carottes en petits cubes. Lavez, épépinez et coupez les poivrons en fines lamelles.");
		// -- Instruction 120 --//
		_instructionRecetteService.create(_recette,
				"Dans une poêle sur feu moyen, faites cuire les poivrons et les carottes avec un peu d'huile d'olive, jusqu'à ce qu'ils soient tendres.");
		// -- Instruction 121 --//
		_instructionRecetteService.create(_recette,
				"Sur 4 feuilles de papier sulfurisé, déposez les légumes revenus à la poêle, les échalotes, du sel, du poivre et les filets de merlan sur le dessus. Salez, poivrez et déposez quelques brins de persil haché. Arrosez d'un filet d'huile d'olive.");
		// -- Instruction 122 --//
		_instructionRecetteService.create(_recette,
				"Déposez les papillotes dans un plat allant au four. Versez le vin blanc et refermez-les définitivement. Enfournez pendant 30 minutes.");
		// -- Instruction 123 --//
		_instructionRecetteService.create(_recette, "Servez immédiatement à la sortie du four avec du riz nature.");

		/* Recette 13 */
		_recette.setId(null);
		_recette.setName("Ragoût cramoisi de betterave, chou et bacon");
		_recette.setTempsDeCuisine(LocalTime.of(2, 0));
		_recette.setNote(2); // 2.1/5 - 28 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 35 ///
		_ingredient.setId(null);
		_ingredient.setName("Chou blanc");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(25);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 56
		_recetteIngredientService.create(_recette, _ingredient, 700);

		/// Ingredient 36 ///
		_ingredient.setId(null);
		_ingredient.setName("Betterave");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(19);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 57
		_recetteIngredientService.create(_recette, _ingredient, 1800);

		/// Ingredient 37 ///
		_ingredient.setId(null);
		_ingredient.setName("Tranche de bacon");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(541);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 58
		_recetteIngredientService.create(_recette, _ingredient, 172);

		// RecetteIngredient 59
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredient.setId(null);

		// RecetteIngredient 60
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 21);
		_ingredient.setId(null);

		// -- Instruction 124 --//
		_instructionRecetteService.create(_recette,
				"Épluchez les betteraves et détaillez-les en dés. Pelez et émincez l’oignon. Coupez le trognon du chou et émincez-le. Pelez et écrasez l’ail. Coupez le bacon en dés.");
		// -- Instruction 125 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre l’oignon quelques minutes avec l’huile dans une cocotte, puis ajoutez les légumes et les dés de bacon. Laissez cuire 5 minutes à feu moyen.");
		// -- Instruction 126 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez le cube de bouillon et 25 cl d’eau. Salez, poivrez, ajoutez le persil et le laurier.");
		// -- Instruction 127 --//
		_instructionRecetteService.create(_recette, "Ramenez à feu doux et laissez mijoter 1 h 30.");
		// -- Instruction 128 --//
		_instructionRecetteService.create(_recette, "Servez chaud !");

		/* Recette 14: 4 personnes */
		_recette.setId(null);
		_recette.setName("Omelette au saumon fumé");
		_recette.setTempsDeCuisine(LocalTime.of(0, 23));
		_recette.setNote(4); // 4.1/5 - 11 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 61
		_ingredient.setId(17);
		_recetteIngredientService.create(_recette, _ingredient, 480);
		_ingredient.setId(null);

		/// Ingredient 38 ///
		_ingredient.setId(null);
		_ingredient.setName("Tranche de saumon fumé");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(117);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 62
		_recetteIngredientService.create(_recette, _ingredient, 200);

		/// Ingredient 39 ///
		_ingredient.setId(null);
		_ingredient.setName("Citron jaune");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(29);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 63
		_recetteIngredientService.create(_recette, _ingredient, 60);

		// -- Instruction 129 --//
		_instructionRecetteService.create(_recette, "Découpez les tranches de saumon fumé en fines lanières.");
		// -- Instruction 130 --//
		_instructionRecetteService.create(_recette,
				"Pressez le demi citron afin de récupérer son jus. Retirez-y les pépins si besoin.");
		// -- Instruction 131 --//
		_instructionRecetteService.create(_recette,
				"Placez les lanières de saumon fumé dans un bol et arrosez-les avec le jus de citron. Mélangez bien puis réservez de côté.");
		// -- Instruction 132 --//
		_instructionRecetteService.create(_recette, "Lavez les peluches de persil et épongez-les (facultatif).");
		// -- Instruction 133 --//
		_instructionRecetteService.create(_recette,
				"Battez 2 oeufs à la fourchette dans un récipient. Salez et poivrez selon vos goûts.");
		// -- Instruction 134 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre la noix de beurre allégé dans une poêle anti-adhésive sur feu moyen.");
		// -- Instruction 135 --//
		_instructionRecetteService.create(_recette,
				"Versez-y les 2 oeufs battus puis faites-les cuire 3 à 4 minutes sur feu doux ou jusqu’à obtenir une omelette bien prise.");
		// -- Instruction 136 --//
		_instructionRecetteService.create(_recette,
				"Retirez alors l'omelette de la poêle et déposez-la dans une assiette. Réservez au chaud.");
		// -- Instruction 137 --//
		_instructionRecetteService.create(_recette,
				"Répétez l’opération de cuisson pour cuire les trois autres omelettes avec le restant d’oeufs frais.");
		// -- Instruction 138 --//
		_instructionRecetteService.create(_recette,
				"Quand toutes les omelettes sont cuites, répartissez les lanières de saumon fumé sur le dessus. Parsemez enfin de peluches de persil frais (facultatif), puis repliez un bord des omelettes sur l’autre.");
		// -- Instruction 139 --//
		_instructionRecetteService.create(_recette,
				"Servez tiède et dégustez ces omelettes en guise de plat principal, accompagnées d’une salade verte assaisonnée et de tranches de pain grillé. Pendant les fêtes de fin d’année, accompagnez cette recette avec un vin blanc ou rosé, pétillant ou non, bien fruité et frais.");
		// -- Instruction 140 --//
		_instructionRecetteService.create(_recette,
				"Astuce : Vous aimez l’aneth ? N’hésitez pas à en incorporer ciselé dans les oeufs battus avant cuisson des omelettes. Tout aussi bon !");

		/* Recette 15: 6 personnes */
		_recette.setId(null);
		_recette.setName("Gratin de chou fleur persillé au comté");
		_recette.setTempsDeCuisine(LocalTime.of(1, 0));
		_recette.setNote(4); // 3.6/5 - 56 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 40 ///
		_ingredient.setId(null);
		_ingredient.setName("Chou fleur");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(25);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 64
		_recetteIngredientService.create(_recette, _ingredient, 60);

		/// Ingredient 40 ///
		_ingredient.setId(null);
		_ingredient.setName("Comté");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(29);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 65
		_recetteIngredientService.create(_recette, _ingredient, 390);

		/// Ingredient 41 ///
		_ingredient.setId(null);
		_ingredient.setName("Crème allégée");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(108);
		_ingredient.setUnite(Unite.mL);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 66
		_recetteIngredientService.create(_recette, _ingredient, 300);

		// RecetteIngredient 67
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 7);
		_ingredient.setId(null);

		// -- Instruction 141 --//
		_instructionRecetteService.create(_recette,
				"Détacher les fleurs du chou et les cuire 5 minutes à l’auto-cuiseur.");
		// -- Instruction 142 --//
		_instructionRecetteService.create(_recette,
				"Dans un saladier, mélanger la crème, le Comté râpé, le persil haché et une gousse d’ail écrasée.");
		// -- Instruction 143 --//
		_instructionRecetteService.create(_recette,
				"Déposer les fleurs de chou dans un plat à gratin et arroser avec la préparation.");
		// -- Instruction 144 --//
		_instructionRecetteService.create(_recette,
				"Enfourner dans un four préchauffé à 180°C pour 30 minutes de cuisson environ.");

		_ctx.close();
	}
}
