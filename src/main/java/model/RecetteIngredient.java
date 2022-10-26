package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RecetteIngredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Ingredient Ingredient;
	
	@ManyToOne
	private Recette recette;
	private double quantite;
	
	public RecetteIngredient() {
	}

	public RecetteIngredient(model.Ingredient ingredient, double quantite) {
		super();
		Ingredient = ingredient;
		this.quantite = quantite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return Ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		Ingredient = ingredient;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
	

}
