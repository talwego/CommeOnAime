package Sopra.DiscuissonAPI.model;

import java.time.LocalTime;
import java.util.ArrayList;
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
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private Integer id;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private String name;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private boolean vegetarien;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private boolean vegan;

	@OneToMany(mappedBy = "recette")
	@JsonView(JsonViews.RecetteWithInstructionAndIngredient.class)
	private List<RecetteIngredient> recetteIngredients;

	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private int calorie;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private int debutSaison; // 1 = Janvier, 2 = Fevrier, 3 = Mars...
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private int finSaison; // 1 = Janvier, 2 = Fevrier, 3 = Mars...
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private String commentaires;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private double note;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private int nombreVotant;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private int nombrePersonne; // la recette est prevu pour XX personnes
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private LocalTime tempsDeCuisine;
	@JsonView({ JsonViews.Common.class, JsonViews.RecetteWithInstructionAndIngredient.class })
	private Boolean isValid;

	@OneToMany(mappedBy = "recette")
	@JsonView(JsonViews.RecetteWithInstructionAndIngredient.class)
	private List<InstructionRecette> instructionRecettes;

	private transient List<Ingredient> ingredients;

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Recette() {
	}

	public Recette(String name, int nombrePersonne, String commentaires, double note, int nombreVotant,
			LocalTime tempsDeCuisine, Boolean isValid) {
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

	public void setListeIngredient() {
		ingredients = new ArrayList<>();
		List<RecetteIngredient> obj1 = recetteIngredients;
		for (int j = 0; j < obj1.size(); j++) {
			ingredients.add(obj1.get(j).getIngredient());
		}
	}

	public void setRegimeRecette() {
		int i = 0;
		int size = ingredients.size();
		boolean boolean1 = true;
		while (boolean1 && i < size) {
			if (!ingredients.get(i).isVegetarien()) {
				boolean1 = false;
			}
			i++;
		}

		setVegetarien(boolean1);

		i = 0;
		boolean1 = true;
		while (boolean1 && i < size) {
			if (!ingredients.get(i).isVegan()) {
				boolean1 = false;
			}
			i++;
		}

		setVegan(boolean1);
		setDate();
	}

	public void setDate() {
		int debut = 1;
		int fin = 24;
		List<Integer> obj1a = new ArrayList<>();
		List<Integer> obj1b = new ArrayList<>();
		int size = ingredients.size();
		for (int j = 0; j < size; j++) {
			obj1a.add((ingredients.get(j)).getDateDebutRecolte());
			obj1b.add((ingredients.get(j)).getDateFinRecolte());
			if (obj1a.get(j) > obj1b.get(j)) {
				obj1b.set(j, obj1b.get(j) + 12);
			}
		}
		int i = 0;
		while (i < size) {
			if (((obj1a.get(i) - obj1b.get(i)) < 11) && ((obj1a.get(i) - obj1b.get(i)) > -11)) {
				if (obj1a.get(i) > debut) {
					debut = obj1a.get(i);
				}
				if (obj1b.get(i) < fin) {
					fin = obj1b.get(i);
				}
				if (debut > fin) {
					i = size + 12;
				}
			}
			i++;
		}
		if (fin > 12) {
			fin -= 12;
		}
		setDebutSaison(debut);
		setFinSaison(fin);
	}
	
	
	public void setCalorieAvecListeIngredient() {
		int caloriee = 0;
		for(int i=0; i<ingredients.size();i++) {
			caloriee += ingredients.get(i).getCalorie() * recetteIngredients.get(i).getQuantite()/100;
		}
		setCalorie(Math.round(caloriee/nombrePersonne));
	}
}