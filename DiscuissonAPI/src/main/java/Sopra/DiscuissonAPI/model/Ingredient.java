package Sopra.DiscuissonAPI.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private Integer id;

	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private int calorie;

	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private String name;

	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private int dateDebutRecolte;

	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private int dateFinRecolte;

	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private boolean vegetarien;

	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private boolean vegan;
	
	@JsonView({JsonViews.Common.class,JsonViews.RecetteWithInstructionAndIngredient.class})
	private Unite unite;

	@OneToMany(mappedBy = "ingredient")
	private List<RecetteIngredient> recetteIngredients;

	@OneToMany(mappedBy = "ingredient")
	private List<ElementFrigo> elementFrigos;

	public Ingredient() {

	}

	public Ingredient(Integer id) {
		super();
		this.id = id;
	}

	public Ingredient(String name, int calorie, int dateDebutRecolte, int dateFinRecolte, boolean vegetarien,
			boolean vegan, Unite unite) {
		super();
		this.calorie = calorie;
		this.name = name;
		this.dateDebutRecolte = dateDebutRecolte;
		this.dateFinRecolte = dateFinRecolte;
		this.vegetarien = vegetarien;
		this.vegan = vegan;
		this.unite = unite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getDateDebutRecolte() {
		return dateDebutRecolte;
	}

	public void setDateDebutRecolte(int dateDebutRecolte) {
		this.dateDebutRecolte = dateDebutRecolte;
	}

	public int getDateFinRecolte() {
		return dateFinRecolte;
	}

	public void setDateFinRecolte(int dateFinRecolte) {
		this.dateFinRecolte = dateFinRecolte;
	}

	public boolean isVegetarien() {
		return vegetarien;
	}

	public void setVegetarien(boolean vegetarien) {
		this.vegetarien = vegetarien;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RecetteIngredient> getRecetteIngredients() {
		return recetteIngredients;
	}

	public void setRecetteIngredients(List<RecetteIngredient> recetteIngredients) {
		this.recetteIngredients = recetteIngredients;
	}

	public List<ElementFrigo> getElementFrigos() {
		return elementFrigos;
	}

	public void setElementFrigos(List<ElementFrigo> elementFrigos) {
		this.elementFrigos = elementFrigos;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", calorie=" + calorie + ", dateDebutRecolte=" + dateDebutRecolte
				+ ", dateFinRecolte=" + dateFinRecolte + ", vegetarien=" + vegetarien + ", vegan=" + vegan + ", name="
				+ name + "]";
	}

}
