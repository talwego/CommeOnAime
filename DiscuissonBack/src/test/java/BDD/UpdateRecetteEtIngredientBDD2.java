package BDD;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
 * les dates ne fonctionnent pas!
 * 
 * Source: https://www.fourchette-et-bikini.fr/cuisine/recettes-minceur/15-plats-dhiver-legers-et-gourmands.html
 * https://www.cuisineaz.com/recettes/pate-a-tarte-maison-rapide-36657.aspx
 */

public class UpdateRecetteEtIngredientBDD2 {
	public static void setRegimeRecette(Recette recette, List<Ingredient> ingredients) {
		int i =0;
		int size = ingredients.size();
		boolean boolean1 = true;
		while (boolean1 &&  i < size) {
			if (!ingredients.get(i).isVegetarien()) {
				boolean1 = false;
			}
			i++;
		}
		
		recette.setVegetarien(boolean1);
		
		i =0;
		boolean1 = true;
		while (boolean1 &&  i < size) {
			if (!ingredients.get(i).isVegan()) {
				boolean1 = false;
			}
			i++;
		}
		
		recette.setVegan(boolean1);
		
		System.out.println(recette.isVegan() + " + " + recette.isVegetarien());
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext _ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		IngredientService _ingredientService = _ctx.getBean(IngredientService.class);
		RecetteIngredientService _recetteIngredientService = _ctx.getBean(RecetteIngredientService.class);
		RecetteService _recetteService = _ctx.getBean(RecetteService.class);
		InstructionRecetteService _instructionRecetteService = _ctx.getBean(InstructionRecetteService.class);
		Recette _recette = new Recette();
		Ingredient _ingredient = new Ingredient();
		List<Ingredient> _ingredients = new ArrayList<>();

		//-------------------------------------------------//
		
		/* Recette 1: 8 personnes */
		System.out.println("Recette 1");
		_recette.setId(null);
		_recette.setName("Tartiflette sans lardons au gruy??re l??ger");
		_recette.setTempsDeCuisine(LocalTime.of(1, 30));
		_recette.setNote(4); // 3.7/5 - 51 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recetteService.create(_recette);

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
		_ingredients.add(_ingredientService.findById(1));
		
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

		// RecetteIngredient 2
		_recetteIngredientService.create(_recette, _ingredient, 100);
		_ingredients.add(_ingredientService.findById(2));
		
		/// Ingredient 3 ///
		_ingredient.setId(null);
		_ingredient.setName("Gruyere all??g??");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(213);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);
		
		// RecetteIngredient 3
		_recetteIngredientService.create(_recette, _ingredient, 200);
		_ingredients.add(_ingredientService.findById(3));
		
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

		// RecetteIngredient 4
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredients.add(_ingredientService.findById(4));

		/// Ingredient 5 ///
		_ingredient.setId(null);
		_ingredient.setName("Cr??me fra??che l??g??re");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(192);
		_ingredient.setUnite(Unite.mL);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 5
		_recetteIngredientService.create(_recette, _ingredient, 100);
		_ingredients.add(_ingredientService.findById(5));
		
		// -- Instruction 1 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 210 degr??s");
		// -- Instruction 2 --//
		_instructionRecetteService.create(_recette, "Pelez et coupez les pommes de terre en fines rondelles.");
		// -- Instruction 3 --//
		_instructionRecetteService.create(_recette, "Pelez et taillez les oignons en fines lamelles.");
		// -- Instruction 4 --//
		_instructionRecetteService.create(_recette,
				"D??posez une couche de pommes de terre puis une couche d'oignons dans le fond d'un plat ?? gratin.");
		// -- Instruction 5 --//
		_instructionRecetteService.create(_recette,
				"Recouvrez avec une couche de d??s de jambon puis une couche de gruy??re r??p??.");
		// -- Instruction 6 --//
		_instructionRecetteService.create(_recette,
				"Red??posez une couche de pommes de terre, une couche d'oignons,..., et ainsi de suite jusqu'?? ??puisement des ingr??dients, en terminant par une couche de pommes de terre.");
		// -- Instruction 7 --//
		_instructionRecetteService.create(_recette,
				"M??langez si vous le souhaitez, la cr??me fra??che avec du persil cisel??, du sel et du poivre dans un bol.");
		// -- Instruction 8 --//
		_instructionRecetteService.create(_recette,
				"Versez la cr??me fra??che sur les pommes de terre dans le plat. Parsemez d'un peu de gruy??re r??p??.");
		// -- Instruction 9 --//
		_instructionRecetteService.create(_recette,
				"Enfournez pendant 1 heure ?? 1h15 de cuisson jusqu'?? ce que la tartiflette soit bien dor??e.");
		// -- Instruction 10 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud accompagn?? d'une salade verte assaisonn??e.");
		
		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 2: 4 personnes */
		System.out.println("Recette 2");
		_recette.setId(null);
		_recette.setName("Lasagnes minceur au thon et au parmesan l??ger");
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
		_ingredients.add(_ingredientService.findById(6));
		
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
		_ingredients.add(_ingredientService.findById(7));
		
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
		_ingredients.add(_ingredientService.findById(8));

		// RecetteIngredient 9
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredients.add(_ingredientService.findById(5));
		_ingredient.setId(null);

		// -- Instruction 11 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 180 degr??s.");
		// -- Instruction 12 --//
		_instructionRecetteService.create(_recette, "Emiettez le thon dans un saladier ?? l'aide d'une fourchette.");
		// -- Instruction 13 --//
		_instructionRecetteService.create(_recette, "Ajoutez-y la sauce tomate et m??langez bien.");
		// -- Instruction 14 --//
		_instructionRecetteService.create(_recette, "Placez des feuilles ?? lasagnes dans le fond d'un plat ?? gratin.");
		// -- Instruction 15 --//
		_instructionRecetteService.create(_recette,
				"Recouvrez avec une couche de cr??me fra??che puis une couche de pr??paration thon-sauce tomate.");
		// -- Instruction 16 --//
		_instructionRecetteService.create(_recette,
				"Replacez des feuilles ?? lasagnes sur le dessus puis une nouvelle couche de cr??me fra??che et de pr??paration au thon.");
		// -- Instruction 17 --//
		_instructionRecetteService.create(_recette,
				"R??p??tez l'op??ration jusqu'?? ??puisement des ingr??dients, en terminant par une couche de cr??me fra??che.");
		// -- Instruction 18 --//
		_instructionRecetteService.create(_recette, "Bonus: Parsemez le plat avec le parmesan r??p??.");
		// -- Instruction 19 --//
		_instructionRecetteService.create(_recette,
				"Enfournez pendant 30 minutes jusqu'?? ce que les lasagnes soient bien gratin??es.");
		// -- Instruction 20 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud accompagn?? d'une salade verte assaisonn??e.");
		
		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 3: 4 personnes */
		System.out.println("Recette 3");
		_recette.setId(null);
		_recette.setName("Dos de cabillaud ?? la cr??me l??g??re ?? l'ail");
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
		_ingredients.add(_ingredientService.findById(9));

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
		_ingredients.add(_ingredientService.findById(10));

		// RecetteIngredient 12
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 200);
		_ingredients.add(_ingredientService.findById(5));
		_ingredient.setId(null);

		// -- Instruction 21 --//
		_instructionRecetteService.create(_recette,
				"Epluchez les gousses d'ail. Faites-les cuire pendant 20 minutes dans une casserole d'eau bouillante.");
		// -- Instruction 22 --//
		_instructionRecetteService.create(_recette,
				"Une fois les gousses d'ail cuites, ??gouttez-les et mixez-les avec la cr??me liquide dans un blender.");
		// -- Instruction 23 --//
		_instructionRecetteService.create(_recette,
				"Bonus: Ajouter du persil frais. Ajoutez-le au m??lange avec un peu de sel et de poivre. R??servez.");
		// -- Instruction 24 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre une noix de beurre dans une po??le et faites-y cuire de chaque c??t?? les dos de cabillaud jusqu'?? obtenir la cuisson d??sir??e.");
		// -- Instruction 25 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, r??chauffez la cr??me ?? l'ail dans une casserole ?? feu doux.");
		// -- Instruction 26 --//
		_instructionRecetteService.create(_recette,
				"Servez les dos de cabillaud dans les assiettes et nappez-les de cr??me ?? l'ail.");
		// -- Instruction 27 --//
		_instructionRecetteService.create(_recette, "D??gustez.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 4: 4 personnes */
		System.out.println("Recette 4");
		_recette.setId(null);
		_recette.setName("Quiche l??g??re poulet, champignons et brocoli");
		_recette.setTempsDeCuisine(LocalTime.of(0, 50));
		_recette.setNote(4); // 3.6/5
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 11 ///
		_ingredient.setId(null);
		_ingredient.setName("Farine de bl??");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(true);
		_ingredient.setCalorie(149);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 13
		_recetteIngredientService.create(_recette, _ingredient, 250);
		_ingredients.add(_ingredientService.findById(11));

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
		_ingredients.add(_ingredientService.findById(12));

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
		_ingredients.add(_ingredientService.findById(13));

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
		_ingredients.add(_ingredientService.findById(14));

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
		_ingredients.add(_ingredientService.findById(15));

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
		_ingredients.add(_ingredientService.findById(16));

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
		_ingredients.add(_ingredientService.findById(17));

		// RecetteIngredient 20
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 100);
		_ingredients.add(_ingredientService.findById(5));
		_ingredient.setId(null);

		// -- Instruction 28 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre le beurre avec l???eau dans une casserole ?? feu doux.");
		// -- Instruction 29 --//
		_instructionRecetteService.create(_recette,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de bl?? et le sucre en poudre (en option).");
		// -- Instruction 30 --//
		_instructionRecetteService.create(_recette,
				"Malaxez bien le m??lange avec vos mains, pendant plusieurs minutes, jusqu????? obtenir une boule de p??te bien lisse et homog??ne.");
		// -- Instruction 31 --//
		_instructionRecetteService.create(_recette,
				"Couvrez le saladier avec du film alimentaire et placez la boule de p??te au frais pendant 10 min minimum.");
		// -- Instruction 32 --//
		_instructionRecetteService.create(_recette,
				"C'est pr??t ! D??gazez la p??te sur un plan de travail farin??.Pour cela, tapez ??nergiquement sur la p??te pour en enlever le gaz carbonique emprisonn?? dans les bulles d'air.");
		// -- Instruction 33 --//
		_instructionRecetteService.create(_recette,
				"Puis ??talez-la ?? l'aide d'un rouleau ?? p??tisserie. D??posez ensuite votre fond de tarte dans un plat ?? tarte recouvert de papier sulfuris?? et piquez son fond avec une fourchette.");

		// -- Instruction 34 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 220??C.");
		// -- Instruction 35 --//
		_instructionRecetteService.create(_recette,
				"Foncez la p??te dans un moule ?? tarte recouvert de papier sulfuris??.");
		// -- Instruction 36 --//
		_instructionRecetteService.create(_recette, "Piquez le fond avec une fourchette. R??servez.");
		// -- Instruction 37 --//
		_instructionRecetteService.create(_recette, "Coupez les blancs de poulet en morceaux.");
		// -- Instruction 38 --//
		_instructionRecetteService.create(_recette, "Nettoyez et ??mincez en tranches les champignons de Paris.");
		// -- Instruction 39 --//
		_instructionRecetteService.create(_recette,
				"Faites dorer le poulet dans une po??le anti-adh??sive pendant 5 minutes.");
		// -- Instruction 40 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez les champignons ??minc??s et laissez cuire jusqu'?? ce qu'ils aient rendu leur eau.");
		// -- Instruction 41 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, faites cuire les fleurons de brocoli dans une casserole d'eau bouillante pendant 10 minutes.");
		// -- Instruction 42 --//
		_instructionRecetteService.create(_recette, "R??partissez le m??lange poulet-champignons dans le fond de p??te.");
		// -- Instruction 43 --//
		_instructionRecetteService.create(_recette,
				"Egouttez les fleurons de brocoli et r??partissez-les sur le dessus du m??lange poulet-champignons.");
		// -- Instruction 44 --//
		_instructionRecetteService.create(_recette,
				"Battez les oeufs avec la cr??me fra??che et le lait dans un bol. Ajoutez du persil cisel?? puis salez et poivrez.");
		// -- Instruction 45 --//
		_instructionRecetteService.create(_recette,
				"Versez le m??lange aux oeufs sur la garniture au poulet dans le moule.");
		// -- Instruction 46 --//
		_instructionRecetteService.create(_recette,
				"Enfournez la quiche pendant 30 minutes jusqu'?? ce qu'elle soit dor??e.");
		// -- Instruction 47 --//
		_instructionRecetteService.create(_recette,
				"D??gustez chaud ou froid accompagn?? d'une salade verte assaisonn??e.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 5: 4 personnes */
		System.out.println("Recette 5");
		_recette.setId(null);
		_recette.setName(" Hachis parmentier sans viande aux l??gumes");
		_recette.setTempsDeCuisine(LocalTime.of(1, 15));
		_recette.setNote(3); // 3.3/5 - 60 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 21
		_ingredient.setId(1);
		_recetteIngredientService.create(_recette, _ingredient, 400);
		_ingredients.add(_ingredientService.findById(1));
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
		_ingredients.add(_ingredientService.findById(18));

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
		_ingredients.add(_ingredientService.findById(19));

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
		_ingredients.add(_ingredientService.findById(20));

		// RecetteIngredient 25
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredients.add(_ingredientService.findById(4));
		_ingredient.setId(null);

		// RecetteIngredient 26
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 7);
		_ingredients.add(_ingredientService.findById(10));
		_ingredient.setId(null);

		// -- Instruction 48 --//
		_instructionRecetteService.create(_recette,
				"Pelez et coupez en morceaux les carottes, le navet, les branches de c??leri, les oignons et l'ail.");
		// -- Instruction 49 --//
		_instructionRecetteService.create(_recette,
				"Mixez les l??gumes dans un blender jusqu'?? obtenir un hachis bien homog??ne. R??servez.");
		// -- Instruction 50 --//
		_instructionRecetteService.create(_recette,
				"Pelez les pommes de terre et coupez-les en cubes. Nettoyez et ??mincez en rondelles le poireau.");
		// -- Instruction 51 --//
		_instructionRecetteService.create(_recette,
				"Faites cuire les pommes de terre et le poireau dans une casserole d'eau bouillante sal??e pendant 20 minutes.");
		// -- Instruction 52 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, faites chauffer l'huile d'olive dans une sauteuse.");
		// -- Instruction 53 --//
		_instructionRecetteService.create(_recette,
				"Faites revenir le hachis de l??gumes dans la sauteuse pendant 15 minutes en remuant r??guli??rement. Salez et poivrez puis ajoutez le persil cisel??.");
		// -- Instruction 54 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 200 degr??.");
		// -- Instruction 55 --//
		_instructionRecetteService.create(_recette,
				"R??partissez le hachis de l??gumes dans le fond d'un plat ?? gratin. R??servez.");
		// -- Instruction 56 --//
		_instructionRecetteService.create(_recette,
				"Egouttez les pommes de terre et le poireau et ??crasez-les en pur??e ??paisse dans un saladier, ?? l'aide d'une fourchette. Rectifiez l'assaisonnement.");
		// -- Instruction 57 --//
		_instructionRecetteService.create(_recette,
				"Recouvrez le hachis de l??gumes avec la pur??e de pommes de terre au poireau.");
		// -- Instruction 58 --//
		_instructionRecetteService.create(_recette,
				"Striez le hachis avec les dents d'une fourchette puis enfournez pendant 35 minutes jusqu'?? ce qu'il soit bien dor??.");
		// -- Instruction 59 --//
		_instructionRecetteService.create(_recette, "D??gustez bien chaud.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 6: 4 personnes */
		System.out.println("Recette 6");
		_recette.setId(null);
		_recette.setName("Tagliatelles l??g??res lentilles, potiron et roquefort");
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
		_ingredients.add(_ingredientService.findById(21));

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
		_ingredients.add(_ingredientService.findById(22));

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
		_ingredients.add(_ingredientService.findById(23));

		// RecetteIngredient 30
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredients.add(_ingredientService.findById(4));
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
		_ingredients.add(_ingredientService.findById(24));

		// -- Instruction 60 --//
		_instructionRecetteService.create(_recette, "Coupez la chair de potiron en petits cubes.");
		// -- Instruction 61 --//
		_instructionRecetteService.create(_recette, "Pelez et hachez l'oignon.");
		// -- Instruction 62 --//
		_instructionRecetteService.create(_recette, "Faites chauffer 1 c. ?? soupe d'huile d'olive dans une po??le.");
		// -- Instruction 63 --//
		_instructionRecetteService.create(_recette,
				"Faites blondir l'oignon, les cubes de potiron et les lentilles vertes ??goutt??es pendant 5 minutes en m??langeant bien.");
		// -- Instruction 64 --//
		_instructionRecetteService.create(_recette,
				"Versez le vin blanc puis salez et poivrez. Laissez compoter pendant 15 minutes.");
		// -- Instruction 65 --//
		_instructionRecetteService.create(_recette,
				"Pendant ce temps, faites cuire les tagliatelles fra??ches dans une casserole d'eau bouillante en suivant le temps indiqu?? sur le paquet.");
		// -- Instruction 66 --//
		_instructionRecetteService.create(_recette,
				"Egouttez les tagliatelles en fin de cuisson et dressez-les dans les assiettes.");
		// -- Instruction 67 --//
		_instructionRecetteService.create(_recette,
				"Nappez-les de compot??e au potiron puis parsemez-les de roquefort ??miett?? et de basilic cisel??.");
		// -- Instruction 68 --//
		_instructionRecetteService.create(_recette, "D??gustez sans attendre.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 7 */
		System.out.println("Recette 7");
		_recette.setId(null);
		_recette.setName("Mijot?? de boeuf maigre fa??on bourguignon ?? la tomate");
		_recette.setTempsDeCuisine(LocalTime.of(2, 0));
		_recette.setNote(4); // 3.6/5 - 77 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 25 ///
		_ingredient.setId(null);
		_ingredient.setName("Viande de boeuf d??graiss??e");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(100);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 32
		_recetteIngredientService.create(_recette, _ingredient, 800);
		_ingredients.add(_ingredientService.findById(25));

		// RecetteIngredient 33
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 375);
		_ingredients.add(_ingredientService.findById(19));
		_ingredient.setId(null);

		// RecetteIngredient 34
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredients.add(_ingredientService.findById(4));
		_ingredient.setId(null);

		// RecetteIngredient 35
		_ingredient.setId(13);
		_recetteIngredientService.create(_recette, _ingredient, 225);
		_ingredients.add(_ingredientService.findById(13));
		_ingredient.setId(null);

		// RecetteIngredient 36
		_ingredient.setId(8);
		_recetteIngredientService.create(_recette, _ingredient, 45);
		_ingredients.add(_ingredientService.findById(8));
		_ingredient.setId(null);

		// -- Instruction 69 --//
		_instructionRecetteService.create(_recette, "Pelez et ??mincez les oignons et les carottes.");
		// -- Instruction 70 --//
		_instructionRecetteService.create(_recette, "Coupez en morceaux la viande de boeuf.");
		// -- Instruction 71 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre le beurre avec un filet d'huile d'olive dans une cocotte.");
		// -- Instruction 72 --//
		_instructionRecetteService.create(_recette, "Faites-y suer les oignons jusqu'?? ce qu'ils soient dor??s.");
		// -- Instruction 73 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez la viande de boeuf et laissez dorer en m??langeant r??guli??rement.");
		// -- Instruction 74 --//
		_instructionRecetteService.create(_recette,
				"Faites dissoudre le cube de bouillon dans le verre d'eau et versez dans la cocotte. Ajoutez les vinaigres puis salez et poivrez.");
		// -- Instruction 75 --//
		_instructionRecetteService.create(_recette, "Couvrez et laissez mijoter 20 minutes ?? feu doux.");
		// -- Instruction 76 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez les carottes ??minc??es puis poursuivez la cuisson pendant environ 1h10, toujours ?? feu doux et ?? couvert.");
		// -- Instruction 77 --//
		_instructionRecetteService.create(_recette,
				"En fin de cuisson, ajoutez la sauce tomate puis la f??cule de ma??s et m??langez bien.");
		// -- Instruction 78 --//
		_instructionRecetteService.create(_recette, "Rectifiez l'assaisonnement si besoin puis servez imm??diatement.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 8: 4 personnes */
		System.out.println("Recette 8");
		_recette.setId(null);
		_recette.setName("Curry light de dinde aux l??gumes");
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
		_ingredients.add(_ingredientService.findById(26));
		
		// RecetteIngredient 38
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredients.add(_ingredientService.findById(4));
		_ingredient.setId(null);

		// RecetteIngredient 39
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 7);
		_ingredients.add(_ingredientService.findById(10));
		_ingredient.setId(null);

		// RecetteIngredient 40
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredients.add(_ingredientService.findById(19));
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
		_ingredients.add(_ingredientService.findById(27));

		// RecetteIngredient 42
		_ingredient.setId(13);
		_recetteIngredientService.create(_recette, _ingredient, 350);
		_ingredients.add(_ingredientService.findById(13));
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

		// RecetteIngredient 43
		_recetteIngredientService.create(_recette, _ingredient, 20);
		_ingredients.add(_ingredientService.findById(28));

		// -- Instruction 79 --//
		_instructionRecetteService.create(_recette, "Epluchez et hachez l'oignon et l'ail.");
		// -- Instruction 80 --//
		_instructionRecetteService.create(_recette, "Faites chauffer un filet d'huile dans une sauteuse.");
		// -- Instruction 81 --//
		_instructionRecetteService.create(_recette,
				"Mettez-y l'oignon, l'ail et toutes les ??pices puis faites suer jusqu'?? ce que l'oignon soit translucide.");
		// -- Instruction 82 --//
		_instructionRecetteService.create(_recette,
				"Coupez les escalopes de dinde en d??s puis ajoutez-les dans la sauteuse. Laissez cuire 5 minutes en m??langeant.");
		// -- Instruction 83 --//
		_instructionRecetteService.create(_recette,
				"Pelez et coupez en rondelles les carottes. Nettoyez et ??gouttez les haricots verts. Quand la dinde est dor??e, ajoutez les l??gumes dans la sauteuse et m??langez.");
		// -- Instruction 84 --//
		_instructionRecetteService.create(_recette,
				"Versez 25 cl d'eau, remuez, couvrez et laissez cuire pendant 1 heure ?? feu doux.");
		// -- Instruction 85 --//
		_instructionRecetteService.create(_recette,
				"Au bout de ce temps, ajoutez la poudre de coco dilu??e dans 10 cl d'eau et remuez bien. Laissez mijoter encore 5 minutes.");
		// -- Instruction 86 --//
		_instructionRecetteService.create(_recette, "Rectifiez l'assaisonnement en sel et en poivre et m??langez.");
		// -- Instruction 87 --//
		_instructionRecetteService.create(_recette, "Servez accompagn?? de riz blanc.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 9: 4 personnes */
		System.out.println("Recette 9");
		_recette.setId(null);
		_recette.setName("Soupe de l??gumes di??t??tique au quinoa");
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

		// RecetteIngredient 44
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredients.add(_ingredientService.findById(29));

		// RecetteIngredient 45
		_ingredient.setId(1);
		_recetteIngredientService.create(_recette, _ingredient, 960);
		_ingredients.add(_ingredientService.findById(1));
		_ingredient.setId(null);

		// RecetteIngredient 46
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 250);
		_ingredients.add(_ingredientService.findById(19));
		_ingredient.setId(null);

		// RecetteIngredient 47
		_ingredient.setId(20);
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredients.add(_ingredientService.findById(20));
		_ingredient.setId(null);

		// RecetteIngredient 48
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredients.add(_ingredientService.findById(4));
		_ingredient.setId(null);

		// -- Instruction 88 --//
		_instructionRecetteService.create(_recette,
				"Pelez et taillez en petits morceaux les pommes de terre et les carottes.");
		// -- Instruction 89 --//
		_instructionRecetteService.create(_recette, "Nettoyez et ??mincez en fines rondelles les poireaux.");
		// -- Instruction 90 --//
		_instructionRecetteService.create(_recette, "Pelez et hachez l'oignon.");
		// -- Instruction 91 --//
		_instructionRecetteService.create(_recette, "Faites fondre une noix de beurre dans une cocotte.");
		// -- Instruction 92 --//
		_instructionRecetteService.create(_recette, "Faites-y suer l'oignon jusqu'?? ce qu'il soit translucide.");
		// -- Instruction 93 --//
		_instructionRecetteService.create(_recette, "Ajoutez les l??gumes puis recouvrez d'eau ?? hauteur.");
		// -- Instruction 94 --//
		_instructionRecetteService.create(_recette, "Couvrez et portez ?? ??bullition ?? feu doux.");
		// -- Instruction 95 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez le quinoa dans la cocotte puis faites cuire ?? couvert pendant 30 minutes, jusqu'?? ce que les carottes et les pommes de terre soient tendres.");
		// -- Instruction 96 --//
		_instructionRecetteService.create(_recette,
				"Salez et poivrez ?? votre go??t en fin de cuisson. Ajoutez le persil cisel??.");
		// -- Instruction 97 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 10: 8 personnes */
		System.out.println("Recette 10");
		_recette.setId(null);
		_recette.setName("Tarte light thon-??pinards");
		_recette.setTempsDeCuisine(LocalTime.of(1, 0));
		_recette.setNote(5); // 4.9/5 - 16 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 49
		_ingredient.setId(11);
		_recetteIngredientService.create(_recette, _ingredient, 250);
		_ingredients.add(_ingredientService.findById(11));
		_ingredient.setId(null);

		// RecetteIngredient 50
		_ingredient.setId(12);
		_recetteIngredientService.create(_recette, _ingredient, 125);
		_ingredients.add(_ingredientService.findById(12));
		_ingredient.setId(null);

		// RecetteIngredient 51
		_ingredient.setId(7);
		_recetteIngredientService.create(_recette, _ingredient, 125);
		_ingredients.add(_ingredientService.findById(7));
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

		// RecetteIngredient 52
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredients.add(_ingredientService.findById(30));

		// RecetteIngredient 53
		_ingredient.setId(17);
		_recetteIngredientService.create(_recette, _ingredient, 125);
		_ingredients.add(_ingredientService.findById(17));
		_ingredient.setId(null);

		// RecetteIngredient 54
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 100);
		_ingredients.add(_ingredientService.findById(5));
		_ingredient.setId(null);

		// -- Instruction 98 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre le beurre avec l???eau dans une casserole ?? feu doux.");
		// -- Instruction 99 --//
		_instructionRecetteService.create(_recette,
				"Quand le beurre est bien fondu, versez le tout dans un saladier et rajoutez la farine de bl?? et le sucre en poudre (en option).");
		// -- Instruction 100 --//
		_instructionRecetteService.create(_recette,
				"Malaxez bien le m??lange avec vos mains, pendant plusieurs minutes, jusqu????? obtenir une boule de p??te bien lisse et homog??ne.");
		// -- Instruction 101 --//
		_instructionRecetteService.create(_recette,
				"Couvrez le saladier avec du film alimentaire et placez la boule de p??te au frais pendant 10 min minimum.");
		// -- Instruction 102 --//
		_instructionRecetteService.create(_recette,
				"C'est pr??t ! D??gazez la p??te sur un plan de travail farin??.Pour cela, tapez ??nergiquement sur la p??te pour en enlever le gaz carbonique emprisonn?? dans les bulles d'air.");
		// -- Instruction 103 --//
		_instructionRecetteService.create(_recette,
				"Puis ??talez-la ?? l'aide d'un rouleau ?? p??tisserie. D??posez ensuite votre fond de tarte dans un plat ?? tarte recouvert de papier sulfuris?? et piquez son fond avec une fourchette.");

		// -- Instruction 104 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 180??C.");
		// -- Instruction 105 --//
		_instructionRecetteService.create(_recette,
				"Foncez la p??te dans un moule ?? tarte recouvert de papier sulfuris??.");
		// -- Instruction 106 --//
		_instructionRecetteService.create(_recette, "Piquez le fond avec une fourchette. R??servez.");
		// -- Instruction 107 --//
		_instructionRecetteService.create(_recette, "Egouttez puis ??miettez le thon ?? la fourchette dans un saladier.");
		// -- Instruction 108 --//
		_instructionRecetteService.create(_recette, "Ajoutez les ??pinards hach??s et m??langez bien. R??servez.");
		// -- Instruction 109 --//
		_instructionRecetteService.create(_recette, "Battez les oeufs avec la cr??me fra??che dans un saladier.");
		// -- Instruction 110 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez le m??lange thon-??pinards et remuez bien. Salez et poivrez ?? votre go??t.");
		// -- Instruction 111 --//
		_instructionRecetteService.create(_recette,
				"Versez le m??lange sur le fond de p??te dans le moule. Parsemez de gruy??re r??p??.");
		// -- Instruction 112 --//
		_instructionRecetteService.create(_recette,
				"Enfournez pendant 35 minutes jusqu'?? ce que la tarte soit bien dor??e.");
		// -- Instruction 113 --//
		_instructionRecetteService.create(_recette, "Servez chaud ou froid accompagn?? d'une salade verte assaisonn??e.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 11: 4 personnes */
		System.out.println("Recette 11");
		_recette.setId(null);
		_recette.setName("Endives au jambon minceur gratin??es au gruy??re");
		_recette.setTempsDeCuisine(LocalTime.of(0, 50));
		_recette.setNote(4); // 4.4/5 - 67 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 55
		_ingredient.setId(3);
		_recetteIngredientService.create(_recette, _ingredient, 50);
		_ingredients.add(_ingredientService.findById(3));
		_ingredient.setId(null);

		// RecetteIngredient 56
		_ingredient.setId(5);
		_recetteIngredientService.create(_recette, _ingredient, 400);
		_ingredients.add(_ingredientService.findById(5));
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

		// RecetteIngredient 57
		_recetteIngredientService.create(_recette, _ingredient, 600);
		_ingredients.add(_ingredientService.findById(31));

		// RecetteIngredient 58
		_ingredient.setId(2);
		_recetteIngredientService.create(_recette, _ingredient, 200);
		_ingredients.add(_ingredientService.findById(2));
		_ingredient.setId(null);

		// -- Instruction 114 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 180??C.");
		// -- Instruction 115 --//
		_instructionRecetteService.create(_recette,
				"Nettoyez les endives, puis enroulez-les dans une tranche de jambon. D??posez les endives dans un plat ?? gratin.");
		// -- Instruction 116 --//
		_instructionRecetteService.create(_recette,
				"Dans un bol, m??langez la cr??me, du sel, du poivre et la muscade. Versez sur les endives.");
		// -- Instruction 117 --//
		_instructionRecetteService.create(_recette,
				"Parsemez de gruy??re r??p??, puis ciselez le persil lav?? par-dessus, et enfournez pour 35 ?? 40 minutes.");
		// -- Instruction 118 --//
		_instructionRecetteService.create(_recette, "Servez bien chaud et accompagnez d???une po??l??e de l??gumes !");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 12: 4 personnes */
		System.out.println("Recette 12");
		_recette.setId(null);
		_recette.setName("Papillote de merlan aux poivrons");
		_recette.setTempsDeCuisine(LocalTime.of(1, 0));
		_recette.setNote(4); // 3.6/5 - 39 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		/// Ingredient 32 ///
		_ingredient.setId(null);
		_ingredient.setName("Filet de merlan");
		_ingredient.setVegetarien(false);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(128);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 59
		_recetteIngredientService.create(_recette, _ingredient, 360);
		_ingredients.add(_ingredientService.findById(32));

		// RecetteIngredient 60
		_ingredient.setId(19);
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredients.add(_ingredientService.findById(32));
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

		// RecetteIngredient 61
		_recetteIngredientService.create(_recette, _ingredient, 500);
		_ingredients.add(_ingredientService.findById(33));
		
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

		// RecetteIngredient 62
		_recetteIngredientService.create(_recette, _ingredient, 40);
		_ingredients.add(_ingredientService.findById(34));

		// -- Instruction 118 --//
		_instructionRecetteService.create(_recette, "Pr??chauffez le four ?? 180??C.");
		// -- Instruction 119 --//
		_instructionRecetteService.create(_recette,
				"Emincez et ??pluchez les ??chalotes en petits morceaux. Epluchez et coupez les carottes en petits cubes. Lavez, ??p??pinez et coupez les poivrons en fines lamelles.");
		// -- Instruction 120 --//
		_instructionRecetteService.create(_recette,
				"Dans une po??le sur feu moyen, faites cuire les poivrons et les carottes avec un peu d'huile d'olive, jusqu'?? ce qu'ils soient tendres.");
		// -- Instruction 121 --//
		_instructionRecetteService.create(_recette,
				"Sur 4 feuilles de papier sulfuris??, d??posez les l??gumes revenus ?? la po??le, les ??chalotes, du sel, du poivre et les filets de merlan sur le dessus. Salez, poivrez et d??posez quelques brins de persil hach??. Arrosez d'un filet d'huile d'olive.");
		// -- Instruction 122 --//
		_instructionRecetteService.create(_recette,
				"D??posez les papillotes dans un plat allant au four. Versez le vin blanc et refermez-les d??finitivement. Enfournez pendant 30 minutes.");
		// -- Instruction 123 --//
		_instructionRecetteService.create(_recette, "Servez imm??diatement ?? la sortie du four avec du riz nature.");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();
		
		//-------------------------------------------------//
		
		/* Recette 13 */
		System.out.println("Recette 13");
		_recette.setId(null);
		_recette.setName("Rago??t cramoisi de betterave, chou et bacon");
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

		// RecetteIngredient 63
		_recetteIngredientService.create(_recette, _ingredient, 700);
		_ingredients.add(_ingredientService.findById(35));

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

		// RecetteIngredient 64
		_recetteIngredientService.create(_recette, _ingredient, 1800);
		_ingredients.add(_ingredientService.findById(36));
		
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

		// RecetteIngredient 65
		_recetteIngredientService.create(_recette, _ingredient, 172);
		_ingredients.add(_ingredientService.findById(37));

		// RecetteIngredient 66
		_ingredient.setId(4);
		_recetteIngredientService.create(_recette, _ingredient, 150);
		_ingredients.add(_ingredientService.findById(4));
		_ingredient.setId(null);

		// RecetteIngredient 67
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 21);
		_ingredients.add(_ingredientService.findById(10));
		_ingredient.setId(null);

		// -- Instruction 124 --//
		_instructionRecetteService.create(_recette,
				"??pluchez les betteraves et d??taillez-les en d??s. Pelez et ??mincez l???oignon. Coupez le trognon du chou et ??mincez-le. Pelez et ??crasez l???ail. Coupez le bacon en d??s.");
		// -- Instruction 125 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre l???oignon quelques minutes avec l???huile dans une cocotte, puis ajoutez les l??gumes et les d??s de bacon. Laissez cuire 5 minutes ?? feu moyen.");
		// -- Instruction 126 --//
		_instructionRecetteService.create(_recette,
				"Ajoutez le cube de bouillon et 25 cl d???eau. Salez, poivrez, ajoutez le persil et le laurier.");
		// -- Instruction 127 --//
		_instructionRecetteService.create(_recette, "Ramenez ?? feu doux et laissez mijoter 1 h 30.");
		// -- Instruction 128 --//
		_instructionRecetteService.create(_recette, "Servez chaud !");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 14: 4 personnes */
		System.out.println("Recette 14");
		_recette.setId(null);
		_recette.setName("Omelette au saumon fum??");
		_recette.setTempsDeCuisine(LocalTime.of(0, 23));
		_recette.setNote(4); // 4.1/5 - 11 votes
		_recette.setIsValid(false);
		_recette.setDebutSaison(3);
		_recette.setFinSaison(3);
		_recette = _recetteService.create(_recette);

		// RecetteIngredient 68
		_ingredient.setId(17);
		_recetteIngredientService.create(_recette, _ingredient, 480);
		_ingredients.add(_ingredientService.findById(17));
		_ingredient.setId(null);

		/// Ingredient 38 ///
		_ingredient.setId(null);
		_ingredient.setName("Tranche de saumon fum??");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(117);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 69
		_recetteIngredientService.create(_recette, _ingredient, 200);
		_ingredients.add(_ingredientService.findById(38));
		
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

		// RecetteIngredient 70
		_recetteIngredientService.create(_recette, _ingredient, 60);
		_ingredients.add(_ingredientService.findById(39));

		// -- Instruction 129 --//
		_instructionRecetteService.create(_recette, "D??coupez les tranches de saumon fum?? en fines lani??res.");
		// -- Instruction 130 --//
		_instructionRecetteService.create(_recette,
				"Pressez le demi citron afin de r??cup??rer son jus. Retirez-y les p??pins si besoin.");
		// -- Instruction 131 --//
		_instructionRecetteService.create(_recette,
				"Placez les lani??res de saumon fum?? dans un bol et arrosez-les avec le jus de citron. M??langez bien puis r??servez de c??t??.");
		// -- Instruction 132 --//
		_instructionRecetteService.create(_recette, "Lavez les peluches de persil et ??pongez-les (facultatif).");
		// -- Instruction 133 --//
		_instructionRecetteService.create(_recette,
				"Battez 2 oeufs ?? la fourchette dans un r??cipient. Salez et poivrez selon vos go??ts.");
		// -- Instruction 134 --//
		_instructionRecetteService.create(_recette,
				"Faites fondre la noix de beurre all??g?? dans une po??le anti-adh??sive sur feu moyen.");
		// -- Instruction 135 --//
		_instructionRecetteService.create(_recette,
				"Versez-y les 2 oeufs battus puis faites-les cuire 3 ?? 4 minutes sur feu doux ou jusqu????? obtenir une omelette bien prise.");
		// -- Instruction 136 --//
		_instructionRecetteService.create(_recette,
				"Retirez alors l'omelette de la po??le et d??posez-la dans une assiette. R??servez au chaud.");
		// -- Instruction 137 --//
		_instructionRecetteService.create(_recette,
				"R??p??tez l???op??ration de cuisson pour cuire les trois autres omelettes avec le restant d???oeufs frais.");
		// -- Instruction 138 --//
		_instructionRecetteService.create(_recette,
				"Quand toutes les omelettes sont cuites, r??partissez les lani??res de saumon fum?? sur le dessus. Parsemez enfin de peluches de persil frais (facultatif), puis repliez un bord des omelettes sur l???autre.");
		// -- Instruction 139 --//
		_instructionRecetteService.create(_recette,
				"Servez ti??de et d??gustez ces omelettes en guise de plat principal, accompagn??es d???une salade verte assaisonn??e et de tranches de pain grill??. Pendant les f??tes de fin d???ann??e, accompagnez cette recette avec un vin blanc ou ros??, p??tillant ou non, bien fruit?? et frais.");
		// -- Instruction 140 --//
		_instructionRecetteService.create(_recette,
				"Astuce : Vous aimez l???aneth ? N???h??sitez pas ?? en incorporer cisel?? dans les oeufs battus avant cuisson des omelettes. Tout aussi bon !");

		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();

		//-------------------------------------------------//
		
		/* Recette 15: 6 personnes */
		System.out.println("Recette 15");
		_recette.setId(null);
		_recette.setName("Gratin de chou fleur persill?? au comt??");
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

		// RecetteIngredient 71
		_recetteIngredientService.create(_recette, _ingredient, 60);
		_ingredients.add(_ingredientService.findById(40));

		/// Ingredient 41 ///
		_ingredient.setId(null);
		_ingredient.setName("Comt??");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(29);
		_ingredient.setUnite(Unite.g);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 72
		_recetteIngredientService.create(_recette, _ingredient, 390);
		_ingredients.add(_ingredientService.findById(41));

		/// Ingredient 42 ///
		_ingredient.setId(null);
		_ingredient.setName("Cr??me all??g??e");
		_ingredient.setVegetarien(true);
		_ingredient.setVegan(false);
		_ingredient.setCalorie(108);
		_ingredient.setUnite(Unite.mL);
		_ingredient.setDateDebutRecolte(3);
		_ingredient.setDateFinRecolte(3);
		_ingredient = _ingredientService.create(_ingredient);

		// RecetteIngredient 73
		_recetteIngredientService.create(_recette, _ingredient, 300);
		_ingredients.add(_ingredientService.findById(42));

		// RecetteIngredient 74
		_ingredient.setId(10);
		_recetteIngredientService.create(_recette, _ingredient, 7);
		_ingredients.add(_ingredientService.findById(10));
		_ingredient.setId(null);

		// -- Instruction 141 --//
		_instructionRecetteService.create(_recette,
				"D??tacher les fleurs du chou et les cuire 5 minutes ?? l???auto-cuiseur.");
		// -- Instruction 142 --//
		_instructionRecetteService.create(_recette,
				"Dans un saladier, m??langer la cr??me, le Comt?? r??p??, le persil hach?? et une gousse d???ail ??cras??e.");
		// -- Instruction 143 --//
		_instructionRecetteService.create(_recette,
				"D??poser les fleurs de chou dans un plat ?? gratin et arroser avec la pr??paration.");
		// -- Instruction 144 --//
		_instructionRecetteService.create(_recette,
				"Enfourner dans un four pr??chauff?? ?? 180??C pour 30 minutes de cuisson environ.");

		for(Ingredient obj: _ingredients) {
			System.out.println(obj);
		}
		setRegimeRecette(_recette, _ingredients);
		_recette = _recetteService.update(_recette);
		_ingredients.clear();
		
		_ctx.close();
	}
}
