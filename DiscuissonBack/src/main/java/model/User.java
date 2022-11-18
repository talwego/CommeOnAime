package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="utilisateur")
public class User extends Compte{

	
	
	private Genre genre;
	private Integer age;
	private double taille;
	private double poids;
	private boolean compteVIP;
	private boolean vegetarien;
	private boolean vegan;
	private ActivitePhysique activitePhysique;
	
	@OneToMany(mappedBy="user")
	private List<Message> messages = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<ElementFrigo> elementFrigos;
	
	public User() {
		super();
	}
	
	public User(Integer id, String login, String password) {
		super(id, login, password);
	}


	public ActivitePhysique getActivitePhysique() {
		return activitePhysique;
	}

	public void setActivitePhysique(ActivitePhysique activitePhysique) {
		this.activitePhysique = activitePhysique;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [ genre=" + genre + ", age=" + age + ", taille=" + taille + ", poids="
				+ poids + ", compteVIP=" + compteVIP + ", vegetarien=" + vegetarien + ", vegan=" + vegan + ", messages="
				+ messages + "]";
	}



	
	
}
