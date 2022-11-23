package Sopra.DiscuissonAPI.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({JsonViews.Common.class,JsonViews.Message.class})
	private Integer id;
	@JsonView({JsonViews.Common.class,JsonViews.Message.class})
	private String text;
	@ManyToOne
	@JoinColumn(name = "id_envoyeur", nullable = false)
	@JsonView({JsonViews.Common.class,JsonViews.Message.class})
	private Compte envoyeur;

	@ManyToOne
	@JoinColumn(name = "id_recepteur", nullable = false)
	@JsonView({JsonViews.Common.class,JsonViews.Message.class})
	private Compte recepteur;

	public Message() {
	}

	

	public Message(Integer id, String text, Compte envoyeur, Compte recepteur) {
		super();
		this.id = id;
		this.text = text;
		this.envoyeur = envoyeur;
		this.recepteur = recepteur;
	}



	public Message(String text, Compte envoyeur, Compte recepteur) {
		super();
		this.text = text;
		this.envoyeur = envoyeur;
		this.recepteur = recepteur;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	public Compte getEnvoyeur() {
		return envoyeur;
	}



	public void setEnvoyeur(Compte envoyeur) {
		this.envoyeur = envoyeur;
	}



	public Compte getRecepteur() {
		return recepteur;
	}



	public void setRecepteur(Compte recepteur) {
		this.recepteur = recepteur;
	}



	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", envoyeur=" + envoyeur + ", recepteur=" + recepteur + "]";
	}

	



}
