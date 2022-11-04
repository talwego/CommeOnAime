package model;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Produit;

@Entity
public class Recette {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	@NotBlank
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	@JsonView(JsonViews.Common.class)
	@Column(name = "vegetarien", length = 30, nullable = true)
	private boolean vegetarien;
	@JsonView(JsonViews.Common.class)
	@Column(name = "vegan", length = 30, nullable = true)
	private boolean vegan;
	
	@OneToMany(mappedBy="recette")
	private List<RecetteIngredient> recetteIngredients;
	
	private int calorie;	
	private int debutSaison;	 //1 = Janvier, 2 = Fevrier, 3 = Mars...
	private int finSaison; //1 = Janvier, 2 = Fevrier, 3 = Mars...
	private String commentaires;
	private int note;
	private LocalTime tempsDeCuisine;
	private Boolean isValid;
	
	public Recette() {
	}

	public Recette(String name, boolean vegetarien, boolean vegan, int calorie, int debutSaison, int finSaison,
			String commentaires, int note, LocalTime tempsDeCuisine, Boolean isValid) {
		super();
		this.name = name;
		this.vegetarien = vegetarien;
		this.vegan = vegan;
		this.calorie = calorie;
		this.debutSaison = debutSaison;
		this.finSaison = finSaison;
		this.commentaires = commentaires;
		this.note = note;
		this.tempsDeCuisine = tempsDeCuisine;
		this.isValid = isValid;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public List<RecetteIngredient> getRecetteIngredients() {
		return recetteIngredients;
	}


	public void setRecetteIngredients(List<RecetteIngredient> recetteIngredients) {
		this.recetteIngredients = recetteIngredients;
	}


	public int getCalorie() {
		return calorie;
	}


	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}


	public int getDebutSaison() {
		return debutSaison;
	}


	public void setDebutSaison(int debutSaison) {
		this.debutSaison = debutSaison;
	}


	public int getFinSaison() {
		return finSaison;
	}


	public void setFinSaison(int finSaison) {
		this.finSaison = finSaison;
	}


	public String getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}


	public int getNote() {
		return note;
	}


	public void setNote(int note) {
		this.note = note;
	}


	public LocalTime getTempsDeCuisine() {
		return tempsDeCuisine;
	}


	public void setTempsDeCuisine(LocalTime tempsDeCuisine) {
		this.tempsDeCuisine = tempsDeCuisine;
	}


	public Boolean getIsValid() {
		return isValid;
	}


	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Recette [id=" + id + ", name=" + name + ", vegetarien=" + vegetarien + ", vegan=" + vegan + ", calorie="
				+ calorie + ", debutSaison=" + debutSaison + ", finSaison=" + finSaison + ", commentaires="
				+ commentaires + ", note=" + note + ", tempsDeCuisine=" + tempsDeCuisine + ", isValid=" + isValid + "]";
	}
	
	
}