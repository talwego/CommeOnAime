package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RecetteIngredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Ingredient ingredient;
	
	@ManyToOne
	private Recette recette;
	
	
	public RecetteIngredient() {
	}
	
	private double quantite;
	
	public RecetteIngredient(Ingredient ingredient, Recette recette, double quantite) {
		this.ingredient = ingredient;
		this.recette = recette;
		this.quantite = quantite;
	}
	public RecetteIngredient(Integer id, Ingredient ingredient, Recette recette, double quantite) {
		this.id = id;
		this.ingredient = ingredient;
		this.recette = recette;
		this.quantite = quantite;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public Recette getRecette() {
		return recette;
	}
	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "RecetteIngredient [id=" + id + ", ingredient=" + ingredient + ", recette=" + recette + ", quantite="
				+ quantite + "]";
	}
	
}
	

