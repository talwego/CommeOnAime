package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String sujet;
	private String text;
	private LocalDate dateMessageDate;
	
	@ManyToOne
	@JoinColumn(name="id_nutritionnist",nullable = false)
	private Nutritionist nutritionist;
	
	@ManyToOne
	@JoinColumn(name="id_user",nullable = false)
	private User user;
	
	
	public Message() {}


	public Message(Integer id, String sujet, String text, LocalDate dateMessageDate, Nutritionist nutritionist,
			User user) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.text = text;
		this.dateMessageDate = dateMessageDate;
		this.nutritionist = nutritionist;
		this.user = user;
	}


	public Message(String sujet, String text, LocalDate dateMessageDate, Nutritionist nutritionist, User user) {
		super();
		this.sujet = sujet;
		this.text = text;
		this.dateMessageDate = dateMessageDate;
		this.nutritionist = nutritionist;
		this.user = user;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public LocalDate getDateMessageDate() {
		return dateMessageDate;
	}


	public void setDateMessageDate(LocalDate dateMessageDate) {
		this.dateMessageDate = dateMessageDate;
	}

	

	public Nutritionist getNutritionist() {
		return nutritionist;
	}


	public void setNutritionist(Nutritionist nutritionist) {
		this.nutritionist = nutritionist;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", sujet=" + sujet + ", text=" + text + ", dateMessageDate=" + dateMessageDate
				+ ", nutritionist=" + nutritionist + ", user=" + user + "]";
	}
	
	
	
	
	
}
