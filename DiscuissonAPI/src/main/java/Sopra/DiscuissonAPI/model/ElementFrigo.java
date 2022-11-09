package Sopra.DiscuissonAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElementFrigo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int quantite;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Ingredient ingredient;
	
	public ElementFrigo() {}

	public ElementFrigo(Integer id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public ElementFrigo(int quantite) {
		super();
		this.quantite = quantite;
	}

	public Integer getId() {
		return id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "ElementFrigo [id=" + id + ", quantite=" + quantite + "]";
	}
}
