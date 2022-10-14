package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String sujet;
	private String text;
	private LocalDate dateMessageDate;
	
	
	public Message() {}


	public Message(Integer id, String sujet, String text, LocalDate dateMessageDate) {
		this.id = id;
		this.sujet = sujet;
		this.text = text;
		this.dateMessageDate = dateMessageDate;
	}

	public Message(String sujet, String text, LocalDate dateMessageDate) {
		super();
		this.sujet = sujet;
		this.text = text;
		this.dateMessageDate = dateMessageDate;
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


	@Override
	public String toString() {
		return "Message [id=" + id + ", sujet=" + sujet + ", text=" + text + ", dateMessageDate=" + dateMessageDate
				+ "]";
	}
	
	
	
	
	
}
