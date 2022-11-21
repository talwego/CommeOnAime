package Sopra.DiscuissonAPI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name="utilisateur")
public class User extends Compte{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonView(JsonViews.Common.class)
	private Genre genre;
	@JsonView(JsonViews.Common.class)
	private Integer age;
	@JsonView(JsonViews.Common.class)
	private double taille;
	@JsonView(JsonViews.Common.class)
	private double poids;
	@JsonView(JsonViews.Common.class)
	private boolean compteVIP;
	@JsonView(JsonViews.Common.class)
	private boolean vegetarien;
	@JsonView(JsonViews.Common.class)
	private boolean vegan;
	@JsonView(JsonViews.Common.class)
	private ActivitePhysique activitePhysique;
	
	@OneToMany(mappedBy="user")
	private List<Message> messages = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<ElementFrigo> elementFrigos;
	
	public User() {
		super();
	}
	
	public User(String login, String password) {
		super(login, password);
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
