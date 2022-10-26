package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int calorie;
	
	private String name;
	
	private int dateDebutRecolte;
	
	private int dateFinRecolte;
		
	private boolean vegetarien;
	
	private boolean vegan;
	
	@OneToMany(mappedBy = "ingredient")
	private List<RecetteIngredient> RecetteIngredients;
	
	@OneToMany(mappedBy="ingredient")
	private List<ElementFrigo> elementFrigos;
	
	public Ingredient() {}
	
	

	public Ingredient(String name, int calorie, int dateDebutRecolte, int dateFinRecolte,
			boolean vegetarien, boolean vegan) {
		super();
		this.calorie = calorie;
		this.name = name;
		this.dateDebutRecolte = dateDebutRecolte;
		this.dateFinRecolte = dateFinRecolte;
		this.vegetarien = vegetarien;
		this.vegan = vegan;
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

	public void setDateFinRecolteDate(int dateFinRecolte) {
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

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", calorie=" + calorie + ", dateDebutRecolte=" + dateDebutRecolte
				+ ", dateFinRecolte=" + dateFinRecolte + ", vegetarien=" + vegetarien + ", vegan=" + vegan
				+ ", name=" + name + "]";
	}

	
	
	
	
	
	

}
