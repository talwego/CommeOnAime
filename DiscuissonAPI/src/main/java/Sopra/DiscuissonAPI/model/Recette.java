package Sopra.DiscuissonAPI.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Recette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String name;
	@JsonView(JsonViews.Common.class)
	private boolean vegetarien;
	@JsonView(JsonViews.Common.class)
	private boolean vegan;
	
	@OneToMany(mappedBy="recette")
	private List<RecetteIngredient> recetteIngredients;
	
	@JsonView(JsonViews.Common.class)
	private int calorie;	
	@JsonView(JsonViews.Common.class)
	private int debutSaison;	 // 1 = Janvier, 2 = Fevrier, 3 = Mars...
	@JsonView(JsonViews.Common.class)
	private int finSaison; // 1 = Janvier, 2 = Fevrier, 3 = Mars...
	@JsonView(JsonViews.Common.class)
	private String commentaires;
	@JsonView(JsonViews.Common.class)
	private double note;
	@JsonView(JsonViews.Common.class)
	private int nombreVotant;
	@JsonView(JsonViews.Common.class)
	private int nombrePersonne; // la recette est prevu pour XX personnes
	@JsonView(JsonViews.Common.class)
	private LocalTime tempsDeCuisine;
	@JsonView(JsonViews.Common.class)
	private Boolean isValid;
	
	@OneToMany(mappedBy="recette")
	private List<InstructionRecette> instructionRecettes;
	
	public Recette() {
	}

	public Recette(String name, int nombrePersonne, String commentaires, double note, int nombreVotant, LocalTime tempsDeCuisine,
			Boolean isValid) {
		this.name = name;
		this.nombrePersonne = nombrePersonne;
		this.commentaires = commentaires;
		this.note = note;
		this.nombreVotant = nombreVotant;
		this.tempsDeCuisine = tempsDeCuisine;
		this.isValid = isValid;
		this.debutSaison = 1;
		this.finSaison = 12;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public int getNombreVotant() {
		return nombreVotant;
	}

	public void setNombreVotant(int nombreVotant) {
		this.nombreVotant = nombreVotant;
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

	public List<InstructionRecette> getInstructionRecettes() {
		return instructionRecettes;
	}

	public void setInstructionRecettes(List<InstructionRecette> instructionRecettes) {
		this.instructionRecettes = instructionRecettes;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
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
		Recette other = (Recette) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Recette [id=" + id + ", name=" + name + ", vegetarien=" + vegetarien + ", vegan=" + vegan + ", calorie="
				+ calorie + ", debutSaison=" + debutSaison + ", finSaison=" + finSaison + ", commentaires="
				+ commentaires + ", note=" + note + ", nombreVotant=" + nombreVotant + ", nombrePersonne="
				+ nombrePersonne + ", tempsDeCuisine=" + tempsDeCuisine + ", isValid=" + isValid + "]";
	}

	
}