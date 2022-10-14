package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class User extends Compte{

	@Column(length = 30,nullable = false)
	private String pseudo;
	
	private Integer age;
	private double taille;
	private double poids;
	private boolean compteVIP;
	private boolean vegetarien;
	private boolean vegan;
	
	public User() {
		super();
	}
	
	public User(Integer id, String login, String password) {
		super(id, login, password);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public boolean isCompteVIP() {
		return compteVIP;
	}

	public void setCompteVIP(boolean compteVIP) {
		this.compteVIP = compteVIP;
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
		return "User [pseudo=" + pseudo + ", age=" + age + ", taille=" + taille + ", poids=" + poids + ", compteVIP="
				+ compteVIP + ", vegetarien=" + vegetarien + ", vegan=" + vegan + "]";
	}
	
	
	
}
