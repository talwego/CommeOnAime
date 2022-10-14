package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int calorie;
	
	private LocalDate dateDebutRecolte;
	
	private LocalDate dateFinRecolteDate;
		
	private boolean vegetarien;
	
	private boolean vegan;
	
	public Ingredient() {}

	
	
	
	public Ingredient(int calorie, LocalDate dateDebutRecolte, LocalDate dateFinRecolteDate, boolean vegetarien,
			boolean vegan) {
		super();
		this.calorie = calorie;
		this.dateDebutRecolte = dateDebutRecolte;
		this.dateFinRecolteDate = dateFinRecolteDate;
		this.vegetarien = vegetarien;
		this.vegan = vegan;
	}


	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public LocalDate getDateDebutRecolte() {
		return dateDebutRecolte;
	}

	public void setDateDebutRecolte(LocalDate dateDebutRecolte) {
		this.dateDebutRecolte = dateDebutRecolte;
	}

	public LocalDate getDateFinRecolteDate() {
		return dateFinRecolteDate;
	}
	
	public void setDateFinRecolteDate(LocalDate dateFinRecolteDate) {
		this.dateFinRecolteDate = dateFinRecolteDate;
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




	@Override
	public String toString() {
		return "Ingredient [calorie=" + calorie + ", dateDebutRecolte=" + dateDebutRecolte + ", dateFinRecolteDate="
				+ dateFinRecolteDate + ", vegetarien=" + vegetarien + ", vegan=" + vegan + "]";
	}
	
	

}
