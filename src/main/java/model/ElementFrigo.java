package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
