package context;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Recette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private boolean vegetarien;	
	private boolean vegan;	
	private int calorie;	
	private LocalDate debutSaison;	
	private LocalDate finSaison;
	private String commentaires;
	private int notes;
	private LocalTime tempsDeCuisine;
	private Boolean isValid;
	
	public Recette() {
	}
	
	public Recette(boolean vegetarien, boolean vegan, int calorie, LocalDate debutSaison, LocalDate finSaison,
			String commentaires, int notes, LocalTime tempsDeCuisine, Boolean isValid) {
		super();
		this.vegetarien = vegetarien;
		this.vegan = vegan;
		this.calorie = calorie;
		this.debutSaison = debutSaison;
		this.finSaison = finSaison;
		this.commentaires = commentaires;
		this.notes = notes;
		this.tempsDeCuisine = tempsDeCuisine;
		this.isValid = isValid;
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

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public LocalDate getDebutSaison() {
		return debutSaison;
	}

	public void setDebutSaison(LocalDate debutSaison) {
		this.debutSaison = debutSaison;
	}

	public LocalDate getFinSaison() {
		return finSaison;
	}

	public void setFinSaison(LocalDate finSaison) {
		this.finSaison = finSaison;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public int getNotes() {
		return notes;
	}

	public void setNotes(int notes) {
		this.notes = notes;
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
	public String toString() {
		return "Recette [id=" + id + ", vegetarien=" + vegetarien + ", vegan=" + vegan + ", calorie=" + calorie
				+ ", debutSaison=" + debutSaison + ", finSaison=" + finSaison + ", commentaires=" + commentaires
				+ ", notes=" + notes + ", tempsDeCuisine=" + tempsDeCuisine + ", isValid=" + isValid + "]";
	}


	

	
	
	
	
	
	
	
	
}
